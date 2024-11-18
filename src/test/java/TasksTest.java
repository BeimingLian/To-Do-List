import org.demo.todo.domain.tasks;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TasksTest{

    @Test
    public void testTaskProperties() {
        tasks task = new tasks();
        task.setId(1L);
        task.setTaskName("Test Task");
        task.setTaskDescription("This is a test description.");
        task.setDueDate("2024-11-17");
        task.setStatus("Pending");
        task.setUserId(2L);
        task.setCreatedBy("Admin");
        task.setUpdatedBy("Admin");

        assertEquals(1L, task.getId());
        assertEquals("Test Task", task.getTaskName());
        assertEquals("This is a test description.", task.getTaskDescription());
        assertEquals("2024-11-17", task.getDueDate());
        assertEquals("Pending", task.getStatus());
        assertEquals(2L, task.getUserId());
        assertEquals("Admin", task.getCreatedBy());
        assertEquals("Admin", task.getUpdatedBy());
    }
}

