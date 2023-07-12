package com.alipay.sdk.m.b0;

import com.alipay.sdk.m.z.C4368a;
import java.io.File;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.b0.b */
/* loaded from: classes12.dex */
public final class C4146b {
    public static String a(String str) {
        String str2;
        try {
            str2 = C4150f.a(str);
        } catch (Throwable unused) {
            str2 = "";
        }
        if (C4368a.a(str2)) {
            return C4147c.a(".SystemConfig" + File.separator + str);
        }
        return str2;
    }
}
