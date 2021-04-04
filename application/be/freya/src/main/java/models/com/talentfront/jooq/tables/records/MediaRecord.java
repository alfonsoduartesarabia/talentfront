/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables.records;


import com.talentfront.jooq.tables.Media;

import java.time.LocalDateTime;

import javax.annotation.processing.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;


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
public class MediaRecord extends UpdatableRecordImpl<MediaRecord> implements Record6<Integer, String, Integer, byte[], String, LocalDateTime> {

    private static final long serialVersionUID = 521775551;

    /**
     * Setter for <code>db.media.media_id</code>.
     */
    public void setMediaId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>db.media.media_id</code>.
     */
    public Integer getMediaId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>db.media.encoding</code>.
     */
    public void setEncoding(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>db.media.encoding</code>.
     */
    public String getEncoding() {
        return (String) get(1);
    }

    /**
     * Setter for <code>db.media.user_id</code>.
     */
    public void setUserId(Integer value) {
        set(2, value);
    }

    /**
     * Getter for <code>db.media.user_id</code>.
     */
    public Integer getUserId() {
        return (Integer) get(2);
    }

    /**
     * Setter for <code>db.media.file</code>.
     */
    public void setFile(byte[] value) {
        set(3, value);
    }

    /**
     * Getter for <code>db.media.file</code>.
     */
    public byte[] getFile() {
        return (byte[]) get(3);
    }

    /**
     * Setter for <code>db.media.title</code>.
     */
    public void setTitle(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>db.media.title</code>.
     */
    public String getTitle() {
        return (String) get(4);
    }

    /**
     * Setter for <code>db.media.created_dt</code>.
     */
    public void setCreatedDt(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>db.media.created_dt</code>.
     */
    public LocalDateTime getCreatedDt() {
        return (LocalDateTime) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, Integer, byte[], String, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, String, Integer, byte[], String, LocalDateTime> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Media.MEDIA.MEDIA_ID;
    }

    @Override
    public Field<String> field2() {
        return Media.MEDIA.ENCODING;
    }

    @Override
    public Field<Integer> field3() {
        return Media.MEDIA.USER_ID;
    }

    @Override
    public Field<byte[]> field4() {
        return Media.MEDIA.FILE;
    }

    @Override
    public Field<String> field5() {
        return Media.MEDIA.TITLE;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return Media.MEDIA.CREATED_DT;
    }

    @Override
    public Integer component1() {
        return getMediaId();
    }

    @Override
    public String component2() {
        return getEncoding();
    }

    @Override
    public Integer component3() {
        return getUserId();
    }

    @Override
    public byte[] component4() {
        return getFile();
    }

    @Override
    public String component5() {
        return getTitle();
    }

    @Override
    public LocalDateTime component6() {
        return getCreatedDt();
    }

    @Override
    public Integer value1() {
        return getMediaId();
    }

    @Override
    public String value2() {
        return getEncoding();
    }

    @Override
    public Integer value3() {
        return getUserId();
    }

    @Override
    public byte[] value4() {
        return getFile();
    }

    @Override
    public String value5() {
        return getTitle();
    }

    @Override
    public LocalDateTime value6() {
        return getCreatedDt();
    }

    @Override
    public MediaRecord value1(Integer value) {
        setMediaId(value);
        return this;
    }

    @Override
    public MediaRecord value2(String value) {
        setEncoding(value);
        return this;
    }

    @Override
    public MediaRecord value3(Integer value) {
        setUserId(value);
        return this;
    }

    @Override
    public MediaRecord value4(byte[] value) {
        setFile(value);
        return this;
    }

    @Override
    public MediaRecord value5(String value) {
        setTitle(value);
        return this;
    }

    @Override
    public MediaRecord value6(LocalDateTime value) {
        setCreatedDt(value);
        return this;
    }

    @Override
    public MediaRecord values(Integer value1, String value2, Integer value3, byte[] value4, String value5, LocalDateTime value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached MediaRecord
     */
    public MediaRecord() {
        super(Media.MEDIA);
    }

    /**
     * Create a detached, initialised MediaRecord
     */
    public MediaRecord(Integer mediaId, String encoding, Integer userId, byte[] file, String title, LocalDateTime createdDt) {
        super(Media.MEDIA);

        set(0, mediaId);
        set(1, encoding);
        set(2, userId);
        set(3, file);
        set(4, title);
        set(5, createdDt);
    }
}
