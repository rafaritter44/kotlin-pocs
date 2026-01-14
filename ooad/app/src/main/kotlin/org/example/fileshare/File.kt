package org.example.fileshare

data class File(
    val path: String,
    val encryptedData: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as File

        if (path != other.path) return false
        if (!encryptedData.contentEquals(other.encryptedData)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = path.hashCode()
        result = 31 * result + encryptedData.contentHashCode()
        return result
    }
}
