package com.funmustapps.www.funmustapps;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.os.Handler;
import android.widget.ImageView;

public class Splash extends Activity {

    ImageView ib;
    SharedPreferences preferences;
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    ib=(ImageView)findViewById(R.id.imageButton);

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
//                String name = preferences.getString("Login", "");
//                if(name.equalsIgnoreCase("OK"))
//                {
//                  //  name = name + "  Sethi";  /* Edit the value here*/
//
//                    Intent i2 = new Intent(getApplicationContext(), MainActvity.class);
//
//                    startActivity(i2);
//                    finish();
//                }
//else {
//
//                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);
//
//                    startActivity(i);
//                    finish();
//                }
            }
       });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */

                preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                String name = preferences.getString("Login", "");
                if(name.equalsIgnoreCase("OK"))
                {
                  //  name = name + "  Sethi";  /* Edit the value here*/

                    Intent i2 = new Intent(getApplicationContext(), MainActvity.class);

                    startActivity(i2);
                    finish();
                }
         else {

                    Intent i = new Intent(getApplicationContext(), LoginActivity.class);

                    startActivity(i);
                    finish();
                }


            }
        }, SPLASH_DISPLAY_LENGTH);








    }


}
