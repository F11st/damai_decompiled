package com.taobao.android.dinamicx;

import android.os.Looper;
import android.view.View;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.UUID;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class DXSimpleBaseRenderWorkTask implements Runnable {
    protected static ThreadLocal<k> pipelineThreadLocal = new ThreadLocal<>();
    protected DXEngineConfig config;
    protected h dxPipelineCacheManager;
    protected d engineContext;
    public boolean isDone;
    public DXRenderOptions options;
    public DXRuntimeContext runtimeContext;
    protected WeakReference<View> viewWeakReference;

    public DXSimpleBaseRenderWorkTask(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, d dVar, h hVar, View view) {
        this.runtimeContext = dXRuntimeContext;
        this.options = dXRenderOptions;
        this.config = dVar.b();
        this.engineContext = dVar;
        this.dxPipelineCacheManager = hVar;
        this.viewWeakReference = new WeakReference<>(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public k getPipeline() {
        k kVar = pipelineThreadLocal.get();
        if (kVar == null || this.config.e() != kVar.b().e()) {
            k kVar2 = new k(this.engineContext, 3, UUID.randomUUID().toString());
            pipelineThreadLocal.set(kVar2);
            return kVar2;
        }
        return kVar;
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
