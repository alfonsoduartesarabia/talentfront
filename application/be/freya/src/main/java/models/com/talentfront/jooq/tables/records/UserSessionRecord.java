/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables.records;


import com.talentfront.jooq.tables.UserSession;

import java.time.LocalDateTime;

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
        "schema version:5.1"
    },
    date = "2021-04-11T05:11:40.089Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserSessionRecord extends UpdatableRecordImpl<UserSessionRecord> implements Record4<Integer, Integer, String, LocalDateTime> {

    private static final long serialVersionUID = 1842531976;

    /**
     * Setter for <code>db.user_session.user_session_id</code>.
     */
    public void setUserSessionId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>db.user_session.user_session_id</code>.
     */
    public Integer getUserSessionId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>db.user_session.user_id</code>.
     */
    public void setUserId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>db.user_session.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>db.user_session.verification</code>.
     */
    public void setVerification(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>db.user_session.verification</code>.
     */
    public String getVerification() {
        return (String) get(2);
    }

    /**
     * Setter for <code>db.user_session.created_dt</code>.
     */
    public void setCreatedDt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>db.user_session.created_dt</code>.
     */
    public LocalDateTime getCreatedDt() {
        return (LocalDateTime) get(3);
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
    public Row4<Integer, Integer, String, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, Integer, String, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return UserSession.USER_SESSION.USER_SESSION_ID;
    }

    @Override
    public Field<Integer> field2() {
        return UserSession.USER_SESSION.USER_ID;
    }

    @Override
    public Field<String> field3() {
        return UserSession.USER_SESSION.VERIFICATION;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return UserSession.USER_SESSION.CREATED_DT;
    }

    @Override
    public Integer component1() {
        return getUserSessionId();
    }

    @Override
    public Integer component2() {
        return getUserId();
    }

    @Override
    public String component3() {
        return getVerification();
    }

    @Override
    public LocalDateTime component4() {
        return getCreatedDt();
    }

    @Override
    public Integer value1() {
        return getUserSessionId();
    }

    @Override
    public Integer value2() {
        return getUserId();
    }

    @Override
    public String value3() {
        return getVerification();
    }

    @Override
    public LocalDateTime value4() {
        return getCreatedDt();
    }

    @Override
    public UserSessionRecord value1(Integer value) {
        setUserSessionId(value);
        return this;
    }

    @Override
    public UserSessionRecord value2(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public UserSessionRecord value3(String value) {
        setVerification(value);
        return this;
    }

    @Override
    public UserSessionRecord value4(LocalDateTime value) {
        setCreatedDt(value);
        return this;
    }

    @Override
    public UserSessionRecord values(Integer value1, Integer value2, String value3, LocalDateTime value4) {
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
     * Create a detached UserSessionRecord
     */
    public UserSessionRecord() {
        super(UserSession.USER_SESSION);
    }

    /**
     * Create a detached, initialised UserSessionRecord
     */
    public UserSessionRecord(Integer userSessionId, Integer userId, String verification, LocalDateTime createdDt) {
        super(UserSession.USER_SESSION);

        set(0, userSessionId);
        set(1, userId);
        set(2, verification);
        set(3, createdDt);
    }
}
