package com.ivoronline.springboot_demo_currencies.business.services;

import com.ivoronline.springboot_demo_currencies.business.entities.Currency;
import com.ivoronline.springboot_demo_currencies.business.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.Duration;
import java.util.List;

@Service
public class CurrencyService {

  @Autowired
  CurrencyRepository currencyRepository;

  //=========================================================================
  // STORE CURRENCIES
  //=========================================================================
  public void storeCurrencies(String url) {

    //LOG
    System.out.print(url + " ... ");

    //GET CURRENCIES FROM SERVER
    List<Currency> currencies = WebClient.create(url)
                                         .get()
                                         .retrieve()
                                         .bodyToFlux(Currency.class)
                                         .collectList()
                                         .block(Duration.ofMinutes(1));

    //REFORMAT EXCHANGE RATES
    for(Currency currency : currencies) {
      currency.exchangeRate = Double.parseDouble(currency.exchangeRateString.replace(",", "."));
    }

    //STORE CURRENCIES
    currencyRepository.saveAll(currencies);

    //LOG
    System.out.println("DONE");

  }

}
