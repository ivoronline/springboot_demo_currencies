package com.ivoronline.com.springboot_demo_currencies.business.repositories;

import com.ivoronline.com.springboot_demo_currencies.business.entities.Currency;
import com.ivoronline.com.springboot_demo_currencies.business.entities.CurrencyId;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, CurrencyId> { }


