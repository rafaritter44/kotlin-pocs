package org.example.guitarfactory

import org.example.guitarfactory.domain.Guitar
import java.util.UUID

object Inventory {
    private val guitars = mutableMapOf<UUID, Guitar>()

    fun add(guitar: Guitar) {
        guitars[guitar.id] = guitar
    }
    fun remove(guitar: Guitar) {
        guitars.remove(guitar.id)
    }
    fun get(id: UUID): Guitar? = guitars[id]

    val all: List<Guitar>
        get() = guitars.values.toList()
}