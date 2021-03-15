/*
 * This file is generated by jOOQ.
 */
package com.talentfront.jooq.tables;


import com.talentfront.jooq.Db;
import com.talentfront.jooq.Indexes;
import com.talentfront.jooq.Keys;
import com.talentfront.jooq.tables.records.PostingRecommendationRecord;

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
import org.jooq.Row6;
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
        "schema version:3.1"
    },
    date = "2021-03-15T00:48:38.982Z",
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PostingRecommendation extends TableImpl<PostingRecommendationRecord> {

    private static final long serialVersionUID = 1245921851;

    /**
     * The reference instance of <code>db.posting_recommendation</code>
     */
    public static final PostingRecommendation POSTING_RECOMMENDATION = new PostingRecommendation();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PostingRecommendationRecord> getRecordType() {
        return PostingRecommendationRecord.class;
    }

    /**
     * The column <code>db.posting_recommendation.posting_recommendation_id</code>.
     */
    public final TableField<PostingRecommendationRecord, Integer> POSTING_RECOMMENDATION_ID = createField(DSL.name("posting_recommendation_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>db.posting_recommendation.recommender_id</code>.
     */
    public final TableField<PostingRecommendationRecord, Integer> RECOMMENDER_ID = createField(DSL.name("recommender_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>db.posting_recommendation.recommendee_id</code>.
     */
    public final TableField<PostingRecommendationRecord, Integer> RECOMMENDEE_ID = createField(DSL.name("recommendee_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>db.posting_recommendation.posting_id</code>.
     */
    public final TableField<PostingRecommendationRecord, Integer> POSTING_ID = createField(DSL.name("posting_id"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>db.posting_recommendation.text</code>.
     */
    public final TableField<PostingRecommendationRecord, String> TEXT = createField(DSL.name("text"), org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>db.posting_recommendation.created_dt</code>.
     */
    public final TableField<PostingRecommendationRecord, LocalDateTime> CREATED_DT = createField(DSL.name("created_dt"), org.jooq.impl.SQLDataType.LOCALDATETIME, this, "");

    /**
     * Create a <code>db.posting_recommendation</code> table reference
     */
    public PostingRecommendation() {
        this(DSL.name("posting_recommendation"), null);
    }

    /**
     * Create an aliased <code>db.posting_recommendation</code> table reference
     */
    public PostingRecommendation(String alias) {
        this(DSL.name(alias), POSTING_RECOMMENDATION);
    }

    /**
     * Create an aliased <code>db.posting_recommendation</code> table reference
     */
    public PostingRecommendation(Name alias) {
        this(alias, POSTING_RECOMMENDATION);
    }

    private PostingRecommendation(Name alias, Table<PostingRecommendationRecord> aliased) {
        this(alias, aliased, null);
    }

    private PostingRecommendation(Name alias, Table<PostingRecommendationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    public <O extends Record> PostingRecommendation(Table<O> child, ForeignKey<O, PostingRecommendationRecord> key) {
        super(child, key, POSTING_RECOMMENDATION);
    }

    @Override
    public Schema getSchema() {
        return Db.DB;
    }

    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.POSTING_RECOMMENDATION_POSTING_ID_FK, Indexes.POSTING_RECOMMENDATION_RECOMMENDEE_ID_FK, Indexes.POSTING_RECOMMENDATION_RECOMMENDER_ID_FK);
    }

    @Override
    public Identity<PostingRecommendationRecord, Integer> getIdentity() {
        return Keys.IDENTITY_POSTING_RECOMMENDATION;
    }

    @Override
    public UniqueKey<PostingRecommendationRecord> getPrimaryKey() {
        return Keys.KEY_POSTING_RECOMMENDATION_PRIMARY;
    }

    @Override
    public List<UniqueKey<PostingRecommendationRecord>> getKeys() {
        return Arrays.<UniqueKey<PostingRecommendationRecord>>asList(Keys.KEY_POSTING_RECOMMENDATION_PRIMARY);
    }

    @Override
    public List<ForeignKey<PostingRecommendationRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<PostingRecommendationRecord, ?>>asList(Keys.POSTING_RECOMMENDATION_RECOMMENDER_ID_FK, Keys.POSTING_RECOMMENDATION_RECOMMENDEE_ID_FK, Keys.POSTING_RECOMMENDATION_POSTING_ID_FK);
    }

    public User postingRecommendationRecommenderIdFk() {
        return new User(this, Keys.POSTING_RECOMMENDATION_RECOMMENDER_ID_FK);
    }

    public User postingRecommendationRecommendeeIdFk() {
        return new User(this, Keys.POSTING_RECOMMENDATION_RECOMMENDEE_ID_FK);
    }

    public Posting posting() {
        return new Posting(this, Keys.POSTING_RECOMMENDATION_POSTING_ID_FK);
    }

    @Override
    public PostingRecommendation as(String alias) {
        return new PostingRecommendation(DSL.name(alias), this);
    }

    @Override
    public PostingRecommendation as(Name alias) {
        return new PostingRecommendation(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public PostingRecommendation rename(String name) {
        return new PostingRecommendation(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public PostingRecommendation rename(Name name) {
        return new PostingRecommendation(name, null);
    }

    // -------------------------------------------------------------------------
    // Row6 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, Integer, Integer, Integer, String, LocalDateTime> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}