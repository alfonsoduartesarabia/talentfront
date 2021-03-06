/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables.records;


import com.talentfront.jooq.tables.UserSkill;

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
public class UserSkillRecord extends UpdatableRecordImpl<UserSkillRecord> implements Record3<Integer, Integer, String> {

    private static final long serialVersionUID = 1708860017;

    /**
     * Setter for <code>db.user_skill.user_skill_id</code>.
     */
    public void setUserSkillId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>db.user_skill.user_skill_id</code>.
     */
    public Integer getUserSkillId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>db.user_skill.user_id</code>.
     */
    public void setUserId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>db.user_skill.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>db.user_skill.skill</code>.
     */
    public void setSkill(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>db.user_skill.skill</code>.
     */
    public String getSkill() {
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
        return UserSkill.USER_SKILL.USER_SKILL_ID;
    }

    @Override
    public Field<Integer> field2() {
        return UserSkill.USER_SKILL.USER_ID;
    }

    @Override
    public Field<String> field3() {
        return UserSkill.USER_SKILL.SKILL;
    }

    @Override
    public Integer component1() {
        return getUserSkillId();
    }

    @Override
    public Integer component2() {
        return getUserId();
    }

    @Override
    public String component3() {
        return getSkill();
    }

    @Override
    public Integer value1() {
        return getUserSkillId();
    }

    @Override
    public Integer value2() {
        return getUserId();
    }

    @Override
    public String value3() {
        return getSkill();
    }

    @Override
    public UserSkillRecord value1(Integer value) {
        setUserSkillId(value);
        return this;
    }

    @Override
    public UserSkillRecord value2(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public UserSkillRecord value3(String value) {
        setSkill(value);
        return this;
    }

    @Override
    public UserSkillRecord values(Integer value1, Integer value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserSkillRecord
     */
    public UserSkillRecord() {
        super(UserSkill.USER_SKILL);
    }

    /**
     * Create a detached, initialised UserSkillRecord
     */
    public UserSkillRecord(Integer userSkillId, Integer userId, String skill) {
        super(UserSkill.USER_SKILL);

        set(0, userSkillId);
        set(1, userId);
        set(2, skill);
    }
}
