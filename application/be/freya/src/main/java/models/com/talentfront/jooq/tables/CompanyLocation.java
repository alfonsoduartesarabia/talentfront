/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables;


import com.talentfront.jooq.Db;
import com.talentfront.jooq.Keys;
import com.talentfront.jooq.tables.records.CompanyLocationRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row3;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


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
public class CompanyLocation extends TableImpl<CompanyLocationRecord> {

    private static final long serialVersionUID = 535741678;

    /**
     * The reference instance of <code>db.company_location</code>
     */
    public static final CompanyLocation COMPANY_LOCATION = new CompanyLocation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CompanyLocationRecord> getRecordType() {
        return CompanyLocationRecord.class;
    }

    /**
     * The column <code>db.company_location.company_location_id</code>.
     */
    public final TableField<CompanyLocationRecord, Integer> COMPANY_LOCATION_ID = createField(DSL.name("company_location_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>db.company_location.company_id</code>.
     */
    public final TableField<CompanyLocationRecord, Integer> COMPANY_ID = createField(DSL.name("company_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>db.company_location.location</code>.
     */
    public final TableField<CompanyLocationRecord, String> LOCATION = createField(DSL.name("location"), org.jooq.impl.SQLDataType.VARCHAR(512).nullable(false), this, "");

    /**
     * Create a <code>db.company_location</code> table reference
     */
    public CompanyLocation() {
        this(DSL.name("company_location"), null);
    }

    /**
     * Create an aliased <code>db.company_location</code> table reference
     */
    public CompanyLocation(String alias) {
        this(DSL.name(alias), COMPANY_LOCATION);
    }

    /**
     * Create an aliased <code>db.company_location</code> table reference
     */
    public CompanyLocation(Name alias) {
        this(alias, COMPANY_LOCATION);
    }

    private CompanyLocation(Name alias, Table<CompanyLocationRecord> aliased) {
        this(alias, aliased, null);
    }

    private CompanyLocation(Name alias, Table<CompanyLocationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> CompanyLocation(Table<O> child, ForeignKey<O, CompanyLocationRecord> key) {
        super(child, key, COMPANY_LOCATION);
    }

    @Override
    public Schema getSchema() {
        return Db.DB;
    }

    @Override
    public Identity<CompanyLocationRecord, Integer> getIdentity() {
        return Keys.IDENTITY_COMPANY_LOCATION;
    }

    @Override
    public UniqueKey<CompanyLocationRecord> getPrimaryKey() {
        return Keys.KEY_COMPANY_LOCATION_PRIMARY;
    }

    @Override
    public List<UniqueKey<CompanyLocationRecord>> getKeys() {
        return Arrays.<UniqueKey<CompanyLocationRecord>>asList(Keys.KEY_COMPANY_LOCATION_PRIMARY);
    }

    @Override
    public List<ForeignKey<CompanyLocationRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<CompanyLocationRecord, ?>>asList(Keys.COMPANY_LOCATION_COMPANY_ID_FK);
    }

    public Company company() {
        return new Company(this, Keys.COMPANY_LOCATION_COMPANY_ID_FK);
    }

    @Override
    public CompanyLocation as(String alias) {
        return new CompanyLocation(DSL.name(alias), this);
    }

    @Override
    public CompanyLocation as(Name alias) {
        return new CompanyLocation(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public CompanyLocation rename(String name) {
        return new CompanyLocation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public CompanyLocation rename(Name name) {
        return new CompanyLocation(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
