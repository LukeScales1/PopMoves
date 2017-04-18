package com.example.luke.popmoves;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luke.popmoves.utilities.NetworkUtils;
import com.example.luke.popmoves.utilities.TmdbJsonUtils;

import java.net.URL;

public class MainActivity extends AppCompatActivity
        implements PosterAdapter.ItemClickListener{

    PosterAdapter posterAdapter;
    private RecyclerView mPosterGrid;
    private ImageView mTestImageView;
    private ImageView mTestImageView1;
    private TextView mSearchResultsTextView;
//    private ListView mTestList;
        static String img = "";
        String sortBy = "";
        String[] movieData;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            RecyclerView mPosterGrid = (RecyclerView) findViewById(R.id.rv_pics);

            int numberOfColumns = 6;
            mPosterGrid.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
            posterAdapter = new PosterAdapter(this, movieData);
            posterAdapter.setClickListener(this);
            mPosterGrid.setAdapter(posterAdapter);
//        mSearchResultsTextView = (TextView) findViewById(R.id.tv_github_search_results_json);
//        mTestImageView = (ImageView) findViewById(R.id.iv_search_results);
//        mTestImageView1 = (ImageView) findViewById(R.id.iv_search_results1);
//        mTestList = (ListView) findViewById(R.id.lvUsers);
            loadMostPopularData();
            Bundle b=new Bundle();
            b.putStringArray("POSTER_PATHS", movieData);
            Intent i=new Intent(this, Test.class);
            i.putExtras(b);
        }

        private void loadMostPopularData() {
//        mSearchResultsTextView.setText("");
            sortBy = "popular?";
            new com.example.luke.popmoves.MainActivity.TmdbQueryTask().execute(sortBy);
        }

        private void loadTopRatedData(){
//        mSearchResultsTextView.setText("");
            sortBy = "top_rated?";
            new com.example.luke.popmoves.MainActivity.TmdbQueryTask().execute(sortBy);
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
                            .getPosterPathFromJson(com.example.luke.popmoves.MainActivity.this, jsonMovieResponse);

                    return jsonMovieData;

                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(String[] movieData) {
//                Intent intent = new Intent(this, Test.class);
//                intent.putStringArrayListExtra(movieString, );
//                startActivity(intent);
//                break;
//                if (movieData != null) {



//                    for (String movieString : movieData) {
//                        img = movieString;
//                    mSearchResultsTextView.append((movieString) + "\n\n\n");
//                    img = "/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg";

//                        posterAdapter = new PosterPathAdapter(MainActivity.this, movieData);
//
//                        // Get a reference to the ListView, and attach this adapter to it.
//                        GridView gridView = (GridView) rootView.findViewById(R.id.poster_grid);
//                        gridView.setAdapter(posterAdapter);
//                    Context context = mTestImageView.getContext();
//                    Picasso.with(context).load("http://image.tmdb.org/t/p/w500/" + movieString).into(mTestImageView);
//                        Context context1 = mTestImageView1.getContext();
//                        Picasso.with(context1).load("http://image.tmdb.org/t/p/w500/" + movieString).into(mTestImageView1);
//                    String img1 = "/xq1Ugd62d23K2knRUx6xxuALTZB.jpg";
//                    Context context1 = mTestImageView1.getContext();
//                    Picasso.with(context1).load("http://image.tmdb.org/t/p/w500/" + img1).into(mTestImageView1);
//                    }
//                }

            }
        }

//    @Override
//    public void onGridItemClick(int clickedItemIndex) {
//        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//        startActivity(intent);
//    }

    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + posterAdapter.getItem(position) + ", which is at cell position " + position);
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