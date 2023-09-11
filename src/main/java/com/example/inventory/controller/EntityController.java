package com.example.inventory.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.inventory.entity.Entity;
import com.example.inventory.service.EntityService;

@RestController
public class EntityController {

    @Autowired
    EntityService entityService;

    @PostMapping("/save")
    public ResponseEntity<Entity> save(@RequestBody Entity entity){
        return ResponseEntity.ok(entityService.save(entity));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Entity> getById(@PathVariable String id){
        return ResponseEntity.ok(entityService.getById(id));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Entity>> getAll(){
        return ResponseEntity.ok(entityService.getAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Entity> update(@PathVariable String id, @RequestBody Entity entity){
        return ResponseEntity.ok(entityService.update(id, entity));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        entityService.delete(id);
    }
}
