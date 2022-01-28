package com.pluralsight.keshafundamentals.service;

import java.util.List;

import com.pluralsight.keshafundamentals.entity.Release;
import com.pluralsight.keshafundamentals.repository.ReleaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReleaseServiceImpl implements ReleaseService {
    @Autowired
    private ReleaseRepository releaseRepository;

    @Override
    public List<Release> listReleases() {
        return (List <Release>) releaseRepository.findAll();
    }

}
