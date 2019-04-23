package com.example.pulent.mvp.presenter.retrieve;
import android.os.AsyncTask;
import models.Song;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class JsonReader extends AsyncTask<String, Integer, String>{
    ArrayList<Song> arrayList = new ArrayList<>();
    JSONObject songObject;
    private JSONArray jsonArray;
    JSONObject jsonObject;

    SongRetriver songRetriver;

    public JsonReader(SongRetriver songRetriver) {
        this.songRetriver = songRetriver;
    }

    @Override
    protected String doInBackground(String... params) {
        return readURL(params[0]);
    }

    @Override
    protected void onPostExecute(String content) {
        try {
            jsonObject = new JSONObject(content);
            jsonArray =  jsonObject.getJSONArray("results");

            for(int i =0;i<jsonArray.length(); i++){
                songObject = jsonArray.getJSONObject(i);
                arrayList.add(new Song(
                    songObject.getString("trackName"),
                    songObject.getString("collectionName"),
                    songObject.getString("artworkUrl100"),
                    songObject.getString("artistName")
                ));
                songRetriver.retrieveSongs(arrayList);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private static String readURL(String theUrl) {
        StringBuilder content = new StringBuilder();
        try {
            // create a url object
            URL url = new URL(theUrl);
            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();
            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    private void getDataForThisPosition(Integer position) {
        try {
            jsonArray =  jsonObject.getJSONArray("results");

            songObject = jsonArray.getJSONObject(position);
            String kind =  songObject.getString("kind");
            String wrapperType =  songObject.getString("wrapperType");
            String trackName = songObject.getString("trackName");
            String artistId = songObject.getString("artistId");
            String artistName = songObject.getString("artistName");
            String collectionName = songObject.getString("collectionName");
            String trackCensoredName = songObject.getString("trackCensoredName");
            String releaseDate = songObject.getString("releaseDate");
            String country = songObject.getString("country");
            String currency = songObject.getString("currency");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public interface SongRetriver {
        void retrieveSongs(ArrayList<Song> songs);
    }
}
