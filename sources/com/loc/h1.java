package com.loc;

import android.content.Context;
import com.loc.bl;
import com.uc.webview.export.media.CommandID;
import tb.t43;
import tb.u73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class h1 {
    private static h1 e;
    private Context a;
    private int b = j1.i;
    private boolean c = false;
    private int d = 0;

    private h1(Context context) {
        this.a = null;
        try {
            q1.a().c(context);
        } catch (Throwable unused) {
        }
        this.a = context;
        bg.b();
    }

    public static h1 a(Context context) {
        if (e == null) {
            e = new h1(context);
        }
        return e;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00e5 A[Catch: all -> 0x00f8, TryCatch #2 {all -> 0x0100, blocks: (B:2:0x0000, B:9:0x004f, B:11:0x0056, B:15:0x0065, B:7:0x0049, B:16:0x00d7, B:18:0x00e5, B:19:0x00ea), top: B:26:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String b(android.content.Context r9, double r10, double r12) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.h1.b(android.content.Context, double, double):java.lang.String");
    }

    public final t43 c(u73 u73Var) throws Throwable {
        if (this.c) {
            u73Var.f(bl.c.HTTPS);
        }
        return bg.c(u73Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0101 A[Catch: all -> 0x0108, TRY_LEAVE, TryCatch #1 {all -> 0x0108, blocks: (B:4:0x0012, B:6:0x007a, B:7:0x0081, B:10:0x008f, B:17:0x00e9, B:19:0x00f0, B:21:0x0101, B:15:0x00e3), top: B:28:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final tb.u73 d(android.content.Context r11, byte[] r12, java.lang.String r13, java.lang.String r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.h1.d(android.content.Context, byte[], java.lang.String, java.lang.String, boolean):tb.u73");
    }

    public final void e(long j, boolean z, int i) {
        try {
            this.c = z;
            this.b = Long.valueOf(j).intValue();
            this.d = i;
        } catch (Throwable th) {
            j1.h(th, "LocNetManager", CommandID.setOption);
        }
    }
}
