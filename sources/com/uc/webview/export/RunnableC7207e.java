package com.uc.webview.export;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;
import java.lang.reflect.Constructor;

/* compiled from: Taobao */
/* renamed from: com.uc.webview.export.e */
/* loaded from: classes11.dex */
final class RunnableC7207e implements Runnable {
    final /* synthetic */ Class a;
    final /* synthetic */ Class[] b;
    final /* synthetic */ Object[] c;
    final /* synthetic */ ValueCallback d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC7207e(Class cls, Class[] clsArr, Object[] objArr, ValueCallback valueCallback) {
        this.a = cls;
        this.b = clsArr;
        this.c = objArr;
        this.d = valueCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Constructor declaredConstructor = this.a.getDeclaredConstructor(this.b);
            declaredConstructor.setAccessible(true);
            Handler handler = new Handler(Looper.getMainLooper());
            RunnableC7210f runnableC7210f = new RunnableC7210f(this, declaredConstructor);
            if (SDKFactory.a().booleanValue() && WebView.getCoreType() == 0) {
                throw new RuntimeException("coreType is not valid. init maybe failed.");
            }
            handler.postAtFrontOfQueue(runnableC7210f);
        } catch (Throwable th) {
            this.d.onReceiveValue(new Pair(null, th));
        }
    }
}
