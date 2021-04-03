/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables;


import com.talentfront.jooq.Db;
import com.talentfront.jooq.Keys;
import com.talentfront.jooq.tables.records.UserImageRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Row5;
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
public class UserImage extends TableImpl<UserImageRecord> {

    private static final long serialVersionUID = -1851690360;

    /**
     * The reference instance of <code>db.user_image</code>
     */
    public static final UserImage USER_IMAGE = new UserImage();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserImageRecord> getRecordType() {
        return UserImageRecord.class;
    }

    /**
     * The column <code>db.user_image.user_image_id</code>.
     */
    public final TableField<UserImageRecord, Integer> USER_IMAGE_ID = createField(DSL.name("user_image_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>db.user_image.user_id</code>.
     */
    public final TableField<UserImageRecord, Integer> USER_ID = createField(DSL.name("user_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>db.user_image.img</code>.
     */
    public final TableField<UserImageRecord, byte[]> IMG = createField(DSL.name("img"), org.jooq.impl.SQLDataType.BLOB.nullable(false), this, "");

    /**
     * The column <code>db.user_image.title</code>.
     */
    public final TableField<UserImageRecord, String> TITLE = createField(DSL.name("title"), org.jooq.impl.SQLDataType.VARCHAR(256).nullable(false), this, "");

    /**
     * The column <code>db.user_image.created_dt</code>.
     */
    public final TableField<UserImageRecord, LocalDateTime> CREATED_DT = createField(DSL.name("created_dt"), org.jooq.impl.SQLDataType.LOCALDATETIME.nullable(false), this, "");

    /**
     * Create a <code>db.user_image</code> table reference
     */
    public UserImage() {
        this(DSL.name("user_image"), null);
    }

    /**
     * Create an aliased <code>db.user_image</code> table reference
     */
    public UserImage(String alias) {
        this(DSL.name(alias), USER_IMAGE);
    }

    /**
     * Create an aliased <code>db.user_image</code> table reference
     */
    public UserImage(Name alias) {
        this(alias, USER_IMAGE);
    }

    private UserImage(Name alias, Table<UserImageRecord> aliased) {
        this(alias, aliased, null);
    }

    private UserImage(Name alias, Table<UserImageRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> UserImage(Table<O> child, ForeignKey<O, UserImageRecord> key) {
        super(child, key, USER_IMAGE);
    }

    @Override
    public Schema getSchema() {
        return Db.DB;
    }

    @Override
    public Identity<UserImageRecord, Integer> getIdentity() {
        return Keys.IDENTITY_USER_IMAGE;
    }

    @Override
    public UniqueKey<UserImageRecord> getPrimaryKey() {
        return Keys.KEY_USER_IMAGE_PRIMARY;
    }

    @Override
    public List<UniqueKey<UserImageRecord>> getKeys() {
        return Arrays.<UniqueKey<UserImageRecord>>asList(Keys.KEY_USER_IMAGE_PRIMARY);
    }

    @Override
    public List<ForeignKey<UserImageRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<UserImageRecord, ?>>asList(Keys.USER_IMAGE_USER_ID_FK);
    }

    public User user() {
        return new User(this, Keys.USER_IMAGE_USER_ID_FK);
    }

    @Override
    public UserImage as(String alias) {
        return new UserImage(DSL.name(alias), this);
    }

    @Override
    public UserImage as(Name alias) {
        return new UserImage(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public UserImage rename(String name) {
        return new UserImage(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public UserImage rename(Name name) {
        return new UserImage(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Integer, byte[], String, LocalDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
