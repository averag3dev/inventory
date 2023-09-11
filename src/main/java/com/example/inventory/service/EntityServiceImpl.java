package com.example.inventory.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.example.inventory.entity.Entity;
import com.example.inventory.repository.EntityRepository;

@Service
public class EntityServiceImpl implements EntityService{
    
    @Autowired
    EntityRepository entityRepository;

    public List<Entity> getAll() {
        return (List<Entity>) entityRepository.findAll();
    }

    public Entity save(Entity entity) {
        return entityRepository.save(entity);
    }

    public Entity getById(String id) {
        return entityRepository.findById(id)
                             .orElseThrow(() -> new ResourceNotFoundException(id + " not found."));
    }

    public Entity update(String id, Entity entity) {
        entityRepository.findById(id)
                      .orElseThrow(() -> new ResourceNotFoundException(id + " not found."));
        entity.setId(id);
        return entityRepository.save(entity);
    }

    public void delete(String id) {
        entityRepository.findById(id)
                      .orElseThrow(() -> new ResourceNotFoundException(id + " not found."));
        entityRepository.deleteById(id);
    }
}
