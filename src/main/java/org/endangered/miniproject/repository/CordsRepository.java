package org.endangered.miniproject.repository;

import org.endangered.miniproject.model.Cords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CordsRepository extends JpaRepository<Cords, Long> {
    // You can define custom query methods here if needed, like finding coordinates by values
}

