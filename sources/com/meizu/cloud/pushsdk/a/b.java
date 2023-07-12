package com.meizu.cloud.pushsdk.a;

import android.content.Context;
import android.graphics.Point;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.d.f.e;
import com.meizu.cloud.pushsdk.notification.model.BrightRemindSetting;
import com.meizu.cloud.pushsdk.util.MzSystemUtils;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
    private static final String a = "b";
    private final HashMap<String, String> b;
    private final HashMap<String, Object> c;
    private final HashMap<String, Object> d;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        private Context a = null;

        public a a(Context context) {
            this.a = context;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    private b(a aVar) {
        this.b = new HashMap<>();
        this.c = new HashMap<>();
        this.d = new HashMap<>();
        d();
        if (aVar.a != null) {
            b(aVar.a);
            a(aVar.a);
            c(aVar.a);
            d(aVar.a);
        }
        DebugLogger.i(a, "Subject created successfully.");
    }

    private void a(String str, int i, int i2) {
        this.b.put(str, i + "." + i2);
    }

    private void a(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if ((obj instanceof String) && ((String) obj).isEmpty()) {
            return;
        }
        this.c.put(str, obj);
    }

    private void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.b.put(str, str2);
    }

    private void b(Context context) {
        a("op", e.c(context));
    }

    private void b(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        if ((obj instanceof String) && ((String) obj).isEmpty()) {
            return;
        }
        this.d.put(str, obj);
    }

    private void c(Context context) {
        b("nt", MzSystemUtils.getNetWorkType(context));
    }

    private void d() {
        a(BrightRemindSetting.BRIGHT_REMIND, Build.getBRAND());
        a("dc", Build.getMODEL());
        a("ot", Build.VERSION.getRELEASE());
        a("ov", android.os.Build.DISPLAY);
        a("ll", MzSystemUtils.getCurrentLanguage());
    }

    private void d(Context context) {
        a(IRequestConst.PN, (Object) context.getPackageName());
        a(XStateConstants.KEY_PV, (Object) MzSystemUtils.getAppVersionName(context));
        a("pvc", Integer.valueOf(MzSystemUtils.getAppVersionCode(context)));
        a("st", Integer.valueOf(!TextUtils.isEmpty(MzSystemUtils.findReceiver(context, "com.meizu.ups.push.intent.MESSAGE", context.getPackageName())) ? 1 : 0));
    }

    public Map<String, String> a() {
        return this.b;
    }

    public void a(Context context) {
        Point d = e.d(context);
        if (d == null) {
            DebugLogger.e(a, "screen information not available.");
        } else {
            a("ss", com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(d), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(d));
        }
    }

    public Map<String, Object> b() {
        return this.c;
    }

    public Map<String, Object> c() {
        return this.d;
    }
}
