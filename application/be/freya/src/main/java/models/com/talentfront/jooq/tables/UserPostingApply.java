/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables;


import com.talentfront.jooq.Db;
import com.talentfront.jooq.Indexes;
import com.talentfront.jooq.Keys;
import com.talentfront.jooq.tables.records.UserPostingApplyRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row4;
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
public class UserPostingApply extends TableImpl<UserPostingApplyRecord> {

    private static final long serialVersionUID = 1172545397;

    /**
     * The reference instance of <code>db.user_posting_apply</code>
     */
    public static final UserPostingApply USER_POSTING_APPLY = new UserPostingApply();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserPostingApplyRecord> getRecordType() {
        return UserPostingApplyRecord.class;
    }

    /**
     * The column <code>db.user_posting_apply.user_posting_apply_id</code>.
     */
    public final TableField<UserPostingApplyRecord, Integer> USER_POSTING_APPLY_ID = createField(DSL.name("user_posting_apply_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>db.user_posting_apply.applicant_id</code>.
     */
    public final TableField<UserPostingApplyRecord, Integer> APPLICANT_ID = createField(DSL.name("applicant_id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>db.user_posting_apply.posting_id</code>.
     */
    public final TableField<UserPostingApplyRecord, Integer> POSTING_ID = createField(DSL.name("posting_id"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>db.user_posting_apply.created_dt</code>.
     */
    public final TableField<UserPostingApplyRecord, LocalDateTime> CREATED_DT = createField(DSL.name("created_dt"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * Create a <code>db.user_posting_apply</code> table reference
     */
    public UserPostingApply() {
        this(DSL.name("user_posting_apply"), null);
    }

    /**
     * Create an aliased <code>db.user_posting_apply</code> table reference
     */
    public UserPostingApply(String alias) {
        this(DSL.name(alias), USER_POSTING_APPLY);
    }

    /**
     * Create an aliased <code>db.user_posting_apply</code> table reference
     */
    public UserPostingApply(Name alias) {
        this(alias, USER_POSTING_APPLY);
    }

    private UserPostingApply(Name alias, Table<UserPostingApplyRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserPostingApply(Name alias, Table<UserPostingApplyRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> UserPostingApply(Table<O> child, ForeignKey<O, UserPostingApplyRecord> key) {
        super(child, key, USER_POSTING_APPLY);
    }

    @Override
    public Schema getSchema() {
        return Db.DB;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USER_POSTING_APPLY_POSTING_ID_FK, Indexes.USER_POSTING_APPLY_USER_ID_FK);
    }

    @Override
    public Identity<UserPostingApplyRecord, Integer> getIdentity() {
        return Keys.IDENTITY_USER_POSTING_APPLY;
    }

    @Override
    public UniqueKey<UserPostingApplyRecord> getPrimaryKey() {
        return Keys.KEY_USER_POSTING_APPLY_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserPostingApplyRecord>> getKeys() {
        return Arrays.<UniqueKey<UserPostingApplyRecord>>asList(Keys.KEY_USER_POSTING_APPLY_PRIMARY);
    }

    @Override
    public List<ForeignKey<UserPostingApplyRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserPostingApplyRecord, ?>>asList(Keys.USER_POSTING_APPLY_USER_ID_FK, Keys.USER_POSTING_APPLY_POSTING_ID_FK);
    }

    public User user() {
        return new User(this, Keys.USER_POSTING_APPLY_USER_ID_FK);
    }

    public Posting posting() {
        return new Posting(this, Keys.USER_POSTING_APPLY_POSTING_ID_FK);
    }

    @Override
    public UserPostingApply as(String alias) {
        return new UserPostingApply(DSL.name(alias), this);
    }

    @Override
    public UserPostingApply as(Name alias) {
        return new UserPostingApply(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserPostingApply rename(String name) {
        return new UserPostingApply(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserPostingApply rename(Name name) {
        return new UserPostingApply(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, Integer, Integer, LocalDateTime> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
