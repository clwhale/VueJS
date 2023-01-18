package com.study.rland.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private int id;
    private int calories;
    @Column(name="SATURATED_FAT")
    private int saturatedFat;
    private int menuId;


}
