package com.csc340.animaldemo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */
@RestController
@RequestMapping("/animals")
public class AnimalController {
    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of Animal objects.
     */
    @GetMapping("/all")
    public List<Animal> getAllAnimals() {
        return service.getAllAnimals();
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/2
     *
     * @param animalId the unique Id for an Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public Animal getOneAnimal(@PathVariable int animalId) {
        return service.getAnimalById(animalId);
    }

    /**
     * Add a new Animal entry.
     * http://localhost:8080/animals/new --data '{ "name": "Blue Jay", "scientificName": "Cyanocitta cristata", "species": "Bird", "habitat": "Forest", "description": "A blue bird with a loud call." }'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public List<Animal> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return service.getAllAnimals();
    }

    /**
     * Update an existing Animal object.
     * http://localhost:8080/animals/update/2 --data '{ "name": "Updated Animal", "scientificName": "Updated Name", "species": "Mammal", "habitat": "Desert", "description": "Updated description." }'
     *
     * @param animalId the unique Animal Id.
     * @param animal   the new update Animal details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public Animal updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return service.getAnimalById(animalId);
    }

    /**
     * Delete an Animal object.
     * http://localhost:8080/animals/delete/2
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{animalId}")
    public List<Animal> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return service.getAllAnimals();
    }

    /**
     * Get all animals of a given class.
     * http://localhost:8080/animals/class?species=Bird
     *
     * @param species the search key.
     * @return a list of Animal objects matching the search key.
     */
    @GetMapping("/class")
    public List<Animal> getAnimalsBySpecies(@RequestParam(name = "species") String species) {
        return service.getAnimalsBySpecies(species);
    }

    /**
     * Get animals whose name contains a string.
     * http://localhost:8080/animals/search?name=blue
     *
     * @param name the search key.
     * @return a list of Animal objects whose name contains the search key.
     */
    @GetMapping("/search")
    public List<Animal> getAnimalsByName(@RequestParam(name = "name") String name) {
        return service.getAnimalsByName(name);
    }
}
