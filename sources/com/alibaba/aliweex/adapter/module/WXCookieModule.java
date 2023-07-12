package com.alibaba.aliweex.adapter.module;

import android.taobao.windvane.WVCookieManager;
import android.text.TextUtils;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.WXModule;
import com.taobao.weex.utils.WXLogUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WXCookieModule extends WXModule {
    @JSMethod(uiThread = false)
    public String get() {
        String cookie = WVCookieManager.getCookie(this.mWXSDKInstance.getBundleUrl());
        WXLogUtils.v("WXCookieModule", "get cookie :" + cookie);
        return cookie;
    }

    @JSMethod(uiThread = false)
    public ArrayList getAllObjects() {
        String cookie = WVCookieManager.getCookie(this.mWXSDKInstance.getBundleUrl());
        if (cookie != null) {
            String[] split = cookie.replace("\"", "\\\\\"").split(";");
            ArrayList arrayList = new ArrayList();
            for (String str : split) {
                String[] split2 = str.split("=");
                if (split2.length > 1) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put("name", split2[0].trim());
                        hashMap.put("value", split2[1].trim());
                        arrayList.add(hashMap);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            WXLogUtils.v("WXCookieModule", "get cookies :" + arrayList.toString());
            return arrayList;
        }
        return null;
    }

    @JSMethod(uiThread = false)
    public void remove(String str) {
    }

    @JSMethod(uiThread = false)
    public void set(String str) {
        if (!TextUtils.isEmpty(str)) {
            WVCookieManager.setCookie(this.mWXSDKInstance.getBundleUrl(), str);
        }
        WXLogUtils.v("WXCookieModule", "set cookie :" + str);
    }

    @JSMethod(uiThread = false)
    public void setObject(String str) {
    }
}
