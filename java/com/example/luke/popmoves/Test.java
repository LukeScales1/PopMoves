package com.example.luke.popmoves;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Test extends AppCompatActivity implements PosterAdapter.ItemClickListener{
    PosterAdapter posterAdapter;
        private ImageView mTestImageView;
//    private ImageView mTestImageView1;
    private TextView mSearchResultsTextView;
//    private ListView mTestList;
    static String img = "";
    String sortBy = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle b=this.getIntent().getExtras();
        String[] array=b.getStringArray("POSTER_PATHS");

        RecyclerView mPosterGrid = (RecyclerView) findViewById(R.id.rv_pics);

        int numberOfColumns = 6;
        mPosterGrid.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        posterAdapter = new PosterAdapter(this, array);
        posterAdapter.setClickListener(this);
        mPosterGrid.setAdapter(posterAdapter);
//        mSearchResultsTextView = (TextView) findViewById(R.id.tv_github_search_results_json);
//        mTestImageView = (ImageView) findViewById(R.id.iv_search_results);
//        mTestImageView1 = (ImageView) findViewById(R.id.iv_search_results1);
//        mTestList = (ListView) findViewById(R.id.lvUsers);
    }
    @Override
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + posterAdapter.getItem(position) + ", which is at cell position " + position);
    }

}
