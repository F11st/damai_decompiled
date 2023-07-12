package com.alibaba.aliweex.adapter.module;

import android.app.Activity;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXLogUtils;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXScreenModule extends WXModule {
    private static final String TAG = "WXScreenModule";

    @Nullable
    private Window getWindowIfExists() {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null) {
            return null;
        }
        Context context = wXSDKInstance.getContext();
        if (context == null || !(context instanceof Activity)) {
            context = this.mWXSDKInstance.getUIContext();
        }
        if (context == null || !(context instanceof Activity)) {
            return null;
        }
        return ((Activity) context).getWindow();
    }

    private void setOrClearFlags(int i, boolean z) {
        Window windowIfExists = getWindowIfExists();
        if (windowIfExists != null) {
            try {
                if (z) {
                    windowIfExists.addFlags(i);
                } else {
                    windowIfExists.clearFlags(i);
                }
            } catch (Exception e) {
                WXLogUtils.e(TAG, e.getMessage());
            }
        } else if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.e(TAG, "window not found");
        }
    }

    @JSMethod
    public void setAlwaysOn(boolean z) {
        setOrClearFlags(128, z);
    }

    @JSMethod
    public void setBrightness(float f) {
        float max = Math.max(-1.0f, Math.min(1.0f, f));
        Window windowIfExists = getWindowIfExists();
        if (windowIfExists != null) {
            try {
                WindowManager.LayoutParams attributes = windowIfExists.getAttributes();
                attributes.screenBrightness = max;
                windowIfExists.setAttributes(attributes);
            } catch (Exception e) {
                WXLogUtils.e(TAG, e.getMessage());
            }
        }
    }

    @JSMethod
    public void setCaptureEnabled(boolean z) {
        setOrClearFlags(8192, !z);
    }

    @JSMethod
    public void setOrientation(JSONObject jSONObject, JSCallback jSCallback) {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance != null) {
            Context context = wXSDKInstance.getContext();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                String string = (jSONObject == null || !jSONObject.containsKey("orientation")) ? "portrait" : jSONObject.getString("orientation");
                if (string.equalsIgnoreCase("landscape")) {
                    activity.setRequestedOrientation(0);
                } else if (string.equalsIgnoreCase("portrait")) {
                    activity.setRequestedOrientation(1);
                }
            }
        }
    }
}
