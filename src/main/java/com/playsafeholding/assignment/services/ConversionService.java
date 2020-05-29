package com.playsafeholding.assignment.services;

/**
 * @author Tatenda Chiwandire
 * Date: 2020/05/29
 * Time: 21:40
 */
public interface ConversionService {

    float convertCelsiusToKelvin(float input);

    float convertKelvinToCelsius(float input);

    double convertMilesToKilos(double input);

    double convertKilosToMiles(double input);
}
