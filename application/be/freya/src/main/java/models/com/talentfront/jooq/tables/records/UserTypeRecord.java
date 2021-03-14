/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables.records;


import com.talentfront.jooq.tables.UserType;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record2;
import org.jooq.Row2;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "https://www.jooq.org",
        "jOOQ version:3.13.2",
        "schema version:1.2"
    },
    date = "2021-03-14T07:05:54.570Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserTypeRecord extends UpdatableRecordImpl<UserTypeRecord> implements Record2<Integer, String> {

    private static final long serialVersionUID = 1388123525;

    /**
     * Setter for <code>db.user_type.user_type_id</code>.
     */
    public void setUserTypeId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>db.user_type.user_type_id</code>.
     */
    public Integer getUserTypeId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>db.user_type.type</code>.
     */
    public void setType(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>db.user_type.type</code>.
     */
    public String getType() {
        return (String) get(1);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record2 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    @Override
    public Row2<Integer, String> valuesRow() {
        return (Row2) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return UserType.USER_TYPE.USER_TYPE_ID;
    }

    @Override
    public Field<String> field2() {
        return UserType.USER_TYPE.TYPE;
    }

    @Override
    public Integer component1() {
        return getUserTypeId();
    }

    @Override
    public String component2() {
        return getType();
    }

    @Override
    public Integer value1() {
        return getUserTypeId();
    }

    @Override
    public String value2() {
        return getType();
    }

    @Override
    public UserTypeRecord value1(Integer value) {
        setUserTypeId(value);
        return this;
    }

    @Override
    public UserTypeRecord value2(String value) {
        setType(value);
        return this;
    }

    @Override
    public UserTypeRecord values(Integer value1, String value2) {
        value1(value1);
        value2(value2);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserTypeRecord
     */
    public UserTypeRecord() {
        super(UserType.USER_TYPE);
    }

    /**
     * Create a detached, initialised UserTypeRecord
     */
    public UserTypeRecord(Integer userTypeId, String type) {
        super(UserType.USER_TYPE);

        set(0, userTypeId);
        set(1, type);
    }
}
