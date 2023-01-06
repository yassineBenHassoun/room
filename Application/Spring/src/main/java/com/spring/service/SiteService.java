package com.spring.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.spring.entity.Site;
import com.spring.repository.SiteRepository;

@Service
public class SiteService 
{
    private SiteRepository siteRepository;
    
  
    public List<Site> allSites() {

        return siteRepository.findAll();
    }

    public Site getSiteByName (String name) {
        return siteRepository.findByName(name);
    }

}
