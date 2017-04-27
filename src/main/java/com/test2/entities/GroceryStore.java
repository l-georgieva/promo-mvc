package com.test2.entities;

import javax.persistence.*;

@Entity
@Table(name = "grocery_stores")
public class GroceryStore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float latitude;
    private Float longitude;
    //private Set<Product> products;
    public GroceryStore() {
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

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
// @ManyToMany(mappedBy = "grocery_stores",cascade = CascadeType.ALL)
   // public Set<Product> getProducts() {
   //     return products;
    //}

  //  public void setProducts(Set<Product> products) {
     //   this.products = products;
   // }
}
