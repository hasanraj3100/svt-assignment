import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookingServiceTest {
    @Mock
    private PaymentService mockPaymentService;

    @InjectMocks
    private BookingService bookingService;


    @Test
    void book() {
    }

    @Test
    void testProcessMethod() {
        when(mockPaymentService.processPayment()).thenReturn(true);

        assertTrue(bookingService.book());
        verify(mockPaymentService).processPayment();
    }

}