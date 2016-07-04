package com.app.liteorm;

import android.app.Application;
import android.content.Context;

/**
 * Created by ${zyj} on 2016/7/4.
 */
public class MyAppLication extends Application  {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext() ;
    }

    public static Context getContext() {
        return context;
    }
}
