package com.sergioruy.kotlinspringbootapi.service

import com.sergioruy.kotlinspringbootapi.dto.PersonRequestDto
import com.sergioruy.kotlinspringbootapi.dto.PersonResponseDto
import com.sergioruy.kotlinspringbootapi.dto.UpdatePersonRequestDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PersonService {
    fun findById(id:Long): PersonResponseDto?
    fun findAll(pageable: Pageable): Page<PersonResponseDto>
    fun save(addPerson: PersonRequestDto): PersonResponseDto
    fun update(updatePersonRequestDto: UpdatePersonRequestDto): PersonResponseDto
    fun deleteById(id: Long)
}
