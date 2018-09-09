package com.strangengpuppies.strangengpuppies.service.Exception;

import java.time.DateTimeException;

public class DateParseException extends DateTimeException {
  public DateParseException(String message) {
    super(message);
  }
  
  public DateParseException(String message, Throwable cause) {
    super(message, cause);
  }
}
