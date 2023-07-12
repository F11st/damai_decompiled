package com.xiaomi.push;

import android.content.Context;
import android.os.IBinder;
import com.xiaomi.push.bb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
class bd implements Runnable {
    final /* synthetic */ IBinder a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ bb.ServiceConnectionC7607b f128a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bb.ServiceConnectionC7607b serviceConnectionC7607b, IBinder iBinder) {
        this.f128a = serviceConnectionC7607b;
        this.a = iBinder;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Context context;
        String b;
        Object obj5;
        Object obj6;
        try {
            context = bb.this.f123a;
            String packageName = context.getPackageName();
            b = bb.this.b();
            bb.C7606a c7606a = new bb.C7606a();
            c7606a.f127a = bb.C7608c.a(this.a, packageName, b, "GUID");
            c7606a.b = bb.C7608c.a(this.a, packageName, b, "OUID");
            c7606a.c = bb.C7608c.a(this.a, packageName, b, "DUID");
            c7606a.d = bb.C7608c.a(this.a, packageName, b, "AUID");
            bb.this.f125a = c7606a;
            bb.this.m691b();
            bb.this.f122a = 2;
            obj5 = bb.this.f126a;
            synchronized (obj5) {
                try {
                    obj6 = bb.this.f126a;
                    obj6.notifyAll();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            bb.this.m691b();
            bb.this.f122a = 2;
            obj3 = bb.this.f126a;
            synchronized (obj3) {
                try {
                    obj4 = bb.this.f126a;
                    obj4.notifyAll();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            bb.this.m691b();
            bb.this.f122a = 2;
            obj = bb.this.f126a;
            synchronized (obj) {
                try {
                    obj2 = bb.this.f126a;
                    obj2.notifyAll();
                } catch (Exception unused4) {
                }
                throw th;
            }
        }
    }
}
