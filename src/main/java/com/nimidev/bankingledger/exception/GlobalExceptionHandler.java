package com.nimidev.bankingledger.exception;

import com.nimidev.bankingledger.constants.HttpConstants;
import com.nimidev.bankingledger.dto.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;

import static com.nimidev.bankingledger.constants.ErrorConstant.INTERNAL_SERVER_ERROR;
import static com.nimidev.bankingledger.constants.ErrorConstant.ITEM_NOT_FOUND_ERROR;


@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResponse> handleException(Exception ex, WebRequest webRequest) {
    if (ex instanceof ItemNotFoundException) {
      return handleItemNotFoundError(ex, webRequest);
    } else if (ex instanceof BalanceNotSufficientException) {
      return handleBalanceNotSufficientException(ex, webRequest);
    } else if (ex instanceof SQLIntegrityConstraintViolationException) {
      return handleSQLIntegrityException(ex, webRequest);
    } else {
      return handleGenericException(ex, webRequest);
    }
  }

  private ResponseEntity<ExceptionResponse> handleItemNotFoundError(
      Exception ex, WebRequest webRequest) {
    return buildExceptionResponse(HttpStatus.NOT_FOUND, ITEM_NOT_FOUND_ERROR, ex, webRequest);
  }

  private ResponseEntity<ExceptionResponse> handleGenericException(
      Exception ex, WebRequest webRequest) {
    return buildExceptionResponse(
        HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR, ex, webRequest);
  }

  private ResponseEntity<ExceptionResponse> handleFileNotFoundException(
      Exception ex, WebRequest webRequest) {
    return buildExceptionResponse(
        HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR, ex, webRequest);
  }

  private ResponseEntity<ExceptionResponse> handleSQLIntegrityException(
          Exception ex, WebRequest webRequest) {
    return buildExceptionResponse(
            HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR, ex, webRequest);
  }

  private ResponseEntity<ExceptionResponse> handleBalanceNotSufficientException(Exception ex, WebRequest webRequest){
    return buildExceptionResponse(
            HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR, ex, webRequest);
  }

  private ResponseEntity<ExceptionResponse> buildExceptionResponse(
      HttpStatus httpStatus, String error, Throwable ex, WebRequest webRequest) {
    Date timestamp = new Date(System.currentTimeMillis());
    ExceptionResponse exceptionResponse =
        new ExceptionResponse(
            timestamp,
            httpStatus.toString(),
            error,
            ex.getMessage(),
            webRequest.getDescription(false).replace(HttpConstants.URL + "=", ""));
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpConstants.ACCEPT, HttpConstants.APPLICATION_JSON);
    log.error(ex.getMessage(), ex);
    return new ResponseEntity<>(exceptionResponse, headers, httpStatus);
  }
}
