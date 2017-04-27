package com.test2.controller;


import com.test2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @Autowired

    private ProductService productService;

    @GetMapping("/map")
    public String getMapPage(Model model){
       String geoJson = this.productService.getGeoData();
        System.out.println(geoJson);
        model.addAttribute("geoJson", geoJson);
        return "map";
    }
}
