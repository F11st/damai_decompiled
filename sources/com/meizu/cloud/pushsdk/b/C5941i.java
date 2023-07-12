package com.meizu.cloud.pushsdk.b;

import com.meizu.cloud.pushsdk.b.b.C5922a;
import com.meizu.cloud.pushsdk.b.b.C5926d;
import tb.gn1;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.b.i */
/* loaded from: classes10.dex */
public class C5941i {
    public static String a(String str) {
        C5926d a = C5922a.a("android.os.SystemProperties").a(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).a(str);
        if (a.a) {
            return (String) a.b;
        }
        return null;
    }
}
