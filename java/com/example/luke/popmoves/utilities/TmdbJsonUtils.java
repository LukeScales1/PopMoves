package com.example.luke.popmoves.utilities;


import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class TmdbJsonUtils {

    public static String[] getPosterPathFromJson(Context context, String moviesJsonStr)
            throws JSONException {

        final String OWM_RESULTS = "results";
        final String OWM_POSTER = "poster_path";

        String[] parsedMovieData = null;

        JSONObject moviesJson = new JSONObject(moviesJsonStr);


        JSONArray movieArray = moviesJson.getJSONArray(OWM_RESULTS);

        parsedMovieData = new String[movieArray.length()];

        for (int i = 0; i < movieArray.length(); i++) {
            String posterPath;

            JSONObject results = movieArray.getJSONObject(i);
            posterPath = results.getString(OWM_POSTER);

            parsedMovieData[i] = posterPath;
        }

        return parsedMovieData;
    }

}
