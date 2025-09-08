package com.lavanyaSpringBootProject.AOP_project.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    String id;
    private String name;
    private String level;

    public Account() {
    }

    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Account{" +
                ", name='" + name + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
