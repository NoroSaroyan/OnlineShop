package ru.gb.controller;


import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gb.entity.Cart;
import ru.gb.entity.Product;
import ru.gb.repository.CartRepository;
import ru.gb.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping()
public class CartController {
//
//    @Qualifier("cartRepository")
//    private CartRepository cartRepository;
//
//    private ProductRepository productRepository;
//
//    @Autowired
//    public CartController(CartRepository cartRepository, ProductRepository productRepository) {
//        this.cartRepository = cartRepository;
//        this.productRepository = productRepository;
//    }
//
//    @GetMapping("/carts")
//    public String findAll(@NotNull Model model) {
//        List<Cart> carts = new ArrayList<>();
//        cartRepository.findAll().forEach(carts::add);
//        model.addAttribute("carts", carts);
//        return "carts";
//    }
//
//    @GetMapping("carts/{id}")
//    public Cart findById(@PathVariable Long id) {
//        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException());
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public String delete(@PathVariable Long id) {
//        cartRepository.deleteById(id);
//        return "redirect:/carts";
//    }
//
////    @PostMapping("/cartToAdd")
////    public String cartToAdd(@ModelAttribute("cartForm")
////                            @PathVariable long countProduct, Product product, BindingResult bindingResult, Model model) {
////
////        if (bindingResult.hasErrors()) {
////            return "products";
////        }
////        productRepository.saveProductToCart(countProduct, product.getId());
////        return "redirect:/cards";
////    }
//
//
//    @GetMapping("/cartToAdd")
//    public String edit(@ModelAttribute("cartForm") Model model) {
//        model.addAttribute("cartForm", new Cart());
//        return "cartToAdd";
//    }
}