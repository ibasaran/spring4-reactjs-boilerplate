
package com.example.apiweb.service;

import com.example.apiweb.web.dto.AuthorDto;
import com.example.apiweb.web.mapper.AuthorMapper;
import com.example.persistence.repository.AuthorRepository;
import com.example.core.model.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthorService {

    private final AuthorRepository repository;
    private final AuthorMapper mapper;

    public AuthorService(AuthorRepository repository, AuthorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Page<AuthorDto> list(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);
    }

    public AuthorDto get(UUID id) {
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    public AuthorDto create(AuthorDto dto) {
        Author a = mapper.toEntity(dto);
        Author saved = repository.save(a);
        return mapper.toDto(saved);
    }

    public AuthorDto update(UUID id, AuthorDto dto) {
        return repository.findById(id).map(existing -> {
            existing.setName(dto.getName());
            return mapper.toDto(repository.save(existing));
        }).orElse(null);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
