package com.talentfront.freya.image

import org.springframework.stereotype.Component
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.util.zip.DataFormatException
import java.util.zip.Deflater
import java.util.zip.Inflater

@Component
class ImageCompressor {

    fun compressImage(data: ByteArray): ByteArray {
        val deflater = Deflater()
        deflater.setInput(data)
        deflater.finish()

        val outputStream = ByteArrayOutputStream(data.size)
        val buffer = ByteArray(1024)
        while (!deflater.finished()) {
            val count = deflater.deflate(buffer)
            outputStream.write(buffer, 0, count)
        }
        try {
            outputStream.close()
        } catch (e: IOException) {
        }

        return outputStream.toByteArray()
    }

    fun decompressBytes(data: ByteArray): ByteArray? {
        val inflater = Inflater()
        inflater.setInput(data)
        val outputStream = ByteArrayOutputStream(data.size)
        val buffer = ByteArray(1024)
        try {
            while (!inflater.finished()) {
                val count = inflater.inflate(buffer)
                outputStream.write(buffer, 0, count)
            }
            outputStream.close()
        } catch (ioe: IOException) {
        } catch (e: DataFormatException) {
        }
        return outputStream.toByteArray()
    }
}
