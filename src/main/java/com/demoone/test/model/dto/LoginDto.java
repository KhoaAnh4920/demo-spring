package com.demoone.test.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDto {
    private String username;
    private String password;
}
