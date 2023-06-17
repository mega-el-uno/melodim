package com.monzoni.melodim_project.repository;

import com.monzoni.melodim_project.model.entity.ArtistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<ArtistEntity, Integer> {

}
