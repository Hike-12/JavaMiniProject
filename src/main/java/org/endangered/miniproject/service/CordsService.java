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

    // Get all cords
    public List<Cords> getAllCords() {
        return cordsRepository.findAll();
    }

    // Get a specific cord by id
//    public Cords getCordsById(Long id) {
//        return cordsRepository.findById(id).orElse(null);
//    }

    // Get cords by animal id (this will return a list of cords)
    public List<Cords> getCordsByAnimalId(Long animal_id) {
        return cordsRepository.findByAnimalId(animal_id);
    }

    // Save or update a cord
    public Cords saveCords(Cords cords) {
        return cordsRepository.save(cords);
    }

    // Delete a cord by id
    public void deleteCords(Long id) {
        cordsRepository.deleteById(id);
    }
}
