/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables;


import com.talentfront.jooq.Db;
import com.talentfront.jooq.Indexes;
import com.talentfront.jooq.Keys;
import com.talentfront.jooq.tables.records.UserRelationshipRecord;

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
    date = "2021-05-08T19:27:48.680Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRelationship extends TableImpl<UserRelationshipRecord> {

    private static final long serialVersionUID = -679707947;

    /**
     * The reference instance of <code>db.user_relationship</code>
     */
    public static final UserRelationship USER_RELATIONSHIP = new UserRelationship();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRelationshipRecord> getRecordType() {
        return UserRelationshipRecord.class;
    }

    /**
     * The column <code>db.user_relationship.user_relationship_id</code>.
     */
    public final TableField<UserRelationshipRecord, Integer> USER_RELATIONSHIP_ID = createField(DSL.name("user_relationship_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>db.user_relationship.relationship_type</code>.
     */
    public final TableField<UserRelationshipRecord, String> RELATIONSHIP_TYPE = createField(DSL.name("relationship_type"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>db.user_relationship.user_follower_id</code>.
     */
    public final TableField<UserRelationshipRecord, Integer> USER_FOLLOWER_ID = createField(DSL.name("user_follower_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>db.user_relationship.user_followee_id</code>.
     */
    public final TableField<UserRelationshipRecord, Integer> USER_FOLLOWEE_ID = createField(DSL.name("user_followee_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>db.user_relationship</code> table reference
     */
    public UserRelationship() {
        this(DSL.name("user_relationship"), null);
    }

    /**
     * Create an aliased <code>db.user_relationship</code> table reference
     */
    public UserRelationship(String alias) {
        this(DSL.name(alias), USER_RELATIONSHIP);
    }

    /**
     * Create an aliased <code>db.user_relationship</code> table reference
     */
    public UserRelationship(Name alias) {
        this(alias, USER_RELATIONSHIP);
    }

    private UserRelationship(Name alias, Table<UserRelationshipRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserRelationship(Name alias, Table<UserRelationshipRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> UserRelationship(Table<O> child, ForeignKey<O, UserRelationshipRecord> key) {
        super(child, key, USER_RELATIONSHIP);
    }

    @Override
    public Schema getSchema() {
        return Db.DB;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.USER_RELATIONSHIP_USER_FOLLOWEE_ID_FK, Indexes.USER_RELATIONSHIP_USER_FOLLOWER_ID_FK);
    }

    @Override
    public Identity<UserRelationshipRecord, Integer> getIdentity() {
        return Keys.IDENTITY_USER_RELATIONSHIP;
    }

    @Override
    public UniqueKey<UserRelationshipRecord> getPrimaryKey() {
        return Keys.KEY_USER_RELATIONSHIP_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserRelationshipRecord>> getKeys() {
        return Arrays.<UniqueKey<UserRelationshipRecord>>asList(Keys.KEY_USER_RELATIONSHIP_PRIMARY);
    }

    @Override
    public List<ForeignKey<UserRelationshipRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserRelationshipRecord, ?>>asList(Keys.USER_RELATIONSHIP_USER_FOLLOWER_ID_FK, Keys.USER_RELATIONSHIP_USER_FOLLOWEE_ID_FK);
    }

    public User userRelationshipUserFollowerIdFk() {
        return new User(this, Keys.USER_RELATIONSHIP_USER_FOLLOWER_ID_FK);
    }

    public User userRelationshipUserFolloweeIdFk() {
        return new User(this, Keys.USER_RELATIONSHIP_USER_FOLLOWEE_ID_FK);
    }

    @Override
    public UserRelationship as(String alias) {
        return new UserRelationship(DSL.name(alias), this);
    }

    @Override
    public UserRelationship as(Name alias) {
        return new UserRelationship(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserRelationship rename(String name) {
        return new UserRelationship(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserRelationship rename(Name name) {
        return new UserRelationship(name, null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<Integer, String, Integer, Integer> fieldsRow() {
        return (Row4) super.fieldsRow();
    }
}
