package hh.ohju.bookstore.Control;

import hh.ohju.bookstore.Model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
