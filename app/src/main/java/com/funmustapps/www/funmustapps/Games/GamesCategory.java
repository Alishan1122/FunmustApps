package com.funmustapps.www.funmustapps.Games;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.funmustapps.www.funmustapps.CategoryAdapter;
import com.funmustapps.www.funmustapps.R;

/**
 * Created by PC   Center on 10/25/2015.
 */
public class GamesCategory extends Fragment {

    public GamesCategory() {
    }
    ListView L;

    String[] s={
            "Action",
            "Adventure",
            "Arcade",
            "Cards & Casino",
            "Casual",
            "Kids",
            "Multiplayer",
            "Puzzles",
            "Racing",
            "Role Playing",
            "Shooter",
            "Sports Games",
            "Strategy",
            "Tower Defense",
    };
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View  rootview= inflater.inflate(R.layout.games_cate_frgm, container, false);

        L=(ListView)rootview.findViewById(R.id.listView_gamescate);




        L.setAdapter(new CategoryAdapter(getActivity(),s));

        return rootview;


    }
}
