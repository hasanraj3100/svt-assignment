import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {
    Calculator calculator;
    @BeforeAll
    static void beforeAll() {
        System.out.println("Executing beforeAll() method..");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Executing afterAll() method.. ");
    }

    @BeforeEach
    void beforeEach() {
        calculator = new Calculator();
        System.out.println("Initializing a test..");
    }

    @AfterEach
    void afterEach() {
        System.out.println("Test ended...");
    }

    @Test
    void add() {
        assertEquals(5+5, calculator.add(5,5));
        assertNotEquals(63, calculator.add(34, 32));
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

    @Test
    void testNull() {
        Calculator nullCalculator = null;
        assertNull(nullCalculator);
        assertNotNull(calculator);
    }

    @Test
    void testArrayEquals() {
        int[] expectedArray = {1, 2, 3};
        assertArrayEquals(expectedArray, calculator.generateArray());
    }

    @Test
    void testAssertSame() {
        Calculator newCalculator = calculator;
        assertSame(newCalculator, calculator);
    }

    @Test
    void testLineMatch() {
        assertLinesMatch(List.of("Line1", "Line2","Line3"),
                List.of(calculator.generateMultiLineString().split("\n")));
    }

    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(200), () -> {
            Thread.sleep(100);
            calculator.multiply(32, 2);
        });
    }


    @ParameterizedTest
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "-1, 5, 4",
            "0, 0, 0"
    })
    void testAddWithParameterized(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    @RepeatedTest(5)
    void GenerateRandomNumber() {
        int number = calculator.generateRandomNumber();
        assertTrue(number >= 0 && number < 100);
    }
}