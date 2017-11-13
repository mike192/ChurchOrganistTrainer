package pl.mosenko.churchorganisttrainer.data.entities;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

/**
 * Created by syk on 13.11.17.
 */

public class InvocationRelational {
    @Embedded
    private Invocation invocation;
    @Relation(parentColumn = "lowest_tone_id", entityColumn = "id", entity = Tone.class)
    private Tone lowestToneId;
    @Relation(parentColumn = "highest_tone_id", entityColumn = "id", entity = Tone.class)
    private Tone highestToneId;

    public Invocation getInvocation() {
        return invocation;
    }

    public void setInvocation(Invocation invocation) {
        this.invocation = invocation;
    }

    public Tone getLowestToneId() {
        return lowestToneId;
    }

    public void setLowestToneId(Tone lowestToneId) {
        this.lowestToneId = lowestToneId;
    }

    public Tone getHighestToneId() {
        return highestToneId;
    }

    public void setHighestToneId(Tone highestToneId) {
        this.highestToneId = highestToneId;
    }
}
