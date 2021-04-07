package com.talentfront.freya.daos

import com.talentfront.freya.models.UserImage
import com.talentfront.jooq.tables.UserImage.USER_IMAGE
import org.jooq.DSLContext
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class UserImageDao(
    private val dslContext: DSLContext
) {

    fun saveUserImage(userImage: UserImage): Int {
        val userImageRecord = dslContext.newRecord(USER_IMAGE).apply {
            userId = userImage.userId
            img = userImage.img
            title = userImage.title
            createdDt = LocalDateTime.now()
            contentType = userImage.contentType
        }
        userImageRecord.store()
        return userImageRecord.userImageId
    }

    fun getUserImage(userId: Int): UserImage? {
        val record = dslContext.select()
            .from(USER_IMAGE)
            .where(USER_IMAGE.USER_ID.eq(userId))
            .orderBy(USER_IMAGE.USER_IMAGE_ID.desc())
            .limit(1)
            .fetchOne() ?: return null
        val userImageRecord = record.into(USER_IMAGE)

        return if (record != null) {
            UserImage(id = userImageRecord.userImageId, userId = userImageRecord.userId, img = userImageRecord.img, title = userImageRecord.title, created_dt = userImageRecord.createdDt, contentType = userImageRecord.contentType)
        } else {
            null
        }
    }
}
