package com.uc.webview.export;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.webkit.ValueCallback;
import com.uc.webview.export.internal.SDKFactory;
import java.lang.reflect.Constructor;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class e implements Runnable {
    final /* synthetic */ Class a;
    final /* synthetic */ Class[] b;
    final /* synthetic */ Object[] c;
    final /* synthetic */ ValueCallback d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Class cls, Class[] clsArr, Object[] objArr, ValueCallback valueCallback) {
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
            f fVar = new f(this, declaredConstructor);
            if (SDKFactory.a().booleanValue() && WebView.getCoreType() == 0) {
                throw new RuntimeException("coreType is not valid. init maybe failed.");
            }
            handler.postAtFrontOfQueue(fVar);
        } catch (Throwable th) {
            this.d.onReceiveValue(new Pair(null, th));
        }
    }
}
