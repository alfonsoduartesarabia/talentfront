/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables.records;


import com.talentfront.jooq.tables.UserInfo;

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
        "schema version:3.1"
    },
    date = "2021-03-15T00:48:38.982Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserInfoRecord extends UpdatableRecordImpl<UserInfoRecord> implements Record4<Integer, String, Integer, String> {

    private static final long serialVersionUID = -932895397;

    /**
     * Setter for <code>db.user_info.user_info_id</code>.
     */
    public void setUserInfoId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>db.user_info.user_info_id</code>.
     */
    public Integer getUserInfoId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>db.user_info.description</code>.
     */
    public void setDescription(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>db.user_info.description</code>.
     */
    public String getDescription() {
        return (String) get(1);
    }

    /**
     * Setter for <code>db.user_info.user_id</code>.
     */
    public void setUserId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>db.user_info.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>db.user_info.user_info_type</code>.
     */
    public void setUserInfoType(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>db.user_info.user_info_type</code>.
     */
    public String getUserInfoType() {
        return (String) get(3);
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
    public Row4<Integer, String, Integer, String> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, String, Integer, String> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return UserInfo.USER_INFO.USER_INFO_ID;
    }

    @Override
    public Field<String> field2() {
        return UserInfo.USER_INFO.DESCRIPTION;
    }

    @Override
    public Field<Integer> field3() {
        return UserInfo.USER_INFO.USER_ID;
    }

    @Override
    public Field<String> field4() {
        return UserInfo.USER_INFO.USER_INFO_TYPE;
    }

    @Override
    public Integer component1() {
        return getUserInfoId();
    }

    @Override
    public String component2() {
        return getDescription();
    }

    @Override
    public Integer component3() {
        return getUserId();
    }

    @Override
    public String component4() {
        return getUserInfoType();
    }

    @Override
    public Integer value1() {
        return getUserInfoId();
    }

    @Override
    public String value2() {
        return getDescription();
    }

    @Override
    public Integer value3() {
        return getUserId();
    }

    @Override
    public String value4() {
        return getUserInfoType();
    }

    @Override
    public UserInfoRecord value1(Integer value) {
        setUserInfoId(value);
        return this;
    }

    @Override
    public UserInfoRecord value2(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public UserInfoRecord value3(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public UserInfoRecord value4(String value) {
        setUserInfoType(value);
        return this;
    }

    @Override
    public UserInfoRecord values(Integer value1, String value2, Integer value3, String value4) {
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
     * Create a detached UserInfoRecord
     */
    public UserInfoRecord() {
        super(UserInfo.USER_INFO);
    }

    /**
     * Create a detached, initialised UserInfoRecord
     */
    public UserInfoRecord(Integer userInfoId, String description, Integer userId, String userInfoType) {
        super(UserInfo.USER_INFO);

        set(0, userInfoId);
        set(1, description);
        set(2, userId);
        set(3, userInfoType);
    }
}