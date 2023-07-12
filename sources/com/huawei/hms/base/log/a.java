package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class a {
    public String b;
    public int a = 4;
    public b c = new e();

    public void a(Context context, int i, String str) {
        this.a = i;
        this.b = str;
        this.c.a(context, "HMSCore");
    }

    public void b(int i, String str, String str2, Throwable th) {
        if (a(i)) {
            c a = a(i, str, str2, th);
            b bVar = this.c;
            bVar.a(a.c() + a.a(), i, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }

    public b a() {
        return this.c;
    }

    public void a(b bVar) {
        this.c = bVar;
    }

    public boolean a(int i) {
        return i >= this.a;
    }

    public void a(int i, String str, String str2) {
        if (a(i)) {
            c a = a(i, str, str2, null);
            this.c.a(a.c() + a.a(), i, str, str2);
        }
    }

    public void a(String str, String str2) {
        c a = a(4, str, str2, null);
        this.c.a(a.c() + '\n' + a.a(), 4, str, str2);
    }

    public final c a(int i, String str, String str2, Throwable th) {
        c cVar = new c(8, this.b, i, str);
        cVar.a((c) str2);
        cVar.a(th);
        return cVar;
    }
}
