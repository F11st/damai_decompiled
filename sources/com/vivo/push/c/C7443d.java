package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.c.d */
/* loaded from: classes11.dex */
public class C7443d {
    private static volatile C7443d d;
    private InterfaceC7441b a;
    private InterfaceC7442c b;
    private Context c;

    private C7443d(Context context) {
        if (this.a == null) {
            this.c = ContextDelegate.getContext(context.getApplicationContext());
            this.a = new C7444e(this.c);
        }
        if (this.b == null) {
            this.b = new C7440a();
        }
    }

    public static C7443d a(Context context) {
        if (d == null) {
            synchronized (C7443d.class) {
                if (d == null && context != null) {
                    d = new C7443d(context);
                }
            }
        }
        return d;
    }

    public final InterfaceC7441b a() {
        return this.a;
    }
}
