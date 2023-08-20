package com.example.week5day1.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String name;

    @OneToOne(cascade = CascadeType.DETACH,mappedBy = "customer")
    @PrimaryKeyJoinColumn
    private Info info;


}
