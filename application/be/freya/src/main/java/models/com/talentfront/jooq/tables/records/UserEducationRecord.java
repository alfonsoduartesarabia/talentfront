/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables.records;


import com.talentfront.jooq.tables.UserEducation;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
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
public class UserEducationRecord extends UpdatableRecordImpl<UserEducationRecord> implements Record6<Integer, String, String, String, String, Integer> {

    private static final long serialVersionUID = 650763386;

    /**
     * Setter for <code>db.user_education.user_education_id</code>.
     */
    public void setUserEducationId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>db.user_education.user_education_id</code>.
     */
    public Integer getUserEducationId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>db.user_education.school</code>.
     */
    public void setSchool(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>db.user_education.school</code>.
     */
    public String getSchool() {
        return (String) get(1);
    }

    /**
     * Setter for <code>db.user_education.degree_type</code>.
     */
    public void setDegreeType(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>db.user_education.degree_type</code>.
     */
    public String getDegreeType() {
        return (String) get(2);
    }

    /**
     * Setter for <code>db.user_education.major</code>.
     */
    public void setMajor(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>db.user_education.major</code>.
     */
    public String getMajor() {
        return (String) get(3);
    }

    /**
     * Setter for <code>db.user_education.state</code>.
     */
    public void setState(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>db.user_education.state</code>.
     */
    public String getState() {
        return (String) get(4);
    }

    /**
     * Setter for <code>db.user_education.user_id</code>.
     */
    public void setUserId(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>db.user_education.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, String, String, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, String, String, String, String, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return UserEducation.USER_EDUCATION.USER_EDUCATION_ID;
    }

    @Override
    public Field<String> field2() {
        return UserEducation.USER_EDUCATION.SCHOOL;
    }

    @Override
    public Field<String> field3() {
        return UserEducation.USER_EDUCATION.DEGREE_TYPE;
    }

    @Override
    public Field<String> field4() {
        return UserEducation.USER_EDUCATION.MAJOR;
    }

    @Override
    public Field<String> field5() {
        return UserEducation.USER_EDUCATION.STATE;
    }

    @Override
    public Field<Integer> field6() {
        return UserEducation.USER_EDUCATION.USER_ID;
    }

    @Override
    public Integer component1() {
        return getUserEducationId();
    }

    @Override
    public String component2() {
        return getSchool();
    }

    @Override
    public String component3() {
        return getDegreeType();
    }

    @Override
    public String component4() {
        return getMajor();
    }

    @Override
    public String component5() {
        return getState();
    }

    @Override
    public Integer component6() {
        return getUserId();
    }

    @Override
    public Integer value1() {
        return getUserEducationId();
    }

    @Override
    public String value2() {
        return getSchool();
    }

    @Override
    public String value3() {
        return getDegreeType();
    }

    @Override
    public String value4() {
        return getMajor();
    }

    @Override
    public String value5() {
        return getState();
    }

    @Override
    public Integer value6() {
        return getUserId();
    }

    @Override
    public UserEducationRecord value1(Integer value) {
        setUserEducationId(value);
        return this;
    }

    @Override
    public UserEducationRecord value2(String value) {
        setSchool(value);
        return this;
    }

    @Override
    public UserEducationRecord value3(String value) {
        setDegreeType(value);
        return this;
    }

    @Override
    public UserEducationRecord value4(String value) {
        setMajor(value);
        return this;
    }

    @Override
    public UserEducationRecord value5(String value) {
        setState(value);
        return this;
    }

    @Override
    public UserEducationRecord value6(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public UserEducationRecord values(Integer value1, String value2, String value3, String value4, String value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserEducationRecord
     */
    public UserEducationRecord() {
        super(UserEducation.USER_EDUCATION);
    }

    /**
     * Create a detached, initialised UserEducationRecord
     */
    public UserEducationRecord(Integer userEducationId, String school, String degreeType, String major, String state, Integer userId) {
        super(UserEducation.USER_EDUCATION);

        set(0, userEducationId);
        set(1, school);
        set(2, degreeType);
        set(3, major);
        set(4, state);
        set(5, userId);
    }
}
