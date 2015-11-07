package com.funmustapps.www.funmustapps.Wallpapers;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.funmustapps.www.funmustapps.CategoryAdapter;
import com.funmustapps.www.funmustapps.R;
import com.funmustapps.www.funmustapps.RestApiClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;

import cz.msebera.android.httpclient.Header;

/**
 * Created by PC   Center on 10/25/2015.
 */
public class WallpapersCategory extends Fragment {

    public WallpapersCategory() {
    }
    private ProgressDialog pDialog;
    TextView txtUriPath,txtRealPath;
    String url = "http://funmustapps.com/playstore/api.php";
    ListView L;
    String realPath;
    String[] s = {
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
        View rootview = inflater.inflate(R.layout.wallpapers_cate_fragm, container, false);

        L = (ListView) rootview.findViewById(R.id.wall_list);


        L.setAdapter(new CategoryAdapter(getActivity(), s));



        return rootview;



    }

    void getsms(String id,String cate,String SubCate,File f) {


        final String[] s = new String[1];
        RequestParams params = new RequestParams();
        params.add("request", "upload_file");
        params.add("user_id", "category");
        params.add("user_id", "category");
        params.add("category", cate);
        params.add("sub_category", SubCate);


        RestApiClient.post(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                //    progressDialog.dismiss();
                hidepDialog();
                try {
                    s[0] = response.getString("Status");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //    Gson gson = new Gson();
                //    String res = gson.fromJson(response.toString(), Response.class);
                if (s[0].equalsIgnoreCase("OK")) {
                    //  res.setUser(response);
                    //  Log.d("user", res.getUser().toString());
                    Toast.makeText(getActivity(), "Problem" + response, Toast.LENGTH_LONG).show();

                    // Intent i = new Intent(getActivity(), MainActvity.class);

                    // startActivity(i);


                } else {
                    try {
                        s[0] = response.getString("Response");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Toast.makeText(getActivity(), "Problem" + s[0], Toast.LENGTH_LONG).show();


                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                //     progressDialog.dismiss();
                hidepDialog();
            }

            @Override
            public void onStart() {
                super.onStart();
                showpDialog();
                //    progressDialog = Utlity.showProgressDialog(getApplicationContext(), "Sign Up");
            }

        });

    }
    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
    public void setDefaultValues(){
        //  nameET.setText("");
        ///  emailET.setText("");
        //  pwdET.setText("");
    }
    @Override
    public void onActivityResult(int reqCode, int resCode, Intent data) {
        if(resCode == Activity.RESULT_OK && data != null){

            // SDK < API11
            if (Build.VERSION.SDK_INT < 11)
                realPath = RealPathUtil.getRealPathFromURI_BelowAPI11(getActivity(), data.getData());

                // SDK >= 11 && SDK < 19
            else if (Build.VERSION.SDK_INT < 19) {
                realPath = RealPathUtil.getRealPathFromURI_API11to18(getActivity(), data.getData());
                Toast.makeText(getActivity(),realPath, Toast.LENGTH_LONG).show();
                // SDK > 19 (Android 4.4)
            }
            else
                realPath = RealPathUtil.getRealPathFromURI_API19(getActivity(), data.getData());


            //setTextViews(Build.VERSION.SDK_INT, data.getData().getPath(),realPath);
        }
    }
    public static class RealPathUtil {

        @SuppressLint("NewApi")
        public static String getRealPathFromURI_API19(Context context, Uri uri) {
            String filePath = "";
            String wholeID = DocumentsContract.getDocumentId(uri);

            // Split at colon, use second item in the array
            String id = wholeID.split(":")[1];

            String[] column = {MediaStore.Images.Media.DATA};

            // where id is equal to
            String sel = MediaStore.Images.Media._ID + "=?";

            Cursor cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    column, sel, new String[]{id}, null);

            int columnIndex = cursor.getColumnIndex(column[0]);

            if (cursor.moveToFirst()) {
                filePath = cursor.getString(columnIndex);
            }
            cursor.close();
            return filePath;
        }


        @SuppressLint("NewApi")
        public static String getRealPathFromURI_API11to18(Context context, Uri contentUri) {
            String[] proj = {MediaStore.Images.Media.DATA};
            String result = null;

            CursorLoader cursorLoader = new CursorLoader(
                    context,
                    contentUri, proj, null, null, null);
            Cursor cursor = cursorLoader.loadInBackground();

            if (cursor != null) {
                int column_index =
                        cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                result = cursor.getString(column_index);
            }
            return result;
        }

        public static String getRealPathFromURI_BelowAPI11(Context context, Uri contentUri) {
            String[] proj = {MediaStore.Images.Media.DATA};
            Cursor cursor = context.getContentResolver().query(contentUri, proj, null, null, null);
            int column_index
                    = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        }
    }

}