package hh.ohju.bookstore;

import hh.ohju.bookstore.Control.BookRepository;
import hh.ohju.bookstore.Control.CategoryRepository;
import hh.ohju.bookstore.Model.Book;
import hh.ohju.bookstore.Model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CategoryCrud {
    private static final Logger log = LoggerFactory.getLogger(CategoryCrud.class);

    @Bean
    public CommandLineRunner categoryDemo(CategoryRepository CategoryRepository){
        return (args) -> {
            log.info("Tallennetaan muutama kirja");
            CategoryRepository.save(new Category("Kauhu"));
            CategoryRepository.save(new Category("Fantasia"));
            CategoryRepository.save(new Category("Seikkailu"));
            CategoryRepository.save(new Category("Sci-fi"));
            CategoryRepository.save(new Category("Koulutus"));
            log.info("fetch all books");
            for (Category category: CategoryRepository.findAll()){
                log.info(category.toString());
            }
        };
    }
}
