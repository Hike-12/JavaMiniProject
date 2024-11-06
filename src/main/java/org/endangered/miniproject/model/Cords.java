package org.endangered.miniproject.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Cords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double x;
    private double y;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    private String species;

    public Long getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(Long animal_id) {
        this.animal_id = animal_id;
    }

    private Long animal_id;

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    private String lastSeen;

    @OneToMany(mappedBy = "cords", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EndangeredAnimals> endangeredAnimals; // Link to EndangeredAnimals

    // Default constructor
    public Cords() {
    }

    // Parameterized constructor
    public Cords(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public List<EndangeredAnimals> getEndangeredAnimals() {
        return endangeredAnimals;
    }

    public void setEndangeredAnimals(List<EndangeredAnimals> endangeredAnimals) {
        this.endangeredAnimals = endangeredAnimals;
    }

    @Override
    public String toString() {
        return "Cords{" +
                "id=" + id +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
