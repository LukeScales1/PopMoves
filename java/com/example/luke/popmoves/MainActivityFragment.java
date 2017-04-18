package com.example.luke.popmoves;

import android.support.v4.app.Fragment;

public class MainActivityFragment extends Fragment {

    private PosterPathAdapter posterAdapter;

    Movie[] moviePosters = {
        new Movie("/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg")
    };

    public MainActivityFragment() {
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.activity_fragment_main, container, false);
//
//        posterAdapter = new PosterPathAdapter(getActivity(), Arrays.asList(moviePosters));
//
//        // Get a reference to the ListView, and attach this adapter to it.
//        GridView gridView = (GridView) rootView.findViewById(R.id.poster_grid);
//        gridView.setAdapter(posterAdapter);
//
//        return rootView;
//    }

}
