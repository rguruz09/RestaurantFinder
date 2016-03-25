package com.sjsu.raghu.restaurantfinder;

import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;


/**
 * Created by Raghu on 3/16/2016.
 */

public class CallYelpAPI {

//    private static final String DEFAULT_TERM = "Restaurant";
//    private static final String DEFAULT_LOCATION = "San Jose, CA";
//    private static final int SEARCH_LIMIT = 20;
//    private static final String SEARCH_PATH = "/v2/search";

    private static final String CONSUMER_KEY = "37P6ld4tnpVvz3YpluOuNw";
    private static final String CONSUMER_SECRET = "P3T0NjgHTo9AmO4TFg9vYK4BXtk";
    private static final String TOKEN = "280r6SUTDWYl6UvHEh4ZFWJ0lufA4mtz";
    private static final String TOKEN_SECRET = "dD7INWI-Z-LvlcPd5bbtJ2oWGB8";
    private static final String API_URL = "https://api.yelp.com/v2/search?term=Restaurant&location=San+Jose&linit=20";

    private OAuthProvider provider;
    private OAuthConsumer consumer;
    private String url;

    public CallYelpAPI(){
        this.consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
        consumer.setTokenWithSecret(TOKEN, TOKEN_SECRET);
    }

    public String makeAPICall() throws Exception{

        HttpClient httpclient = new DefaultHttpClient();
        HttpGet request = new HttpGet(API_URL);
        consumer.sign(request);
        HttpResponse response = httpclient.execute(request);
        Log.d("TAG_AFR","HHTP REsponse");
        InputStream data = response.getEntity().getContent();
        String responeLine = "";
        if (data != null)
            responeLine =  convertInputStreamToString(data);
        else
            responeLine = "No Data";

        JSONObject myObject = new JSONObject(responeLine);
        return "";

    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        InputStreamReader is = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(is);
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

}




























