package com.monzoni.melodim_project.model.entity;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(GenreEntity.class)
public class GenreEntity_ {

    public static volatile SingularAttribute<GenreEntity, Integer> id;

    public static volatile SingularAttribute<GenreEntity, String> name;

}
