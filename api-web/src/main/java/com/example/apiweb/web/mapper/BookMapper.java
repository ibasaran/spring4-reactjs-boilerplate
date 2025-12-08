
package com.example.apiweb.web.mapper;

import com.example.apiweb.web.dto.BookDto;
import com.example.core.model.Book;
import com.example.core.model.Author;
import com.example.core.model.Library;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDto toDto(Book b) {
        if (b == null) return null;
        BookDto d = new BookDto();
        d.setId(b.getId());
        d.setTitle(b.getTitle());
        if (b.getAuthor() != null) d.setAuthorId(b.getAuthor().getId());
        if (b.getLibrary() != null) d.setLibraryId(b.getLibrary().getId());
        return d;
    }

    public Book toEntity(BookDto d, Author author, Library library) {
        if (d == null) return null;
        Book b = new Book();
        b.setTitle(d.getTitle());
        b.setAuthor(author);
        b.setLibrary(library);
        return b;
    }
}
