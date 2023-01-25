package com.sergioruy.kotlinspringbootapi.controller

import com.sergioruy.kotlinspringbootapi.controller.PersonController.Companion.BASE_PERSON_URL
import com.sergioruy.kotlinspringbootapi.dto.PersonRequestDto
import com.sergioruy.kotlinspringbootapi.dto.PersonResponseDto
import com.sergioruy.kotlinspringbootapi.service.PersonServiceImpl
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping

@RestController
@RequestMapping(value = [BASE_PERSON_URL])
class PersonController(private val personServiceImpl: PersonServiceImpl) {

    @GetMapping
    fun findAll(pageable: Pageable): ResponseEntity<Page<PersonResponseDto>> {
        return ResponseEntity.ok(this.personServiceImpl.findAll(pageable))
    }

    @PostMapping
    fun save(@RequestBody personRequestDto: PersonRequestDto): ResponseEntity<PersonResponseDto> {
        val personResponseDto = this.personServiceImpl.save(personRequestDto)
        return ResponseEntity.ok(personResponseDto)
    }

    companion object {
        const val BASE_PERSON_URL: String = "/api/v1/persons"
    }
}
