package com.tencent.open.b;

import com.tencent.open.utils.i;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class f {
    public static int a(String str) {
        int a;
        if (com.tencent.open.utils.g.a() == null || (a = i.a(com.tencent.open.utils.g.a(), str).a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return a;
    }

    public static int a() {
        int a = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_HttpRetryCount");
        if (a == 0) {
            return 2;
        }
        return a;
    }
}
