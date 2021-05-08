/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables;


import com.talentfront.jooq.Db;
import com.talentfront.jooq.Keys;
import com.talentfront.jooq.tables.records.PostingRequirementRecord;

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
    date = "2021-05-08T05:41:00.043Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PostingRequirement extends TableImpl<PostingRequirementRecord> {

    private static final long serialVersionUID = 194658159;

    /**
     * The reference instance of <code>db.posting_requirement</code>
     */
    public static final PostingRequirement POSTING_REQUIREMENT = new PostingRequirement();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PostingRequirementRecord> getRecordType() {
        return PostingRequirementRecord.class;
    }

    /**
     * The column <code>db.posting_requirement.posting_requirement_id</code>.
     */
    public final TableField<PostingRequirementRecord, Integer> POSTING_REQUIREMENT_ID = createField(DSL.name("posting_requirement_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>db.posting_requirement.posting_id</code>.
     */
    public final TableField<PostingRequirementRecord, Integer> POSTING_ID = createField(DSL.name("posting_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>db.posting_requirement.requirement</code>.
     */
    public final TableField<PostingRequirementRecord, String> REQUIREMENT = createField(DSL.name("requirement"), org.jooq.impl.SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * Create a <code>db.posting_requirement</code> table reference
     */
    public PostingRequirement() {
        this(DSL.name("posting_requirement"), null);
    }

    /**
     * Create an aliased <code>db.posting_requirement</code> table reference
     */
    public PostingRequirement(String alias) {
        this(DSL.name(alias), POSTING_REQUIREMENT);
    }

    /**
     * Create an aliased <code>db.posting_requirement</code> table reference
     */
    public PostingRequirement(Name alias) {
        this(alias, POSTING_REQUIREMENT);
    }

    private PostingRequirement(Name alias, Table<PostingRequirementRecord> aliased) {
        this(alias, aliased, null);
    }

    private PostingRequirement(Name alias, Table<PostingRequirementRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> PostingRequirement(Table<O> child, ForeignKey<O, PostingRequirementRecord> key) {
        super(child, key, POSTING_REQUIREMENT);
    }

    @Override
    public Schema getSchema() {
        return Db.DB;
    }

    @Override
    public Identity<PostingRequirementRecord, Integer> getIdentity() {
        return Keys.IDENTITY_POSTING_REQUIREMENT;
    }

    @Override
    public UniqueKey<PostingRequirementRecord> getPrimaryKey() {
        return Keys.KEY_POSTING_REQUIREMENT_PRIMARY;
    }

    @Override
    public List<UniqueKey<PostingRequirementRecord>> getKeys() {
        return Arrays.<UniqueKey<PostingRequirementRecord>>asList(Keys.KEY_POSTING_REQUIREMENT_PRIMARY);
    }

    @Override
    public List<ForeignKey<PostingRequirementRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PostingRequirementRecord, ?>>asList(Keys.POSTING_REQUIREMENT_POSTING_ID_FK);
    }

    public Posting posting() {
        return new Posting(this, Keys.POSTING_REQUIREMENT_POSTING_ID_FK);
    }

    @Override
    public PostingRequirement as(String alias) {
        return new PostingRequirement(DSL.name(alias), this);
    }

    @Override
    public PostingRequirement as(Name alias) {
        return new PostingRequirement(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PostingRequirement rename(String name) {
        return new PostingRequirement(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PostingRequirement rename(Name name) {
        return new PostingRequirement(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
