package com.taobao.weex.ui.module;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXMetaModule extends WXModule {
    public static final String DEVICE_WIDTH = "device-width";
    public static final String WIDTH = "width";

    @JSMethod(uiThread = false)
    public void getPageInfo(JSCallback jSCallback) {
        if (jSCallback == null) {
            return;
        }
        List<WXSDKInstance> allInstances = WXSDKManager.v().G().getAllInstances();
        HashMap hashMap = new HashMap(4);
        for (WXSDKInstance wXSDKInstance : allInstances) {
            if (!TextUtils.isEmpty(wXSDKInstance.getBundleUrl())) {
                hashMap.put(wXSDKInstance.getBundleUrl(), wXSDKInstance.getTemplateInfo());
            }
        }
        jSCallback.invoke(hashMap);
    }

    @JSMethod(uiThread = true)
    public void openLog(String str) {
        Application application = WXEnvironment.getApplication();
        if (application == null || (application.getApplicationInfo().flags & 2) == 0) {
            return;
        }
        if (WXUtils.getBoolean(str, Boolean.TRUE).booleanValue()) {
            WXEnvironment.setApkDebugable(true);
            WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
            if (wXSDKInstance != null) {
                Toast.makeText(wXSDKInstance.getContext(), "log open success", 0).show();
                return;
            }
            return;
        }
        WXEnvironment.setApkDebugable(false);
        WXSDKInstance wXSDKInstance2 = this.mWXSDKInstance;
        if (wXSDKInstance2 != null) {
            Toast.makeText(wXSDKInstance2.getContext(), "log close success", 0).show();
        }
    }

    @JSMethod(uiThread = false)
    public void setViewport(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject parseObject = JSON.parseObject(URLDecoder.decode(str, "utf-8"));
            Context context = this.mWXSDKInstance.getContext();
            if (DEVICE_WIDTH.endsWith(parseObject.getString("width"))) {
                int screenWidth = (int) (WXViewUtils.getScreenWidth(context) / WXViewUtils.getScreenDensity(context));
                this.mWXSDKInstance.setInstanceViewPortWidth(screenWidth, true);
                WXLogUtils.d("[WXMetaModule] setViewport success[device-width]=" + screenWidth);
                return;
            }
            int intValue = parseObject.getInteger("width").intValue();
            if (intValue > 0) {
                this.mWXSDKInstance.setInstanceViewPortWidth(intValue, true);
            }
            WXLogUtils.d("[WXMetaModule] setViewport success[width]=" + intValue);
        } catch (Exception e) {
            WXLogUtils.e("[WXMetaModule] alert param parse error ", e);
        }
    }
}
