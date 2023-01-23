package com.study.rland.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
// @Table(name = "COMMENT")
public class Comment {
    
    @Id
    private int id;
    private String content;
    private Date regDate;
    private int menuId;

    // @JsonBackReference
    // @ManyToOne
    // @JoinColumn(name = "menu_id")
    // private Menu menu;

}
