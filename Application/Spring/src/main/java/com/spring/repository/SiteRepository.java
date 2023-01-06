package com.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.spring.entity.Site;

@Repository
public interface SiteRepository  extends CrudRepository <Site, Long> 
{
    Site findByName(String name);

    List<Site> findAll();

    Site findFirstByOrderByIdAsc();


}
