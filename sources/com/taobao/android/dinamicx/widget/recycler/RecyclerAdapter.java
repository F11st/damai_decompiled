package com.taobao.android.dinamicx.widget.recycler;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoContainerSpan;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$layout;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.k;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.view.DXNativeFrameLayout;
import com.taobao.android.dinamicx.widget.DXRecyclerLayout;
import com.taobao.android.dinamicx.widget.DXScrollLayoutBase;
import com.taobao.android.dinamicx.widget.DXTemplateWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import com.taobao.android.dinamicx.widget.recycler.loadmore.DXAbsOnLoadMoreView;
import com.taobao.weex.ui.component.WXBasicComponentType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import tb.e10;
import tb.nz;
import tb.p20;
import tb.ry;
import tb.wt;
import tb.zx;
import tb.zz;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RecyclerAdapter extends BaseStickyAdapter {
    public static final String LOADMORE_TITLE = "load_more_title";
    public static final String TAG = "RecyclerAdapter";
    public static final int TYPE_FOOTER_VIEW = -1;
    protected k c;
    protected Context d;
    protected zx f;
    protected DXRecyclerLayout g;
    private boolean j;
    private TextView k;
    View l;
    DXAbsOnLoadMoreView m;
    private ProgressBar n;
    protected boolean w;
    protected ArrayList<DXWidgetNode> e = new ArrayList<>();
    protected p20 h = new p20(DXScrollLayoutBase.DX_SCROLL_LAYOUT_BASE_ON_PAGE_APPEAR);
    private p20 i = new p20(DXScrollLayoutBase.DX_SCROLL_LAYOUT_BASE_ON_PAGE_DISAPPEAR);
    private String o = "太火爆啦，点我再尝试下吧";
    private String p = "";
    private String q = "亲，已经到底了哦";
    private int r = 0;
    private int s = 0;
    private int v = 1;
    private Map<String, Integer> t = new HashMap();
    private Map<Integer, String> u = new HashMap();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        public DXWidgetNode a;

        public ItemViewHolder(View view) {
            super(view);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            RecyclerAdapter.this.o(view);
        }
    }

    public RecyclerAdapter(Context context, boolean z, boolean z2) {
        this.d = context;
        this.j = z;
        View a2 = e10.a(context, R$layout.dx_scrollable_load_more_bottom);
        this.l = a2;
        this.k = (TextView) a2.findViewById(R$id.scrollable_loadmore_tv);
        this.n = (ProgressBar) this.l.findViewById(R$id.scrollable_loadmore_progressbar);
        this.w = z2;
    }

    private int g() {
        return (!this.j || l()) ? 0 : 1;
    }

    private int k() {
        DXRecyclerLayout dXRecyclerLayout = this.g;
        if (dXRecyclerLayout == null || dXRecyclerLayout.getDXRuntimeContext() == null || this.g.getDXRuntimeContext().getRootView() == null || this.g.getDXRuntimeContext().getRootView().getDxNestedScrollerView() == null || this.g.getDXRuntimeContext().getRootView().getDxNestedScrollerView().getmChildList() == null) {
            return 0;
        }
        return this.g.getDXRuntimeContext().getRootView().getDxNestedScrollerView().getStickyHeight();
    }

    private boolean l() {
        if (this.w) {
            zx zxVar = this.f;
            return zxVar == null || zxVar.getRealCount() <= 0;
        }
        ArrayList<DXWidgetNode> arrayList = this.e;
        return arrayList == null || arrayList.isEmpty();
    }

    private boolean m(int i) {
        return this.j && i >= getItemCount() - g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(View view) {
        if (3 == this.v) {
            n(-1);
        }
    }

    public void A(int i) {
        if (this.v == i) {
            return;
        }
        this.v = i;
        int i2 = this.r;
        if (i2 != 0) {
            this.k.setTextColor(i2);
        }
        int i3 = this.s;
        if (i3 != 0) {
            this.k.setTextSize(0, i3);
        }
        if (i != 2) {
            if (i != 3) {
                if (i != 4) {
                    if (i != 5) {
                        if (i == 6) {
                            this.n.setVisibility(8);
                            this.k.setText("");
                        }
                    } else if (this.m != null) {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(LOADMORE_TITLE, (Object) this.q);
                        this.m.onLoadMoreStatusUpdate(i, jSONObject);
                    } else {
                        this.n.setVisibility(8);
                        this.k.setVisibility(0);
                        this.k.setText(this.q);
                    }
                } else if (this.m != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(LOADMORE_TITLE, (Object) "");
                    this.m.onLoadMoreStatusUpdate(i, jSONObject2);
                } else {
                    this.n.setVisibility(8);
                    this.k.setVisibility(0);
                    this.k.setText("");
                }
            } else if (this.m != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(LOADMORE_TITLE, (Object) this.o);
                this.m.onLoadMoreStatusUpdate(i, jSONObject3);
            } else {
                this.n.setVisibility(8);
                this.k.setVisibility(0);
                this.k.setText(this.o);
            }
        } else if (this.m != null) {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put(LOADMORE_TITLE, (Object) this.p);
            this.m.onLoadMoreStatusUpdate(i, jSONObject4);
        } else {
            this.n.setVisibility(0);
            this.k.setVisibility(0);
            this.k.setText(this.p);
        }
        DXRecyclerLayout dXRecyclerLayout = this.g;
        if (dXRecyclerLayout == null || !wt.y0(dXRecyclerLayout.getDXRuntimeContext().getBizType()) || this.l == null) {
            return;
        }
        nz.g("RLLoadMore", "HitRLLoadMoreGone");
        if (i != 6 && i != 4 && (i != 5 || !TextUtils.isEmpty(this.q))) {
            this.l.setVisibility(0);
        } else {
            this.l.setVisibility(8);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.BaseStickyAdapter
    public void a(RecyclerView.ViewHolder viewHolder, int i) {
        DXWidgetNode i2;
        String str;
        FalcoContainerSpan falcoContainerSpan;
        boolean z;
        View view;
        DXWidgetNode childAt;
        DXWidgetNode childAt2;
        if (getItemViewType(i) != -1) {
            FalcoContainerSpan falcoContainerSpan2 = null;
            try {
                i2 = i(i, true);
                if (i2 instanceof DXTemplateWidgetNode) {
                    boolean isFullSpan = ((DXTemplateWidgetNode) i2).isFullSpan();
                    FalcoContainerSpan span = ((DXTemplateWidgetNode) i2).getSpan();
                    str = ((DXTemplateWidgetNode) i2).getTemplateInfo();
                    falcoContainerSpan = span;
                    z = isFullSpan;
                } else {
                    str = "";
                    falcoContainerSpan = null;
                    z = false;
                }
            } catch (Throwable th) {
                th = th;
            }
            if (i2 != null) {
                try {
                } catch (Throwable th2) {
                    th = th2;
                    falcoContainerSpan2 = falcoContainerSpan;
                }
                if (this.c != null) {
                    zz.q(falcoContainerSpan, "onBindStart-cellInfo", "  pos  " + i + "  itemInfo  " + str + "  rlId  " + this.g.getUserId());
                    ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
                    DXRuntimeContext e = e(i2);
                    DXWidgetNode dXWidgetNode = itemViewHolder.a;
                    if ((dXWidgetNode instanceof DXTemplateWidgetNode) && (childAt = dXWidgetNode.getChildAt(0)) != null && childAt.getDXRuntimeContext() != null && childAt.getDXRuntimeContext().getInstanceId() > 0 && (i2 instanceof DXTemplateWidgetNode) && (childAt2 = i2.getChildAt(0)) != null && childAt2.getDXRuntimeContext() != null) {
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
                    i2.setLayoutWidth(-1);
                    i2.setLayoutHeight(-2);
                    if (wt.A0() && i2.getDXRuntimeContext().isRefreshPart() && viewHolder != null && i2 != ((ItemViewHolder) viewHolder).a) {
                        i2.updateRefreshType(0);
                        e.setRefreshType(0);
                    }
                    FalcoContainerSpan falcoContainerSpan3 = falcoContainerSpan;
                    try {
                        this.c.g(i2, null, viewHolder.itemView, e, 2, 8, c, c2, i);
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
                        itemViewHolder.a = i2;
                        this.h.f(i);
                        if (i2.getBindingXExecutingMap() != null) {
                            i2.getBindingXExecutingMap().clear();
                        }
                        i2.sendBroadcastEvent(this.h);
                        this.g.postEvent(this.h);
                        this.g.addAppearWidget(i2);
                        view = viewHolder.itemView;
                    } catch (Throwable th3) {
                        th = th3;
                        falcoContainerSpan2 = falcoContainerSpan3;
                        try {
                            e eVar = new e(WXBasicComponentType.RECYCLER);
                            e.a aVar = new e.a("DX_RECYCLER", "DX_RECYCLER_BIND", e.DX_ERROR_CODE_RECYCLER_LAYOUT_ON_BIND);
                            aVar.e = ry.a(th);
                            eVar.c.add(aVar);
                            DXAppMonitor.n(eVar);
                            ry.b(th);
                            zz.o(falcoContainerSpan2, "onbindViewholder 发生 exception" + i);
                            n(i);
                        } finally {
                            zz.l(falcoContainerSpan2);
                        }
                    }
                    if (view != null && ((view instanceof ViewGroup) || ((ViewGroup) view).getChildCount() <= 0)) {
                        falcoContainerSpan2 = falcoContainerSpan3;
                        zz.p(falcoContainerSpan2, "onBindEnd", System.currentTimeMillis());
                        if (wt.A0() && i2.getDXRuntimeContext().isRefreshPart()) {
                            i2.updateRefreshType(0);
                        }
                    }
                    this.g.trackError(e.DX_ERROR_CODE_RECYCLER_LAYOUT_ON_BINDHOLDER, "onbindViewholder返回的view是空");
                    falcoContainerSpan2 = falcoContainerSpan3;
                    zz.o(falcoContainerSpan2, "onbindViewholder返回的view是空: " + i);
                    zz.p(falcoContainerSpan2, "onBindEnd", System.currentTimeMillis());
                    if (wt.A0()) {
                        i2.updateRefreshType(0);
                    }
                }
            }
            FalcoContainerSpan falcoContainerSpan4 = falcoContainerSpan;
            nz.g(TAG, "get item null!");
            zz.o(falcoContainerSpan4, "get item null!");
            zz.l(falcoContainerSpan4);
            return;
        }
        n(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public DXRuntimeContext e(DXWidgetNode dXWidgetNode) {
        DXRuntimeContext cloneWithWidgetNode = dXWidgetNode.getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode);
        e eVar = new e(cloneWithWidgetNode.getBizType());
        eVar.b = cloneWithWidgetNode.getDxTemplateItem();
        cloneWithWidgetNode.setDxError(eVar);
        return cloneWithWidgetNode;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int f() {
        if (this.w) {
            zx zxVar = this.f;
            if (zxVar == null) {
                return 0;
            }
            return zxVar.getRealCount();
        }
        ArrayList<DXWidgetNode> arrayList = this.e;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int size;
        int g;
        if (this.w) {
            zx zxVar = this.f;
            if (zxVar == null || (size = zxVar.getRealCount()) <= 0) {
                return 0;
            }
            g = g();
        } else {
            ArrayList<DXWidgetNode> arrayList = this.e;
            if (arrayList == null || arrayList.isEmpty()) {
                return 0;
            }
            size = this.e.size();
            g = g();
        }
        return size + g;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        if (m(i)) {
            return 2147483647L;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        String templateInfo;
        if (m(i)) {
            return -1;
        }
        DXWidgetNode i2 = i(i, true);
        if (i2 instanceof DXTemplateWidgetNode) {
            DXTemplateWidgetNode dXTemplateWidgetNode = (DXTemplateWidgetNode) i2;
            if (!TextUtils.isEmpty(dXTemplateWidgetNode.getReuseIdentifier())) {
                templateInfo = dXTemplateWidgetNode.getReuseIdentifier();
            } else {
                templateInfo = dXTemplateWidgetNode.getTemplateInfo();
            }
            if (this.t.containsKey(templateInfo)) {
                return this.t.get(templateInfo).intValue();
            }
            int size = this.t.size();
            this.t.put(templateInfo, Integer.valueOf(size));
            this.u.put(Integer.valueOf(size), templateInfo);
            return size;
        } else if (this.t.containsKey("default")) {
            return this.t.get("default").intValue();
        } else {
            int size2 = this.t.size();
            this.t.put("default", Integer.valueOf(size2));
            this.u.put(Integer.valueOf(size2), "default");
            return size2;
        }
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.IStickyAdapter
    public int getStickyOffset(int i) {
        int stickyPosition;
        if (isSticky(i)) {
            DXWidgetNode h = h(i);
            if (h instanceof DXTemplateWidgetNode) {
                return ((DXTemplateWidgetNode) h).getStickyOffset();
            }
            return 0;
        } else if (!hasPreSticky(i) || (stickyPosition = getStickyPosition(i)) < 0) {
            return 0;
        } else {
            DXWidgetNode h2 = h(stickyPosition);
            if (h2 instanceof DXTemplateWidgetNode) {
                return ((DXTemplateWidgetNode) h2).getStickyOffset();
            }
            return 0;
        }
    }

    public DXWidgetNode h(int i) {
        return i(i, false);
    }

    public DXWidgetNode i(int i, boolean z) {
        if (this.w) {
            zx zxVar = this.f;
            if (zxVar == null) {
                return null;
            }
            DXWidgetNode item = zxVar.getItem(i);
            if (item == null && z && this.g != null && this.f.e() != null) {
                if (i < 0 || i >= this.f.e().size()) {
                    return null;
                }
                Object obj = this.f.e().get(i);
                zx zxVar2 = this.f;
                item = zxVar2.b(this.g, obj, zxVar2.e(), this.g.getOriginWidgetNodes(), i, null);
            }
            if (item != null) {
                this.f.addItem(i, item);
            }
            return item;
        }
        ArrayList<DXWidgetNode> arrayList = this.e;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.e.get(i);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.IStickyAdapter
    public boolean isSticky(int i) {
        DXWidgetNode h = h(i);
        if (h instanceof DXTemplateWidgetNode) {
            return ((DXTemplateWidgetNode) h).isSticky();
        }
        return false;
    }

    public DXRecyclerLayout j() {
        return this.g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n(int i) {
        int i2;
        int i3;
        if (!this.j || (i2 = this.v) == 2 || i2 == 5 || l() || this.g == null || (i3 = this.v) == 6 || i3 == 2) {
            return;
        }
        if (i < 0) {
            A(2);
            this.g.onLoadMore();
        } else if (i <= 0 || getItemCount() - (i + 1) > this.g.getEndReachedThreshold()) {
        } else {
            A(2);
            this.g.onLoadMore();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View dXNativeFrameLayout;
        k kVar;
        if (i == -1) {
            RelativeLayout relativeLayout = new RelativeLayout(this.d);
            DXAbsOnLoadMoreView dXAbsOnLoadMoreView = this.m;
            if (dXAbsOnLoadMoreView != null) {
                relativeLayout.addView(dXAbsOnLoadMoreView, new ViewGroup.LayoutParams(-1, -2));
            } else {
                View view = this.l;
                if (view != null) {
                    relativeLayout.addView(view, new ViewGroup.LayoutParams(-1, -2));
                }
            }
            StaggeredGridLayoutManager.LayoutParams layoutParams = new StaggeredGridLayoutManager.LayoutParams(-2, -2);
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = k();
            layoutParams.setFullSpan(true);
            relativeLayout.setLayoutParams(layoutParams);
            ItemViewHolder itemViewHolder = new ItemViewHolder(relativeLayout);
            relativeLayout.setOnClickListener(new a());
            return itemViewHolder;
        }
        if (this.g.isEnableVideoControl() && (kVar = this.c) != null) {
            dXNativeFrameLayout = kVar.e(this.d);
        } else {
            dXNativeFrameLayout = new DXNativeFrameLayout(this.d);
        }
        dXNativeFrameLayout.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
        return new ItemViewHolder(dXNativeFrameLayout);
    }

    @Override // com.taobao.android.dinamicx.widget.recycler.IStickyAdapter
    public void onStickyChange(int i, boolean z) {
        DXWidgetNode h = h(i);
        if (h instanceof DXTemplateWidgetNode) {
            ((DXTemplateWidgetNode) h).triggerOnStickyChange(i, z);
        }
        this.g.triggerOnStickyChange(i, z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        this.i.f(viewHolder.getAdapterPosition());
        this.g.postEvent(this.i);
        ItemViewHolder itemViewHolder = (ItemViewHolder) viewHolder;
        DXWidgetNode dXWidgetNode = itemViewHolder.a;
        if (dXWidgetNode != null) {
            dXWidgetNode.sendBroadcastEvent(this.i);
            this.g.removeAppearWidget(itemViewHolder.a);
            if (itemViewHolder.a.getDXRuntimeContext() == null || itemViewHolder.a.getDXRuntimeContext().getEngineContext() == null || itemViewHolder.a.getDXRuntimeContext().getEngineContext().e() == null || itemViewHolder.a.getDXRuntimeContext().getEngineContext().e().j() == null) {
                return;
            }
            itemViewHolder.a.getDXRuntimeContext().getEngineContext().e().j().destroy(itemViewHolder.a.getDXRuntimeContext().getInstanceId());
        }
    }

    public void p(ArrayList<DXWidgetNode> arrayList) {
        this.e = arrayList;
        c();
    }

    public void q(List<DXWidgetNode> list) {
        p((ArrayList) list);
    }

    public void r(zx zxVar) {
        this.f = zxVar;
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(int i, DXWidgetNode dXWidgetNode) {
        if (this.w) {
            zx zxVar = this.f;
            if (zxVar != null) {
                zxVar.setItem(i, dXWidgetNode);
                return;
            }
            return;
        }
        ArrayList<DXWidgetNode> arrayList = this.e;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return;
        }
        this.e.set(i, dXWidgetNode);
    }

    public void t(String str) {
        this.o = str;
    }

    public void u(String str) {
        this.p = str;
    }

    public void v(String str) {
        this.q = str;
    }

    public void w(int i) {
        this.r = i;
    }

    public void x(int i) {
        this.s = i;
    }

    public void y(boolean z) {
        this.j = z;
    }

    public void z(DXRecyclerLayout dXRecyclerLayout) {
        this.g = dXRecyclerLayout;
        if (dXRecyclerLayout == null || this.c != null) {
            return;
        }
        this.c = new k(dXRecyclerLayout.getDXRuntimeContext().getEngineContext(), 3, UUID.randomUUID().toString(), dXRecyclerLayout.isEnableVideoControl());
        if (dXRecyclerLayout.getDXRuntimeContext().getEngineContext().b() != null) {
            dXRecyclerLayout.getDXRuntimeContext().getEngineContext().b().c();
        }
    }
}
