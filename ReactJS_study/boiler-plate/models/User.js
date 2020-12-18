const mongoose = require('mongoose');
//bcrypt 사용법은 git 참조
const bcrypt = require('bcrypt');
const saltRound = 10; //salt가 몇글자인지
var jwt = require('jsonwebtoken');

const userSchema = mongoose.Schema({

    name:{
        type:String,
        maxlength:50
    },
    email:{
        type:String,
        trim : true, //space 없애준다.
        unique : 1
    },
    password : {
        type: String,
        maxlength : 100
    },
    role : {
        type : Number,
        default : 0 
    },
    image : String,
    token : {
        type : String
    },
    tokenExp : {
        type : Number
    }
})

userSchema.pre('save' , function(next){

    var user = this; 

    if(user.isModified('password')){
        //비밀 번호를 암호화 시킨다.
        bcrypt.genSalt(saltRound, function(err, salt){
            if(err) return next(err);
            bcrypt.hash(user.password, salt, function(err, hash){
                if(err) return next(err)
                user.password = hash           
                next()
            })
        })    

    }else{
        next()
    }

});

userSchema.methods.comparePassword = function(plainPassword, cb){
    //plainPassword 1234567 암호화된 비밀번호   $2b$10$Eid6YUjC3eO9iUqZwT//p.7zhjQgX5Dgy6uuXrdCBexVbOR/5X8BK 같은지 체크
    bcrypt.compare(plainPassword, this.password, function(err, isMatch){
        if(err){
            return cb(err)
        } 
        else{
            cb(null, isMatch)
        }
            
    })
    
}

userSchema.methods.generateToken = function(cb){
    
    var user = this;
    //jsonWebToken 이용해서 token을 생성하기
    var token = jwt.sign(user._id.toHexString(), 'secretToken');

    // user._id + 'secretToken' = token
    user.token = token
    user.save(function(err, user){
        if(err) return cb(err)
        cb(null, user)
    })
}

userSchema.static.findByToken = function(token, cb){
    var user = this;
    
    //토큰을 decode 한다.
    jwt.verify(token, 'secretToken', function(err, decoded){
        //유저 아이디를 이용해서 유저를 찾은 다음에 
        //클라이언트에서 가져온 token과 db에 보관된 토큰이 일치하는지 확인
        user.findOne({"_id" : decoded , "token" : token} , function(err, user){
            if(err){
                return cb(err);
            }else{
                cb(null, user); 
            }
        })
    })
}

const User = mongoose.model('User', userSchema)
module.exports = {User} //다른 곳에도 쓸 수 있도록

