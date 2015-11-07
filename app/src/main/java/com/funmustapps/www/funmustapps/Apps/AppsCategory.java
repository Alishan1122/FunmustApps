package com.funmustapps.www.funmustapps.Apps;

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
import com.funmustapps.www.funmustapps.MainActvity;
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
public class AppsCategory extends Fragment {
    private ProgressDialog pDialog;
    String url = "http://funmustapps.com/playstore/api.php";
    public AppsCategory() {



    }
    ListView L;

    String[] s={
            "All Apps",
            "Books & Reference",
            "Business",
            "Comics",
            "Communication",
            "Education",
            "Entertainment",
            "Finance",
            "Health & Fitness",
            "Libraries & Demo",
            "Lifestyle",
            "Media & Video",
            "Medical",
            "Music & Audio",
            "News & Magazines",
            "Personalization",
            "Photography",
            "Productivity",
            "Shopping",
            "Social",
            "Sports",
            "Tools",
            "Transportation",
            "Travel & Local",
            "Wallpaper",
            "Weather"
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View  rootview= inflater.inflate(R.layout.apps_fragment, container, false);

        L=(ListView)rootview.findViewById(R.id.appslistfragment);
        pDialog = new ProgressDialog(getActivity());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        L.setAdapter(new CategoryAdapter(getActivity(),s));

      L.setOnItemClickListener(new AdapterView.OnItemClickListener() {


          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//              ((MainActvity) getActivity()).loadFragment(new Apps_Fragments());
//
//              String tag_json_obj = "json_obj_req";
//
//              String url = "http://api.androidhive.info/volley/person_object.json";
//
//              final ProgressDialog pDialog = new ProgressDialog(getActivity());
//              pDialog.setMessage("Loading...");
//              pDialog.show();






          }
      });


         return rootview;


    }
    void getsms(String Cate,String SubCate){


        final String[] s = new String[1];
        RequestParams params = new RequestParams();
        params.add("request", "get_files");
        params.add("category", Cate);
        params.add("sub_category", SubCate);


        RestApiClient.post(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                //    progressDialog.dismiss();
                hidepDialog();
                try {
                    s[0] = response.getString("Status");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //    Gson gson = new Gson();
                //    String res = gson.fromJson(response.toString(), Response.class);
                if (s[0].equalsIgnoreCase("OK")) {
                    //  res.setUser(response);
                    //  Log.d("user", res.getUser().toString());
                    Toast.makeText(getActivity(), "Problem" + response, Toast.LENGTH_LONG).show();

                    // Intent i = new Intent(getActivity(), MainActvity.class);

                    // startActivity(i);


                } else {
                    try {
                        s[0] = response.getString("Response");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(getActivity(), "Problem" + s[0], Toast.LENGTH_LONG).show();


                }

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
    public void setDefaultValues(){
        //  nameET.setText("");
        ///  emailET.setText("");
        //  pwdET.setText("");
    }
}
