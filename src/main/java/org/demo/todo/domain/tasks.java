package org.demo.todo.domain;

public class tasks {
    private Long id;
    private String taskName;
    private String taskDescription;
    private String dueDate;
    private String status;
    private Long userId;
    private String createdBy;
    private String updatedBy;

    public Long getId() {
        return id;
    }

    public tasks setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTaskName() {
        return taskName;
    }

    public tasks setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public tasks setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
        return this;
    }

    public String getDueDate() {
        return dueDate;
    }

    public tasks setDueDate(String dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public tasks setStatus(String status) {
        this.status = status;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public tasks setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public tasks setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public tasks setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
        return this;
    }
}
