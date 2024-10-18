package org.endangered.miniproject.service;

import org.endangered.miniproject.model.Cords;
import org.endangered.miniproject.repository.CordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CordsService {

    private final CordsRepository cordsRepository;

    @Autowired
    public CordsService(CordsRepository cordsRepository) {
        this.cordsRepository = cordsRepository;
    }

    // Method to create a new Cords entry
    public Cords saveCords(Cords cords) {
        return cordsRepository.save(cords);
    }

    // Method to get all coordinates
    public List<Cords> getAllCords() {
        return cordsRepository.findAll();
    }

    // Method to get a specific Cords entry by ID
    public Optional<Cords> getCordsById(Long id) {
        return cordsRepository.findById(id);
    }

    // Method to update a Cords entry
    public Cords updateCords(Long id, Cords updatedCords) {
        return cordsRepository.findById(id)
                .map(existingCords -> {
                    existingCords.setX(updatedCords.getX());
                    existingCords.setY(updatedCords.getY());
                    return cordsRepository.save(existingCords);
                }).orElseThrow(() -> new RuntimeException("Cords not found with id: " + id));
    }

    // Method to delete a Cords entry by ID
    public void deleteCords(Long id) {
        cordsRepository.deleteById(id);
    }
}

