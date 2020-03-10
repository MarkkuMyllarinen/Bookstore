package hh.ohju.bookstore.Control;


import hh.ohju.bookstore.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;


    @RequestMapping(value =  "/categorylist", method = RequestMethod.GET)
    public String getCategoryList(Model model){
        List<Category> categories = (List<Category>) categoryRepository.findAll();

        model.addAttribute("categories",categories);
        return "categorylist";
    }

    @RequestMapping(value = "/newcategory",method = RequestMethod.GET)
    public String newCategory(Model model){
        model.addAttribute("category", new Category());
        return "categoryform";
    }

    @RequestMapping(value = "/newcategory",method = RequestMethod.POST)
    public String saveNewCategory(Category category){
        categoryRepository.save(category);
        return "redirect:/categorylist";
    }


}
