package com.alipay.sdk.m.n0;

import android.content.Context;
import com.alipay.sdk.m.l0.C4243f;
import com.ta.audid.Constants;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.n0.a */
/* loaded from: classes12.dex */
public class C4255a {
    public static String a(Context context) {
        C4256b b = C4257c.b(context);
        return (b == null || C4243f.m215a(b.c())) ? Constants.UTDID_INVALID : b.c();
    }

    public static String b(Context context) {
        String a = C4258d.a(context).a();
        return (a == null || C4243f.m215a(a)) ? Constants.UTDID_INVALID : a;
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
