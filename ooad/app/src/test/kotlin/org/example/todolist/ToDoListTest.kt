package org.example.todolist

import kotlin.test.Test

class ToDoListTest {
    @Test fun toDoListWorks() {
        ToDoList.add("Milk")
        ToDoList.add("Eggs")
        ToDoList.add("Bread")
        ToDoList.markDone("Milk")
        ToDoList.markDone("Eggs")
        println(ToDoList.listAll())

        ToDoList.redo("Eggs")
        ToDoList.remove("Bread")
        println(ToDoList.listAll())
    }
}