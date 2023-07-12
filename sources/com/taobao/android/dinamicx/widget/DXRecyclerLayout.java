package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.taobao.analysis.v3.FalcoAbilitySpan;
import com.taobao.analysis.v3.FalcoSpan;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.videoc.DXVideoControlConfig;
import com.taobao.android.dinamicx.widget.recycler.IDXRecyclerOnScrollToPos;
import com.taobao.android.dinamicx.widget.recycler.PrefetchRecyclerAdapter;
import com.taobao.android.dinamicx.widget.recycler.RecyclerAdapter;
import com.taobao.android.dinamicx.widget.recycler.ScrollListener;
import com.taobao.android.dinamicx.widget.recycler.WaterfallLayout;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeDistinctCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeFilterCallback;
import com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeStayCallback;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.DXDataSourceLruManager;
import com.taobao.android.dinamicx.widget.recycler.manager.datasource.IDXDataSourceManager;
import com.taobao.android.dinamicx.widget.recycler.nested.DXNestedScrollerView;
import com.taobao.android.dinamicx.widget.recycler.view.DXRecyclerView;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;
import tb.ay;
import tb.az;
import tb.by;
import tb.g20;
import tb.h00;
import tb.hy;
import tb.j00;
import tb.l00;
import tb.m00;
import tb.n00;
import tb.nz;
import tb.o00;
import tb.p00;
import tb.pz;
import tb.q00;
import tb.ry;
import tb.s00;
import tb.te;
import tb.wt;
import tb.x41;
import tb.y00;
import tb.yx1;
import tb.zx;
import tb.zz;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXRecyclerLayout extends DXAbsContainerBaseLayout {
    public static final String ABILITY_SPAN = "ability_span";
    private static final String DELIMITER = " .[]";
    public static final long DXRECYCLERLAYOUT_ADAPTERTYPE = 4719559293862423182L;
    public static final int DXRECYCLERLAYOUT_ADAPTERTYPE_COMMON = 0;
    public static final int DXRECYCLERLAYOUT_ADAPTERTYPE_DATACOPY = 1;
    public static final int DXRECYCLERLAYOUT_ADAPTERTYPE_TWODIMENSIONALARRAY = 2;
    public static final long DXRECYCLERLAYOUT_COLUMNCOUNT = 4480460401770252962L;
    public static final long DXRECYCLERLAYOUT_COLUMNGAP = 7523322875951878575L;
    public static final long DXRECYCLERLAYOUT_DATASOURCE = -5948810534719014123L;
    public static final long DXRECYCLERLAYOUT_DEFAULTLOADMORESTATUS = 4192478880209527953L;
    public static final long DXRECYCLERLAYOUT_DISABLEBOUNCES = -7721339152929171023L;
    public static final long DXRECYCLERLAYOUT_ENABLELEFTGAPWHENSINGLECOLUMN = 3569509988477778057L;
    public static final int DXRECYCLERLAYOUT_ENABLELEFTGAPWHENSINGLECOLUMN_FALSE = 0;
    public static final int DXRECYCLERLAYOUT_ENABLELEFTGAPWHENSINGLECOLUMN_TRUE = 1;
    public static final long DXRECYCLERLAYOUT_ENABLETRACKSTAYTIME = 1118607339767866271L;
    public static final int DXRECYCLERLAYOUT_ENABLETRACKSTAYTIME_FALSE = 0;
    public static final int DXRECYCLERLAYOUT_ENABLETRACKSTAYTIME_TRUE = 1;
    public static final long DXRECYCLERLAYOUT_ENDREACHEDTHRESHOLD = 5205069215281796771L;
    public static final long DXRECYCLERLAYOUT_EXPOSURESPACEFACTOR = -277183941220263719L;
    public static final long DXRECYCLERLAYOUT_EXPOSURETIMEFACTOR = -2576277436099050373L;
    public static final long DXRECYCLERLAYOUT_FIXVERTICALSCROLLCONFLICT = 8809657122981937979L;
    public static final long DXRECYCLERLAYOUT_ISOPENLOADMORE = 2380170249149374095L;
    public static final int DXRECYCLERLAYOUT_ISOPENLOADMORE_TRUE = 1;
    public static final long DXRECYCLERLAYOUT_ISOPENPULLTOREFRESH = 1110502637440832944L;
    public static final int DXRECYCLERLAYOUT_ISOPENPULLTOREFRESH_TRUE = 1;
    public static final long DXRECYCLERLAYOUT_LEFTGAP = 5063678658862152906L;
    public static final long DXRECYCLERLAYOUT_LOADMOREFAILTEXT = 7321446999712924516L;
    public static final long DXRECYCLERLAYOUT_LOADMORELOADINGTEXT = -3963239569560963927L;
    public static final long DXRECYCLERLAYOUT_LOADMORENOMOREDATATEXT = -7969714938924101192L;
    public static final long DXRECYCLERLAYOUT_LOADMORETEXTCOLOR = 3416394884019274728L;
    public static final long DXRECYCLERLAYOUT_LOADMORETEXTSIZE = 8369659249760268163L;
    public static final long DXRECYCLERLAYOUT_NEEDITEMANIMATION = -3924891868525265444L;
    public static final int DXRECYCLERLAYOUT_NEEDITEMANIMATION_FALSE = 0;
    public static final int DXRECYCLERLAYOUT_NEEDITEMANIMATION_TRUE = 1;
    public static final long DXRECYCLERLAYOUT_ONEXPOSURE = 6278152710403332930L;
    public static final long DXRECYCLERLAYOUT_ONSTARTREACHED = -1945209666977474139L;
    public static final long DXRECYCLERLAYOUT_ONSTAY = 9859236201376900L;
    public static final long DXRECYCLERLAYOUT_ONSTICKYCHANGE = 2228800223520853672L;
    public static final long DXRECYCLERLAYOUT_OPENPREFETCH = 149121233077571055L;
    public static final int DXRECYCLERLAYOUT_OPENPREFETCH_FALSE = 0;
    public static final int DXRECYCLERLAYOUT_OPENPREFETCH_TRUE = 1;
    public static final long DXRECYCLERLAYOUT_ORIENTATION = -7199229155167727177L;
    public static final long DXRECYCLERLAYOUT_PREFETCHBATCHSIZE = 2756224129729260223L;
    public static final long DXRECYCLERLAYOUT_RECYCLERLAYOUT = -1365643441053437243L;
    public static final long DXRECYCLERLAYOUT_REFRESHLOADINGTEXT = 4423553470726895972L;
    public static final long DXRECYCLERLAYOUT_REFRESHPULLTEXT = 4728312954970318656L;
    public static final long DXRECYCLERLAYOUT_REFRESHRELEASETEXT = -5282950348472280217L;
    public static final long DXRECYCLERLAYOUT_RIGHTGAP = 6166552115852018494L;
    public static final long DXRECYCLERLAYOUT_STARTREACHEDTHRESHOLD = -6236604739320595556L;
    public static final long DXRECYCLERLAYOUT_VIDEOCONTROLCONFIG = -7801350391660369312L;
    protected static final String ITEM_DATA = "item_data";
    public static final String LOAD_MORE_EMPTY = "empty";
    public static final String LOAD_MORE_FAIL_STRING = "failed";
    public static final String LOAD_MORE_LOADING_STRING = "loading";
    public static final String LOAD_MORE_NO_DATA_STRING = "noMore";
    public static final String LOAD_MORE_STOPED = "stopped";
    public static final String MSG_METHOD_APPEND_ITEMS = "DXRecyclerLayout#appendItems";
    public static final String MSG_METHOD_DELETE_ITEMS = "DXRecyclerLayout#deleteItems";
    public static final String MSG_METHOD_INSERT_ITEMS = "DXRecyclerLayout#insertItems";
    public static final String MSG_METHOD_INSERT_ITEMS_BY_OFFSET = "DXRecyclerLayout#insertItemsByOffset";
    public static final String MSG_METHOD_LOAD_MORE = "DXRecyclerLayout#loadMore";
    public static final String MSG_METHOD_MODIFY_CURRENT_ITEM_DATA = "DXRecyclerLayout#modifyCurrentItemData";
    public static final String MSG_METHOD_PULL_TO_REFRESH = "DXRecyclerLayout#refresh";
    public static final String MSG_METHOD_REFRESH_DATA = "DXRecyclerLayout#refreshData";
    public static final String MSG_METHOD_UPDATE_ALL = "DXRecyclerLayout#updateAll";
    public static final String MSG_METHOD_UPDATE_CURRENT = "DXRecyclerLayout#updateCurrent";
    public static final String MSG_METHOD_UPDATE_ITEMS = "DXRecyclerLayout#updateItems";
    public static final String MSG_METHOD_UPDATE_STYLE = "DXRecyclerLayout#updateStyle";
    private static final String OPERATOR_ACTION_MERGE = "merge";
    private static final String OPERATOR_ACTION_MODIFY = "modify";
    private static final String OPERATOR_ACTION_REMOVE = "remove";
    protected static final String PATH_ACTIONS = "actions";
    private static final String PATH_KEY = "key";
    private static final String PATH_OPERATOR = "operator";
    private static final String PATH_VALUE = "value";
    private static final String REFRESH_TYPE = "refreshType";
    private static final String REFRESH_TYPE_ALL = "all";
    private static final String REFRESH_TYPE_PART = "part";
    public static final String TAG = "DXRecyclerLayout";
    private int adapterType;
    protected int columnGap;
    zx dataSourceManager;
    protected int disableBounces;
    j00 dxRecyclerJsOperator;
    o00 dxRecyclerOperator;
    protected int endReachedThreshold;
    private JSONArray exportMethods;
    private boolean fixVerticalScrollConflict;
    private IDXRecyclerOnScrollToPos idxRecyclerOnScrollToPos;
    protected int isOpenLoadMore;
    protected int isOpenPullToRefresh;
    protected int leftGap;
    protected String loadMoreFailText;
    protected String loadMoreLoadingText;
    protected String loadMoreNoMoreDataText;
    private int loadMoreTextColor;
    private int loadMoreTextSize;
    private com.taobao.android.dinamicx.widget.recycler.expose.b mExposeHelper;
    private boolean mShouldScroll;
    private int mToPosition;
    private n00 onTouchListener;
    private int openPrefetch;
    private int preFetchBatchSize;
    private yx1 pullRefreshListener;
    protected int rightGap;
    private ScrollListener scrollListener;
    private Object videoControlConfig;
    protected int columnCount = 1;
    protected String refreshLoadingText = "加载中...";
    protected String refreshPullText = "下拉即可刷新...";
    protected String refreshReleaseText = "释放即可刷新...";
    private boolean enableTrackStayTime = true;
    private double exposureSpaceFactor = 0.5d;
    private long exposureTimeFactor = 300;
    private boolean enableLeftGapWhenSingleColumn = true;
    private int defaultLoadMoreStatus = 1;
    private boolean needItemAnimation = false;
    private int startReachedThreshold = -1;
    Map<String, Integer> cellUserId2PositionMap = new HashMap();

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface LoadMoreStatus {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class a implements IExposeStayCallback {
        final /* synthetic */ RecyclerView a;

        a(RecyclerView recyclerView) {
            this.a = recyclerView;
        }

        @Override // com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeStayCallback
        public void exposeStay(int i, long j) {
            List<Object> f;
            if (this.a == null || DXRecyclerLayout.this.mExposeHelper == null || (f = DXRecyclerLayout.this.mExposeHelper.f()) == null || i < 0 || i >= f.size()) {
                return;
            }
            Object obj = f.get(i);
            if (obj instanceof JSONObject) {
                DXRecyclerLayout.this.postEvent(new m00(i, (JSONObject) obj, j));
            } else if (DXRecyclerLayout.this.getDXRuntimeContext() != null && DXRecyclerLayout.this.getDXRuntimeContext().supportDataProxy() && (obj instanceof Object)) {
                DXRecyclerLayout.this.postEvent(new m00(i, obj, j));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class b implements IExposeFilterCallback {
        b() {
        }

        @Override // com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeFilterCallback
        public boolean filter(int i) {
            RecyclerView.Adapter adapter;
            return (DXRecyclerLayout.this.getRecyclerView() == null || (adapter = DXRecyclerLayout.this.getRecyclerView().getAdapter()) == null || adapter.getItemViewType(i) != -1) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class c implements IExposeDistinctCallback {
        c(DXRecyclerLayout dXRecyclerLayout) {
        }

        @Override // com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeDistinctCallback
        public String distinct(int i) {
            return i + "";
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class d implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXRecyclerLayout();
        }
    }

    public DXRecyclerLayout() {
        setOrientation(1);
    }

    private boolean appendItems(@NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        if (wt.O0()) {
            return this.dxRecyclerOperator.a(this, jSONObject, falcoSpan);
        }
        JSONArray jSONArray = null;
        try {
            jSONArray = jSONObject.getJSONArray("data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray == null || jSONArray.isEmpty()) {
            return false;
        }
        appendItemsWithData(jSONArray, this.originWidgetNodes, falcoSpan, jSONObject.getString(REFRESH_TYPE));
        return true;
    }

    private void appendItemsByRef(JSONArray jSONArray) {
        int i;
        if (wt.O0()) {
            this.dxRecyclerJsOperator.r(this, jSONArray);
        } else if (jSONArray == null || jSONArray.size() <= 0) {
        } else {
            Object obj = jSONArray.get(0);
            if (obj instanceof JSONArray) {
                List<Object> list = this.dataSource;
                if (list != null) {
                    int size = list.size();
                    this.dataSource.addAll((JSONArray) obj);
                    i = size;
                } else {
                    i = 0;
                }
                List<Object> list2 = this.dataSource;
                ArrayList<DXWidgetNode> generateWidgetNodeByData = generateWidgetNodeByData(list2, this.originWidgetNodes, i, list2.size(), null);
                if (generateWidgetNodeByData == null || generateWidgetNodeByData.isEmpty()) {
                    return;
                }
                getItemWidgetNodes().addAll(generateWidgetNodeByData);
                refresh();
            }
        }
    }

    private void appendItemsWithData(JSONArray jSONArray, List<DXWidgetNode> list, FalcoSpan falcoSpan, String str) {
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        int i = -1;
        int i2 = 0;
        for (int i3 = 0; i3 < jSONArray.size(); i3++) {
            Object obj = jSONArray.get(i3);
            if (!(obj instanceof JSONObject)) {
                nz.g(TAG, "no setData for append!!!");
            } else if (itemWidgetNodes != null) {
                List<Object> list2 = this.dataSource;
                if (list2 != null) {
                    if (i < 0) {
                        i = list2.size();
                    }
                    this.dataSource.add(obj);
                    i2++;
                }
                itemWidgetNodes.add(generateItemWithData((JSONObject) obj, list, i + i3, falcoSpan));
            }
        }
        if (i < 0 || i2 <= 0) {
            return;
        }
        if (wt.u0()) {
            refresh(REFRESH_TYPE_PART, i, i2, MSG_METHOD_APPEND_ITEMS, false);
        } else {
            refresh(REFRESH_TYPE_PART, i, i2, MSG_METHOD_APPEND_ITEMS);
        }
    }

    private void bindSpanCtx(DXWidgetNode dXWidgetNode) {
        if (!(dXWidgetNode instanceof DXTemplateWidgetNode) || getDXRuntimeContext().getOpenTracerSpan() == null) {
            return;
        }
        Map<String, String> i = zz.i(getDXRuntimeContext().getOpenTracerSpan());
        DXTemplateWidgetNode dXTemplateWidgetNode = (DXTemplateWidgetNode) dXWidgetNode;
        if (dXTemplateWidgetNode.getSpan() == null) {
            dXTemplateWidgetNode.setSpan(zz.e(i, "DX", TAG));
        }
    }

    private boolean deleteItems(@NonNull JSONObject jSONObject) {
        List<DXWidgetNode> itemWidgetNodes;
        if (wt.O0()) {
            return this.dxRecyclerOperator.b(this, jSONObject);
        }
        JSONArray jSONArray = null;
        try {
            jSONArray = jSONObject.getJSONArray("data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray == null || jSONArray.isEmpty() || (itemWidgetNodes = getItemWidgetNodes()) == null || itemWidgetNodes.isEmpty()) {
            return false;
        }
        return deleteItemsWithData(jSONArray, jSONObject.get("current"), jSONObject.getString(REFRESH_TYPE));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean deleteItemsWithData(com.alibaba.fastjson.JSONArray r8, java.lang.Object r9, java.lang.String r10) {
        /*
            r7 = this;
            r0 = 0
            r1 = 0
        L2:
            int r2 = r8.size()
            r3 = 1
            if (r1 >= r2) goto L7d
            java.lang.Object r2 = r8.get(r1)
            boolean r4 = r2 instanceof com.alibaba.fastjson.JSONObject
            if (r4 == 0) goto L7a
            r4 = -1
            r5 = r2
            com.alibaba.fastjson.JSONObject r5 = (com.alibaba.fastjson.JSONObject) r5     // Catch: java.lang.Exception -> L2a
            java.lang.String r6 = "isRelative"
            java.lang.Boolean r5 = r5.getBoolean(r6)     // Catch: java.lang.Exception -> L2a
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Exception -> L2a
            com.alibaba.fastjson.JSONObject r2 = (com.alibaba.fastjson.JSONObject) r2     // Catch: java.lang.Exception -> L28
            java.lang.String r6 = "offset"
            int r2 = r2.getIntValue(r6)     // Catch: java.lang.Exception -> L28
            goto L30
        L28:
            r2 = move-exception
            goto L2c
        L2a:
            r2 = move-exception
            r5 = 0
        L2c:
            r2.printStackTrace()
            r2 = -1
        L30:
            if (r2 == r4) goto L7a
            java.util.List r4 = r7.getItemWidgetNodes()
            if (r5 == 0) goto L53
            boolean r5 = r9 instanceof com.taobao.android.dinamicx.widget.DXWidgetNode
            if (r5 == 0) goto L53
            r5 = r9
            com.taobao.android.dinamicx.widget.DXWidgetNode r5 = (com.taobao.android.dinamicx.widget.DXWidgetNode) r5
            com.taobao.android.dinamicx.widget.DXTemplateWidgetNode r5 = r7.getParentTemplateWidgetNode(r5)
            if (r5 != 0) goto L4e
            r8 = 230003(0x38273, float:3.22303E-40)
            java.lang.String r9 = ""
            r7.trackError(r8, r9)
            return r0
        L4e:
            int r5 = r4.indexOf(r5)
            int r2 = r2 + r5
        L53:
            if (r2 < 0) goto L5e
            int r5 = r4.size()
            if (r2 >= r5) goto L5e
            r4.remove(r2)
        L5e:
            if (r2 < 0) goto L6d
            java.util.List<java.lang.Object> r4 = r7.dataSource
            int r4 = r4.size()
            if (r2 >= r4) goto L6d
            java.util.List<java.lang.Object> r4 = r7.dataSource
            r4.remove(r2)
        L6d:
            java.lang.String r4 = "part"
            boolean r5 = r4.equals(r10)
            if (r5 == 0) goto L7a
            java.lang.String r5 = "DXRecyclerLayout#deleteItems"
            r7.refresh(r4, r2, r3, r5)
        L7a:
            int r1 = r1 + 1
            goto L2
        L7d:
            boolean r8 = android.text.TextUtils.isEmpty(r10)
            if (r8 != 0) goto L8b
            java.lang.String r8 = "all"
            boolean r8 = r8.equals(r10)
            if (r8 == 0) goto L8e
        L8b:
            r7.refresh()
        L8e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.DXRecyclerLayout.deleteItemsWithData(com.alibaba.fastjson.JSONArray, java.lang.Object, java.lang.String):boolean");
    }

    private com.taobao.android.dinamicx.widget.recycler.expose.b getExposeHelper() {
        if (this.mExposeHelper == null) {
            WaterfallLayout waterfallLayout = this.waterfallLayout;
            if (waterfallLayout == null || waterfallLayout.e() == null || !(this.waterfallLayout.e() instanceof DXRecyclerView)) {
                return null;
            }
            com.taobao.android.dinamicx.widget.recycler.expose.b exposeHelper = ((DXRecyclerView) this.waterfallLayout.e()).getExposeHelper();
            this.mExposeHelper = exposeHelper;
            if (exposeHelper == null) {
                initExpose(this.waterfallLayout.e());
            }
            com.taobao.android.dinamicx.widget.recycler.expose.b bVar = this.mExposeHelper;
            if (bVar != null && bVar.f() == null) {
                this.mExposeHelper.i(this.dataSource);
            }
        }
        return this.mExposeHelper;
    }

    private DXTemplateWidgetNode getParentTemplateWidgetNode(DXWidgetNode dXWidgetNode) {
        return q00.b(dXWidgetNode);
    }

    private int getRealCount() {
        if (getDXRuntimeContext().getEngineContext().j()) {
            zx zxVar = this.dataSourceManager;
            if (zxVar != null) {
                return zxVar.getRealCount();
            }
            return 0;
        }
        return getItemWidgetNodes().size();
    }

    private int getRealIndex(boolean z, int i, int i2, Object obj) {
        if (z) {
            if (i > 0) {
                return i2 + i;
            }
            if (obj instanceof DXWidgetNode) {
                return i2 + getItemWidgetNodes().indexOf(getParentTemplateWidgetNode((DXWidgetNode) obj));
            }
            return -1;
        }
        return i2;
    }

    private int indexOfItem(DXWidgetNode dXWidgetNode) {
        if (getDXRuntimeContext().getEngineContext().j()) {
            zx zxVar = this.dataSourceManager;
            if (zxVar != null) {
                return zxVar.indexOfItem(dXWidgetNode);
            }
            return -1;
        }
        return getItemWidgetNodes().indexOf(dXWidgetNode);
    }

    private void initDataSourceManager() {
        DXDataSourceLruManager dXDataSourceLruManager = getDXRuntimeContext().getEngineContext().j() ? new DXDataSourceLruManager(getDXRuntimeContext().getEngineContext().g()) : null;
        int i = this.adapterType;
        if (i == 0) {
            this.dataSourceManager = new ay(dXDataSourceLruManager);
        } else if (i == 1) {
            this.dataSourceManager = new by(dXDataSourceLruManager);
        }
    }

    private void initExpose(final RecyclerView recyclerView) {
        if (getEventHandlersExprNode() != null) {
            if (getEventHandlersExprNode().get(6278152710403332930L) == null && getEventHandlersExprNode().get(9859236201376900L) == null) {
                return;
            }
            com.taobao.android.dinamicx.widget.recycler.expose.b a2 = new com.taobao.android.dinamicx.widget.recycler.expose.c(recyclerView, new IExposeCallback() { // from class: com.taobao.android.dinamicx.widget.DXRecyclerLayout.9
                @Override // com.taobao.android.dinamicx.widget.recycler.expose.listener.IExposeCallback
                public void expose(final int i) {
                    y00.m(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXRecyclerLayout.9.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i2;
                            AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                            if (recyclerView == null || DXRecyclerLayout.this.mExposeHelper == null) {
                                return;
                            }
                            List<Object> f = DXRecyclerLayout.this.mExposeHelper.f();
                            if (f != null && (i2 = i) >= 0 && i2 < f.size()) {
                                Object obj = f.get(i);
                                if (obj instanceof JSONObject) {
                                    DXRecyclerLayout.this.postEvent(new l00(i, (JSONObject) obj));
                                    return;
                                } else if (DXRecyclerLayout.this.getDXRuntimeContext() != null && DXRecyclerLayout.this.getDXRuntimeContext().supportDataProxy() && (obj instanceof Object)) {
                                    DXRecyclerLayout.this.postEvent(new l00(i, obj));
                                    return;
                                } else {
                                    return;
                                }
                            }
                            DXRecyclerLayout dXRecyclerLayout = DXRecyclerLayout.this;
                            StringBuilder sb = new StringBuilder();
                            sb.append("发送曝光条件异常 ds: ");
                            sb.append(f == null ? "null" : Integer.valueOf(f.size()));
                            sb.append(" pos ");
                            sb.append(i);
                            dXRecyclerLayout.trackError(com.taobao.android.dinamicx.e.DX_ERROR_CODE_RECYCLER_LAYOUT_230006, sb.toString());
                        }
                    });
                }
            }).b(new c(this)).d(new b()).l(this.exposureTimeFactor).k((float) this.exposureSpaceFactor).c(getEventHandlersExprNode().get(9859236201376900L) != null && this.enableTrackStayTime ? new a(recyclerView) : null).a();
            this.mExposeHelper = a2;
            if (recyclerView instanceof DXRecyclerView) {
                ((DXRecyclerView) recyclerView).setExposeHelper(a2);
            }
        }
    }

    private void initOnTouchListener() {
        if (getEventHandlersExprNode() == null) {
            return;
        }
        if (getEventHandlersExprNode().get(18903999933159L) == null && getEventHandlersExprNode().get(-6544685697300501093L) == null) {
            return;
        }
        WaterfallLayout waterfallLayout = this.waterfallLayout;
        if (waterfallLayout != null && (waterfallLayout.d() instanceof n00)) {
            n00 d2 = this.waterfallLayout.d();
            this.onTouchListener = d2;
            d2.b(this);
            return;
        }
        n00 n00Var = new n00(this);
        this.onTouchListener = n00Var;
        this.waterfallLayout.m(n00Var);
    }

    private void initScrollListener() {
        WaterfallLayout waterfallLayout = this.waterfallLayout;
        if (waterfallLayout != null && (waterfallLayout.c() instanceof ScrollListener)) {
            ScrollListener scrollListener = (ScrollListener) this.waterfallLayout.c();
            this.scrollListener = scrollListener;
            scrollListener.b();
            return;
        }
        getDXRuntimeContext().getEngineContext().b().c();
        ScrollListener scrollListener2 = new ScrollListener(this);
        this.scrollListener = scrollListener2;
        this.waterfallLayout.l(scrollListener2);
    }

    private void initVideoPlayControl(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return;
        }
        try {
            DXRuntimeContext dXRuntimeContext = getDXRuntimeContext();
            g20 n = dXRuntimeContext.getEngineContext().e().n();
            if (n != null && isEnableVideoControl() && n.b()) {
                String str = (TextUtils.isEmpty(dXRuntimeContext.getBizType()) ? "" : dXRuntimeContext.getBizType()) + JSMethod.NOT_SET + (TextUtils.isEmpty(this.userId) ? TAG : this.userId);
                n.makeVideoControl(recyclerView, (DXVideoControlConfig) this.videoControlConfig, str);
                n.start(recyclerView, str);
            }
        } catch (Exception e) {
            ry.b(e);
        }
    }

    private boolean insertItems(@NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        if (wt.O0()) {
            return this.dxRecyclerOperator.i(this, jSONObject, falcoSpan);
        }
        JSONArray jSONArray = null;
        try {
            jSONArray = jSONObject.getJSONArray("data");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray == null || jSONArray.isEmpty() || getItemWidgetNodes() == null) {
            return false;
        }
        return insertItemsWithData(jSONArray, jSONObject.get("current"), falcoSpan, (String) x41.b(REFRESH_TYPE, jSONObject, "all"));
    }

    private boolean insertItemsByOffset(@NonNull JSONObject jSONObject, FalcoSpan falcoSpan) {
        JSONArray e;
        if (wt.O0()) {
            return this.dxRecyclerOperator.j(this, jSONObject, falcoSpan);
        }
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        if (itemWidgetNodes == null || itemWidgetNodes.isEmpty() || (e = x41.e("data", jSONObject, null)) == null || e.isEmpty()) {
            return false;
        }
        return insertItemsWithDataByOffset(e, (DXWidgetNode) x41.b("current", jSONObject, null), x41.d("offset", jSONObject, -1), x41.c("isRelative", jSONObject, Boolean.FALSE).booleanValue(), falcoSpan);
    }

    private void insertItemsByRef(JSONArray jSONArray) {
        Object obj;
        if (wt.O0()) {
            this.dxRecyclerJsOperator.s(this, jSONArray);
        } else if ((jSONArray != null || jSONArray.size() > 0) && (obj = jSONArray.get(0)) != null) {
            List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
            int size = itemWidgetNodes.size();
            if (jSONArray.size() > 1) {
                try {
                    Integer integer = jSONArray.getInteger(1);
                    if (integer != null) {
                        if (integer.intValue() > itemWidgetNodes.size()) {
                            integer = Integer.valueOf(itemWidgetNodes.size());
                        } else if (integer.intValue() < 0) {
                            integer = 0;
                        }
                        size = integer.intValue();
                    }
                } catch (Exception unused) {
                }
            }
            if (jSONArray.size() > 2) {
                try {
                    jSONArray.getBooleanValue(2);
                } catch (Exception unused2) {
                }
            }
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                if (size < 0 || size > itemWidgetNodes.size()) {
                    return;
                }
                List<Object> list = this.dataSource;
                if (list != null && size >= 0 && size <= list.size()) {
                    this.dataSource.add(size, jSONObject);
                }
                itemWidgetNodes.add(size, generateItemWithData(jSONObject, this.originWidgetNodes, size, null));
                refresh();
            } else if (!(obj instanceof JSONArray) || size < 0 || size > itemWidgetNodes.size()) {
            } else {
                List<Object> list2 = this.dataSource;
                if (list2 != null && size >= 0 && size <= list2.size()) {
                    this.dataSource.addAll(size, (JSONArray) obj);
                }
                ArrayList<DXWidgetNode> generateWidgetNodeByData = generateWidgetNodeByData(this.dataSource, this.originWidgetNodes, size, size + ((JSONArray) obj).size(), null);
                if (generateWidgetNodeByData == null || generateWidgetNodeByData.isEmpty()) {
                    return;
                }
                itemWidgetNodes.addAll(size, generateWidgetNodeByData);
                refresh();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0049 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean insertItemsWithData(com.alibaba.fastjson.JSONArray r16, java.lang.Object r17, com.taobao.analysis.v3.FalcoSpan r18, java.lang.String r19) {
        /*
            r15 = this;
            r7 = r15
            r8 = r17
            r9 = r19
            java.util.List r10 = r15.getItemWidgetNodes()
            r11 = 0
            r12 = 0
        Lb:
            int r0 = r16.size()
            r1 = 1
            if (r12 >= r0) goto Lad
            r13 = r16
            java.lang.Object r0 = r13.get(r12)
            boolean r2 = r0 instanceof com.alibaba.fastjson.JSONObject
            if (r2 == 0) goto La7
            r2 = 0
            r3 = -1
            r4 = r0
            com.alibaba.fastjson.JSONObject r4 = (com.alibaba.fastjson.JSONObject) r4     // Catch: java.lang.Exception -> L41
            java.lang.String r5 = "isRelative"
            java.lang.Boolean r4 = r4.getBoolean(r5)     // Catch: java.lang.Exception -> L41
            boolean r4 = r4.booleanValue()     // Catch: java.lang.Exception -> L41
            r5 = r0
            com.alibaba.fastjson.JSONObject r5 = (com.alibaba.fastjson.JSONObject) r5     // Catch: java.lang.Exception -> L3f
            java.lang.String r6 = "offset"
            int r5 = r5.getIntValue(r6)     // Catch: java.lang.Exception -> L3f
            com.alibaba.fastjson.JSONObject r0 = (com.alibaba.fastjson.JSONObject) r0     // Catch: java.lang.Exception -> L3d
            java.lang.String r6 = "data"
            com.alibaba.fastjson.JSONObject r2 = r0.getJSONObject(r6)     // Catch: java.lang.Exception -> L3d
            goto L47
        L3d:
            r0 = move-exception
            goto L44
        L3f:
            r0 = move-exception
            goto L43
        L41:
            r0 = move-exception
            r4 = 0
        L43:
            r5 = -1
        L44:
            r0.printStackTrace()
        L47:
            if (r2 != 0) goto L4a
            return r11
        L4a:
            if (r5 == r3) goto La7
            if (r4 == 0) goto L63
            boolean r0 = r8 instanceof com.taobao.android.dinamicx.widget.DXWidgetNode
            if (r0 == 0) goto L63
            r0 = r8
            com.taobao.android.dinamicx.widget.DXWidgetNode r0 = (com.taobao.android.dinamicx.widget.DXWidgetNode) r0
            com.taobao.android.dinamicx.widget.DXTemplateWidgetNode r0 = r15.getParentTemplateWidgetNode(r0)
            if (r0 != 0) goto L5c
            return r11
        L5c:
            int r0 = r10.indexOf(r0)
            int r0 = r0 + r5
            r3 = r0
            goto L64
        L63:
            r3 = r5
        L64:
            java.util.List<java.lang.Object> r0 = r7.dataSource
            if (r0 == 0) goto L75
            if (r3 < 0) goto L75
            int r0 = r0.size()
            if (r3 > r0) goto L75
            java.util.List<java.lang.Object> r0 = r7.dataSource
            r0.add(r3, r2)
        L75:
            java.util.ArrayList<com.taobao.android.dinamicx.widget.DXWidgetNode> r0 = r7.originWidgetNodes
            r14 = r18
            com.taobao.android.dinamicx.widget.DXWidgetNode r0 = r15.generateItemWithData(r2, r0, r3, r14)
            if (r3 < 0) goto L88
            int r2 = r10.size()
            if (r3 > r2) goto L88
            r10.add(r3, r0)
        L88:
            java.lang.String r0 = "part"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto La9
            boolean r0 = tb.wt.u0()
            if (r0 == 0) goto La1
            r4 = 1
            r6 = 0
            java.lang.String r5 = "DXRecyclerLayout#insertItems"
            r1 = r15
            r2 = r19
            r1.refresh(r2, r3, r4, r5, r6)
            goto La9
        La1:
            java.lang.String r0 = "DXRecyclerLayout#insertItems"
            r15.refresh(r9, r3, r1, r0)
            goto La9
        La7:
            r14 = r18
        La9:
            int r12 = r12 + 1
            goto Lb
        Lad:
            java.lang.String r0 = "all"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto Lb8
            r15.refresh()
        Lb8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.DXRecyclerLayout.insertItemsWithData(com.alibaba.fastjson.JSONArray, java.lang.Object, com.taobao.analysis.v3.FalcoSpan, java.lang.String):boolean");
    }

    private boolean insertItemsWithDataByOffset(JSONArray jSONArray, DXWidgetNode dXWidgetNode, int i, boolean z, FalcoSpan falcoSpan) {
        if (jSONArray == null || dXWidgetNode == null) {
            return false;
        }
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        for (int i2 = 0; i2 < jSONArray.size(); i2++) {
            JSONObject jSONObject = (JSONObject) x41.a(i2, jSONArray, null);
            if (jSONObject != null) {
                int i3 = i + i2;
                if (z) {
                    DXTemplateWidgetNode parentTemplateWidgetNode = getParentTemplateWidgetNode(dXWidgetNode);
                    if (parentTemplateWidgetNode == null) {
                        return false;
                    }
                    i3 = itemWidgetNodes.indexOf(parentTemplateWidgetNode) + i;
                }
                List<Object> list = this.dataSource;
                if (list != null && i3 >= 0 && i3 < list.size()) {
                    this.dataSource.add(i3, jSONObject);
                }
                DXWidgetNode generateItemWithData = generateItemWithData(jSONObject, this.originWidgetNodes, i3, falcoSpan);
                if (i3 >= 0 && i3 < itemWidgetNodes.size()) {
                    itemWidgetNodes.add(i3, generateItemWithData);
                }
            }
        }
        refresh();
        return true;
    }

    private boolean isOpenPrefetch() {
        return this.openPrefetch == 1 && wt.z0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyData(RecyclerView.Adapter adapter, String str, int i, int i2, String str2) {
        if (adapter == null) {
            return;
        }
        try {
            if (!TextUtils.isEmpty(str) && !"all".equals(str) && i >= 0 && !TextUtils.isEmpty(str2)) {
                if (!str.equals(REFRESH_TYPE_PART)) {
                    adapter.notifyDataSetChanged();
                    return;
                }
                char c2 = 65535;
                switch (str2.hashCode()) {
                    case -1472811200:
                        if (str2.equals(MSG_METHOD_APPEND_ITEMS)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -708482225:
                        if (str2.equals(MSG_METHOD_DELETE_ITEMS)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -232077206:
                        if (str2.equals(MSG_METHOD_UPDATE_CURRENT)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 310191873:
                        if (str2.equals(MSG_METHOD_INSERT_ITEMS)) {
                            c2 = 3;
                            break;
                        }
                        break;
                }
                if (c2 == 0) {
                    ((RecyclerAdapter) adapter).c();
                    adapter.notifyItemRangeRemoved(i, i2);
                    return;
                } else if (c2 == 1) {
                    adapter.notifyItemRangeChanged(i, i2);
                    return;
                } else if (c2 == 2) {
                    adapter.notifyItemRangeInserted(i, i2);
                    return;
                } else if (c2 != 3) {
                    adapter.notifyDataSetChanged();
                    return;
                } else {
                    adapter.notifyItemInserted(i);
                    return;
                }
            }
            ((RecyclerAdapter) adapter).c();
            adapter.notifyDataSetChanged();
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    private boolean onRefresh(@NonNull JSONObject jSONObject) {
        WaterfallLayout waterfallLayout;
        String string = jSONObject.getString("status");
        string.hashCode();
        if (string.equals(LOAD_MORE_STOPED)) {
            WaterfallLayout waterfallLayout2 = this.waterfallLayout;
            if (waterfallLayout2 != null) {
                waterfallLayout2.q();
                return true;
            }
            return false;
        } else if (string.equals("triggered") && (waterfallLayout = this.waterfallLayout) != null) {
            waterfallLayout.p();
            return true;
        } else {
            return false;
        }
    }

    private void parseFieldNamePathQueue(String str, Queue<String> queue) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, DELIMITER, false);
        while (stringTokenizer.hasMoreTokens()) {
            queue.offer(stringTokenizer.nextToken());
        }
    }

    private void postOnLoadMoreEvent() {
        postEvent(new hy(DXAbsContainerBaseLayout.DXRECYCLERLAYOUT_ONENDREACHED));
    }

    private void reInitAdapter(RecyclerAdapter recyclerAdapter) {
        recyclerAdapter.setHasStableIds(true);
        setDataSource(recyclerAdapter, getItemWidgetNodes());
        recyclerAdapter.b();
        recyclerAdapter.z(this);
        recyclerAdapter.t(this.loadMoreFailText);
        recyclerAdapter.u(this.loadMoreLoadingText);
        recyclerAdapter.v(this.loadMoreNoMoreDataText);
        recyclerAdapter.w(this.loadMoreTextColor);
        recyclerAdapter.x(this.loadMoreTextSize);
        int i = this.defaultLoadMoreStatus;
        if (i != 1) {
            recyclerAdapter.A(i);
        }
        this.waterfallLayout.i(recyclerAdapter);
    }

    private void rebuildMapping(boolean z) {
        this.cellUserId2PositionMap.clear();
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        if (itemWidgetNodes == null || itemWidgetNodes.size() <= 0) {
            return;
        }
        int size = itemWidgetNodes.size();
        for (int i = 0; i < size; i++) {
            DXWidgetNode dXWidgetNode = itemWidgetNodes.get(i);
            if (dXWidgetNode instanceof DXTemplateWidgetNode) {
                if (!TextUtils.isEmpty(dXWidgetNode.getUserId())) {
                    this.cellUserId2PositionMap.put(dXWidgetNode.getUserId(), Integer.valueOf(i));
                }
                if (z) {
                    ((DXTemplateWidgetNode) dXWidgetNode).dataIndex = i;
                }
            }
        }
    }

    private void refresh() {
        refresh(false, "all", -1, 0, null, true);
    }

    private boolean refreshData(JSONObject jSONObject) {
        List<DXWidgetNode> itemWidgetNodes;
        String str;
        FalcoAbilitySpan abilitySpanFromParams = getAbilitySpanFromParams(jSONObject);
        JSONArray jSONArray = null;
        try {
            jSONArray = jSONObject.getJSONArray("data");
            if (jSONArray != null && jSONArray.size() > 0) {
                if (getExposeHelper() != null) {
                    this.mExposeHelper.i(jSONArray);
                }
                triggerStayTime();
                clearExposureCache();
                zz.q(abilitySpanFromParams, MSG_METHOD_REFRESH_DATA, "dataSize:" + jSONArray.size());
            } else {
                zz.q(abilitySpanFromParams, MSG_METHOD_REFRESH_DATA, " dataSize null or 0");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray == null) {
            jSONArray = new JSONArray();
        }
        resetLoadMoreStatus();
        reloadRecycler(jSONArray, abilitySpanFromParams);
        if (getItemWidgetNodes() == null) {
            str = "null";
        } else {
            str = " itemSize " + itemWidgetNodes.size() + "";
        }
        zz.q(abilitySpanFromParams, MSG_METHOD_REFRESH_DATA, str);
        y00.n(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXRecyclerLayout.1
            @Override // java.lang.Runnable
            public void run() {
                DXRecyclerLayout.this.resumeStayTime();
            }
        }, 300L);
        return true;
    }

    private void refreshWithRange(final boolean z) {
        final RecyclerView.Adapter adapter;
        try {
            WaterfallLayout waterfallLayout = this.waterfallLayout;
            if (waterfallLayout != null) {
                RecyclerView e = waterfallLayout.e();
                if (e != null && (adapter = e.getAdapter()) != null && (adapter instanceof RecyclerAdapter)) {
                    if (e.getScrollState() != 0 || e.isComputingLayout()) {
                        y00.m(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXRecyclerLayout.4
                            @Override // java.lang.Runnable
                            public void run() {
                                if (z) {
                                    DXRecyclerLayout dXRecyclerLayout = DXRecyclerLayout.this;
                                    dXRecyclerLayout.setDataSource((RecyclerAdapter) adapter, dXRecyclerLayout.getItemWidgetNodes());
                                }
                            }
                        });
                    } else if (z) {
                        setDataSource((RecyclerAdapter) adapter, getItemWidgetNodes());
                    }
                }
            }
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    private void reloadRecycler(JSONArray jSONArray, FalcoAbilitySpan falcoAbilitySpan) {
        initDataSourceManager();
        initOperator();
        this.dataSource = jSONArray;
        setItemWidgetNodes(generateWidgetNodeByData(jSONArray, this.originWidgetNodes, 0, jSONArray.size(), falcoAbilitySpan));
        if (wt.u0()) {
            refresh(true, "all", -1, 0, null, false);
        } else {
            refresh(true, "all", -1, 0, null, true);
        }
    }

    private boolean removeItemByIndex(int i) {
        List<Object> list = this.dataSource;
        if (list != null && i >= 0 && i < list.size()) {
            this.dataSource.remove(i);
        }
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        if (itemWidgetNodes == null || i < 0 || i >= itemWidgetNodes.size()) {
            return false;
        }
        itemWidgetNodes.remove(i);
        return true;
    }

    private void removeItemsByRef(JSONArray jSONArray) {
        if (wt.O0()) {
            this.dxRecyclerJsOperator.u(this, jSONArray);
        } else if (jSONArray != null) {
            boolean z = true;
            if (jSONArray.size() < 1) {
                return;
            }
            boolean z2 = false;
            Object obj = jSONArray.get(0);
            if (obj == null) {
                return;
            }
            if (obj instanceof JSONArray) {
                Iterator<Object> it = ((JSONArray) obj).iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next != null && (next instanceof Integer) && removeItemByIndex(((Integer) next).intValue())) {
                        z2 = true;
                    }
                }
                z = z2;
            } else if (!(obj instanceof Integer) || !removeItemByIndex(((Integer) obj).intValue())) {
                z = false;
            }
            if (z) {
                refresh();
            }
        }
    }

    private void resetLoadMoreStatus() {
        updateLoadMoreStatus(4);
    }

    private void resetOperatorLayout(DXRecyclerLayout dXRecyclerLayout) {
        if (this.dxRecyclerJsOperator == null) {
            this.dxRecyclerJsOperator = new j00();
        }
        if (this.dxRecyclerOperator == null && this.adapterType == 0) {
            this.dxRecyclerOperator = new p00();
        }
    }

    private void scrollTo(JSONArray jSONArray) {
        WaterfallLayout waterfallLayout = this.waterfallLayout;
        if (waterfallLayout == null || waterfallLayout.e() == null || jSONArray == null || jSONArray.size() <= 0 || !(jSONArray.get(0) instanceof Integer)) {
            return;
        }
        int intValue = ((Integer) jSONArray.get(0)).intValue();
        boolean z = true;
        if (jSONArray.size() > 1 && (jSONArray.get(1) instanceof Boolean)) {
            z = jSONArray.getBooleanValue(1);
        }
        if (z) {
            smoothMoveToPosition(this.waterfallLayout.e(), intValue);
            return;
        }
        this.waterfallLayout.e().scrollToPosition(intValue);
        if (this.waterfallLayout.e().getLayoutManager() instanceof StaggeredGridLayoutManager) {
            ((StaggeredGridLayoutManager) this.waterfallLayout.e().getLayoutManager()).scrollToPositionWithOffset(intValue, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDataSource(RecyclerAdapter recyclerAdapter, List<DXWidgetNode> list) {
        if (getDXRuntimeContext().getEngineContext().j()) {
            recyclerAdapter.r(this.dataSourceManager);
        } else {
            recyclerAdapter.q(list);
        }
    }

    private void setItem(int i, DXWidgetNode dXWidgetNode) {
        if (getDXRuntimeContext().getEngineContext().j()) {
            zx zxVar = this.dataSourceManager;
            if (zxVar != null) {
                zxVar.setItem(i, dXWidgetNode);
                return;
            }
            return;
        }
        getItemWidgetNodes().set(i, dXWidgetNode);
    }

    private void smoothMoveToPosition(RecyclerView recyclerView, int i) {
        if (recyclerView == null) {
            return;
        }
        int childLayoutPosition = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(0));
        int childLayoutPosition2 = recyclerView.getChildLayoutPosition(recyclerView.getChildAt(recyclerView.getChildCount() - 1));
        if (i < childLayoutPosition) {
            recyclerView.smoothScrollToPosition(i);
        } else if (i <= childLayoutPosition2) {
            int i2 = i - childLayoutPosition;
            if (i2 < 0 || i2 >= recyclerView.getChildCount()) {
                return;
            }
            recyclerView.smoothScrollBy(0, recyclerView.getChildAt(i2).getTop());
        } else {
            recyclerView.smoothScrollToPosition(i);
            this.mToPosition = i;
            this.mShouldScroll = true;
        }
    }

    private boolean updateAll(JSONObject jSONObject, FalcoSpan falcoSpan) {
        List<DXWidgetNode> itemWidgetNodes;
        if (wt.O0()) {
            return this.dxRecyclerOperator.n(this, jSONObject, falcoSpan);
        }
        JSONArray jSONArray = null;
        try {
            jSONArray = jSONObject.getJSONArray(PATH_ACTIONS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (jSONArray != null && !jSONArray.isEmpty() && (itemWidgetNodes = getItemWidgetNodes()) != null && !itemWidgetNodes.isEmpty()) {
            boolean z = false;
            for (int i = 0; i < this.dataSource.size(); i++) {
                if (updateWithActions(jSONArray, i, falcoSpan)) {
                    z = true;
                }
            }
            if (z) {
                refresh();
                return true;
            }
        }
        return false;
    }

    private boolean updateCurrent(JSONObject jSONObject, boolean z, FalcoSpan falcoSpan) {
        DXTemplateWidgetNode parentTemplateWidgetNode;
        if (wt.O0()) {
            return this.dxRecyclerOperator.o(this, jSONObject, false, falcoSpan);
        }
        Object obj = jSONObject.get("current");
        if (obj == null) {
            return false;
        }
        JSONArray jSONArray = null;
        try {
            jSONArray = jSONObject.getJSONArray(PATH_ACTIONS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(ITEM_DATA);
        if (jSONArray != null && !jSONArray.isEmpty()) {
            if (!(obj instanceof DXWidgetNode) || (parentTemplateWidgetNode = getParentTemplateWidgetNode((DXWidgetNode) obj)) == null) {
                return false;
            }
            int indexOf = getItemWidgetNodes().indexOf(parentTemplateWidgetNode);
            boolean updateWithActions = updateWithActions(jSONArray, indexOf, z, falcoSpan);
            if (z) {
                return updateWithActions;
            }
            if (updateWithActions) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("params");
                if (jSONObject3 != null ? jSONObject3.getBooleanValue("refreshPart") : false) {
                    if (wt.u0()) {
                        refresh(REFRESH_TYPE_PART, indexOf, 1, MSG_METHOD_UPDATE_CURRENT, false);
                    } else {
                        refresh(REFRESH_TYPE_PART, indexOf, 1, MSG_METHOD_UPDATE_CURRENT);
                    }
                } else {
                    refresh();
                }
                return true;
            }
        } else if (jSONObject2 != null && (obj instanceof DXWidgetNode)) {
            return updateCurrent((DXWidgetNode) obj, jSONObject2);
        }
        return false;
    }

    private void updateItemWithData(JSONObject jSONObject, int i) {
        updateItemWithData(jSONObject, i, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean updateItems(com.alibaba.fastjson.JSONObject r13) {
        /*
            r12 = this;
            boolean r0 = tb.wt.O0()
            if (r0 == 0) goto Ld
            tb.o00 r0 = r12.dxRecyclerOperator
            boolean r13 = r0.q(r12, r13)
            return r13
        Ld:
            java.lang.String r0 = "current"
            java.lang.Object r0 = r13.get(r0)
            r1 = 0
            java.lang.String r2 = "data"
            com.alibaba.fastjson.JSONArray r13 = r13.getJSONArray(r2)     // Catch: java.lang.Exception -> L1b
            goto L20
        L1b:
            r13 = move-exception
            r13.printStackTrace()
            r13 = r1
        L20:
            r2 = 0
            if (r13 == 0) goto Lb1
            boolean r3 = r13.isEmpty()
            if (r3 == 0) goto L2b
            goto Lb1
        L2b:
            r3 = -1
            r4 = 0
            r5 = 0
        L2e:
            int r6 = r13.size()
            r7 = 1
            if (r4 >= r6) goto Lab
            java.lang.Object r6 = r13.get(r4)
            boolean r8 = r6 instanceof com.alibaba.fastjson.JSONObject
            if (r8 == 0) goto La7
            r8 = r6
            com.alibaba.fastjson.JSONObject r8 = (com.alibaba.fastjson.JSONObject) r8     // Catch: java.lang.Exception -> L6c
            java.lang.String r9 = "offset"
            java.lang.Integer r8 = r8.getInteger(r9)     // Catch: java.lang.Exception -> L6c
            r9 = r6
            com.alibaba.fastjson.JSONObject r9 = (com.alibaba.fastjson.JSONObject) r9     // Catch: java.lang.Exception -> L69
            java.lang.String r10 = "actions"
            com.alibaba.fastjson.JSONArray r9 = r9.getJSONArray(r10)     // Catch: java.lang.Exception -> L69
            r10 = r6
            com.alibaba.fastjson.JSONObject r10 = (com.alibaba.fastjson.JSONObject) r10     // Catch: java.lang.Exception -> L67
            java.lang.String r11 = "isRelative"
            java.lang.Boolean r10 = r10.getBoolean(r11)     // Catch: java.lang.Exception -> L67
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Exception -> L67
            com.alibaba.fastjson.JSONObject r6 = (com.alibaba.fastjson.JSONObject) r6     // Catch: java.lang.Exception -> L65
            java.lang.String r11 = "item_data"
            com.alibaba.fastjson.JSONObject r6 = r6.getJSONObject(r11)     // Catch: java.lang.Exception -> L65
            goto L74
        L65:
            r6 = move-exception
            goto L70
        L67:
            r6 = move-exception
            goto L6f
        L69:
            r6 = move-exception
            r9 = r1
            goto L6f
        L6c:
            r6 = move-exception
            r8 = r1
            r9 = r8
        L6f:
            r10 = 0
        L70:
            r6.printStackTrace()
            r6 = r1
        L74:
            if (r6 != 0) goto L90
            if (r8 == 0) goto La7
            if (r9 == 0) goto La7
            boolean r6 = r9.isEmpty()
            if (r6 == 0) goto L81
            goto La7
        L81:
            int r6 = r8.intValue()
            int r6 = r12.getRealIndex(r10, r3, r6, r0)
            boolean r6 = r12.updateWithActions(r9, r6, r1)
            if (r6 == 0) goto La7
            goto La6
        L90:
            if (r8 == 0) goto La7
            boolean r9 = r6.isEmpty()
            if (r9 == 0) goto L99
            goto La7
        L99:
            int r8 = r8.intValue()
            int r8 = r12.getRealIndex(r10, r3, r8, r0)
            r12.updateItemWithData(r6, r8)
            if (r8 < 0) goto La7
        La6:
            r5 = 1
        La7:
            int r4 = r4 + 1
            goto L2e
        Lab:
            if (r5 == 0) goto Lb1
            r12.refresh()
            return r7
        Lb1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.DXRecyclerLayout.updateItems(com.alibaba.fastjson.JSONObject):boolean");
    }

    private void updateItemsByRef(JSONArray jSONArray) {
        if (wt.O0()) {
            this.dxRecyclerJsOperator.v(this, jSONArray);
        } else if (jSONArray != null && jSONArray.size() > 1) {
            Object obj = jSONArray.get(0);
            if (obj == null) {
                return;
            }
            if (obj instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) obj;
                int i = -1;
                try {
                    Integer integer = jSONArray.getInteger(1);
                    if (integer != null) {
                        i = integer.intValue();
                    }
                } catch (Exception unused) {
                }
                updateItemWithData(jSONObject, i);
            } else if (obj instanceof JSONArray) {
                Object obj2 = jSONArray.get(2);
                if (obj2 instanceof JSONArray) {
                    for (int i2 = 0; i2 < ((JSONArray) obj2).size(); i2++) {
                        try {
                            updateItemWithData(((JSONArray) obj).getJSONObject(i2), ((JSONArray) obj2).getInteger(i2).intValue());
                        } catch (Exception unused2) {
                        }
                    }
                }
            }
            refresh();
        }
    }

    private boolean updateStyle(JSONObject jSONObject) {
        int d2 = x41.d(Constants.Name.LEFT_GAP, jSONObject, getLeftGap());
        int d3 = x41.d(Constants.Name.RIGHT_GAP, jSONObject, getRightGap());
        int d4 = x41.d(Constants.Name.COLUMN_GAP, jSONObject, getColumnGap());
        if (d2 == getLeftGap() && d3 == getRightGap() && d4 == getColumnGap()) {
            return false;
        }
        setNeedRender(getDXRuntimeContext().getContext());
        return true;
    }

    private boolean updateWithActions(JSONArray jSONArray, int i, FalcoSpan falcoSpan) {
        return updateWithActions(jSONArray, i, false, falcoSpan);
    }

    public void addVisibleStayTag() {
        if (getExposeHelper() != null) {
            getExposeHelper().a();
        }
        try {
            DXRecyclerLayout currentChildRecyclerLayout = getCurrentChildRecyclerLayout();
            if (currentChildRecyclerLayout == null) {
                return;
            }
            currentChildRecyclerLayout.addVisibleStayTag();
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void bindRuntimeContext(DXRuntimeContext dXRuntimeContext, boolean z) {
        super.bindRuntimeContext(dXRuntimeContext, z);
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXRecyclerLayout();
    }

    public void clearExposureCache() {
        if (getExposeHelper() != null) {
            getExposeHelper().g();
        }
        try {
            DXRecyclerLayout currentChildRecyclerLayout = getCurrentChildRecyclerLayout();
            if (currentChildRecyclerLayout == null) {
                return;
            }
            currentChildRecyclerLayout.clearExposureCache();
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public JSONArray exportMethods() {
        if (this.exportMethods == null) {
            this.exportMethods = new JSONArray() { // from class: com.taobao.android.dinamicx.widget.DXRecyclerLayout.5
                {
                    add("insert");
                    add(DXRecyclerLayout.OPERATOR_ACTION_REMOVE);
                    add("append");
                    add("update");
                    add("reload");
                    add("stopLoading");
                    add("finishedLoading");
                    add("beginUpdates");
                    add("endUpdates");
                    add("scrollTo");
                }
            };
            this.exportMethods.addAll(super.exportMethods());
        }
        return this.exportMethods;
    }

    public DXWidgetNode generateItemWithData(@NonNull Object obj, List<DXWidgetNode> list, int i, FalcoSpan falcoSpan) {
        DXTemplateWidgetNode dXTemplateWidgetNode = null;
        if (wt.O0()) {
            zx zxVar = this.dataSourceManager;
            if (zxVar != null) {
                return zxVar.b(this, obj, this.dataSource, list, i, falcoSpan);
            }
            return null;
        }
        for (int i2 = 0; i2 < list.size() && (dXTemplateWidgetNode = deepCopyChildForTemplate(list.get(i2), obj, i, falcoSpan)) == null; i2++) {
        }
        if (dXTemplateWidgetNode == null) {
            h00 h00Var = new h00();
            h00Var.setDXRuntimeContext(getDXRuntimeContext().cloneWithWidgetNode(this));
            h00Var.setVisibility(2);
            return h00Var;
        }
        return dXTemplateWidgetNode;
    }

    List<DXWidgetNode> generateSectionItemWithData(@NonNull JSONObject jSONObject, List<DXWidgetNode> list, int i, FalcoSpan falcoSpan) {
        zx zxVar = this.dataSourceManager;
        if (zxVar != null) {
            return zxVar.c(this, jSONObject, this.dataSource, list, 0, i, falcoSpan);
        }
        return null;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout
    public ArrayList<DXWidgetNode> generateWidgetNodeByData(List<Object> list, List<DXWidgetNode> list2, int i, int i2, FalcoSpan falcoSpan) {
        if (wt.O0()) {
            zx zxVar = this.dataSourceManager;
            if (zxVar != null) {
                return zxVar.d(this, this.dataSource, list2, i, i2, falcoSpan);
            }
            return null;
        }
        return super.generateWidgetNodeByData(list, list2, i, i2, falcoSpan);
    }

    FalcoAbilitySpan getAbilitySpanFromParams(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Object obj = jSONObject.get(ABILITY_SPAN);
        if (obj instanceof FalcoAbilitySpan) {
            return (FalcoAbilitySpan) obj;
        }
        return null;
    }

    public int getCellIndexByTemplateUserId(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (this.cellUserId2PositionMap.containsKey(str)) {
            return this.cellUserId2PositionMap.get(str).intValue();
        }
        return -2;
    }

    public Map<String, Integer> getCellUserId2PositionMap() {
        return this.cellUserId2PositionMap;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    public int getColumnGap() {
        return this.columnGap;
    }

    public DXRecyclerLayout getCurrentChildRecyclerLayout() {
        DXRecyclerLayout dXRecyclerLayout;
        DXRecyclerView dXRecyclerView = (DXRecyclerView) getDXRuntimeContext().getRootView().getDxNestedScrollerView().getmChildList();
        if (dXRecyclerView == null || (dXRecyclerLayout = (DXRecyclerLayout) dXRecyclerView.getTag(DXWidgetNode.TAG_WIDGET_NODE)) == this) {
            return null;
        }
        return dXRecyclerLayout;
    }

    public int getDataIndex(DXWidgetNode dXWidgetNode) {
        DXTemplateWidgetNode parentTemplateWidgetNode = getParentTemplateWidgetNode(dXWidgetNode);
        if (parentTemplateWidgetNode == null || parentTemplateWidgetNode.getDXRuntimeContext() == null) {
            return -1;
        }
        return parentTemplateWidgetNode.dataIndex;
    }

    public IDXDataSourceManager getDataSourceManager() {
        return this.dataSourceManager;
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == 4480460401770252962L || j == DXRECYCLERLAYOUT_ENABLETRACKSTAYTIME) {
            return 1;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public String getDefaultValueForStringAttr(long j) {
        return super.getDefaultValueForStringAttr(j);
    }

    public int getEndReachedThreshold() {
        return this.endReachedThreshold;
    }

    public IDXRecyclerOnScrollToPos getIdxRecyclerOnScrollToPos() {
        return this.idxRecyclerOnScrollToPos;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout
    public List<DXWidgetNode> getItemWidgetNodes() {
        if (wt.O0()) {
            zx zxVar = this.dataSourceManager;
            if (zxVar != null) {
                return zxVar.f();
            }
            return null;
        }
        return super.getItemWidgetNodes();
    }

    public int getLeftGap() {
        return this.leftGap;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getMarginLeft() {
        return this.marginLeft;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getMarginRight() {
        return this.marginRight;
    }

    public ArrayList<DXWidgetNode> getOriginWidgetNodes() {
        return this.originWidgetNodes;
    }

    public RecyclerView getRecyclerView() {
        WaterfallLayout waterfallLayout = this.waterfallLayout;
        if (waterfallLayout != null) {
            return waterfallLayout.e();
        }
        return null;
    }

    public int getRightGap() {
        return this.rightGap;
    }

    public ScrollListener getScrollListener() {
        return this.scrollListener;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout
    public int getScrollPosition() {
        return this.scrollPosition;
    }

    public int getStartReachedThreshold() {
        return this.startReachedThreshold;
    }

    public WaterfallLayout getWaterfallLayout() {
        return this.waterfallLayout;
    }

    public void initOperator() {
        if (this.adapterType == 0) {
            this.dxRecyclerOperator = new p00();
        }
        this.dxRecyclerJsOperator = new j00();
    }

    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public JSONObject invokeRefMethod(String str, JSONArray jSONArray) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1411068134:
                if (str.equals("append")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1183792455:
                if (str.equals("insert")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1067535254:
                if (str.equals("finishedLoading")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1042636831:
                if (str.equals("beginUpdates")) {
                    c2 = 3;
                    break;
                }
                break;
            case -948122918:
                if (str.equals("stopLoading")) {
                    c2 = 4;
                    break;
                }
                break;
            case -934641255:
                if (str.equals("reload")) {
                    c2 = 5;
                    break;
                }
                break;
            case -934610812:
                if (str.equals(OPERATOR_ACTION_REMOVE)) {
                    c2 = 6;
                    break;
                }
                break;
            case -838846263:
                if (str.equals("update")) {
                    c2 = 7;
                    break;
                }
                break;
            case -402165208:
                if (str.equals("scrollTo")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -6925457:
                if (str.equals("endUpdates")) {
                    c2 = '\t';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                if (wt.O0()) {
                    this.dxRecyclerJsOperator.r(this, jSONArray);
                    break;
                } else {
                    appendItemsByRef(jSONArray);
                    break;
                }
            case 1:
                if (wt.O0()) {
                    this.dxRecyclerJsOperator.s(this, jSONArray);
                    break;
                } else {
                    insertItemsByRef(jSONArray);
                    break;
                }
            case 2:
                updateLoadMoreStatus(5);
                break;
            case 3:
            case '\t':
                break;
            case 4:
                updateLoadMoreStatus(4);
                WaterfallLayout waterfallLayout = this.waterfallLayout;
                if (waterfallLayout != null) {
                    waterfallLayout.q();
                    break;
                }
                break;
            case 5:
                if (jSONArray != null && jSONArray.size() > 0) {
                    Object obj = jSONArray.get(0);
                    if (obj == null) {
                        reloadRecycler(null, null);
                        break;
                    } else if (obj instanceof JSONArray) {
                        reloadRecycler((JSONArray) obj, null);
                        break;
                    }
                }
                break;
            case 6:
                if (wt.O0()) {
                    this.dxRecyclerJsOperator.u(this, jSONArray);
                    break;
                } else {
                    removeItemsByRef(jSONArray);
                    break;
                }
            case 7:
                if (wt.O0()) {
                    this.dxRecyclerJsOperator.v(this, jSONArray);
                    break;
                } else {
                    updateItemsByRef(jSONArray);
                    break;
                }
            case '\b':
                scrollTo(jSONArray);
                break;
            default:
                return super.invokeRefMethod(str, jSONArray);
        }
        return null;
    }

    public boolean isEnableLeftGapWhenSingleColumn() {
        return this.enableLeftGapWhenSingleColumn;
    }

    public boolean isEnableVideoControl() {
        return this.videoControlConfig instanceof DXVideoControlConfig;
    }

    public boolean isItemsNull() {
        if (!getDXRuntimeContext().getEngineContext().j()) {
            return getItemWidgetNodes() == null;
        }
        zx zxVar = this.dataSourceManager;
        if (zxVar != null) {
            return zxVar.isItemsNull();
        }
        return true;
    }

    public boolean isReachTop() {
        WaterfallLayout waterfallLayout = this.waterfallLayout;
        if (waterfallLayout != null) {
            return waterfallLayout.z;
        }
        return false;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBeforeBindChildData() {
        initDataSourceManager();
        initOperator();
        setOrientation(getOrientation());
        List<Object> list = this.dataSource;
        if (list == null || list.size() == 0) {
            s00.b("this.dataSource == null || this.dataSource.size() == 0");
        }
        super.onBeforeBindChildData();
        if (!wt.u0()) {
            rebuildMapping(true);
        }
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        if (itemWidgetNodes != null && itemWidgetNodes.size() != 0) {
            for (DXWidgetNode dXWidgetNode : itemWidgetNodes) {
                bindSpanCtx(dXWidgetNode);
            }
            return;
        }
        List<Object> list2 = this.dataSource;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("生成的子节点为空，或者数量为 0 。 dataSource: ");
        List<Object> list3 = this.dataSource;
        sb.append(list3 == null ? " null " : Integer.valueOf(list3.size()));
        trackError(com.taobao.android.dinamicx.e.DX_ERROR_CODE_RECYCLER_LAYOUT_ON_BEFORE_DATA, sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onBindEvent(Context context, View view, long j) {
        super.onBindEvent(context, view, j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        if (dXWidgetNode instanceof DXRecyclerLayout) {
            super.onClone(dXWidgetNode, z);
            DXRecyclerLayout dXRecyclerLayout = (DXRecyclerLayout) dXWidgetNode;
            this.columnCount = dXRecyclerLayout.columnCount;
            this.columnGap = dXRecyclerLayout.columnGap;
            this.disableBounces = dXRecyclerLayout.disableBounces;
            this.isOpenLoadMore = dXRecyclerLayout.isOpenLoadMore;
            this.loadMoreFailText = dXRecyclerLayout.loadMoreFailText;
            this.loadMoreLoadingText = dXRecyclerLayout.loadMoreLoadingText;
            this.loadMoreNoMoreDataText = dXRecyclerLayout.loadMoreNoMoreDataText;
            this.dataSource = dXRecyclerLayout.dataSource;
            setItemWidgetNodes(dXRecyclerLayout.getItemWidgetNodes());
            this.appearWidgets = dXRecyclerLayout.appearWidgets;
            this.disableBounces = dXRecyclerLayout.disableBounces;
            this.endReachedThreshold = dXRecyclerLayout.endReachedThreshold;
            this.isOpenLoadMore = dXRecyclerLayout.isOpenLoadMore;
            this.isOpenPullToRefresh = dXRecyclerLayout.isOpenPullToRefresh;
            this.leftGap = dXRecyclerLayout.leftGap;
            this.loadMoreTextColor = dXRecyclerLayout.loadMoreTextColor;
            this.loadMoreTextSize = dXRecyclerLayout.loadMoreTextSize;
            this.refreshLoadingText = dXRecyclerLayout.refreshLoadingText;
            this.refreshPullText = dXRecyclerLayout.refreshPullText;
            this.refreshReleaseText = dXRecyclerLayout.refreshReleaseText;
            this.rightGap = dXRecyclerLayout.rightGap;
            this.scrollListener = dXRecyclerLayout.scrollListener;
            this.exposureTimeFactor = dXRecyclerLayout.exposureTimeFactor;
            this.exposureSpaceFactor = dXRecyclerLayout.exposureSpaceFactor;
            com.taobao.android.dinamicx.widget.recycler.expose.b bVar = dXRecyclerLayout.mExposeHelper;
            this.mExposeHelper = bVar;
            this.enableLeftGapWhenSingleColumn = dXRecyclerLayout.enableLeftGapWhenSingleColumn;
            this.defaultLoadMoreStatus = dXRecyclerLayout.defaultLoadMoreStatus;
            this.idxRecyclerOnScrollToPos = dXRecyclerLayout.idxRecyclerOnScrollToPos;
            this.enableTrackStayTime = dXRecyclerLayout.enableTrackStayTime;
            if (bVar != null) {
                bVar.i(this.dataSource);
            }
            this.openPrefetch = dXRecyclerLayout.openPrefetch;
            this.preFetchBatchSize = dXRecyclerLayout.preFetchBatchSize;
            this.startReachedThreshold = dXRecyclerLayout.startReachedThreshold;
            this.needItemAnimation = dXRecyclerLayout.needItemAnimation;
            this.fixVerticalScrollConflict = dXRecyclerLayout.fixVerticalScrollConflict;
            this.videoControlConfig = dXRecyclerLayout.videoControlConfig;
            this.adapterType = dXRecyclerLayout.adapterType;
            this.dataSourceManager = dXRecyclerLayout.dataSourceManager;
            o00 o00Var = dXRecyclerLayout.dxRecyclerOperator;
            if (o00Var != null) {
                this.dxRecyclerOperator = o00Var;
            }
            j00 j00Var = dXRecyclerLayout.dxRecyclerJsOperator;
            if (j00Var != null) {
                this.dxRecyclerJsOperator = j00Var;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        postEvent(new hy(5288680013941347641L));
        getDXRuntimeContext().getEngineContext().b().c();
        WaterfallLayout.b bVar = new WaterfallLayout.b();
        DXNestedScrollerView dxNestedScrollerView = getDXRuntimeContext().getRootView().getDxNestedScrollerView();
        if (dxNestedScrollerView != null) {
            dxNestedScrollerView.setFixVerticalScrollConflict(this.fixVerticalScrollConflict);
        }
        WaterfallLayout a2 = bVar.b(this.columnCount).c(this.columnGap).i(this.marginLeft).j(this.marginRight).h(this.leftGap).m(this.rightGap).d(this.disableBounces == 1).g(this.isOpenPullToRefresh == 1).l(new String[]{this.refreshPullText, this.refreshReleaseText, this.refreshLoadingText, "刷新完成"}).n(null).e(dxNestedScrollerView).f(this.enableLeftGapWhenSingleColumn).k(this.needItemAnimation).o(getOrientation()).a();
        this.waterfallLayout = a2;
        View a3 = a2.a(context);
        a3.setTag(R$id.dx_recycler_layout_view_tag, this.waterfallLayout);
        this.pullRefreshListener = new yx1(this);
        this.scrollListener = new ScrollListener(this);
        this.waterfallLayout.k(this.pullRefreshListener);
        this.waterfallLayout.l(this.scrollListener);
        initExpose(this.waterfallLayout.e());
        initVideoPlayControl(this.waterfallLayout.e());
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public boolean onEvent(hy hyVar) {
        if (hyVar instanceof pz) {
            pz pzVar = (pz) hyVar;
            if (pzVar.h().equalsIgnoreCase("General")) {
                String f = pzVar.f();
                JSONObject g = pzVar.g();
                boolean z = false;
                if (g == null) {
                    return false;
                }
                FalcoAbilitySpan abilitySpanFromParams = getAbilitySpanFromParams(g);
                zz.q(abilitySpanFromParams, MSG_METHOD_UPDATE_CURRENT, "start");
                f.hashCode();
                char c2 = 65535;
                switch (f.hashCode()) {
                    case -1675200021:
                        if (f.equals(MSG_METHOD_INSERT_ITEMS_BY_OFFSET)) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -1472811200:
                        if (f.equals(MSG_METHOD_APPEND_ITEMS)) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -954124385:
                        if (f.equals(MSG_METHOD_REFRESH_DATA)) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case -724196078:
                        if (f.equals(MSG_METHOD_UPDATE_ALL)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -708482225:
                        if (f.equals(MSG_METHOD_DELETE_ITEMS)) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case -232077206:
                        if (f.equals(MSG_METHOD_UPDATE_CURRENT)) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case -160105743:
                        if (f.equals(MSG_METHOD_UPDATE_ITEMS)) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case -150851358:
                        if (f.equals(MSG_METHOD_UPDATE_STYLE)) {
                            c2 = 7;
                            break;
                        }
                        break;
                    case 310191873:
                        if (f.equals(MSG_METHOD_INSERT_ITEMS)) {
                            c2 = '\b';
                            break;
                        }
                        break;
                    case 1086719573:
                        if (f.equals(MSG_METHOD_PULL_TO_REFRESH)) {
                            c2 = '\t';
                            break;
                        }
                        break;
                    case 1534853078:
                        if (f.equals(MSG_METHOD_MODIFY_CURRENT_ITEM_DATA)) {
                            c2 = '\n';
                            break;
                        }
                        break;
                    case 1884917025:
                        if (f.equals(MSG_METHOD_LOAD_MORE)) {
                            c2 = 11;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        if (wt.O0()) {
                            z = this.dxRecyclerOperator.j(this, g, abilitySpanFromParams);
                            break;
                        } else {
                            z = insertItemsByOffset(g, abilitySpanFromParams);
                            break;
                        }
                    case 1:
                        if (wt.O0()) {
                            this.dxRecyclerOperator.a(this, g, abilitySpanFromParams);
                            return true;
                        }
                        z = appendItems(g, abilitySpanFromParams);
                        break;
                    case 2:
                        z = refreshData(g);
                        break;
                    case 3:
                        if (wt.O0()) {
                            z = this.dxRecyclerOperator.n(this, g, abilitySpanFromParams);
                            break;
                        } else {
                            z = updateAll(g, abilitySpanFromParams);
                            break;
                        }
                    case 4:
                        if (wt.O0()) {
                            this.dxRecyclerOperator.b(this, g);
                            return true;
                        }
                        z = deleteItems(g);
                        break;
                    case 5:
                        if (wt.O0()) {
                            z = this.dxRecyclerOperator.o(this, g, false, abilitySpanFromParams);
                            break;
                        } else {
                            z = updateCurrent(g, abilitySpanFromParams);
                            break;
                        }
                    case 6:
                        if (wt.O0()) {
                            z = this.dxRecyclerOperator.q(this, g);
                            break;
                        } else {
                            z = updateItems(g);
                            break;
                        }
                    case 7:
                        z = updateStyle(g);
                        break;
                    case '\b':
                        if (wt.O0()) {
                            z = this.dxRecyclerOperator.i(this, g, abilitySpanFromParams);
                            break;
                        } else {
                            z = insertItems(g, abilitySpanFromParams);
                            break;
                        }
                    case '\t':
                        z = onRefresh(g);
                        break;
                    case '\n':
                        if (wt.O0()) {
                            z = this.dxRecyclerOperator.o(this, g, true, abilitySpanFromParams);
                            break;
                        } else {
                            z = updateCurrent(g, true, (FalcoSpan) abilitySpanFromParams);
                            break;
                        }
                    case 11:
                        z = onLoadMore(g);
                        break;
                }
                zz.q(abilitySpanFromParams, f, "end " + z);
                zz.l(abilitySpanFromParams);
                return z;
            }
        }
        return super.onEvent(hyVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.scroller.IDXScrollableLoadMoreListener
    public void onLoadMore() {
        if (DinamicXEngine.x()) {
            float f = (float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d);
            float freeMemory = (float) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d);
            String[] strArr = new String[1];
            StringBuilder sb = new StringBuilder();
            sb.append("内存优化");
            sb.append(getDXRuntimeContext().getEngineContext().j() ? "开" : "关");
            sb.append(" dataSource ");
            sb.append(this.dataSource.size());
            sb.append(" / totalMem ");
            sb.append(f);
            sb.append(" / freeMem ");
            sb.append(freeMemory);
            strArr[0] = sb.toString();
            nz.i("RLMemPerf", strArr);
        }
        updateLoadMoreStatus(2);
        postOnLoadMoreEvent();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onMeasure(int i, int i2) {
        removeAllChild();
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        RecyclerView e;
        PrefetchRecyclerAdapter prefetchRecyclerAdapter;
        boolean z;
        RecyclerAdapter recyclerAdapter;
        PrefetchRecyclerAdapter prefetchRecyclerAdapter2;
        getDXRuntimeContext().getEngineContext().e().b();
        super.onRenderView(context, view);
        if (view == null) {
            return;
        }
        if (getChildrenCount() > 0) {
            DXWidgetNode widgetNode = getDXRuntimeContext().getWidgetNode();
            if (widgetNode == null) {
                return;
            }
            widgetNode.removeAllChild();
            removeAllChild();
        }
        if (this.waterfallLayout == null) {
            Object tag = view.getTag(R$id.dx_recycler_layout_view_tag);
            if (tag instanceof WaterfallLayout) {
                this.waterfallLayout = (WaterfallLayout) tag;
            }
        }
        if (this.scrollListener == null) {
            initScrollListener();
        }
        WaterfallLayout waterfallLayout = this.waterfallLayout;
        if (waterfallLayout != null && (e = waterfallLayout.e()) != null) {
            RecyclerAdapter recyclerAdapter2 = (RecyclerAdapter) e.getAdapter();
            if (recyclerAdapter2 == null) {
                if (isOpenPrefetch()) {
                    PrefetchRecyclerAdapter prefetchRecyclerAdapter3 = new PrefetchRecyclerAdapter(context, this.isOpenLoadMore == 1, getDXRuntimeContext().getEngineContext().j());
                    prefetchRecyclerAdapter3.M(this.preFetchBatchSize);
                    prefetchRecyclerAdapter2 = prefetchRecyclerAdapter3;
                } else {
                    prefetchRecyclerAdapter2 = new RecyclerAdapter(context, this.isOpenLoadMore == 1, getDXRuntimeContext().getEngineContext().j());
                }
                reInitAdapter(prefetchRecyclerAdapter2);
            } else {
                this.waterfallLayout.h(this.columnCount, -1, this.columnGap, this.leftGap, this.rightGap, this.paddingLeft, this.paddingRight, this.paddingTop, this.paddingBottom, this.marginLeft, this.marginRight, this.isOpenPullToRefresh == 1, false, new String[]{this.refreshPullText, this.refreshReleaseText, this.refreshLoadingText, "刷新完成"}, null, this.disableBounces == 1, this.enableLeftGapWhenSingleColumn);
                if (recyclerAdapter2 instanceof PrefetchRecyclerAdapter) {
                    if (isOpenPrefetch()) {
                        ((PrefetchRecyclerAdapter) recyclerAdapter2).M(this.preFetchBatchSize);
                        z = true;
                        recyclerAdapter = recyclerAdapter2;
                    } else {
                        prefetchRecyclerAdapter = new RecyclerAdapter(context, this.isOpenLoadMore == 1, getDXRuntimeContext().getEngineContext().j());
                        z = false;
                        recyclerAdapter = prefetchRecyclerAdapter;
                    }
                } else {
                    if (isOpenPrefetch()) {
                        PrefetchRecyclerAdapter prefetchRecyclerAdapter4 = new PrefetchRecyclerAdapter(context, this.isOpenLoadMore == 1, getDXRuntimeContext().getEngineContext().j());
                        prefetchRecyclerAdapter4.M(this.preFetchBatchSize);
                        prefetchRecyclerAdapter = prefetchRecyclerAdapter4;
                        z = false;
                        recyclerAdapter = prefetchRecyclerAdapter;
                    }
                    z = true;
                    recyclerAdapter = recyclerAdapter2;
                }
                if (z) {
                    setDataSource(recyclerAdapter, getItemWidgetNodes());
                    recyclerAdapter.z(this);
                    recyclerAdapter.t(this.loadMoreFailText);
                    recyclerAdapter.u(this.loadMoreLoadingText);
                    recyclerAdapter.v(this.loadMoreNoMoreDataText);
                    recyclerAdapter.w(this.loadMoreTextColor);
                    recyclerAdapter.x(this.loadMoreTextSize);
                    recyclerAdapter.y(this.isOpenLoadMore == 1);
                    recyclerAdapter.notifyDataSetChanged();
                } else {
                    this.waterfallLayout.g(e, context);
                    reInitAdapter(recyclerAdapter);
                }
            }
            e.setTag(DXWidgetNode.TAG_WIDGET_NODE, this);
        }
        if (getExposeHelper() != null) {
            this.mExposeHelper.i(this.dataSource);
        }
        ScrollListener scrollListener = this.scrollListener;
        if (scrollListener != null) {
            scrollListener.b();
        }
        initOnTouchListener();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetDoubleAttribute(long j, double d2) {
        if (j == DXRECYCLERLAYOUT_EXPOSURESPACEFACTOR) {
            this.exposureSpaceFactor = d2;
        } else {
            super.onSetDoubleAttribute(j, d2);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == 4480460401770252962L) {
            this.columnCount = i;
        } else if (j == DXRECYCLERLAYOUT_COLUMNGAP) {
            this.columnGap = i;
        } else if (j == DXRECYCLERLAYOUT_DISABLEBOUNCES) {
            this.disableBounces = i;
        } else if (j == DXRECYCLERLAYOUT_ENDREACHEDTHRESHOLD) {
            this.endReachedThreshold = i;
        } else if (j == 2380170249149374095L) {
            this.isOpenLoadMore = i;
        } else if (j == DXRECYCLERLAYOUT_ISOPENPULLTOREFRESH) {
            this.isOpenPullToRefresh = i;
        } else if (j == DXRECYCLERLAYOUT_LEFTGAP) {
            this.leftGap = i;
        } else if (j == DXRECYCLERLAYOUT_LOADMORETEXTCOLOR) {
            this.loadMoreTextColor = i;
        } else if (j == DXRECYCLERLAYOUT_LOADMORETEXTSIZE) {
            this.loadMoreTextSize = i;
        } else if (j == DXRECYCLERLAYOUT_RIGHTGAP) {
            this.rightGap = i;
        } else {
            if (j == DXRECYCLERLAYOUT_ENABLELEFTGAPWHENSINGLECOLUMN) {
                this.enableLeftGapWhenSingleColumn = i != 0;
            } else if (j == DXRECYCLERLAYOUT_DEFAULTLOADMORESTATUS) {
                this.defaultLoadMoreStatus = i;
            } else if (j == DXRECYCLERLAYOUT_ENABLETRACKSTAYTIME) {
                this.enableTrackStayTime = i == 1;
            } else if (j == DXRECYCLERLAYOUT_OPENPREFETCH) {
                this.openPrefetch = i;
            } else if (j == DXRECYCLERLAYOUT_PREFETCHBATCHSIZE) {
                this.preFetchBatchSize = i;
            } else if (j == DXRECYCLERLAYOUT_STARTREACHEDTHRESHOLD) {
                this.startReachedThreshold = i;
            } else if (j == DXRECYCLERLAYOUT_NEEDITEMANIMATION) {
                this.needItemAnimation = i == 1;
            } else if (j == DXRECYCLERLAYOUT_FIXVERTICALSCROLLCONFLICT) {
                this.fixVerticalScrollConflict = i == 1;
            } else if (j == DXRECYCLERLAYOUT_ADAPTERTYPE) {
                this.adapterType = i;
            } else {
                super.onSetIntAttribute(j, i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetListAttribute(long j, JSONArray jSONArray) {
        if (j == -5948810534719014123L) {
            this.dataSource = jSONArray;
            this.propertyInitFlag |= 2;
            return;
        }
        super.onSetListAttribute(j, jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetLongAttribute(long j, long j2) {
        if (j == DXRECYCLERLAYOUT_EXPOSURETIMEFACTOR) {
            this.exposureTimeFactor = j2;
        } else {
            super.onSetLongAttribute(j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetObjAttribute(long j, Object obj) {
        if (j == -7801350391660369312L) {
            this.videoControlConfig = obj;
        } else {
            super.onSetObjAttribute(j, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetStringAttribute(long j, String str) {
        if (j == 7321446999712924516L) {
            this.loadMoreFailText = str;
        } else if (j == -3963239569560963927L) {
            this.loadMoreLoadingText = str;
        } else if (j == -7969714938924101192L) {
            this.loadMoreNoMoreDataText = str;
        } else if (j == DXRECYCLERLAYOUT_REFRESHLOADINGTEXT) {
            this.refreshLoadingText = str;
        } else if (j == DXRECYCLERLAYOUT_REFRESHPULLTEXT) {
            this.refreshPullText = str;
        } else if (j == DXRECYCLERLAYOUT_REFRESHRELEASETEXT) {
            this.refreshReleaseText = str;
        } else {
            super.onSetStringAttribute(j, str);
        }
    }

    public void postOnStartReachedEvent() {
        postEvent(new hy(DXRECYCLERLAYOUT_ONSTARTREACHED));
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode queryWTByAutoId(int i) {
        return super.queryWTByAutoId(i);
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public DXWidgetNode queryWTByUserId(String str) {
        return super.queryWTByUserId(str);
    }

    public boolean refreshCurrentNode(DXWidgetNode dXWidgetNode) {
        if ((dXWidgetNode instanceof DXTemplateWidgetNode) && dXWidgetNode.getDXRuntimeContext().getSubData() != null) {
            JSONObject jSONObject = (JSONObject) dXWidgetNode.getDXRuntimeContext().getSubData();
        } else {
            dXWidgetNode.getDXRuntimeContext().getData();
        }
        DXTemplateWidgetNode parentTemplateWidgetNode = getParentTemplateWidgetNode(dXWidgetNode);
        if (parentTemplateWidgetNode == null) {
            return false;
        }
        int indexOfItem = indexOfItem(parentTemplateWidgetNode);
        if (indexOfItem < 0) {
            trackError(com.taobao.android.dinamicx.e.DX_ERROR_CODE_RECYCLER_LAYOUT_230007, "index: " + indexOfItem);
            return false;
        }
        s00.e(" updateCurrent 获取到的index 为" + indexOfItem);
        refresh(REFRESH_TYPE_PART, indexOfItem, 1, MSG_METHOD_UPDATE_CURRENT);
        return true;
    }

    public void resumeStayTime() {
        if (getExposeHelper() != null) {
            getExposeHelper().h();
        }
        try {
            DXRecyclerLayout currentChildRecyclerLayout = getCurrentChildRecyclerLayout();
            if (currentChildRecyclerLayout == null) {
                return;
            }
            currentChildRecyclerLayout.resumeStayTime();
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public void scrollToPosForAbility(boolean z, int i) {
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null) {
            return;
        }
        ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).scrollToPositionWithOffset(i, 0);
        IDXRecyclerOnScrollToPos iDXRecyclerOnScrollToPos = this.idxRecyclerOnScrollToPos;
        if (iDXRecyclerOnScrollToPos != null) {
            iDXRecyclerOnScrollToPos.onScrollToPos(i);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void sendBroadcastEvent(hy hyVar) {
        super.sendBroadcastEvent(hyVar);
    }

    @Override // com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void setBackground(View view) {
        if (this.waterfallLayout == null && view != null) {
            Object tag = view.getTag(R$id.dx_recycler_layout_view_tag);
            if (tag instanceof WaterfallLayout) {
                this.waterfallLayout = (WaterfallLayout) tag;
            }
        }
        if (this.waterfallLayout != null) {
            if (hasCornerRadius()) {
                WaterfallLayout.c cVar = new WaterfallLayout.c();
                int i = this.cornerRadius;
                if (i > 0) {
                    cVar.j(view, i);
                } else {
                    cVar.k(view, this.cornerRadiusLeftTop, this.cornerRadiusRightTop, this.cornerRadiusLeftBottom, this.cornerRadiusRightBottom);
                }
                this.waterfallLayout.j(cVar);
            } else {
                te b2 = this.waterfallLayout.b();
                if (b2 != null) {
                    b2.j(view, 0.0f);
                }
            }
        }
        super.setBackground(view);
    }

    public void setIdxRecyclerOnScrollToPos(IDXRecyclerOnScrollToPos iDXRecyclerOnScrollToPos) {
        this.idxRecyclerOnScrollToPos = iDXRecyclerOnScrollToPos;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout
    public void setItemWidgetNodes(List<DXWidgetNode> list) {
        if (wt.O0()) {
            zx zxVar = this.dataSourceManager;
            if (zxVar != null) {
                zxVar.i(list);
                this.dataSourceManager.h(this.dataSource);
                return;
            }
            return;
        }
        super.setItemWidgetNodes(list);
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout
    public void setScrollPosition(int i) {
        this.scrollPosition = i;
    }

    public void setStartReachedThreshold(int i) {
        this.startReachedThreshold = i;
    }

    public void trackError(int i, String str) {
        trackError(i, str + " rlId: " + getUserId(), "DX_RECYCLER", "DX_RECYCLER_ERROR");
    }

    public void triggerExposure() {
        if (getExposeHelper() != null) {
            getExposeHelper().d();
        }
        try {
            DXRecyclerLayout currentChildRecyclerLayout = getCurrentChildRecyclerLayout();
            if (currentChildRecyclerLayout != null && currentChildRecyclerLayout != this) {
                currentChildRecyclerLayout.triggerExposure();
            }
        } catch (Throwable th) {
            nz.d(TAG, "triggerExposure ", th);
            ry.b(th);
        }
    }

    public void triggerOnStickyChange(int i, boolean z) {
        hy hyVar = new hy(2228800223520853672L);
        HashMap hashMap = new HashMap();
        hashMap.put("index", az.J(i));
        hashMap.put("sticky", az.F(z));
        hyVar.d(hashMap);
        postEvent(hyVar);
    }

    public void triggerScrollToWhenScrollByFinish(RecyclerView recyclerView) {
        if (this.mShouldScroll) {
            this.mShouldScroll = false;
            smoothMoveToPosition(recyclerView, this.mToPosition);
        }
    }

    public void triggerStayTime() {
        if (getExposeHelper() != null) {
            getExposeHelper().e();
        }
        try {
            DXRecyclerLayout currentChildRecyclerLayout = getCurrentChildRecyclerLayout();
            if (currentChildRecyclerLayout == null) {
                return;
            }
            currentChildRecyclerLayout.triggerStayTime();
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    public void updateItem(DXTemplateWidgetNode dXTemplateWidgetNode) {
        int indexOf;
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        if (dXTemplateWidgetNode == null || itemWidgetNodes == null || (indexOf = itemWidgetNodes.indexOf(dXTemplateWidgetNode)) < 0 || dXTemplateWidgetNode.getDXRuntimeContext() == null || !(dXTemplateWidgetNode.getDXRuntimeContext().getSubData() instanceof JSONObject)) {
            return;
        }
        updateItemWithData((JSONObject) dXTemplateWidgetNode.getDXRuntimeContext().getSubData(), indexOf, null);
        refresh();
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout
    public boolean updateLoadMoreStatus(int i) {
        RecyclerView e;
        RecyclerAdapter recyclerAdapter;
        WaterfallLayout waterfallLayout = this.waterfallLayout;
        if (waterfallLayout == null || (e = waterfallLayout.e()) == null || (recyclerAdapter = (RecyclerAdapter) e.getAdapter()) == null) {
            return false;
        }
        recyclerAdapter.A(i);
        return true;
    }

    @Override // com.taobao.android.dinamicx.widget.DXAbsContainerBaseLayout, com.taobao.android.dinamicx.widget.DXWidgetNode
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

    private void refresh(String str, int i, int i2, String str2) {
        refresh(false, str, i, i2, str2, true);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean updateWithActions(JSONArray jSONArray, int i, boolean z, FalcoSpan falcoSpan) {
        char c2;
        char c3;
        if (i >= 0 && i < this.dataSource.size()) {
            List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
            if (itemWidgetNodes == null || itemWidgetNodes.isEmpty()) {
                return false;
            }
            Object obj = this.dataSource.get(i);
            Iterator<Object> it = jSONArray.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (!(next instanceof JSONObject)) {
                    return false;
                }
                JSONObject jSONObject = (JSONObject) next;
                String string = jSONObject.getString(PATH_OPERATOR);
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
                String string2 = jSONObject.getString("key");
                if (TextUtils.isEmpty(string2)) {
                    return false;
                }
                Object obj2 = jSONObject.get("value");
                ArrayDeque arrayDeque = new ArrayDeque();
                parseFieldNamePathQueue(string2, arrayDeque);
                Object obj3 = obj;
                while (!arrayDeque.isEmpty()) {
                    String poll = arrayDeque.poll();
                    if (arrayDeque.isEmpty()) {
                        if (obj3 instanceof JSONObject) {
                            string.hashCode();
                            switch (string.hashCode()) {
                                case -1068795718:
                                    if (string.equals(OPERATOR_ACTION_MODIFY)) {
                                        c2 = 0;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case -934610812:
                                    if (string.equals(OPERATOR_ACTION_REMOVE)) {
                                        c2 = 1;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                case 103785528:
                                    if (string.equals(OPERATOR_ACTION_MERGE)) {
                                        c2 = 2;
                                        break;
                                    }
                                    c2 = 65535;
                                    break;
                                default:
                                    c2 = 65535;
                                    break;
                            }
                            switch (c2) {
                                case 0:
                                    ((JSONObject) obj3).put(poll, obj2);
                                    if (!z) {
                                        updateItemWithData((JSONObject) obj, i, falcoSpan);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1:
                                    ((JSONObject) obj3).remove(poll);
                                    if (!z) {
                                        updateItemWithData((JSONObject) obj, i, falcoSpan);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 2:
                                    Object obj4 = ((JSONObject) obj3).get(poll);
                                    if ((obj4 instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                                        ((JSONObject) obj4).putAll((JSONObject) obj2);
                                        if (!z) {
                                            updateItemWithData((JSONObject) obj, i, falcoSpan);
                                            break;
                                        } else {
                                            break;
                                        }
                                    } else {
                                        return false;
                                    }
                                default:
                                    return false;
                            }
                        } else {
                            if (obj3 instanceof JSONArray) {
                                try {
                                    int parseInt = Integer.parseInt(poll);
                                    string.hashCode();
                                    switch (string.hashCode()) {
                                        case -1068795718:
                                            if (string.equals(OPERATOR_ACTION_MODIFY)) {
                                                c3 = 0;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        case -934610812:
                                            if (string.equals(OPERATOR_ACTION_REMOVE)) {
                                                c3 = 1;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        case 103785528:
                                            if (string.equals(OPERATOR_ACTION_MERGE)) {
                                                c3 = 2;
                                                break;
                                            }
                                            c3 = 65535;
                                            break;
                                        default:
                                            c3 = 65535;
                                            break;
                                    }
                                    switch (c3) {
                                        case 0:
                                            ((JSONArray) obj3).set(parseInt, obj2);
                                            if (!(obj instanceof JSONObject)) {
                                                break;
                                            } else {
                                                updateItemWithData((JSONObject) obj, i, falcoSpan);
                                                break;
                                            }
                                        case 1:
                                            ((JSONArray) obj3).remove(parseInt);
                                            if (!(obj instanceof JSONObject)) {
                                                break;
                                            } else {
                                                updateItemWithData((JSONObject) obj, i, falcoSpan);
                                                break;
                                            }
                                        case 2:
                                            Object obj5 = ((JSONArray) obj3).get(parseInt);
                                            if ((obj5 instanceof JSONObject) && (obj2 instanceof JSONObject)) {
                                                ((JSONObject) obj5).putAll((JSONObject) obj2);
                                                if (!(obj instanceof JSONObject)) {
                                                    break;
                                                } else {
                                                    updateItemWithData((JSONObject) obj, i, falcoSpan);
                                                    break;
                                                }
                                            } else {
                                                return false;
                                            }
                                        default:
                                            return false;
                                    }
                                } catch (Exception unused) {
                                }
                            }
                            return false;
                        }
                    } else if (!(obj3 instanceof JSONObject)) {
                        return false;
                    } else {
                        obj3 = ((JSONObject) obj3).get(poll);
                    }
                }
            }
            return true;
        }
        trackError(com.taobao.android.dinamicx.e.DX_ERROR_CODE_RECYCLER_LAYOUT_230004, "index: " + i + " dataSource.size() " + this.dataSource.size());
        return false;
    }

    public void resetLoadMoreStatus(int i) {
        updateLoadMoreStatus(i);
    }

    public void updateItemWithData(Object obj, int i, FalcoSpan falcoSpan) {
        DXWidgetNode generateItemWithData;
        List<Object> list = this.dataSource;
        if (list != null && i >= 0 && i < list.size()) {
            this.dataSource.set(i, obj);
        }
        if (isItemsNull() || i < 0 || i >= getRealCount() || (generateItemWithData = generateItemWithData(obj, this.originWidgetNodes, i, falcoSpan)) == null) {
            return;
        }
        setItem(i, generateItemWithData);
    }

    private void refresh(String str, int i, int i2, String str2, boolean z) {
        refresh(false, str, i, i2, str2, z);
    }

    public void refresh(final boolean z, final String str, final int i, final int i2, final String str2, boolean z2) {
        try {
            if (this.waterfallLayout != null) {
                triggerExposure();
                this.waterfallLayout.n(false);
                RecyclerView e = this.waterfallLayout.e();
                if (e == null) {
                    return;
                }
                final RecyclerView.Adapter adapter = e.getAdapter();
                if (!(adapter instanceof RecyclerAdapter)) {
                    return;
                }
                if (e.getScrollState() == 0 && !e.isComputingLayout()) {
                    if (z) {
                        setDataSource((RecyclerAdapter) adapter, getItemWidgetNodes());
                    }
                    notifyData(adapter, str, i, i2, str2);
                } else {
                    y00.m(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXRecyclerLayout.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (z) {
                                DXRecyclerLayout dXRecyclerLayout = DXRecyclerLayout.this;
                                dXRecyclerLayout.setDataSource((RecyclerAdapter) adapter, dXRecyclerLayout.getItemWidgetNodes());
                            }
                            DXRecyclerLayout.this.notifyData(adapter, str, i, i2, str2);
                        }
                    });
                }
                y00.n(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXRecyclerLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        DXRecyclerLayout.this.addVisibleStayTag();
                    }
                }, 100L);
            }
            if (getExposeHelper() != null) {
                this.mExposeHelper.i(this.dataSource);
            }
            if (z2) {
                rebuildMapping(true, i, i2);
            }
        } catch (Throwable th) {
            ry.b(th);
        }
    }

    private boolean onLoadMore(@NonNull JSONObject jSONObject) {
        String string = jSONObject.getString("status");
        string.hashCode();
        char c2 = 65535;
        switch (string.hashCode()) {
            case -1884319283:
                if (string.equals(LOAD_MORE_STOPED)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1281977283:
                if (string.equals("failed")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1040845642:
                if (string.equals(LOAD_MORE_NO_DATA_STRING)) {
                    c2 = 2;
                    break;
                }
                break;
            case 96634189:
                if (string.equals(LOAD_MORE_EMPTY)) {
                    c2 = 3;
                    break;
                }
                break;
            case 336650556:
                if (string.equals("loading")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return updateLoadMoreStatus(4);
            case 1:
                return updateLoadMoreStatus(3);
            case 2:
                return updateLoadMoreStatus(5);
            case 3:
                return updateLoadMoreStatus(6);
            case 4:
                return updateLoadMoreStatus(2);
            default:
                return false;
        }
    }

    private void rebuildMapping(boolean z, int i, int i2) {
        List<DXWidgetNode> itemWidgetNodes = getItemWidgetNodes();
        if (i < 0) {
            rebuildMapping(z);
        } else if (itemWidgetNodes == null || itemWidgetNodes.size() <= 0 || itemWidgetNodes.size() <= i) {
            return;
        } else {
            int size = itemWidgetNodes.size();
            while (i < size) {
                DXWidgetNode dXWidgetNode = itemWidgetNodes.get(i);
                if (dXWidgetNode instanceof DXTemplateWidgetNode) {
                    if (!TextUtils.isEmpty(dXWidgetNode.getUserId())) {
                        this.cellUserId2PositionMap.put(dXWidgetNode.getUserId(), Integer.valueOf(i));
                    }
                    if (z) {
                        ((DXTemplateWidgetNode) dXWidgetNode).dataIndex = i;
                    }
                }
                i++;
            }
        }
        this.cellUserId2PositionMap.clear();
        if (itemWidgetNodes == null || itemWidgetNodes.size() <= 0) {
            return;
        }
        int size2 = itemWidgetNodes.size();
        for (int i3 = 0; i3 < size2; i3++) {
            DXWidgetNode dXWidgetNode2 = itemWidgetNodes.get(i3);
            if (dXWidgetNode2 instanceof DXTemplateWidgetNode) {
                if (!TextUtils.isEmpty(dXWidgetNode2.getUserId())) {
                    this.cellUserId2PositionMap.put(dXWidgetNode2.getUserId(), Integer.valueOf(i3));
                }
                if (z) {
                    ((DXTemplateWidgetNode) dXWidgetNode2).dataIndex = i3;
                }
            }
        }
    }

    private boolean updateCurrent(JSONObject jSONObject, FalcoSpan falcoSpan) {
        return updateCurrent(jSONObject, false, falcoSpan);
    }

    public boolean updateCurrent(DXWidgetNode dXWidgetNode) {
        JSONObject data;
        if ((dXWidgetNode instanceof DXTemplateWidgetNode) && dXWidgetNode.getDXRuntimeContext().getSubData() != null) {
            data = (JSONObject) dXWidgetNode.getDXRuntimeContext().getSubData();
        } else {
            data = dXWidgetNode.getDXRuntimeContext().getData();
        }
        return updateCurrent(dXWidgetNode, data);
    }

    public boolean updateCurrent(DXWidgetNode dXWidgetNode, JSONObject jSONObject, boolean z) {
        DXTemplateWidgetNode parentTemplateWidgetNode = getParentTemplateWidgetNode(dXWidgetNode);
        if (parentTemplateWidgetNode == null) {
            return false;
        }
        int indexOfItem = indexOfItem(parentTemplateWidgetNode);
        if (indexOfItem < 0) {
            trackError(com.taobao.android.dinamicx.e.DX_ERROR_CODE_RECYCLER_LAYOUT_230005, "index: " + indexOfItem);
            return false;
        }
        s00.e(" updateCurrent 获取到的index 为" + indexOfItem);
        updateItemWithData(jSONObject, indexOfItem);
        if (z) {
            return true;
        }
        if (wt.u0()) {
            refresh(REFRESH_TYPE_PART, indexOfItem, 1, MSG_METHOD_UPDATE_CURRENT, false);
            return true;
        }
        refresh(REFRESH_TYPE_PART, indexOfItem, 1, MSG_METHOD_UPDATE_CURRENT, true);
        return true;
    }

    public boolean updateCurrent(DXWidgetNode dXWidgetNode, JSONObject jSONObject) {
        return updateCurrent(dXWidgetNode, jSONObject, false);
    }
}
