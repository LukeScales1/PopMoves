package com.example.luke.popmoves;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.luke.popmoves.utilities.NetworkUtils;
import com.example.luke.popmoves.utilities.TmdbJsonUtils;

import java.net.URL;

public class DetailActivity extends AppCompatActivity {

    TextView mSearchResultsTextView;
    static String img;
    String sortBy = "";
//    static String postaaas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
//        mSearchResultsTextView = (TextView) findViewById(R.id.tv_test);
        loadMostPopularData();
    }

    private void loadMostPopularData() {
//        mSearchResultsTextView.setText("");
        sortBy = "popular?";
        new DetailActivity.TmdbQueryTask().execute(sortBy);
    }

    private void loadTopRatedData(){
//        mSearchResultsTextView.setText("");
        sortBy = "top_rated?";
        new DetailActivity.TmdbQueryTask().execute(sortBy);
    }

    public class TmdbQueryTask extends AsyncTask<String, Void, String[]> {

        @Override
        protected String[] doInBackground(String... params) {
            if (params.length == 0) {
                return null;
            }

            URL movieRequestUrl = NetworkUtils.moviesUrl(sortBy);
            try {
                String jsonMovieResponse = NetworkUtils
                        .getResponseFromHttpUrl(movieRequestUrl);

                String[] jsonMovieData = TmdbJsonUtils
                        .getPosterPathFromJson(DetailActivity.this, jsonMovieResponse);

                return jsonMovieData;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String[] movieData) {
            if (movieData != null) {
                for (String movieString : movieData) {
                    img = movieString;
//                    postaaas = movieString;
                }

            }
            }

        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_most_pop) {
//            populateMoviesList();
            loadMostPopularData();
            return true;
        }
        if (itemThatWasClickedId == R.id.action_top_rated) {
//            populateMoviesList();
            loadTopRatedData();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
