package com.uc.webview.export.internal.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class a implements Runnable {
    private ValueCallback<a> e;
    private int c = 0;
    private Throwable d = null;
    protected String a = a.class.getSimpleName();
    protected Pair<Integer, Integer> b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a() {
        this.e = null;
        this.e = null;
    }

    private void a(int i) {
        String str = this.a;
        Log.i(str, "notifyStatusChange status:" + i);
        this.c = i;
        ValueCallback<a> valueCallback = this.e;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(this);
        }
    }

    protected abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        long d = com.uc.webview.export.internal.uc.startup.b.d();
        a(1);
        Pair<Integer, Integer> pair = this.b;
        if (pair != null) {
            com.uc.webview.export.internal.uc.startup.b.a(((Integer) pair.first).intValue());
        }
        a();
        a(2);
        Pair<Integer, Integer> pair2 = this.b;
        if (pair2 != null) {
            com.uc.webview.export.internal.uc.startup.b.a(((Integer) pair2.second).intValue());
        }
        String str = this.a;
        Log.i(str, "execute cost:" + (com.uc.webview.export.internal.uc.startup.b.d() - d));
    }
}
