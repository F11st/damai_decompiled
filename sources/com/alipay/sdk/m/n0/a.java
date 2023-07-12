package com.alipay.sdk.m.n0;

import android.content.Context;
import com.ta.audid.Constants;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class a {
    public static String a(Context context) {
        b b = c.b(context);
        return (b == null || com.alipay.sdk.m.l0.f.m215a(b.c())) ? Constants.UTDID_INVALID : b.c();
    }

    public static String b(Context context) {
        String a = d.a(context).a();
        return (a == null || com.alipay.sdk.m.l0.f.m215a(a)) ? Constants.UTDID_INVALID : a;
    }

    @Deprecated
    public static String c(Context context) {
        return a(context);
    }

    @Deprecated
    public static String d(Context context) {
        return b(context);
    }
}
