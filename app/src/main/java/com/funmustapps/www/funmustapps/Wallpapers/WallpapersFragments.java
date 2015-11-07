package com.funmustapps.www.funmustapps.Wallpapers;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import com.funmustapps.www.funmustapps.ListViewAdapter;
import com.funmustapps.www.funmustapps.R;

/**
 * Created by PC   Center on 10/24/2015.
 */
public class WallpapersFragments extends Fragment {

public WallpapersFragments(){


        }
    GridView grid_wallpapers;
    private ProgressDialog pDialog;

    String[] s={"A","s","d","f",};
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View  rootview= inflater.inflate(R.layout.wallpapers_fragments, container, false);




    grid_wallpapers=(GridView)rootview.findViewById(R.id.list_wall);

    grid_wallpapers.setAdapter(new ListViewAdapter(getActivity(),s));


        return rootview;


        }



        }
