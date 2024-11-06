//package org.endangered.miniproject.service;
//
//import org.endangered.miniproject.model.Cords;
//import org.endangered.miniproject.repository.CordsRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.Optional;
//
//@Service
//public class CordsService {
//
//    @Autowired
//    private CordsRepository cordsRepository;
//
//    public Cords getCordsByAnimalId(Long animalId) {
//        Optional<Cords> cords = cordsRepository.findByAnimal_id(animalId);
//        return cords.orElse(null);  // Returns null if not found
//    }
//}
