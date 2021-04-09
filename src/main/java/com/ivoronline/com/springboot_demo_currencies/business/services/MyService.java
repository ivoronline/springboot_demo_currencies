package com.ivoronline.com.springboot_demo_currencies.business.services;

import com.ivoronline.com.springboot_demo_currencies.business.dto.AverageDTOResponse;
import com.ivoronline.com.springboot_demo_currencies.business.dto.CurrenciesDTOResponse;
import com.ivoronline.com.springboot_demo_currencies.business.dto.DatesDTOResponse;
import org.springframework.stereotype.Component;

@Component
public interface MyService {
  CurrenciesDTOResponse getAllCurrencyNames();
  DatesDTOResponse getFirstLastDate(String currencyName);
  AverageDTOResponse getAverageValue(String currencyName, String startDate, String endDate);
}
