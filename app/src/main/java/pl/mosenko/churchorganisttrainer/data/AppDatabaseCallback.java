package pl.mosenko.churchorganisttrainer.data;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import pl.mosenko.churchorganisttrainer.R;
import pl.mosenko.churchorganisttrainer.data.dao.ToneDao;
import pl.mosenko.churchorganisttrainer.data.entities.Tone;
import pl.mosenko.churchorganisttrainer.utils.RawResourceUtil;

/**
 * Created by syk on 14.11.17.
 */

public class AppDatabaseCallback extends RoomDatabase.Callback {

    private final Context context;
    private final ToneDao toneDao;

    public AppDatabaseCallback(Context context, ToneDao toneDao) {
        this.context = context;
        this.toneDao = toneDao;
    }

    @Override
    public void onCreate(@NonNull SupportSQLiteDatabase db) {
        super.onCreate(db);
        String tonesJson = RawResourceUtil.readRawTextFile(context, R.raw.tones);
        List<Tone> toneList = new Gson().fromJson(tonesJson, new TypeToken<List<Tone>>(){}.getType());
        toneDao.insertAll(toneList);

    }
}
