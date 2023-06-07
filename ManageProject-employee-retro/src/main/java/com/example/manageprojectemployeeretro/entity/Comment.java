package com.example.manageprojectemployeeretro.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

import java.time.LocalDate;



@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "content")
    private String content;

    @Column(name = "rating")
    private double rating;


    @Column(name = "date")
    private LocalDate date;

    @Override
    public String toString() {
        return "Comment [id = " + id + "]";
    }
}
