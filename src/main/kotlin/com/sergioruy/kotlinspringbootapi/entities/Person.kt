package com.sergioruy.kotlinspringbootapi.entities

import jakarta.persistence.*

@Entity
class Person (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var firstName: String,
    var lastName: String,
    var jobPosition: String? = null
)
