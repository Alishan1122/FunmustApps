package com.funmustapps.www.funmustapps;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class LoginActivity extends Activity {
    private ProgressDialog pDialog;
    Button b1,btn_Signup;
    EditText edit_username,edit_Password;
    String Username,Password;
    String username=null,password=null,email=null,id=null;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String url = "http://funmustapps.com/playstore/api.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_loginpage);



         preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
         editor = preferences.edit();

        b1=(Button)findViewById(R.id.btn_signin);
        edit_username=(EditText)findViewById(R.id.edit_usernamesignin);
        edit_Password=(EditText)findViewById(R.id.editText_passwordsignin);
        btn_Signup=(Button)findViewById(R.id.btn_signuppage);
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        Intent i=new Intent(getApplicationContext(),MainActvity.class);

                Username=edit_username.getText().toString();
                Password=edit_Password.getText().toString();
                  if(Username.isEmpty()){
                  edit_username.setError("Enter Name");

   //    Toast.makeText(getApplication(),Username+Password,Toast.LENGTH_LONG).show();

                    //  startActivity(i);


                  }
                else if (Password.isEmpty()){
                      edit_Password.setError("Enter Password");

                  }
    else {



                      singin(Username,Password);

                  }


            }


        });

        btn_Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent i=new Intent(getApplicationContext(),Signup.class);
                startActivity(i);




            }
        });

    }
void singin(String user,String Password){

    final String[] s = new String[1];
    RequestParams params = new RequestParams();
    params.add("request", "login");
    params.add("email", user);
    params.add("password", Password);



    RestApiClient.post(url, params, new JsonHttpResponseHandler() {
        @Override
        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
            super.onSuccess(statusCode, headers, response);
            //    progressDialog.dismiss();
            hidepDialog();
            try {
                s[0] =response.getString("Status");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String w=response.toString();
            //    Gson gson = new Gson();
            //    String res = gson.fromJson(response.toString(), Response.class);
            if (s[0].equalsIgnoreCase("OK")) {
                //  res.setUser(response);
                //  Log.d("user", res.getUser().toString());
          //     Toast.makeText(getApplicationContext(),response+"",Toast.LENGTH_LONG).show();

                JSONObject phone = null;
                try {
                    phone = response.getJSONObject("Response");
                     id = phone.getString("id");
                      username= phone.getString("user_name");
                    email= phone.getString("email");
                    password = phone.getString("password");



                    editor.putString("Login","OK");
                    editor.apply();
                    finish();
                  //  String home = phone.getString("user_name");
                   // String office = phone.getString(TAG_PHONE_OFFICE);
                 //   Toast.makeText(getApplicationContext(),mobile+"",Toast.LENGTH_LONG).show();

                } catch (JSONException e) {
                    e.printStackTrace();
                }




                Intent i2=new Intent(getApplicationContext(),MainActvity.class);

                List<String> allNames = new ArrayList<String>();

                JSONArray cast = null;



                startActivity(i2);


            } else {
                try {
                    s[0] =response.getString("Response");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(),"Problem"+s[0],Toast.LENGTH_LONG).show();


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
