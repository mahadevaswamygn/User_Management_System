package com.Geeksterasmt.UserManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "tlb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    @NotBlank(message = "User name required")
    private String userName;

    @NotBlank(message = "date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String dateOfBirth;

    private String email;

    @NotBlank(message = "phone number must required")
    @Size(min=12,max=12,message = "size must be required")
    private String phoneNumber;


    private String date;

    private String userTime;
}
