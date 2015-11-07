package com.funmustapps.www.funmustapps.Rintones;

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
import com.funmustapps.www.funmustapps.R;
import com.funmustapps.www.funmustapps.RestApiClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by PC   Center on 10/25/2015.
 */
public class RingtonesCategory extends Fragment {

    public RingtonesCategory() {

    }
    ListView L;
    private ProgressDialog pDialog;
    String url = "http://funmustapps.com/playstore/api.php";
    String[] s={
            "Annoying Annoying Ringtones",


            "Blues Blues Ringtones",


            "Bollywood Bollywood Ringtones",


            "Country Ringtones",


            "Dance Dance Ringtones",


            "Disco Disco Ringtones",


            "Bass Ringtones",

            "Islamic ringtones",

            "National antham tunes",

            "Hollywood ringtones",

            "Bollywood ringtones",


            "Electronica Ringtones",


            "Folk Folk Ringtones"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  rootview= inflater.inflate(R.layout.ringtone_cate_fragment, container, false);

        L=(ListView)rootview.findViewById(R.id.list_ringtone);




        L.setAdapter(new CategoryAdapter(getActivity(),s));
        L.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                getringtones();

            }
        });

        return rootview;


    }
    void getringtones() {


        final String[] s = new String[1];
        RequestParams params = new RequestParams();
      //  params.add("request", "get_files");
     //   params.add("category", Cate);
     //   params.add("sub_category", SubCate);


        RestApiClient.get("cricscore-api.appspot.com", params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                //    progressDialog.dismiss();
                hidepDialog();
             //   try {
             //       s[0] = response.getString("Status");
            //    } catch (JSONException e) {
              //      e.printStackTrace();
           //     }
                //    Gson gson = new Gson();
                //    String res = gson.fromJson(response.toString(), Response.class);
          //      if (s[0].equalsIgnoreCase("OK")) {
                    //  res.setUser(response);
                    //  Log.d("user", res.getUser().toString());
                //    Toast.makeText(getActivity(), "Problem" + response, Toast.LENGTH_LONG).show();

                    // Intent i = new Intent(getActivity(), MainActvity.class);

                    // startActivity(i);


              //  } else {
              //      try {
                      //  s[0] = response.getString("Response");
               //     } catch (JSONException e) {
                 //       e.printStackTrace();
               //     }

                    Toast.makeText(getActivity(), response+"", Toast.LENGTH_LONG).show();


              //  }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                //     progressDialog.dismiss();
                hidepDialog();
            }

            @Override
            public void onStart() {
                super.onStart();
                showpDialog();
                //    progressDialog = Utlity.showProgressDialog(getApplicationContext(), "Sign Up");
            }

        });

    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
