package com.example.week5day1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Info {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String age;
    private String email;


    @OneToOne
    @MapsId
    @JsonIgnore
//    @Cascade(CascadeType.ALL)
    private Customer customer;


}
