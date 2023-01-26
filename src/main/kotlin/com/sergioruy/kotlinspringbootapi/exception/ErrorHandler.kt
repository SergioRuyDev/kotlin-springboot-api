package com.sergioruy.kotlinspringbootapi.exception

import org.springframework.http.ResponseEntity
import com.sergioruy.kotlinspringbootapi.dto.ErrorResponse
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalState(ex: IllegalStateException): ResponseEntity<ErrorResponse> {
        return ResponseEntity.badRequest().body(ErrorResponse(message = ex.localizedMessage))
    }

}
