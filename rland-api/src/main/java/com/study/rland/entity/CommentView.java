package com.study.rland.entity;

import java.sql.Date;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentView {
    
    @Id
    private int id;
    private String content;
    private Date regDate;
    private String menuName;
    private int menuPrice;

    // private Menu menu;
}
