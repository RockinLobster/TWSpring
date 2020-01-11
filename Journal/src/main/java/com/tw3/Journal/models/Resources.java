package com.tw3.Journal.models;


import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "resources")
public class Resources {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String text;

    @OneToMany(
            mappedBy = "resources",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<ResourcesRights> rights = new LinkedHashSet<>();

    public Resources() {
    }

    public Resources(String name, String text, Set<ResourcesRights> rights) {
        this.name = name;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<ResourcesRights> getRights() {
        return rights;
    }

    public void setRights(Set<ResourcesRights> rights) {
        this.rights = rights;
    }
}
