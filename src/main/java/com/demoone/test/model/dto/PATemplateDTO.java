package com.demoone.test.model.dto;

import lombok.*;

import javax.persistence.Column;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PATemplateDTO {
    private String name;
    private String description;
}
