package com.pluralsight.keshafundamentals.repository;


import com.pluralsight.keshafundamentals.entity.Release;

import org.springframework.data.repository.CrudRepository;

public interface ReleaseRepository extends CrudRepository<Release, Long> {
}