package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.service.C7777u;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hi {
    public static boolean a(Context context) {
        return !com.xiaomi.push.service.ca.f956a.isEmpty() && bj.e(context) && C7680j.m1095b(context);
    }

    public static boolean a(Context context, int i) {
        if (context != null && i > 0) {
            String m1239a = C7777u.m1239a(context);
            if (!TextUtils.isEmpty(m1239a)) {
                for (int i2 = 1; i2 <= i; i2++) {
                    if (C7661g.a(10) == C7787w.a(m1239a.substring(m1239a.length() - 1, m1239a.length()), -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
