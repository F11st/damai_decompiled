package com.vivo.push.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import java.util.Iterator;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class n implements o {
    private static final String a = jn1.BRACKET_START_STR + Process.myPid() + jn1.BRACKET_END_STR;

    @Override // com.vivo.push.util.o
    public final int a(String str, String str2) {
        String concat = "VivoPush.".concat(String.valueOf(str));
        return Log.e(concat, a + str2);
    }

    @Override // com.vivo.push.util.o
    public final int b(String str, String str2) {
        String concat = "VivoPush.".concat(String.valueOf(str));
        return Log.w(concat, a + str2);
    }

    @Override // com.vivo.push.util.o
    public final int c(String str, String str2) {
        String concat = "VivoPush.".concat(String.valueOf(str));
        return Log.d(concat, a + str2);
    }

    @Override // com.vivo.push.util.o
    public final int d(String str, String str2) {
        if (p.a()) {
            String concat = "VivoPush.".concat(String.valueOf(str));
            return Log.i(concat, a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.o
    public final int e(String str, String str2) {
        if (p.a()) {
            String concat = "VivoPush.".concat(String.valueOf(str));
            return Log.v(concat, a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.o
    public final int a(String str, Throwable th) {
        return Log.e("VivoPush.".concat(String.valueOf(str)), Log.getStackTraceString(th));
    }

    @Override // com.vivo.push.util.o
    public final int b(String str, String str2, Throwable th) {
        if (p.a()) {
            String concat = "VivoPush.".concat(String.valueOf(str));
            return Log.i(concat, a + str2, th);
        }
        return -1;
    }

    @Override // com.vivo.push.util.o
    public final void c(Context context, String str) {
        if (a()) {
            a(context, str, 2);
        }
    }

    @Override // com.vivo.push.util.o
    public final void b(Context context, String str) {
        if (a()) {
            a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.o
    public final int a(String str, String str2, Throwable th) {
        String concat = "VivoPush.".concat(String.valueOf(str));
        return Log.e(concat, a + str2, th);
    }

    @Override // com.vivo.push.util.o
    public final String a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    @Override // com.vivo.push.util.o
    public final void a(Context context, String str) {
        if (a()) {
            a(context, str, 0);
        }
    }

    private void a(Context context, String str, int i) {
        com.vivo.push.b.n nVar = new com.vivo.push.b.n();
        nVar.b(str);
        nVar.a(i);
        if (i > 0) {
            d("LogController", str);
        }
        if (context.getPackageName().equals("com.vivo.pushservice")) {
            nVar.a(true);
            Iterator<String> it = com.vivo.push.e.a.a().b().iterator();
            while (it.hasNext()) {
                com.vivo.push.a.a.a(context, nVar, it.next());
            }
            return;
        }
        nVar.a(false);
        com.vivo.push.a.a.a(context, nVar, context.getPackageName());
    }

    private static boolean a() {
        p.a();
        return com.vivo.push.e.a.a().c();
    }
}
