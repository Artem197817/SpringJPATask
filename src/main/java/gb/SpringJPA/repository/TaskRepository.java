package gb.SpringJPA.repository;

import gb.SpringJPA.model.Task;
import gb.SpringJPA.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTaskByStatus(TaskStatus status);
}
