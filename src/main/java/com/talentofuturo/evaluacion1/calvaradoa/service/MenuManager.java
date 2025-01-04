package com.talentofuturo.evaluacion1.calvaradoa.service;

import java.util.Scanner;

import com.talentofuturo.evaluacion1.calvaradoa.model.Task;
import com.talentofuturo.evaluacion1.calvaradoa.model.TaskPriority;
import com.talentofuturo.evaluacion1.calvaradoa.model.TaskStatus;

public class MenuManager implements IMenuManager {
	
    private final TaskManager taskManager;
    private final Scanner scanner;

    public MenuManager(TaskManager taskManager) {
        this.taskManager = taskManager;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void showMenu() {
        System.out.println("\n=== Menú ===");
        System.out.println("1) Agregar tarea");
        System.out.println("2) Editar tarea");
        System.out.println("3) Eliminar tarea");
        System.out.println("4) Listar tareas");
        System.out.println("5) Buscar tarea");
        System.out.println("6) Salir");
        System.out.print("Seleccione una opción: ");
    }

    @Override
    public void getReponse() {
    	String choice = scanner.nextLine();
        switch (choice.toLowerCase()) {
            case "1":
                addTask();
                break;
            case "2":
                editTask();
                break;
            case "3":
                deleteTask();
                break;
            case "4":
                taskManager.listTasksOrderByPriority();
                break;
            case "5":
                searchTask();
                break;
            case "6":
                System.out.println("Saliendo del sistema de tareas.");
                System.exit(0);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void addTask() {
        Task newTask = new Task();
        
        System.out.print("Ingresa un Título: ");
        newTask.setTitle(scanner.nextLine());
        if (newTask.getTitle().isEmpty()) {
            System.out.println("El título no puede estar vacío.");
            return;
        }

        System.out.print("Ingresa una Descripción: ");
        newTask.setDescription(scanner.nextLine());
        if (newTask.getDescription().isEmpty()) {
            System.out.println("La descripción no puede estar vacía.");
            return;
        }

        boolean validPriority = false;
        while (!validPriority) {
            System.out.print("Ingresa una Prioridad (ALTA, MEDIA, BAJA): ");
            try {
                newTask.setPriority(TaskPriority.valueOf(scanner.nextLine().toUpperCase()));
                validPriority = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Prioridad no válida. Ingresa ALTA, MEDIA o BAJA.");
            }
        }

        boolean validStatus = false;
        while (!validStatus) {
            System.out.print("Ingresa un Estado (PENDIENTE, EN_PROGRESO, COMPLETADA): ");
            try {
                newTask.setStatus(TaskStatus.valueOf(scanner.nextLine().toUpperCase()));
                validStatus = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Estado no válido. Ingresa PENDIENTE, EN_PROGRESO o COMPLETADA.");
            }
        }

        System.out.println(taskManager.addTask(newTask));
    }

    private void editTask() {
    	Task updateTask = new Task();
    	
        boolean validId = false;        
        while (!validId) {
            System.out.print("Ingresa el ID de la tarea a editar: ");
            try {
            	updateTask.setId(Integer.parseInt(scanner.nextLine()));
                
                if(taskManager.getTaskById(updateTask.getId()) != null) { 
                	validId = true;
                }else {
                	System.out.println("No existe ninguna tarea con el ID ingresado.");
                	return;
                }
            } catch (NumberFormatException e) {
                System.out.println("ID no válido. Por favor ingresa un número entero.");
            }
        }
        
        System.out.print("Nuevo título (opcional): ");
        updateTask.setTitle(scanner.nextLine());
        
        System.out.print("Nueva descripción (opcional): ");
        updateTask.setDescription(scanner.nextLine());
        
        boolean validPriority = false;
        while (!validPriority) {
            System.out.print("Nueva prioridad (ALTA, MEDIA, BAJA) (opcional): ");
            String priorityInput = scanner.nextLine();
            if (priorityInput.isEmpty()) {
                validPriority = true;
            } else {
                try {
                	updateTask.setPriority(TaskPriority.valueOf(priorityInput.toUpperCase()));
                    validPriority = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Prioridad no válida. Ingresa ALTA, MEDIA o BAJA.");
                }
            }
        }

        boolean validStatus = false;
        while (!validStatus) {
            System.out.print("Nuevo estado (PENDIENTE, EN_PROGRESO, COMPLETADA) (opcional): ");
            String statusInput = scanner.nextLine();
            if (statusInput.isEmpty()) {
                validStatus = true;
            } else {
                try {
                    updateTask.setStatus(TaskStatus.valueOf(statusInput.toUpperCase()));
                    validStatus = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Estado no válido. Ingresa PENDIENTE, EN_PROGRESO o COMPLETADA.");
                }
            }
        }

        System.out.println(taskManager.editTask(updateTask));
    }

    private void deleteTask() {    	
    	boolean validId = false;        
        while (!validId) {
            System.out.print("Ingresa el ID de la tarea a eliminar: ");
            try {
            	int id = Integer.parseInt(scanner.nextLine());
            	System.out.println(taskManager.deleteTask(id));
                validId = true;
            } catch (NumberFormatException e) {
                System.out.println("ID no válido. Por favor ingresa un número entero.");
            }
        }
    }

    private void searchTask() {
        System.out.print("Ingresa el Término de búsqueda: ");
        String query = scanner.nextLine();
        taskManager.quickSearch(query);
    }
}
