package com.amap.api.col.s;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class dj {
    private Context a;
    private bv b;
    private String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] a() {
        return bw.a(a(this.a, this.b, this.c));
    }

    private static String a(Context context, bv bvVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(bvVar.d());
            sb.append("\",\"product\":\"");
            sb.append(bvVar.b());
            sb.append("\",\"nt\":\"");
            sb.append(bo.d(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
