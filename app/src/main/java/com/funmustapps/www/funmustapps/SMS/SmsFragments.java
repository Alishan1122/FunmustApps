package com.funmustapps.www.funmustapps.SMS;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.funmustapps.www.funmustapps.ArraylistAdapter;
import com.funmustapps.www.funmustapps.ListViewAdapter;
import com.funmustapps.www.funmustapps.MainActvity;
import com.funmustapps.www.funmustapps.R;

/**
 * Created by PC   Center on 10/24/2015.
 */
public class SmsFragments extends Fragment {

    public SmsFragments(){


    }
    ListView L;

    String[] s={"A","s","d","f",};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  rootview= inflater.inflate(R.layout.sms_fragmets, container, false);

        L=(ListView)rootview.findViewById(R.id.list_sms);
        L.setAdapter(new ArraylistAdapter(getActivity(), MainActvity.list));

        L.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            }
        });



         return rootview;
    }
}