package org.endangered.miniproject.service;

import org.endangered.miniproject.model.EndangeredAnimals;
import org.endangered.miniproject.repository.EndangeredAnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EndangeredAnimalService {
    private final EndangeredAnimalRepository repository;

    @Autowired
    public EndangeredAnimalService(EndangeredAnimalRepository repository) {
        this.repository = repository;
    }

    public List<EndangeredAnimals> getAllAnimals() {
        return repository.findAll();
    }

    public EndangeredAnimals getAnimalById(String id) {
        return repository.findById(id).orElse(null);
    }

    public EndangeredAnimals saveAnimal(EndangeredAnimals animal) {
        return repository.save(animal);
    }
}

