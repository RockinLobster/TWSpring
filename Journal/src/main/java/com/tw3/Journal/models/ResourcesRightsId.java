package com.tw3.Journal.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ResourcesRightsId implements Serializable {

    @Column(name="resources_id")
    private Long resourceId;

    @Column(name="rights_id")
    private Long rightsId;

    public ResourcesRightsId(){
    }

    public ResourcesRightsId(Long resourceId, Long rightsId) {
        this.resourceId = resourceId;
        this.rightsId = rightsId;
    }

    public Long getResourceId() {
        return resourceId;
    }

    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }

    public Long getRightsId() {
        return rightsId;
    }

    public void setRightsId(Long rightsId) {
        this.rightsId = rightsId;
    }
}
