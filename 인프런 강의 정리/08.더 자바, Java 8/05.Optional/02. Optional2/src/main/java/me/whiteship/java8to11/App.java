package me.whiteship.java8to11;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", true));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst(); //있을수도 없을 수도 있으니 , optional로 나오게 된다.

        boolean present = optional.isPresent();
        System.out.println(present);

//        OnlineClass onlineClass = optional.get();
//        System.out.println(onlineClass.getTitle());

        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        //있거나 없더라도 새로운 클래스를 만들어라 : orElse
//        OnlineClass onlineClass = optional.orElse(createNewJpaClass());
//        System.out.println(onlineClass.getTitle());

        //동적으로 작업을 추가 해야할때? : orElseGet
//        OnlineClass onlineClass = optional.orElseGet(App::createNewJpaClass);
//        System.out.println(onlineClass.getTitle());

        //없을 때, exception
//        OnlineClass onlineClass = optional.orElseThrow(() -> {
//            return new IllegalArgumentException();
//        });
//        System.out.println(onlineClass.getTitle());

        //있다는 가정하에
//        Optional<OnlineClass> onlineClass = optional
//                .filter(oc -> !oc.isClosed());
//        System.out.println(onlineClass.isEmpty());

        //stream과 같이 map
        Optional<Integer> integer = optional.map(OnlineClass::getId);
        System.out.println(integer.isPresent());

        //2번 껍질을 까주는 flatmap
        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);
        Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress2 = progress1.orElseThrow();


    }

    private static OnlineClass createNewJpaClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "New Class", false);
    }
}
