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
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<EndangeredAnimals> animals = repository.findAll();
                System.out.println("Fetched all animals in thread: " + Thread.currentThread().getName());
            }
        });
        thread.start();

        return repository.findAll();
    }

    public EndangeredAnimals getAnimalById(String id) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                EndangeredAnimals animal = repository.findById(id).orElse(null);
                System.out.println("Fetched animal with ID: " + id + " in thread: " + Thread.currentThread().getName());
            }
        };
        thread.start();

        return repository.findById(id).orElse(null);
    }
}
