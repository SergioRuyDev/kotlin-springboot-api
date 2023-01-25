package com.sergioruy.kotlinspringbootapi.mapper

interface Mapper <A, B>{
    fun mapper(source: A): B
}
