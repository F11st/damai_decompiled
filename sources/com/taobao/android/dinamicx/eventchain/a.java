package com.taobao.android.dinamicx.eventchain;

import android.text.TextUtils;
import android.view.View;
import com.taobao.analysis.v3.FalcoBusinessSpan;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.analysis.v3.FalcoStage;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import tb.h;
import tb.iy;
import tb.my;
import tb.nz;
import tb.py;
import tb.q;
import tb.uf0;
import tb.wf0;
import tb.wt;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class a {
    private WeakReference<View> a;
    private WeakReference<DXRuntimeContext> b;
    private WeakReference<q> c;
    private WeakReference<b> d;
    private my e;
    private FalcoBusinessSpan h;
    private FalcoContainerSpan i;
    private FalcoStage j;
    private wf0 m;
    private uf0 n;
    private py o;
    private boolean p;
    private boolean f = false;
    private int g = 0;
    private String k = "";
    private final AtomicInteger l = new AtomicInteger(0);

    private DXRuntimeContext k() {
        DXWidgetNode dXWidgetNode;
        WeakReference<View> weakReference = this.a;
        if (weakReference == null || weakReference.get() == null || (dXWidgetNode = (DXWidgetNode) this.a.get().getTag(DXWidgetNode.TAG_WIDGET_NODE)) == null || dXWidgetNode.getReferenceNode() == null) {
            return null;
        }
        return dXWidgetNode.getReferenceNode().getDXRuntimeContext();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(DXRuntimeContext dXRuntimeContext) {
        this.b = new WeakReference<>(dXRuntimeContext);
    }

    public void B(uf0 uf0Var) {
        this.n = uf0Var;
    }

    public void C(py pyVar) {
        this.o = pyVar;
    }

    public void D(String str) {
        this.k = str;
    }

    public void E(my myVar) {
        this.e = myVar;
    }

    public void F(FalcoStage falcoStage) {
        this.j = falcoStage;
    }

    public void G(boolean z) {
        this.p = z;
    }

    public void H(wf0 wf0Var) {
        this.m = wf0Var;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I(View view) {
        this.a = new WeakReference<>(view);
    }

    public void J() {
        int i = this.g;
        if (i > 0) {
            this.g = i - 1;
        }
        nz.f("DXFullTrace", "subReferenceCount ", Integer.valueOf(this.g));
    }

    public void K() {
        WeakReference<DXRuntimeContext> weakReference = this.b;
        DXRuntimeContext dXRuntimeContext = weakReference == null ? null : weakReference.get();
        if (dXRuntimeContext == null) {
            dXRuntimeContext = k();
        }
        if (dXRuntimeContext != null) {
            dXRuntimeContext.setEventChainExpressionSourceContext(this.e);
        }
    }

    public void a() {
        int i = this.g + 1;
        this.g = i;
        nz.f("DXFullTrace", "addReferenceCount ", Integer.valueOf(i));
    }

    public void b() {
        this.f = true;
    }

    public void c() {
        this.g = 0;
        nz.f("DXFullTrace", "clearReferenceCount ", 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h d() {
        WeakReference<b> weakReference = this.d;
        if (weakReference != null && weakReference.get() != null) {
            return this.d.get().j();
        }
        nz.g("DXEventChainContext", "getAbilityEngine : dxEventChainManager is null");
        return null;
    }

    public q e() {
        WeakReference<q> weakReference = this.c;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public int f() {
        return this.l.getAndIncrement();
    }

    public FalcoBusinessSpan g() {
        return this.h;
    }

    public FalcoContainerSpan h() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public DXAtomicEventNode i(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            nz.g("DXEventChainContext", "getAtomicNode : eventchain name  or atomic name is null");
        }
        iy j = j(str);
        if (j == null) {
            return null;
        }
        return j.c(str2);
    }

    protected iy j(String str) {
        if (TextUtils.isEmpty(str)) {
            nz.g("DXEventChainContext", "getEventChain : eventchain name is null");
            return null;
        }
        py n = n();
        if (n == null) {
            return null;
        }
        return n.c(str);
    }

    public DXRuntimeContext l() {
        WeakReference<DXRuntimeContext> weakReference = this.b;
        DXRuntimeContext dXRuntimeContext = weakReference == null ? null : weakReference.get();
        if (dXRuntimeContext == null) {
            dXRuntimeContext = k();
        }
        if (dXRuntimeContext != null && dXRuntimeContext.getEventChainExpressionSourceContext() == null) {
            dXRuntimeContext.setEventChainExpressionSourceContext(this.e);
        }
        return dXRuntimeContext;
    }

    public uf0 m() {
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public py n() {
        if (this.o != null && wt.M0() && this.p) {
            return this.o;
        }
        DXRuntimeContext l = l();
        if (l == null || l.getWidgetNode() == null || l.getWidgetNode().queryRootWidgetNode() == null) {
            return null;
        }
        return l.getWidgetNode().queryRootWidgetNode().getDxEventChains();
    }

    public String o() {
        return TextUtils.isEmpty(this.k) ? "" : this.k;
    }

    public my p() {
        return this.e;
    }

    public FalcoStage q() {
        return this.j;
    }

    public wf0 r() {
        return this.m;
    }

    public int s() {
        return this.l.get();
    }

    public int t() {
        nz.f("DXFullTrace", "getReferenceCount ", Integer.valueOf(this.g));
        return this.g;
    }

    public boolean u() {
        return this.f;
    }

    public void v() {
        this.l.set(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(q qVar) {
        this.c = new WeakReference<>(qVar);
    }

    public void x(FalcoBusinessSpan falcoBusinessSpan) {
        this.h = falcoBusinessSpan;
    }

    public void y(FalcoContainerSpan falcoContainerSpan) {
        this.i = falcoContainerSpan;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void z(b bVar) {
        this.d = new WeakReference<>(bVar);
    }
}
