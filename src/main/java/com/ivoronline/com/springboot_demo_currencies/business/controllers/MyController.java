package com.ivoronline.com.springboot_demo_currencies.business.controllers;

import com.ivoronline.com.springboot_demo_currencies.business.dto.AverageDTOResponse;
import com.ivoronline.com.springboot_demo_currencies.business.dto.CurrenciesDTOResponse;
import com.ivoronline.com.springboot_demo_currencies.business.dto.DatesDTOResponse;
import com.ivoronline.com.springboot_demo_currencies.business.services.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class MyController {

  @Autowired MyService myService;

  //================================================================================
  // GET ALL CURRENCY NAMES
  //=================================================================================
  @ResponseBody
  @RequestMapping("/GetAllCurrencyNames")
  public CurrenciesDTOResponse getAllCurrencyNames()  {
    return myService.getAllCurrencyNames();
  }

  //================================================================================
  // GET FIRST LAST DATE
  //================================================================================
  @ResponseBody
  @RequestMapping("/GetFirstLastDate")
  public DatesDTOResponse getFirstLastDate(@RequestParam String currencyName)  {
    return myService.getFirstLastDate(currencyName);
  }

  //================================================================================
  // GET AVERAGE VALUE
  //================================================================================
  @ResponseBody
  @RequestMapping("/GetAverageValue")
  public AverageDTOResponse getAverageValue(
    @RequestParam String currencyName,
    @RequestParam String startDate,
    @RequestParam String endDate
  )  {
    return myService.getAverageValue(currencyName, startDate, endDate);
  }

}
