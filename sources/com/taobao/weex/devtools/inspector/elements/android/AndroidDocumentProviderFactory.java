package com.taobao.weex.devtools.inspector.elements.android;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import com.taobao.weex.devtools.common.ThreadBound;
import com.taobao.weex.devtools.common.UncheckedCallable;
import com.taobao.weex.devtools.common.Util;
import com.taobao.weex.devtools.common.android.HandlerUtil;
import com.taobao.weex.devtools.inspector.elements.DocumentProvider;
import com.taobao.weex.devtools.inspector.elements.DocumentProviderFactory;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class AndroidDocumentProviderFactory implements ThreadBound, DocumentProviderFactory {
    private final Application mApplication;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    public AndroidDocumentProviderFactory(Application application) {
        this.mApplication = (Application) Util.throwIfNull(application);
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public boolean checkThreadAccess() {
        return HandlerUtil.checkThreadAccess(this.mHandler);
    }

    @Override // com.taobao.weex.devtools.inspector.elements.DocumentProviderFactory
    public DocumentProvider create() {
        return new AndroidDocumentProvider(this.mApplication, this);
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public <V> V postAndWait(UncheckedCallable<V> uncheckedCallable) {
        return (V) HandlerUtil.postAndWait(this.mHandler, uncheckedCallable);
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public void postDelayed(Runnable runnable, long j) {
        if (!this.mHandler.postDelayed(runnable, j)) {
            throw new RuntimeException("Handler.postDelayed() returned false");
        }
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public void removeCallbacks(Runnable runnable) {
        this.mHandler.removeCallbacks(runnable);
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public void verifyThreadAccess() {
        HandlerUtil.verifyThreadAccess(this.mHandler);
    }

    @Override // com.taobao.weex.devtools.common.ThreadBound
    public void postAndWait(Runnable runnable) {
        HandlerUtil.postAndWait(this.mHandler, runnable);
    }
}
