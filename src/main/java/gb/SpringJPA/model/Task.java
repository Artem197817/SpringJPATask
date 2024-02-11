package gb.SpringJPA.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

/**
 * Структура задачи(класс Task):
 * - ID (автоинкрементное)(тип Long)
 * - Описание (не может быть пустым)(тип String)
 * - Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
 * - Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)
 */
@Data
@Entity
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String description;
    @Enumerated
    private TaskStatus status = TaskStatus.NOT_STARTED;
    private LocalDateTime dateCreate = LocalDateTime.now();

    public Task(String description) {
        this.description = description;

    }
}
