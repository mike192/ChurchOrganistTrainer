package pl.mosenko.churchorganisttrainer.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tones", indices = {
        @Index(value = "tone_name_pl", unique = true),
        @Index(value = "tone_name_us", unique = true)})
public class Tone {
    @PrimaryKey
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "tone_name_pl")
    private String toneNamePL;

    @ColumnInfo(name = "tone_name_us")
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