package me.zepetto.demobootweb;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

//스프링에서 제공하는 Formatter
@Component //SpringBoot의 경우 ,  Bean으로 등록이 되어있다면 스프링부트에서는 설정없이 알아서 등록을 해준다.
public class PersonFormatter implements Formatter<Person> {

    //문자 -> 객체
    @Override
    public Person parse(String s, Locale locale) throws ParseException {
        Person person = new Person();
        person.setName(s);
        return person;
    }

    //객체 -> 문자
    @Override
    public String print(Person person, Locale locale) {
        return person.toString();
    }
}
