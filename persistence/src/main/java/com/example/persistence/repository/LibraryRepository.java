
package com.example.persistence.repository;

import com.example.core.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LibraryRepository extends JpaRepository<Library, UUID> {
}
