package com.test2.serviceImpl;

import com.test2.repository.GroceryStoreRepository;
import com.test2.service.GroceryStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryStoreServiceImpl implements GroceryStoreService{

    @Autowired
    private GroceryStoreRepository groceryStoreRepository;




    @Override
    public List<String> getGroceryStores() {
        return this.groceryStoreRepository.getGroceryStoreNames();
    }
}
