package com.csc340.animaldemo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AnimalService.java
 * Centralizes data access to the animals Database.
 */
@Service
public class AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    /**
     * Fetch all animals.
     *
     * @return the list of all animals.
     */
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    /**
     * Fetch a unique animal by ID.
     *
     * @param animalId the unique animal id.
     * @return a unique Animal object.
     */
    public Animal getAnimalById(int animalId) {
        return animalRepository.findById(animalId).orElse(null);
    }

    /**
     * Fetch all animals that match the species.
     *
     * @param species the search key.
     * @return the list of matching animals.
     */
    public List<Animal> getAnimalsBySpecies(String species) {
        return animalRepository.findBySpecies(species);
    }

    /**
     * Fetch animals by name containing the search string.
     *
     * @param name the search key.
     * @return a list of Animal objects whose name contains the search key.
     */
    public List<Animal> getAnimalsByName(String name) {
        return animalRepository.findByNameContainingIgnoreCase(name);
    }

    /**
     * Add a new animal to the database.
     *
     * @param animal the new animal to add.
     */
    public void addNewAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    /**
     * Update an existing animal.
     *
     * @param animalId the unique animal Id.
     * @param animal   the new animal details.
     */
    public void updateAnimal(int animalId, Animal animal) {
        Animal existing = getAnimalById(animalId);
        existing.setName(animal.getName());
        existing.setScientificName(animal.getScientificName());
        existing.setSpecies(animal.getSpecies());
        existing.setHabitat(animal.getHabitat());
        existing.setDescription(animal.getDescription());
        animalRepository.save(existing);
    }

    /**
     * Delete a unique animal.
     *
     * @param animalId the unique animal Id.
     */
    public void deleteAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }
}
