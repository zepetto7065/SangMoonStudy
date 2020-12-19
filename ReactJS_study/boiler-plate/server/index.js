const express = require('express')
const app = express()
const port = 5000
const{User} = require('./models/User');
const{auth} = require('./middleware/auth');

const bodyParser = require('body-parser');
const cookieParser = require('cookie-parser');
const config = require('./config/key');



//application/x-www-form-urlencoded
app.use(bodyParser.urlencoded({extended:true})); 

//application/json
app.use(bodyParser.json());

// mongoose 기본 설정
const mongoose = require('mongoose')

mongoose.connect(config.mongoURI ,{
  useNewUrlParser:true, useUnifiedTopology:true, useCreateIndex:true,useFindAndModify:false
}).then(() => console.log('MongoDB Connected...'))
  .catch(err => console.log(err))



app.get('/', (req, res) => res.send('Hello World! 안녕하세요!!!'))

app.post('/api/users/register', (req, res) => { 
  //회원 가입할 떄 , 필요한 정보들을 클라이언트에서 가져오면 
  //그것들을 DB에 넣어준다.
  const user = new User(req.body)

  user.save((err,userInfo)=>{
    if(err) return res.json({ success:false, err});
    return res.status(200).json({
      success:true
    });
  })
})

app.post('/api/users/login',(req, res) => {
  //요청된 이메일을 데이터베이스에서 있는지 찾는다.
  User.findOne({ email: req.body.email }, (err, user) => {
    if(!user){
      return res.json({
        loginSuccess: false,
        message: "제공된 이메일에 해당하는 유저가 없습니다."
      })
    }
    //요청된 이메일이 데이터베이스에 있다면, 비밀번호가 맞는 비밀번호인지 확인
    user.comparePassword(req.body.password, (err, isMatch)=>{ 
      
      if(!isMatch)  return res.json({loginSuccess: false, message : "비밀번호가 틀렸습니다." })
      //비밀번호가 맞다면 Token 생성
      user.generateToken((err, user) => {
        if(err) return res.status(400).send(err);

        //토큰을 저장한다. 어디에? 쿠키, 로컬 스토리지 .. 지금은 쿠키
        res.cookie("x_auth", user.token)
        .status(200)
        .json({loginSuccess: true, userId:user._id})

      })
    })
  })
})

app.get('/api/users/auth', auth , (req, res) => {
  // 여기까지 미들웨어를 통과해 왔다는 얘기는 authentication 이 true
  res.status(200).json({
    _id : req.user._id, //auth.js에서 보내주었기 때문에 가능
    isAdmin : req.user.role === 0 ? false : trues,
    isAuth : true, 
    email : req.user.email,
    name : req.user.name,
    lastname : req.user.lastname,
    role : req.user.role,
    image : req.user.image    
  })
})

app.get('/api/users/logout', auth, (req, res) => {
  User.findOneAndUpdate({ _id : req.user._id},
    {token : ""}, //token 삭제
    (err, user)=> {
      if(err) return res.json({success:false, err});
      return res.status(200).send({success : true})
    })
})




app.listen(port, () => console.log(`Example app listening on port ${port}!`))