
package com.example.apiweb.web.mapper;

import com.example.core.model.Author;
import com.example.apiweb.web.dto.AuthorDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public AuthorDto toDto(Author a) {
        if (a == null) return null;
        AuthorDto d = new AuthorDto();
        d.setId(a.getId());
        d.setName(a.getName());
        return d;
    }

    public Author toEntity(AuthorDto d) {
        if (d == null) return null;
        Author a = new Author();
        a.setName(d.getName());
        return a;
    }
}
