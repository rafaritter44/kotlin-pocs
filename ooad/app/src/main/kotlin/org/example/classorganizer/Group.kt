package org.example.classorganizer

data class Group(
    val id: Long,
    val students: MutableList<Student> = mutableListOf(),
) {
    fun totalSkill(): Int = students.sumOf { it.skill }
    fun averageSkill(): Double =
        if (students.isEmpty()) 0.0
        else totalSkill().toDouble() / students.size
}
