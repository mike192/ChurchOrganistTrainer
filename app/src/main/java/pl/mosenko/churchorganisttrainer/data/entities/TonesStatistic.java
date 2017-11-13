package pl.mosenko.churchorganisttrainer.data.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "tones_statistics", foreignKeys = {
        @ForeignKey(entity = Tone.class,
                parentColumns = "id",
                childColumns = "tone_id",
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = InvocationsStatistic.class,
                parentColumns = "id",
                childColumns = "invocation_statistic_id",
                onUpdate = ForeignKey.CASCADE,
                onDelete = ForeignKey.CASCADE),
})
public class TonesStatistic {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;
    @ColumnInfo(name = "tone_id")
    private int toneId;
    @ColumnInfo(name = "invocation_statistic_id")
    private int invocationsStatisticId;
    @ColumnInfo(name = "incorrect_answers_number")
    private int incorrectAnswersNumber;
    @ColumnInfo(name = "good_answers_number")
    private int goodAnswersNumber;
    @ColumnInfo(name = "perfect_answers_number")
    private int perfectAnswersNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getToneId() {
        return toneId;
    }

    public void setToneId(int toneId) {
        this.toneId = toneId;
    }

    public int getInvocationsStatisticId() {
        return invocationsStatisticId;
    }

    public void setInvocationsStatisticId(int invocationsStatisticId) {
        this.invocationsStatisticId = invocationsStatisticId;
    }

    public int getIncorrectAnswersNumber() {
        return incorrectAnswersNumber;
    }

    public void setIncorrectAnswersNumber(int incorrectAnswersNumber) {
        this.incorrectAnswersNumber = incorrectAnswersNumber;
    }

    public int getGoodAnswersNumber() {
        return goodAnswersNumber;
    }

    public void setGoodAnswersNumber(int goodAnswersNumber) {
        this.goodAnswersNumber = goodAnswersNumber;
    }

    public int getPerfectAnswersNumber() {
        return perfectAnswersNumber;
    }

    public void setPerfectAnswersNumber(int perfectAnswersNumber) {
        this.perfectAnswersNumber = perfectAnswersNumber;
    }
}
