package com.exzone.model.dao;

import com.exzone.enums.NotificationType;
import com.exzone.model.BaseModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "notifications")
public class Notification extends BaseModel {

    private String to;

    private String from;

    private String subject;

    private String message;

    private NotificationType type;
}