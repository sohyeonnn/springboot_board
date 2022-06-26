package com.build_ash.boardservice.entity;

import lombok.Data;

import javax.persistence.*;

//domain - entity - Board

@Entity
@Data
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    @Column(nullable = false)
    private int viewCount = 0;

    //private String filename;
    //private String filepath;
}