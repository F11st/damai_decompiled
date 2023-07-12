package com.amap.api.mapcore.util;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class iq {
    private Context a;
    private gm b;
    private String c;

    public iq(Context context, gm gmVar, String str) {
        this.a = context.getApplicationContext();
        this.b = gmVar;
        this.c = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return gn.a(a(this.a, this.b, this.c));
    }

    private static String a(Context context, gm gmVar, String str) {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("\"sdkversion\":\"");
            sb.append(gmVar.c());
            sb.append("\",\"product\":\"");
            sb.append(gmVar.a());
            sb.append("\",\"nt\":\"");
            sb.append(gg.e(context));
            sb.append("\",\"details\":");
            sb.append(str);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return sb.toString();
    }
}
