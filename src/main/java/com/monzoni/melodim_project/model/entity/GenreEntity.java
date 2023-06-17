package com.monzoni.melodim_project.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "genre_")
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_", nullable = false)
    private Integer id;

    @Column(name = "name_")
    private String name;

}
