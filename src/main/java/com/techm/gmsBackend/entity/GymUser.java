package com.techm.gmsBackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="users")
public class GymUser
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   private String name;
   private String password;
   private  long phone_num;
    @Enumerated(EnumType.STRING)
    private Role role;


}
