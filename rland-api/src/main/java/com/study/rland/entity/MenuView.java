package com.study.rland.entity;


import java.util.List;

import org.hibernate.annotations.Immutable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Immutable
@Entity
public class MenuView {
    
    @Id
    private int id;

    private String name;
    private int price;

    // nutrition fields
    private int calories;
    private int saturatedFat;

    @Transient
    private List<Comment> comment;
}
