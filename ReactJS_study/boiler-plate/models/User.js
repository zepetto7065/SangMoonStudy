const mongoose = require('mongoose');


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

const User = mongoose.model('User', userShema)
module.exports = {User} //다른 곳에도 쓸 수 있도록

