package com.amap.api.mapcore.util;

import android.content.Context;
import com.amap.api.mapcore.util.gm;
import com.amap.api.mapcore.util.hp;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.hn */
/* loaded from: classes10.dex */
public class C4576hn {
    private Context a;
    private gm b;
    private boolean c = true;
    private String d = "40C27E38DCAD404B5465362914090908";
    private jl e = new jl("40C27E38DCAD404B5465362914090908");

    public void a(Context context, boolean z, String str, String str2, String str3, String[] strArr) {
        try {
            gm a = new gm.C4569a(str, str2, str).a(strArr).a(str3).a();
            if (context != null && a != null) {
                Context applicationContext = context.getApplicationContext();
                this.a = applicationContext;
                this.b = a;
                this.c = z;
                this.e.a(applicationContext, a);
            }
        } catch (gb unused) {
        }
    }

    public void a(String str, String str2) {
        hp.C4578a.a.a(this.a, str, str2, this.e.a(this.a), this.c, this.b);
    }
}
