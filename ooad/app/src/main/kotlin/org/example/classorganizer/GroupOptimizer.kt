package org.example.classorganizer

object GroupOptimizer {
    fun createBalancedGroups(
        students: List<Student>,
        groupSize: Int,
    ): List<Group> {
        require(groupSize > 0)
        require(students.isNotEmpty())

        val numberOfGroups = (students.size + groupSize - 1) / groupSize
        val groups = (1..numberOfGroups)
            .map { Group(id = it) }
            .toMutableList()
        val sorted = students.sortedByDescending { it.skill }

        for (student in sorted) {
            val targetGroup = groups
                .filter { it.students.size < groupSize }
                .minByOrNull { it.totalSkill() }!!
            targetGroup.students.add(student)
        }

        return groups
    }
}