const mongoose = require('mongoose');
//bcrypt 사용법은 git 참조
const bcrypt = require('bcrypt');
const saltRound = 10; //salt가 몇글자인지

const userShema = mongoose.Schema({

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
        maxlength : 50
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

userShema.pre('save' , function(next){

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

    }

});

const User = mongoose.model('User', userShema)
module.exports = {User} //다른 곳에도 쓸 수 있도록

