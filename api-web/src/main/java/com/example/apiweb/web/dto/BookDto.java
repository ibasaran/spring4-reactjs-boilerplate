
package com.example.apiweb.web.dto;

import java.util.UUID;

public class BookDto {
    private UUID id;
    private String title;
    private UUID authorId;
    private UUID libraryId;

    public BookDto() {}
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public UUID getAuthorId() { return authorId; }
    public void setAuthorId(UUID authorId) { this.authorId = authorId; }
    public UUID getLibraryId() { return libraryId; }
    public void setLibraryId(UUID libraryId) { this.libraryId = libraryId; }
}
