package com.sergioruy.kotlinspringbootapi.controller

import com.sergioruy.kotlinspringbootapi.controller.PersonController.Companion.BASE_PERSON_URL
import com.sergioruy.kotlinspringbootapi.dto.PersonRequestDto
import com.sergioruy.kotlinspringbootapi.dto.PersonResponseDto
import com.sergioruy.kotlinspringbootapi.dto.UpdatePersonRequestDto
import com.sergioruy.kotlinspringbootapi.service.PersonServiceImpl
import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping

@RestController
@RequestMapping(value = [BASE_PERSON_URL])
class PersonController(private val personServiceImpl: PersonServiceImpl) {

    @GetMapping
    fun findAll(pageable: Pageable): ResponseEntity<Page<PersonResponseDto>> {
        return ResponseEntity.ok(this.personServiceImpl.findAll(pageable))
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<PersonResponseDto?> {
        val personResponseDto: PersonResponseDto? = this.personServiceImpl.findById(id)
        return ResponseEntity.ok(personResponseDto)
    }

    @PostMapping
    fun save(@RequestBody personRequestDto: PersonRequestDto): ResponseEntity<PersonResponseDto> {
        val personResponseDto = this.personServiceImpl.save(personRequestDto)
        return ResponseEntity(personResponseDto, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updatePersonRequestDto: UpdatePersonRequestDto): ResponseEntity<PersonResponseDto> {
        return ResponseEntity.ok(this.personServiceImpl.update(updatePersonRequestDto))
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
        this.personServiceImpl.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    companion object {
        const val BASE_PERSON_URL: String = "/api/v1/persons"
    }
}
