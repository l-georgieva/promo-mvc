package com.test2.serviceImpl;

import com.test2.repository.MarkerRepository;
import com.test2.service.MarkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkerServiceImpl implements MarkerService {

    @Autowired
    private MarkerRepository markerRepository;






    @Override
    public List<String> getMarkerAddresses() {
        return this.markerRepository.getMarkerAddresses();
    }
}


