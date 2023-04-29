package com.monzoni.melodim_project.repository;

import com.monzoni.melodim_project.repository.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer> {
}
