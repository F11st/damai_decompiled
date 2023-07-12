package com.taobao.slide.plugin;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.taobao.windvane.jsbridge.WVResult;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.taobao.slide.api.SlideLoad;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SlideWVPlugin extends WVApiPlugin {
    private static final String METHOD_SLIDE_WV_APP = "getApp";
    public static final String SLIDE_PLUGIN_NAME = "Slide";

    private void getApp(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject g = SlideLoad.h().g();
            if (g != null) {
                WVResult wVResult = new WVResult();
                wVResult.addData("value", g);
                wVCallBackContext.success(wVResult);
            }
        } catch (JSONException unused) {
            WVResult wVResult2 = new WVResult();
            wVResult2.addData("msg", WVResult.ERROR_EXECUTE);
            wVCallBackContext.error(wVResult2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if (METHOD_SLIDE_WV_APP.equals(str)) {
            getApp(str2, wVCallBackContext);
            return true;
        }
        return false;
    }
}
