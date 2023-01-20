package com.study.rland.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Table
 * @Column은 형식이 맞지 않을 경우에 사용한다.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder // 오버로드 생성자
@Entity
@Table(name = "NUTRITION_FACTS")
public class NutritionFacts {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int calories;
    @Column(name="SATURATED_FAT")
    private int saturatedFat;
    // private int menuId;

    // @JsonBackReference
    // @OneToOne
    // @JoinColumn(name = "id")
    // private Menu menu;

}
