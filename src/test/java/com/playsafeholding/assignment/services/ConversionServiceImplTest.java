package com.playsafeholding.assignment.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Tatenda Chiwandire
 * Date: 2020/05/29
 * Time: 22:01
 */
@ExtendWith(SpringExtension.class)
class ConversionServiceImplTest {

    private ConversionService conversionService;

    @BeforeEach
    void setUp() {
        conversionService = new ConversionServiceImpl();
    }

    @Test
    void convertCelsiusToKelvin() {
        //Set Up Fixtures and expectations
        float input = 45;
        float expectedResult = 318.15F;

        //Scenario under test
        float actualResult = conversionService.convertCelsiusToKelvin(input);
        //Verifying behavior and test results
        assertTrue(expectedResult == actualResult);
    }

    @Test
    void convertKelvinToCelsius() {
        //Set Up Fixtures and expectations
        float input = 45;
        float expectedResult = -228.15F;

        //Scenario under test
        float actualResult = conversionService.convertKelvinToCelsius(input);
        //Verifying behavior and test results
        assertTrue(expectedResult == actualResult);
    }

    @Test
    void convertMilesToKilos() {
        //Set Up Fixtures and expectations
        double input = 60;
        double expectedResult = 96.5604;

        //Scenario under test
        double actualResult = conversionService.convertMilesToKilos(input);
        //Verifying behavior and test results
        assertTrue(expectedResult == actualResult);
    }

    @Test
    void convertKilosToMiles() {
        //Set Up Fixtures and expectations
        double input = 120;
        double expectedResult = 74.56452;

        //Scenario under test
        double actualResult = conversionService.convertKilosToMiles(input);
        //Verifying behavior and test results
        assertEquals(expectedResult,actualResult);
    }
}