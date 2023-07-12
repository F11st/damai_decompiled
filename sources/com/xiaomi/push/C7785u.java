package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.AbstractC7535b;
import tb.gn1;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.u */
/* loaded from: classes11.dex */
public class C7785u {
    public static String a(String str, String str2) {
        try {
            return (String) C7786v.a(null, "android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            AbstractC7535b.m586a("SystemProperties.get: " + e);
            return str2;
        }
    }
}
