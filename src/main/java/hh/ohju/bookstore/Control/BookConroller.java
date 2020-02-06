package hh.ohju.bookstore.Control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookConroller {
    @RequestMapping(value = "/index")
    public String getIndex(Model model) {
        return "index";
    }
}

