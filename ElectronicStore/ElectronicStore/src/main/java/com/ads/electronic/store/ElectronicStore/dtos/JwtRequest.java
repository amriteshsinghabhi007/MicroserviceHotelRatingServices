package com.ads.electronic.store.ElectronicStore.dtos;

import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class JwtRequest {
    private String email;
    private String password;
}
