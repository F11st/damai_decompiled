package com.taobao.android.dinamicx;

import android.text.TextUtils;
import android.view.ViewGroup;
import com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback;
import com.taobao.android.dinamicx.asyncrender.DXBaseRenderWorkTask;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import java.lang.ref.WeakReference;
import tb.bu;
import tb.r20;
import tb.ry;
import tb.t00;
import tb.y00;
import tb.yx2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXPreRenderWorkTask extends DXBaseRenderWorkTask {
    public static final String TAG = "DXPreRenderWorkTask";
    private final DXAsyncRenderCallback<t00<DXRootView>> callback;

    public DXPreRenderWorkTask(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, DXTemplateManager dXTemplateManager, h hVar, d dVar, bu buVar) {
        this(dXRuntimeContext, dXRenderOptions, dXTemplateManager, hVar, dVar, buVar, null);
    }

    @Override // com.taobao.android.dinamicx.asyncrender.DXBaseRenderWorkTask, java.lang.Runnable
    public void run() {
        try {
            super.run();
            DXRenderPipeline dXRenderPipeline = DXBaseRenderWorkTask.pipelineThreadLocal.get();
            if (dXRenderPipeline == null || this.config.c != dXRenderPipeline.b().c) {
                DXRenderPipeline dXRenderPipeline2 = new DXRenderPipeline(this.engineContext, new DXTemplateManager(this.engineContext, DinamicXEngine.i()));
                DXBaseRenderWorkTask.pipelineThreadLocal.set(dXRenderPipeline2);
                dXRenderPipeline = dXRenderPipeline2;
            }
            this.runtimeContext.setDxRenderPipeline(new WeakReference<>(dXRenderPipeline));
            this.runtimeContext.contextWeakReference = new WeakReference<>(new yx2(this.runtimeContext.getContext().getApplicationContext()));
            DXRootView dXRootView = new DXRootView(this.runtimeContext.getContext());
            dXRootView.setLayoutParams(new ViewGroup.LayoutParams(0, 0));
            dXRootView.dxTemplateItem = this.runtimeContext.getDxTemplateItem();
            d dVar = this.engineContext;
            if (dVar != null && dVar.e() != null) {
                dXRootView.setBindingXManagerWeakReference(this.engineContext.e().n);
            }
            this.runtimeContext.rootViewWeakReference = new WeakReference<>(dXRootView);
            final t00<DXRootView> q = dXRenderPipeline.q(dXRootView, this.runtimeContext, -1, this.options);
            this.isDone = true;
            if (q == null || q.a == null) {
                return;
            }
            r20.c().b(q.a, this.runtimeContext.getDxTemplateItem(), this.config.a);
            if (this.callback != null) {
                if (this.runtimeContext.hasError()) {
                    y00.o(new Runnable() { // from class: com.taobao.android.dinamicx.DXPreRenderWorkTask.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DXPreRenderWorkTask.this.callback.onRenderFailed(DXPreRenderWorkTask.this.runtimeContext, null);
                        }
                    });
                } else {
                    y00.o(new Runnable() { // from class: com.taobao.android.dinamicx.DXPreRenderWorkTask.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DXPreRenderWorkTask.this.callback.onRenderSuccess(q);
                        }
                    });
                }
            }
        } catch (Throwable th) {
            DXRuntimeContext dXRuntimeContext = this.runtimeContext;
            if (dXRuntimeContext != null && !TextUtils.isEmpty(dXRuntimeContext.bizType)) {
                DXRuntimeContext dXRuntimeContext2 = this.runtimeContext;
                DXAppMonitor.q(dXRuntimeContext2.bizType, dXRuntimeContext2.getDxTemplateItem(), "AsyncRender", "Pre_Render_3.0_Crash", e.V3_PRE_RENDER_CRASH, ry.a(th));
            }
            ry.b(th);
            this.isFailed = true;
            if (this.callback != null) {
                y00.o(new Runnable() { // from class: com.taobao.android.dinamicx.DXPreRenderWorkTask.3
                    @Override // java.lang.Runnable
                    public void run() {
                        DXPreRenderWorkTask.this.callback.onRenderFailed(DXPreRenderWorkTask.this.runtimeContext, th);
                    }
                });
            }
        }
    }

    public DXPreRenderWorkTask(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, DXTemplateManager dXTemplateManager, h hVar, d dVar, bu buVar, DXAsyncRenderCallback<t00<DXRootView>> dXAsyncRenderCallback) {
        super(dXRuntimeContext, dXRenderOptions, dXTemplateManager, hVar, dVar, buVar);
        this.callback = dXAsyncRenderCallback;
    }
}
