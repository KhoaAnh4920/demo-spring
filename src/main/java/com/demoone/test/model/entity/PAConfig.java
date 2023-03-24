package com.demoone.test.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pa_config")
public class PAConfig implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "isDeleted")
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "paConfig", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PAConfigTemplate> paConfigTemplate;

}
