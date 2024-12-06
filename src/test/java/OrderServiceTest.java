import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Or;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    ShippingService shippingService;

    @InjectMocks
    OrderService orderService;

    @Test
    void placeOrder() {
        when(shippingService.ship("item1", 5)).thenReturn(true);

        assertTrue(orderService.placeOrder("item1", 5));

        assertFalse(orderService.placeOrder("item2", -1));
        assertFalse(orderService.placeOrder("item3", 0));

        verify(shippingService).ship("item1", 5);
        verify(shippingService, never()).ship("item2", -1);
        verify(shippingService, never()).ship("item3", 0);
    }
}