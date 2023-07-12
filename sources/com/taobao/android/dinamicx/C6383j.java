package com.taobao.android.dinamicx;

import android.view.View;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import tb.i10;

/* compiled from: Taobao */
/* renamed from: com.taobao.android.dinamicx.j */
/* loaded from: classes11.dex */
public class C6383j extends DXRenderPipelineFlow {
    protected C6386m j = new C6386m();
    protected C6379g k = new C6379g();
    protected i10 l = new i10();

    @Override // com.taobao.android.dinamicx.DXRenderPipelineFlow
    protected DXWidgetNode h() {
        DXWidgetNode dXWidgetNode;
        if (this.e == null || (dXWidgetNode = this.f) == null || this.d == null) {
            return null;
        }
        return dXWidgetNode;
    }

    @Override // com.taobao.android.dinamicx.DXRenderPipelineFlow
    protected DXWidgetNode i() {
        DXRuntimeContext dXRuntimeContext;
        DXWidgetNode dXWidgetNode = this.e;
        if (dXWidgetNode == null || (dXRuntimeContext = this.g) == null) {
            return dXWidgetNode;
        }
        boolean z = false;
        if (dXRuntimeContext.getEngineContext() != null && this.g.getEngineContext().b() != null) {
            z = this.g.getEngineContext().b().m();
        }
        return this.k.b(this.e, this.g, z);
    }

    @Override // com.taobao.android.dinamicx.DXRenderPipelineFlow
    protected DXWidgetNode j() {
        DXRuntimeContext dXRuntimeContext;
        DXWidgetNode dXWidgetNode = this.e;
        if (dXWidgetNode == null || (dXRuntimeContext = this.g) == null) {
            return dXWidgetNode;
        }
        this.k.c(dXWidgetNode, dXRuntimeContext);
        return this.e;
    }

    @Override // com.taobao.android.dinamicx.DXRenderPipelineFlow
    protected DXWidgetNode l() {
        DXRuntimeContext dXRuntimeContext;
        DXWidgetNode dXWidgetNode = this.e;
        if (dXWidgetNode == null || (dXRuntimeContext = this.g) == null) {
            return dXWidgetNode;
        }
        this.k.d(dXWidgetNode, this.h, this.i, dXRuntimeContext);
        return this.e;
    }

    @Override // com.taobao.android.dinamicx.DXRenderPipelineFlow
    protected DXWidgetNode m() {
        DXWidgetNode dXWidgetNode = this.e;
        if (dXWidgetNode == null || this.g == null) {
            return dXWidgetNode;
        }
        if (this.b == 1) {
            this.j.d(dXWidgetNode);
        } else {
            this.j.f(dXWidgetNode);
        }
        return this.e;
    }

    @Override // com.taobao.android.dinamicx.DXRenderPipelineFlow
    protected View n() {
        DXWidgetNode dXWidgetNode;
        DXRuntimeContext dXRuntimeContext;
        DXWidgetNode dXWidgetNode2 = this.e;
        if (dXWidgetNode2 == null || (dXWidgetNode = this.f) == null || (dXRuntimeContext = this.g) == null) {
            return null;
        }
        return this.l.d(dXWidgetNode2, dXWidgetNode, this.d, dXRuntimeContext, 1);
    }
}
