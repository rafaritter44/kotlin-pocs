package org.example.guitarfactory

import java.util.UUID

data class Guitar(
    val id: UUID = UUID.randomUUID(),
    val model: GuitarModel,
    val specs: GuitarSpecs,
    val os: GuitarOS,
)
