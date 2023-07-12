package com.taobao.weex.utils;

import android.net.Uri;
import android.view.View;
import com.alibaba.fastjson.JSONArray;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.WXSDKManager;
import com.taobao.weex.adapter.URIAdapter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ATagUtil {
    public static void onClick(View view, String str, String str2) {
        WXSDKInstance y = WXSDKManager.v().y(str);
        if (y == null) {
            return;
        }
        String uri = y.rewriteUri(Uri.parse(str2), URIAdapter.LINK).toString();
        JSONArray jSONArray = new JSONArray();
        jSONArray.add(uri);
        WXSDKManager.v().D().callModuleMethod(str, "event", "openURL", jSONArray);
    }
}
