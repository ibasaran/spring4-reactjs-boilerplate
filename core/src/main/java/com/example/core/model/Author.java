
package com.example.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity {

    @Column(nullable = false)
    private String name;

    public Author() {}

    public Author(String name) { this.name = name; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
