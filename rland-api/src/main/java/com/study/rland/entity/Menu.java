package com.study.rland.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
// @ToString
// @Getter
@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "name은 null값일 수 없습니다.")
    private String name;
    private int price;

    // @JsonManagedReference
    // @OneToOne(mappedBy = "menu")
    // @OneToOne
    // @JoinColumn(name = "id")
    // private NutritionFacts nutritionFacts;

    // @JsonManagedReference
    // @OneToMany(mappedBy = "menu")
    // private List<Comment> comments;

}
