package com.crypho.plugins;

import android.content.Context;
import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;


public class ContextManager {

    static CordovaInterface cordova;

    public static void initialize(CordovaInterface cordovaInterface) {
        cordova = cordovaInterface;
    }

    public static Context getContext() {
        return cordova.getActivity().getApplicationContext();
    }

    public static Context getPackageContext(String packageName) throws Exception {
        Context pkgContext = null;

        Context context = getContext();
        if (context.getPackageName().equals(packageName)) {
            pkgContext = context;
        } else {
            pkgContext = context.createPackageContext(packageName, 0);
        }

        return pkgContext;
    }

    public static String getPackageName() {
        return getContext().getPackageName();
    }

    public static Object getSystemService() {
        return getContext().getSystemService(Context.KEYGUARD_SERVICE);
    }
}