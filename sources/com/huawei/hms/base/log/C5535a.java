package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.base.log.a */
/* loaded from: classes10.dex */
public class C5535a {
    public String b;
    public int a = 4;
    public InterfaceC5536b c = new C5539e();

    public void a(Context context, int i, String str) {
        this.a = i;
        this.b = str;
        this.c.a(context, "HMSCore");
    }

    public void b(int i, String str, String str2, Throwable th) {
        if (a(i)) {
            C5537c a = a(i, str, str2, th);
            InterfaceC5536b interfaceC5536b = this.c;
            interfaceC5536b.a(a.c() + a.a(), i, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }

    public InterfaceC5536b a() {
        return this.c;
    }

    public void a(InterfaceC5536b interfaceC5536b) {
        this.c = interfaceC5536b;
    }

    public boolean a(int i) {
        return i >= this.a;
    }

    public void a(int i, String str, String str2) {
        if (a(i)) {
            C5537c a = a(i, str, str2, null);
            this.c.a(a.c() + a.a(), i, str, str2);
        }
    }

    public void a(String str, String str2) {
        C5537c a = a(4, str, str2, null);
        this.c.a(a.c() + '\n' + a.a(), 4, str, str2);
    }

    public final C5537c a(int i, String str, String str2, Throwable th) {
        C5537c c5537c = new C5537c(8, this.b, i, str);
        c5537c.a((C5537c) str2);
        c5537c.a(th);
        return c5537c;
    }
}
