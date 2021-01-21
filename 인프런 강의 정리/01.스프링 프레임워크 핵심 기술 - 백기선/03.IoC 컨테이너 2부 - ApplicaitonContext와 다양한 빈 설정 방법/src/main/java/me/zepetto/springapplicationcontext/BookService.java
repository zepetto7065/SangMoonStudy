package me.zepetto.springapplicationcontext;

import org.springframework.beans.factory.annotation.Autowired;

public class BookService {

    BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

}
