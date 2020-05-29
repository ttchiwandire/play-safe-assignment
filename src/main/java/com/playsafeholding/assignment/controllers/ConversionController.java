package com.playsafeholding.assignment.controllers;

import com.playsafeholding.assignment.services.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.logging.Logger;

/**
 * @author Tatenda Chiwandire
 * Date: 2020/05/29
 * Time: 22:17
 */

@RestController
@RequestMapping(value = "/conversions")
public class ConversionController {
    private static final Logger LOGGER = Logger.getLogger(ConversionController.class.getName());
    @Autowired
    private ConversionService conversionService;

    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("/ctok")
    public float convertCelciusToKelvin(@RequestParam(value = "celsius") float celsius) {

        Long time = System.currentTimeMillis();
        try {
            return conversionService.convertCelsiusToKelvin(celsius);
        } finally {
            time = System.currentTimeMillis() - time;
            LOGGER.info(MessageFormat.format("Call took {0}  milliseconds", time));
        }
    }

    @GetMapping("/ktoc")
    public float convertKelvinToCelsius(@RequestParam(value = "kelvin") float kelvin) {

        Long time = System.currentTimeMillis();
        try {
            return conversionService.convertCelsiusToKelvin(kelvin);
        } finally {
            time = System.currentTimeMillis() - time;
            LOGGER.info(MessageFormat.format("Call took {0}  milliseconds", time));
        }
    }

    @GetMapping("/ktom")
    public double convertKmsToMiles(@RequestParam(value = "kms") double kms) {

        Long time = System.currentTimeMillis();
        try {
            return conversionService.convertKilosToMiles(kms);
        } finally {
            time = System.currentTimeMillis() - time;
            LOGGER.info(MessageFormat.format("Call took {0}  milliseconds", time));
        }
    }

    @GetMapping("/mtok")
    public double convertMilesToKms(@RequestParam(value = "miles") double miles) {

        Long time = System.currentTimeMillis();
        try {
            return conversionService.convertMilesToKilos(miles);
        } finally {
            time = System.currentTimeMillis() - time;
            LOGGER.info(MessageFormat.format("Call took {0}  milliseconds", time));
        }
    }
}
