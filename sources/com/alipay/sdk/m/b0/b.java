package com.alipay.sdk.m.b0;

import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class b {
    public static String a(String str) {
        String str2;
        try {
            str2 = f.a(str);
        } catch (Throwable unused) {
            str2 = "";
        }
        if (com.alipay.sdk.m.z.a.a(str2)) {
            return c.a(".SystemConfig" + File.separator + str);
        }
        return str2;
    }
}
