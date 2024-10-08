package org.endangered.miniproject.repository;

import org.endangered.miniproject.model.EndangeredAnimals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndangeredAnimalRepository extends JpaRepository<EndangeredAnimals, String> {
}
