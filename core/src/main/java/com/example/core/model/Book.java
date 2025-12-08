
package com.example.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book extends BaseEntity {

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    public Book() {}
    public Book(String title) { this.title = title; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }

    public Library getLibrary() { return library; }
    public void setLibrary(Library library) { this.library = library; }
}
