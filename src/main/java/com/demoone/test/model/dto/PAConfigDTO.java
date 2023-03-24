package com.demoone.test.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PAConfigDTO {
    private String name;
    private String description;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date startDate;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date endDate;

    private List<Long> ids;
}
