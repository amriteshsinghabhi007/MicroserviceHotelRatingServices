package com.ads.electronic.store.ElectronicStore.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private String userId;
    @Size(min = 3,max = 25,message = "min 3 and max 25 Char")
    private String name;
    @NotBlank(message = "Gender Is Blank")
    private String gender;
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Email is not vaid")
    @NotBlank(message = "Email id required !!")
    private String email;
    @NotBlank(message = "Password is required !!")
    private String password;
    @Size(min = 2, max = 50,message = "size not more then 25")
    private String about;
    private String userImage;
}
