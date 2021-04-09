package com.ivoronline.springboot_demo_currencies.loggerDB.repositories;

import com.ivoronline.springboot_demo_currencies.loggerDB.entities.Log;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<Log, Integer> {  }
