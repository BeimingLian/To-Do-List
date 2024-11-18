import org.demo.todo.DemoApplication;
import org.demo.todo.domain.users;
import org.demo.todo.service.impl.usersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class UsersServiceImplTest {

    @Autowired
    private usersServiceImpl usersService;

    @Test
    public void testSelectUserById() {
        Long userId = 1L;
        users user = usersService.selectUserById(userId);
        assertNotNull(user);
        assertEquals(userId, user.getId());
    }

    @Test
    public void testInsertUser() {
        users newUser = new users();
        newUser.setUserName("Test User");
        newUser.setPassword("password123");
        newUser.setEmail("testuser@example.com");

        int result = usersService.insertUser(newUser);
        assertEquals(1, result);
        assertNotNull(newUser.getId(), "User ID should not be null after insertion");
    }

    @Test
    public void testUpdateUser() {
        users existingUser = usersService.selectUserById(1L);
        assertNotNull(existingUser, "User should exist before updating");

        existingUser.setUserName("Updated User");
        existingUser.setEmail("updateduser@example.com");

        int result = usersService.updateUser(existingUser);
        assertEquals(1, result);
    }

    @Test
    public void testDeleteUser() {
        Long userId = 2L;
        users user = usersService.selectUserById(userId);
        assertNotNull(user, "User should exist before deletion");

        usersService.deleteUser(userId);

        users deletedUser = usersService.selectUserById(userId);
        assertNull(deletedUser, "User should no longer exist after deletion");
    }
}
