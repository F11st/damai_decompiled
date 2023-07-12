package com.loc;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class g1 {
    C5819e a;
    Context b;
    Messenger c = null;

    public g1(Context context) {
        this.a = null;
        this.b = null;
        this.b = context.getApplicationContext();
        this.a = new C5819e(this.b);
    }

    public final IBinder a(Intent intent) {
        this.a.w(intent);
        this.a.d(intent);
        Messenger messenger = new Messenger(this.a.s());
        this.c = messenger;
        return messenger.getBinder();
    }

    public final void b() {
        try {
            C5819e.C();
            this.a.n = m1.B();
            this.a.o = m1.g();
            this.a.c();
        } catch (Throwable th) {
            j1.h(th, "ApsServiceCore", "onCreate");
        }
    }

    public final void c() {
        try {
            C5819e c5819e = this.a;
            if (c5819e != null) {
                c5819e.s().sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            j1.h(th, "ApsServiceCore", "onDestroy");
        }
    }
}
