package me.zepetto.demospring51;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository @Primary
public class YourBookRepository implements BookRepository{
}
