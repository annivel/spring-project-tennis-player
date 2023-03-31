package io.datajek.springdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;

import java.util.Date;

/**
 * The Player class is a bean and the data coming from the Player table in H2 will be mapped to this class.
 */
@Entity
@NamedQuery(name = "get_all_players", query = "select p from Player p")
public class Player {
    /**
     * @Id is used to indicate the primary key
     * @GeneratedValue is used to automatically generate ID valued
     * */
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String nationality;
    private Date dateBirth;
    private int titles;

    public Player() {
    }

    public Player(int id, String name, String nationality, Date dateBirth, int titles) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.dateBirth = dateBirth;
        this.titles = titles;
    }

    public Player(String name, String nationality, Date dateBirth, int titles) {
        super(); // super() is used to call the constructor of the superclass (parent class)
        this.name = name;
        this.nationality = nationality;
        this.dateBirth = dateBirth;
        this.titles = titles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", dateBirth=" + dateBirth +
                ", titles=" + titles +
                '}';
    }
}
