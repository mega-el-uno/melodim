package com.monzoni.melodim_project.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "artist_")
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_", nullable = false)
    private Integer id;
    @Column(name = "name_")
    private String name;
    @Column(name = "type_")
    private String type;
    @Column(name = "creation_date_")
    private LocalDate creationDate;
}
