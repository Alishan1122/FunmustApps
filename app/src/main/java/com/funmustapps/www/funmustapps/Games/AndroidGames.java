package com.funmustapps.www.funmustapps.Games;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.funmustapps.www.funmustapps.ListViewAdapter;
import com.funmustapps.www.funmustapps.R;

/**
 * Created by PC   Center on 10/24/2015.
 */
public class AndroidGames extends Fragment {

    public AndroidGames(){


    }
    ListView L;

    String[] s={"A","s","d","f",};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  rootview= inflater.inflate(R.layout.games_fragments, container, false);
       L=(ListView)rootview.findViewById(R.id.list_gamelist);
        L.setAdapter(new ListViewAdapter(getActivity(),s));

        return rootview;
    }
}
