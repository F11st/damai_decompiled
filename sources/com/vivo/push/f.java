package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.b.h;
        if (context == null || TextUtils.isEmpty(this.a)) {
            return;
        }
        context2 = this.b.h;
        context3 = this.b.h;
        if (z.b(context2, context3.getPackageName(), this.a)) {
            this.b.i();
        }
    }
}
