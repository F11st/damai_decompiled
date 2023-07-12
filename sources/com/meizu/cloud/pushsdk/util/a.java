package com.meizu.cloud.pushsdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    public static NetworkInfo a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean b(Context context) {
        NetworkInfo a = a(context);
        return a != null && a.isConnected() && a.getType() == 1;
    }
}
