package com.talentofuturo.evaluacion1.calvaradoa.model;

public class Task {

private static int serial_id = 1;
private Integer id;
private String title;
private String description;
private TaskPriority priority;
private TaskStatus status;

public Task() {
	this.id = serial_id++;
}

public Task(Integer id, String title, String description, TaskPriority priority, TaskStatus status) {
	if(id > 0) { this.id = id;} else { this.id = serial_id++;}
	this.title = title;
	this.description = description;
	this.priority = priority;
	this.status = status;
}

public static int getSerial_id() {
	return serial_id;
}

public static void setSerial_id(int serial_id) {
	Task.serial_id = serial_id;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public TaskPriority getPriority() {
	return priority;
}

public void setPriority(TaskPriority priority) {
	this.priority = priority;
}

public TaskStatus getStatus() {
	return status;
}

public void setStatus(TaskStatus status) {
	this.status = status;
}

@Override
public String toString() {
	 return "[ID: " + this.id + "] - " +
             "Título: " + this.title + " - " +
             "Descripción: " + this.description + " - " +
             "Prioridad: " + this.priority + " - " +
             "Estado: " + this.status;
}

}
