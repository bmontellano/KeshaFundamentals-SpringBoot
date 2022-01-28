package com.pluralsight.keshafundamentals.repository;

import com.pluralsight.keshafundamentals.entity.Application;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Application, Long> {
}
