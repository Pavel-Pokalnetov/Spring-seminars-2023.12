package ru.gb.pokalnetovps.hw10;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.gb.pokalnetovps.hw10.model.User;
import ru.gb.pokalnetovps.hw10.service.UserService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IntegrityAppServiceTest {
    @Autowired
    UserService us;
    @Test
    public void integrityTest(){
        User user = new User();
        user.setName("test-user");
        user.setLogin("test-login");
        user.setPassword("test-password");
        User createdUser = us.addUser(user);
        Long id = createdUser.getId();
        User readUser = us.getUserById(id);
        assertEquals(readUser.getId(),id);
        us.deleteUserById(id);
        readUser = us.getUserById(id);
        assertNull(readUser);
    };
}
