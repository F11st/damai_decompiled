package com.vivo.push.util;

import android.content.Context;
import android.os.Process;
import android.util.Log;
import com.vivo.push.a.C7411a;
import com.vivo.push.b.C7426n;
import com.vivo.push.e.C7483a;
import java.util.Iterator;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.vivo.push.util.n */
/* loaded from: classes11.dex */
public final class C7521n implements InterfaceC7522o {
    private static final String a = jn1.BRACKET_START_STR + Process.myPid() + jn1.BRACKET_END_STR;

    @Override // com.vivo.push.util.InterfaceC7522o
    public final int a(String str, String str2) {
        String concat = "VivoPush.".concat(String.valueOf(str));
        return Log.e(concat, a + str2);
    }

    @Override // com.vivo.push.util.InterfaceC7522o
    public final int b(String str, String str2) {
        String concat = "VivoPush.".concat(String.valueOf(str));
        return Log.w(concat, a + str2);
    }

    @Override // com.vivo.push.util.InterfaceC7522o
    public final int c(String str, String str2) {
        String concat = "VivoPush.".concat(String.valueOf(str));
        return Log.d(concat, a + str2);
    }

    @Override // com.vivo.push.util.InterfaceC7522o
    public final int d(String str, String str2) {
        if (C7523p.a()) {
            String concat = "VivoPush.".concat(String.valueOf(str));
            return Log.i(concat, a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.InterfaceC7522o
    public final int e(String str, String str2) {
        if (C7523p.a()) {
            String concat = "VivoPush.".concat(String.valueOf(str));
            return Log.v(concat, a + str2);
        }
        return -1;
    }

    @Override // com.vivo.push.util.InterfaceC7522o
    public final int a(String str, Throwable th) {
        return Log.e("VivoPush.".concat(String.valueOf(str)), Log.getStackTraceString(th));
    }

    @Override // com.vivo.push.util.InterfaceC7522o
    public final int b(String str, String str2, Throwable th) {
        if (C7523p.a()) {
            String concat = "VivoPush.".concat(String.valueOf(str));
            return Log.i(concat, a + str2, th);
        }
        return -1;
    }

    @Override // com.vivo.push.util.InterfaceC7522o
    public final void c(Context context, String str) {
        if (a()) {
            a(context, str, 2);
        }
    }

    @Override // com.vivo.push.util.InterfaceC7522o
    public final void b(Context context, String str) {
        if (a()) {
            a(context, str, 1);
        }
    }

    @Override // com.vivo.push.util.InterfaceC7522o
    public final int a(String str, String str2, Throwable th) {
        String concat = "VivoPush.".concat(String.valueOf(str));
        return Log.e(concat, a + str2, th);
    }

    @Override // com.vivo.push.util.InterfaceC7522o
    public final String a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    @Override // com.vivo.push.util.InterfaceC7522o
    public final void a(Context context, String str) {
        if (a()) {
            a(context, str, 0);
        }
    }

    private void a(Context context, String str, int i) {
        C7426n c7426n = new C7426n();
        c7426n.b(str);
        c7426n.a(i);
        if (i > 0) {
            d("LogController", str);
        }
        if (context.getPackageName().equals("com.vivo.pushservice")) {
            c7426n.a(true);
            Iterator<String> it = C7483a.a().b().iterator();
            while (it.hasNext()) {
                C7411a.a(context, c7426n, it.next());
            }
            return;
        }
        c7426n.a(false);
        C7411a.a(context, c7426n, context.getPackageName());
    }

    private static boolean a() {
        C7523p.a();
        return C7483a.a().c();
    }
}
