
package com.example.apiweb.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public abstract class BaseController<DTO, ID> {

    @GetMapping
    public abstract ResponseEntity<Page<DTO>> list(Pageable pageable);

    @GetMapping("/{id}")
    public abstract ResponseEntity<DTO> get(@PathVariable ID id);

    @PostMapping
    public abstract ResponseEntity<DTO> create(@RequestBody DTO dto);

    @PutMapping("/{id}")
    public abstract ResponseEntity<DTO> update(@PathVariable ID id, @RequestBody DTO dto);

    @DeleteMapping("/{id}")
    public abstract ResponseEntity<Void> delete(@PathVariable ID id);
}
