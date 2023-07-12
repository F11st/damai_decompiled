package com.meizu.cloud.pushsdk.a;

import android.content.Context;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.meizu.cloud.pushsdk.a.C5913b;
import com.meizu.cloud.pushsdk.a.a.C5911b;
import com.meizu.cloud.pushsdk.b.c.ExecutorC5928a;
import com.meizu.cloud.pushsdk.d.a.C6001c;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.a.a */
/* loaded from: classes10.dex */
public class C5909a {
    public static C6001c a(Context context) {
        C6001c c6001c = new C6001c();
        C5913b c = c(context);
        Map<String, String> a = c.a();
        Map<String, Object> b = c.b();
        Map<String, Object> c2 = c.c();
        if (a.size() > 0) {
            c6001c.a(AppIconSetting.DEFAULT_LARGE_ICON, a);
        }
        if (b.size() > 0) {
            c6001c.a(BQCCameraParam.FOCUS_TYPE_AI, b);
        }
        if (c2.size() > 0) {
            c6001c.a(AppIconSetting.LARGE_ICON_URL, c2);
        }
        return c6001c;
    }

    public static void b(final Context context) {
        ExecutorC5928a.a().execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                C5911b.a(context).a("POST", null, C5909a.a(context).toString());
            }
        });
    }

    private static C5913b c(Context context) {
        return new C5913b.C5914a().a(context).a();
    }
}
