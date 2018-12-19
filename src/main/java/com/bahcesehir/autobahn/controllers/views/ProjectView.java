package com.bahcesehir.autobahn.controllers.views;


import com.bahcesehir.autobahn.entities.Project;
import org.modelmapper.ModelMapper;

public class ProjectView extends BaseView<Project> {

    private String name;
    private String description;

    public ProjectView(Project p){
        this.map(p);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
