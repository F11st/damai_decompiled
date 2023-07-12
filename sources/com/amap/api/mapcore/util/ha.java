package com.amap.api.mapcore.util;

import android.content.Context;
import java.lang.Thread;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ha {
    protected static ha a;
    protected Thread.UncaughtExceptionHandler b;
    protected boolean c = true;

    public static void a(Throwable th, String str, String str2) {
        ha haVar = a;
        if (haVar != null) {
            haVar.a(th, 1, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context, gm gmVar, boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(gm gmVar, String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Throwable th, int i, String str, String str2) {
    }
}
