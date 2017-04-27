package com.test2.repository;

import com.test2.entities.GroceryStore;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface GroceryStoreRepository extends CrudRepository<GroceryStore,Long> {
    @Query(value = "SELECT g.name FROM GroceryStore AS g")
    List<String> getGroceryStoreNames();

    Set<GroceryStore> getGroceryStores();

    Set<GroceryStore> getGroceryStores(String[] groceryStores);
}
