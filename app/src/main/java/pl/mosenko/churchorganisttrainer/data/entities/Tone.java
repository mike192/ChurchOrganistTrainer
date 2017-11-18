package pl.mosenko.churchorganisttrainer.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static pl.mosenko.churchorganisttrainer.data.entities.Tone.TABLE_NAME;
import static pl.mosenko.churchorganisttrainer.data.entities.Tone.TONE_NAME_PL_COLUMN;
import static pl.mosenko.churchorganisttrainer.data.entities.Tone.TONE_NAME_US_COLUMN;

@Entity(tableName = TABLE_NAME, indices = {
        @Index(value = TONE_NAME_PL_COLUMN, unique = true),
        @Index(value = TONE_NAME_US_COLUMN, unique = true)})
public class Tone {
    public static final String TABLE_NAME = "tones";
    public static final String ID_COLUMN = "id";
    public static final String TONE_NAME_PL_COLUMN = "tone_name_pl";
    public static final String TONE_NAME_US_COLUMN = "tone_name_us";

    @PrimaryKey
    @ColumnInfo(name = ID_COLUMN)
    private int id;

    @ColumnInfo(name = TONE_NAME_PL_COLUMN)
    private String toneNamePL;

    @ColumnInfo(name = TONE_NAME_US_COLUMN)
    private String toneNameUS;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToneNamePL() {
        return toneNamePL;
    }

    public void setToneNamePL(String toneNamePL) {
        this.toneNamePL = toneNamePL;
    }

    public String getToneNameUS() {
        return toneNameUS;
    }

    public void setToneNameUS(String toneNameUS) {
        this.toneNameUS = toneNameUS;
    }

    @Override
    public String toString() {
        return "Tone{" +
                "id=" + id +
                ", toneNamePL='" + toneNamePL + '\'' +
                ", toneNameUS='" + toneNameUS + '\'' +
                '}';
    }
}