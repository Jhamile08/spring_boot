package com.web.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Entity tells to springboot than this class is an entity
@Entity
// Table permit set the table that will create the orm (hibernate)
@Table(name = "coder")
public class Coder {
    // @Id indicate that the attribute will be the primary key
    @Id
    // @Id indicate that the attribute will be generate with the stategy auto_increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String clan;
    private int age;

    public Coder() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Coder [id=" + id + ", name=" + name + ", clan=" + clan + ", age=" + age + "]";
    }
    
}

