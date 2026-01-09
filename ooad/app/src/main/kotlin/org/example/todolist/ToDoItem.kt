package org.example.todolist

data class ToDoItem(val name: String) {
    private var done = false

    init {
        require(name.isNotBlank())
    }

    fun markDone() {
        done = true
    }
    fun redo() {
        done = false
    }
    fun isDone() = done

    override fun toString(): String =
        if (done) "[x] $name" else "[ ] $name"
}
