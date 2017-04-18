package com.example.luke.popmoves.utilities;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {

    //* -- Please insert your API key below -- *//

    private static String apiKey = "91a6615502eae75cc56bb476c2c8790c" ;
    private static String lang = "en-US";
    private static String page = "1";

    final static String BASE_URL =
            "http://api.themoviedb.org/3/movie/";

    final static String API_QUERY = "api_key";
    final static String LANG_QUERY = "language";
    final static String PAGE_QUERY= "page";

    public static URL moviesUrl(String sortBy) {
        Uri builtUri = Uri.parse(BASE_URL + sortBy).buildUpon()
                .appendQueryParameter(API_QUERY, apiKey)
                .appendQueryParameter(LANG_QUERY, lang)
                .appendQueryParameter(PAGE_QUERY, page)
                .build();

        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }


    public static String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}