package com.demoone.test.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PADto {
    private String name;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    private Long userId;

    private Long paConfigTemplateId;
}

