package org.example.fileshare

import kotlin.test.Test

class FileSharerTest {
    @Test fun fileSharerWorks() {
        val fs = FileSharer("secret1234567890")
        val path1 = "/Users/rafael/notes-2025-12.txt"
        val path2 = "/Users/rafael/notes-2026-01.txt"
        val path3 = "/Users/rafael/notes-2026-02.txt"
        fs.save(path1, "Hello 1!".toByteArray())
        fs.save(path2, "Hello 2!".toByteArray())
        fs.save(path3, "Hello 3!".toByteArray())
        println(fs.restore(path1)?.decodeToString())
        println(fs.restore("/Users/rafael/nonexistent-file.txt") ?: "File not found.")
        println(fs.search("notes-2026"))
        println(fs.delete(path2))
        println(fs.list())
    }
}