package com.xiaomi.push;

import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class u {
    public static String a(String str, String str2) {
        try {
            return (String) v.a(null, "android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m586a("SystemProperties.get: " + e);
            return str2;
        }
    }
}
