package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$layout;
import com.taobao.android.dinamicx.view.DXGridLayoutManager;
import com.taobao.android.dinamicx.view.DXNativeRecyclerView;
import com.taobao.android.dinamicx.widget.DXScrollerLayout;
import com.taobao.android.dinamicx.widget.scroller.IDXScrollableLoadMoreListener;
import com.taobao.android.dinamicx.widget.scroller.ViewHolder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import tb.d10;
import tb.e10;
import tb.hy;
import tb.nz;
import tb.pz;
import tb.ry;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXScrollableLayout extends DXScrollerLayout implements IDXScrollableLoadMoreListener {
    private static final int DEFAULT_COLUMN_COUNT = 1;
    private static final int DEFAULT_PRELOAD_COUNT = 3;
    public static final long DXSCROLLABLELAYOUT_COLUMNCOUNT = 4480460401770252962L;
    public static final long DXSCROLLABLELAYOUT_ISOPENLOADMORE = 2380170249149374095L;
    public static final long DXSCROLLABLELAYOUT_LOADMOREFAILTEXT = 7321446999712924516L;
    public static final long DXSCROLLABLELAYOUT_LOADMORELOADINGTEXT = -3963239569560963927L;
    public static final long DXSCROLLABLELAYOUT_LOADMORENOMOREDATATEXT = -7969714938924101192L;
    public static final long DXSCROLLABLELAYOUT_PRELOADITEMCOUNT = -7119500793674581393L;
    public static final long DXSCROLLABLELAYOUT_SCROLLABLELAYOUT = -211546880150949743L;
    public static final int LOAD_MORE_END = 4;
    public static final String LOAD_MORE_END_STRING = "LOAD_MORE_END";
    public static final int LOAD_MORE_FAIL = 3;
    public static final String LOAD_MORE_FAIL_STRING = "LOAD_MORE_FAIL";
    public static final int LOAD_MORE_IDLE = 1;
    public static final String LOAD_MORE_IDLE_STRING = "LOAD_MORE_IDLE";
    public static final int LOAD_MORE_LOADING = 2;
    public static final String LOAD_MORE_LOADING_STRING = "LOAD_MORE_LOADING";
    public static final int LOAD_MORE_NO_DATA = 5;
    public static final String LOAD_MORE_NO_DATA_STRING = "LOAD_MORE_NO_DATA";
    public static final String MSG_METHOD_appendData = "DXScrollableLayout#appendData";
    public static final String MSG_METHOD_updateLoadMoreStatus = "DXScrollableLayout#updateLoadMoreStatus";
    public static final String MSG_PROPERTY_data = "data";
    public static final String MSG_PROPERTY_status = "status";
    private List<DXWidgetNode> originChildren;
    private String loadMoreFailText = "太火爆啦，点我再尝试下吧";
    private String loadMoreLoadingText = "";
    private String loadMoreNoMoreDataText = "亲，已经到底了哦";
    private int columnCount = 1;
    private boolean isOpenLoadMore = true;
    private int preLoadItemCount = 3;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface LoadMoreStatus {
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class ScrollerAdapterUpgrade extends DXScrollerLayout.ScrollerAdapter {
        public static final int TYPE_COMMON_VIEW = 1;
        public static final int TYPE_EMPTY_VIEW = 3;
        public static final int TYPE_FOOTER_VIEW = 2;
        private boolean h;
        private RelativeLayout i;
        private View j;
        private DXGridLayoutManager k;
        private TextView l;
        private ProgressBar m;
        private String n;
        private String o;
        private String p;
        private int q;
        private int r;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* loaded from: classes11.dex */
        public class a extends GridLayoutManager.SpanSizeLookup {
            final /* synthetic */ DXGridLayoutManager a;

            a(DXGridLayoutManager dXGridLayoutManager) {
                this.a = dXGridLayoutManager;
            }

            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int i) {
                if (ScrollerAdapterUpgrade.this.n(i)) {
                    return this.a.getSpanCount();
                }
                return 1;
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes12.dex */
        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScrollerAdapterUpgrade.this.p(view);
            }
        }

        public ScrollerAdapterUpgrade(Context context, DXScrollerLayout dXScrollerLayout) {
            super(context, dXScrollerLayout);
            this.h = true;
            this.n = "太火爆啦，点我再尝试下吧";
            this.o = "";
            this.p = "亲，已经到底了哦";
            this.q = 1;
            this.r = 3;
            View a2 = e10.a(context, R$layout.dx_scrollable_load_more_bottom);
            this.l = (TextView) a2.findViewById(R$id.scrollable_loadmore_tv);
            this.m = (ProgressBar) a2.findViewById(R$id.scrollable_loadmore_progressbar);
            k(a2);
        }

        private void k(View view) {
            if (view == null) {
                return;
            }
            if (this.i == null) {
                this.i = new RelativeLayout(this.b);
            }
            q();
            this.i.addView(view, new ViewGroup.LayoutParams(-1, -2));
        }

        private int l() {
            return (!this.h || m()) ? 0 : 1;
        }

        private boolean m() {
            ArrayList<DXWidgetNode> arrayList = this.c;
            return arrayList == null || arrayList.isEmpty();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean n(int i) {
            return this.h && i >= getItemCount() - 1;
        }

        private void o(int i) {
            int i2;
            DXScrollerLayout dXScrollerLayout;
            if (!this.h || (i2 = this.q) == 2 || i2 == 5 || m()) {
                return;
            }
            if (i < 0) {
                DXScrollerLayout dXScrollerLayout2 = this.d;
                if (dXScrollerLayout2 == null || !(dXScrollerLayout2 instanceof DXScrollableLayout)) {
                    return;
                }
                v(2);
                ((DXScrollableLayout) this.d).onLoadMore();
            } else if (i <= 0 || (this.c.size() - 1) - (i - l()) > this.r || (dXScrollerLayout = this.d) == null || !(dXScrollerLayout instanceof DXScrollableLayout)) {
            } else {
                v(2);
                ((DXScrollableLayout) this.d).onLoadMore();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(View view) {
            if (3 == this.q) {
                o(-1);
            }
        }

        private void q() {
            this.i.removeAllViews();
        }

        @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout.ScrollerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<DXWidgetNode> arrayList = this.c;
            if (arrayList != null && !arrayList.isEmpty()) {
                return this.c.size() + l();
            }
            return super.getItemCount();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (!m() || this.j == null) {
                return n(i) ? 2 : 1;
            }
            return 3;
        }

        @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout.ScrollerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (getItemViewType(i) == 1) {
                super.onBindViewHolder(viewHolder, i);
            }
            o(i);
        }

        @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout.ScrollerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i != 2) {
                return super.onCreateViewHolder(viewGroup, i);
            }
            if (this.i == null) {
                this.i = new RelativeLayout(this.b);
            }
            ViewHolder a2 = ViewHolder.a(this.i);
            this.i.setOnClickListener(new b());
            return a2;
        }

        public void r(DXGridLayoutManager dXGridLayoutManager) {
            this.k = dXGridLayoutManager;
            dXGridLayoutManager.setSpanSizeLookup(new a(dXGridLayoutManager));
        }

        public void s(String str) {
            this.n = str;
        }

        public void t(String str) {
            this.o = str;
        }

        public void u(String str) {
            this.p = str;
        }

        public void v(int i) {
            this.q = i;
            if (i == 2) {
                this.m.setVisibility(0);
                this.l.setVisibility(0);
                this.l.setText(this.o);
            } else if (i == 3) {
                this.m.setVisibility(8);
                this.l.setVisibility(0);
                this.l.setText(this.n);
            } else if (i == 4) {
                this.m.setVisibility(8);
                this.l.setVisibility(8);
                this.l.setText("");
            } else if (i != 5) {
            } else {
                this.m.setVisibility(8);
                this.l.setVisibility(0);
                this.l.setText(this.p);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXScrollableLayout();
        }
    }

    private void postOnLoadMoreEvent() {
        postEvent(new d10());
    }

    private void refresh() {
        try {
            final DXNativeRecyclerView dXNativeRecyclerView = (DXNativeRecyclerView) getDXRuntimeContext().getNativeView();
            if (dXNativeRecyclerView.getScrollState() == 0 && !dXNativeRecyclerView.isComputingLayout()) {
                dXNativeRecyclerView.getAdapter().notifyDataSetChanged();
            } else {
                dXNativeRecyclerView.post(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXScrollableLayout.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dXNativeRecyclerView.getAdapter().notifyDataSetChanged();
                    }
                });
            }
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public boolean appendData(JSONArray jSONArray) {
        if (jSONArray == null) {
            return false;
        }
        this.itemWidgetNodes.addAll(generateItemsNode(jSONArray));
        getListData().addAll(jSONArray);
        refresh();
        return true;
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXScrollableLayout();
    }

    protected ArrayList<DXWidgetNode> generateItemsNode(JSONArray jSONArray) {
        return generateWidgetNodeByData(getListData().size(), jSONArray, this.originChildren);
    }

    public String getLoadMoreFailText() {
        return this.loadMoreFailText;
    }

    public String getLoadMoreLoadingText() {
        return this.loadMoreLoadingText;
    }

    public String getLoadMoreNoMoreDataText() {
        return this.loadMoreNoMoreDataText;
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        this.originChildren = new ArrayList();
        if (getChildren() != null && getChildren().size() > 0) {
            for (int i = 0; i < getChildren().size(); i++) {
                this.originChildren.add(getChildAt(i).deepClone(getDXRuntimeContext()));
            }
        }
        super.onBeforeBindChildData();
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode == null || !(dXWidgetNode instanceof DXScrollableLayout)) {
            return;
        }
        super.onClone(dXWidgetNode, z);
        DXScrollableLayout dXScrollableLayout = (DXScrollableLayout) dXWidgetNode;
        this.originChildren = dXScrollableLayout.originChildren;
        this.loadMoreFailText = dXScrollableLayout.loadMoreFailText;
        this.loadMoreLoadingText = dXScrollableLayout.loadMoreLoadingText;
        this.loadMoreNoMoreDataText = dXScrollableLayout.loadMoreNoMoreDataText;
        this.preLoadItemCount = dXScrollableLayout.preLoadItemCount;
        this.columnCount = dXScrollableLayout.columnCount;
        this.isOpenLoadMore = dXScrollableLayout.isOpenLoadMore;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return super.onCreateView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public boolean onEvent(hy hyVar) {
        if (hyVar instanceof pz) {
            pz pzVar = (pz) hyVar;
            if (pzVar.h().equalsIgnoreCase("General")) {
                JSONObject g = pzVar.g();
                String f = pzVar.f();
                if (MSG_METHOD_updateLoadMoreStatus.equalsIgnoreCase(f)) {
                    String string = g.getString("status");
                    string.hashCode();
                    char c = 65535;
                    switch (string.hashCode()) {
                        case -1870033097:
                            if (string.equals(LOAD_MORE_NO_DATA_STRING)) {
                                c = 0;
                                break;
                            }
                            break;
                        case -464686673:
                            if (string.equals(LOAD_MORE_FAIL_STRING)) {
                                c = 1;
                                break;
                            }
                            break;
                        case -464594331:
                            if (string.equals(LOAD_MORE_IDLE_STRING)) {
                                c = 2;
                                break;
                            }
                            break;
                        case 123556874:
                            if (string.equals(LOAD_MORE_END_STRING)) {
                                c = 3;
                                break;
                            }
                            break;
                        case 622228715:
                            if (string.equals(LOAD_MORE_LOADING_STRING)) {
                                c = 4;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            return updateLoadMoreStatus(5);
                        case 1:
                            return updateLoadMoreStatus(3);
                        case 2:
                            return updateLoadMoreStatus(1);
                        case 3:
                            return updateLoadMoreStatus(4);
                        case 4:
                            return updateLoadMoreStatus(2);
                        default:
                            return false;
                    }
                } else if (MSG_METHOD_appendData.equalsIgnoreCase(f)) {
                    return appendData(g.getJSONArray("data"));
                }
            }
        }
        return super.onEvent(hyVar);
    }

    @Override // com.taobao.android.dinamicx.widget.scroller.IDXScrollableLoadMoreListener
    public void onLoadMore() {
        nz.i("收到loadMore", new String[0]);
        updateLoadMoreStatus(2);
        postOnLoadMoreEvent();
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == 4480460401770252962L) {
            if (i <= 0) {
                i = 1;
            }
            this.columnCount = i;
        } else if (j == 2380170249149374095L) {
            this.isOpenLoadMore = i != 0;
        } else if (j == DXSCROLLABLELAYOUT_PRELOADITEMCOUNT) {
            if (i < 0) {
                i = 3;
            }
            this.preLoadItemCount = i;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == 7321446999712924516L) {
            this.loadMoreFailText = str;
        } else if (j == -3963239569560963927L) {
            this.loadMoreLoadingText = str;
        } else if (j == -7969714938924101192L) {
            this.loadMoreNoMoreDataText = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout
    protected void setAdapter(DXScrollerLayout dXScrollerLayout, RecyclerView recyclerView, Context context) {
        ScrollerAdapterUpgrade scrollerAdapterUpgrade = (ScrollerAdapterUpgrade) recyclerView.getAdapter();
        if (scrollerAdapterUpgrade == null) {
            scrollerAdapterUpgrade = new ScrollerAdapterUpgrade(context, dXScrollerLayout);
            scrollerAdapterUpgrade.setHasStableIds(true);
            scrollerAdapterUpgrade.c(dXScrollerLayout.itemWidgetNodes);
            recyclerView.setAdapter(scrollerAdapterUpgrade);
            scrollerAdapterUpgrade.r((DXGridLayoutManager) recyclerView.getLayoutManager());
        } else {
            scrollerAdapterUpgrade.c(dXScrollerLayout.itemWidgetNodes);
            scrollerAdapterUpgrade.f(dXScrollerLayout);
            if (this.contentOffset <= -1) {
                ((DXNativeRecyclerView) recyclerView).needScrollAfterLayout(0, 0, dXScrollerLayout.contentHorizontalLength, dXScrollerLayout.contentVerticalLength);
            }
            scrollerAdapterUpgrade.notifyDataSetChanged();
        }
        scrollerAdapterUpgrade.s(this.loadMoreFailText);
        scrollerAdapterUpgrade.t(this.loadMoreLoadingText);
        scrollerAdapterUpgrade.u(this.loadMoreNoMoreDataText);
        scrollerAdapterUpgrade.r = this.preLoadItemCount;
        scrollerAdapterUpgrade.h = this.isOpenLoadMore;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout
    public void setLayoutManager(Context context, DXScrollerLayout dXScrollerLayout, RecyclerView recyclerView) {
        DXGridLayoutManager dXGridLayoutManager = (DXGridLayoutManager) recyclerView.getLayoutManager();
        if (dXGridLayoutManager == null) {
            dXGridLayoutManager = new DXGridLayoutManager(context, this.columnCount);
            recyclerView.setLayoutManager(dXGridLayoutManager);
        }
        if (getOrientation() == 1) {
            dXGridLayoutManager.setOrientation(1);
        } else {
            dXGridLayoutManager.setOrientation(0);
        }
        dXGridLayoutManager.setItemPrefetchEnabled(dXScrollerLayout.isItemPrefetch());
    }

    public void setLoadMoreFailText(String str) {
        this.loadMoreFailText = str;
    }

    public void setLoadMoreLoadingText(String str) {
        this.loadMoreLoadingText = str;
    }

    public void setLoadMoreNoMoreDataText(String str) {
        this.loadMoreNoMoreDataText = str;
    }

    public boolean updateLoadMoreStatus(int i) {
        ScrollerAdapterUpgrade scrollerAdapterUpgrade;
        View nativeView = getDXRuntimeContext().getNativeView();
        if (nativeView == null || !(nativeView instanceof DXNativeRecyclerView) || (scrollerAdapterUpgrade = (ScrollerAdapterUpgrade) ((DXNativeRecyclerView) nativeView).getAdapter()) == null) {
            return false;
        }
        scrollerAdapterUpgrade.v(i);
        nz.i("更新状态" + i, new String[0]);
        return true;
    }
}
