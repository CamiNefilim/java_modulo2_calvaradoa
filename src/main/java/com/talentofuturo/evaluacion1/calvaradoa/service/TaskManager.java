package com.talentofuturo.evaluacion1.calvaradoa.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import com.talentofuturo.evaluacion1.calvaradoa.model.ErrorResponse;
import com.talentofuturo.evaluacion1.calvaradoa.model.SuccessResponse;
import com.talentofuturo.evaluacion1.calvaradoa.model.ResponseUtil;
import com.talentofuturo.evaluacion1.calvaradoa.model.Task;

public class TaskManager implements ITaskManager {

	private List<Task> tasks = new LinkedList<>();
	
	@Override
	public ResponseUtil addTask(Task task) {
		try {
			if(task.getId() > 0 && task.getTitle().length() > 0) {
			 tasks.add(task);
		     return new SuccessResponse("Tarea agregada en la lista.");
			}
			else { return new ErrorResponse("Tarea no fue agregada - Detalle: Debe tener al menos un ID y Título", 500); }
		}
		catch(Exception ex) {
			return new ErrorResponse("Tarea no fue agregada - Detalle: "+ex.getMessage(), 500);
		}
	}

	@Override
	public ResponseUtil editTask(Task editTask) {
		Optional<Task> task = tasks.stream().filter(t -> t.getId() == editTask.getId()).findFirst();
        if (task.isPresent()) {
            Task t = task.get();
            if(!editTask.getTitle().isEmpty()) t.setTitle(editTask.getTitle());
            if(!editTask.getDescription().isEmpty()) t.setDescription(editTask.getDescription());
            if(editTask.getPriority() != null) t.setPriority(editTask.getPriority());
            if(editTask.getStatus() != null) t.setStatus(editTask.getStatus());
            return new SuccessResponse("Tarea editada en la lista.");
        }
        return new ErrorResponse("Tarea no encontrada en la lista.", 404);
	}

	@Override
	public ResponseUtil deleteTask(Integer taskId) {
		boolean removed = tasks.removeIf(task -> task.getId() == taskId);
        if (removed) {
            return new SuccessResponse("Tarea eliminada de la lista.");
        }
        return new ErrorResponse("Tarea no encontrada", 404);
	}
	
	@Override
	public Task getTaskById(Integer taskId) {
		return tasks.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .orElse(null);
	}

	@Override
	public void listTasksOrderByPriority() {
		List<Task> results = tasks.stream()
						     .sorted((t1, t2) -> t1.getPriority().compareTo(t2.getPriority()))
			                 .toList();
		if (results.isEmpty()) {
            System.out.println("No se encontraron tareas.");
        } else {
        	printTask(results);
        }
	}

	@Override
	public void quickSearch(String taskQuery) {
		List<Task> results =  tasks.stream()
							 .filter(task -> task.getTitle().toLowerCase().contains(taskQuery.toLowerCase()) || task.getDescription().toLowerCase().contains(taskQuery.toLowerCase()))
                             .toList();		
		if (results.isEmpty()) {
            System.out.println("No se encontraron tareas.");
        } else {
        	printTask(results);
        }
	}
	
	private void printTask(List<Task> results) {
		results.forEach(System.out::println);
	}
	
}
