package com.sergioruy.kotlinspringbootapi.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime

data class ErrorResponse(
    val title: String = "Bad Request", val message: String, @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss")
    val dateTime: LocalDateTime = LocalDateTime.now())
