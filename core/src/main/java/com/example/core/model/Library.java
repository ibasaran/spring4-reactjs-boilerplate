
package com.example.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "libraries")
public class Library extends BaseEntity {

    @Column(nullable = false)
    private String name;

    public Library() {}

    public Library(String name) { this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
