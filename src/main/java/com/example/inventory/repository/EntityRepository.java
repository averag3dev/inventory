package com.example.inventory.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.inventory.entity.Entity;

@Repository
@EnableScan
public interface EntityRepository extends CrudRepository<Entity, String>{
}
