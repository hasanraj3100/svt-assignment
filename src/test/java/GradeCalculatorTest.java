import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class GradeCalculatorTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/GradeData.csv")
    void getGrade(int score, String expectedGrade) {
        assertEquals(expectedGrade, GradeCalculator.getGrade(score));
    }

    @Test
    void testInvalidScore() {
        assertThrows(IllegalArgumentException.class, ()-> GradeCalculator.getGrade(-5));
        assertThrows(IllegalArgumentException.class, ()-> GradeCalculator.getGrade(101));
    }
}