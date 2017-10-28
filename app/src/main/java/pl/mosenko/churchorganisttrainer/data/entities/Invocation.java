package pl.mosenko.churchorganisttrainer.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "invocations", foreignKeys = {
        @ForeignKey(
                entity = Tone.class,
                parentColumns = "id",
                childColumns = "lowest_tone_id",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE),
        @ForeignKey(
                entity = Tone.class,
                parentColumns = "id",
                childColumns = "highest_tone_id",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)}, indices = {
        @Index("lowest_tone_id"), @Index("highest_tone_id")})
public class Invocation {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "invocation_name")
    private String invocationName;
    @ColumnInfo(name = "created_at")
    private Date createdAt;
    private String author;
    @ColumnInfo(name = "lowest_tone_id")
    private Integer lowestToneId;
    @Ignore
    private Tone lowestTone;
    @ColumnInfo(name = "highest_tone_id")
    private Integer highestToneId;
    @Ignore
    private Tone highestTone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInvocationName() {
        return invocationName;
    }

    public void setInvocationName(String invocationName) {
        this.invocationName = invocationName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getLowestToneId() {
        return lowestToneId;
    }

    public void setLowestToneId(Integer lowestToneId) {
        this.lowestToneId = lowestToneId;
    }

    public Integer getHighestToneId() {
        return highestToneId;
    }

    public void setHighestToneId(Integer highestToneId) {
        this.highestToneId = highestToneId;
    }

    public Tone getLowestTone() {
        return lowestTone;
    }

    public void setLowestTone(Tone lowestTone) {
        this.lowestTone = lowestTone;
    }

    public Tone getHighestTone() {
        return highestTone;
    }

    public void setHighestTone(Tone highestTone) {
        this.highestTone = highestTone;
    }
}

