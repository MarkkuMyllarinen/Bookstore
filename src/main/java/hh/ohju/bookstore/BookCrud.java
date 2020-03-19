package hh.ohju.bookstore;

import hh.ohju.bookstore.Control.BookRepository;
import hh.ohju.bookstore.Control.CategoryRepository;
import hh.ohju.bookstore.Control.UserRepository;
import hh.ohju.bookstore.Model.Book;
import hh.ohju.bookstore.Model.Category;
import hh.ohju.bookstore.Model.User;
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
    public CommandLineRunner bookDemo(BookRepository bookRepository, UserRepository userRepository, CategoryRepository categoryRepository){
        return (args) -> {
            log.info("Tallennetaan muutama kirja");
            bookRepository.save(new Book("Testi", "kirja", "on", 199.2, 1994,new Category("Elämänkerta")));

            userRepository.save(new User("admin", "$2y$10$m3hlAf2d7B.BPUv9TuLn.ulsKh5OSoDq6Fge3ePiukNsdtRdT24yu", "admin@bookstore.com", "ADMIN"));
            userRepository.save(new User("user", "$2y$10$cGDhPoZ1.wRgr9u2zUJqduFnktXcM7FKxEnDaRg/0Q.99YmSubKka", "admin@bookstore.com", "USER"));

            log.info("fetch all books");
            for (User user: userRepository.findAll()){
                log.info(user.toString());
            }
            for (Book book: bookRepository.findAll()){
                log.info(book.toString());
            }
        };
    }
}
