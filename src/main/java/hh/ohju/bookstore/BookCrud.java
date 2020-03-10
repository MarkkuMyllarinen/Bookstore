package hh.ohju.bookstore;

import hh.ohju.bookstore.Control.BookRepository;
import hh.ohju.bookstore.Model.Book;
import hh.ohju.bookstore.Model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BookCrud {
    private static final Logger log = LoggerFactory.getLogger(BookCrud.class);

    public static void main(String[] args) {
        SpringApplication.run(BookCrud.class, args);
    }

    @Bean
    public CommandLineRunner bookDemo(BookRepository bookRepository){
        return (args) -> {
            log.info("Tallennetaan muutama kirja");
            bookRepository.save(new Book("Testi", "kirja", "on", 199.2, 1994,new Category("Elämänkerta")));
            log.info("fetch all books");
            for (Book book: bookRepository.findAll()){
                log.info(book.toString());
            }
        };
    }
}
