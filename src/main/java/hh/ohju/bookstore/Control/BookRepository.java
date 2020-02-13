package hh.ohju.bookstore.Control;

import hh.ohju.bookstore.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
