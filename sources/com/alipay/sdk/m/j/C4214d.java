package com.alipay.sdk.m.j;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.alipay.sdk.m.k.C4218a;
import com.alipay.sdk.m.k.C4226b;
import com.alipay.sdk.m.m.C4245a;
import com.alipay.sdk.m.s.C4293a;
import com.alipay.sdk.m.u.C4318n;
import com.taobao.weex.ui.module.WXModalUIModule;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.j.d */
/* loaded from: classes12.dex */
public class C4214d {
    public static final int a = 1010;
    public static InterfaceC4215a b;

    /* compiled from: Taobao */
    /* renamed from: com.alipay.sdk.m.j.d$a */
    /* loaded from: classes12.dex */
    public interface InterfaceC4215a {
        void a(boolean z, JSONObject jSONObject, String str);
    }

    public static boolean a(C4293a c4293a, Context context) {
        return C4318n.a(c4293a, context, (List<C4245a.C4247b>) Collections.singletonList(new C4245a.C4247b("com.taobao.taobao", 0, "")), false);
    }

    public static boolean a(C4293a c4293a, Activity activity, int i, String str, String str2, InterfaceC4215a interfaceC4215a) {
        try {
            C4218a.a(c4293a, C4226b.l, C4226b.u0);
            activity.startActivityForResult(new Intent(str2, Uri.parse(str)), i);
            b = interfaceC4215a;
            return true;
        } catch (Throwable th) {
            interfaceC4215a.a(false, null, "UNKNOWN_ERROR");
            C4218a.a(c4293a, C4226b.l, C4226b.y0, th);
            return false;
        }
    }

    public static boolean a(C4293a c4293a, int i, int i2, Intent intent) {
        if (i == 1010 && intent != null) {
            InterfaceC4215a interfaceC4215a = b;
            if (interfaceC4215a == null) {
                return true;
            }
            b = null;
            if (i2 == -1) {
                C4218a.a(c4293a, C4226b.l, C4226b.x0, intent.toUri(1));
                interfaceC4215a.a(true, C4318n.a(intent), WXModalUIModule.OK);
            } else if (i2 != 0) {
                C4218a.b(c4293a, C4226b.l, C4226b.w0, "" + i2);
            } else {
                C4218a.a(c4293a, C4226b.l, C4226b.v0, intent.toUri(1));
                interfaceC4215a.a(false, null, "CANCELED");
            }
            return true;
        }
        return false;
    }
}
