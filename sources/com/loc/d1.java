package com.loc;

import android.content.Context;
import android.os.Handler;
import tb.i73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class d1 extends ep<y0> {
    public d1(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    private static String w(y0 y0Var) {
        return y0Var == null ? "" : y0Var.b();
    }

    private static void x(y0 y0Var, long j) {
        if (y0Var != null) {
            y0Var.f = j;
        }
    }

    private static int y(y0 y0Var) {
        if (y0Var == null) {
            return -113;
        }
        return y0Var.c;
    }

    private static long z(y0 y0Var) {
        if (y0Var == null) {
            return 0L;
        }
        return y0Var.f;
    }

    @Override // com.loc.ep
    final /* bridge */ /* synthetic */ void e(y0 y0Var, long j) {
        x(y0Var, j);
    }

    @Override // com.loc.ep
    final long h() {
        return i73.a;
    }

    @Override // com.loc.ep
    public final /* synthetic */ String i(y0 y0Var) {
        return w(y0Var);
    }

    @Override // com.loc.ep
    final /* synthetic */ int l(y0 y0Var) {
        return y(y0Var);
    }

    @Override // com.loc.ep
    final long m() {
        return i73.b;
    }

    @Override // com.loc.ep
    final /* synthetic */ long o(y0 y0Var) {
        return z(y0Var);
    }
}
