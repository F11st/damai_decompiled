package com.android.dingtalk.share.ddsharemodule;

import android.content.Context;
import android.content.Intent;
import com.android.dingtalk.share.ddsharemodule.message.BaseReq;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface IDDShareApi {
    int getDDSupportAPI();

    int getDDSupportAPI(Context context);

    boolean handleIntent(Intent intent, IDDAPIEventHandler iDDAPIEventHandler);

    boolean isDDAppInstalled();

    boolean isDDAppInstalled(Context context);

    boolean isDDSupportAPI();

    boolean isDDSupportAPI(Context context);

    boolean isDDSupportDingAPI();

    boolean isDDSupportDingAPI(Context context);

    boolean openDDApp();

    boolean openDDApp(Context context);

    boolean registerApp(Context context, String str);

    boolean registerApp(String str);

    boolean sendReq(BaseReq baseReq);

    boolean sendReqToDing(BaseReq baseReq);

    void unregisterApp();

    void unregisterApp(Context context);
}
