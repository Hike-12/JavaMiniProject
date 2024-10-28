package org.endangered.miniproject.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class EndangeredAnimals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String species;
    private String habitat;
    private String color;
    private String img_url;
    private String food_habits;
    private String behaviors;
    private int approxCount;
    private String lastSeen;
    private String measuresForSurvival;
    private String migrationPatternImage;
    private String observations;

    @ManyToOne // Many EndangeredAnimals to One Cords
    @JoinColumn(name = "cords_id")
    private Cords cords;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSpecies() { return species; }
    public void setSpecies(String species) { this.species = species; }

    public Cords getCords() {
        return cords;
    }

    public void setCords(Cords cords) {
        this.cords = cords;
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

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getFood_habits() {
        return food_habits;
    }

    public void setFood_habits(String food_habits) {
        this.food_habits = food_habits;
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
                ", cords=" + cords + // Include cords in the toString() method
                '}';
    }
}
