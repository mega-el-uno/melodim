package com.monzoni.melodim_project.exception;


import com.monzoni.melodim_project.dto.response.artist.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.monzoni.melodim_project.util.constant.ResponseConstant.BadRequestResponse.BAD_REQUEST_EXCEPTION;


@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {
    @ResponseBody
    @ExceptionHandler(CommandException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CommonResponse> handleCommandException(CommandException exception) {
        log.error("CommandException: {}", exception.getMessage());
        return new ResponseEntity<>(new CommonResponse(BAD_REQUEST_EXCEPTION, exception.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(ProcessErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CommonResponse> handleProcessErrorException(ProcessErrorException exception) {
        log.error("ProcessErrorException: {}", exception.getMessage());
        return new ResponseEntity<>(new CommonResponse(BAD_REQUEST_EXCEPTION, exception.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ResponseBody
    @ExceptionHandler(EmployeeRestException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<CommonResponse> handleProcessErrorException(EmployeeRestException exception) {
        log.error("ProcessErrorException: {}", exception.getMessage());
        return new ResponseEntity<>(new CommonResponse(BAD_REQUEST_EXCEPTION, exception.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
