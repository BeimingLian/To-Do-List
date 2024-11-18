import org.demo.todo.domain.tasks;
import org.demo.todo.service.tasksService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TasksServiceIntegrationFunctionalTest {

    @Autowired
    private tasksService tasksService;

    @Test
    @Transactional
    @Rollback
    public void testSelectTaskById() {
        // 先插入一个任务用于测试
        tasks newTask = new tasks();
        newTask.setTaskName("Test Task");
        newTask.setTaskDescription("This is a test task description.");
        newTask.setDueDate("2024-11-20");
        newTask.setStatus("Pending");
        newTask.setUserId(1L);

        tasksService.insertTask(newTask);

        // 查找插入的任务
        tasks foundTask = tasksService.selectTaskById(newTask.getId());

        // 验证任务属性
        assertNotNull(foundTask);
        assertEquals(newTask.getId(), foundTask.getId());
        assertEquals("Test Task", foundTask.getTaskName());
    }

    @Test
    @Transactional
    @Rollback
    public void testSelectAllTasks() {
        // 插入两个任务用于测试
        tasks task1 = new tasks();
        task1.setTaskName("Task 1");
        task1.setTaskDescription("Description 1");
        task1.setDueDate("2024-11-21");
        task1.setStatus("Pending");
        task1.setUserId(2L);
        tasksService.insertTask(task1);

        tasks task2 = new tasks();
        task2.setTaskName("Task 2");
        task2.setTaskDescription("Description 2");
        task2.setDueDate("2024-12-01");
        task2.setStatus("Completed");
        task2.setUserId(3L);
        tasksService.insertTask(task2);

        // 查询所有任务
        List<tasks> tasksList = tasksService.selectAllTasks();

        // 验证返回结果
        assertNotNull(tasksList);
        assertTrue(tasksList.size() >= 2); // 至少应该包含插入的两个任务
    }

    @Test
    @Transactional
    @Rollback
    public void testInsertTask() {
        // 创建新任务
        tasks newTask = new tasks();
        newTask.setTaskName("Insert Test Task");
        newTask.setTaskDescription("Insert test description.");
        newTask.setDueDate("2024-12-10");
        newTask.setStatus("Pending");
        newTask.setUserId(4L);

        // 插入任务
        int rowsInserted = tasksService.insertTask(newTask);

        // 验证插入成功
        assertEquals(1, rowsInserted);
        assertNotNull(newTask.getId()); // 插入后 ID 应该生成
    }

    @Test
    @Transactional
    @Rollback
    public void testUpdateTask() {
        // 创建并插入一个任务
        tasks newTask = new tasks();
        newTask.setTaskName("Original Task");
        newTask.setTaskDescription("Original description.");
        newTask.setDueDate("2024-12-15");
        newTask.setStatus("Pending");
        newTask.setUserId(5L);
        tasksService.insertTask(newTask);

        // 更新任务
        newTask.setTaskName("Updated Task");
        newTask.setTaskDescription("Updated description.");
        newTask.setStatus("Completed");
        int rowsUpdated = tasksService.updateTask(newTask);

        // 验证更新成功
        assertEquals(1, rowsUpdated);

        // 再次查询，验证属性是否更新
        tasks updatedTask = tasksService.selectTaskById(newTask.getId());
        assertNotNull(updatedTask);
        assertEquals("Updated Task", updatedTask.getTaskName());
        assertEquals("Updated description.", updatedTask.getTaskDescription());
        assertEquals("Completed", updatedTask.getStatus());
    }

    @Test
    @Transactional
    @Rollback
    public void testDeleteTask() {
        // 创建并插入一个任务
        tasks newTask = new tasks();
        newTask.setTaskName("Task to be deleted");
        newTask.setTaskDescription("This task will be deleted.");
        newTask.setDueDate("2024-12-20");
        newTask.setStatus("Pending");
        newTask.setUserId(6L);
        tasksService.insertTask(newTask);

        // 删除任务
        tasksService.deleteTask(newTask.getId());

        // 验证任务已被删除
        tasks deletedTask = tasksService.selectTaskById(newTask.getId());
        assertNull(deletedTask);
    }
}
