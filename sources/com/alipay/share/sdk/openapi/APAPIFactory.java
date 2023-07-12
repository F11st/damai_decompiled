package com.alipay.share.sdk.openapi;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class APAPIFactory {
    private APAPIFactory() {
    }

    public static IAPApi createZFBApi(Context context, String str, boolean z) {
        return new APApiImlV1(context, str, z);
    }

    public static IAPApi createZFBApi(Context context, String str) {
        return new APApiImlV1(context, str);
    }
}
