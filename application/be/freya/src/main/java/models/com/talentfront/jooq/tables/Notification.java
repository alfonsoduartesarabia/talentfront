/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables;


import com.talentfront.jooq.Db;
import com.talentfront.jooq.Indexes;
import com.talentfront.jooq.Keys;
import com.talentfront.jooq.tables.records.NotificationRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
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
    date = "2021-04-04T00:56:11.066Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Notification extends TableImpl<NotificationRecord> {

    private static final long serialVersionUID = 880312690;

    /**
     * The reference instance of <code>db.notification</code>
     */
    public static final Notification NOTIFICATION = new Notification();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<NotificationRecord> getRecordType() {
        return NotificationRecord.class;
    }

    /**
     * The column <code>db.notification.notification_id</code>.
     */
    public final TableField<NotificationRecord, Integer> NOTIFICATION_ID = createField(DSL.name("notification_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>db.notification.sender_id</code>.
     */
    public final TableField<NotificationRecord, Integer> SENDER_ID = createField(DSL.name("sender_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>db.notification.reciever_id</code>.
     */
    public final TableField<NotificationRecord, Integer> RECIEVER_ID = createField(DSL.name("reciever_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>db.notification.data</code>.
     */
    public final TableField<NotificationRecord, String> DATA = createField(DSL.name("data"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>db.notification.status</code>.
     */
    public final TableField<NotificationRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * Create a <code>db.notification</code> table reference
     */
    public Notification() {
        this(DSL.name("notification"), null);
    }

    /**
     * Create an aliased <code>db.notification</code> table reference
     */
    public Notification(String alias) {
        this(DSL.name(alias), NOTIFICATION);
    }

    /**
     * Create an aliased <code>db.notification</code> table reference
     */
    public Notification(Name alias) {
        this(alias, NOTIFICATION);
    }

    private Notification(Name alias, Table<NotificationRecord> aliased) {
        this(alias, aliased, null);
    }

    private Notification(Name alias, Table<NotificationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> Notification(Table<O> child, ForeignKey<O, NotificationRecord> key) {
        super(child, key, NOTIFICATION);
    }

    @Override
    public Schema getSchema() {
        return Db.DB;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.NOTIFICATION_RECIEVER_ID_FK, Indexes.NOTIFICATION_SENDER_ID_FK);
    }

    @Override
    public Identity<NotificationRecord, Integer> getIdentity() {
        return Keys.IDENTITY_NOTIFICATION;
    }

    @Override
    public UniqueKey<NotificationRecord> getPrimaryKey() {
        return Keys.KEY_NOTIFICATION_PRIMARY;
    }

    @Override
    public List<UniqueKey<NotificationRecord>> getKeys() {
        return Arrays.<UniqueKey<NotificationRecord>>asList(Keys.KEY_NOTIFICATION_PRIMARY);
    }

    @Override
    public List<ForeignKey<NotificationRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<NotificationRecord, ?>>asList(Keys.NOTIFICATION_SENDER_ID_FK, Keys.NOTIFICATION_RECIEVER_ID_FK);
    }

    public User notificationSenderIdFk() {
        return new User(this, Keys.NOTIFICATION_SENDER_ID_FK);
    }

    public User notificationRecieverIdFk() {
        return new User(this, Keys.NOTIFICATION_RECIEVER_ID_FK);
    }

    @Override
    public Notification as(String alias) {
        return new Notification(DSL.name(alias), this);
    }

    @Override
    public Notification as(Name alias) {
        return new Notification(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Notification rename(String name) {
        return new Notification(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Notification rename(Name name) {
        return new Notification(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, Integer, Integer, String, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
