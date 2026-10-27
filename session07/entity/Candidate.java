
package com.example.session07.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "candidates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String fullName;
    private String email;
    private Integer age;
    private Integer yearsOfExperience;
    private String address;
    private String bio;
}
