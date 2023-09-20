package com.zebra.profilemanagerjs;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    private static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main_activity_layout);
        testClockJS();
    }

    private void testClockJS()
    {
        String profileData = "setSystemSetting(\"AutoTimeZone:auto_time_zone\",\"1\");setSystemSetting(\"AutoTime:auto_time\",\"0\");setTime(\"Local\",\"01:00:00\");setDate(\"Local\",\"2023-12-11\");";

        ProfileManagerCommand profileManagerCommand = new ProfileManagerCommand(this);
        profileManagerCommand.execute(profileData, "clock", new IResultCallbacks() {
            @Override
            public void onSuccess(String message, String resultXML) {
                Log.d(TAG,"Profile completed with success.");
                Log.d(TAG,"Message=" + message);
                Log.d(TAG, "Result=" + resultXML);
            }

            @Override
            public void onError(String message, String resultXML) {
                Log.d(TAG,"Profile completed with errors.");
                Log.d(TAG,"Message=" + message);
                Log.d(TAG, "Result=" + resultXML);
            }

            @Override
            public void onDebugStatus(String message) {
                Log.v(TAG, "Verbose=" + message);
            }
        });

    }
}
