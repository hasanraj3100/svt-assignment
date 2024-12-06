import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginManagerTest {

    @Mock
    AuthenticationService authenticationService;

    @InjectMocks
    LoginManager loginManager;

    @Test
    void login() {
        when(authenticationService.authenticate("validUser", "validPass")).thenReturn(true);
        when(authenticationService.authenticate("invalidUser", "wrongPass")).thenReturn(false);

        try {

            assertTrue(loginManager.login("validUser", "validPass"));


            assertFalse(loginManager.login("invalidUser", "wrongPass"));

            // Verify that the authenticate method is called with correct arguments
            verify(authenticationService).authenticate("validUser", "validPass");
            verify(authenticationService).authenticate("invalidUser", "wrongPass");

            // Test for null username or password
            assertThrows(Exception.class, () -> loginManager.login(null, "password"));
            assertThrows(Exception.class, () -> loginManager.login("username", null));

            // Verify that authenticate is not called when username or password is null
            verify(authenticationService, never()).authenticate(null, "password");
            verify(authenticationService, never()).authenticate("username", null);

        } catch (Exception e) {
            fail("Test failed due to unexpected exception: " + e.getMessage());
        }
    }
}