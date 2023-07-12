package com.alipay.sdk.m.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.m.m.a;
import com.alipay.sdk.m.u.n;
import com.taobao.weex.ui.module.WXModalUIModule;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class d {
    public static final int a = 1010;
    public static a b;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface a {
        void a(boolean z, JSONObject jSONObject, String str);
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, Context context) {
        return n.a(aVar, context, (List<a.b>) Collections.singletonList(new a.b("com.taobao.taobao", 0, "")), false);
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, Activity activity, int i, String str, String str2, a aVar2) {
        try {
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.u0);
            activity.startActivityForResult(new Intent(str2, Uri.parse(str)), i);
            b = aVar2;
            return true;
        } catch (Throwable th) {
            aVar2.a(false, null, "UNKNOWN_ERROR");
            com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.y0, th);
            return false;
        }
    }

    public static boolean a(com.alipay.sdk.m.s.a aVar, int i, int i2, Intent intent) {
        if (i == 1010 && intent != null) {
            a aVar2 = b;
            if (aVar2 == null) {
                return true;
            }
            b = null;
            if (i2 == -1) {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.x0, intent.toUri(1));
                aVar2.a(true, n.a(intent), WXModalUIModule.OK);
            } else if (i2 != 0) {
                com.alipay.sdk.m.k.a.b(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.w0, "" + i2);
            } else {
                com.alipay.sdk.m.k.a.a(aVar, com.alipay.sdk.m.k.b.l, com.alipay.sdk.m.k.b.v0, intent.toUri(1));
                aVar2.a(false, null, "CANCELED");
            }
            return true;
        }
        return false;
    }
}
