package com.talentofuturo.evaluacion1.calvaradoa.service;

import com.talentofuturo.evaluacion1.calvaradoa.model.ResponseUtil;
import com.talentofuturo.evaluacion1.calvaradoa.model.Task;

public interface ITaskManager {
	ResponseUtil addTask(Task task);
	ResponseUtil editTask(Task task);
	ResponseUtil deleteTask(Integer taskId);
	Task getTaskById(Integer taskId);
    void listTasksOrderByPriority();
    void quickSearch(String taskQuery);
}
