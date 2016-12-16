package com.bridgelabz.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class GameActivity extends AppCompatActivity {
    private static final String TAG = "GameActivity";

    public static final String KEY_LEVEL = "com.manico.chain_reaction.level";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Log.d(TAG, "onCreate()");
        setContentView(new GameView(this));
    }
}
