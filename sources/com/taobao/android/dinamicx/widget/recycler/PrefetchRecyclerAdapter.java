package com.taobao.android.dinamicx.widget.recycler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRenderOptions;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.asyncrender.C6363a;
import com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.RecyclerAdapter;
import com.taobao.weex.ui.component.WXBasicComponentType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import tb.h00;
import tb.nz;
import tb.ry;
import tb.wt;
import tb.zx;
import tb.zz;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PrefetchRecyclerAdapter extends RecyclerAdapter {
    public static final int DEFAULT_BATCH_SIZE = Runtime.getRuntime().availableProcessors();
    protected int x;
    protected Map<Integer, C6506c> y;
    private int z;

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.PrefetchRecyclerAdapter$a */
    /* loaded from: classes11.dex */
    class C6504a extends RecyclerView.AdapterDataObserver {
        C6504a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            PrefetchRecyclerAdapter.this.E(i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            try {
                if (PrefetchRecyclerAdapter.this.f() - i2 == i) {
                    int i3 = PrefetchRecyclerAdapter.this.z;
                    int i4 = PrefetchRecyclerAdapter.this.z;
                    PrefetchRecyclerAdapter prefetchRecyclerAdapter = PrefetchRecyclerAdapter.this;
                    int min = Math.min(i4 + prefetchRecyclerAdapter.x, prefetchRecyclerAdapter.f());
                    if (min > i3) {
                        PrefetchRecyclerAdapter.this.z += PrefetchRecyclerAdapter.this.x;
                        PrefetchRecyclerAdapter prefetchRecyclerAdapter2 = PrefetchRecyclerAdapter.this;
                        prefetchRecyclerAdapter2.z = Math.min(prefetchRecyclerAdapter2.f(), PrefetchRecyclerAdapter.this.z);
                        PrefetchRecyclerAdapter.this.J(i3, min);
                    }
                }
            } catch (Throwable th) {
                PrefetchRecyclerAdapter.this.O(th);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            PrefetchRecyclerAdapter.this.E(i, i2);
            if (i > PrefetchRecyclerAdapter.this.z) {
                return;
            }
            PrefetchRecyclerAdapter prefetchRecyclerAdapter = PrefetchRecyclerAdapter.this;
            prefetchRecyclerAdapter.z = Math.max(0, Math.min(prefetchRecyclerAdapter.z - i, i2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.PrefetchRecyclerAdapter$b */
    /* loaded from: classes11.dex */
    public class C6505b implements DXAsyncRenderCallback<DXRuntimeContext> {
        final /* synthetic */ C6506c a;

        C6505b(C6506c c6506c) {
            this.a = c6506c;
        }

        @Override // com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback
        /* renamed from: a */
        public void onRenderSuccess(DXRuntimeContext dXRuntimeContext) {
            PrefetchRecyclerAdapter.this.I(this.a, false, dXRuntimeContext);
        }

        @Override // com.taobao.android.dinamicx.asyncrender.DXAsyncRenderCallback
        public void onRenderFailed(DXRuntimeContext dXRuntimeContext, Throwable th) {
            PrefetchRecyclerAdapter.this.I(this.a, true, dXRuntimeContext);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.recycler.PrefetchRecyclerAdapter$c */
    /* loaded from: classes12.dex */
    public static class C6506c {
        int a;
        boolean b;
        boolean c;
        DXWidgetNode d;

        public C6506c(int i, DXWidgetNode dXWidgetNode, DXRuntimeContext dXRuntimeContext, int i2, int i3) {
            this.a = i;
            this.d = dXWidgetNode;
        }
    }

    public PrefetchRecyclerAdapter(Context context, boolean z, boolean z2) {
        super(context, z, z2);
        this.x = DEFAULT_BATCH_SIZE;
        this.y = new LinkedHashMap();
        this.z = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(Throwable th) {
        ry.b(th);
        C6368e c6368e = new C6368e(WXBasicComponentType.RECYCLER);
        C6368e.C6369a c6369a = new C6368e.C6369a("Engine", "Engine_Render", C6368e.DX_RECYCLER_PREFETCH_CRASH);
        c6369a.e = ry.a(th);
        c6368e.c.add(c6369a);
        DXAppMonitor.n(c6368e);
    }

    protected void E(int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            try {
                F(i3, true);
            } catch (Throwable th) {
                O(th);
                return;
            }
        }
    }

    protected void F(int i, boolean z) {
        try {
            G(z ? this.y.remove(Integer.valueOf(i)) : this.y.get(Integer.valueOf(i)));
        } catch (Throwable th) {
            O(th);
        }
    }

    protected void G(C6506c c6506c) {
        if (c6506c == null) {
            return;
        }
        c6506c.c = true;
        if (c6506c.b) {
            return;
        }
        DXRuntimeContext dXRuntimeContext = c6506c.d.getDXRuntimeContext();
        C6363a k = dXRuntimeContext.getEngineContext().e().k();
        if (k == null) {
            return;
        }
        k.j(dXRuntimeContext);
    }

    public int[] H(DXWidgetNode dXWidgetNode) {
        boolean isFullSpan = dXWidgetNode instanceof DXTemplateWidgetNode ? ((DXTemplateWidgetNode) dXWidgetNode).isFullSpan() : false;
        DXRecyclerLayout dXRecyclerLayout = this.g;
        if (dXRecyclerLayout == null) {
            return null;
        }
        int measuredWidth = dXRecyclerLayout.getMeasuredWidth();
        if (!isFullSpan) {
            measuredWidth = (((measuredWidth - ((this.g.getColumnCount() - 1) * this.g.getColumnGap())) - this.g.getLeftGap()) - this.g.getRightGap()) / this.g.getColumnCount();
        } else if (this.g.isEnableLeftGapWhenSingleColumn()) {
            measuredWidth = (measuredWidth - this.g.getLeftGap()) - this.g.getRightGap();
        }
        return new int[]{DXWidgetNode.DXMeasureSpec.c(measuredWidth, 1073741824), DXWidgetNode.DXMeasureSpec.c(8388607, 0)};
    }

    protected void I(@NonNull C6506c c6506c, boolean z, DXRuntimeContext dXRuntimeContext) {
        int i;
        try {
            c6506c.b = true;
            this.y.remove(Integer.valueOf(c6506c.a));
            if (!c6506c.c && dXRuntimeContext != null && (i = c6506c.a) >= 0 && i < f()) {
                DXWidgetNode h = h(c6506c.a);
                if (dXRuntimeContext.getWidgetNode() != null && h != null) {
                    dXRuntimeContext.getWidgetNode().setParentWidget(h.getParentWidget());
                    s(c6506c.a, dXRuntimeContext.getWidgetNode());
                }
            }
        } catch (Throwable th) {
            O(th);
        }
    }

    protected void J(int i, int i2) {
        try {
            if (f() <= 0) {
                return;
            }
            int max = Math.max(0, Math.min(f(), i2));
            for (int max2 = Math.max(0, i); max2 < max; max2++) {
                C6506c c6506c = this.y.get(Integer.valueOf(max2));
                if (c6506c != null) {
                    F(max2, true);
                    if (c6506c.d == h(max2)) {
                    }
                }
                DXWidgetNode h = h(max2);
                if (h == null) {
                    return;
                }
                if (!h.getStatInPrivateFlags(32)) {
                    DXRuntimeContext e = e(h);
                    DinamicXEngine e2 = e.getEngineContext().e();
                    int[] H = H(h);
                    if (H == null) {
                        N();
                        return;
                    }
                    h.setLayoutWidth(-1);
                    h.setLayoutHeight(-2);
                    DXRenderOptions k = new DXRenderOptions.C6359b().r(1).l(2).s(4).u(H[0]).m(H[1]).k();
                    if (!(h instanceof h00)) {
                        C6506c c6506c2 = new C6506c(max2, h, e, H[0], H[1]);
                        this.y.put(Integer.valueOf(max2), c6506c2);
                        e2.F(e, k, null, new C6505b(c6506c2));
                    }
                }
            }
        } catch (Throwable th) {
            O(th);
        }
    }

    protected void K(int i) {
        int min;
        int i2 = this.z;
        int i3 = this.x;
        if (i2 - i3 == i && (min = Math.min(i3 + i2, f())) > i2) {
            this.z += this.x;
            this.z = Math.min(f(), this.z);
            J(i2, min);
        }
    }

    protected void L() {
        int min;
        N();
        this.z = this.x;
        if (f() > 0 && (min = Math.min(this.x, f())) > 1) {
            J(1, min);
        }
    }

    public void M(int i) {
        if (i <= 0) {
            i = DEFAULT_BATCH_SIZE;
        }
        this.x = i;
    }

    protected void N() {
        C6363a k;
        for (Integer num : this.y.keySet()) {
            F(num.intValue(), false);
        }
        this.y.clear();
        DXRecyclerLayout dXRecyclerLayout = this.g;
        if (dXRecyclerLayout == null || (k = dXRecyclerLayout.getDXRuntimeContext().getEngineContext().e().k()) == null) {
            return;
        }
        k.A();
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.RecyclerAdapter, com.taobao.android.dinamicx.widget.recycler.BaseStickyAdapter
    public void a(RecyclerView.ViewHolder viewHolder, int i) {
        DXWidgetNode h;
        String str;
        boolean z;
        DXWidgetNode childAt;
        DXWidgetNode childAt2;
        if (getItemViewType(i) != -1) {
            FalcoContainerSpan falcoContainerSpan = null;
            try {
                h = h(i);
                if (h instanceof DXTemplateWidgetNode) {
                    boolean isFullSpan = ((DXTemplateWidgetNode) h).isFullSpan();
                    falcoContainerSpan = ((DXTemplateWidgetNode) h).getSpan();
                    str = ((DXTemplateWidgetNode) h).getTemplateInfo();
                    z = isFullSpan;
                } else {
                    str = "";
                    z = false;
                }
            } finally {
                try {
                } finally {
                }
            }
            if (h != null && this.c != null) {
                zz.q(falcoContainerSpan, "onBindStart-cellInfo", "  pos  " + i + "  itemInfo  " + str + "  rlId  " + this.g.getUserId());
                RecyclerAdapter.ItemViewHolder itemViewHolder = (RecyclerAdapter.ItemViewHolder) viewHolder;
                DXRuntimeContext e = e(h);
                DXWidgetNode dXWidgetNode = itemViewHolder.a;
                if ((dXWidgetNode instanceof DXTemplateWidgetNode) && (childAt = dXWidgetNode.getChildAt(0)) != null && childAt.getDXRuntimeContext() != null && childAt.getDXRuntimeContext().getInstanceId() > 0 && (h instanceof DXTemplateWidgetNode) && (childAt2 = h.getChildAt(0)) != null && childAt2.getDXRuntimeContext() != null) {
                    childAt2.getDXRuntimeContext().setInstanceId(childAt.getDXRuntimeContext().getInstanceId());
                }
                int measuredWidth = this.g.getMeasuredWidth();
                if (!z) {
                    measuredWidth = (((measuredWidth - ((this.g.getColumnCount() - 1) * this.g.getColumnGap())) - this.g.getLeftGap()) - this.g.getRightGap()) / this.g.getColumnCount();
                } else if (this.g.isEnableLeftGapWhenSingleColumn()) {
                    measuredWidth = (measuredWidth - this.g.getLeftGap()) - this.g.getRightGap();
                }
                int c = DXWidgetNode.DXMeasureSpec.c(measuredWidth, 1073741824);
                int c2 = DXWidgetNode.DXMeasureSpec.c(8388607, 0);
                K(i);
                F(i, true);
                h.setLayoutWidth(-1);
                h.setLayoutHeight(-2);
                if (wt.A0() && h.getDXRuntimeContext().isRefreshPart() && viewHolder != null && h != ((RecyclerAdapter.ItemViewHolder) viewHolder).a) {
                    h.updateRefreshType(0);
                    e.setRefreshType(0);
                }
                this.c.h(h, null, viewHolder.itemView, e, new DXRenderOptions.C6359b().l(2).s(8).u(c).m(c2).k());
                if (viewHolder.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
                    if (z) {
                        ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(true);
                    } else {
                        ((StaggeredGridLayoutManager.LayoutParams) viewHolder.itemView.getLayoutParams()).setFullSpan(false);
                    }
                }
                if (e.hasError()) {
                    DXAppMonitor.o(e.getDxError(), true);
                }
                itemViewHolder.a = h;
                this.h.f(i);
                if (h.getBindingXExecutingMap() != null) {
                    h.getBindingXExecutingMap().clear();
                }
                h.sendBroadcastEvent(this.h);
                this.g.postEvent(this.h);
                this.g.addAppearWidget(h);
                View view = viewHolder.itemView;
                if (view == null || (!(view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0)) {
                    this.g.trackError(C6368e.DX_ERROR_CODE_RECYCLER_LAYOUT_ON_BINDHOLDER, "onbindViewholder返回的view是空");
                    zz.o(falcoContainerSpan, "onbindViewholder返回的view是空: " + i);
                }
                zz.p(falcoContainerSpan, "onBindEnd", System.currentTimeMillis());
                if (wt.A0() && h.getDXRuntimeContext().isRefreshPart()) {
                    h.updateRefreshType(0);
                }
            }
            nz.g(RecyclerAdapter.TAG, "get item null!");
            zz.o(falcoContainerSpan, "get item null!");
            return;
        }
        n(i);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.BaseStickyAdapter
    public void b() {
        super.b();
        registerAdapterDataObserver(new C6504a());
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.RecyclerAdapter
    public void p(ArrayList<DXWidgetNode> arrayList) {
        try {
            super.p(arrayList);
            L();
            K(0);
        } catch (Throwable th) {
            O(th);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.RecyclerAdapter
    public void r(zx zxVar) {
        super.r(zxVar);
        L();
    }
}
