package pl.mosenko.churchorganisttrainer.data.entities;

import com.google.gson.Gson;

import org.junit.Test;

import pl.mosenko.churchorganisttrainer.R;
import pl.mosenko.churchorganisttrainer.utils.RawResourceUtil;

import static org.junit.Assert.*;

/**
 * Created by syk on 14.11.17.
 */
public class ToneTest {

    @Test
    public void testToneToJson() {
        //#"\u266F"
        //♭
        //"D\u266D"
        //Scientific pitch notation (or SPN,
        // also known as American Standard Pitch Notation (ASPN)
        // and International Pitch Notation (IPN))

        Tone tone1 = new Tone();
        tone1.setId(1);
        tone1.setToneNamePL("c");
        tone1.setToneNameUS("D\u00B9");
        Gson gson = new Gson();
        String json = gson.toJson(tone1);
        System.out.println(json);
    }
}