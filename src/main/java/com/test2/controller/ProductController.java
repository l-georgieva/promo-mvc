package com.test2.controller;


import com.test2.models.bindingModels.product.ProductBindingModel;
import com.test2.service.GroceryStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {



    private final GroceryStoreService groceryStoreService;

    @Autowired
    public ProductController(GroceryStoreService groceryStoreService) {
        this.groceryStoreService = groceryStoreService;
      //  this.productService = productService;
    }

    // @ModelAttribute(name = "mutations")
    // public List<String> getMutations(){
    //  List<String> mutationList = new ArrayList<>();
    //  Mutation[] mutations = Mutation.values();
    //   for (Mutation mutation : mutations) {
    //     mutationList.add(mutation.toString());
    //  }

    //  return mutationList;
    // }

    //  @ModelAttribute(name = "categories")
    // public List<String> getMagnitude(){
    List<String> categoryList = new ArrayList<>();
    // Category[] categories = Category.class;
    // for (Category category : categories) {
    //  categoryList.add(category.toString());
    // }

    // return categoryList;
    // }

    @ModelAttribute(name = "groceryStores")
     public List<String> getGroceryStores(){
    return this.groceryStoreService.getGroceryStores();
    }


    @GetMapping("/products")
    public String getAddProduct(@ModelAttribute ProductBindingModel productBindingModel){
        return "add-products";
    }

    @PostMapping("/products")
    public String addProduct(@Valid @ModelAttribute ProductBindingModel productBindingModel, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "add-products";
        }



        return "redirect:/";
    }
}
