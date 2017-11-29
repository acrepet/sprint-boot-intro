package fr.emse.majeureinfo.springbootintro.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@SuppressWarnings("serial")
@Table(name = "ROOM")
public class Room {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * The Light of a room
     */
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Light light;

    /**
     * The Noise of a room
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Noise noise;


    /**
     * The Building of a room
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Building building;

    @SuppressWarnings("unused")
    public Room() {
    }

    public Room(Light light, Noise noise, Building building) {
        this.light = light;
        this.noise = noise;
        this.building = building;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

    public Noise getNoise() {
        return noise;
    }

    public void setNoise(Noise noise) {
        this.noise = noise;
    }


    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }


    public void switchLight() {
        if (getLight().getStatus() == Status.ON) {
            getLight().setStatus(Status.OFF);
        } else {
            getLight().setStatus(Status.ON);
        }
    }


    public void switchRinger() {
        if (getNoise().getStatus() == Status.ON) {
            getNoise().setStatus(Status.OFF);
        } else {
            getNoise().setStatus(Status.ON);
        }
    }


}
