package com.example.motionlayoutproject.other

inline class DogId(val id: Int)
data class Dog(val id: DogId)

inline class CatId(val id: Int)
data class Cat(val id: CatId)


fun dog(id: DogId) {
    println("dog id = ${id.id}")
}

fun cat(id: CatId) {
    println("cat id = ${id.id}")
}

fun main() {
    dog(DogId(2))
    cat(CatId(3))
}