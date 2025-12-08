
package com.example.apiweb.service;

import com.example.apiweb.web.dto.BookDto;
import com.example.apiweb.web.mapper.BookMapper;
import com.example.persistence.repository.BookRepository;
import com.example.persistence.repository.AuthorRepository;
import com.example.persistence.repository.LibraryRepository;
import com.example.core.model.Book;
import com.example.core.model.Author;
import com.example.core.model.Library;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookService {

    private final BookRepository bookRepo;
    private final AuthorRepository authorRepo;
    private final LibraryRepository libraryRepo;
    private final BookMapper mapper;

    public BookService(BookRepository bookRepo, AuthorRepository authorRepo, LibraryRepository libraryRepo, BookMapper mapper) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
        this.libraryRepo = libraryRepo;
        this.mapper = mapper;
    }

    public Page<BookDto> list(Pageable pageable) {
        return bookRepo.findAll(pageable).map(mapper::toDto);
    }

    public BookDto get(UUID id) {
        return bookRepo.findById(id).map(mapper::toDto).orElse(null);
    }

    public BookDto create(BookDto dto) {
        Author author = dto.getAuthorId() == null ? null : authorRepo.findById(dto.getAuthorId()).orElse(null);
        Library lib = dto.getLibraryId() == null ? null : libraryRepo.findById(dto.getLibraryId()).orElse(null);
        Book b = mapper.toEntity(dto, author, lib);
        Book saved = bookRepo.save(b);
        return mapper.toDto(saved);
    }

    public BookDto update(UUID id, BookDto dto) {
        return bookRepo.findById(id).map(existing -> {
            existing.setTitle(dto.getTitle());
            if (dto.getAuthorId()!=null) existing.setAuthor(authorRepo.findById(dto.getAuthorId()).orElse(null));
            if (dto.getLibraryId()!=null) existing.setLibrary(libraryRepo.findById(dto.getLibraryId()).orElse(null));
            return mapper.toDto(bookRepo.save(existing));
        }).orElse(null);
    }

    public void delete(UUID id) { bookRepo.deleteById(id); }
}
