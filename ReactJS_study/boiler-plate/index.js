const express = require('express')
const app = express()
const port = 5000
const{User} = require('./models/User');
const bodyParser = require('body-parser');
const config = require('./config/key')



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

app.post('/register', (req, res) => { 
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



app.listen(port, () => console.log(`Example app listening on port ${port}!`))