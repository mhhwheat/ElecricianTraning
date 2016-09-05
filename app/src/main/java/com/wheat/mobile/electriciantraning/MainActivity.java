package com.wheat.mobile.electriciantraning;

import android.app.Activity;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;
import com.taobao.weex.ui.view.WXWebView;
import com.taobao.weex.utils.WXFileUtils;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";

    private WXSDKInstance mInstance=new WXSDKInstance(this);

    private ViewGroup mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContainer=(ViewGroup)findViewById(R.id.sampler_container);

        mInstance.registerRenderListener(new IWXRenderListener() {
            @Override
            public void onViewCreated(WXSDKInstance instance, View view) {
                if(view instanceof WebView){
                    Log.i("MainActivity","view of WebView");
                }
                if(mContainer!=null){
                    mContainer.removeAllViews();
                    mContainer.addView(view);
                }
            }

            @Override
            public void onRenderSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onRefreshSuccess(WXSDKInstance instance, int width, int height) {

            }

            @Override
            public void onException(WXSDKInstance instance, String errCode, String msg) {

            }
        });

        mInstance.render(
                "MainActivity",
                WXFileUtils.loadAsset("tech_list.js",this),
                new HashMap<String, Object>(),
                null,-1,-1,
                WXRenderStrategy.APPEND_ASYNC);
    }
}
