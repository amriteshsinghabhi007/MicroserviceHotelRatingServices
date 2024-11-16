package com.ads.electronic.store.ElectronicStore.dtos;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String userId;
    private String name;
    private String gender;
    private String email;
    private String password;
    private String about;
    private String userImage;
}
