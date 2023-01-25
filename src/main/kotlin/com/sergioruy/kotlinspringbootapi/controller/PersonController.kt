package com.sergioruy.kotlinspringbootapi.controller

import com.sergioruy.kotlinspringbootapi.repository.PersonRepository
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/persons")
class PersonController(private val repository: PersonRepository) {



}
