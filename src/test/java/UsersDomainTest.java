import org.demo.todo.domain.users;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsersDomainTest {

    @Test
    public void testUserProperties() {
        users user = new users();
        user.setId(1L);
        user.setUserName("Beiming");
        user.setPassword("password123");
        user.setEmail("beiming@example.com");

        assertEquals(1L, user.getId());
        assertEquals("Beiming", user.getUserName());
        assertEquals("password123", user.getPassword());
        assertEquals("beiming@example.com", user.getEmail());
    }
}
