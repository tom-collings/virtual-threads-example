package com.example.client;

import org.springframework.data.repository.CrudRepository;

public interface CountingsRepository extends CrudRepository<CountEntity, Integer> {
    
}
