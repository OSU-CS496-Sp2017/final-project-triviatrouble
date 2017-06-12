package com.powersst.triviatrouble;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by User on 6/9/2017.
 */

public class EndGameActivity extends AppCompatActivity {

    private Button mBtnShare;
    private Button mBtnStartNew;
    private int playerScore;
    private int totalScore;
    private TextView playerScoreTV;
    private TextView totalScoreTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        mBtnStartNew = (Button) findViewById(R.id.startNewBtn);
        mBtnShare = (Button) findViewById(R.id.shareBtn);
        playerScore = InGameActivity.getPlayerScore();
        totalScore = InGameActivity.getTotalScore();
        playerScoreTV = (TextView) findViewById(R.id.playerScoreTV);
        totalScoreTV = (TextView) findViewById(R.id.totalScoreTV);
        playerScoreTV.setText(String.valueOf(playerScore));
        totalScoreTV.setText(String.valueOf(totalScore));

        mBtnStartNew.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
