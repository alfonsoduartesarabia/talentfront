/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables.records;


import com.talentfront.jooq.tables.UserPostingApply;

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
        "schema version:9.1"
    },
    date = "2021-04-14T18:06:43.912Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserPostingApplyRecord extends UpdatableRecordImpl<UserPostingApplyRecord> implements Record4<Integer, Integer, Integer, LocalDateTime> {

    private static final long serialVersionUID = -667698897;

    /**
     * Setter for <code>db.user_posting_apply.user_posting_apply_id</code>.
     */
    public void setUserPostingApplyId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>db.user_posting_apply.user_posting_apply_id</code>.
     */
    public Integer getUserPostingApplyId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>db.user_posting_apply.applicant_id</code>.
     */
    public void setApplicantId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>db.user_posting_apply.applicant_id</code>.
     */
    public Integer getApplicantId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>db.user_posting_apply.posting_id</code>.
     */
    public void setPostingId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>db.user_posting_apply.posting_id</code>.
     */
    public Integer getPostingId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>db.user_posting_apply.created_dt</code>.
     */
    public void setCreatedDt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>db.user_posting_apply.created_dt</code>.
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
    public Row4<Integer, Integer, Integer, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    @Override
    public Row4<Integer, Integer, Integer, LocalDateTime> valuesRow() {
        return (Row4) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return UserPostingApply.USER_POSTING_APPLY.USER_POSTING_APPLY_ID;
    }

    @Override
    public Field<Integer> field2() {
        return UserPostingApply.USER_POSTING_APPLY.APPLICANT_ID;
    }

    @Override
    public Field<Integer> field3() {
        return UserPostingApply.USER_POSTING_APPLY.POSTING_ID;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return UserPostingApply.USER_POSTING_APPLY.CREATED_DT;
    }

    @Override
    public Integer component1() {
        return getUserPostingApplyId();
    }

    @Override
    public Integer component2() {
        return getApplicantId();
    }

    @Override
    public Integer component3() {
        return getPostingId();
    }

    @Override
    public LocalDateTime component4() {
        return getCreatedDt();
    }

    @Override
    public Integer value1() {
        return getUserPostingApplyId();
    }

    @Override
    public Integer value2() {
        return getApplicantId();
    }

    @Override
    public Integer value3() {
        return getPostingId();
    }

    @Override
    public LocalDateTime value4() {
        return getCreatedDt();
    }

    @Override
    public UserPostingApplyRecord value1(Integer value) {
        setUserPostingApplyId(value);
        return this;
    }

    @Override
    public UserPostingApplyRecord value2(Integer value) {
        setApplicantId(value);
        return this;
    }

    @Override
    public UserPostingApplyRecord value3(Integer value) {
        setPostingId(value);
        return this;
    }

    @Override
    public UserPostingApplyRecord value4(LocalDateTime value) {
        setCreatedDt(value);
        return this;
    }

    @Override
    public UserPostingApplyRecord values(Integer value1, Integer value2, Integer value3, LocalDateTime value4) {
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
     * Create a detached UserPostingApplyRecord
     */
    public UserPostingApplyRecord() {
        super(UserPostingApply.USER_POSTING_APPLY);
    }

    /**
     * Create a detached, initialised UserPostingApplyRecord
     */
    public UserPostingApplyRecord(Integer userPostingApplyId, Integer applicantId, Integer postingId, LocalDateTime createdDt) {
        super(UserPostingApply.USER_POSTING_APPLY);

        set(0, userPostingApplyId);
        set(1, applicantId);
        set(2, postingId);
        set(3, createdDt);
    }
}
