package com.mobile.vivo.Common;

import android.app.Application;

/**
 * Created by android on 13/01/2018.
 */

public class MyApplication extends Application {
    private String TAG="MyApplication";
    @Override
    public void onCreate() {
        super.onCreate();
        new NukeSSLCerts().nuke();
    }
}
