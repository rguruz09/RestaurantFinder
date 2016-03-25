package com.sjsu.raghu.restaurantfinder;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Raghu on 3/14/2016.
 */

public class SearchFragment extends Fragment{

//    CallYelpAPI callYelpAPI;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        callYelpAPI = new CallYelpAPI();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_search, container, false);

        Button btn = (Button) view.findViewById(R.id.tempBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                   new FetchResAPITask().execute("");
                }catch (Exception e){
                    Log.e("API_CALL", e.getLocalizedMessage());
                }

            }
        });

        return view;
    }
}
