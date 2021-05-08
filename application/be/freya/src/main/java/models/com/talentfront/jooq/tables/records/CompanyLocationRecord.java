/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables.records;


import com.talentfront.jooq.tables.CompanyLocation;

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
public class CompanyLocationRecord extends UpdatableRecordImpl<CompanyLocationRecord> implements Record3<Integer, Integer, String> {

    private static final long serialVersionUID = -590958427;

    /**
     * Setter for <code>db.company_location.company_location_id</code>.
     */
    public void setCompanyLocationId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>db.company_location.company_location_id</code>.
     */
    public Integer getCompanyLocationId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>db.company_location.company_id</code>.
     */
    public void setCompanyId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>db.company_location.company_id</code>.
     */
    public Integer getCompanyId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>db.company_location.location</code>.
     */
    public void setLocation(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>db.company_location.location</code>.
     */
    public String getLocation() {
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
        return CompanyLocation.COMPANY_LOCATION.COMPANY_LOCATION_ID;
    }

    @Override
    public Field<Integer> field2() {
        return CompanyLocation.COMPANY_LOCATION.COMPANY_ID;
    }

    @Override
    public Field<String> field3() {
        return CompanyLocation.COMPANY_LOCATION.LOCATION;
    }

    @Override
    public Integer component1() {
        return getCompanyLocationId();
    }

    @Override
    public Integer component2() {
        return getCompanyId();
    }

    @Override
    public String component3() {
        return getLocation();
    }

    @Override
    public Integer value1() {
        return getCompanyLocationId();
    }

    @Override
    public Integer value2() {
        return getCompanyId();
    }

    @Override
    public String value3() {
        return getLocation();
    }

    @Override
    public CompanyLocationRecord value1(Integer value) {
        setCompanyLocationId(value);
        return this;
    }

    @Override
    public CompanyLocationRecord value2(Integer value) {
        setCompanyId(value);
        return this;
    }

    @Override
    public CompanyLocationRecord value3(String value) {
        setLocation(value);
        return this;
    }

    @Override
    public CompanyLocationRecord values(Integer value1, Integer value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached CompanyLocationRecord
     */
    public CompanyLocationRecord() {
        super(CompanyLocation.COMPANY_LOCATION);
    }

    /**
     * Create a detached, initialised CompanyLocationRecord
     */
    public CompanyLocationRecord(Integer companyLocationId, Integer companyId, String location) {
        super(CompanyLocation.COMPANY_LOCATION);

        set(0, companyLocationId);
        set(1, companyId);
        set(2, location);
    }
}
