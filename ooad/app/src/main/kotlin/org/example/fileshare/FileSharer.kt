package org.example.fileshare

class FileSharer(secret: String) {
    private val encryptor = Encryptor(secret)
    private val files = mutableMapOf<String, File>()

    fun save(path: String, content: ByteArray) {
        val encryptedData = encryptor.encrypt(content)
        files[path] = File(path, encryptedData)
    }
    fun restore(path: String): ByteArray? {
        val file = files[path] ?: return null
        return encryptor.decrypt(file.encryptedData)
    }
    fun delete(path: String): Boolean {
        return files.remove(path) != null
    }
    fun list(): List<String> {
        return files.keys.toList()
    }
    fun search(query: String): List<String> {
        return files.keys
            .filter { it.contains(query, ignoreCase = true) }
    }
}