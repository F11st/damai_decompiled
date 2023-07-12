package com.taobao.android.dinamicx.asyncrender;

import android.os.Looper;
import com.taobao.android.dinamicx.DXEngineConfig;
import com.taobao.android.dinamicx.DXRenderOptions;
import com.taobao.android.dinamicx.DXRenderPipeline;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DXTemplateManager;
import com.taobao.android.dinamicx.d;
import com.taobao.android.dinamicx.h;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import tb.bu;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXBaseRenderWorkTask implements Runnable {
    protected static ThreadLocal<DXRenderPipeline> pipelineThreadLocal = new ThreadLocal<>();
    protected DXEngineConfig config;
    protected WeakReference<bu> controlEventCenterWeakReference;
    protected h dxPipelineCacheManager;
    protected d engineContext;
    public boolean isDone;
    public boolean isFailed;
    protected DXRenderOptions options;
    public DXRuntimeContext runtimeContext;
    protected long taskId;
    protected String taskName;
    protected WeakReference<DXTemplateManager> templateManagerWeakReference;

    public DXBaseRenderWorkTask(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, DXTemplateManager dXTemplateManager, h hVar, d dVar, bu buVar) {
        this.runtimeContext = dXRuntimeContext;
        this.dxPipelineCacheManager = hVar;
        this.options = dXRenderOptions;
        this.config = dVar.b();
        this.engineContext = dVar;
        if (buVar != null) {
            this.controlEventCenterWeakReference = new WeakReference<>(buVar);
        }
        if (dXTemplateManager != null) {
            this.templateManagerWeakReference = new WeakReference<>(dXTemplateManager);
        }
        this.taskId = System.nanoTime();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Field declaredField = Looper.class.getDeclaredField("sThreadLocal");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(Looper.getMainLooper());
            if (obj instanceof ThreadLocal) {
                ((ThreadLocal) obj).set(Looper.getMainLooper());
            }
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public DXBaseRenderWorkTask() {
    }
}
