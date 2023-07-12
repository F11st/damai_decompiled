package com.vivo.push.c;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class d {
    private static volatile d d;
    private b a;
    private c b;
    private Context c;

    private d(Context context) {
        if (this.a == null) {
            this.c = ContextDelegate.getContext(context.getApplicationContext());
            this.a = new e(this.c);
        }
        if (this.b == null) {
            this.b = new a();
        }
    }

    public static d a(Context context) {
        if (d == null) {
            synchronized (d.class) {
                if (d == null && context != null) {
                    d = new d(context);
                }
            }
        }
        return d;
    }

    public final b a() {
        return this.a;
    }
}
