package com.carlos.filipe.controllerusercar.exception.exceptionHandler;

import com.carlos.filipe.controllerusercar.exception.BadRequestException;
import com.carlos.filipe.controllerusercar.exception.BusinessException;
import com.carlos.filipe.controllerusercar.exception.EntityNotFoundException;
import feign.FeignException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> HandleUserNotFound(BadRequestException ex, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        var problem = new Problems();
        problem.setStatus(status.value());
        problem.setLabel(ex.getMessage());
        problem.setDateTime(OffsetDateTime.now());
        return handleExceptionInternal(ex, problem,new HttpHeaders(), status, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> HandleUserNotFound(EntityNotFoundException ex, WebRequest request) {
        var status = HttpStatus.NOT_FOUND;

        var problem = new Problems();
        problem.setStatus(status.value());
        problem.setLabel(ex.getMessage());
        problem.setDateTime(OffsetDateTime.now());
        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> HandleNegocio(BusinessException ex, WebRequest request) {
        var status = HttpStatus.BAD_REQUEST;

        var problem = new Problems();
        problem.setStatus(status.value());
        problem.setLabel(ex.getMessage());
        problem.setDateTime(OffsetDateTime.now());
        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<Object> HandleFeign(FeignException ex, HttpStatus status, WebRequest request) {
        var problem = new Problems();
        problem.setStatus(ex.status());
        problem.setLabel(ex.getMessage());
        problem.setDateTime(OffsetDateTime.now());
        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        var fields = new ArrayList<Problems.Field>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());

            fields.add(new Problems.Field(nome, mensagem));
        }

        var problem = new Problems();
        problem.setStatus(status.value());
        problem.setLabel("Um ou mais campos estão inválidos.");
        problem.setDateTime(OffsetDateTime.now());
        problem.setFields(fields);

        return super.handleExceptionInternal(ex, problem, headers, status, request);
    }
}
