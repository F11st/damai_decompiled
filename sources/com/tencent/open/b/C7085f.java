package com.tencent.open.b;

import com.tencent.open.utils.C7119g;
import com.tencent.open.utils.C7121i;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.b.f */
/* loaded from: classes11.dex */
public class C7085f {
    public static int a(String str) {
        int a;
        if (C7119g.a() == null || (a = C7121i.a(C7119g.a(), str).a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return a;
    }

    public static int a() {
        int a = C7121i.a(C7119g.a(), (String) null).a("Common_HttpRetryCount");
        if (a == 0) {
            return 2;
        }
        return a;
    }
}
