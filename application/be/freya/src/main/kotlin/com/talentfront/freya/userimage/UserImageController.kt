package com.talentfront.freya.userimage

import com.talentfront.freya.config.Routes.Companion.GET_USER_IMAGE
import com.talentfront.freya.config.Routes.Companion.USER_IMAGE_UPLOAD
import com.talentfront.freya.daos.UserImageDao
import com.talentfront.freya.image.ImageCompressor
import com.talentfront.freya.models.UserImage
import com.talentfront.freya.session.SessionService
import com.talentfront.freya.util.UserIdUtil
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class UserImageController(
    private val userImageDao: UserImageDao,
    private val imageCompressor: ImageCompressor,
    private val sessionService: SessionService,
    private val userIdUtil: UserIdUtil
) {

    @PostMapping(value = ["$USER_IMAGE_UPLOAD"])
    fun uploadUserImage(
        @CookieValue(value = SessionService.SESSION_COOKIE_NAME) cookieValue: String?,
        @RequestParam("cookie") cookie: String?,
        image: MultipartFile
    ): ResponseEntity<*> {
        val data = imageCompressor.compressImage(image.bytes)
        val realCookieValue = cookie ?: cookieValue
        val userIdFromCookie =
            sessionService.getValidUserIdFromCookie(realCookieValue) ?: return ResponseEntity.ok("expected cookie or path param")
        val id = userImageDao.saveUserImage(
            UserImage(
                userId = userIdFromCookie,
                img = data,
                title = "Profile",
                contentType = image.contentType
            )
        )
        return ResponseEntity.ok("looks good boss made img with id: $id")
    }

    @GetMapping(value = ["$GET_USER_IMAGE/{userId}", GET_USER_IMAGE])
    fun getUserImage(
        @PathVariable(required = false, value = "userId") pathUserId: Int?,
        @CookieValue(value = SessionService.SESSION_COOKIE_NAME) cookieValue: String?,
        @RequestParam("cookie") cookieQuery: String?,
    ): ResponseEntity<*> {
        if (cookieValue == null && cookieQuery == null && pathUserId == null) return ResponseEntity.ok("expected cookie or path param")
        val userId = userIdUtil.getUserId(pathUserId = pathUserId, cookieValue = cookieValue, cookieQuery = cookieQuery) ?: return ResponseEntity.ok("no user found")
        val userImage = userImageDao.getUserImage(userId)
        if (userImage?.img != null) {
            val data = imageCompressor.decompressBytes(userImage.img)
            val mediaType = when (userImage.contentType) {
                "image/png" -> MediaType.IMAGE_PNG
                "image/jpeg" -> MediaType.IMAGE_JPEG
                else -> MediaType.IMAGE_PNG
            }
            return ResponseEntity.ok().contentType(mediaType).body(data)
        }
        val defaultImage = javaClass.getClassLoader().getResourceAsStream("x.png")!!.readBytes()
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(defaultImage)
    }
}
