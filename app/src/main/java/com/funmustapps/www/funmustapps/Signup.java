package com.funmustapps.www.funmustapps;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



import org.json.JSONException;
import org.json.JSONObject;

import android.widget.TextView;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

public class Signup extends AppCompatActivity {
    private String TAG = Signup.class.getSimpleName();
    private Button btnJsonObj, btnJsonArray;
    private TextView msgResponse;
    private ProgressDialog pDialog;
    String site;
    private String tag_json_obj = "jobj_req",
            tag_json_arry = "jarray_req";

    String url = "http://funmustapps.com/playstore/api.php";
    EditText edit_usernamesignup,edit_Passwordsignup,edit_rePasswordsignup
            ,edit_name,edit_email;

    String Username=null,Password=null,Re_Password=null,email=null,name=null;
    Button btn_signup;
    TextView t;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


    edit_usernamesignup=(EditText)findViewById(R.id.edit_usernamesignup);
    edit_Passwordsignup=(EditText)findViewById(R.id.editText_passwordsignup);
    edit_rePasswordsignup=(EditText)findViewById(R.id.editText_repasswordsignup);
    edit_name=(EditText)findViewById(R.id.edit_namesignup);
    edit_email=(EditText)findViewById(R.id.edit_emailsignup);
    btn_signup=(Button)findViewById(R.id.btn_newsignup);
        t=(TextView)findViewById(R.id.textView);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Username = edit_usernamesignup.getText().toString();
                Password = edit_Passwordsignup.getText().toString();
                Re_Password = edit_rePasswordsignup.getText().toString();
                name = edit_name.getText().toString();
                email = edit_email.getText().toString();

                if(Username.isEmpty()){
                    edit_usernamesignup.setError("Required");

                }
                else if(Password.isEmpty()){
                    edit_usernamesignup.setError("Required");

                }
                else if(Re_Password.isEmpty()){
                    edit_usernamesignup.setError("Required");

                }else if(name.isEmpty()){
                    edit_usernamesignup.setError("Required");

                }else if(email.isEmpty()){
                    edit_usernamesignup.setError("Required");

                }
                else if(Password.equalsIgnoreCase(Re_Password)){

                    signup(name, Username, email, Password);

                  //  Toast.makeText(getApplicationContext(),"",Toast.LENGTH_LONG).show();


                }
                else {

                    Toast.makeText(getApplicationContext(),"Password Not Match",Toast.LENGTH_LONG).show();

                }



                //  Toast.makeText(getApplicationContext(), Password, Toast.LENGTH_SHORT).show();
                //   Toast.makeText(getApplicationContext(), Re_Password, Toast.LENGTH_SHORT).show();

                        //  String url = "http://httpbin.org/get?site=code&network=tutsplus";

                        // String url = "http://httpbin.org/post";
                    //    signup(name, Username, email, Password);
                        //   t.setText(site);
                        //   Toast.makeText(getApplicationContext(),site,Toast.LENGTH_LONG).toString();


            }
        });




    }





void signup(final String name,final String username,final  String email,final String password){
    //name=null;
    //username=null;

    final String[] s = new String[1];
    RequestParams params = new RequestParams();
                   params.add("request", "signup");
                   params.add("name", name);
                  params.add("user_name", username);
                  params.add("email", email);

                   params.add("password", password);

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
            //    Gson gson = new Gson();
        //    String res = gson.fromJson(response.toString(), Response.class);
            if (s[0].equalsIgnoreCase("OK")) {
              //  res.setUser(response);
              //  Log.d("user", res.getUser().toString());
    //Toast.makeText(getApplicationContext(),"Problem"+response,Toast.LENGTH_LONG).show();

                Intent i=new Intent(getApplicationContext(),LoginActivity.class);

                startActivity(i);


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










        // When the response returned by REST has Http response code '200'



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

















