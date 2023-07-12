package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.C7533z;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.vivo.push.f */
/* loaded from: classes11.dex */
public final class RunnableC7485f implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ C7481e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7485f(C7481e c7481e, String str) {
        this.b = c7481e;
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
        if (C7533z.b(context2, context3.getPackageName(), this.a)) {
            this.b.i();
        }
    }
}
