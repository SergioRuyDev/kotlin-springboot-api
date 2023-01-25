package com.sergioruy.kotlinspringbootapi.repository

import com.sergioruy.kotlinspringbootapi.entities.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository : JpaRepository<Person, Long> {
}
