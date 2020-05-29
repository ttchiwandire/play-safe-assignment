package com.playsafeholding.assignment.controllers;

import com.playsafeholding.assignment.services.ConversionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyFloat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Tatenda Chiwandire
 * Date: 2020/05/29
 * Time: 22:29
 */
@ExtendWith(MockitoExtension.class)
class ConversionControllerTest {

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private ConversionController conversionController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(conversionController).build();
    }


    @Test
    void convertCelciusToKelvin() throws Exception {

        //Set up fixtures
        when(conversionController.convertCelciusToKelvin(anyFloat())).thenReturn(74562.00f);

        //SUT
        mockMvc.perform(get("/conversion/ctok?celsius=400.45"))
                .andExpect(status().isOk())
                .andExpect(content().string("74562.0"));
    }

    @Test
    void convertKelvinToCelsius() throws Exception {
        //Set up fixtures
        when(conversionController.convertKelvinToCelsius(anyFloat())).thenReturn(74562.00f);

        //SUT
        mockMvc.perform(get("/conversion/ktoc?kelvin=400.45"))
                .andExpect(status().isOk())
                .andExpect(content().string("74562.0"));
    }

    @Test
    void convertKmsToMiles() throws Exception {
        //Set up fixtures
        when(conversionController.convertKmsToMiles(anyDouble())).thenReturn(74562.0);

        //SUT
        mockMvc.perform(get("/conversion/ktom?kms=400.45"))
                .andExpect(status().isOk())
                .andExpect(content().string("74562.0"));
    }

    @Test
    void convertMilesToKms() throws Exception {
        //Set up fixtures
        when(conversionController.convertMilesToKms(anyDouble())).thenReturn(74562.0);

        //SUT
        mockMvc.perform(get("/conversion/mtok?miles=400.45"))
                .andExpect(status().isOk())
                .andExpect(content().string("74562.0"));
    }
}