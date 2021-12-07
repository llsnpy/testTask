package by.mironenko.testTask.controller;

import by.mironenko.testTask.dao.ProductDao;
import by.mironenko.testTask.dto.ProductDto;
import by.mironenko.testTask.entity.Product;
import by.mironenko.testTask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping()
public class MainController {
    @Autowired
    ProductService productService;

    @RequestMapping(value = "/admin", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ModelAndView getProductsForAdmin() {
        ModelAndView model = new ModelAndView("admin");
        List<ProductDto> list = productService.getAll();
        model.addObject("listProduct", list);
        return model;
    }

    @RequestMapping(value = "/user", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody ModelAndView getProductsForUser() {
        ModelAndView model = new ModelAndView("user");
        List<ProductDto> list = productService.getAll();
        model.addObject("listProduct", list);
        return model;
    }

    @GetMapping(value = "/delete/{id}")
    public ModelAndView deleteProductById(@PathVariable(name = "id") String id, Model model) {
        ModelAndView modeV = new ModelAndView("admAfterChanges");
        ProductDto product = productService.getById(Long.parseLong(id));
        productService.deleteById(Long.parseLong(id));
        model.addAttribute("listProduct", productService.getAll());
        return modeV;
    }
}
