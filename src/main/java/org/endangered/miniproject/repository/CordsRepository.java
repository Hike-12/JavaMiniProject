package org.endangered.miniproject.repository;

import org.endangered.miniproject.model.Cords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CordsRepository extends JpaRepository<Cords, Long> {

    // Query to find cords by animal id
    @Query("SELECT c FROM Cords c WHERE c.animal_id = :animal_id")
    List<Cords> findByAnimalId(Long animal_id);
}
