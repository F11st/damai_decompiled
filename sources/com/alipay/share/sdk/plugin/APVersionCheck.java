package com.alipay.share.sdk.plugin;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class APVersionCheck {
    private Context a;

    public APVersionCheck(Context context) {
        this.a = context;
    }

    public int getZFBAppVersionCode() {
        try {
            return this.a.getPackageManager().getPackageInfo("com.eg.android.AlipayGphone", 64).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }
}
