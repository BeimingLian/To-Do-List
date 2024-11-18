import org.demo.todo.domain.tasks;
import org.junit.jupiter.api.Test;
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
        task.setCreatedBy(String.valueOf(1L));
        task.setUpdatedBy(String.valueOf(1L));

        assertEquals("Test Task", task.getTaskName());
        assertEquals("This is a test task description.", task.getTaskDescription());
        assertEquals("2024-11-20", task.getDueDate());
        assertEquals("Pending", task.getStatus());
        assertEquals(1L, task.getUserId());
        assertEquals(1L, task.getCreatedBy());
        assertEquals(1L, task.getUpdatedBy());
    }

    @Test
    public void testTasksEquality() {
        tasks task1 = new tasks();
        task1.setId(1L);
        task1.setTaskName("Task Name");

        tasks task2 = new tasks();
        task2.setId(1L);
        task2.setTaskName("Task Name");

        assertEquals(task1, task2, "Tasks with the same ID and name should be considered equal");
    }

    @Test
    public void testTasksHashCode() {
        tasks task = new tasks();
        task.setId(1L);
        task.setTaskName("Task Name");

        assertNotNull(task.hashCode(), "HashCode should not be null");
    }
}
