package pl.mosenko.churchorganisttrainer.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "invocation_tones", foreignKeys = {
        @ForeignKey(entity = Invocation.class,
                parentColumns = "id",
                childColumns = "invocation_id",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE),
        @ForeignKey(entity = Tone.class,
                parentColumns = "id",
                childColumns = "tone_id",
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE)}, indices = {
        @Index(value = "full_path", unique = true),
        @Index("invocation_id"), @Index("tone_id")})
public class InvocationTone {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "invocation_id")
    private int invocationId;
    @Ignore
    private Invocation invocation;
    @ColumnInfo(name = "tone_id")
    private int toneId;
    @Ignore
    private Tone tone;
    @ColumnInfo(name = "full_path")
    private String fullPath;

    public InvocationTone() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvocationId() {
        return invocationId;
    }

    public void setInvocationId(int invocationId) {
        this.invocationId = invocationId;
    }

    public int getToneId() {
        return toneId;
    }

    public void setToneId(int toneId) {
        this.toneId = toneId;
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath;
    }

    public Invocation getInvocation() {
        return invocation;
    }

    public void setInvocation(Invocation invocation) {
        this.invocation = invocation;
    }

    public Tone getTone() {
        return tone;
    }

    public void setTone(Tone tone) {
        this.tone = tone;
    }
}
