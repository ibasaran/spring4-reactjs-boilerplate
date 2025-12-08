
package com.example.apiweb.web;

import com.example.apiweb.web.dto.AuthorDto;
import com.example.apiweb.service.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController extends BaseController<AuthorDto, UUID> {

    private final AuthorService service;

    public AuthorController(AuthorService service) { this.service = service; }

    @GetMapping
    @Override
    public ResponseEntity<Page<AuthorDto>> list(Pageable pageable) {
        return ResponseEntity.ok(service.list(pageable));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<AuthorDto> get(@PathVariable UUID id) {
        AuthorDto d = service.get(id);
        return d==null ? ResponseEntity.notFound().build() : ResponseEntity.ok(d);
    }

    @PostMapping
    @Override
    public ResponseEntity<AuthorDto> create(@RequestBody AuthorDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<AuthorDto> update(@PathVariable UUID id, @RequestBody AuthorDto dto) {
        AuthorDto d = service.update(id, dto);
        return d==null ? ResponseEntity.notFound().build() : ResponseEntity.ok(d);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
