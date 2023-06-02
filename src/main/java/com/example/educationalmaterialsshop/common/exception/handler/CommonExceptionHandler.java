package com.example.educationalmaterialsshop.common.exception.handler;

import com.example.educationalmaterialsshop.common.exception.AlreadyExistsException;
import com.example.educationalmaterialsshop.common.exception.RecordNotFountException;
import com.example.educationalmaterialsshop.common.exception.handler.pojo.FieldErrorResponse;
import com.example.educationalmaterialsshop.common.exception.handler.pojo.TraceableErrorResponse;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Path;
import jakarta.validation.metadata.ConstraintDescriptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.internal.metadata.descriptor.ConstraintDescriptorImpl;
import org.hibernate.validator.internal.util.annotation.ConstraintAnnotationDescriptor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class CommonExceptionHandler {
//    private final Environment environment;
//
//    @ExceptionHandler({BindException.class})
//    @ResponseStatus(BAD_REQUEST)
//    List<FieldErrorResponse> handle(BindException ex) {
//        return Stream.concat(
//                ex.getBindingResult().getFieldErrors().stream()
//                        .map(fieldError -> FieldErrorResponse.builder()
//                                .field(fieldError.getField())
//                                .message(fieldError.getDefaultMessage())
//                                .code(fieldError.getCode())
//                                .build()
//                        ),
//                ex.getBindingResult().getGlobalErrors().stream()
//                        .map(globalError -> FieldErrorResponse.builder()
//                                .field(globalError.getObjectName())
//                                .message(globalError.getDefaultMessage())
//                                .code(globalError.getCode())
//                                .build())
//        ).toList();
//    }
//
//    @ExceptionHandler(MissingServletRequestParameterException.class)
//    @ResponseStatus(BAD_REQUEST)
//    FieldErrorResponse handle(MissingServletRequestParameterException ex) {
//        return FieldErrorResponse.builder()
//                .code("ParameterMissing")
//                .message(ex.getMessage())
//                .build();
//    }
//
//    @ExceptionHandler(ConstraintViolationException.class)
//    @ResponseStatus(BAD_REQUEST)
//    List<FieldErrorResponse> handle(ConstraintViolationException ex) {
//        return ex.getConstraintViolations().stream()
//                .map(constraintViolation -> FieldErrorResponse
//                        .builder()
//                        .field(extractField(constraintViolation.getPropertyPath()))
//                        .code(extractCode(constraintViolation.getConstraintDescriptor()))
//                        .message(constraintViolation.getMessage())
//                        .build())
//                .toList();
//    }
//
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    @ResponseStatus(BAD_REQUEST)
//    FieldErrorResponse handle(HttpMessageNotReadableException ex) {
//        return FieldErrorResponse.builder()
//                .message(ex.getMessage())
//                .code("InvalidRequest")
//                .build();
//    }
//
//    @ExceptionHandler(IllegalArgumentException.class)
//    @ResponseStatus(BAD_REQUEST)
//    FieldErrorResponse handle(IllegalArgumentException ex) {
//        return FieldErrorResponse.builder()
//                .message(ex.getMessage())
//                .code("IllegalArgument")
//                .build();
//    }
//
//    @ExceptionHandler(IllegalStateException.class)
//    @ResponseStatus(CONFLICT)
//    FieldErrorResponse handle(IllegalStateException ex) {
//        return FieldErrorResponse.builder()
//                .message(ex.getMessage())
//                .code("IllegalState")
//                .build();
//    }
//
//    @ExceptionHandler(URISyntaxException.class)
//    @ResponseStatus(BAD_REQUEST)
//    FieldErrorResponse handle(URISyntaxException ex) {
//        return FieldErrorResponse.builder()
//                .message(ex.getMessage())
//                .code("URISyntaxException")
//                .build();
//    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    FieldErrorResponse handle(RuntimeException ex) {
        return FieldErrorResponse.builder()
                .message(ex.getMessage())
                .code("Exception occured")
                .build();
    }

//    @ExceptionHandler(AlreadyExistsException.class)
//    @ResponseStatus(CONFLICT)
//    FieldErrorResponse handle(AlreadyExistsException ex) {
//        return FieldErrorResponse.builder()
//                .message(ex.getMessage())
//                .code("RecordAlreadyExist")
//                .build();
//    }
//
//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseStatus(FORBIDDEN)
//    FieldErrorResponse handle(AccessDeniedException ex) {
//        return FieldErrorResponse.builder()
//                .message(ex.getMessage())
//                .code("AccessDenied")
//                .build();
//    }
//
//    @ExceptionHandler(AuthenticationException.class)
//    @ResponseStatus(UNAUTHORIZED)
//    FieldErrorResponse handle(AuthenticationException ex) {
//        return FieldErrorResponse.builder()
//                .message(ex.getMessage())
//                .code("Authentication")
//                .build();
//    }
//
//
//    private boolean isNonProdEnv() {
//        return Arrays.stream(environment.getActiveProfiles())
//                .anyMatch(profile -> "dev".equals(profile) || "qa".equals(profile));
//    }
//
//    private String extractCode(ConstraintDescriptor<?> constraintDescriptor) {
//        ConstraintAnnotationDescriptor<?> annotationDescriptor = ((ConstraintDescriptorImpl<?>) constraintDescriptor).getAnnotationDescriptor();
//        Class<?> type = annotationDescriptor.getType();
//        return type.getName().replace(type.getPackageName(), "")
//                .replaceFirst("\\.", "");
//    }
//
//    private String extractField(Path propertyPath) {
//        String field = null;
//        for (Path.Node node : propertyPath) {
//            field = node.getName();
//        }
//
//        return field;
//    }
}
