
package com.exzone.model.dao;

import com.exzone.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tasks", uniqueConstraints = @UniqueConstraint(columnNames = {"parentTaskId", "taskType", "name"}))
public class Task extends BaseModel {

    public Task() {
    }

    public Task(Long id) {
        super();
        this.setId(id);
    }

    @NotNull
    @Column(length = 50)
    private String module;

    @NotNull
    @JsonProperty("parent_task_id")
    private Long parentTaskId;

    @NotNull
    @Column(unique = true, length = 100)
    private String route;

    @NotNull
    @Column(length = 50)
    private String name;

    @NotNull
    @Column(length = 100)
    private String description;

    @JsonProperty("order")
    @Column(length = 11)
    private Integer _order;

    @Column(length = 20)
    private String icon;

    @Column(length = 100)
    private String extra;

    @JsonBackReference
    @ManyToMany(mappedBy = "tasks")
    private Set<Group> groups = new HashSet<>();

    @JsonBackReference
    @ManyToMany( cascade = {
            CascadeType.PERSIST
            },mappedBy = "authorizerTasks")
    private Set<Group> authorizerGroups = new HashSet<>();
}

