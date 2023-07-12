package com.taobao.android.dinamicx;

import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class DXSimpleBaseRenderWorkTask implements Runnable {
    protected static ThreadLocal<C6384k> pipelineThreadLocal = new ThreadLocal<>();
    protected DXEngineConfig config;
    protected C6380h dxPipelineCacheManager;
    protected C6367d engineContext;
    public boolean isDone;
    public DXRenderOptions options;
    public DXRuntimeContext runtimeContext;
    protected WeakReference<View> viewWeakReference;

    public DXSimpleBaseRenderWorkTask(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, C6367d c6367d, C6380h c6380h, View view) {
        this.runtimeContext = dXRuntimeContext;
        this.options = dXRenderOptions;
        this.config = c6367d.b();
        this.engineContext = c6367d;
        this.dxPipelineCacheManager = c6380h;
        this.viewWeakReference = new WeakReference<>(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public C6384k getPipeline() {
        C6384k c6384k = pipelineThreadLocal.get();
        if (c6384k == null || this.config.e() != c6384k.b().e()) {
            C6384k c6384k2 = new C6384k(this.engineContext, 3, UUID.randomUUID().toString());
            pipelineThreadLocal.set(c6384k2);
            return c6384k2;
        }
        return c6384k;
    }

    protected abstract void onRunTask();

    @Override // java.lang.Runnable
    public void run() {
        try {
            Field declaredField = Looper.class.getDeclaredField("sThreadLocal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(Looper.getMainLooper());
            if (obj instanceof ThreadLocal) {
                ((ThreadLocal) obj).set(Looper.getMainLooper());
            }
            onRunTask();
        } catch (Throwable unused) {
        }
    }
}
