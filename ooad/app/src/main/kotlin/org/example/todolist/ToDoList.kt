package org.example.todolist

object ToDoList {
    private val items = mutableListOf<ToDoItem>()

    fun add(name: String) {
        require(items.none { it.name == name }) {
            "Item '$name' already exists."
        }
        items.add(ToDoItem(name))
    }
    fun remove(name: String) {
        items.removeIf { it.name == name }
    }
    fun markDone(name: String) {
        findItem(name)?.markDone()
    }
    fun redo(name: String) {
        findItem(name)?.redo()
    }
    fun listAll(): List<String> =
        items.map { it.toString() }

    private fun findItem(name: String): ToDoItem? =
        items.find { it.name == name }
}