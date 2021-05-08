/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables;


import com.talentfront.jooq.Db;
import com.talentfront.jooq.Keys;
import com.talentfront.jooq.tables.records.UserSkillRecord;

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
public class UserSkill extends TableImpl<UserSkillRecord> {

    private static final long serialVersionUID = -2068210204;

    /**
     * The reference instance of <code>db.user_skill</code>
     */
    public static final UserSkill USER_SKILL = new UserSkill();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserSkillRecord> getRecordType() {
        return UserSkillRecord.class;
    }

    /**
     * The column <code>db.user_skill.user_skill_id</code>.
     */
    public final TableField<UserSkillRecord, Integer> USER_SKILL_ID = createField(DSL.name("user_skill_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>db.user_skill.user_id</code>.
     */
    public final TableField<UserSkillRecord, Integer> USER_ID = createField(DSL.name("user_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>db.user_skill.skill</code>.
     */
    public final TableField<UserSkillRecord, String> SKILL = createField(DSL.name("skill"), org.jooq.impl.SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * Create a <code>db.user_skill</code> table reference
     */
    public UserSkill() {
        this(DSL.name("user_skill"), null);
    }

    /**
     * Create an aliased <code>db.user_skill</code> table reference
     */
    public UserSkill(String alias) {
        this(DSL.name(alias), USER_SKILL);
    }

    /**
     * Create an aliased <code>db.user_skill</code> table reference
     */
    public UserSkill(Name alias) {
        this(alias, USER_SKILL);
    }

    private UserSkill(Name alias, Table<UserSkillRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserSkill(Name alias, Table<UserSkillRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> UserSkill(Table<O> child, ForeignKey<O, UserSkillRecord> key) {
        super(child, key, USER_SKILL);
    }

    @Override
    public Schema getSchema() {
        return Db.DB;
    }

    @Override
    public Identity<UserSkillRecord, Integer> getIdentity() {
        return Keys.IDENTITY_USER_SKILL;
    }

    @Override
    public UniqueKey<UserSkillRecord> getPrimaryKey() {
        return Keys.KEY_USER_SKILL_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserSkillRecord>> getKeys() {
        return Arrays.<UniqueKey<UserSkillRecord>>asList(Keys.KEY_USER_SKILL_PRIMARY);
    }

    @Override
    public List<ForeignKey<UserSkillRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserSkillRecord, ?>>asList(Keys.USER_SKILL_USER_ID_FK);
    }

    public User user() {
        return new User(this, Keys.USER_SKILL_USER_ID_FK);
    }

    @Override
    public UserSkill as(String alias) {
        return new UserSkill(DSL.name(alias), this);
    }

    @Override
    public UserSkill as(Name alias) {
        return new UserSkill(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserSkill rename(String name) {
        return new UserSkill(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserSkill rename(Name name) {
        return new UserSkill(name, null);
    }

    // -------------------------------------------------------------------------
    // Row3 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row3<Integer, Integer, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }
}
