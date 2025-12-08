
package com.example.apiweb.web;

import com.example.apiweb.web.dto.LibraryDto;
import com.example.persistence.repository.LibraryRepository;
import com.example.apiweb.web.mapper.AuthorMapper;
import com.example.apiweb.web.mapper.BookMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryController extends BaseController<LibraryDto, UUID> {

    private final LibraryRepository repo;

    public LibraryController(LibraryRepository repo) { this.repo = repo; }

    @GetMapping
    @Override
    public ResponseEntity<Page<LibraryDto>> list(Pageable pageable) {
        return ResponseEntity.ok(repo.findAll(pageable).map(l -> {
            LibraryDto d = new LibraryDto();
            d.setId(l.getId());
            d.setName(l.getName());
            return d;
        }));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<LibraryDto> get(@PathVariable UUID id) {
        return repo.findById(id).map(l -> {
            LibraryDto d = new LibraryDto(); d.setId(l.getId()); d.setName(l.getName()); return ResponseEntity.ok(d);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Override
    public ResponseEntity<LibraryDto> create(@RequestBody LibraryDto dto) {
        com.example.core.model.Library l = new com.example.core.model.Library(); l.setName(dto.getName());
        com.example.core.model.Library saved = repo.save(l);
        LibraryDto d = new LibraryDto(); d.setId(saved.getId()); d.setName(saved.getName());
        return ResponseEntity.ok(d);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<LibraryDto> update(@PathVariable UUID id, @RequestBody LibraryDto dto) {
        return repo.findById(id).map(existing -> {
            existing.setName(dto.getName());
            com.example.core.model.Library saved = repo.save(existing);
            LibraryDto d = new LibraryDto(); d.setId(saved.getId()); d.setName(saved.getName());
            return ResponseEntity.ok(d);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
