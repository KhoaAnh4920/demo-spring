package com.demoone.test.model.dto;

import com.demoone.test.model.entity.Role;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterDto {
    private String name;
    private String username;
    private String email;
    private String password;
    private List<Long> roleIds;
}
