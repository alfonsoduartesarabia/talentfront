/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables.records;


import com.talentfront.jooq.tables.UserCompany;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record3;
import org.jooq.Row3;
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
public class UserCompanyRecord extends UpdatableRecordImpl<UserCompanyRecord> implements Record3<Integer, Integer, String> {

    private static final long serialVersionUID = 972712274;

    /**
     * Setter for <code>db.user_company.user_company_id</code>.
     */
    public void setUserCompanyId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>db.user_company.user_company_id</code>.
     */
    public Integer getUserCompanyId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>db.user_company.user_id</code>.
     */
    public void setUserId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>db.user_company.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>db.user_company.company_name</code>.
     */
    public void setCompanyName(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>db.user_company.company_name</code>.
     */
    public String getCompanyName() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<Integer, Integer, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return UserCompany.USER_COMPANY.USER_COMPANY_ID;
    }

    @Override
    public Field<Integer> field2() {
        return UserCompany.USER_COMPANY.USER_ID;
    }

    @Override
    public Field<String> field3() {
        return UserCompany.USER_COMPANY.COMPANY_NAME;
    }

    @Override
    public Integer component1() {
        return getUserCompanyId();
    }

    @Override
    public Integer component2() {
        return getUserId();
    }

    @Override
    public String component3() {
        return getCompanyName();
    }

    @Override
    public Integer value1() {
        return getUserCompanyId();
    }

    @Override
    public Integer value2() {
        return getUserId();
    }

    @Override
    public String value3() {
        return getCompanyName();
    }

    @Override
    public UserCompanyRecord value1(Integer value) {
        setUserCompanyId(value);
        return this;
    }

    @Override
    public UserCompanyRecord value2(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public UserCompanyRecord value3(String value) {
        setCompanyName(value);
        return this;
    }

    @Override
    public UserCompanyRecord values(Integer value1, Integer value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserCompanyRecord
     */
    public UserCompanyRecord() {
        super(UserCompany.USER_COMPANY);
    }

    /**
     * Create a detached, initialised UserCompanyRecord
     */
    public UserCompanyRecord(Integer userCompanyId, Integer userId, String companyName) {
        super(UserCompany.USER_COMPANY);

        set(0, userCompanyId);
        set(1, userId);
        set(2, companyName);
    }
}
