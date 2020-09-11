package com.widson.creditanalysis.exceptionhandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// @ControllerAdvice caso algum controller gere uma excessão, elas serão tratadas pelos mótodos desta classe
// ResponseEntityExceptionHandler é uma classe que já tem vários tratamentos de excessão

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

}
