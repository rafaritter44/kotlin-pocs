package org.example.guitarfactory.domain

sealed class GuitarOS(val name: String) {
    object Analog : GuitarOS("Analog")
    object Digital : GuitarOS("Digital")
    data class Smart(val version: String) : GuitarOS("Smart v$version")
}