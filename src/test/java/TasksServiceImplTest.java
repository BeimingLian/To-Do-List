import org.demo.todo.DemoApplication;
import org.demo.todo.domain.tasks;
import org.demo.todo.service.impl.tasksServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class TasksServiceImplTest {

    @Autowired
    private tasksServiceImpl tasksService;

    @Test
    public void testSelectTaskById() {
        Long taskId = 6L;
        tasks task = tasksService.selectTaskById(taskId);
        assertNotNull(task);
        assertEquals(taskId, task.getId());
    }

    @Test
    public void testInsertTask() {
        tasks newTask = new tasks();
        newTask.setTaskName("New Task");
        newTask.setTaskDescription("This is a test task.");

        int result = tasksService.insertTask(newTask);
        assertEquals(1, result);
    }

    @Test
    public void testUpdateTask() {
        tasks existingTask = tasksService.selectTaskById(6L);
        existingTask.setTaskName("Updated Task");

        existingTask.setTaskDescription("Updated Description");

        int result = tasksService.updateTask(existingTask);
        assertEquals(1, result);

    }

//    @Test
//    public void testDeleteTask() {
//        // Assuming that you have already inserted a task with ID 1 for testing.
//        Long taskId = L;
//
//        // First, ensure the task exists by checking if it can be fetched
//        tasks task = tasksService.selectTaskById(taskId);
//        assertNotNull(task); // Verify that the task exists before deletion
//
//        // Perform the deletion
//        tasksService.deleteTask(taskId);
//
//        // Verify that the task has been deleted by trying to fetch it again
//        tasks deletedTask = tasksService.selectTaskById(taskId);
//        assertNull(deletedTask); // The task should no longer exist
//    }
//
//    @Test
//    @Transactional
//    @Rollback
//    public void testFailingScenario() {
//
//        // intent to give bug report
//
//        tasks newTask = new tasks();
//        newTask.setTaskName("Failing Task");
//        newTask.setTaskDescription("This task is meant to fail.");
//        newTask.setDueDate("2024-12-15");
//        newTask.setStatus("Pending");
//        newTask.setUserId(5L);
//
//
//        assertEquals(1, 2, "This is a deliberate failure to test the bug reporting mechanism.");
//    }

}
