package pl.mosenko.churchorganisttrainer.utils;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by syk on 04.10.17.
 */

public class DateTypeConverter {

    @TypeConverter
    public static Long fromDate(Date date) {
        if (date == null) {
            return null;
        }

        return date.getTime();
    }

    @TypeConverter
    public static Date toDate(Long millisSinceEpoch) {
        if (millisSinceEpoch == null) {
            return null;
        }

        return new Date(millisSinceEpoch);
    }
}
