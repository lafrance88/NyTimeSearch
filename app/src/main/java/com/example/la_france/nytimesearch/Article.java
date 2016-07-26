package com.example.la_france.nytimesearch;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by La-France on 7/22/2016.
 */
public class Article {


    public String getWebUrl() {
        return webUrl;
    }

    public String getThumbNail() {
        return thumbNail;
    }

    public String getHeadline() {
        return headline;
    }
    String webUrl;
    String headline;
    String thumbNail;

    public Article(JSONObject jsonObject){
        try{
            this.webUrl = jsonObject.getString("web_url");
            this.headline = jsonObject.getJSONObject("headline").getString("main");

            JSONArray multimedia = jsonObject.getJSONArray("multimedia");

            if(multimedia.length()>0) {
             JSONObject multimediaJson = multimedia.getJSONObject(0);
                this.thumbNail ="http://www.nytimes.com/" + multimediaJson.getString("url");
            }else {
             this.thumbNail = "";
            }



    }catch (JSONException e){

    }
    }
    public static ArrayList<Article> fromJSONArray(JSONArray array){
    ArrayList<Article> results = new ArrayList<>();
        for(int x=0; x<array.length(); x++){
     try {
         results.add(new Article(array.getJSONObject(x)));
     }catch(JSONException e){
         e.printStackTrace();
     }
    }
        return results;

}
}
