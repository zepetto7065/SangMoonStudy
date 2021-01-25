package me.zepetto.demospring51;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
//@Profile("test")
@Profile("!Prod") //prod가 아니면 빈으로 등록 
public class TestBookRepository implements BookRepository {
}
