package by.mironenko.testTask.controller;

import by.mironenko.testTask.dto.ProductDto;
import by.mironenko.testTask.dto.PurchasesDto;
import by.mironenko.testTask.service.ProductService;
import by.mironenko.testTask.service.PurchasesService;
import by.mironenko.testTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping()
public class MainController {
    @Autowired
    ProductService productService;

    @Autowired
    PurchasesService purchasesService;

    @Autowired
    UserService userService;

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

    @RequestMapping(value = "/update/{id}")
    public ModelAndView updateProduct(@PathVariable(name = "id") String id) {
        ModelAndView model = new ModelAndView("updatePage");
        ProductDto updatedDto = productService.getById(Long.parseLong(id));
        model.addObject("product", updatedDto);
        productService.deleteById(Long.parseLong(id));
        return model;
    }

    @RequestMapping(value = "/update")
    public ModelAndView update(ModelAndView modelAndView,
                               @RequestParam("name") String name,
                               @RequestParam("price") String price,
                               @RequestParam("category") String category) {
        modelAndView.setViewName("admin");
        ProductDto updatedProduct = new ProductDto(name, Double.parseDouble(price), category);
        productService.save(updatedProduct);
        modelAndView.addObject("listProduct", productService.getAll());
        return modelAndView;
    }

    @RequestMapping(value = "/addToBucket/{id}")
    public ModelAndView addToBucket(@PathVariable(name = "id") String id) {
        ModelAndView model = new ModelAndView("user");
        purchasesService.save(new PurchasesDto(userService.getById(1L).getId(), Long.parseLong(id)));
        List<ProductDto> list = productService.getAll();
        model.addObject("listProduct", list);
        return model;
    }

    @RequestMapping(value = "/openBucket")
    public ModelAndView openBucket() {
        ModelAndView model = new ModelAndView("bucket");
        List<PurchasesDto> list = purchasesService.getAll();
        List<String> names = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String currentProductName = productService.getById(list.get(i).getProductId()).getName();
            names.add(currentProductName);
        }
        model.addObject("purchasesList", names);
        return model;
    }
}
