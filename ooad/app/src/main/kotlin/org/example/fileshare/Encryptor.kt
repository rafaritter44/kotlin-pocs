package org.example.fileshare

import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class Encryptor(secret: String) {
    private val key = SecretKeySpec(secret.toByteArray(), "AES")

    fun encrypt(data: ByteArray): ByteArray {
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.ENCRYPT_MODE, key)
        return cipher.doFinal(data)
    }
    fun decrypt(data: ByteArray): ByteArray {
        val cipher = Cipher.getInstance("AES")
        cipher.init(Cipher.DECRYPT_MODE, key)
        return cipher.doFinal(data)
    }
}