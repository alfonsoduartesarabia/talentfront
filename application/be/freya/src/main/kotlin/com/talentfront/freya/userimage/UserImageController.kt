package com.talentfront.freya.userimage

import com.talentfront.freya.config.Routes.Companion.GET_USER_IMAGE
import com.talentfront.freya.config.Routes.Companion.USER_IMAGE_UPLOAD
import com.talentfront.freya.daos.UserImageDao
import com.talentfront.freya.image.ImageCompressor
import com.talentfront.freya.models.UserImage
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class UserImageController(
    private val userImageDao: UserImageDao,
    private val imageCompressor: ImageCompressor
) {

    @PostMapping(value = ["$USER_IMAGE_UPLOAD/{userId}"])
    fun uploadUserImage(
        @PathVariable userId: Int,
        image: MultipartFile
    ): ResponseEntity<*> {
        val data = imageCompressor.compressImage(image.bytes)
        val id = userImageDao.saveUserImage(
            UserImage(
                userId = userId,
                img = data,
                title = "Profile"
            )
        )
        return ResponseEntity.ok("looks good boss made img with id: $id")
    }

    @GetMapping(value = ["$GET_USER_IMAGE/{userId}"])
    fun getUserImage(@PathVariable userId: Int): ResponseEntity<*> {
        val userImage = userImageDao.getUserImage(userId)?.img
        if (userImage != null) {
            val data = imageCompressor.decompressBytes(userImage)
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(data)
        }
        return ResponseEntity.ok("No image found")
    }
}
