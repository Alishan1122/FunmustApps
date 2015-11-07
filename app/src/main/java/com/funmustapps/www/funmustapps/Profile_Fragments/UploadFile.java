package com.funmustapps.www.funmustapps.Profile_Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.funmustapps.www.funmustapps.R;

/**
 * Created by PC   Center on 11/6/2015.
 */
public class UploadFile extends Fragment {

   public  UploadFile(){


    }

    @Nullable
    Button fileupload;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View  rootview= inflater.inflate(R.layout.upload_fragment, container, false);
          fileupload=(Button)rootview.findViewById(R.id.selectfile);

        fileupload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });


        return rootview;
    }


}
