package org.example.guitarfactory.domain

data class GuitarSpecs(
    val numberOfStrings: Int,
    val color: String,
) {
    init {
        require(numberOfStrings > 0)
        require(color.isNotBlank())
    }
}