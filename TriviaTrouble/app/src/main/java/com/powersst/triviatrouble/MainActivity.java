package com.powersst.triviatrouble;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "ON CREATE METHOD");

        // Capture references
        mSavedInstanceState = savedInstanceState;
        mBtnBegin = (Button) findViewById(R.id.btn_Main_Begin);
//        mFabSettings = (FloatingActionButton) findViewById(R.id.fab_Main_Settings);
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

//        mFabSettings.setOnClickListener(new FloatingActionButton.OnClickListener()
//        {
//            @Override
//            public void onClick(View v)
//            {
//                Intent intent = new Intent(v.getContext(), GameSetupActivity.class);
//                startActivity(intent);
//            }
//        });

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
