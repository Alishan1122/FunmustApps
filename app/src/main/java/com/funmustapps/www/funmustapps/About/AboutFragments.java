package com.funmustapps.www.funmustapps.About;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.funmustapps.www.funmustapps.R;

/**
 * Created by PC   Center on 10/24/2015.
 */
public class AboutFragments extends Fragment {

    public AboutFragments(){


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  rootview= inflater.inflate(R.layout.aboutus, container, false);

        return rootview;
    }
}
