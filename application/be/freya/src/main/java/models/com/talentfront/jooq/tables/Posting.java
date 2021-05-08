/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables;


import com.talentfront.jooq.Db;
import com.talentfront.jooq.Indexes;
import com.talentfront.jooq.Keys;
import com.talentfront.jooq.tables.records.PostingRecord;

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
import org.jooq.Row10;
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
public class Posting extends TableImpl<PostingRecord> {

    private static final long serialVersionUID = 14154581;

    /**
     * The reference instance of <code>db.posting</code>
     */
    public static final Posting POSTING = new Posting();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PostingRecord> getRecordType() {
        return PostingRecord.class;
    }

    /**
     * The column <code>db.posting.posting_id</code>.
     */
    public final TableField<PostingRecord, Integer> POSTING_ID = createField(DSL.name("posting_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>db.posting.description</code>.
     */
    public final TableField<PostingRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>db.posting.employer_name</code>.
     */
    public final TableField<PostingRecord, String> EMPLOYER_NAME = createField(DSL.name("employer_name"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>db.posting.salary_range_top</code>.
     */
    public final TableField<PostingRecord, Integer> SALARY_RANGE_TOP = createField(DSL.name("salary_range_top"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>db.posting.salary_range_bottom</code>.
     */
    public final TableField<PostingRecord, Integer> SALARY_RANGE_BOTTOM = createField(DSL.name("salary_range_bottom"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>db.posting.created_dt</code>.
     */
    public final TableField<PostingRecord, LocalDateTime> CREATED_DT = createField(DSL.name("created_dt"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * The column <code>db.posting.user_id</code>.
     */
    public final TableField<PostingRecord, Integer> USER_ID = createField(DSL.name("user_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>db.posting.job_title</code>.
     */
    public final TableField<PostingRecord, String> JOB_TITLE = createField(DSL.name("job_title"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>db.posting.state</code>.
     */
    public final TableField<PostingRecord, String> STATE = createField(DSL.name("state"), org.jooq.impl.SQLDataType.VARCHAR(2), this, "");

    /**
     * The column <code>db.posting.city</code>.
     */
    public final TableField<PostingRecord, String> CITY = createField(DSL.name("city"), org.jooq.impl.SQLDataType.VARCHAR(256), this, "");

    /**
     * Create a <code>db.posting</code> table reference
     */
    public Posting() {
        this(DSL.name("posting"), null);
    }

    /**
     * Create an aliased <code>db.posting</code> table reference
     */
    public Posting(String alias) {
        this(DSL.name(alias), POSTING);
    }

    /**
     * Create an aliased <code>db.posting</code> table reference
     */
    public Posting(Name alias) {
        this(alias, POSTING);
    }

    private Posting(Name alias, Table<PostingRecord> aliased) {
        this(alias, aliased, null);
    }

    private Posting(Name alias, Table<PostingRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Posting(Table<O> child, ForeignKey<O, PostingRecord> key) {
        super(child, key, POSTING);
    }

    @Override
    public Schema getSchema() {
        return Db.DB;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.POSTING_USER_ID_FK);
    }

    @Override
    public Identity<PostingRecord, Integer> getIdentity() {
        return Keys.IDENTITY_POSTING;
    }

    @Override
    public UniqueKey<PostingRecord> getPrimaryKey() {
        return Keys.KEY_POSTING_PRIMARY;
    }

    @Override
    public List<UniqueKey<PostingRecord>> getKeys() {
        return Arrays.<UniqueKey<PostingRecord>>asList(Keys.KEY_POSTING_PRIMARY);
    }

    @Override
    public List<ForeignKey<PostingRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PostingRecord, ?>>asList(Keys.POSTING_USER_ID_FK);
    }

    public User user() {
        return new User(this, Keys.POSTING_USER_ID_FK);
    }

    @Override
    public Posting as(String alias) {
        return new Posting(DSL.name(alias), this);
    }

    @Override
    public Posting as(Name alias) {
        return new Posting(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Posting rename(String name) {
        return new Posting(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Posting rename(Name name) {
        return new Posting(name, null);
    }

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<Integer, String, String, Integer, Integer, LocalDateTime, Integer, String, String, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }
}
