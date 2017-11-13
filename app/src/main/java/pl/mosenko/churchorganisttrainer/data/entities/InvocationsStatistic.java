package pl.mosenko.churchorganisttrainer.data.entities;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "invocations_statistic", foreignKeys =
@ForeignKey(entity = Invocation.class,
        parentColumns = "id",
        childColumns = "invocation_id",
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
), indices = @Index("date_of_exercise"))
public class InvocationsStatistic {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "invocation_id")
    private int invocationId;

    @ColumnInfo(name = "date_of_exercise")
    private Date dateOfExercise;

    @ColumnInfo(name = "percentage_result")
    private Double percentageResult;

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

    public Date getDateOfExercise() {
        return dateOfExercise;
    }

    public void setDateOfExercise(Date dateOfExercise) {
        this.dateOfExercise = dateOfExercise;
    }

    public Double getPercentageResult() {
        return percentageResult;
    }

    public void setPercentageResult(Double percentageResult) {
        this.percentageResult = percentageResult;
    }
}
