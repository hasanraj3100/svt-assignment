import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserManagerTest {

    @Mock
    UserService userService;

    @InjectMocks
    UserManager userManager;




    @Test
    void registerUser() {
        // Stub methods
        when(userService.usernameExists("raj3100")).thenReturn(false); // New username
        when(userService.usernameExists("raj")).thenReturn(true); // Existing username
        when(userService.saveUser("raj3100", "1234")).thenReturn(true); // Save success for "raj3100"

        String newName = "raj3100";
        assertTrue(userManager.registerUser(newName, "1234"));

        String existingName = "raj";
        assertFalse(userManager.registerUser(existingName, "1234"));

        String anotherName = "hasanraj";
        when(userService.usernameExists(anotherName)).thenReturn(false);
        when(userService.saveUser(anotherName, "1234")).thenReturn(true);
        assertTrue(userManager.registerUser(anotherName, "1234"));


        verify(userService).usernameExists(newName);
        verify(userService).usernameExists(existingName);
        verify(userService).usernameExists(anotherName);

        verify(userService).saveUser(newName, "1234");
        verify(userService).saveUser(anotherName, "1234");

    }

}