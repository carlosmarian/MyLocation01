package br.com.carlosmarian.mobile.mylocation;


import android.app.Application;
import android.support.multidex.MultiDex;

/**
 * Created by des on 05/10/16.
 */

public class MyLocationApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }


}
