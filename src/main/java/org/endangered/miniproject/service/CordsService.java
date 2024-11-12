package org.endangered.miniproject.service;

import org.endangered.miniproject.model.Cords;
import org.endangered.miniproject.repository.CordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CordsService {

    @Autowired
    private CordsRepository cordsRepository;

    public List<Cords> getAllCords() {
        Thread thread = new Thread(() -> {
            List<Cords> cords = cordsRepository.findAll();
            System.out.println("Fetched all cords in thread: " + Thread.currentThread().getName());
        });
        thread.start();
        return cordsRepository.findAll();
    }

    public List<Cords> getCordsByAnimalId(Long animal_id) {
        Thread thread = new Thread(() -> {
            List<Cords> cords = cordsRepository.findByAnimalId(animal_id);
            System.out.println("Fetched cords for animal ID: " + animal_id + " in thread: " + Thread.currentThread().getName());
        });
        thread.start();
        return cordsRepository.findByAnimalId(animal_id);
    }

    public Cords saveCords(Cords cords) {
        Thread thread = new Thread(() -> {
            Cords savedCords = cordsRepository.save(cords);
            System.out.println("Saved cords in thread: " + Thread.currentThread().getName());
        });
        thread.start();
        return cordsRepository.save(cords);
    }

    public void deleteCords(Long id) {
        Thread thread = new Thread(() -> {
            cordsRepository.deleteById(id);
            System.out.println("Deleted cords with ID: " + id + " in thread: " + Thread.currentThread().getName());
        });
        thread.start();
    }
}
