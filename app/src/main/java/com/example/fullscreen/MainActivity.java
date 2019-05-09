package com.example.fullscreen;

import android.app.ActionBar;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnEnterFullScreen;
    private Button mBtnExitFullScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnEnterFullScreen = findViewById(R.id.enter_fullscreen);
        mBtnEnterFullScreen.setOnClickListener(this);

        mBtnExitFullScreen = findViewById(R.id.exit_fullscreen);
        mBtnExitFullScreen.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        View decorView;
        int uiOptions;

        switch (v.getId()) {
            case R.id.enter_fullscreen:

                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

                decorView = getWindow().getDecorView();
                uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
                decorView.setSystemUiVisibility(uiOptions);

                break;
            case R.id.exit_fullscreen:

                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

                getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);



                break;
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);



        switch (newConfig.orientation)
        {
            case ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_PORTRAIT:

                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();



    }
}
