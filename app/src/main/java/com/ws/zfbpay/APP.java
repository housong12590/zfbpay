package com.ws.zfbpay;

import android.app.Application;

import com.jmm.common.utils.Utils;


public class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
