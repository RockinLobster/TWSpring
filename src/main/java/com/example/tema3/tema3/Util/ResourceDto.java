package com.example.tema3.tema3.Util;

import com.example.tema3.tema3.models.Users;

public class ResourceDto {
    private String name = new String();
    private String resourceText = new String();
    private Integer id = new Integer(0);

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceText() {
        return resourceText;
    }

    public void setResourceText(String resourceText) {
        this.resourceText = resourceText;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
