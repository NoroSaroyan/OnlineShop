package ru.gb.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import ru.gb.entity.Category;
import ru.gb.entity.Product;
import ru.gb.repository.CategoryRepository;
import ru.gb.repository.ProductRepository;
import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
//    ProductRepository productRepository;
//    CategoryRepository categoryRepository;
//
//    @Autowired
//    public void setProductRepository(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @Autowired
//    public void setCategoryRepository(CategoryRepository categoryRepository){
//        this.categoryRepository = categoryRepository;
//    }
//
//    public Optional<Product> findById(Long id) {
//
//        Optional<Product> product = productRepository.findById(id);
//        if (product.isPresent()) {
//            return product;
//        }else{
//            throw new RuntimeException();
//        }
//
//    }
//
//    public Iterable<Product> findAll() {
//        return productRepository.findAll();
//    }
//
//    public void save(Product product) {
//
//    }
//
//    public void deleteById(Long id) {
//    }
}
