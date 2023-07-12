package com.vivo.push.util;

import android.content.Context;
import android.net.NetworkInfo;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class r {
    public static NetworkInfo a(Context context) {
        try {
            return ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Exception e) {
            p.a("NetUtils", e);
            return null;
        }
    }
}
