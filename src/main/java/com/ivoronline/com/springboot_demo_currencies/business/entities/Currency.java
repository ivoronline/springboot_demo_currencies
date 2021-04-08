package com.ivoronline.com.springboot_demo_currencies.business.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;
import java.time.LocalDate;

@Entity
@IdClass(CurrencyId.class)
public class Currency {

  //COMPOSITE PRIMARY KEY
  @Id @JsonProperty("valuta")         public String    currencyName;
  @Id @JsonProperty("datum_primjene") public LocalDate date;

  //STORED PROPERTIES
  @JsonProperty("broj_tecajnice")     public Integer   number;
  @JsonProperty("drzava")             public String    state;
  @JsonProperty("drzava_iso")         public String    stateISO;
  @JsonProperty("sifra_valute")       public String    currencyCode;
  @JsonProperty("jedinica")           public Integer   units;
                                      public Double    exchangeRate;     //Decimal point "7.65"

  //TRANSIENT PROPERTIES
  @Transient
  @JsonProperty("srednji_tecaj")      public String exchangeRateString;  //Decimal comma "7,65"

}
