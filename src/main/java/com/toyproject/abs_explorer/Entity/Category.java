package com.toyproject.abs_explorer.Entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;

@Data
@Entity
@Table(name="category")
public class Category {

    @Id
    private String name;

    private String url;

    public Category() {}

    public Category(String name, String url) {
        this.name = name;
        this.url = url;
    }
}
