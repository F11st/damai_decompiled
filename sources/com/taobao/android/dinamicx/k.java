package com.taobao.android.dinamicx;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamicx.DXRenderOptions;
import com.taobao.android.dinamicx.monitor.DXPerformBaselineUtil;
import com.taobao.android.dinamicx.monitor.DXTraceUtil;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import com.taobao.android.dinamicx.view.DXRootNativeFrameLayout;
import com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.wt;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class k extends DXRenderPipelineBase {
    private final boolean f;

    public k(@NonNull d dVar, int i, String str) {
        this(dVar, i, str, false);
    }

    public View e(@NonNull Context context) {
        return this.f ? new DXRootNativeFrameLayout(context) : new DXNativeFrameLayout(context);
    }

    public int f(DXWidgetNode dXWidgetNode, int i, boolean z) {
        if (!wt.u0()) {
            return super.c(dXWidgetNode, i);
        }
        if ((dXWidgetNode instanceof DXTemplateWidgetNode) && ((dXWidgetNode.getParentWidget() instanceof DXAbsContainerBaseLayout) || z)) {
            if (dXWidgetNode.getChildrenCount() <= 0 || super.c(dXWidgetNode, i) == 2) {
                return 2;
            }
            return super.c(dXWidgetNode.getChildAt(0), i);
        }
        return super.c(dXWidgetNode, i);
    }

    public View g(DXWidgetNode dXWidgetNode, DXWidgetNode dXWidgetNode2, View view, DXRuntimeContext dXRuntimeContext, int i, int i2, int i3, int i4, int i5) {
        return h(dXWidgetNode, dXWidgetNode2, view, dXRuntimeContext, new DXRenderOptions.b().l(i).s(i2).u(i3).m(i4).k());
    }

    public View h(@Nullable DXWidgetNode dXWidgetNode, @Nullable DXWidgetNode dXWidgetNode2, @Nullable View view, @NonNull DXRuntimeContext dXRuntimeContext, @NonNull DXRenderOptions dXRenderOptions) {
        DXTraceUtil.b("DX-SimplePipeline-RenderWt", " : ", dXWidgetNode.getDXRuntimeContext().getTemplateId());
        long nanoTime = System.nanoTime();
        if (view == null) {
            view = e(dXRuntimeContext.getContext());
        }
        dXRuntimeContext.setPipelineIdentifier(this.d);
        int f = f(dXWidgetNode, dXRenderOptions.a(), dXRenderOptions.e() == 1);
        this.e.h = dXRenderOptions.h();
        this.e.i = dXRenderOptions.b();
        DXRenderPipelineFlow dXRenderPipelineFlow = this.e;
        dXRenderPipelineFlow.d = view;
        dXRenderPipelineFlow.g = dXRuntimeContext;
        dXRenderPipelineFlow.e = dXWidgetNode;
        dXRenderPipelineFlow.f = dXWidgetNode2;
        dXRenderPipelineFlow.b = 0;
        dXRenderPipelineFlow.o(f, dXRenderOptions.f(), dXRenderOptions);
        DXPerformBaselineUtil.a("DX-SimplePipeline-RenderWt", System.nanoTime() - nanoTime, dXRuntimeContext.getDxTemplateItem());
        DXTraceUtil.c();
        return view;
    }

    public k(@NonNull d dVar, int i, String str, boolean z) {
        super(dVar, i, str);
        d(new j());
        this.f = z;
    }
}
