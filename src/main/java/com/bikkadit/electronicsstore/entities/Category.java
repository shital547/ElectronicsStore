package com.bikkadit.electronicsstore.entities;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long categoryId;

    @Column(name="category_title", length = 60,nullable = false)
    private String title;

    @Column(name="category_desc", length = 1000)
    private String description;

    private String coverImage;

}

