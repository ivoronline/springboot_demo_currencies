package com.ivoronline.springboot_demo_currencies.loggerDB.filters;

import com.ivoronline.springboot_demo_currencies.loggerDB.entities.Log;
import com.ivoronline.springboot_demo_currencies.loggerDB.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@Component
public class LogFilter extends OncePerRequestFilter {

  @Autowired LogRepository logRepository;

  @Override
  public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
    throws IOException, ServletException {

    //DIVIDES HTTP REQUEST AND RESPONSE CODE
    chain.doFilter(request, response);

    //GET USERNAME
    String username;
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal instanceof UserDetails) { username = ((UserDetails)principal).getUsername(); }
    else                                  { username = principal.toString();                   }

    //CREATE LOG
    Log log             = new Log();
        log.username    = username;
        log.date        = LocalDate.now();
        log.protocol    = request.getProtocol();
        log.serverName  = request.getServerName();
        log.serverPort  = request.getServerPort();
        log.servletPath = request.getServletPath();
        log.queryString = request.getQueryString();
        log.method      = request.getMethod();
        log.status      = response.getStatus();

    //STORE LOG
    logRepository.save(log);

  }

}
