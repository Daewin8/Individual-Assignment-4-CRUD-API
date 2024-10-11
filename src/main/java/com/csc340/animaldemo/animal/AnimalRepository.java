package com.csc340.animaldemo.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions.
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer>{
    List<Animal> findBySpecies(String species);
    List<Animal> findByNameContainingIgnoreCase(String name);

}
