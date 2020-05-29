package com.playsafeholding.assignment.services;

import org.springframework.stereotype.Service;

/**
 * @author Tatenda Chiwandire
 * Date: 2020/05/29
 * Time: 21:45
 */

@Service
public class ConversionServiceImpl implements ConversionService {

    private static final double KMS_PER_MILE = 1.60934;
    private static final double MILES_PER_KM = 0.621371;
    private static final float KELVIN_CELSIUS_CONST = 273.15F;

    @Override
    public float convertCelsiusToKelvin(float input) {
        return input + KELVIN_CELSIUS_CONST;
    }

    @Override
    public float convertKelvinToCelsius(float input) {
        return input - KELVIN_CELSIUS_CONST;
    }

    @Override
    public double convertMilesToKilos(double input) {
        return input * KMS_PER_MILE;
    }

    @Override
    public double convertKilosToMiles(double input) {
        return input * MILES_PER_KM;
    }
}
