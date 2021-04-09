package com.ivoronline.springboot_demo_currencies.business.controllers;

import com.ivoronline.springboot_demo_currencies.business.repositories.CurrencyRepository;
import com.ivoronline.springboot_demo_currencies.business.services.MyService;
import com.ivoronline.springboot_demo_currencies.loggerDB.repositories.LogRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = MyController.class)
class MyControllerTest {

  @Autowired MockMvc           mockMvc;
  @Autowired MyController      myController;

  @MockBean MyService          myService;
  @MockBean CurrencyRepository currencyRepository;
  @MockBean LogRepository      logRepository;

  //===================================================================================
  // TEST  ENDPOINT URL: GET MyService
  //===================================================================================
  @Test
  void getAllCurrencyNames() throws Exception {
    mockMvc.perform(get("/GetAllCurrencyNames")).andExpect(status().isOk());
  }

  //===================================================================================
  // TEST  ENDPOINT URL: GET GetFirstLastDate
  //===================================================================================
  @Test
  void GetFirstLastDate() throws Exception {
    mockMvc.perform(get("/GetFirstLastDate?currencyName=EUR")).andExpect(status().isOk());
  }

  //===================================================================================
  // TEST  ENDPOINT URL: GET GetAverageValue
  //===================================================================================
  @Test
  void GetAverageValue() throws Exception {
    mockMvc.perform(get("/GetAverageValue?currencyName=EUR&startDate=2000-05-30&endDate=2010-05-30")).andExpect(status().isOk());
  }

}