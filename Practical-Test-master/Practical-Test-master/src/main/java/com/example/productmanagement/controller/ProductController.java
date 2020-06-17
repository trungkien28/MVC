package com.example.productmanagement.controller;

import com.example.productmanagement.entity.Product;
import com.example.productmanagement.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @RequestMapping("/product-add")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product-add";
    }

    @RequestMapping(value = "/product-save", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        productRepository.save(product);

        return "redirect:/products";
    }

    @RequestMapping("/products")
    public String index(Model model) {
        List<Product> products = (List<Product>) productRepository.findAll();
        model.addAttribute("products", products);

        return "product";
    }
}
