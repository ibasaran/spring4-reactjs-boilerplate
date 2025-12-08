
package com.example.apiweb.web;

import com.example.apiweb.web.dto.BookDto;
import com.example.apiweb.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BookController extends BaseController<BookDto, UUID> {

    private final BookService service;

    public BookController(BookService service) { this.service = service; }

    @GetMapping
    @Override
    public ResponseEntity<Page<BookDto>> list(Pageable pageable) {
        return ResponseEntity.ok(service.list(pageable));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<BookDto> get(@PathVariable UUID id) {
        BookDto d = service.get(id);
        return d==null ? ResponseEntity.notFound().build() : ResponseEntity.ok(d);
    }

    @PostMapping
    @Override
    public ResponseEntity<BookDto> create(@RequestBody BookDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<BookDto> update(@PathVariable UUID id, @RequestBody BookDto dto) {
        BookDto d = service.update(id, dto);
        return d==null ? ResponseEntity.notFound().build() : ResponseEntity.ok(d);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
