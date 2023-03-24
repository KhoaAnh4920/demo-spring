package com.demoone.test.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pa")
public class PA implements Serializable {
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

    @OneToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "pa_config_template_id", referencedColumnName = "id")
//    private PAConfigTemplate paConfigTemplate;
}
