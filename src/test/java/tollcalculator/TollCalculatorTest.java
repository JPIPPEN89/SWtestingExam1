package tollcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TollCalculatorTest
{
    TollCalculator calculator = new TollCalculator();

    @ParameterizedTest
    @CsvFileSource(resources = "/testCases.csv", numLinesToSkip = 1)
    void testDiscount(String testCase,
                      double weight,
                      boolean isEV,
                      boolean isCarpool,
                      double expectedOutput) {


        double actual = calculator.calculateDiscount(weight, isEV, isCarpool);

        assertEquals(expectedOutput, actual);
    }

    //TC2
    @Test
    void invalidWeight() {
        assertThrows(IllegalArgumentException.class, () ->
                calculator.calculateDiscount(0, false, false)
        );
    }

}

