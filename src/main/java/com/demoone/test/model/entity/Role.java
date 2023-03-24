package com.demoone.test.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pa_role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "deleted")
    private Boolean isDeleted = false;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @JoinTable(name = "users_roles",
//            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id")
//    )
//    private List<User> users;
}
