package com.sergioruy.kotlinspringbootapi.service

import com.sergioruy.kotlinspringbootapi.dto.PersonRequestDto
import com.sergioruy.kotlinspringbootapi.dto.PersonResponseDto
import com.sergioruy.kotlinspringbootapi.entities.Person
import com.sergioruy.kotlinspringbootapi.mapper.AddPersonRequestMapper
import com.sergioruy.kotlinspringbootapi.mapper.toPersonResponse
import com.sergioruy.kotlinspringbootapi.repository.PersonRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PersonServiceImpl(private val personRepository: PersonRepository,
                        private val addPersonRequestMapper: AddPersonRequestMapper) : PersonService {

    override fun findById(id: Long): PersonResponseDto? {
        TODO("Not yet implemented")
    }

    override fun findAll(pageable: Pageable): Page<PersonResponseDto> = this.personRepository.findAll(pageable)
            .map(Person::toPersonResponse)

    override fun save(addPerson: PersonRequestDto): PersonResponseDto {
        return this.saveOrUpdate(
                addPersonRequestMapper.mapper(addPerson)
        )
    }

    override fun update(updatePersonRequestDto: PersonRequestDto): PersonResponseDto {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }

    private fun findPersonById(id: Long): Person? = this.personRepository.findByIdOrNull(id)

    private fun saveOrUpdate(person: Person): PersonResponseDto = this.personRepository.save(person).toPersonResponse()
}
