package com.vivo.push.util;

import android.content.Context;
import android.net.NetworkInfo;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.util.r */
/* loaded from: classes11.dex */
public final class C7525r {
    public static NetworkInfo a(Context context) {
        try {
            return ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Exception e) {
            C7523p.a("NetUtils", e);
            return null;
        }
    }
}
