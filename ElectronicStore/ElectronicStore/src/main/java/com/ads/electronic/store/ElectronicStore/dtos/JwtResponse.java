package com.ads.electronic.store.ElectronicStore.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtResponse {
    private String JwtToken;
    private UserDto user;
}
