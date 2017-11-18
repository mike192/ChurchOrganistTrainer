package pl.mosenko.churchorganisttrainer.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import pl.mosenko.churchorganisttrainer.R;
import pl.mosenko.churchorganisttrainer.data.entities.Tone;
import pl.mosenko.churchorganisttrainer.utils.RawResourceUtil;
import timber.log.Timber;

/**
 * Created by syk on 14.11.17.
 */

public class AppDatabaseCallback extends RoomDatabase.Callback {

    private final Context context;

    public AppDatabaseCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);
        insertTones(db);
    }

    private void insertTones(@NonNull SupportSQLiteDatabase db) {
        List<Tone> toneList = prepareToneList();
        insertTones(db, toneList);
    }

    private void insertTones(SupportSQLiteDatabase db, List<Tone> toneList) {
        for (Tone tone : toneList) {
            ContentValues toneContentValue = toneToContentValue(tone);
            db.insert(Tone.TABLE_NAME, SQLiteDatabase.CONFLICT_FAIL, toneContentValue);
            Timber.i("INSERTED: " + tone.toString());
        }
    }

    private ContentValues toneToContentValue(Tone tone) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Tone.ID_COLUMN, tone.getId());
        contentValues.put(Tone.TONE_NAME_PL_COLUMN, tone.getToneNamePL());
        contentValues.put(Tone.TONE_NAME_US_COLUMN, tone.getToneNameUS());
        return contentValues;
    }

    private List<Tone> prepareToneList() {
        String tonesJson = RawResourceUtil.readRawTextFile(context, R.raw.tones);
        return new Gson().fromJson(tonesJson, new TypeToken<List<Tone>>(){}.getType());
    }
}
