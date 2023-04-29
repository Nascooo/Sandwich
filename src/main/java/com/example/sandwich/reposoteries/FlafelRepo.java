package com.example.sandwich.reposoteries;

import com.example.sandwich.entities.Flafel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "flafel", path = "flafel")
public interface FlafelRepo extends JpaRepository<Flafel, Integer> {
    Flafel findByName(@Param("name") String name);
}
