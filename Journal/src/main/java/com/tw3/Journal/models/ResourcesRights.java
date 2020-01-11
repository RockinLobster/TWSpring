package com.tw3.Journal.models;


import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "resources_rights")
public class ResourcesRights {

    @EmbeddedId
    private ResourcesRightsId id;

    @ManyToOne
    @MapsId("resourcesId")
    private Resources resources;

    @ManyToOne
    @MapsId("rightsId")
    private Rights rights;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinColumns({
            @JoinColumn(name = "resources_rights_id"),
            @JoinColumn(name = "role_id")
    })
    private Set<Roles> roles = new LinkedHashSet<>();

    public ResourcesRights() {

    }

    public ResourcesRights(Resources resources, Rights rights) {
        this.resources = resources;
        this.rights = rights;
        this.id = new ResourcesRightsId(resources.getId(), rights.getId());
    }

    public ResourcesRightsId getId() {
        return id;
    }

    public void setId(ResourcesRightsId id) {
        this.id = id;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
