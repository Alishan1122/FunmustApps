package com.funmustapps.www.funmustapps;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.funmustapps.www.funmustapps.About.AboutFragments;
import com.funmustapps.www.funmustapps.Apps.AppsCategory;
import com.funmustapps.www.funmustapps.Apps.Apps_Fragments;
import com.funmustapps.www.funmustapps.Games.AndroidGames;
import com.funmustapps.www.funmustapps.Games.GamesCategory;
import com.funmustapps.www.funmustapps.Profile_Fragments.ProfileFragments;
import com.funmustapps.www.funmustapps.Profile_Fragments.Uploaddata;
import com.funmustapps.www.funmustapps.Rintones.RingtoneFragment;
import com.funmustapps.www.funmustapps.Rintones.RingtonesCategory;
import com.funmustapps.www.funmustapps.SMS.SMSCategory;
import com.funmustapps.www.funmustapps.SMS.SmsFragments;
import com.funmustapps.www.funmustapps.Wallpapers.WallpapersCategory;
import com.funmustapps.www.funmustapps.Wallpapers.WallpapersFragments;

/**
 * Created by PC   Center on 10/23/2015.
 */
public class Fragment_main  extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
  //  private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */


    public Fragment_main (){
    }
    ListView L;
    TextView txt_apps,txt_games,txt_sms,txt_wallpapers,txt_ringtone,
            txt_about,txt_upload,txt_profile;
    String[] s={"A","s","d","f",};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main_actvity, container, false);


        txt_apps=(TextView)rootView.findViewById(R.id.android);
        txt_games=(TextView)rootView.findViewById(R.id.games);
        txt_sms=(TextView)rootView.findViewById(R.id.sms);
        txt_wallpapers=(TextView)rootView.findViewById(R.id.wallapares);
        txt_ringtone=(TextView)rootView.findViewById(R.id.ringtone);
        txt_upload=(TextView)rootView.findViewById(R.id.upload);
        txt_about=(TextView)rootView.findViewById(R.id.about);
        txt_profile=(TextView)rootView.findViewById(R.id.profile);



        txt_apps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //((MainActvity).getActivty()).loadFragment(new Apps_Fragments());

                ((MainActvity) getActivity()).loadFragment(new AppsCategory());

//                FragmentManager fragmentManager = getFragmentManager();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new Apps_Fragments())
//                        .commit();

//                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, Fragment_main.newInstance(position + 1))
//                        .commit();


            }
        });
        txt_games.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActvity) getActivity()).loadFragment( new GamesCategory());


            }
        });
        txt_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActvity) getActivity()).loadFragment(new SMSCategory());

            }
        });
        txt_wallpapers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActvity) getActivity()).loadFragment(new WallpapersCategory());

            }
        });
        txt_ringtone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActvity) getActivity()).loadFragment(new RingtonesCategory());

            }
        });
        txt_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActvity) getActivity()).loadFragment(new Uploaddata());


            }
        });
        txt_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActvity) getActivity()).loadFragment(new AboutFragments());


            }
        });

        txt_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActvity) getActivity()).loadFragment(new ProfileFragments());


            }
        });














        return rootView;





    }


}
