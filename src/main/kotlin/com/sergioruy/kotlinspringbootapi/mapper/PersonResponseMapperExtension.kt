package com.sergioruy.kotlinspringbootapi.mapper

import com.sergioruy.kotlinspringbootapi.dto.PersonResponseDto
import com.sergioruy.kotlinspringbootapi.entities.Person

fun Person?.toPersonResponse(): PersonResponseDto {
    return PersonResponseDto(
            id = this?.id ?: 1L,
            fullName = "${this?.lastName}, ${this?.firstName}",
            jobPosition = "${this?.jobPosition}"
    )
}
