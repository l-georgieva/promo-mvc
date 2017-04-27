package com.test2.serviceImpl;

import com.test2.entities.GroceryStore;
import com.test2.entities.Product;
import com.test2.models.bindingModels.product.ProductBindingModel;
import com.test2.repository.GroceryStoreRepository;
import com.test2.repository.ProductRepository;
import com.test2.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final GroceryStoreRepository groceryStoreRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, GroceryStoreRepository groceryStoreRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.groceryStoreRepository = groceryStoreRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void create(ProductBindingModel productBindingModel) {
        Product product = this.modelMapper.map(productBindingModel, Product.class);
        Set<GroceryStore> groceryStores = this.groceryStoreRepository.getGroceryStores(productBindingModel.getGroceryStores());
        product.setGroceryStores(groceryStores);
        this.productRepository.save(product);
    }

    @Transactional
    @Override
    public String getGeoData() {
        List<Product> products = this.productRepository.getAllProducts();
        StringBuilder geoJson = new StringBuilder();
        String header = "{\n" +
                "    \"type\": \"FeatureCollection\",\n" +
                "    \"features\": [\n";
        String footer = "]\n" +
                "}\n";
        geoJson.append(header);
        StringJoiner joiner = new StringJoiner(",");
        for (Product product : products) {
            String color = "#f00";
            // int magnitude = 0;
            // switch (virus.getMagnitude()){
            //    case LOW:
            //       magnitude = 4;
            //       break;
            //   case MEDIUM:
            //       magnitude = 5;
            //       break;
            //   case HIGH:
            //       magnitude = 6;
            //       break;
            // }

            for (GroceryStore groceryStore : product.getGroceryStores()) {
                String body = String.format("{\n" +
                        "        \"type\": \"Feature\",\n" +
                        "        \"properties\": {\n" +
                        "            \"mag\": %d,\n" +
                        "            \"color\": \"%s\"\n" +
                        "        },\n" +
                        "        \"geometry\": {\n" +
                        "            \"type\": \"Point\",\n" +
                        "            \"coordinates\": [\n" +
                        "                %f,\n" +
                        "                %f\n" +
                        "            ]\n" +
                        "        }\n" +
                        "    }\n", color, groceryStore.getLatitude(), groceryStore.getLongitude());
                joiner.add(body);
            }
        }

        geoJson.append(joiner);
        geoJson.append(footer);

        return geoJson.toString();
    }
}
