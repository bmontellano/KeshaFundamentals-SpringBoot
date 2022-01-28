package com.pluralsight.keshafundamentals.service;

import java.util.List;
import com.pluralsight.keshafundamentals.entity.Application;

public interface ApplicationService {
    List<Application> listApplications();
    Application findApplication(long id);
}


