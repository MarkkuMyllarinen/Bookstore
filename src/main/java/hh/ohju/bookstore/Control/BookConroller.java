package hh.ohju.bookstore.Control;

import hh.ohju.bookstore.Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookConroller {

    @Autowired
    BookRepository bookRepository;

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String getIndex(Model model) {
        List<Book> books = (List<Book>) bookRepository.findAll();

        model.addAttribute("books", books);


        return "booklist";
    }
}

