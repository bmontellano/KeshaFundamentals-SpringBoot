package com.pluralsight.keshafundamentals.service;

import com.pluralsight.keshafundamentals.entity.Application;
import com.pluralsight.keshafundamentals.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationRepository applicationRepository;

    @Override
    public Iterable<Application> listApplications() {
        return applicationRepository.findAll();
    }

}
