package com.wheat.mobile.electriciantraning.Application;

import android.app.Application;

import com.taobao.weex.InitConfig;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;
import com.wheat.mobile.electriciantraning.adapter.ImageAdapter;
import com.wheat.mobile.electriciantraning.adapter.PlayDebugAdapter;

/**
 * Created by Administrator on 2016/8/31.
 */
public class WXApplication extends Application{
    @Override
    public void onCreate() {
        super.onCreate();

        WXEnvironment.addCustomOptions("appName","ElectricianTraning");

        WXSDKEngine.initialize(this,new InitConfig.Builder()
                .setImgAdapter(new ImageAdapter())
                .setDebugAdapter(new PlayDebugAdapter())
                .build());
    }
}
