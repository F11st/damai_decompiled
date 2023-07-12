package com.taobao.weex;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public interface IWXRenderListener {
    void onException(WXSDKInstance wXSDKInstance, String str, String str2);

    void onRefreshSuccess(WXSDKInstance wXSDKInstance, int i, int i2);

    void onRenderSuccess(WXSDKInstance wXSDKInstance, int i, int i2);

    void onViewCreated(WXSDKInstance wXSDKInstance, View view);
}
