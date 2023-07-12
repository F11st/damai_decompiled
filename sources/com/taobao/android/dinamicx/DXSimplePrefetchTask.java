package com.taobao.android.dinamicx;

import android.view.View;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.asyncrender.C6363a;
import com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.ry;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXSimplePrefetchTask extends DXSimpleBaseRenderWorkTask {
    protected DXAsyncRenderCallback<DXRuntimeContext> callback;
    protected Runnable callbackRunnable;

    public DXSimplePrefetchTask(DXRuntimeContext dXRuntimeContext, DXRenderOptions dXRenderOptions, C6367d c6367d, C6380h c6380h, View view, DXAsyncRenderCallback<DXRuntimeContext> dXAsyncRenderCallback) {
        super(dXRuntimeContext, dXRenderOptions, c6367d, c6380h, view);
        this.callback = dXAsyncRenderCallback;
    }

    private void notifyPrefetchSuccess(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode == null) {
            return;
        }
        try {
            if (dXWidgetNode instanceof PrefetchListener) {
                ((PrefetchListener) dXWidgetNode).onPrefetchSuccess();
            }
            if (dXWidgetNode.getChildren() == null || dXWidgetNode.getChildren().isEmpty()) {
                return;
            }
            for (DXWidgetNode dXWidgetNode2 : dXWidgetNode.getChildren()) {
                notifyPrefetchSuccess(dXWidgetNode2);
            }
        } catch (Throwable th) {
            C6368e c6368e = new C6368e(this.runtimeContext.getBizType());
            C6368e.C6369a c6369a = new C6368e.C6369a("Engine", "Engine_Render", C6368e.DX_SIMPLE_PREFETCH_LISTENER_CRASH);
            c6369a.e = ry.a(th);
            c6368e.c.add(c6369a);
            DXAppMonitor.n(c6368e);
        }
    }

    public void cancel() {
        Runnable runnable = this.callbackRunnable;
        if (runnable != null) {
            y00.a(runnable);
        }
        this.options.k(true);
        this.isDone = true;
    }

    @Override // com.taobao.android.dinamicx.DXSimpleBaseRenderWorkTask
    protected void onRunTask() {
        C6363a k;
        try {
            getPipeline().h(this.runtimeContext.getWidgetNode(), null, this.viewWeakReference.get(), this.runtimeContext, this.options);
            this.isDone = true;
            if (this.callback != null && !this.options.i()) {
                if (!this.runtimeContext.hasError()) {
                    notifyPrefetchSuccess(this.runtimeContext.getWidgetNode());
                    this.callbackRunnable = new Runnable() { // from class: com.taobao.android.dinamicx.DXSimplePrefetchTask.1
                        @Override // java.lang.Runnable
                        public void run() {
                            DXSimplePrefetchTask dXSimplePrefetchTask = DXSimplePrefetchTask.this;
                            dXSimplePrefetchTask.callback.onRenderSuccess(dXSimplePrefetchTask.runtimeContext);
                        }
                    };
                } else {
                    this.callbackRunnable = new Runnable() { // from class: com.taobao.android.dinamicx.DXSimplePrefetchTask.2
                        @Override // java.lang.Runnable
                        public void run() {
                            DXSimplePrefetchTask dXSimplePrefetchTask = DXSimplePrefetchTask.this;
                            dXSimplePrefetchTask.callback.onRenderFailed(dXSimplePrefetchTask.runtimeContext, null);
                        }
                    };
                }
                y00.o(this.callbackRunnable);
            }
            if (!this.runtimeContext.getEngineContext().j() || (k = this.runtimeContext.getEngineContext().e().k()) == null) {
                return;
            }
            k.A();
        } catch (Throwable th) {
            ry.b(th);
            this.isDone = true;
            if (this.callback == null || this.options.i()) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.taobao.android.dinamicx.DXSimplePrefetchTask.3
                @Override // java.lang.Runnable
                public void run() {
                    DXSimplePrefetchTask dXSimplePrefetchTask = DXSimplePrefetchTask.this;
                    dXSimplePrefetchTask.callback.onRenderFailed(dXSimplePrefetchTask.runtimeContext, th);
                }
            };
            this.callbackRunnable = runnable;
            y00.o(runnable);
        }
    }
}
