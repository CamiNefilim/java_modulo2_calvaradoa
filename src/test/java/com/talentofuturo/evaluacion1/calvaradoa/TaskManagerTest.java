package com.talentofuturo.evaluacion1.calvaradoa;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.talentofuturo.evaluacion1.calvaradoa.model.Task;
import com.talentofuturo.evaluacion1.calvaradoa.model.ResponseUtil;
import com.talentofuturo.evaluacion1.calvaradoa.model.SuccessResponse;
import com.talentofuturo.evaluacion1.calvaradoa.model.ErrorResponse;
import com.talentofuturo.evaluacion1.calvaradoa.model.TaskPriority;
import com.talentofuturo.evaluacion1.calvaradoa.model.TaskStatus;
import com.talentofuturo.evaluacion1.calvaradoa.service.TaskManager;

public class TaskManagerTest {

    private TaskManager taskManager;

    @BeforeEach
    void setUp() {
        taskManager = new TaskManager();
    }

    @Test
    void testAddTaskSuccess() {
        Task task = new Task(1, "Test Task", "Test Description", TaskPriority.ALTA, TaskStatus.PENDIENTE);
        ResponseUtil response = taskManager.addTask(task);

        assertTrue(response instanceof SuccessResponse);
        assertEquals("Tarea agregada en la lista.", response.getMessage());
    }

    @Test
    void testAddTaskFailure() {
        Task task = new Task(0, "", "Invalid Task", TaskPriority.BAJA, TaskStatus.PENDIENTE);
        ResponseUtil response = taskManager.addTask(task);

        assertTrue(response instanceof ErrorResponse);
        assertEquals("Tarea no fue agregada - Detalle: Debe tener al menos un ID y Título", response.getMessage());
    }

    @Test
    void testEditTaskSuccess() {
        Task task = new Task(1, "Original Task", "Original Description", TaskPriority.MEDIA, TaskStatus.PENDIENTE);
        taskManager.addTask(task);

        Task updatedTask = new Task(1, "Updated Task", "Updated Description", TaskPriority.ALTA, TaskStatus.EN_PROGRESO);
        ResponseUtil response = taskManager.editTask(updatedTask);

        assertTrue(response instanceof SuccessResponse);
        assertEquals("Tarea editada en la lista.", response.getMessage());

        Task editedTask = taskManager.getTaskById(1);
        assertEquals("Updated Task", editedTask.getTitle());
        assertEquals("Updated Description", editedTask.getDescription());
        assertEquals(TaskPriority.ALTA, editedTask.getPriority());
        assertEquals(TaskStatus.EN_PROGRESO, editedTask.getStatus());
    }

    @Test
    void testEditTaskFailure() {
        Task updatedTask = new Task(99, "Nonexistent Task", "No Description", TaskPriority.ALTA, TaskStatus.EN_PROGRESO);
        ResponseUtil response = taskManager.editTask(updatedTask);

        assertTrue(response instanceof ErrorResponse);
        assertEquals("Tarea no encontrada en la lista.", response.getMessage());
    }

    @Test
    void testDeleteTaskSuccess() {
        Task task = new Task(1, "Task to Delete", "Description", TaskPriority.MEDIA, TaskStatus.PENDIENTE);
        taskManager.addTask(task);

        ResponseUtil response = taskManager.deleteTask(1);

        assertTrue(response instanceof SuccessResponse);
        assertEquals("Tarea eliminada de la lista.", response.getMessage());

        assertNull(taskManager.getTaskById(1));
    }

    @Test
    void testDeleteTaskFailure() {
        ResponseUtil response = taskManager.deleteTask(99);

        assertTrue(response instanceof ErrorResponse);
        assertEquals("Tarea no encontrada", response.getMessage());
    }

    @Test
    void testGetTaskById() {
        Task task = new Task(1, "Test Task", "Description", TaskPriority.ALTA, TaskStatus.PENDIENTE);
        taskManager.addTask(task);

        Task retrievedTask = taskManager.getTaskById(1);

        assertNotNull(retrievedTask);
        assertEquals(1, retrievedTask.getId());
        assertEquals("Test Task", retrievedTask.getTitle());
    }

    @Test
    void testGetTaskByIdNotFound() {
        Task task = taskManager.getTaskById(99);
        assertNull(task);
    }

}
