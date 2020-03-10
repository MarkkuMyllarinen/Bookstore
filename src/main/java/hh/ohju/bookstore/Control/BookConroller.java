package hh.ohju.bookstore.Control;

import hh.ohju.bookstore.BookCrud;
import hh.ohju.bookstore.Model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookConroller {

    private static final Logger log = LoggerFactory.getLogger(BookConroller.class);


    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String getIndex(Model model) {
        List<Book> books = (List<Book>) bookRepository.findAll();

        model.addAttribute("books", books);


        return "booklist";
    }


    @RequestMapping(value = "/newbook", method = RequestMethod.GET)
    public String getNewBookForm(Model model) {
        model.addAttribute("book", new Book()); // "tyhjä" auto-olio
        model.addAttribute("categories", categoryRepository.findAll());
        return "bookform";
    }

    @RequestMapping(value = "/newbook", method = RequestMethod.POST)
    public String saveBook(@ModelAttribute Book book) {
        // talletetaan yhden auton tiedot tietokantaan
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId) {
        bookRepository.deleteById(bookId);
        return "redirect:/booklist";
    }

    @RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
    public String getEditBookForm(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book",bookRepository.findById(bookId));
        model.addAttribute("categories", categoryRepository.findAll());
        log.info(model.toString());

        return "editbook";
    }
    @RequestMapping(value = "/editbook/", method = RequestMethod.POST)
    public String editBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }



}

