package ru.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gb.entity.Product;
import ru.gb.repository.ProductRepository;
import ru.gb.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
//
//    private final ProductService productService;
//
//    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }
//
//
//    @GetMapping()
//    public String findAll(Model model) {
//
//        List<Product> products = new ArrayList<>();
//        productService.findAll().forEach(products::add);
//
//        model.addAttribute("products", products);
//        return "templates/product/products";
//
//    }
//
//
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable Long id, Model model) {
//        Optional<Product> product = productService.findById(id);
//        if (product.isPresent()) {
//            model.addAttribute("products", product);
//            return "edit";
//        } else {
//            return "/edit/{id}";
//        }
//    }
//
////    @PreAuthorize("hasAuthority({'ROLE_ADMIN', 'ROLE_MANAGER'})")
////    @PostMapping("/update")
////    public String update(@RequestParam Long id,
////                         @RequestParam(value = "/edit", required = false) boolean edit) {
////        productService.(id);
////        return "redirect:/products/upd";
////    }
//
//    @PreAuthorize("hasAuthority({'ROLE_ADMIN', 'ROLE_MANAGER'})")
//    @PostMapping
//    public String save(@RequestParam Product product, BindingResult result) {
//        if (result.hasErrors()) {
//            return "product-add";
//        }
//        productService.save(product);
//        return "redirect:/product/products";
//    }
//
//
////    @GetMapping("/form")
////    public String saveForm(Product product) {
////        return "product-add";
////    }
//
////    @GetMapping("/{id}")
////    public Optional<Product> findById(@PathVariable Long id) {
////        return productService.findById(id.longValue());
////    }
//
////    @PreAuthorize("hasAuthority({'ROLE_ADMIN', 'ROLE_MANAGER'})")
////    @DeleteMapping("/delete/{id}")
////    public String delete(@PathVariable Long id) {
////        productService.deleteById(id);
////        return "redirect:/";
////    }

}