package com.uc.webview.export.internal.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class cc implements Runnable {
    final /* synthetic */ bq a;
    final /* synthetic */ ValueCallback b;
    final /* synthetic */ Pair c;
    final /* synthetic */ by d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(by byVar, bq bqVar, ValueCallback valueCallback, Pair pair) {
        this.d = byVar;
        this.a = bqVar;
        this.b = valueCallback;
        this.c = pair;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        String str3;
        try {
            if (this.a.a()) {
                String d = com.uc.webview.export.internal.utility.j.d(this.d.getContext().getApplicationContext());
                str2 = by.a;
                Log.d(str2, ".shareCoreWaitTimeout localDir:" + d + " isWaitting:" + this.a.a());
                if (!com.uc.webview.export.internal.utility.p.a(d) && this.a.a()) {
                    this.d.d = d;
                    this.b.onReceiveValue(this.d);
                    this.a.a(8, null);
                } else if (this.a.a()) {
                    String e = com.uc.webview.export.internal.utility.j.e(this.d.getContext().getApplicationContext());
                    str3 = by.a;
                    Log.d(str3, ".shareCoreWaitTimeout decFile:" + e + " isWaitting:" + this.a.a());
                    if (!com.uc.webview.export.internal.utility.p.a(e) && this.a.a()) {
                        this.d.e = e;
                        this.b.onReceiveValue(this.d);
                        this.a.a(8, null);
                    } else if (((Integer) this.c.first).intValue() != 1) {
                        this.a.a(((Integer) this.c.first).intValue(), this.c.second);
                    }
                }
            }
        } catch (Throwable th) {
            str = by.a;
            Log.d(str, ".shareCoreWaitTimeout Thread ", th);
            if (((Integer) this.c.first).intValue() != 1) {
                this.a.a(((Integer) this.c.first).intValue(), this.c.second);
            }
        }
    }
}
