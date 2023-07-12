package com.taobao.android.dinamicx.widget;

import android.content.Context;
import android.os.Parcelable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXRootView;
import com.taobao.android.dinamicx.DXRuntimeContext;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.view.DXLinearLayoutManager;
import com.taobao.android.dinamicx.view.DXNativeAutoLoopRecyclerView;
import com.taobao.android.dinamicx.view.DXNativeRecyclerView;
import com.taobao.android.dinamicx.view.DXScrollLinearLayoutManager;
import com.taobao.android.dinamicx.widget.DXScrollerLayout;
import com.youku.live.livesdk.wkit.component.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import tb.b00;
import tb.g10;
import tb.hy;
import tb.r10;
import tb.ry;
import tb.s00;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXSliderLayout extends DXScrollerLayout {
    public static final long DXSLIDERLAYOUT_AVOIDINCESSANTSCROLL = 6175561478597347134L;
    public static final long DXSLIDERLAYOUT_AVOIDINDEXDELTATOLARGE_ANDROID = 4501425988663277281L;
    public static final long DXSLIDERLAYOUT_DISABLEPAGESELECTANDSTARTTIMEONPRERENDER = -5411074322938787347L;
    public static final long DXSLIDERLAYOUT_INTERCEPTTOUCHEVENT = -3458159313298372122L;
    public static final int DXSLIDERLAYOUT_INTERCEPTTOUCHEVENT_NONE = 0;
    public static final long DXSLIDERLAYOUT_ISCORRECTIONSLIDEOFFSET_ANDROID = 3230619470895835019L;
    public static final long DXSLIDERLAYOUT_ISINTERCEPTMULTIPOINTTOUCH = -4985343460365605412L;
    public static final long DXSLIDERLAYOUT_OVERRIDECANSCROLLHORIZONTALLY = 2622876492584549901L;
    public static final long DXSLIDERLAYOUT_SCROLLWITHPOSTMSG = -7857363928666175735L;
    public static final long DX_SLIDER_LAYOUT = 7645421793448373229L;
    public static final long DX_SLIDER_LAYOUT_AUTO_SCROLL = 2618773720063865426L;
    public static final long DX_SLIDER_LAYOUT_AUTO_SCROLL_INTERVAL = 5501313022839937951L;
    public static final long DX_SLIDER_LAYOUT_IS_INFINITE = -3537170322378136036L;
    public static final long DX_SLIDER_LAYOUT_MANUAL_SWITCH_ENABLED = -7107533083539416402L;
    public static final long DX_SLIDER_LAYOUT_ON_PAGE_CHANGE = -8975195222378757716L;
    public static final long DX_SLIDER_LAYOUT_ON_SET_PAGE_INDEX = -3492248032330035060L;
    public static final long DX_SLIDER_LAYOUT_PAGE_INDEX = 7816489696776271262L;
    private static final String TAG = "DXSliderLayout";
    private boolean autoScroll;
    private boolean isInfinite;
    private int pageIndex;
    private boolean manualSwitchEnabled = true;
    private int autoScrollInterval = 1000;
    private int interceptTouchEvent = 0;
    private boolean avoidIncessantScroll = false;
    private boolean disablePageSelectAndstartTimeOnPreRender = false;
    private boolean avoidIndexDeltaToLarge_Android = false;
    private boolean isInterceptMultipointTouch = true;
    private boolean scrollWithPostMsg = false;
    private boolean overrideCanScrollHorizontal = false;
    private boolean isCorrectionSlideOffset_Android = false;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class AutoLoopScrollerAdapter extends DXScrollerLayout.ScrollerAdapter {
        public AutoLoopScrollerAdapter(Context context, DXScrollerLayout dXScrollerLayout) {
            super(context, dXScrollerLayout);
        }

        @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout.ScrollerAdapter
        public DXWidgetNode b(int i) {
            return super.b(i % this.c.size());
        }

        @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout.ScrollerAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            ArrayList<DXWidgetNode> arrayList = this.c;
            return (arrayList == null || arrayList.size() == 0) ? 0 : Integer.MAX_VALUE;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            ArrayList<DXWidgetNode> arrayList = this.c;
            return arrayList.get(i % arrayList.size()).getAutoId();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class SliderScrollListener extends DXScrollerLayout.ScrollListener {
        private final boolean m;
        private boolean n;

        public SliderScrollListener(boolean z, boolean z2) {
            this.m = z2;
            this.n = z;
        }

        @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout.ScrollListener, androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int size;
            super.onScrollStateChanged(recyclerView, i);
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
            final int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            final DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) recyclerView;
            if (i != 0) {
                if (findFirstVisibleItemPosition == 0 && findLastVisibleItemPosition == 1 && i == 1) {
                    s00.d(DXSliderLayout.TAG, DXSliderLayout.TAG, "first = 0 && last = 1 protect index。set current index = " + findFirstVisibleItemPosition);
                    dXNativeAutoLoopRecyclerView.setCurrentIndex(findFirstVisibleItemPosition);
                    if (dXNativeAutoLoopRecyclerView.getOnPageChangeListener() != null) {
                        dXNativeAutoLoopRecyclerView.getOnPageChangeListener().onPageSelected(findFirstVisibleItemPosition);
                    }
                }
            } else if (dXNativeAutoLoopRecyclerView.getCurrentIndex() != findFirstVisibleItemPosition && findFirstVisibleItemPosition == findLastVisibleItemPosition) {
                s00.d(DXSliderLayout.TAG, DXSliderLayout.TAG, "onScrollStateChanged state idle。 currentIndex = " + dXNativeAutoLoopRecyclerView.getCurrentIndex() + ";firstVisiblePosition = " + findFirstVisibleItemPosition + ";delta = " + (findFirstVisibleItemPosition - dXNativeAutoLoopRecyclerView.getCurrentIndex()));
                dXNativeAutoLoopRecyclerView.setCurrentIndex(findFirstVisibleItemPosition);
                if (this.m && !y00.e(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXSliderLayout.SliderScrollListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dXNativeAutoLoopRecyclerView.scrollToPosition(findFirstVisibleItemPosition);
                    }
                })) {
                    s00.d(DXSliderLayout.TAG, DXSliderLayout.TAG, "onScrollStateChanged state idle scrollToPosition failed, position =  " + findFirstVisibleItemPosition);
                    C6368e c6368e = new C6368e(r10.DB_NAME);
                    C6368e.C6369a c6369a = new C6368e.C6369a("Render", "RENDER_ERROR", C6368e.DX_ERROR_CODE_SLIDER_LAYOUT_IDLE_SCROLL_TO_FAILED);
                    c6369a.e = "onScrollStateChanged state idle scrollToPosition failed, position =  " + findFirstVisibleItemPosition;
                    c6368e.c.add(c6369a);
                    DXAppMonitor.n(c6368e);
                }
                if (dXNativeAutoLoopRecyclerView.getOnPageChangeListener() != null) {
                    dXNativeAutoLoopRecyclerView.getOnPageChangeListener().onPageSelected(findFirstVisibleItemPosition);
                }
                if (d().getOrientation() == 0) {
                    DXScrollerLayout.ScrollListener scrollListener = (DXScrollerLayout.ScrollListener) dXNativeAutoLoopRecyclerView.getTag(DXScrollerLayout.DX_TAG_HAS_SCROLL_LISTENER);
                    int measuredWidth = d().getMeasuredWidth();
                    if (measuredWidth == 0 || scrollListener.g % measuredWidth == 0) {
                        return;
                    }
                    if (scrollListener.d() != null && scrollListener.d().itemWidgetNodes != null && this.n && (size = scrollListener.d().itemWidgetNodes.size()) > 0 && findFirstVisibleItemPosition > 100) {
                        findFirstVisibleItemPosition %= size;
                    }
                    int measuredWidth2 = findFirstVisibleItemPosition * d().getMeasuredWidth();
                    dXNativeAutoLoopRecyclerView.setScrolledX(measuredWidth2);
                    dXNativeAutoLoopRecyclerView.setScrolledY(0);
                    scrollListener.h(measuredWidth2);
                    scrollListener.i(0);
                    g(recyclerView, this.b);
                    f("scroll_end");
                }
            } else if (this.n) {
                int measuredWidth3 = d().getMeasuredWidth();
                DXScrollerLayout.ScrollListener scrollListener2 = (DXScrollerLayout.ScrollListener) dXNativeAutoLoopRecyclerView.getTag(DXScrollerLayout.DX_TAG_HAS_SCROLL_LISTENER);
                int i2 = scrollListener2.g;
                if ((i2 % measuredWidth3 == 0 || findFirstVisibleItemPosition != findLastVisibleItemPosition) && ((i2 / measuredWidth3) % 4 == dXNativeAutoLoopRecyclerView.getCurrentIndex() % 4 || findFirstVisibleItemPosition != findLastVisibleItemPosition)) {
                    return;
                }
                int currentIndex = (dXNativeAutoLoopRecyclerView.getCurrentIndex() % 4) * d().getMeasuredWidth();
                dXNativeAutoLoopRecyclerView.setScrolledX(currentIndex);
                dXNativeAutoLoopRecyclerView.setScrolledY(0);
                scrollListener2.h(currentIndex);
                scrollListener2.i(0);
                g(recyclerView, this.b);
                f("scroll_end");
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.DXSliderLayout$a */
    /* loaded from: classes11.dex */
    public static class C6456a implements IDXBuilderWidgetNode {
        @Override // com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
        public DXWidgetNode build(Object obj) {
            return new DXSliderLayout();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.DXSliderLayout$b */
    /* loaded from: classes11.dex */
    public static class C6457b implements DXNativeAutoLoopRecyclerView.OnPageChangeListener {
        private DXSliderLayout a;
        private int b;
        private b00 c = new b00(-8975195222378757716L);

        public C6457b(DXSliderLayout dXSliderLayout, int i) {
            this.a = dXSliderLayout;
            this.b = i;
        }

        @Override // com.taobao.android.dinamicx.view.DXNativeAutoLoopRecyclerView.OnPageChangeListener
        public void onPageSelected(int i) {
            if (this.b == 0) {
                DXRuntimeContext dXRuntimeContext = this.a.getDXRuntimeContext();
                C6368e c6368e = new C6368e(dXRuntimeContext.getBizType());
                c6368e.b = dXRuntimeContext.getDxTemplateItem();
                C6368e.C6369a c6369a = new C6368e.C6369a("Engine", "Engine_Render", C6368e.DX_ERROR_CODE_SLIDER_LAYOUT_ITEM_COUNT_0);
                c6369a.e = "position=" + i;
                c6368e.c.add(c6369a);
                return;
            }
            DXRuntimeContext dXRuntimeContext2 = this.a.getDXRuntimeContext();
            if (dXRuntimeContext2 == null) {
                return;
            }
            DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) dXRuntimeContext2.getNativeView();
            if (dXNativeAutoLoopRecyclerView == null) {
                new C6368e(dXRuntimeContext2.getBizType()).b = dXRuntimeContext2.getDxTemplateItem();
                C6368e.C6369a c6369a2 = new C6368e.C6369a("Engine", "Engine_Render", C6368e.DX_ERROR_CODE_SLIDER_LAYOUT_RECYCLER_VIEW_NULL);
                DXWidgetNode referenceNode = this.a.getReferenceNode();
                WeakReference<View> wRView = referenceNode != null ? referenceNode.getWRView() : null;
                StringBuilder sb = new StringBuilder();
                sb.append("flattenWidgetNode is");
                sb.append(referenceNode == null ? "null" : "notNull");
                sb.append("weakReferenceView is");
                sb.append(wRView != null ? "notNull" : "null");
                c6369a2.e = sb.toString();
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("thread info:");
                    sb2.append(Thread.currentThread().getName());
                    DXWidgetNode widgetNode = dXRuntimeContext2.getWidgetNode();
                    if (widgetNode != null) {
                        sb2.append("expandedWT != null\n ");
                        if (widgetNode.getReferenceNode() == null) {
                            sb2.append("flatten == null");
                        }
                    } else {
                        sb2.append("expandedWT == null\n ");
                    }
                    StackTraceElement[] stackTrace = new Throwable().getStackTrace();
                    if (stackTrace != null) {
                        for (int i2 = 0; i2 < stackTrace.length; i2++) {
                            sb2.append(stackTrace[i2].getClassName() + Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX + stackTrace[i2].getMethodName() + " #" + stackTrace[i2].getLineNumber() + StringUtils.LF);
                        }
                    }
                    s00.b(sb2.toString());
                    c6369a2.e += sb2.toString();
                } finally {
                    try {
                        return;
                    } finally {
                    }
                }
                return;
            }
            dXNativeAutoLoopRecyclerView.setSaveInstanceState(null);
            if (this.a.isInfinite) {
                this.c.f(i % this.b);
            } else {
                this.c.f(i);
            }
            DXWidgetNode dXWidgetNode = this.a.indicatorWidgetNode;
            if (dXWidgetNode != null) {
                dXWidgetNode.postEvent(this.c);
            }
            this.a.setPageIndex(this.c.d);
            this.a.postEvent(this.c);
        }
    }

    private int calculateTargetIndex(DXSliderLayout dXSliderLayout, int i) {
        ArrayList<DXWidgetNode> arrayList = dXSliderLayout.itemWidgetNodes;
        int i2 = 0;
        int size = arrayList != null ? arrayList.size() : 0;
        if (!dXSliderLayout.isInfinite) {
            i2 = i;
        } else if (size != 0) {
            i2 = ((536870911 / size) * size) + i;
        }
        s00.d(TAG, TAG, "calculateTargetIndex = " + i2 + ";pageIndex = " + i + ";itemCount = " + size);
        return i2;
    }

    private void scrollToIndexOnIsNotInfinite(final DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView, DXSliderLayout dXSliderLayout, final int i) {
        if (i > 0) {
            if (getOrientation() == 0) {
                final DXScrollerLayout.ScrollListener scrollListener = (DXScrollerLayout.ScrollListener) dXNativeAutoLoopRecyclerView.getTag(DXScrollerLayout.DX_TAG_HAS_SCROLL_LISTENER);
                dXNativeAutoLoopRecyclerView.needScrollAfterLayout(i * getMeasuredWidth(), 0, dXSliderLayout.contentHorizontalLength, dXSliderLayout.contentVerticalLength);
                scrollListener.g(dXNativeAutoLoopRecyclerView, new g10(DX_SLIDER_LAYOUT_ON_SET_PAGE_INDEX));
                y00.e(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXSliderLayout.6
                    @Override // java.lang.Runnable
                    public void run() {
                        scrollListener.f("scrolling");
                    }
                });
                return;
            }
            y00.e(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXSliderLayout.7
                @Override // java.lang.Runnable
                public void run() {
                    dXNativeAutoLoopRecyclerView.scrollToPosition(i);
                }
            });
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode, com.taobao.android.dinamicx.widget.IDXBuilderWidgetNode
    public DXWidgetNode build(Object obj) {
        return new DXSliderLayout();
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXWidgetNode
    public int getDefaultValueForIntAttr(long j) {
        if (j == DX_SLIDER_LAYOUT_AUTO_SCROLL) {
            return 0;
        }
        if (j == DX_SLIDER_LAYOUT_AUTO_SCROLL_INTERVAL) {
            return 1000;
        }
        if (j == -3537170322378136036L) {
            return 0;
        }
        if (j == DX_SLIDER_LAYOUT_MANUAL_SWITCH_ENABLED) {
            return 1;
        }
        if (j == DXSLIDERLAYOUT_DISABLEPAGESELECTANDSTARTTIMEONPRERENDER || j == DX_SLIDER_LAYOUT_PAGE_INDEX) {
            return 0;
        }
        if (j == DXSLIDERLAYOUT_ISINTERCEPTMULTIPOINTTOUCH) {
            return 1;
        }
        if (j == DXSLIDERLAYOUT_AVOIDINDEXDELTATOLARGE_ANDROID || j == DXSLIDERLAYOUT_SCROLLWITHPOSTMSG || j == DXSLIDERLAYOUT_ISCORRECTIONSLIDEOFFSET_ANDROID) {
            return 0;
        }
        return super.getDefaultValueForIntAttr(j);
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.IDXNodePropProvider
    public Object getNodePropByKey(String str) {
        if ("pageIndex".equals(str)) {
            return Integer.valueOf(this.pageIndex);
        }
        return super.getNodePropByKey(str);
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollLayoutBase
    public int measureSpecForChild(int i, int i2) {
        return i2;
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout
    @NonNull
    protected DXLinearLayoutManager newLinearLayoutManager(Context context) {
        return new DXScrollLinearLayoutManager(context, getOrientation(), false);
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout
    protected DXScrollerLayout.ScrollListener newScrollListener() {
        return new SliderScrollListener(this.isCorrectionSlideOffset_Android, this.avoidIndexDeltaToLarge_Android);
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onClone(DXWidgetNode dXWidgetNode, boolean z) {
        super.onClone(dXWidgetNode, z);
        if (dXWidgetNode instanceof DXSliderLayout) {
            DXSliderLayout dXSliderLayout = (DXSliderLayout) dXWidgetNode;
            this.isInfinite = dXSliderLayout.isInfinite;
            this.pageIndex = dXSliderLayout.pageIndex;
            this.autoScrollInterval = dXSliderLayout.autoScrollInterval;
            this.autoScroll = dXSliderLayout.autoScroll;
            this.manualSwitchEnabled = dXSliderLayout.manualSwitchEnabled;
            this.disablePageSelectAndstartTimeOnPreRender = dXSliderLayout.disablePageSelectAndstartTimeOnPreRender;
            this.interceptTouchEvent = dXSliderLayout.interceptTouchEvent;
            this.avoidIncessantScroll = dXSliderLayout.avoidIncessantScroll;
            this.isInterceptMultipointTouch = dXSliderLayout.isInterceptMultipointTouch;
            this.avoidIndexDeltaToLarge_Android = dXSliderLayout.avoidIndexDeltaToLarge_Android;
            this.scrollWithPostMsg = dXSliderLayout.scrollWithPostMsg;
            this.overrideCanScrollHorizontal = dXSliderLayout.overrideCanScrollHorizontal;
            this.isCorrectionSlideOffset_Android = dXSliderLayout.isCorrectionSlideOffset_Android;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.DXWidgetNode
    public View onCreateView(Context context) {
        return new DXNativeAutoLoopRecyclerView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXWidgetNode
    public boolean onEvent(hy hyVar) {
        DXRootView rootView;
        final DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView;
        int measuredWidth;
        int scrolledX;
        if (super.onEvent(hyVar) || (rootView = getDXRuntimeContext().getRootView()) == null) {
            return true;
        }
        if (!rootView.hasDXRootViewLifeCycle() || (dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) getDXRuntimeContext().getNativeView()) == null) {
            return false;
        }
        dXNativeAutoLoopRecyclerView.setNeedProcessViewLifeCycle(false);
        long b = hyVar.b();
        if (5288671110273408574L != b) {
            if (5388973340095122049L == b) {
                try {
                    dXNativeAutoLoopRecyclerView.stopTimer();
                    dXNativeAutoLoopRecyclerView.setSaveInstanceState(dXNativeAutoLoopRecyclerView.getLayoutManager().onSaveInstanceState());
                    return true;
                } catch (Throwable th) {
                    ry.b(th);
                }
            }
            return false;
        }
        dXNativeAutoLoopRecyclerView.startTimer();
        if (!dXNativeAutoLoopRecyclerView.isAutoPlay() && getOrientation() == 0 && !dXNativeAutoLoopRecyclerView.isNeedScrollAfterLayout() && (measuredWidth = getMeasuredWidth()) != 0 && (scrolledX = dXNativeAutoLoopRecyclerView.getScrolledX() % measuredWidth) != 0) {
            int measuredWidth2 = getMeasuredWidth() / 2;
            final int scrolledX2 = dXNativeAutoLoopRecyclerView.getScrolledX() / measuredWidth;
            if (scrolledX > measuredWidth2) {
                dXNativeAutoLoopRecyclerView.scrollBy(measuredWidth - scrolledX, 0);
                scrolledX2++;
            } else {
                dXNativeAutoLoopRecyclerView.scrollBy(-scrolledX, 0);
            }
            s00.d(TAG, TAG, "onAppear correct index。  oldIndex = " + dXNativeAutoLoopRecyclerView.getCurrentIndex() + ";newIndex = " + scrolledX2 + ";delta = " + (scrolledX2 - dXNativeAutoLoopRecyclerView.getCurrentIndex()));
            dXNativeAutoLoopRecyclerView.setCurrentIndex(scrolledX2);
            if (this.avoidIndexDeltaToLarge_Android && !y00.e(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXSliderLayout.2
                @Override // java.lang.Runnable
                public void run() {
                    dXNativeAutoLoopRecyclerView.scrollToPosition(scrolledX2);
                }
            })) {
                s00.d(TAG, TAG, "onAppear correct index scrollToPosition failed, position =  " + scrolledX2);
                C6368e c6368e = new C6368e(r10.DB_NAME);
                C6368e.C6369a c6369a = new C6368e.C6369a("Render", "RENDER_ERROR", C6368e.DX_ERROR_CODE_SLIDER_LAYOUT_APPEAR_SCROLL_TO_FAILED);
                c6369a.e = "onAppear correct index scrollToPosition failed, position =  " + scrolledX2;
                c6368e.c.add(c6369a);
                DXAppMonitor.n(c6368e);
            }
            if (dXNativeAutoLoopRecyclerView.getOnPageChangeListener() != null) {
                dXNativeAutoLoopRecyclerView.getOnPageChangeListener().onPageSelected(scrolledX2);
            }
            final DXScrollerLayout.ScrollListener scrollListener = (DXScrollerLayout.ScrollListener) dXNativeAutoLoopRecyclerView.getTag(DXScrollerLayout.DX_TAG_HAS_SCROLL_LISTENER);
            y00.e(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXSliderLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    if (scrolledX2 == 0) {
                        scrollListener.h(1);
                        scrollListener.f("scrolling");
                        scrollListener.h(0);
                    }
                    scrollListener.f("scrolling");
                }
            });
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onRenderView(Context context, View view) {
        DXSliderLayout dXSliderLayout;
        int i;
        int size;
        super.onRenderView(context, view);
        if ((view instanceof DXNativeAutoLoopRecyclerView) && (dXSliderLayout = (DXSliderLayout) getDXRuntimeContext().getWidgetNode()) != null) {
            final DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) view;
            dXNativeAutoLoopRecyclerView.setOverrideCanScrollHorizontal(this.overrideCanScrollHorizontal);
            dXNativeAutoLoopRecyclerView.setDinamicXEngine(getDXRuntimeContext().getEngineContext().e());
            dXNativeAutoLoopRecyclerView.setNestedType(this.interceptTouchEvent);
            dXNativeAutoLoopRecyclerView.setInterceptMultipointTouch(this.isInterceptMultipointTouch);
            final int calculateTargetIndex = calculateTargetIndex(dXSliderLayout, dXSliderLayout.pageIndex);
            if (dXSliderLayout.getMeasuredWidth() != 0 && getOrientation() == 0 && this.isCorrectionSlideOffset_Android) {
                DXScrollerLayout.ScrollListener scrollListener = (DXScrollerLayout.ScrollListener) dXNativeAutoLoopRecyclerView.getTag(DXScrollerLayout.DX_TAG_HAS_SCROLL_LISTENER);
                int measuredWidth = ((scrollListener == null || scrollListener.d() == null || scrollListener.d().itemWidgetNodes == null || (size = scrollListener.d().itemWidgetNodes.size()) <= 0 || calculateTargetIndex <= 100) ? calculateTargetIndex : calculateTargetIndex % size) * dXSliderLayout.getMeasuredWidth();
                dXNativeAutoLoopRecyclerView.setScrolledX(measuredWidth);
                dXNativeAutoLoopRecyclerView.setScrolledY(0);
                scrollListener.h(measuredWidth);
                scrollListener.i(0);
            }
            DXRootView rootView = getDXRuntimeContext().getRootView();
            if (rootView == null) {
                return;
            }
            dXNativeAutoLoopRecyclerView.setNeedProcessViewLifeCycle(!rootView.hasDXRootViewLifeCycle());
            s00.d(TAG, TAG, "onRenderView oldIndex = " + dXNativeAutoLoopRecyclerView.getCurrentIndex() + ";newIndex = " + calculateTargetIndex + ";delta = " + (calculateTargetIndex - dXNativeAutoLoopRecyclerView.getCurrentIndex()));
            dXNativeAutoLoopRecyclerView.setCurrentIndex(calculateTargetIndex);
            if (dXSliderLayout.isInfinite) {
                boolean e = y00.e(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXSliderLayout.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dXNativeAutoLoopRecyclerView.scrollToPosition(calculateTargetIndex);
                    }
                });
                if (this.avoidIndexDeltaToLarge_Android && !e) {
                    s00.d(TAG, TAG, "onRenderView scrollToPosition failed, targetIndex = " + calculateTargetIndex);
                    C6368e c6368e = new C6368e(r10.DB_NAME);
                    C6368e.C6369a c6369a = new C6368e.C6369a("Render", "RENDER_ERROR", C6368e.DX_ERROR_CODE_SLIDER_LAYOUT_RENDER_SCROLL_TO_FAILED);
                    c6369a.e = "onRenderView scrollToPosition failed, targetIndex = " + calculateTargetIndex;
                    c6368e.c.add(c6369a);
                    DXAppMonitor.n(c6368e);
                }
            } else {
                scrollToIndexOnIsNotInfinite(dXNativeAutoLoopRecyclerView, dXSliderLayout, calculateTargetIndex);
            }
            ArrayList<DXWidgetNode> arrayList = dXSliderLayout.itemWidgetNodes;
            C6457b c6457b = new C6457b(dXSliderLayout, arrayList != null ? arrayList.size() : 0);
            dXNativeAutoLoopRecyclerView.setOnPageChangeListener(c6457b);
            if (!this.disablePageSelectAndstartTimeOnPreRender || getDXRuntimeContext().getRenderType() != 2) {
                c6457b.onPageSelected(calculateTargetIndex);
            }
            dXNativeAutoLoopRecyclerView.setManualSwitchEnabled(this.manualSwitchEnabled);
            dXNativeAutoLoopRecyclerView.setAvoidIncessantScroll(this.avoidIncessantScroll);
            if (dXSliderLayout.isInfinite && (i = dXSliderLayout.autoScrollInterval) > 0 && dXSliderLayout.autoScroll && dXSliderLayout.scrollEnabled) {
                dXNativeAutoLoopRecyclerView.setInterval(i);
                dXNativeAutoLoopRecyclerView.setAutoPlay(true);
                if (this.disablePageSelectAndstartTimeOnPreRender && getDXRuntimeContext().getRenderType() == 2) {
                    return;
                }
                dXNativeAutoLoopRecyclerView.startTimer();
                return;
            }
            dXNativeAutoLoopRecyclerView.stopTimer();
            dXNativeAutoLoopRecyclerView.setAutoPlay(false);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout, com.taobao.android.dinamicx.widget.DXScrollLayoutBase, com.taobao.android.dinamicx.widget.DXLinearLayoutWidgetNode, com.taobao.android.dinamicx.widget.C6493f, com.taobao.android.dinamicx.widget.DXWidgetNode
    public void onSetIntAttribute(long j, int i) {
        if (j == DX_SLIDER_LAYOUT_AUTO_SCROLL) {
            this.autoScroll = i != 0;
        } else if (j == DX_SLIDER_LAYOUT_AUTO_SCROLL_INTERVAL) {
            this.autoScrollInterval = Math.max(0, i);
        } else if (j == DX_SLIDER_LAYOUT_PAGE_INDEX) {
            this.pageIndex = Math.max(0, i);
        } else if (j == -3537170322378136036L) {
            this.isInfinite = i != 0;
        } else if (j == DX_SLIDER_LAYOUT_MANUAL_SWITCH_ENABLED) {
            this.manualSwitchEnabled = i != 0;
        } else if (j == DXSLIDERLAYOUT_DISABLEPAGESELECTANDSTARTTIMEONPRERENDER) {
            this.disablePageSelectAndstartTimeOnPreRender = i != 0;
        } else if (j == DXSLIDERLAYOUT_INTERCEPTTOUCHEVENT) {
            this.interceptTouchEvent = i;
        } else if (j == DXSLIDERLAYOUT_AVOIDINCESSANTSCROLL) {
            this.avoidIncessantScroll = i != 0;
        } else if (j == DXSLIDERLAYOUT_AVOIDINDEXDELTATOLARGE_ANDROID) {
            this.avoidIndexDeltaToLarge_Android = i != 0;
        } else if (j == DXSLIDERLAYOUT_ISINTERCEPTMULTIPOINTTOUCH) {
            this.isInterceptMultipointTouch = i != 0;
        } else if (j == DXSLIDERLAYOUT_SCROLLWITHPOSTMSG) {
            this.scrollWithPostMsg = i != 0;
        } else if (j == DXSLIDERLAYOUT_OVERRIDECANSCROLLHORIZONTALLY) {
            this.overrideCanScrollHorizontal = i != 0;
        } else if (j == DXSLIDERLAYOUT_ISCORRECTIONSLIDEOFFSET_ANDROID) {
            this.isCorrectionSlideOffset_Android = i != 0;
        } else {
            super.onSetIntAttribute(j, i);
        }
    }

    public void scrollToPageIndex(int i) {
        if (getDXRuntimeContext().getNativeView() instanceof DXNativeAutoLoopRecyclerView) {
            final DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) getDXRuntimeContext().getNativeView();
            DXSliderLayout dXSliderLayout = (DXSliderLayout) getDXRuntimeContext().getWidgetNode();
            final int calculateTargetIndex = calculateTargetIndex(dXSliderLayout, i);
            if (dXSliderLayout.isInfinite) {
                y00.e(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXSliderLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        dXNativeAutoLoopRecyclerView.scrollToPosition(calculateTargetIndex);
                        dXNativeAutoLoopRecyclerView.setCurrentIndex(calculateTargetIndex);
                    }
                });
            } else {
                scrollToIndexOnIsNotInfinite(dXNativeAutoLoopRecyclerView, dXSliderLayout, calculateTargetIndex);
            }
            DXNativeAutoLoopRecyclerView.OnPageChangeListener onPageChangeListener = dXNativeAutoLoopRecyclerView.getOnPageChangeListener();
            if (this.disablePageSelectAndstartTimeOnPreRender && getDXRuntimeContext().getRenderType() == 2) {
                return;
            }
            onPageChangeListener.onPageSelected(calculateTargetIndex);
        }
    }

    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout
    protected void setAdapter(DXScrollerLayout dXScrollerLayout, @NonNull RecyclerView recyclerView, Context context) {
        DXSliderLayout dXSliderLayout = (DXSliderLayout) dXScrollerLayout;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (dXSliderLayout.isInfinite) {
            if (adapter instanceof AutoLoopScrollerAdapter) {
                AutoLoopScrollerAdapter autoLoopScrollerAdapter = (AutoLoopScrollerAdapter) adapter;
                autoLoopScrollerAdapter.c(dXScrollerLayout.itemWidgetNodes);
                autoLoopScrollerAdapter.f(dXSliderLayout);
                autoLoopScrollerAdapter.notifyDataSetChanged();
                return;
            }
            AutoLoopScrollerAdapter autoLoopScrollerAdapter2 = new AutoLoopScrollerAdapter(context, dXScrollerLayout);
            autoLoopScrollerAdapter2.c(dXScrollerLayout.itemWidgetNodes);
            recyclerView.setAdapter(autoLoopScrollerAdapter2);
            return;
        }
        if (adapter instanceof AutoLoopScrollerAdapter) {
            recyclerView.setAdapter(null);
            DXScrollerLayout.ScrollerAdapter scrollerAdapter = new DXScrollerLayout.ScrollerAdapter(context, dXScrollerLayout);
            scrollerAdapter.setHasStableIds(true);
            scrollerAdapter.c(dXScrollerLayout.itemWidgetNodes);
            recyclerView.setAdapter(scrollerAdapter);
        } else if (adapter == null) {
            DXScrollerLayout.ScrollerAdapter scrollerAdapter2 = new DXScrollerLayout.ScrollerAdapter(context, dXScrollerLayout);
            scrollerAdapter2.setHasStableIds(true);
            scrollerAdapter2.c(dXScrollerLayout.itemWidgetNodes);
            recyclerView.setAdapter(scrollerAdapter2);
        } else {
            DXScrollerLayout.ScrollerAdapter scrollerAdapter3 = (DXScrollerLayout.ScrollerAdapter) recyclerView.getAdapter();
            scrollerAdapter3.c(dXScrollerLayout.itemWidgetNodes);
            scrollerAdapter3.f(dXScrollerLayout);
            if (this.pageIndex == 0) {
                ((DXNativeRecyclerView) recyclerView).needScrollAfterLayout(0, 0, dXScrollerLayout.contentHorizontalLength, dXScrollerLayout.contentVerticalLength, this.scrollWithPostMsg);
            }
            Parcelable saveInstanceState = ((DXNativeAutoLoopRecyclerView) recyclerView).getSaveInstanceState();
            if (saveInstanceState != null) {
                recyclerView.getLayoutManager().onRestoreInstanceState(saveInstanceState);
            }
            adapter.notifyDataSetChanged();
        }
        ((DXScrollerLayout.ScrollerAdapter) recyclerView.getAdapter()).d(false);
    }

    public void setInterceptMultipointTouch(boolean z) {
        this.isInterceptMultipointTouch = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.android.dinamicx.widget.DXScrollerLayout
    public void setLayoutManager(Context context, DXScrollerLayout dXScrollerLayout, RecyclerView recyclerView) {
        super.setLayoutManager(context, dXScrollerLayout, recyclerView);
        DXScrollLinearLayoutManager dXScrollLinearLayoutManager = (DXScrollLinearLayoutManager) recyclerView.getLayoutManager();
        if (getOrientation() == 1) {
            dXScrollLinearLayoutManager.c(getHeight());
        } else {
            dXScrollLinearLayoutManager.c(getWidth());
        }
    }

    public void setPageIndex(int i) {
        this.pageIndex = i;
    }

    public void smoothScrollToPosition(int i) {
        if (getDXRuntimeContext().getNativeView() instanceof DXNativeAutoLoopRecyclerView) {
            final DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) getDXRuntimeContext().getNativeView();
            final int calculateTargetIndex = calculateTargetIndex((DXSliderLayout) getDXRuntimeContext().getWidgetNode(), i);
            y00.e(new Runnable() { // from class: com.taobao.android.dinamicx.widget.DXSliderLayout.5
                @Override // java.lang.Runnable
                public void run() {
                    dXNativeAutoLoopRecyclerView.smoothScrollToPosition(calculateTargetIndex);
                    dXNativeAutoLoopRecyclerView.setCurrentIndex(calculateTargetIndex);
                }
            });
            DXNativeAutoLoopRecyclerView.OnPageChangeListener onPageChangeListener = dXNativeAutoLoopRecyclerView.getOnPageChangeListener();
            if (this.disablePageSelectAndstartTimeOnPreRender && getDXRuntimeContext().getRenderType() == 2) {
                return;
            }
            onPageChangeListener.onPageSelected(calculateTargetIndex);
        }
    }

    public void startTimer() {
        DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView;
        int i;
        if ((getDXRuntimeContext().getNativeView() instanceof DXNativeAutoLoopRecyclerView) && (dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) getDXRuntimeContext().getNativeView()) != null && this.isInfinite && (i = this.autoScrollInterval) > 0 && this.autoScroll && this.scrollEnabled) {
            dXNativeAutoLoopRecyclerView.setInterval(i);
            dXNativeAutoLoopRecyclerView.setAutoPlay(true);
            if (this.disablePageSelectAndstartTimeOnPreRender && getDXRuntimeContext().getRenderType() == 2) {
                return;
            }
            dXNativeAutoLoopRecyclerView.startTimer();
        }
    }

    public void stopTimer() {
        if (getDXRuntimeContext().getNativeView() instanceof DXNativeAutoLoopRecyclerView) {
            DXNativeAutoLoopRecyclerView dXNativeAutoLoopRecyclerView = (DXNativeAutoLoopRecyclerView) getDXRuntimeContext().getNativeView();
            dXNativeAutoLoopRecyclerView.stopTimer();
            dXNativeAutoLoopRecyclerView.setAutoPlay(false);
        }
    }
}
