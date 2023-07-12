package com.loc;

import android.content.Context;
import android.os.Handler;
import tb.i73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class a1 extends ep<b1> {
    public a1(Context context, String str, Handler handler) {
        super(context, str, handler);
    }

    private static String w(b1 b1Var) {
        return b1Var == null ? "" : b1Var.b();
    }

    private static void x(b1 b1Var, long j) {
        if (b1Var != null) {
            b1Var.t = j;
        }
    }

    private static int y(b1 b1Var) {
        if (b1Var == null) {
            return 99;
        }
        return b1Var.s;
    }

    private static long z(b1 b1Var) {
        if (b1Var == null) {
            return 0L;
        }
        return b1Var.t;
    }

    @Override // com.loc.ep
    final /* bridge */ /* synthetic */ void e(b1 b1Var, long j) {
        x(b1Var, j);
    }

    @Override // com.loc.ep
    final long h() {
        return i73.c;
    }

    @Override // com.loc.ep
    public final /* synthetic */ String i(b1 b1Var) {
        return w(b1Var);
    }

    @Override // com.loc.ep
    final /* synthetic */ int l(b1 b1Var) {
        return y(b1Var);
    }

    @Override // com.loc.ep
    final long m() {
        return i73.d;
    }

    @Override // com.loc.ep
    final /* synthetic */ long o(b1 b1Var) {
        return z(b1Var);
    }
}
