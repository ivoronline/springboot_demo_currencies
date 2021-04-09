package com.ivoronline.springboot_demo_currencies.business.startup;

import com.ivoronline.springboot_demo_currencies.business.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class LoadHistory implements CommandLineRunner {

  @Autowired
  CurrencyService currencyService;

  @Value("${loadHistory}")
  private Boolean loadHistory;

  //=====================================================================================
  // RUN
  //=====================================================================================
  @Override
  public void run(String... args) throws Exception {

    //RETURN IF HISTORY SHOULD NOT BE LOADED
    if(!loadHistory) { return; }

    //LOG
    System.out.println("STARTED RUNNER: LoadHistory ----------------------------------");

    //CONSTRUCT URL
    Integer sleep       = 10 * 1000;                    //Sleep for 10 seconds
    Integer year        = 2015;                         //Start Date
    Date    currentDate = new Date();                   //To calculate current Year
    Integer yearEnd     = 1900 + currentDate.getYear(); //Current Year
    while(year <= yearEnd) {
      String url = "http://api.hnb.hr/tecajn/v2?datum-primjene-od=" + year + "-01-01&datum-primjene-do=" + year + "-12-31";
      currencyService.storeCurrencies(url);
      Thread.sleep(sleep);
      year++;
    }

    //LOG
    System.out.println("ENDED RUNNER: LoadHistory ----------------------------------");

  }

}
