package com.test2.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Double price;

    private byte[] image;

    // For sort.
    private Date createDate;

    //@Enumerated(EnumType.STRING)

    private Brand brand;
    // private Promotion promotion;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    @Column(name = "images", length = Integer.MAX_VALUE, nullable = true)
    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false)
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @ManyToMany()
    @JoinTable(name = "grocery_stores_products",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "grocery_store_id"))
    private Set<GroceryStore> groceryStores;

    public void setGroceryStores(Set<GroceryStore> groceryStores) {
        this.groceryStores = groceryStores;
    }


    @ManyToOne()
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;

    public Promotion getPromotion() {
        return promotion;
    }
    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Set<GroceryStore> getGroceryStores() {
        return groceryStores;
    }


    @ManyToOne()
    @JoinColumn(name = "category_id")

    private Category category;



    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}