package org.endangered.miniproject.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


import java.util.List;

@Entity
public class EndangeredAnimals {

    @Id
    @GeneratedValue // Uncomment this if you want the ID to be auto-generated
    private Long id; // Use Long for generated ID
    private String species; // Species name
    private String habitat; // Natural habitat
    private String color; // Color description

    private String img_url;



    private String food_habits;
    private String behaviors;

    private int approxCount; // Approximate number of animals left
    private String lastSeen; // Last seen date
    private String measuresForSurvival; // Measures to improve survival
    private String migrationPatternImage; // URL or path to migration pattern image


    private String observations;

    // Default constructor (required for JPA)
    public EndangeredAnimals() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBehaviors() {
        return behaviors;
    }

    public void setBehaviors(String behaviors) {
        this.behaviors = behaviors;
    }

    public int getApproxCount() {
        return approxCount;
    }

    public void setApproxCount(int approxCount) {
        this.approxCount = approxCount;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getMeasuresForSurvival() {
        return measuresForSurvival;
    }

    public void setMeasuresForSurvival(String measuresForSurvival) {
        this.measuresForSurvival = measuresForSurvival;
    }

    public String getMigrationPatternImage() {
        return migrationPatternImage;
    }

    public void setMigrationPatternImage(String migrationPatternImage) {
        this.migrationPatternImage = migrationPatternImage;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
    public String getFood_habits() {
        return food_habits;
    }

    public void setFood_habits(String food_habits) {
        this.food_habits = food_habits;
    }
    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
    @Override
    public String toString() {
        return "EndangeredAnimals{" +
                "id=" + id +
                ", species='" + species + '\'' +
                ", habitat='" + habitat + '\'' +
                ", color='" + color + '\'' +
                ", img_url='" + img_url + '\'' +
                ", food_habits='" + food_habits + '\'' +
                ", behaviors='" + behaviors + '\'' +
                ", approxCount=" + approxCount +
                ", lastSeen='" + lastSeen + '\'' +
                ", measuresForSurvival='" + measuresForSurvival + '\'' +
                ", migrationPatternImage='" + migrationPatternImage + '\'' +
                ", observations='" + observations + '\'' +
                '}';
    }

}
