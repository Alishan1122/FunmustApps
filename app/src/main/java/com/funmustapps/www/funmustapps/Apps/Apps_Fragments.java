package com.funmustapps.www.funmustapps.Apps;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.funmustapps.www.funmustapps.ListViewAdapter;
import com.funmustapps.www.funmustapps.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class Apps_Fragments extends Fragment {

    public Apps_Fragments() {
    }
    ListView L;

    String[] s={"A","s","d","f",};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      View  rootview= inflater.inflate(R.layout.apps_fragment, container, false);

      L=(ListView)rootview.findViewById(R.id.appslistfragment);




      L.setAdapter(new ListViewAdapter(getActivity(),s));

      return rootview;


    }
}
