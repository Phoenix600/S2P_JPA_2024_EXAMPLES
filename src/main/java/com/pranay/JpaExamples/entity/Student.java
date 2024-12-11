package com.pranay.JpaExamples.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
@Table(
        name = "tbl_student",
        schema = "springcore",
        uniqueConstraints = @UniqueConstraint(name = "email_unique",columnNames = "email")
)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false,length = 100)
    private String firstName;

    @Column(nullable = true,length = 100)
    private String middleName;

    @Column(nullable = false,length = 200)
    private String lastName;

    private String phoneNumber;

    @Column(nullable = false,length = 255)
    private String email;

    private String instituteName;

    @Column(nullable = false,length = 255,name = "course_name")
    private String courseName;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
