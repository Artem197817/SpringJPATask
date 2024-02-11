package gb.SpringJPA.service;

import gb.SpringJPA.model.Task;
import gb.SpringJPA.model.TaskStatus;
import gb.SpringJPA.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findTaskByStatus(status);
    }
    public Task findById (Long id){
        return taskRepository.findById(id).orElse(null);
    }

    /**
     * Логичнее
     * Cюда  передавать либо уже задачу с измененным статусом
     * либо идентификатор и статус.
     */
    public Task updateTaskStatus(Long id, Task task) {
        Task taskUpdate = findById(id);
        if (taskUpdate != null){
            taskUpdate.setStatus(task.getStatus());
            taskRepository.save(taskUpdate);
            return taskUpdate;
        }
        return task;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
