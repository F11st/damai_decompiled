package com.taobao.weex.ui.component.list;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Build;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.taobao.weex.common.ICheckBindingScroller;
import com.taobao.weex.common.OnWXScrollListener;
import com.taobao.weex.ui.action.BasicComponentData;
import com.taobao.weex.ui.component.AppearanceHelper;
import com.taobao.weex.ui.component.Scrollable;
import com.taobao.weex.ui.component.WXBaseRefresh;
import com.taobao.weex.ui.component.WXComponent;
import com.taobao.weex.ui.component.WXComponentProp;
import com.taobao.weex.ui.component.WXHeader;
import com.taobao.weex.ui.component.WXLoading;
import com.taobao.weex.ui.component.WXRefresh;
import com.taobao.weex.ui.component.WXVContainer;
import com.taobao.weex.ui.component.helper.ScrollStartEndHelper;
import com.taobao.weex.ui.component.helper.WXStickyHelper;
import com.taobao.weex.ui.component.list.ListComponentView;
import com.taobao.weex.ui.view.listview.WXRecyclerView;
import com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener;
import com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener;
import com.taobao.weex.ui.view.listview.adapter.ListBaseViewHolder;
import com.taobao.weex.ui.view.listview.adapter.RecyclerViewBaseAdapter;
import com.taobao.weex.ui.view.listview.adapter.WXRecyclerViewOnScrollListener;
import com.taobao.weex.utils.WXLogUtils;
import com.taobao.weex.utils.WXResourceUtils;
import com.taobao.weex.utils.WXUtils;
import com.taobao.weex.utils.WXViewUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class BasicListComponent<T extends ViewGroup & ListComponentView> extends WXVContainer<T> implements IRecyclerAdapterListener<ListBaseViewHolder>, IOnLoadMoreListener, Scrollable {
    private static final boolean DEFAULT_EXCLUDED = false;
    private static final String DEFAULT_TRIGGER_TYPE = "longpress";
    private static final String DRAG_ANCHOR = "dragAnchor";
    private static final String DRAG_TRIGGER_TYPE = "dragTriggerType";
    private static final String EXCLUDED = "dragExcluded";
    public static final String LOADMOREOFFSET = "loadmoreoffset";
    private static final int MAX_VIEWTYPE_ALLOW_CACHE = 9;
    public static final String TRANSFORM = "transform";
    private String TAG;
    private boolean isScrollable;
    private WXComponent keepPositionCell;
    private Runnable keepPositionCellRunnable;
    private long keepPositionLayoutDelay;
    private Runnable mAppearChangeRunnable;
    private long mAppearChangeRunnableDelay;
    private Map<String, AppearanceHelper> mAppearComponents;
    protected int mColumnCount;
    protected float mColumnGap;
    protected float mColumnWidth;
    private DragHelper mDragHelper;
    private boolean mForceLoadmoreNextTime;
    private boolean mHasAddScrollEvent;
    private RecyclerView.ItemAnimator mItemAnimator;
    private Point mLastReport;
    protected int mLayoutType;
    protected float mLeftGap;
    private int mListCellCount;
    private int mOffsetAccuracy;
    private ArrayMap<String, Long> mRefToViewType;
    protected float mRightGap;
    private ScrollStartEndHelper mScrollStartEndHelper;
    private Map<String, Map<String, WXComponent>> mStickyMap;
    private String mTriggerType;
    private WXRecyclerViewOnScrollListener mViewOnScrollListener;
    private SparseArray<ArrayList<WXComponent>> mViewTypes;
    private WXStickyHelper stickyHelper;
    private static final Pattern transformPattern = Pattern.compile("([a-z]+)\\(([0-9\\.]+),?([0-9\\.]+)?\\)");
    private static boolean mAllowCacheViewHolder = true;
    private static boolean mDownForBidCacheViewHolder = false;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    interface DragTriggerType {
        public static final String LONG_PRESS = "longpress";
        public static final String PAN = "pan";
    }

    public BasicListComponent(WXSDKInstance wXSDKInstance, WXVContainer wXVContainer, BasicComponentData basicComponentData) {
        super(wXSDKInstance, wXVContainer, basicComponentData);
        this.TAG = "BasicListComponent";
        this.mListCellCount = 0;
        this.mForceLoadmoreNextTime = false;
        this.mAppearComponents = new HashMap();
        this.mAppearChangeRunnable = null;
        this.mAppearChangeRunnableDelay = 50L;
        this.isScrollable = true;
        this.mViewOnScrollListener = new WXRecyclerViewOnScrollListener(this);
        this.mLayoutType = 1;
        this.mColumnCount = 1;
        this.mColumnGap = 0.0f;
        this.mColumnWidth = 0.0f;
        this.mLeftGap = 0.0f;
        this.mRightGap = 0.0f;
        this.mOffsetAccuracy = 10;
        this.mLastReport = new Point(-1, -1);
        this.mHasAddScrollEvent = false;
        this.mStickyMap = new HashMap();
        this.keepPositionCell = null;
        this.keepPositionCellRunnable = null;
        this.keepPositionLayoutDelay = 150L;
        this.stickyHelper = new WXStickyHelper(this);
    }

    private void bindViewType(WXComponent wXComponent) {
        int generateViewType = generateViewType(wXComponent);
        if (this.mViewTypes == null) {
            this.mViewTypes = new SparseArray<>();
        }
        ArrayList<WXComponent> arrayList = this.mViewTypes.get(generateViewType);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.mViewTypes.put(generateViewType, arrayList);
        }
        arrayList.add(wXComponent);
    }

    private void checkRecycledViewPool(int i) {
        try {
            if (this.mViewTypes.size() > 9) {
                mAllowCacheViewHolder = false;
            }
            if (mDownForBidCacheViewHolder && getHostView() != 0 && ((ListComponentView) ((ViewGroup) getHostView())).getInnerView() != null) {
                ((ListComponentView) ((ViewGroup) getHostView())).getInnerView().getRecycledViewPool().setMaxRecycledViews(i, 0);
            }
            if (mDownForBidCacheViewHolder || mAllowCacheViewHolder || getHostView() == 0 || ((ListComponentView) ((ViewGroup) getHostView())).getInnerView() == null) {
                return;
            }
            for (int i2 = 0; i2 < this.mViewTypes.size(); i2++) {
                ((ListComponentView) ((ViewGroup) getHostView())).getInnerView().getRecycledViewPool().setMaxRecycledViews(this.mViewTypes.keyAt(i2), 0);
            }
            mDownForBidCacheViewHolder = true;
        } catch (Exception unused) {
            WXLogUtils.e(this.TAG, "Clear recycledViewPool error!");
        }
    }

    @NonNull
    private ListBaseViewHolder createVHForFakeComponent(int i) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setBackgroundColor(-1);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        return new ListBaseViewHolder(frameLayout, i);
    }

    private ListBaseViewHolder createVHForRefreshComponent(int i) {
        FrameLayout frameLayout = new FrameLayout(getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, 1));
        return new ListBaseViewHolder(frameLayout, i);
    }

    @Nullable
    private WXComponent findComponentByAnchorName(@NonNull WXComponent wXComponent, @NonNull String str) {
        String string;
        long currentTimeMillis = WXEnvironment.isApkDebugable() ? System.currentTimeMillis() : 0L;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(wXComponent);
        while (!arrayDeque.isEmpty()) {
            WXComponent wXComponent2 = (WXComponent) arrayDeque.removeFirst();
            if (wXComponent2 != null && (string = WXUtils.getString(wXComponent2.getAttrs().get(str), null)) != null && string.equals("true")) {
                if (WXEnvironment.isApkDebugable()) {
                    WXLogUtils.d("dragPerf", "findComponentByAnchorName time: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                }
                return wXComponent2;
            } else if (wXComponent2 instanceof WXVContainer) {
                WXVContainer wXVContainer = (WXVContainer) wXComponent2;
                int childCount = wXVContainer.childCount();
                for (int i = 0; i < childCount; i++) {
                    arrayDeque.add(wXVContainer.getChild(i));
                }
            }
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("dragPerf", "findComponentByAnchorName elapsed time: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        return null;
    }

    @Nullable
    private WXComponent findDirectListChild(WXComponent wXComponent) {
        WXVContainer parent;
        if (wXComponent == null || (parent = wXComponent.getParent()) == null) {
            return null;
        }
        return parent instanceof BasicListComponent ? wXComponent : findDirectListChild(parent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireScrollEvent(RecyclerView recyclerView, int i, int i2) {
        fireEvent("scroll", getScrollEvent(recyclerView, i, i2));
    }

    private int generateViewType(WXComponent wXComponent) {
        long j;
        try {
            j = Integer.parseInt(wXComponent.getRef());
            String scope = wXComponent.getAttrs().getScope();
            if (!TextUtils.isEmpty(scope)) {
                if (this.mRefToViewType == null) {
                    this.mRefToViewType = new ArrayMap<>();
                }
                if (!this.mRefToViewType.containsKey(scope)) {
                    this.mRefToViewType.put(scope, Long.valueOf(j));
                }
                j = this.mRefToViewType.get(scope).longValue();
            }
        } catch (RuntimeException e) {
            WXLogUtils.eTag(this.TAG, e);
            j = -1;
            WXLogUtils.e(this.TAG, "getItemViewType: NO ID, this will crash the whole render system of WXListRecyclerView");
        }
        return (int) j;
    }

    private String getTriggerType(@Nullable WXComponent wXComponent) {
        String str = "longpress";
        if (wXComponent == null) {
            return "longpress";
        }
        String string = WXUtils.getString(wXComponent.getAttrs().get(DRAG_TRIGGER_TYPE), "longpress");
        if ("longpress".equals(string) || "pan".equals(string)) {
            str = string;
        }
        if (WXEnvironment.isApkDebugable()) {
            String str2 = this.TAG;
            WXLogUtils.d(str2, "trigger type is " + str);
        }
        return str;
    }

    private void relocateAppearanceHelper() {
        for (Map.Entry<String, AppearanceHelper> entry : this.mAppearComponents.entrySet()) {
            AppearanceHelper value = entry.getValue();
            value.setCellPosition(this.mChildren.indexOf(findDirectListChild(value.getAwareChild())));
        }
    }

    private void setAppearanceWatch(WXComponent wXComponent, int i, boolean z) {
        AppearanceHelper appearanceHelper = this.mAppearComponents.get(wXComponent.getRef());
        if (appearanceHelper != null) {
            appearanceHelper.setWatchEvent(i, z);
        } else if (z) {
            int indexOf = this.mChildren.indexOf(findDirectListChild(wXComponent));
            if (indexOf != -1) {
                AppearanceHelper appearanceHelper2 = new AppearanceHelper(wXComponent, indexOf);
                appearanceHelper2.setWatchEvent(i, true);
                this.mAppearComponents.put(wXComponent.getRef(), appearanceHelper2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldReport(int i, int i2) {
        Point point = this.mLastReport;
        int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
        if (xVar == -1 && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) == -1) {
            point.x = i;
            point.y = i2;
            return true;
        }
        int abs = Math.abs(xVar - i);
        int abs2 = Math.abs(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.mLastReport) - i2);
        int i3 = this.mOffsetAccuracy;
        if (abs >= i3 || abs2 >= i3) {
            Point point2 = this.mLastReport;
            point2.x = i;
            point2.y = i2;
            return true;
        }
        return false;
    }

    private void unBindViewType(WXComponent wXComponent) {
        ArrayList<WXComponent> arrayList;
        int generateViewType = generateViewType(wXComponent);
        SparseArray<ArrayList<WXComponent>> sparseArray = this.mViewTypes;
        if (sparseArray == null || (arrayList = sparseArray.get(generateViewType)) == null) {
            return;
        }
        arrayList.remove(wXComponent);
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void addChild(WXComponent wXComponent) {
        addChild(wXComponent, -1);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void addEvent(String str) {
        super.addEvent(str);
        if (!ScrollStartEndHelper.isScrollEvent(str) || getHostView() == 0 || ((ListComponentView) ((ViewGroup) getHostView())).getInnerView() == null || this.mHasAddScrollEvent) {
            return;
        }
        this.mHasAddScrollEvent = true;
        ((ListComponentView) ((ViewGroup) getHostView())).getInnerView().addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.7
            private boolean mFirstEvent = true;
            private int offsetXCorrection;
            private int offsetYCorrection;

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                int i3;
                int i4;
                super.onScrolled(recyclerView, i, i2);
                int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
                int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
                if (i == 0 && i2 == 0) {
                    this.offsetXCorrection = computeHorizontalScrollOffset;
                    this.offsetYCorrection = computeVerticalScrollOffset;
                    i3 = 0;
                    i4 = 0;
                } else {
                    i3 = computeHorizontalScrollOffset - this.offsetXCorrection;
                    i4 = computeVerticalScrollOffset - this.offsetYCorrection;
                }
                BasicListComponent.this.getScrollStartEndHelper().onScrolled(i3, i4);
                if (BasicListComponent.this.getEvents().contains("scroll")) {
                    if (this.mFirstEvent) {
                        this.mFirstEvent = false;
                    } else if (recyclerView.getLayoutManager().canScrollVertically() && BasicListComponent.this.shouldReport(i3, i4)) {
                        BasicListComponent.this.fireScrollEvent(recyclerView, i3, i4);
                    }
                }
            }
        });
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void addSubView(View view, int i) {
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindAppearEvent(WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 0, true);
        if (this.mAppearChangeRunnable == null) {
            this.mAppearChangeRunnable = new Runnable() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.4
                @Override // java.lang.Runnable
                public void run() {
                    if (BasicListComponent.this.mAppearChangeRunnable != null) {
                        BasicListComponent.this.notifyAppearStateChange(0, 0, 0, 0);
                    }
                }
            };
        }
        if (getHostView() != 0) {
            ((ViewGroup) getHostView()).removeCallbacks(this.mAppearChangeRunnable);
            ((ViewGroup) getHostView()).postDelayed(this.mAppearChangeRunnable, this.mAppearChangeRunnableDelay);
        }
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindDisappearEvent(WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 1, true);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void bindStickStyle(WXComponent wXComponent) {
        this.stickyHelper.bindStickStyle(wXComponent, this.mStickyMap);
    }

    public int calcContentOffset(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int i = 0;
        if (layoutManager instanceof LinearLayoutManager) {
            int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            if (findFirstVisibleItemPosition == -1) {
                return 0;
            }
            View findViewByPosition = layoutManager.findViewByPosition(findFirstVisibleItemPosition);
            int top = findViewByPosition != null ? findViewByPosition.getTop() : 0;
            int i2 = 0;
            while (i < findFirstVisibleItemPosition) {
                WXComponent child = getChild(i);
                if (child != null) {
                    i2 = (int) (i2 - child.getLayoutHeight());
                }
                i++;
            }
            if (layoutManager instanceof GridLayoutManager) {
                i2 /= ((GridLayoutManager) layoutManager).getSpanCount();
            }
            return i2 + top;
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int spanCount = staggeredGridLayoutManager.getSpanCount();
            int i3 = staggeredGridLayoutManager.findFirstVisibleItemPositions(null)[0];
            if (i3 == -1) {
                return 0;
            }
            View findViewByPosition2 = layoutManager.findViewByPosition(i3);
            int top2 = findViewByPosition2 != null ? findViewByPosition2.getTop() : 0;
            int i4 = 0;
            while (i < i3) {
                WXComponent child2 = getChild(i);
                if (child2 != null) {
                    i4 = (int) (i4 - child2.getLayoutHeight());
                }
                i++;
            }
            return (i4 / spanCount) + top2;
        } else {
            return -1;
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void computeVisiblePointInViewCoordinate(PointF pointF) {
        WXRecyclerView innerView = ((ListComponentView) ((ViewGroup) getHostView())).getInnerView();
        pointF.set(innerView.computeHorizontalScrollOffset(), innerView.computeVerticalScrollOffset());
    }

    @Override // com.taobao.weex.ui.component.WXVContainer, com.taobao.weex.ui.component.WXComponent
    public void destroy() {
        if (this.mAppearChangeRunnable != null && getHostView() != 0) {
            ((ViewGroup) getHostView()).removeCallbacks(this.mAppearChangeRunnable);
            this.mAppearChangeRunnable = null;
        }
        super.destroy();
        Map<String, Map<String, WXComponent>> map = this.mStickyMap;
        if (map != null) {
            map.clear();
        }
        SparseArray<ArrayList<WXComponent>> sparseArray = this.mViewTypes;
        if (sparseArray != null) {
            sparseArray.clear();
        }
        ArrayMap<String, Long> arrayMap = this.mRefToViewType;
        if (arrayMap != null) {
            arrayMap.clear();
        }
    }

    abstract T generateListView(Context context, int i);

    @Override // com.taobao.weex.ui.component.WXVContainer
    public ViewGroup.LayoutParams getChildLayoutParams(WXComponent wXComponent, View view, int i, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if ((wXComponent instanceof WXBaseRefresh) && marginLayoutParams == null) {
            return new LinearLayout.LayoutParams(i, i2);
        }
        if (marginLayoutParams == null) {
            return new RecyclerView.LayoutParams(i, i2);
        }
        marginLayoutParams.width = i;
        marginLayoutParams.height = i2;
        setMarginsSupportRTL(marginLayoutParams, i3, 0, i4, 0);
        return marginLayoutParams;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXVContainer
    public int getChildrenLayoutTopOffset() {
        return 0;
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public int getItemCount() {
        return getChildCount();
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public long getItemId(int i) {
        try {
            return Long.parseLong(getChild(i).getRef());
        } catch (RuntimeException e) {
            WXLogUtils.e(this.TAG, WXLogUtils.getStackTrace(e));
            return -1L;
        }
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public int getItemViewType(int i) {
        return generateViewType(getChild(i));
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public int getOrientation() {
        return 1;
    }

    public Map<String, Object> getScrollEvent(RecyclerView recyclerView, int i, int i2) {
        if (getOrientation() == 1) {
            i2 = -calcContentOffset(recyclerView);
        }
        int measuredWidth = recyclerView.getMeasuredWidth() + recyclerView.computeHorizontalScrollRange();
        int i3 = 0;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            WXComponent child = getChild(i4);
            if (child != null) {
                i3 = (int) (i3 + child.getLayoutHeight());
            }
        }
        HashMap hashMap = new HashMap(3);
        HashMap hashMap2 = new HashMap(3);
        HashMap hashMap3 = new HashMap(3);
        hashMap2.put("width", Float.valueOf(WXViewUtils.getWebPxByWidth(measuredWidth, getInstance().getInstanceViewPortWidth())));
        hashMap2.put("height", Float.valueOf(WXViewUtils.getWebPxByWidth(i3, getInstance().getInstanceViewPortWidth())));
        hashMap3.put(Constants.Name.X, Float.valueOf(-WXViewUtils.getWebPxByWidth(i, getInstance().getInstanceViewPortWidth())));
        hashMap3.put(Constants.Name.Y, Float.valueOf(-WXViewUtils.getWebPxByWidth(i2, getInstance().getInstanceViewPortWidth())));
        hashMap.put(Constants.Name.CONTENT_SIZE, hashMap2);
        hashMap.put(Constants.Name.CONTENT_OFFSET, hashMap3);
        hashMap.put(Constants.Name.ISDRAGGING, Boolean.valueOf(recyclerView.getScrollState() == 1));
        return hashMap;
    }

    public ScrollStartEndHelper getScrollStartEndHelper() {
        if (this.mScrollStartEndHelper == null) {
            this.mScrollStartEndHelper = new ScrollStartEndHelper(this);
        }
        return this.mScrollStartEndHelper;
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public int getScrollX() {
        ViewGroup viewGroup = (ViewGroup) getHostView();
        if (viewGroup == null) {
            return 0;
        }
        return ((ListComponentView) viewGroup).getInnerView().getScrollX();
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public int getScrollY() {
        ViewGroup viewGroup = (ViewGroup) getHostView();
        if (viewGroup == null) {
            return 0;
        }
        return ((ListComponentView) viewGroup).getInnerView().getScrollY();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected /* bridge */ /* synthetic */ View initComponentHostView(@NonNull Context context) {
        return (T) initComponentHostView(context);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public boolean isScrollable() {
        return this.isScrollable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void markComponentUsable() {
        Iterator<WXComponent> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().setUsing(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.taobao.weex.ui.component.WXComponent
    public WXComponent.MeasureOutput measure(int i, int i2) {
        int screenHeight = WXViewUtils.getScreenHeight(getInstanceId());
        int weexHeight = WXViewUtils.getWeexHeight(getInstanceId());
        if (weexHeight < screenHeight) {
            screenHeight = weexHeight;
        }
        if (i2 > screenHeight) {
            i2 = weexHeight - getAbsoluteY();
        }
        return super.measure(i, i2);
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener
    public void notifyAppearStateChange(int i, int i2, int i3, int i4) {
        View hostView;
        String str = null;
        if (this.mAppearChangeRunnable != null) {
            ((ViewGroup) getHostView()).removeCallbacks(this.mAppearChangeRunnable);
            this.mAppearChangeRunnable = null;
        }
        if (i4 > 0) {
            str = "up";
        } else if (i4 < 0) {
            str = "down";
        }
        if (getOrientation() == 0 && i3 != 0) {
            str = i3 > 0 ? "left" : "right";
        }
        for (AppearanceHelper appearanceHelper : this.mAppearComponents.values()) {
            WXComponent awareChild = appearanceHelper.getAwareChild();
            if (appearanceHelper.isWatch() && (hostView = awareChild.getHostView()) != null) {
                int appearStatus = appearanceHelper.setAppearStatus(!(ViewCompat.isAttachedToWindow(hostView) ^ true) && appearanceHelper.isViewVisible(true));
                if (appearStatus != 0) {
                    boolean isApkDebugable = WXEnvironment.isApkDebugable();
                    String str2 = Constants.Event.APPEAR;
                    if (isApkDebugable) {
                        WXLogUtils.d(Constants.Event.APPEAR, "item " + appearanceHelper.getCellPositionINScollable() + " result " + appearStatus);
                    }
                    if (appearStatus != 1) {
                        str2 = Constants.Event.DISAPPEAR;
                    }
                    awareChild.notifyAppearStateChange(str2, str);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010f  */
    @Override // com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onBeforeScroll(int r11, int r12) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.weex.ui.component.list.BasicListComponent.onBeforeScroll(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.taobao.weex.ui.component.WXComponent
    public /* bridge */ /* synthetic */ void onHostViewInitialized(View view) {
        onHostViewInitialized((BasicListComponent<T>) ((ViewGroup) view));
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IOnLoadMoreListener
    public void onLoadMore(int i) {
        try {
            String loadMoreOffset = getAttrs().getLoadMoreOffset();
            if (TextUtils.isEmpty(loadMoreOffset)) {
                loadMoreOffset = "0";
            }
            if (i > WXViewUtils.getRealPxByWidth(WXUtils.getInt(loadMoreOffset), getInstance().getInstanceViewPortWidth()) || !getEvents().contains(Constants.Event.LOADMORE)) {
                return;
            }
            if (this.mListCellCount != this.mChildren.size() || this.mForceLoadmoreNextTime) {
                fireEvent(Constants.Event.LOADMORE);
                this.mListCellCount = this.mChildren.size();
                this.mForceLoadmoreNextTime = false;
            }
        } catch (Exception e) {
            WXLogUtils.d(this.TAG + "onLoadMore :", e);
        }
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void remove(WXComponent wXComponent, boolean z) {
        int indexOf = this.mChildren.indexOf(wXComponent);
        if (z) {
            wXComponent.detachViewAndClearPreInfo();
        }
        unBindViewType(wXComponent);
        ViewGroup viewGroup = (ViewGroup) getHostView();
        if (viewGroup == null) {
            return;
        }
        if ("default".equals(wXComponent.getAttrs().get(Constants.Name.DELETE_CELL_ANIMATION))) {
            ((ListComponentView) viewGroup).getInnerView().setItemAnimator(this.mItemAnimator);
        } else {
            ((ListComponentView) viewGroup).getInnerView().setItemAnimator(null);
        }
        ((ListComponentView) viewGroup).getRecyclerViewBaseAdapter().notifyItemRemoved(indexOf);
        if (WXEnvironment.isApkDebugable()) {
            String str = this.TAG;
            WXLogUtils.d(str, "removeChild child at " + indexOf);
        }
        super.remove(wXComponent, z);
    }

    @JSMethod
    public void resetLoadmore() {
        this.mForceLoadmoreNextTime = true;
        this.mListCellCount = 0;
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void scrollTo(WXComponent wXComponent, Map<String, Object> map) {
        boolean z;
        int indexOf;
        float f = 0.0f;
        if (map != null) {
            String obj = map.get("offset") == null ? "0" : map.get("offset").toString();
            z = WXUtils.getBoolean(map.get(Constants.Name.ANIMATED), Boolean.TRUE).booleanValue();
            if (obj != null) {
                try {
                    f = WXViewUtils.getRealPxByWidth(Float.parseFloat(obj), getInstance().getInstanceViewPortWidth());
                } catch (Exception e) {
                    WXLogUtils.e("Float parseFloat error :" + e.getMessage());
                }
            }
        } else {
            z = true;
        }
        int i = (int) f;
        ViewGroup viewGroup = (ViewGroup) getHostView();
        if (viewGroup == null) {
            return;
        }
        WXCell wXCell = null;
        while (true) {
            if (wXComponent == null) {
                break;
            } else if (wXComponent instanceof WXCell) {
                wXCell = (WXCell) wXComponent;
                break;
            } else {
                wXComponent = wXComponent.getParent();
            }
        }
        if (wXCell == null || (indexOf = this.mChildren.indexOf(wXCell)) == -1) {
            return;
        }
        ((ListComponentView) viewGroup).getInnerView().scrollTo(z, indexOf, i, getOrientation());
    }

    @WXComponentProp(name = Constants.Name.DRAGGABLE)
    public void setDraggable(boolean z) {
        DragHelper dragHelper = this.mDragHelper;
        if (dragHelper != null) {
            dragHelper.setDraggable(z);
        }
        if (WXEnvironment.isApkDebugable()) {
            WXLogUtils.d("set draggable : " + z);
        }
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    public void setLayout(WXComponent wXComponent) {
        if (wXComponent.getHostView() != null) {
            ViewCompat.setLayoutDirection(wXComponent.getHostView(), wXComponent.isLayoutRTL() ? 1 : 0);
        }
        super.setLayout(wXComponent);
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    @SuppressLint({"RtlHardcoded"})
    public void setMarginsSupportRTL(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2, int i3, int i4) {
        if (Build.VERSION.SDK_INT >= 17) {
            marginLayoutParams.setMargins(i, i2, i3, i4);
            marginLayoutParams.setMarginStart(i);
            marginLayoutParams.setMarginEnd(i3);
        } else if (marginLayoutParams instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) marginLayoutParams;
            if (isLayoutRTL()) {
                layoutParams.gravity = 53;
                marginLayoutParams.setMargins(i3, i2, i, i4);
                return;
            }
            layoutParams.gravity = 51;
            marginLayoutParams.setMargins(i, i2, i3, i4);
        } else {
            marginLayoutParams.setMargins(i, i2, i3, i4);
        }
    }

    @WXComponentProp(name = Constants.Name.OFFSET_ACCURACY)
    public void setOffsetAccuracy(int i) {
        this.mOffsetAccuracy = (int) WXViewUtils.getRealPxByWidth(i, getInstance().getInstanceViewPortWidth());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.taobao.weex.ui.component.WXComponent
    public boolean setProperty(String str, Object obj) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -304480883:
                if (str.equals(Constants.Name.DRAGGABLE)) {
                    c = 0;
                    break;
                }
                break;
            case -223520855:
                if (str.equals(Constants.Name.SHOW_SCROLLBAR)) {
                    c = 1;
                    break;
                }
                break;
            case -112563826:
                if (str.equals("loadmoreoffset")) {
                    c = 2;
                    break;
                }
                break;
            case -5620052:
                if (str.equals(Constants.Name.OFFSET_ACCURACY)) {
                    c = 3;
                    break;
                }
                break;
            case 66669991:
                if (str.equals(Constants.Name.SCROLLABLE)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                setDraggable(WXUtils.getBoolean(obj, Boolean.FALSE).booleanValue());
                return true;
            case 1:
                Boolean bool = WXUtils.getBoolean(obj, null);
                if (bool != null) {
                    setShowScrollbar(bool.booleanValue());
                }
                return true;
            case 2:
                break;
            case 3:
                setOffsetAccuracy(WXUtils.getInteger(obj, 10).intValue());
                break;
            case 4:
                setScrollable(WXUtils.getBoolean(obj, Boolean.TRUE).booleanValue());
                return true;
            default:
                return super.setProperty(str, obj);
        }
        return true;
    }

    @WXComponentProp(name = Constants.Name.SCROLLABLE)
    public void setScrollable(boolean z) {
        this.isScrollable = z;
        WXRecyclerView innerView = ((ListComponentView) ((ViewGroup) getHostView())).getInnerView();
        if (innerView != null) {
            innerView.setScrollable(z);
        }
    }

    @WXComponentProp(name = Constants.Name.SHOW_SCROLLBAR)
    public void setShowScrollbar(boolean z) {
        if (getHostView() == 0 || ((ListComponentView) ((ViewGroup) getHostView())).getInnerView() == null) {
            return;
        }
        if (getOrientation() == 1) {
            ((ListComponentView) ((ViewGroup) getHostView())).getInnerView().setVerticalScrollBarEnabled(z);
        } else {
            ((ListComponentView) ((ViewGroup) getHostView())).getInnerView().setHorizontalScrollBarEnabled(z);
        }
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindAppearEvent(WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 0, false);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindDisappearEvent(WXComponent wXComponent) {
        setAppearanceWatch(wXComponent, 1, false);
    }

    @Override // com.taobao.weex.ui.component.Scrollable
    public void unbindStickStyle(WXComponent wXComponent) {
        this.stickyHelper.unbindStickStyle(wXComponent, this.mStickyMap);
        WXHeader wXHeader = (WXHeader) findTypeParent(wXComponent, WXHeader.class);
        if (wXHeader == null || getHostView() == 0) {
            return;
        }
        ((ListComponentView) ((ViewGroup) getHostView())).notifyStickyRemove(wXHeader);
    }

    @Override // com.taobao.weex.ui.component.WXVContainer
    public void addChild(WXComponent wXComponent, int i) {
        super.addChild(wXComponent, i);
        if (wXComponent == null || i < -1) {
            return;
        }
        if (i >= this.mChildren.size()) {
            i = -1;
        }
        bindViewType(wXComponent);
        int size = i == -1 ? this.mChildren.size() - 1 : i;
        final ViewGroup viewGroup = (ViewGroup) getHostView();
        if (viewGroup != null) {
            boolean z = false;
            if (getBasicComponentData() != null && "default".equals(getAttrs().get(Constants.Name.INSERT_CELL_ANIMATION))) {
                ((ListComponentView) viewGroup).getInnerView().setItemAnimator(this.mItemAnimator);
            } else {
                ((ListComponentView) viewGroup).getInnerView().setItemAnimator(null);
            }
            if (wXComponent.getBasicComponentData() != null && WXUtils.getBoolean(wXComponent.getAttrs().get(Constants.Name.KEEP_SCROLL_POSITION), Boolean.FALSE).booleanValue() && i <= getChildCount() && i > -1) {
                z = true;
            }
            if (z) {
                ListComponentView listComponentView = (ListComponentView) viewGroup;
                if (listComponentView.getInnerView().getLayoutManager() instanceof LinearLayoutManager) {
                    if (this.keepPositionCell == null) {
                        ListBaseViewHolder listBaseViewHolder = (ListBaseViewHolder) listComponentView.getInnerView().findViewHolderForAdapterPosition(((LinearLayoutManager) listComponentView.getInnerView().getLayoutManager()).findLastCompletelyVisibleItemPosition());
                        if (listBaseViewHolder != null) {
                            this.keepPositionCell = listBaseViewHolder.getComponent();
                        }
                        if (this.keepPositionCell != null) {
                            if (!listComponentView.getInnerView().isLayoutFrozen()) {
                                listComponentView.getInnerView().setLayoutFrozen(true);
                            }
                            Runnable runnable = this.keepPositionCellRunnable;
                            if (runnable != null) {
                                viewGroup.removeCallbacks(runnable);
                            }
                            this.keepPositionCellRunnable = new Runnable() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.5
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (BasicListComponent.this.keepPositionCell != null) {
                                        BasicListComponent basicListComponent = BasicListComponent.this;
                                        int indexOf = basicListComponent.indexOf(basicListComponent.keepPositionCell);
                                        int top = BasicListComponent.this.keepPositionCell.getHostView() != null ? BasicListComponent.this.keepPositionCell.getHostView().getTop() : 0;
                                        if (top > 0) {
                                            ((LinearLayoutManager) ((ListComponentView) viewGroup).getInnerView().getLayoutManager()).scrollToPositionWithOffset(indexOf, top);
                                        } else {
                                            ((ListComponentView) viewGroup).getInnerView().getLayoutManager().scrollToPosition(indexOf);
                                        }
                                        ((ListComponentView) viewGroup).getInnerView().setLayoutFrozen(false);
                                        BasicListComponent.this.keepPositionCell = null;
                                        BasicListComponent.this.keepPositionCellRunnable = null;
                                    }
                                }
                            };
                        }
                    }
                    if (this.keepPositionCellRunnable == null) {
                        listComponentView.getInnerView().scrollToPosition(((LinearLayoutManager) listComponentView.getInnerView().getLayoutManager()).findLastVisibleItemPosition());
                    }
                }
                listComponentView.getRecyclerViewBaseAdapter().notifyItemInserted(size);
                Runnable runnable2 = this.keepPositionCellRunnable;
                if (runnable2 != null) {
                    viewGroup.removeCallbacks(runnable2);
                    viewGroup.postDelayed(this.keepPositionCellRunnable, this.keepPositionLayoutDelay);
                }
            } else {
                ((ListComponentView) viewGroup).getRecyclerViewBaseAdapter().notifyItemChanged(size);
            }
        }
        relocateAppearanceHelper();
    }

    @Override // com.taobao.weex.ui.component.WXComponent
    protected T initComponentHostView(@NonNull Context context) {
        T generateListView = generateListView(context, getOrientation());
        String attrByKey = getAttrByKey("transform");
        if (attrByKey != null) {
            generateListView.getInnerView().addItemDecoration(RecyclerTransform.parseTransforms(getOrientation(), attrByKey));
        }
        if (getAttrs().get(Constants.Name.KEEP_POSITION_LAYOUT_DELAY) != null) {
            this.keepPositionLayoutDelay = WXUtils.getNumberInt(getAttrs().get(Constants.Name.KEEP_POSITION_LAYOUT_DELAY), (int) this.keepPositionLayoutDelay);
        }
        if (getAttrs().get("appearActionDelay") != null) {
            this.mAppearChangeRunnableDelay = WXUtils.getNumberInt(getAttrs().get("appearActionDelay"), (int) this.mAppearChangeRunnableDelay);
        }
        T t = generateListView;
        this.mItemAnimator = t.getInnerView().getItemAnimator();
        RecyclerViewBaseAdapter recyclerViewBaseAdapter = new RecyclerViewBaseAdapter(this);
        recyclerViewBaseAdapter.setHasStableIds(true);
        t.setRecyclerViewBaseAdapter(recyclerViewBaseAdapter);
        generateListView.setOverScrollMode(2);
        T t2 = generateListView;
        t2.getInnerView().addOnScrollListener(this.mViewOnScrollListener);
        if (getAttrs().get(Constants.Name.HAS_FIXED_SIZE) != null) {
            t2.getInnerView().setHasFixedSize(WXUtils.getBoolean(getAttrs().get(Constants.Name.HAS_FIXED_SIZE), Boolean.FALSE).booleanValue());
        }
        t2.getInnerView().addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.2
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                int size;
                View childAt;
                super.onScrollStateChanged(recyclerView, i);
                BasicListComponent.this.getScrollStartEndHelper().onScrollStateChanged(i);
                List<OnWXScrollListener> wXScrollListeners = BasicListComponent.this.getInstance().getWXScrollListeners();
                if (wXScrollListeners == null || (size = wXScrollListeners.size()) <= 0) {
                    return;
                }
                for (int i2 = 0; i2 < size && i2 < wXScrollListeners.size(); i2++) {
                    OnWXScrollListener onWXScrollListener = wXScrollListeners.get(i2);
                    if (onWXScrollListener != null && (childAt = recyclerView.getChildAt(0)) != null) {
                        onWXScrollListener.onScrollStateChanged(recyclerView, 0, childAt.getTop(), i);
                    }
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                List<OnWXScrollListener> wXScrollListeners = BasicListComponent.this.getInstance().getWXScrollListeners();
                if (wXScrollListeners == null || wXScrollListeners.size() <= 0) {
                    return;
                }
                try {
                    for (OnWXScrollListener onWXScrollListener : wXScrollListeners) {
                        if (onWXScrollListener != null) {
                            if (onWXScrollListener instanceof ICheckBindingScroller) {
                                if (((ICheckBindingScroller) onWXScrollListener).isNeedScroller(BasicListComponent.this.getRef(), null)) {
                                    onWXScrollListener.onScrolled(recyclerView, i, i2);
                                }
                            } else {
                                onWXScrollListener.onScrolled(recyclerView, i, i2);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        generateListView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            @TargetApi(16)
            public void onGlobalLayout() {
                ViewGroup viewGroup = (ViewGroup) BasicListComponent.this.getHostView();
                if (viewGroup == null) {
                    return;
                }
                BasicListComponent.this.mViewOnScrollListener.onScrolled(((ListComponentView) viewGroup).getInnerView(), 0, 0);
                if (Build.VERSION.SDK_INT >= 16) {
                    viewGroup.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    viewGroup.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
        return generateListView;
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public void onBindViewHolder(final ListBaseViewHolder listBaseViewHolder, int i) {
        if (listBaseViewHolder == null) {
            return;
        }
        listBaseViewHolder.setComponentUsing(true);
        WXComponent child = getChild(i);
        if (child != null && !(child instanceof WXRefresh) && !(child instanceof WXLoading) && !child.isFixed()) {
            if (listBaseViewHolder.getComponent() == null || !(listBaseViewHolder.getComponent() instanceof WXCell)) {
                return;
            }
            if (listBaseViewHolder.isRecycled()) {
                listBaseViewHolder.bindData(child);
                child.onRenderFinish(1);
            }
            DragHelper dragHelper = this.mDragHelper;
            if (dragHelper == null || !dragHelper.isDraggable()) {
                return;
            }
            String str = this.mTriggerType;
            if (str == null) {
                str = "longpress";
            }
            this.mTriggerType = str;
            WXCell wXCell = (WXCell) listBaseViewHolder.getComponent();
            boolean booleanValue = WXUtils.getBoolean(wXCell.getAttrs().get(EXCLUDED), Boolean.FALSE).booleanValue();
            this.mDragHelper.setDragExcluded(listBaseViewHolder, booleanValue);
            if ("pan".equals(this.mTriggerType)) {
                this.mDragHelper.setLongPressDragEnabled(false);
                WXComponent findComponentByAnchorName = findComponentByAnchorName(wXCell, DRAG_ANCHOR);
                if (findComponentByAnchorName != null && findComponentByAnchorName.getHostView() != null && !booleanValue) {
                    findComponentByAnchorName.getHostView().setOnTouchListener(new View.OnTouchListener() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.6
                        @Override // android.view.View.OnTouchListener
                        @SuppressLint({"ClickableViewAccessibility"})
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            if (MotionEventCompat.getActionMasked(motionEvent) == 0) {
                                BasicListComponent.this.mDragHelper.startDrag(listBaseViewHolder);
                                return true;
                            }
                            return true;
                        }
                    });
                    return;
                } else if (WXEnvironment.isApkDebugable()) {
                    if (!booleanValue) {
                        WXLogUtils.e(this.TAG, "[error] onBindViewHolder: the anchor component or view is not found");
                        return;
                    }
                    String str2 = this.TAG;
                    WXLogUtils.d(str2, "onBindViewHolder: position " + i + " is drag excluded");
                    return;
                } else {
                    return;
                }
            } else if ("longpress".equals(this.mTriggerType)) {
                this.mDragHelper.setLongPressDragEnabled(true);
                return;
            } else {
                return;
            }
        }
        if (WXEnvironment.isApkDebugable()) {
            String str3 = this.TAG;
            WXLogUtils.d(str3, "Bind WXRefresh & WXLoading " + listBaseViewHolder);
        }
        if (!(child instanceof WXBaseRefresh) || listBaseViewHolder.getView() == null || child.getAttrs().get("holderBackground") == null) {
            return;
        }
        listBaseViewHolder.getView().setBackgroundColor(WXResourceUtils.getColor(child.getAttrs().get("holderBackground").toString(), -1));
        listBaseViewHolder.getView().setVisibility(0);
        listBaseViewHolder.getView().postInvalidate();
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public ListBaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.mChildren != null) {
            SparseArray<ArrayList<WXComponent>> sparseArray = this.mViewTypes;
            if (sparseArray == null) {
                return createVHForFakeComponent(i);
            }
            ArrayList<WXComponent> arrayList = sparseArray.get(i);
            checkRecycledViewPool(i);
            if (arrayList == null) {
                return createVHForFakeComponent(i);
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                WXComponent wXComponent = arrayList.get(i2);
                if (wXComponent != null && !wXComponent.isUsing()) {
                    if (wXComponent.isFixed()) {
                        return createVHForFakeComponent(i);
                    }
                    if (wXComponent instanceof WXCell) {
                        if (wXComponent.getRealView() != null) {
                            return new ListBaseViewHolder(wXComponent, i);
                        }
                        wXComponent.lazy(false);
                        wXComponent.createView();
                        wXComponent.applyLayoutAndEvent(wXComponent);
                        return new ListBaseViewHolder(wXComponent, i, true);
                    } else if (wXComponent instanceof WXBaseRefresh) {
                        return createVHForRefreshComponent(i);
                    } else {
                        WXLogUtils.e(this.TAG, "List cannot include element except cell、header、fixed、refresh and loading");
                        return createVHForFakeComponent(i);
                    }
                }
            }
        }
        if (WXEnvironment.isApkDebugable()) {
            String str = this.TAG;
            WXLogUtils.e(str, "Cannot find request viewType: " + i);
        }
        return createVHForFakeComponent(i);
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public boolean onFailedToRecycleView(ListBaseViewHolder listBaseViewHolder) {
        if (WXEnvironment.isApkDebugable()) {
            String str = this.TAG;
            WXLogUtils.d(str, "Failed to recycle " + listBaseViewHolder);
            return false;
        }
        return false;
    }

    protected void onHostViewInitialized(T t) {
        super.onHostViewInitialized((BasicListComponent<T>) t);
        WXRecyclerView innerView = t.getInnerView();
        if (innerView != null && innerView.getAdapter() != null) {
            if (WXUtils.getBoolean(getAttrs().get("prefetchGapDisable"), Boolean.FALSE).booleanValue() && innerView.getLayoutManager() != null) {
                innerView.getLayoutManager().setItemPrefetchEnabled(false);
            }
            ArrayList<WXComponent> arrayList = this.mChildren;
            if (arrayList == null) {
                WXLogUtils.e(this.TAG, "children is null");
                return;
            }
            this.mDragHelper = new DefaultDragHelper(arrayList, innerView, new EventTrigger() { // from class: com.taobao.weex.ui.component.list.BasicListComponent.1
                @Override // com.taobao.weex.ui.component.list.EventTrigger
                public void triggerEvent(String str, Map<String, Object> map) {
                    BasicListComponent.this.fireEvent(str, map);
                }
            });
            this.mTriggerType = getTriggerType(this);
            return;
        }
        WXLogUtils.e(this.TAG, "RecyclerView is not found or Adapter is not bound");
    }

    @Override // com.taobao.weex.ui.view.listview.adapter.IRecyclerAdapterListener
    public void onViewRecycled(ListBaseViewHolder listBaseViewHolder) {
        long currentTimeMillis = System.currentTimeMillis();
        listBaseViewHolder.setComponentUsing(false);
        if (listBaseViewHolder.canRecycled() && listBaseViewHolder.getComponent() != null && !listBaseViewHolder.getComponent().isUsing()) {
            listBaseViewHolder.recycled();
        } else {
            WXLogUtils.w(this.TAG, "this holder can not be allowed to  recycled");
        }
        if (WXEnvironment.isApkDebugable()) {
            String str = this.TAG;
            WXLogUtils.d(str, "Recycle holder " + (System.currentTimeMillis() - currentTimeMillis) + "  Thread:" + Thread.currentThread().getName());
        }
    }
}
