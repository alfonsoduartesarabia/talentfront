/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables;


import com.talentfront.jooq.Db;
import com.talentfront.jooq.Keys;
import com.talentfront.jooq.tables.records.UserTypeRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row2;
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
        "schema version:4.1"
    },
    date = "2021-04-03T20:58:38.186Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserType extends TableImpl<UserTypeRecord> {

    private static final long serialVersionUID = -1477167590;

    /**
     * The reference instance of <code>db.user_type</code>
     */
    public static final UserType USER_TYPE = new UserType();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserTypeRecord> getRecordType() {
        return UserTypeRecord.class;
    }

    /**
     * The column <code>db.user_type.user_type_id</code>.
     */
    public final TableField<UserTypeRecord, Integer> USER_TYPE_ID = createField(DSL.name("user_type_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>db.user_type.type</code>.
     */
    public final TableField<UserTypeRecord, String> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR(90).nullable(false), this, "");

    /**
     * Create a <code>db.user_type</code> table reference
     */
    public UserType() {
        this(DSL.name("user_type"), null);
    }

    /**
     * Create an aliased <code>db.user_type</code> table reference
     */
    public UserType(String alias) {
        this(DSL.name(alias), USER_TYPE);
    }

    /**
     * Create an aliased <code>db.user_type</code> table reference
     */
    public UserType(Name alias) {
        this(alias, USER_TYPE);
    }

    private UserType(Name alias, Table<UserTypeRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserType(Name alias, Table<UserTypeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> UserType(Table<O> child, ForeignKey<O, UserTypeRecord> key) {
        super(child, key, USER_TYPE);
    }

    @Override
    public Schema getSchema() {
        return Db.DB;
    }

    @Override
    public Identity<UserTypeRecord, Integer> getIdentity() {
        return Keys.IDENTITY_USER_TYPE;
    }

    @Override
    public UniqueKey<UserTypeRecord> getPrimaryKey() {
        return Keys.KEY_USER_TYPE_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserTypeRecord>> getKeys() {
        return Arrays.<UniqueKey<UserTypeRecord>>asList(Keys.KEY_USER_TYPE_PRIMARY);
    }

    @Override
    public UserType as(String alias) {
        return new UserType(DSL.name(alias), this);
    }

    @Override
    public UserType as(Name alias) {
        return new UserType(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserType rename(String name) {
        return new UserType(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserType rename(Name name) {
        return new UserType(name, null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}
