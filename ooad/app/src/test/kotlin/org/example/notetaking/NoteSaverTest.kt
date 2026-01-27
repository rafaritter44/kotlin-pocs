package org.example.notetaking

import kotlin.test.Test

class NoteSaverTest {
    @Test fun noteSaverWorks() {
        val id = NoteSaver.add("Note 1")
        println(NoteSaver.edit(id, content = "Some content"))
        NoteSaver.save()
        NoteSaver.delete(id)
        println(NoteSaver.viewAll())
        NoteSaver.sync()
        println(NoteSaver.viewAll())
    }
}