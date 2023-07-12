package com.taobao.android.dinamicx.widget;

import android.text.TextUtils;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONArray;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.android.dinamicx.C6386m;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.widget.recycler.RecyclerAdapter;
import com.taobao.android.dinamicx.widget.recycler.WaterfallLayout;
import com.taobao.android.dinamicx.widget.scroller.IDXScrollableLoadMoreListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tb.h00;
import tb.hy;
import tb.nz;
import tb.p20;
import tb.ry;
import tb.s00;
import tb.wt;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class DXAbsContainerBaseLayout extends DXLinearLayoutWidgetNode implements IDXScrollableLoadMoreListener {
    public static final long DXABSCONTAINERBASELAYOUT_POSTEVENTSAMPLING = 6334795214712177940L;
    public static final long DXDXABSCONTAINERBASELAYOUT_DATASOURCE = -5948810534719014123L;
    public static final long DXDXABSCONTAINERBASELAYOUT_ONCREATE = 5288680013941347641L;
    public static final long DXDXABSCONTAINERBASELAYOUT_ONSCROLL = 5288751146867425108L;
    public static final long DXDXABSCONTAINERBASELAYOUT_ONSCROLLBEGIN = 9144262755562405950L;
    public static final long DXDXABSCONTAINERBASELAYOUT_ONSCROLLEND = 2691126191158604142L;
    public static final int DXRECYCLERLAYOUT_ISOPENLOADMORE_TRUE = 1;
    public static final int DXRECYCLERLAYOUT_ISOPENPULLTOREFRESH_TRUE = 1;
    public static final long DXRECYCLERLAYOUT_ONENDREACHED = -2277119638481222228L;
    public static final long DXRECYCLERLAYOUT_ORIENTATION = -7199229155167727177L;
    public static final int LOAD_MORE_EMPTY_INT = 6;
    public static final int LOAD_MORE_END = 4;
    public static final int LOAD_MORE_FAIL = 3;
    public static final int LOAD_MORE_IDLE = 1;
    public static final int LOAD_MORE_LOADING = 2;
    public static final int LOAD_MORE_NO_DATA = 5;
    public static final String TAG = "DXAbsContainerBaseLayout";
    protected List<WeakReference<DXWidgetNode>> appearWidgets;
    List<Object> dataSource;
    private JSONArray exportMethods;
    private ArrayList<DXWidgetNode> itemWidgetNodes;
    protected ArrayList<DXWidgetNode> originWidgetNodes;
    private int postEventSampling = 1;
    private int samplingCount = 1;
    int scrollPosition = -1;
    protected WaterfallLayout waterfallLayout;
    protected C6386m widgetNodeParser;

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface LoadMoreStatus {
    }

    public DXAbsContainerBaseLayout() {
        this.markContainer = true;
    }

    private void broadcastChildrenEvent(hy hyVar) {
        Iterator<WeakReference<DXWidgetNode>> it;
        try {
            List<WeakReference<DXWidgetNode>> list = this.appearWidgets;
            if (list == null || list.size() == 0 || (it = this.appearWidgets.iterator()) == null) {
                return;
            }
            while (it.hasNext()) {
                WeakReference<DXWidgetNode> next = it.next();
                DXWidgetNode dXWidgetNode = next.get();
                if (next.get() == null) {
                    it.remove();
                } else if (hyVar instanceof p20) {
                    ((p20) hyVar).f(dXWidgetNode.getDXRuntimeContext().getSubdataIndex());
                } else {
                    dXWidgetNode.sendBroadcastEvent(hyVar);
                }
            }
        } catch (Exception e) {
            ry.b(e);
        }
    }

    private void parseTemplateWidgetNode(DXTemplateWidgetNode dXTemplateWidgetNode) {
        if (this.widgetNodeParser == null) {
            this.widgetNodeParser = new C6386m();
        }
        this.widgetNodeParser.h(dXTemplateWidgetNode, true);
        if (TextUtils.isEmpty(dXTemplateWidgetNode.getSlotId())) {
            return;
        }
        dXTemplateWidgetNode.processContainsSlotIdTemplate();
    }

    private void postOnLoadMoreEvent() {
        postEvent(new hy(DXRECYCLERLAYOUT_ONENDREACHED));
    }

    public void addAppearWidget(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode == null) {
            return;
        }
        if (this.appearWidgets == null) {
            this.appearWidgets = new ArrayList();
        }
        this.appearWidgets.add(new WeakReference<>(dXWidgetNode));
        if (dXWidgetNode instanceof DXTemplateWidgetNode) {
            ((DXTemplateWidgetNode) dXWidgetNode).setAppearing(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void bindContext(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode.getSourceWidget() == null) {
            dXWidgetNode.setSourceWidget(dXWidgetNode);
        }
        List<DXWidgetNode> children = dXWidgetNode.getChildren();
        if (children == null || children.size() == 0) {
            return;
        }
        for (DXWidgetNode dXWidgetNode2 : children) {
            bindContext(dXWidgetNode2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void bindRuntimeContext(DXRuntimeContext dXRuntimeContext, boolean z) {
        if (dXRuntimeContext == null) {
            return;
        }
        Object obj = null;
        int i = 0;
        if (z) {
            obj = this.dXRuntimeContext.getSubData();
            i = this.dXRuntimeContext.getSubdataIndex();
        }
        if (this.dXRuntimeContext != dXRuntimeContext) {
            DXRuntimeContext cloneWithWidgetNode = dXRuntimeContext.cloneWithWidgetNode(this);
            this.dXRuntimeContext = cloneWithWidgetNode;
            if (z) {
                cloneWithWidgetNode.setSubData(obj);
                this.dXRuntimeContext.setSubdataIndex(i);
            }
        }
        if (getItemWidgetNodes() != null) {
            for (DXWidgetNode dXWidgetNode : getItemWidgetNodes()) {
                dXWidgetNode.bindRuntimeContext(dXRuntimeContext, z);
            }
        }
    }

    void bindSourceWidget(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode.getSourceWidget() == null) {
            dXWidgetNode.setSourceWidget(dXWidgetNode);
        }
        List<DXWidgetNode> children = dXWidgetNode.getChildren();
        if (children == null || children.size() == 0) {
            return;
        }
        for (DXWidgetNode dXWidgetNode2 : children) {
            bindSourceWidget(dXWidgetNode2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new C6493f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.taobao.android.dinamicx.widget.DXTemplateWidgetNode deepCopyChildForTemplate(com.taobao.android.dinamicx.widget.DXWidgetNode r6, java.lang.Object r7, int r8, com.taobao.analysis.v3.FalcoSpan r9) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout.deepCopyChildForTemplate(com.taobao.android.dinamicx.widget.DXWidgetNode, java.lang.Object, int, com.taobao.analysis.v3.FalcoSpan):com.taobao.android.dinamicx.widget.DXTemplateWidgetNode");
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public JSONArray exportMethods() {
        if (this.exportMethods == null) {
            this.exportMethods = new JSONArray() { // from class: com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout.1
            };
            this.exportMethods.addAll(super.exportMethods());
        }
        return this.exportMethods;
    }

    public ArrayList<DXWidgetNode> generateWidgetNodeByData(List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        ArrayList<DXWidgetNode> arrayList = new ArrayList<>();
        if (list2 != null && !list2.isEmpty() && list != null && !list.isEmpty()) {
            while (i < i2) {
                Object obj = list.get(i);
                DXWidgetNode dXWidgetNode = null;
                for (int i3 = 0; i3 < list2.size() && (dXWidgetNode = deepCopyChildForTemplate(list2.get(i3), obj, i, falcoSpan)) == null; i3++) {
                }
                if (dXWidgetNode == null) {
                    dXWidgetNode = new h00();
                    dXWidgetNode.setDXRuntimeContext(getDXRuntimeContext().cloneWithWidgetNode(dXWidgetNode));
                    dXWidgetNode.setVisibility(2);
                }
                arrayList.add(dXWidgetNode);
                i++;
            }
        }
        return arrayList;
    }

    public List<Object> getDataSource() {
        return this.dataSource;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public String getDefaultValueForStringAttr(long j) {
        return super.getDefaultValueForStringAttr(j);
    }

    public List<DXWidgetNode> getItemWidgetNodes() {
        return this.itemWidgetNodes;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getMarginLeft() {
        return this.marginLeft;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getMarginRight() {
        return this.marginRight;
    }

    public int getScrollPosition() {
        return this.scrollPosition;
    }

    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        if (this.originWidgetNodes == null) {
            ArrayList<DXWidgetNode> arrayList = new ArrayList<>();
            this.originWidgetNodes = arrayList;
            arrayList.addAll(getChildren());
        }
        if (this.dataSource == null) {
            s00.b(getUserId() + " datasource 是空重新构建一个");
            this.dataSource = new JSONArray();
        }
        Iterator<DXWidgetNode> it = this.originWidgetNodes.iterator();
        while (it.hasNext()) {
            bindContext(it.next());
        }
        List<Object> list = this.dataSource;
        setItemWidgetNodes(generateWidgetNodeByData(list, this.originWidgetNodes, 0, list.size(), null));
        removeAllChild();
        if (wt.D0()) {
            for (DXWidgetNode dXWidgetNode : getItemWidgetNodes()) {
                addChild(dXWidgetNode, false);
            }
        }
        setDisableFlatten(true);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode instanceof DXAbsContainerBaseLayout) {
            super.onClone(dXWidgetNode, z);
            DXAbsContainerBaseLayout dXAbsContainerBaseLayout = (DXAbsContainerBaseLayout) dXWidgetNode;
            this.dataSource = dXAbsContainerBaseLayout.dataSource;
            setItemWidgetNodes(dXAbsContainerBaseLayout.getItemWidgetNodes());
            this.appearWidgets = dXAbsContainerBaseLayout.appearWidgets;
            if (wt.O0()) {
                this.originWidgetNodes = dXAbsContainerBaseLayout.originWidgetNodes;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public boolean onEvent(hy hyVar) {
        return super.onEvent(hyVar);
    }

    @Override // com.taobao.android.dinamicx.widget.scroller.IDXScrollableLoadMoreListener
    public void onLoadMore() {
        nz.i(TAG, "收到loadMore1");
        updateLoadMoreStatus(2);
        postOnLoadMoreEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        removeAllChild();
        super.onMeasure(i, i2);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == DXABSCONTAINERBASELAYOUT_POSTEVENTSAMPLING) {
            if (i <= 0) {
                i = 1;
            }
            this.postEventSampling = i;
            return;
        }
        super.onSetIntAttribute(j, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        if (j == -5948810534719014123L) {
            this.dataSource = jSONArray;
            this.propertyInitFlag |= 2;
            return;
        }
        super.onSetListAttribute(j, jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetUserDefinedListAttribute(long j, List<Object> list) {
        if (-5948810534719014123L == j) {
            this.dataSource = list;
            this.propertyInitFlag |= 2;
            return;
        }
        super.onSetUserDefinedListAttribute(j, list);
    }

    public final boolean postEventWithSampling(hy hyVar) {
        int i = this.samplingCount;
        if (i % this.postEventSampling != 0) {
            this.samplingCount = i + 1;
            return false;
        }
        this.samplingCount = 1;
        if (!this.isFlatten) {
            return onEvent(hyVar);
        }
        return getReferenceNode().onEvent(hyVar);
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode queryWTByAutoId(int i) {
        DXWidgetNode queryWTByAutoId = super.queryWTByAutoId(i);
        if (queryWTByAutoId == null) {
            if (getItemWidgetNodes() == null) {
                return null;
            }
            Iterator<DXWidgetNode> it = getItemWidgetNodes().iterator();
            while (it.hasNext() && (queryWTByAutoId = it.next().queryWTByAutoId(i)) == null) {
            }
        }
        return queryWTByAutoId;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode queryWTByUserId(String str) {
        DXWidgetNode queryWTByUserId = super.queryWTByUserId(str);
        if (queryWTByUserId == null) {
            if (getItemWidgetNodes() == null) {
                return null;
            }
            for (DXWidgetNode dXWidgetNode : getItemWidgetNodes()) {
                DXWidgetNode queryWTByUserId2 = dXWidgetNode.queryWTByUserId(str);
                if (queryWTByUserId2 != null) {
                    return queryWTByUserId2;
                }
            }
        }
        return queryWTByUserId;
    }

    public boolean removeAppearWidget(DXWidgetNode dXWidgetNode) {
        if (dXWidgetNode != null) {
            try {
                if (this.appearWidgets != null) {
                    if (dXWidgetNode instanceof DXTemplateWidgetNode) {
                        ((DXTemplateWidgetNode) dXWidgetNode).setAppearing(false);
                    }
                    Iterator<WeakReference<DXWidgetNode>> it = this.appearWidgets.iterator();
                    if (it == null) {
                        return false;
                    }
                    while (it.hasNext()) {
                        WeakReference<DXWidgetNode> next = it.next();
                        if (next != null && next.get() != null) {
                            if (next.get() == dXWidgetNode) {
                                it.remove();
                                return true;
                            }
                        }
                        it.remove();
                    }
                    return false;
                }
            } catch (Exception e) {
                ry.b(e);
            }
        }
        return false;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void sendBroadcastEvent(hy hyVar) {
        if (hyVar == null) {
            return;
        }
        if (5288671110273408574L == hyVar.b()) {
            postEvent(hyVar);
            broadcastChildrenEvent(new p20(DXScrollLayoutBase.DX_SCROLL_LAYOUT_BASE_ON_PAGE_APPEAR));
        } else if (5388973340095122049L == hyVar.b()) {
            postEvent(hyVar);
            broadcastChildrenEvent(new p20(DXScrollLayoutBase.DX_SCROLL_LAYOUT_BASE_ON_PAGE_DISAPPEAR));
        } else {
            postEvent(hyVar);
            broadcastChildrenEvent(hyVar);
        }
    }

    public void setItemWidgetNodes(List<DXWidgetNode> list) {
        this.itemWidgetNodes = (ArrayList) list;
    }

    public void setScrollPosition(int i) {
        this.scrollPosition = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void trackError(int i, String str, String str2, String str3) {
        DXAppMonitor.q(getDXRuntimeContext().getBizType(), getDXRuntimeContext().getDxTemplateItem(), "DX_RECYCLER", "DX_RECYCLER_ERROR", i, str);
    }

    public boolean updateLoadMoreStatus(int i) {
        RecyclerView e;
        RecyclerAdapter recyclerAdapter;
        WaterfallLayout waterfallLayout = this.waterfallLayout;
        if (waterfallLayout == null || (e = waterfallLayout.e()) == null || (recyclerAdapter = (RecyclerAdapter) e.getAdapter()) == null) {
            return false;
        }
        recyclerAdapter.A(i);
        nz.i(TAG, "更新状态" + i);
        return true;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void updateRefreshType(int i) {
        DXRuntimeContext dXRuntimeContext = this.dXRuntimeContext;
        if (dXRuntimeContext != null) {
            dXRuntimeContext.setRefreshType(i);
        }
        if (getItemWidgetNodes() != null) {
            for (DXWidgetNode dXWidgetNode : getItemWidgetNodes()) {
                dXWidgetNode.updateRefreshType(i);
            }
        }
    }
}
