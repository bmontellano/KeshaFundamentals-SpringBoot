package com.pluralsight.keshafundamentals.service;

import java.util.List;
import java.util.Optional;

import com.pluralsight.keshafundamentals.entity.Application;
import com.pluralsight.keshafundamentals.exception.ApplicationNotFoundException;
import com.pluralsight.keshafundamentals.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public List<Application> listApplications() {
        return (List<Application>) applicationRepository.findAll();
    }

    @Override
    public Application findApplication(long id){
        Optional<Application> optionalApplication = applicationRepository.findById(id);
        
        if(optionalApplication.isPresent()){
            return optionalApplication.get();
        } else {
            throw new ApplicationNotFoundException("Application Not Found");
        }
    }

}
