//package com.example.manageprojectemployeeretro.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "address")
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Setter
//public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//    private String street;
//    private int houseNumber;
//    private String city;
//    private int zipCode;
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Person person;
//}
