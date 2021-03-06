package pl.mosenko.churchorganisttrainer.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import pl.mosenko.churchorganisttrainer.BuildConfig;

/**
 * Created by syk on 14.11.17.
 */

public class RawResourceUtil {

    private static final String TAG = RawResourceUtil.class.getSimpleName();
    private RawResourceUtil() {}

    public static String readRawTextFile(@NonNull Context context, @NonNull int resId) {
        InputStream inputStream = context.getResources().openRawResource(resId);
        return readTextFromInputStream(inputStream);
    }

    public static String readTextFromInputStream(InputStream inputStream) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            reader.close();
            return sb.toString();
        } catch (IOException e) {
            if (BuildConfig.DEBUG) {
                Log.e(TAG, "Exception during reading text from the raw file.", e);
            }
        }
        return null;
    }
}