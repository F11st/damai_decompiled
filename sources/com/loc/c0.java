package com.loc;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class c0 {
    private Context a;
    private u1 b;
    private String c;

    public c0(Context context, u1 u1Var, String str) {
        this.a = context.getApplicationContext();
        this.b = u1Var;
        this.c = str;
    }

    private static String a(Context context, u1 u1Var, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(u1Var.f());
            sb.append("\",\"product\":\"");
            sb.append(u1Var.a());
            sb.append("\",\"nt\":\"");
            sb.append(o.J(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] b() {
        return v1.p(a(this.a, this.b, this.c));
    }
}
