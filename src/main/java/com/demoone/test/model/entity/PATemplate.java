package com.demoone.test.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pa_template")
public class PATemplate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Boolean status = true;

    @Column(name = "description")
    private String description;

    @Column(name = "isDeleted")
    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "paTemplate", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<PAConfigTemplate> paConfigTemplate;

}
