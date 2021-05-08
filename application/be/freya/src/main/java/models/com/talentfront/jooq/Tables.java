/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq;


import com.talentfront.jooq.tables.Media;
import com.talentfront.jooq.tables.Notification;
import com.talentfront.jooq.tables.Posting;
import com.talentfront.jooq.tables.PostingRecommendation;
import com.talentfront.jooq.tables.PostingRequirement;
import com.talentfront.jooq.tables.User;
import com.talentfront.jooq.tables.UserCompany;
import com.talentfront.jooq.tables.UserEducation;
import com.talentfront.jooq.tables.UserExperience;
import com.talentfront.jooq.tables.UserImage;
import com.talentfront.jooq.tables.UserInfo;
import com.talentfront.jooq.tables.UserPostingApply;
import com.talentfront.jooq.tables.UserRelationship;
import com.talentfront.jooq.tables.UserReview;
import com.talentfront.jooq.tables.UserSession;
import com.talentfront.jooq.tables.UserSkill;
import com.talentfront.jooq.tables.UserType;

import javax.annotation.processing.Generated;


/**
 * Convenience access to all tables in db
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.2",
        "schema version:9.1"
    },
    date = "2021-05-08T18:12:30.804Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>db.media</code>.
     */
    public static final Media MEDIA = Media.MEDIA;

    /**
     * The table <code>db.notification</code>.
     */
    public static final Notification NOTIFICATION = Notification.NOTIFICATION;

    /**
     * The table <code>db.posting</code>.
     */
    public static final Posting POSTING = Posting.POSTING;

    /**
     * The table <code>db.posting_recommendation</code>.
     */
    public static final PostingRecommendation POSTING_RECOMMENDATION = PostingRecommendation.POSTING_RECOMMENDATION;

    /**
     * The table <code>db.posting_requirement</code>.
     */
    public static final PostingRequirement POSTING_REQUIREMENT = PostingRequirement.POSTING_REQUIREMENT;

    /**
     * The table <code>db.user</code>.
     */
    public static final User USER = User.USER;

    /**
     * The table <code>db.user_company</code>.
     */
    public static final UserCompany USER_COMPANY = UserCompany.USER_COMPANY;

    /**
     * The table <code>db.user_education</code>.
     */
    public static final UserEducation USER_EDUCATION = UserEducation.USER_EDUCATION;

    /**
     * The table <code>db.user_experience</code>.
     */
    public static final UserExperience USER_EXPERIENCE = UserExperience.USER_EXPERIENCE;

    /**
     * The table <code>db.user_image</code>.
     */
    public static final UserImage USER_IMAGE = UserImage.USER_IMAGE;

    /**
     * The table <code>db.user_info</code>.
     */
    public static final UserInfo USER_INFO = UserInfo.USER_INFO;

    /**
     * The table <code>db.user_posting_apply</code>.
     */
    public static final UserPostingApply USER_POSTING_APPLY = UserPostingApply.USER_POSTING_APPLY;

    /**
     * The table <code>db.user_relationship</code>.
     */
    public static final UserRelationship USER_RELATIONSHIP = UserRelationship.USER_RELATIONSHIP;

    /**
     * The table <code>db.user_review</code>.
     */
    public static final UserReview USER_REVIEW = UserReview.USER_REVIEW;

    /**
     * The table <code>db.user_session</code>.
     */
    public static final UserSession USER_SESSION = UserSession.USER_SESSION;

    /**
     * The table <code>db.user_skill</code>.
     */
    public static final UserSkill USER_SKILL = UserSkill.USER_SKILL;

    /**
     * The table <code>db.user_type</code>.
     */
    public static final UserType USER_TYPE = UserType.USER_TYPE;
}
