package com.monzoni.melodim_project.repository.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "album_")
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_", nullable = false)
    private Integer id;
    @Column(name = "name_")
    private String name;
    @Column(name = "description_")
    private String description;
    @Column(name = "release_date_")
    private LocalDate releaseDate;
}
