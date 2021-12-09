package by.mironenko.testTask.controller;

import by.mironenko.testTask.dao.ProductDao;
import by.mironenko.testTask.dto.ProductDto;
import by.mironenko.testTask.entity.Product;
import by.mironenko.testTask.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
        productService.deleteById(Long.parseLong(id));
        model.addAttribute("listProduct", productService.getAll());
        return modeV;
    }

    @RequestMapping(value = "/createNewProduct", method = RequestMethod.POST)
    public ModelAndView createNewProduct(ModelAndView modelAndView,
                                         @RequestParam("name") String name,
                                         @RequestParam("price") String price,
                                         @RequestParam("category") String category) {
        modelAndView.setViewName("creaetedPage");
        ProductDto createdProduct = new ProductDto(name, Double.parseDouble(price), category);
        productService.save(createdProduct);
        modelAndView.addObject("productDto", createdProduct);
        return modelAndView;
    }
}
