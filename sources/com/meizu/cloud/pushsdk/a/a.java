package com.meizu.cloud.pushsdk.a;

import android.content.Context;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.meizu.cloud.pushsdk.a.b;
import com.meizu.cloud.pushsdk.d.a.c;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    public static c a(Context context) {
        c cVar = new c();
        b c = c(context);
        Map<String, String> a = c.a();
        Map<String, Object> b = c.b();
        Map<String, Object> c2 = c.c();
        if (a.size() > 0) {
            cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, a);
        }
        if (b.size() > 0) {
            cVar.a(BQCCameraParam.FOCUS_TYPE_AI, b);
        }
        if (c2.size() > 0) {
            cVar.a(AppIconSetting.LARGE_ICON_URL, c2);
        }
        return cVar;
    }

    public static void b(final Context context) {
        com.meizu.cloud.pushsdk.b.c.a.a().execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.meizu.cloud.pushsdk.a.a.b.a(context).a("POST", null, a.a(context).toString());
            }
        });
    }

    private static b c(Context context) {
        return new b.a().a(context).a();
    }
}
