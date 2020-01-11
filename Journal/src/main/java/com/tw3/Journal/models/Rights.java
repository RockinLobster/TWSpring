package com.tw3.Journal.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="rights")
public class Rights {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToMany(
            mappedBy = "resources",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<ResourcesRights> rights = new HashSet<>();

    public Rights(){

    }

    public Rights(String name, Set<ResourcesRights> rights) {
        this.name = name;
        this.rights = rights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ResourcesRights> getRights() {
        return rights;
    }

    public void setRights(Set<ResourcesRights> rights) {
        this.rights = rights;
    }
}
