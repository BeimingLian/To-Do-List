import org.demo.todo.domain.tasks;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

public class TasksDomainTest {

    @Test
    public void testTasksCreation() {
        tasks task = new tasks();
        task.setTaskName("Test Task");
        task.setTaskDescription("This is a test task description.");
        task.setDueDate("2024-11-20");
        task.setStatus("Pending");
        task.setUserId(1L);
        String createdTime = LocalDateTime.now().toString();
        String updatedTime = LocalDateTime.now().toString();
        task.setCreatedBy(createdTime);
        task.setUpdatedBy(updatedTime);

        assertEquals("Test Task", task.getTaskName());
        assertEquals("This is a test task description.", task.getTaskDescription());
        assertEquals("2024-11-20", task.getDueDate());
        assertEquals("Pending", task.getStatus());
        assertEquals(1L, task.getUserId());
        assertEquals(createdTime, task.getCreatedBy());
        assertEquals(updatedTime, task.getUpdatedBy());
    }


    @Test
    public void testTasksHashCode() {
        tasks task = new tasks();
        task.setId(1L);
        task.setTaskName("Task Name");

        assertNotNull(task.hashCode(), "HashCode should not be null");
    }
}
