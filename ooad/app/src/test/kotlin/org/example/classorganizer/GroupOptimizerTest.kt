package org.example.classorganizer

import kotlin.test.Test

class GroupOptimizerTest {
    @Test fun groupOptimizerWorks() {
        val students = listOf(
            Student("Alice", 5),
            Student("Bob", 4),
            Student("Charlie", 3),
            Student("David", 5),
            Student("Eve", 2),
            Student("Frank", 1),
            Student("Grace", 4),
            Student("Heidi", 3)
        )
        val groups = GroupOptimizer.createBalancedGroups(
            students = students,
            groupSize = 3
        )
        groups.forEach { group ->
            println("Group ${group.id}")
            group.students.forEach {
                println("  ${it.name} (skill ${it.skill})")
            }
            println("  Avg skill: %.2f\n".format(group.averageSkill()))
        }
    }
}