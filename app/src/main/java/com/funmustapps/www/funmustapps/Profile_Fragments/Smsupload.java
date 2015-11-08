package com.funmustapps.www.funmustapps.Profile_Fragments;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.funmustapps.www.funmustapps.MainActvity;
import com.funmustapps.www.funmustapps.R;
import com.funmustapps.www.funmustapps.RestApiClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

/**
 * Created by PC   Center on 11/8/2015.
 */
public class Smsupload extends Fragment implements AdapterView.OnItemSelectedListener {

   public Smsupload(){




    }
        String url = "http://funmustapps.com/playstore/api.php";
    String[] SMS={
            "Select Category",
            "Funny",
            "Urdu Poetry ",
            "Sad Shayari ",
            "Parveen Shakir",
            "Funny Poetry",
            "Wife Husband SMS",
            "Famous Urdu Poetey",
            "Faraz Ahmad Faraz",
            "Muslim Advise",
            "AprilFool",
            "ASCII Sms",
            "Anniversary Sms",
            "Birthday Sms",
            "Wishes Sms",
            "Christmas Sms",
            "Comedy Sms",
            "Deepawali Sms",
            "Eid Sms",
            "Exam Sms",
            "Angry Sms",
            "Cool Sms",
            "Cute Sms",
            "Encouragement",
            "Evening Sms",
            "Get Well Soon",
            "Sorry Sms",
            "Smile Sms",
            "Riddles Sms",
            "Nice Day Sms",
            "Good Morning Sms",
            "Love Sms",
            "Friendship Sms",
            "Life Sms",
            "Facts Sms",
            "April Fool Wish",
            "Inspirational Sms",
            "Caring Sms",
            "Insult Sms",
            "Fool Sms",
            "Romantic Sms",
            "Miss You Sms",
            "Rain Sms",
            "Good Luck Sms",
            "Advice Sms",
            "Attitude Sms",
            "Break Up Sms",
            "Dua Sms",
            "Politics Sms",
            "Marriage Sms",
            "HeartTouching",
            "Pathan Sms",
            "Student Sms",
            "Valentine Sms",
            "Sad Sms",
            "Sunday Sms",
            "Tears Sms",
            "Bewafa Sms",
            "Emotional Sms",
            "Forget Sms",
            "CID SMS",
            "Alok Nath Jokes",
            "Urdu SMS",
            "Gujrati SMS",
            "Hindi SMS",
            "Republic day",
            "Makar sankranti",
            "Santa Banta Jokes",
            "Pongal SMS",
            "Rajnikanth ",
            "Winter SMS",
            "Engineers SMS",
            "Holi SMS",
            "MunnaBhai SMS",
            "Birthday SMS",
            "Bengali SMS",
            "Malayalam SMS",
            "Marathi SMS",
            "Mubarak SMS",
            "Bollywood SMS",
            "AprilFool SMS",
            "Anneversary SMS",
            "Birthday SMS",
            "Bakra EID SMS",
            "BreakUP SMS",
            "Cool SMS",
            "Good LUCK SMS", // 6
            "Diwali SMS", "Dua SMS", "Exam SMS",
            "Funny SMS", // 10
            "Good Morning SMS",
            "Good Night  SMS", // 12
            "MissYou SMS",
            "NewYear SMS", // 14
            "Ramzan SMS",
            "Sorry SMS", // 16
            "Velentine DAY SMS",// 17
            "Urdu Poetry SMS",// 18
            "English Poetry",// 19
            "Love SMS", // 20
            "Islamic SMS",// 21
            "Eid SMS", // 22
            "Sardar SMS",// 23
            "Pathan SMS",// 24
            "Life SMS",
            "Jokes SMS",
            "AfterNoon SMS",
            "Friendship SMS",
            "Relational SMS",
    };
        Button btnUpload;
   static String item;
    EditText smstext;
    String sms;
      //  private ProgressDialog pDialog;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View  rootview= inflater.inflate(R.layout.uploadsms, container, false);
        //    pDialog = new ProgressDialog(getActivity());
        //    pDialog.setMessage("Please wait...");
       //     pDialog.setCancelable(false);
        final Spinner spinner = (Spinner)rootview.findViewById(R.id.spinner);
            btnUpload=(Button)rootview.findViewById(R.id.btnupload);
            smstext=(EditText)rootview.findViewById(R.id.editText);


        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, SMS); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);


            btnUpload.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        sms=smstext.getText().toString();
                        if(sms.isEmpty()){
                            smstext.setError("Enter sms");

                        }
                       else if(spinner.getSelectedItem().toString().equalsIgnoreCase("Select Category") )  {


                          //  Toast.makeText(getActivity(),"Select Category"+item,Toast.LENGTH_LONG).show();

                        }
                        else {
                            item=spinner.getSelectedItem().toString();
                               getsms(sms,"sms",item);
//
                        }
                    }

            });

          return rootview;

    }

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

           //      item = parent.getItemAtPosition(position).toString();
       //Toast.makeText(getActivity(),item,Toast.LENGTH_LONG).show();



        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }

        void getsms(String message,String category,String subcategory) {
                //name=null;
                //username=null;

                final String[] s = new String[1];
                RequestParams params = new RequestParams();
                params.add("request", "sms");
                params.add("user_id", "28");
                params.add("message", message);
                params.add("category", category);
                params.add("sub_category", subcategory);


                RestApiClient.post(url, params, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                super.onSuccess(statusCode, headers, response);
                                //    progressDialog.dismiss();
                                MainActvity.hidepDialog();
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
                                MainActvity.hidepDialog();
                        }

                        @Override
                        public void onStart() {
                                super.onStart();
                                MainActvity.showpDialog();
                                //    progressDialog = Utlity.showProgressDialog(getApplicationContext(), "Sign Up");
                        }

                });


        }


}
