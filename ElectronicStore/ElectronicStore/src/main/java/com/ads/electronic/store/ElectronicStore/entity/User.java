package com.ads.electronic.store.ElectronicStore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "email_id",unique = true)
    private String email;

    @Column(name = "password",length = 10)
    private String password;

    @Column(name = "about")
    private String about;

    @Column(name = "user_image")
    private String userImage;
}
