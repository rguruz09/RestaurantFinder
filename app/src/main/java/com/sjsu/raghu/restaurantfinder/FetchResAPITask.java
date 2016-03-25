package com.sjsu.raghu.restaurantfinder;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

/**
 * Created by Raghu on 3/16/2016.
 */
public class FetchResAPITask extends AsyncTask<String, Intent, String> {

    private ProgressDialog progressDialog;
    private Context context;
    private HomeActivity homeActivity;
    private static final String TAG = "Fetch API ";
    CallYelpAPI callYelpAPI;

    public FetchResAPITask(HomeActivity activity){
        super();
        homeActivity = activity;
        callYelpAPI = new CallYelpAPI();
        this.context = this.homeActivity.getApplicationContext();
    }

    public  FetchResAPITask(){
        callYelpAPI = new CallYelpAPI();
    }

//    @Override
//    protected void onPreExecute() {
//        super.onPreExecute();
//        progressDialog = ProgressDialog.show(this.homeActivity, "Getting Results", this.context.getResources().getString(R.string.fetching_data) , true, false);
//    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            Log.d(TAG, "Background:" + Thread.currentThread().getName());
            String result=callYelpAPI.makeAPICall();;// = LastFMHelper.downloadFromServer(params);
            return result;
        } catch (Exception e) {
            return new String();
        }
    }

}
