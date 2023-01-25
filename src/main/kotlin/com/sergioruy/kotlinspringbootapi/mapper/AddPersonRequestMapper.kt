package com.sergioruy.kotlinspringbootapi.mapper

import com.sergioruy.kotlinspringbootapi.dto.PersonRequestDto
import com.sergioruy.kotlinspringbootapi.entities.Person
import org.springframework.stereotype.Component

@Component
class AddPersonRequestMapper: Mapper<PersonRequestDto, Person> {
    override fun mapper(source: PersonRequestDto): Person {
        return Person(
                firstName = source.firstName,
                lastName = source.lastName,
                jobPosition = source.jobPosition
        )
    }
}
