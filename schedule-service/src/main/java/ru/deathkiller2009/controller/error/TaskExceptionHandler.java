package ru.deathkiller2009.controller.error;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.deathkiller2009.exception.TaskAlreadyExistsException;

import org.springframework.validation.BindException;
import java.util.Locale;
import java.util.NoSuchElementException;

@RestControllerAdvice
@RequiredArgsConstructor
public class TaskExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ProblemDetail> handleNoSuchElementException(NoSuchElementException exception, Locale locale) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, messageSource.getMessage(exception.getMessage(), new Object[]{}, locale));
        return ResponseEntity.badRequest()
                .body(problemDetail);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<ProblemDetail> handleBindException(BindException exception, Locale locale) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, messageSource.getMessage("error.validation.task", new Object[]{}, locale));
        problemDetail.setProperty("errors",  exception.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList());
        return ResponseEntity.badRequest()
                .body(problemDetail);
    }

    @ExceptionHandler(TaskAlreadyExistsException.class)
    public ResponseEntity<ProblemDetail> handleTaskAlreadyExistsException(TaskAlreadyExistsException exception, Locale locale) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, messageSource.getMessage(exception.getMessage(), new Object[]{}, locale));
        return ResponseEntity.badRequest()
                .body(problemDetail);
    }

}
