/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq;


import com.talentfront.jooq.tables.Media;
import com.talentfront.jooq.tables.Notification;
import com.talentfront.jooq.tables.Posting;
import com.talentfront.jooq.tables.PostingRecommendation;
import com.talentfront.jooq.tables.UserEducation;
import com.talentfront.jooq.tables.UserExperience;
import com.talentfront.jooq.tables.UserInfo;
import com.talentfront.jooq.tables.UserPostingApply;
import com.talentfront.jooq.tables.UserRelationship;
import com.talentfront.jooq.tables.UserReview;

import javax.annotation.processing.Generated;

import org.jooq.Index;
import org.jooq.OrderField;
import org.jooq.impl.Internal;


/**
 * A class modelling indexes of tables of the <code>db</code> schema.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.2",
        "schema version:9.1"
    },
    date = "2021-05-08T19:27:48.680Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Indexes {

    // -------------------------------------------------------------------------
    // INDEX definitions
    // -------------------------------------------------------------------------

    public static final Index MEDIA_USER_ID_FK = Indexes0.MEDIA_USER_ID_FK;
    public static final Index NOTIFICATION_RECIEVER_ID_FK = Indexes0.NOTIFICATION_RECIEVER_ID_FK;
    public static final Index NOTIFICATION_SENDER_ID_FK = Indexes0.NOTIFICATION_SENDER_ID_FK;
    public static final Index POSTING_USER_ID_FK = Indexes0.POSTING_USER_ID_FK;
    public static final Index POSTING_RECOMMENDATION_POSTING_ID_FK = Indexes0.POSTING_RECOMMENDATION_POSTING_ID_FK;
    public static final Index POSTING_RECOMMENDATION_RECOMMENDEE_ID_FK = Indexes0.POSTING_RECOMMENDATION_RECOMMENDEE_ID_FK;
    public static final Index POSTING_RECOMMENDATION_RECOMMENDER_ID_FK = Indexes0.POSTING_RECOMMENDATION_RECOMMENDER_ID_FK;
    public static final Index USER_EDUCATION_USER_ID_FK = Indexes0.USER_EDUCATION_USER_ID_FK;
    public static final Index USER_EXPERIENCE_USER_ID_FK = Indexes0.USER_EXPERIENCE_USER_ID_FK;
    public static final Index USER_INFO_USER_ID_FK = Indexes0.USER_INFO_USER_ID_FK;
    public static final Index USER_POSTING_APPLY_POSTING_ID_FK = Indexes0.USER_POSTING_APPLY_POSTING_ID_FK;
    public static final Index USER_POSTING_APPLY_USER_ID_FK = Indexes0.USER_POSTING_APPLY_USER_ID_FK;
    public static final Index USER_RELATIONSHIP_USER_FOLLOWEE_ID_FK = Indexes0.USER_RELATIONSHIP_USER_FOLLOWEE_ID_FK;
    public static final Index USER_RELATIONSHIP_USER_FOLLOWER_ID_FK = Indexes0.USER_RELATIONSHIP_USER_FOLLOWER_ID_FK;
    public static final Index USER_REVIEW_REVIEWEE_ID_FK = Indexes0.USER_REVIEW_REVIEWEE_ID_FK;
    public static final Index USER_REVIEW_REVIEWER_ID_FK = Indexes0.USER_REVIEW_REVIEWER_ID_FK;

    // -------------------------------------------------------------------------
    // [#1459] distribute members to avoid static initialisers > 64kb
    // -------------------------------------------------------------------------

    private static class Indexes0 {
        public static Index MEDIA_USER_ID_FK = Internal.createIndex("user_id_fk", Media.MEDIA, new OrderField[] { Media.MEDIA.USER_ID }, false);
        public static Index NOTIFICATION_RECIEVER_ID_FK = Internal.createIndex("reciever_id_fk", Notification.NOTIFICATION, new OrderField[] { Notification.NOTIFICATION.RECIEVER_ID }, false);
        public static Index NOTIFICATION_SENDER_ID_FK = Internal.createIndex("sender_id_fk", Notification.NOTIFICATION, new OrderField[] { Notification.NOTIFICATION.SENDER_ID }, false);
        public static Index POSTING_USER_ID_FK = Internal.createIndex("user_id_fk", Posting.POSTING, new OrderField[] { Posting.POSTING.USER_ID }, false);
        public static Index POSTING_RECOMMENDATION_POSTING_ID_FK = Internal.createIndex("posting_id_fk", PostingRecommendation.POSTING_RECOMMENDATION, new OrderField[] { PostingRecommendation.POSTING_RECOMMENDATION.POSTING_ID }, false);
        public static Index POSTING_RECOMMENDATION_RECOMMENDEE_ID_FK = Internal.createIndex("recommendee_id_fk", PostingRecommendation.POSTING_RECOMMENDATION, new OrderField[] { PostingRecommendation.POSTING_RECOMMENDATION.RECOMMENDEE_ID }, false);
        public static Index POSTING_RECOMMENDATION_RECOMMENDER_ID_FK = Internal.createIndex("recommender_id_fk", PostingRecommendation.POSTING_RECOMMENDATION, new OrderField[] { PostingRecommendation.POSTING_RECOMMENDATION.RECOMMENDER_ID }, false);
        public static Index USER_EDUCATION_USER_ID_FK = Internal.createIndex("user_id_fk", UserEducation.USER_EDUCATION, new OrderField[] { UserEducation.USER_EDUCATION.USER_ID }, false);
        public static Index USER_EXPERIENCE_USER_ID_FK = Internal.createIndex("user_id_fk", UserExperience.USER_EXPERIENCE, new OrderField[] { UserExperience.USER_EXPERIENCE.USER_ID }, false);
        public static Index USER_INFO_USER_ID_FK = Internal.createIndex("user_id_fk", UserInfo.USER_INFO, new OrderField[] { UserInfo.USER_INFO.USER_ID }, false);
        public static Index USER_POSTING_APPLY_POSTING_ID_FK = Internal.createIndex("posting_id_fk", UserPostingApply.USER_POSTING_APPLY, new OrderField[] { UserPostingApply.USER_POSTING_APPLY.POSTING_ID }, false);
        public static Index USER_POSTING_APPLY_USER_ID_FK = Internal.createIndex("user_id_fk", UserPostingApply.USER_POSTING_APPLY, new OrderField[] { UserPostingApply.USER_POSTING_APPLY.APPLICANT_ID }, false);
        public static Index USER_RELATIONSHIP_USER_FOLLOWEE_ID_FK = Internal.createIndex("user_followee_id_fk", UserRelationship.USER_RELATIONSHIP, new OrderField[] { UserRelationship.USER_RELATIONSHIP.USER_FOLLOWEE_ID }, false);
        public static Index USER_RELATIONSHIP_USER_FOLLOWER_ID_FK = Internal.createIndex("user_follower_id_fk", UserRelationship.USER_RELATIONSHIP, new OrderField[] { UserRelationship.USER_RELATIONSHIP.USER_FOLLOWER_ID }, false);
        public static Index USER_REVIEW_REVIEWEE_ID_FK = Internal.createIndex("reviewee_id_fk", UserReview.USER_REVIEW, new OrderField[] { UserReview.USER_REVIEW.REVIEWEE_ID }, false);
        public static Index USER_REVIEW_REVIEWER_ID_FK = Internal.createIndex("reviewer_id_fk", UserReview.USER_REVIEW, new OrderField[] { UserReview.USER_REVIEW.REVIEWER_ID }, false);
    }
}
