package com.funmustapps.www.funmustapps;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;



import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;

import com.funmustapps.www.funmustapps.About.AboutFragments;
import com.funmustapps.www.funmustapps.Apps.AppsCategory;
import com.funmustapps.www.funmustapps.Apps.Apps_Fragments;
import com.funmustapps.www.funmustapps.Games.AndroidGames;
import com.funmustapps.www.funmustapps.Games.GamesCategory;
import com.funmustapps.www.funmustapps.Profile_Fragments.ProfileFragments;
import com.funmustapps.www.funmustapps.Rintones.RingtoneFragment;
import com.funmustapps.www.funmustapps.SMS.SmsFragments;
import com.funmustapps.www.funmustapps.Wallpapers.WallpapersFragments;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActvity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    public NavigationDrawerFragment mNavigationDrawerFragment;
    DrawerLayout mDrawerLayout;
   public static ArrayList<String> list = new ArrayList<String>();
    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    public static ProgressDialog pDialog;
   public static HashMap<String, String> contact = new HashMap<String, String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_actvity);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);

        // Set up the drawer.
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer, mDrawerLayout
        );
        }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments

        switch (position){

            case 0:
                loadFragment(new Fragment_main());
            break;
            case 1:
                loadFragment(new AppsCategory());
                break;
            case 2:
                loadFragment(new GamesCategory());
                break;
            case 3:

                loadFragment(new WallpapersFragments());
                break;
            case 4:
                loadFragment(new SmsFragments());
                break;
            case 5:
                loadFragment(new RingtoneFragment());
                break;
            case 6:
                loadFragment(new AboutFragments());
                break;
            case 7:
                loadFragment(new ProfileFragments());
                break;

        }

    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = "Home";
                break;
            case 2:
                mTitle = "Apps";
                break;
            case 3:
                mTitle = "Games";
                break;

            case 4:
                mTitle = "Wallpapers";
                break;
            case 5:
                mTitle = "SMS";
                break;
            case 6:
                mTitle = "RingtoneFragment";
                break;
            case 7:
                mTitle = "About us";
                break;
            case 8:
                mTitle = "Profile";
                break;


        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main_actvity, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(mNavigationDrawerFragment.mDrawerListView)){
            mDrawerLayout.closeDrawer(mNavigationDrawerFragment.mDrawerListView);
        }
        else {


            //   if(m)

            //    super.onBackPressed();
            if (getFragmentManager().getBackStackEntryCount()==1) {


                super.onBackPressed();


            }
            else {

                getFragmentManager().popBackStack();

            }
        }
    }
    public void loadFragment(Fragment fragment) {



        // create a transaction for transition here
        final FragmentTransaction transaction = getFragmentManager()
                .beginTransaction();
        //Fragment fragment=new Fragment();
        // put the fragment in place


        // this is the part that will cause a fragment to be added to backstack,
        // this way we can return to it at any time using this tag
        transaction.addToBackStack(fragment.getClass().getName());
        transaction.replace(R.id.container, fragment);
        transaction.commit();
    }
    public static void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    public static void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
