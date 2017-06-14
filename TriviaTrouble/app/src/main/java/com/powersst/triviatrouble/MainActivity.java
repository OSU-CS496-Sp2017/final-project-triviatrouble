package com.powersst.triviatrouble;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.powersst.triviatrouble.utils.NetworkUtils;
import com.powersst.triviatrouble.utils.OpenTriviaUtils;

import java.io.IOException;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
{
    // MEMBERS
    private Bundle mSavedInstanceState;
    private Button mBtnBegin;
    private FloatingActionButton mFabLeaderboard;
    private FloatingActionButton mFabSettings;

    // METHODS
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String themeKey = sharedPreferences.getString(getString(R.string.preferences_theme_key), "");

        if(themeKey.equals("AppTheme")){
            setTheme(R.style.Default);
        }
        else if (themeKey.equals("AppThemeAlt")){
            setTheme(R.style.AppThemeAlt);
        }
        else{
            setTheme(R.style.Default);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "ON CREATE METHOD");

        // Capture references
        mSavedInstanceState = savedInstanceState;
        mBtnBegin = (Button) findViewById(R.id.btn_Main_Begin);
        mFabSettings = (FloatingActionButton) findViewById(R.id.fab_Main_Settings);
//        mFabLeaderboard = (FloatingActionButton) findViewById(R.id.fab_Main_Leaderboard);


        // Assign actions
        mBtnBegin.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), GameSetupActivity.class);
                startActivity(intent);
            }
        });

        mFabSettings.setOnClickListener(new FloatingActionButton.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(v.getContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });

//        mFabLeaderboard.setOnClickListener(new FloatingActionButton.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Intent intent = new Intent(v.getContext(), GameSetupActivity.class);
//                startActivity(intent);
//            }
//        });
    }

    /**
     * Generates and displays a toast.
     * Ref: https://developer.android.com/guide/topics/ui/notifiers/toasts.html
     *
     * @author  Makiah Merritt <merrittm@oregonstate.edu>
     * @param   toastContext    context for the toast
     * @param   toastMessage    text for the toast
     * @param   toastDuration   toast's duration
     * @return  none
     */
    public void generateToast(Context toastContext, String toastMessage, int toastDuration)
    {
        Context context = (toastContext == null ? getApplicationContext() : toastContext);
        String message = (toastMessage == null ? "ERROR: No toast message provided" : toastMessage);
        int duration = (toastDuration == 0 ? Toast.LENGTH_LONG : toastDuration);
        Toast toast = Toast.makeText(context, message, duration);
        toast.setGravity(Gravity.BOTTOM, 0, -24);
        toast.show();
    } /*-- /generateToast() declaration --*/

    /**
     * Overloads generateToast, to only receive the message. Default duration
     * is Toast.LENGTH_LONG and default context is the applications.
     *
     * @author  Makiah Merritt <merrittm@oregonstate.edu>
     * @param   toastMessage
     * @return  none
     */
    public void generateToast(String toastMessage)
    {
        String message = (toastMessage == null ? "ERROR: No toast message provided" : toastMessage);
        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        toast.show();
    } /*-- /generateToast() declaration --*/
}
/*
        doOpenTriviaSearch();
    }

    //Execute Search
    public void doOpenTriviaSearch() {
        Log.d("MainActivity", "doOpenTriviaSearch");

        String qAmount = "10";
        String qCategory = "9";
        String qDifficulty = "easy";
        String qType = "multiple";

        String openTriviaSearchUrl = OpenTriviaUtils.buildTriviaURL(qAmount, qCategory, qDifficulty, qType);
        Log.d("MainActivity", "got search url: " + openTriviaSearchUrl);
        new OpenTriviaSearchTask().execute(openTriviaSearchUrl);
    }


    private class OpenTriviaSearchTask extends AsyncTask<String, Void, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            mLoadingIndicatorPB.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... params) {
            String openWeatherSearchUrl = params[0];
            String searchResults = null;
            try {
                searchResults = NetworkUtils.doHTTPGet(openWeatherSearchUrl);
                Log.d("Main Activity", "searchResults " + searchResults);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return searchResults;
        }

        @Override
        protected void onPostExecute(String s) {
//            mLoadingIndicatorPB.setVisibility(View.INVISIBLE);
            if (s != null) {
//                mLoadingErrorMessageTV.setVisibility(View.INVISIBLE);
//                mForecastListRV.setVisibility(View.VISIBLE);
                ArrayList<OpenTriviaUtils.TriviaItem> searchResultsList = OpenTriviaUtils.parseTriviaJSON(s);
                Log.d("Main Activity", "Search Results list = " + searchResultsList);
//                mForecastAdapter.updateForecastData(searchResultsList);
            } else {
//                mForecastListRV.setVisibility(View.INVISIBLE);
//                mLoadingErrorMessageTV.setVisibility(View.VISIBLE);
            }
        }
    }
}
*/
