package com.example.luke.popmoves;

public class Movie {
    String posterPath;

    public Movie(String pPath)
    {
        this.posterPath = pPath;

    }

}

//public Movie(JSONObject object){
//    try {
//        this.posterPath = object.getString("posterPath");
//    } catch (JSONException e) {
//        e.printStackTrace();
//    }
//}
//
//    public static ArrayList<Movie> fromJson(JSONArray jsonObjects) {
//        ArrayList<Movie> movies = new ArrayList<Movie>();
//        for (int i = 0; i < jsonObjects.length(); i++) {
//            try {
//                movies.add(new Movie(jsonObjects.getJSONObject(i)));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//        return movies;
//    }
//}
