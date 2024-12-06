import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {
    static Calculator calculator;
    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @AfterAll
    static void afterAll() {
        calculator = null;
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Running a test.");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Test completed. ");
    }

    @Test
    void add() {
        assertNull(calculator.add(1, 2));
        assertNotNull(calculator.add(3, 4));
        assertEquals(5+5, calculator.add(5,5));
    }

    @Test
    void subtract() {
        assertEquals(421- 323, calculator.subtract(421, 323));
    }

    @Test
    void multiply() {
        int res = calculator.multiply(3, 4);
        assertTrue(3*4 == calculator.multiply(3, 4));
    }

    @Test
    void divide() {
        assertThrows(Exception.class, () -> calculator.divide(4, 0));
        assertDoesNotThrow(() -> calculator.divide(0, 3));
    }
}