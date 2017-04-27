package com.test2.models.bindingModels.product;


import com.test2.entities.Brand;
import com.test2.entities.Category;
import com.test2.entities.Promotion;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProductBindingModel {



    @NotBlank(message = "Name cannot be blank")
    @Size(min = 5, max = 30, message = "Invalid Name size")
    private String name;

    @NotBlank(message = "Cannot be vlank")
    @Size(min = 5, max = 100, message = "Invalid Desc size")
    private String description;

    @Range(min = 0, max =100)
    private Double price;

   @NotNull(message = "Should have a mutation")
    private Category category;

    @NotNull(message = "Should have a mutation")
  private Brand brand;

   @NotNull(message = "Should have a mutation")
    private Promotion promotion;

    @NotEmpty(message = "Should pick stores")


    private String[] groceryStores;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public String[] getGroceryStores() {
        return groceryStores;
    }

    public void setGroceryStores(String[] groceryStores) {
        this.groceryStores = groceryStores;
    }
}
