package com.test2.service;

import com.test2.models.bindingModels.product.ProductBindingModel;

public interface ProductService {

    void create(ProductBindingModel productBindingModel);

    String getGeoData();
}
