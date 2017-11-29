package fr.emse.majeureinfo.springbootintro.model;


import javax.persistence.*;
import java.util.Set;

@Entity
@SuppressWarnings("serial")
public class Building {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;


    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Room> rooms;

    public Building() {
    }

    public Building(String name) {
        this.name = name;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
