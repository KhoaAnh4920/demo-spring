package com.demoone.test.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pa_config_template")
public class PAConfigTemplate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

//    @Column(name = "name")
//    private String name;
//
//    @Column(name = "description")
//    private String description;
//
//    @Column(name = "role_type")
//    private String roleType;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "pa_config_id", referencedColumnName = "id")
    private PAConfig paConfig;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "pa_template_id", referencedColumnName = "id")
    private PATemplate paTemplate;

//    @OneToOne(
//            fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL,
//            mappedBy = "paConfigTemplate")
//    private PA pa;


}
