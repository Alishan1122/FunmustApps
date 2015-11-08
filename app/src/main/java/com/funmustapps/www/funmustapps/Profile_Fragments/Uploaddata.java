package com.funmustapps.www.funmustapps.Profile_Fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.funmustapps.www.funmustapps.CategoryAdapter;
import com.funmustapps.www.funmustapps.Games.GamesCategory;
import com.funmustapps.www.funmustapps.ListViewAdapter;
import com.funmustapps.www.funmustapps.MainActvity;
import com.funmustapps.www.funmustapps.R;
import com.funmustapps.www.funmustapps.RestApiClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by PC   Center on 10/24/2015.
 */
public class Uploaddata extends Fragment {

    public Uploaddata(){

    }
    private ProgressDialog pDialog;
    String upload[]={"Apps","SMS","Wallpaper","Games","Ringtone"};
    String url = "http://funmustapps.com/playstore/api.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  rootview= inflater.inflate(R.layout.upload_fragment, container, false);

        ListView L=(ListView)rootview.findViewById(R.id.uploadfile);
         L.setAdapter(new CategoryAdapter(getActivity(), upload));

        L.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //  ((MainActvity) getActivity()).loadFragment( new UploadFile());
                if (position == 1) {

                    ((MainActvity) getActivity()).loadFragment( new Smsupload());


                }
            }
        });

        return rootview;
    }


}

