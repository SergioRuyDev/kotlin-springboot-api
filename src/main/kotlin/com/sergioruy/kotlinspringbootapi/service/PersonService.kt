package com.sergioruy.kotlinspringbootapi.service

import com.sergioruy.kotlinspringbootapi.dto.PersonResponseDto
import com.sergioruy.kotlinspringbootapi.entities.Person
import org.springframework.data.domain.Page
import java.awt.print.Pageable

interface PersonService {
    fun findById(id:Long): PersonResponseDto?
    fun findAll(pageable: Pageable): Page<PersonResponseDto>
    fun save(addPerson: )
}
