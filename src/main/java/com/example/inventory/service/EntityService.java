package com.example.inventory.service;

import java.util.List;
import com.example.inventory.entity.Entity;

public interface EntityService{
    List<Entity> getAll();
    Entity save(Entity entity);
    Entity getById(String id);
    Entity update(String id, Entity entity);
    void delete(String id);
}
