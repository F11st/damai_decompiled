package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hi {
    public static boolean a(Context context) {
        return !com.xiaomi.push.service.ca.f956a.isEmpty() && bj.e(context) && j.m1095b(context);
    }

    public static boolean a(Context context, int i) {
        if (context != null && i > 0) {
            String m1239a = com.xiaomi.push.service.u.m1239a(context);
            if (!TextUtils.isEmpty(m1239a)) {
                for (int i2 = 1; i2 <= i; i2++) {
                    if (g.a(10) == w.a(m1239a.substring(m1239a.length() - 1, m1239a.length()), -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
