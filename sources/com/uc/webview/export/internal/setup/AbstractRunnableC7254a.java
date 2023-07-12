package com.uc.webview.export.internal.setup;

import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.uc.startup.C7302b;
import com.uc.webview.export.internal.utility.Log;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.internal.setup.a */
/* loaded from: classes11.dex */
public abstract class AbstractRunnableC7254a implements Runnable {
    private ValueCallback<AbstractRunnableC7254a> e;
    private int c = 0;
    private Throwable d = null;
    protected String a = AbstractRunnableC7254a.class.getSimpleName();
    protected Pair<Integer, Integer> b = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractRunnableC7254a() {
        this.e = null;
        this.e = null;
    }

    private void a(int i) {
        String str = this.a;
        Log.i(str, "notifyStatusChange status:" + i);
        this.c = i;
        ValueCallback<AbstractRunnableC7254a> valueCallback = this.e;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(this);
        }
    }

    protected abstract void a();

    @Override // java.lang.Runnable
    public void run() {
        long d = C7302b.d();
        a(1);
        Pair<Integer, Integer> pair = this.b;
        if (pair != null) {
            C7302b.a(((Integer) pair.first).intValue());
        }
        a();
        a(2);
        Pair<Integer, Integer> pair2 = this.b;
        if (pair2 != null) {
            C7302b.a(((Integer) pair2.second).intValue());
        }
        String str = this.a;
        Log.i(str, "execute cost:" + (C7302b.d() - d));
    }
}
