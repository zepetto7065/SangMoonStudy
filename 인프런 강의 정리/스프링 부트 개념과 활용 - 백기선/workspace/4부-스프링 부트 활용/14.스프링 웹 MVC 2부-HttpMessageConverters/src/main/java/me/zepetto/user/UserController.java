package me.zepetto.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/hello")
    public String hello(){
        return "hello sangmoon";
    }

    //요청이 JSON 요청이라면 Content-Type에서 Json message converter가 user로 converting
    //User라는 객체를 return 할 때, composition type일때에는 Json message converter가 사용된다.
    //@RestController가 있으면 @ResponseBody 생략이 가능하다. ( 사실상 생략이 되어 표기되어 있다고 볼 수 있다. )
//    @PostMapping("/users/create")
//    public User create(@RequestBody User user){
//        return null;
//    }

    @PostMapping("/users/create")
    public User create(@RequestBody User user){
        return user;
    }

}
