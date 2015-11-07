package com.funmustapps.www.funmustapps.SMS;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.funmustapps.www.funmustapps.CategoryAdapter;
import com.funmustapps.www.funmustapps.LoginActivity;
import com.funmustapps.www.funmustapps.MainActvity;
import com.funmustapps.www.funmustapps.R;
import com.funmustapps.www.funmustapps.RestApiClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;
import java.io.File;
import java.io.FileNotFoundException;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import cz.msebera.android.httpclient.Header;

/**
 * Created by PC   Center on 10/25/2015.
 */
public class SMSCategory extends Fragment {
        TextView txtUriPath,txtRealPath;
    public SMSCategory() {
    }
    ListView L;
        String url = "http://funmustapps.com/playstore/api.php";
        private static final int FILE_SELECT_CODE = 0;
    String[] s={
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
        private ProgressDialog pDialog;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  rootview= inflater.inflate(R.layout.sms_cate_fragment, container, false);

        L=(ListView)rootview.findViewById(R.id.list_cate_sms);

            pDialog = new ProgressDialog(getActivity());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);


            L.setAdapter(new CategoryAdapter(getActivity(), s));
            L.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            // 1. on Upload click call ACTION_GET_CONTENT intent
//                            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                            // 2. pick image only
//                            intent.setType("image/*");
//                            // 3. start activity
//                            startActivityForResult(intent, 0);



                            // define onActivityResult to do something with picked image
                            //      getsms("sms",s[position]);

                       //     showFileChooser();


                    }
            });



        return rootview;


    }
        void getsms(final String Cate,final String subCate) {
                //name=null;
                //username=null;

                final String[] s = new String[1];
                RequestParams params = new RequestParams();
                params.add("request", "get_sms");
                params.add("category", Cate);
                params.add("sub_category", subCate);


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

}