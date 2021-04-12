/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables.records;


import com.talentfront.jooq.tables.UserRelationship;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record4;
import org.jooq.Row4;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.2",
        "schema version:8.1"
    },
    date = "2021-04-12T08:11:55.614Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRelationshipRecord extends UpdatableRecordImpl<UserRelationshipRecord> implements Record4<Integer, String, Integer, Integer> {

    private static final long serialVersionUID = -403948889;

    /**
     * Setter for <code>db.user_relationship.user_relationship_id</code>.
     */
    public void setUserRelationshipId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>db.user_relationship.user_relationship_id</code>.
     */
    public Integer getUserRelationshipId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>db.user_relationship.relationship_type</code>.
     */
    public void setRelationshipType(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>db.user_relationship.relationship_type</code>.
     */
    public String getRelationshipType() {
        return (String) get(1);
    }

    /**
     * Setter for <code>db.user_relationship.user_follower_id</code>.
     */
    public void setUserFollowerId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>db.user_relationship.user_follower_id</code>.
     */
    public Integer getUserFollowerId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>db.user_relationship.user_followee_id</code>.
     */
    public void setUserFolloweeId(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>db.user_relationship.user_followee_id</code>.
     */
    public Integer getUserFolloweeId() {
        return (Integer) get(3);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record4 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, Integer, Integer> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return UserRelationship.USER_RELATIONSHIP.USER_RELATIONSHIP_ID;
    }

    @Override
    public Field<String> field2() {
        return UserRelationship.USER_RELATIONSHIP.RELATIONSHIP_TYPE;
    }

    @Override
    public Field<Integer> field3() {
        return UserRelationship.USER_RELATIONSHIP.USER_FOLLOWER_ID;
    }

    @Override
    public Field<Integer> field4() {
        return UserRelationship.USER_RELATIONSHIP.USER_FOLLOWEE_ID;
    }

    @Override
    public Integer component1() {
        return getUserRelationshipId();
    }

    @Override
    public String component2() {
        return getRelationshipType();
    }

    @Override
    public Integer component3() {
        return getUserFollowerId();
    }

    @Override
    public Integer component4() {
        return getUserFolloweeId();
    }

    @Override
    public Integer value1() {
        return getUserRelationshipId();
    }

    @Override
    public String value2() {
        return getRelationshipType();
    }

    @Override
    public Integer value3() {
        return getUserFollowerId();
    }

    @Override
    public Integer value4() {
        return getUserFolloweeId();
    }

    @Override
    public UserRelationshipRecord value1(Integer value) {
        setUserRelationshipId(value);
        return this;
    }

    @Override
    public UserRelationshipRecord value2(String value) {
        setRelationshipType(value);
        return this;
    }

    @Override
    public UserRelationshipRecord value3(Integer value) {
        setUserFollowerId(value);
        return this;
    }

    @Override
    public UserRelationshipRecord value4(Integer value) {
        setUserFolloweeId(value);
        return this;
    }

    @Override
    public UserRelationshipRecord values(Integer value1, String value2, Integer value3, Integer value4) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRelationshipRecord
     */
    public UserRelationshipRecord() {
        super(UserRelationship.USER_RELATIONSHIP);
    }

    /**
     * Create a detached, initialised UserRelationshipRecord
     */
    public UserRelationshipRecord(Integer userRelationshipId, String relationshipType, Integer userFollowerId, Integer userFolloweeId) {
        super(UserRelationship.USER_RELATIONSHIP);

        set(0, userRelationshipId);
        set(1, relationshipType);
        set(2, userFollowerId);
        set(3, userFolloweeId);
    }
}
