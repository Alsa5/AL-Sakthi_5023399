package com.example;

public class TaskManagement {
    private Task head;

    public TaskManagement() {
        this.head = null;
    }

    // Add Task
    public void addTask(Task task) {
        if (head == null) {
            head = task;
        } else {
            Task current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(task);
        }
    }

    // Search Task by ID
    public Task searchTask(String taskId) {
        Task current = head;
        while (current != null) {
            if (current.getTaskId().equals(taskId)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    // Traverse Tasks
    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println(current);
            current = current.getNext();
        }
    }

    // Delete Task by ID
    public void deleteTask(String taskId) {
        if (head == null) {
            return;
        }

        if (head.getTaskId().equals(taskId)) {
            head = head.getNext();
            return;
        }

        Task current = head;
        while (current.getNext() != null) {
            if (current.getNext().getTaskId().equals(taskId)) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }
}
