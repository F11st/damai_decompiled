package com.alibaba.aliweex.adapter.module;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.taobao.windvane.jsbridge.WVCallMethodContext;
import android.taobao.windvane.jsbridge.WVJsBridge;
import android.taobao.windvane.jsbridge.WVPluginEntryManager;
import android.taobao.windvane.service.WVEventContext;
import android.taobao.windvane.service.WVEventListener;
import android.taobao.windvane.service.WVEventResult;
import android.taobao.windvane.service.WVEventService;
import android.text.TextUtils;
import com.alibaba.aliweex.interceptor.mtop.MtopTracker;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.mtop.wvplugin.MtopWVPlugin;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Destroyable;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.performance.WXStateRecord;
import com.taobao.weex.utils.WXLogUtils;
import java.util.HashMap;
import java.util.Map;
import tb.a03;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXWindVaneModule extends WXModule implements Destroyable {
    private static Map<String, MtopTracker> sMtopRequests = new HashMap();
    private WVPluginEntryManager mEntryManager = null;
    private a03 mIWVWebView = null;
    private a mEventListener = new a();

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    static class ActivityResultReceive extends BroadcastReceiver {
        private WVPluginEntryManager a;

        ActivityResultReceive() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (this.a != null) {
                this.a.onActivityResult(intent.getIntExtra("requestCode", -1), intent.getIntExtra("resultCode", -1), intent);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    static class a implements WVEventListener {
        private WXSDKInstance a;

        a() {
        }

        public void a() {
            this.a = null;
        }

        public void b(WXSDKInstance wXSDKInstance) {
            this.a = wXSDKInstance;
        }

        @Override // android.taobao.windvane.service.WVEventListener
        public WVEventResult onEvent(int i, WVEventContext wVEventContext, Object... objArr) {
            if (i != 3013 || objArr == null) {
                return null;
            }
            try {
                if (this.a != null) {
                    HashMap hashMap = new HashMap();
                    if (objArr.length >= 3) {
                        JSONObject parseObject = JSON.parseObject(objArr[2].toString());
                        for (String str : parseObject.keySet()) {
                            hashMap.put(str, parseObject.get(str));
                        }
                    }
                    this.a.fireGlobalEventCallback(objArr[1] == null ? "" : objArr[1].toString(), hashMap);
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
    }

    public WXWindVaneModule() {
        WVEventService.getInstance().addEventListener(this.mEventListener);
    }

    private void filterMtopRequest(JSONObject jSONObject, String str) {
        if (WXEnvironment.isApkDebugable() && jSONObject != null && MtopWVPlugin.API_SERVER_NAME.equals(jSONObject.getString("class"))) {
            MtopTracker m = MtopTracker.m();
            sMtopRequests.put(str, m);
            m.q(jSONObject.getJSONObject("data"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MtopTracker popMtopTracker(String str) {
        return sMtopRequests.remove(str);
    }

    @JSMethod
    public void call(String str, String str2) {
        boolean z;
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null || wXSDKInstance.getContext() == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (this.mEntryManager == null) {
            this.mIWVWebView = new a03(this.mWXSDKInstance);
            this.mEntryManager = new WVPluginEntryManager(this.mWXSDKInstance.getContext(), this.mIWVWebView);
        }
        a aVar = this.mEventListener;
        if (aVar != null) {
            aVar.b(this.mWXSDKInstance);
        }
        WVCallMethodContext wVCallMethodContext = new WVCallMethodContext();
        JSONObject parseObject = JSON.parseObject(str);
        filterMtopRequest(parseObject, str2);
        if (parseObject != null) {
            wVCallMethodContext.webview = this.mIWVWebView;
            wVCallMethodContext.objectName = parseObject.getString("class");
            wVCallMethodContext.methodName = parseObject.getString("method");
            wVCallMethodContext.params = parseObject.getString("data");
            if (MtopWVPlugin.API_SERVER_NAME.equalsIgnoreCase(wVCallMethodContext.objectName) && "send".equalsIgnoreCase(wVCallMethodContext.methodName)) {
                WXStateRecord d = WXStateRecord.d();
                String instanceId = this.mWXSDKInstance.getInstanceId();
                d.i(instanceId, "windvineMtopCall forCallBack:" + str2);
                z = true;
                WVJsBridge.getInstance().exCallMethod(this.mEntryManager, wVCallMethodContext, new com.alibaba.aliweex.adapter.module.a(this.mWXSDKInstance.getInstanceId(), str2, false, z), new com.alibaba.aliweex.adapter.module.a(this.mWXSDKInstance.getInstanceId(), str2, false, z));
            }
        }
        z = false;
        WVJsBridge.getInstance().exCallMethod(this.mEntryManager, wVCallMethodContext, new com.alibaba.aliweex.adapter.module.a(this.mWXSDKInstance.getInstanceId(), str2, false, z), new com.alibaba.aliweex.adapter.module.a(this.mWXSDKInstance.getInstanceId(), str2, false, z));
    }

    @JSMethod
    public void call2(String str, String str2, String str3, String str4) {
        WXSDKInstance wXSDKInstance = this.mWXSDKInstance;
        if (wXSDKInstance == null || wXSDKInstance.getContext() == null || TextUtils.isEmpty(str2)) {
            return;
        }
        if (this.mEntryManager == null) {
            this.mIWVWebView = new a03(this.mWXSDKInstance);
            this.mEntryManager = new WVPluginEntryManager(this.mWXSDKInstance.getContext(), this.mIWVWebView);
        }
        a aVar = this.mEventListener;
        if (aVar != null) {
            aVar.b(this.mWXSDKInstance);
        }
        WVCallMethodContext wVCallMethodContext = new WVCallMethodContext();
        try {
            filterMtopRequest(JSON.parseObject(str2), str3);
            if (TextUtils.isEmpty(str)) {
                WXSDKManager.v().a(this.mWXSDKInstance.getInstanceId(), str4, null);
            } else if (str.indexOf(".") == -1) {
                WXSDKManager.v().a(this.mWXSDKInstance.getInstanceId(), str4, null);
            } else {
                wVCallMethodContext.webview = this.mIWVWebView;
                wVCallMethodContext.objectName = str.substring(0, str.indexOf("."));
                wVCallMethodContext.methodName = str.substring(str.indexOf(".") + 1);
                wVCallMethodContext.params = str2;
                WVJsBridge.getInstance().exCallMethod(this.mEntryManager, wVCallMethodContext, new com.alibaba.aliweex.adapter.module.a(this.mWXSDKInstance.getInstanceId(), str4, true, false), new com.alibaba.aliweex.adapter.module.a(this.mWXSDKInstance.getInstanceId(), str3, true, false));
            }
        } catch (Throwable th) {
            WXLogUtils.w("Invalid param", th);
            WXSDKManager.v().a(this.mWXSDKInstance.getInstanceId(), str4, null);
        }
    }

    @Override // com.taobao.weex.common.Destroyable
    public void destroy() {
        a aVar = this.mEventListener;
        if (aVar != null) {
            aVar.a();
            WVEventService.getInstance().removeEventListener(this.mEventListener);
        }
        a03 a03Var = this.mIWVWebView;
        if (a03Var != null) {
            a03Var.a();
        }
        WVPluginEntryManager wVPluginEntryManager = this.mEntryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onDestroy();
        }
    }

    @Override // com.taobao.weex.common.WXModule
    public void onActivityResult(int i, int i2, Intent intent) {
        WVPluginEntryManager wVPluginEntryManager = this.mEntryManager;
        if (wVPluginEntryManager != null) {
            wVPluginEntryManager.onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }
}
