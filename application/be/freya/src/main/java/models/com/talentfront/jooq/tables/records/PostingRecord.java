/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables.records;


import com.talentfront.jooq.tables.Posting;

import java.time.LocalDateTime;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
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
    date = "2021-05-08T20:05:20.887Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PostingRecord extends UpdatableRecordImpl<PostingRecord> implements Record10<Integer, String, String, Integer, Integer, LocalDateTime, Integer, String, String, String> {

    private static final long serialVersionUID = -475370697;

    /**
     * Setter for <code>db.posting.posting_id</code>.
     */
    public void setPostingId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>db.posting.posting_id</code>.
     */
    public Integer getPostingId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>db.posting.description</code>.
     */
    public void setDescription(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>db.posting.description</code>.
     */
    public String getDescription() {
        return (String) get(1);
    }

    /**
     * Setter for <code>db.posting.employer_name</code>.
     */
    public void setEmployerName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>db.posting.employer_name</code>.
     */
    public String getEmployerName() {
        return (String) get(2);
    }

    /**
     * Setter for <code>db.posting.salary_range_top</code>.
     */
    public void setSalaryRangeTop(Integer value) {
        set(3, value);
    }

    /**
     * Getter for <code>db.posting.salary_range_top</code>.
     */
    public Integer getSalaryRangeTop() {
        return (Integer) get(3);
    }

    /**
     * Setter for <code>db.posting.salary_range_bottom</code>.
     */
    public void setSalaryRangeBottom(Integer value) {
        set(4, value);
    }

    /**
     * Getter for <code>db.posting.salary_range_bottom</code>.
     */
    public Integer getSalaryRangeBottom() {
        return (Integer) get(4);
    }

    /**
     * Setter for <code>db.posting.created_dt</code>.
     */
    public void setCreatedDt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>db.posting.created_dt</code>.
     */
    public LocalDateTime getCreatedDt() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>db.posting.user_id</code>.
     */
    public void setUserId(Integer value) {
        set(6, value);
    }

    /**
     * Getter for <code>db.posting.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>db.posting.job_title</code>.
     */
    public void setJobTitle(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>db.posting.job_title</code>.
     */
    public String getJobTitle() {
        return (String) get(7);
    }

    /**
     * Setter for <code>db.posting.state</code>.
     */
    public void setState(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>db.posting.state</code>.
     */
    public String getState() {
        return (String) get(8);
    }

    /**
     * Setter for <code>db.posting.city</code>.
     */
    public void setCity(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>db.posting.city</code>.
     */
    public String getCity() {
        return (String) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Integer, String, String, Integer, Integer, LocalDateTime, Integer, String, String, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Integer, String, String, Integer, Integer, LocalDateTime, Integer, String, String, String> valuesRow() {
        return (Row10) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Posting.POSTING.POSTING_ID;
    }

    @Override
    public Field<String> field2() {
        return Posting.POSTING.DESCRIPTION;
    }

    @Override
    public Field<String> field3() {
        return Posting.POSTING.EMPLOYER_NAME;
    }

    @Override
    public Field<Integer> field4() {
        return Posting.POSTING.SALARY_RANGE_TOP;
    }

    @Override
    public Field<Integer> field5() {
        return Posting.POSTING.SALARY_RANGE_BOTTOM;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return Posting.POSTING.CREATED_DT;
    }

    @Override
    public Field<Integer> field7() {
        return Posting.POSTING.USER_ID;
    }

    @Override
    public Field<String> field8() {
        return Posting.POSTING.JOB_TITLE;
    }

    @Override
    public Field<String> field9() {
        return Posting.POSTING.STATE;
    }

    @Override
    public Field<String> field10() {
        return Posting.POSTING.CITY;
    }

    @Override
    public Integer component1() {
        return getPostingId();
    }

    @Override
    public String component2() {
        return getDescription();
    }

    @Override
    public String component3() {
        return getEmployerName();
    }

    @Override
    public Integer component4() {
        return getSalaryRangeTop();
    }

    @Override
    public Integer component5() {
        return getSalaryRangeBottom();
    }

    @Override
    public LocalDateTime component6() {
        return getCreatedDt();
    }

    @Override
    public Integer component7() {
        return getUserId();
    }

    @Override
    public String component8() {
        return getJobTitle();
    }

    @Override
    public String component9() {
        return getState();
    }

    @Override
    public String component10() {
        return getCity();
    }

    @Override
    public Integer value1() {
        return getPostingId();
    }

    @Override
    public String value2() {
        return getDescription();
    }

    @Override
    public String value3() {
        return getEmployerName();
    }

    @Override
    public Integer value4() {
        return getSalaryRangeTop();
    }

    @Override
    public Integer value5() {
        return getSalaryRangeBottom();
    }

    @Override
    public LocalDateTime value6() {
        return getCreatedDt();
    }

    @Override
    public Integer value7() {
        return getUserId();
    }

    @Override
    public String value8() {
        return getJobTitle();
    }

    @Override
    public String value9() {
        return getState();
    }

    @Override
    public String value10() {
        return getCity();
    }

    @Override
    public PostingRecord value1(Integer value) {
        setPostingId(value);
        return this;
    }

    @Override
    public PostingRecord value2(String value) {
        setDescription(value);
        return this;
    }

    @Override
    public PostingRecord value3(String value) {
        setEmployerName(value);
        return this;
    }

    @Override
    public PostingRecord value4(Integer value) {
        setSalaryRangeTop(value);
        return this;
    }

    @Override
    public PostingRecord value5(Integer value) {
        setSalaryRangeBottom(value);
        return this;
    }

    @Override
    public PostingRecord value6(LocalDateTime value) {
        setCreatedDt(value);
        return this;
    }

    @Override
    public PostingRecord value7(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public PostingRecord value8(String value) {
        setJobTitle(value);
        return this;
    }

    @Override
    public PostingRecord value9(String value) {
        setState(value);
        return this;
    }

    @Override
    public PostingRecord value10(String value) {
        setCity(value);
        return this;
    }

    @Override
    public PostingRecord values(Integer value1, String value2, String value3, Integer value4, Integer value5, LocalDateTime value6, Integer value7, String value8, String value9, String value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached PostingRecord
     */
    public PostingRecord() {
        super(Posting.POSTING);
    }

    /**
     * Create a detached, initialised PostingRecord
     */
    public PostingRecord(Integer postingId, String description, String employerName, Integer salaryRangeTop, Integer salaryRangeBottom, LocalDateTime createdDt, Integer userId, String jobTitle, String state, String city) {
        super(Posting.POSTING);

        set(0, postingId);
        set(1, description);
        set(2, employerName);
        set(3, salaryRangeTop);
        set(4, salaryRangeBottom);
        set(5, createdDt);
        set(6, userId);
        set(7, jobTitle);
        set(8, state);
        set(9, city);
    }
}
