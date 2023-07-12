package com.alibaba.android.vlayout;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcelable;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx;
import com.alibaba.android.vlayout.extend.LayoutManagerCanScrollListener;
import com.alibaba.android.vlayout.extend.PerformanceMonitor;
import com.alibaba.android.vlayout.extend.ViewLifeCycleHelper;
import com.alibaba.android.vlayout.extend.ViewLifeCycleListener;
import com.alibaba.android.vlayout.layout.BaseLayoutHelper;
import com.alibaba.android.vlayout.layout.FixAreaLayoutHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import tb.m80;
import tb.m81;
import tb.py1;
import tb.wj0;
import tb.x50;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class VirtualLayoutManager extends ExposeLinearLayoutManagerEx implements LayoutManagerHelper {
    private static AbstractC3289a DEFAULT_LAYOUT_HELPER = new x50();
    public static final int HORIZONTAL = 0;
    private static final int MAX_NO_SCROLLING_SIZE = 134217727;
    private static final String PHASE_LAYOUT = "layout";
    private static final String PHASE_MEASURE = "measure";
    protected static final String TAG = "VirtualLayoutManager";
    private static final String TRACE_LAYOUT = "VLM onLayoutChildren";
    private static final String TRACE_SCROLL = "VLM scroll";
    public static final int VERTICAL = 1;
    public static boolean sDebuggable;
    private LayoutManagerCanScrollListener layoutManagerCanScrollListener;
    private boolean mCanScrollHorizontally;
    private boolean mCanScrollVertically;
    private Rect mDecorInsets;
    private AbstractC3289a mDefaultLayoutHelper;
    private boolean mEnableMarginOverlapping;
    private wj0 mFixAreaAdjustor;
    private AbstractC3290b mHelperFinder;
    private BaseLayoutHelper.LayoutViewBindListener mLayoutViewBindListener;
    private LayoutViewFactory mLayoutViewFatory;
    private int mMaxMeasureSize;
    private int mMeasuredFullSpace;
    private int mNested;
    private boolean mNestedScrolling;
    private boolean mNoScrolling;
    protected AbstractC3291c mOrientationHelper;
    private PerformanceMonitor mPerformanceMonitor;
    private Comparator<Pair<py1<Integer>, Integer>> mRangeComparator;
    private List<Pair<py1<Integer>, Integer>> mRangeLengths;
    private RecyclerView mRecyclerView;
    protected AbstractC3291c mSecondaryOrientationHelper;
    private boolean mSpaceMeasured;
    private boolean mSpaceMeasuring;
    private C3286c mTempAnchorInfoWrapper;
    private C3287d mTempLayoutStateWrapper;
    private ViewLifeCycleHelper mViewLifeCycleHelper;
    private HashMap<Integer, AbstractC3289a> newHelpersSet;
    private HashMap<Integer, AbstractC3289a> oldHelpersSet;

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public interface CacheViewHolder {
        boolean needCached();
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class InflateLayoutParams extends LayoutParams {
        public InflateLayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.vlayout.VirtualLayoutManager$a */
    /* loaded from: classes15.dex */
    class C3284a implements Comparator<Pair<py1<Integer>, Integer>> {
        C3284a(VirtualLayoutManager virtualLayoutManager) {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Pair<py1<Integer>, Integer> pair, Pair<py1<Integer>, Integer> pair2) {
            if (pair == null && pair2 == null) {
                return 0;
            }
            if (pair == null) {
                return -1;
            }
            if (pair2 == null) {
                return 1;
            }
            return ((Integer) ((py1) pair.first).d()).intValue() - ((Integer) ((py1) pair2.first).d()).intValue();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.vlayout.VirtualLayoutManager$b */
    /* loaded from: classes6.dex */
    class C3285b implements LayoutViewFactory {
        C3285b(VirtualLayoutManager virtualLayoutManager) {
        }

        @Override // com.alibaba.android.vlayout.LayoutViewFactory
        public View generateLayoutView(@NonNull Context context) {
            return new LayoutView(context);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.vlayout.VirtualLayoutManager$c */
    /* loaded from: classes15.dex */
    public static class C3286c {
        public int a;
        public int b;
        public boolean c;

        C3286c() {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.vlayout.VirtualLayoutManager$d */
    /* loaded from: classes15.dex */
    public static class C3287d {
        public static final int ITEM_DIRECTION_HEAD = -1;
        public static final int ITEM_DIRECTION_TAIL = 1;
        public static final int LAYOUT_END = 1;
        public static final int LAYOUT_START = -1;
        private ExposeLinearLayoutManagerEx.C3282c a;

        C3287d() {
        }

        public int b() {
            return this.a.mAvailable;
        }

        public int c() {
            return this.a.mCurrentPosition;
        }

        public int d() {
            return this.a.mExtra;
        }

        public int e() {
            return this.a.mItemDirection;
        }

        public int f() {
            return this.a.mLayoutDirection;
        }

        public int g() {
            return this.a.mOffset;
        }

        public boolean h(RecyclerView.State state) {
            return this.a.hasMore(state);
        }

        public boolean i() {
            return this.a.mScrapList != null;
        }

        public boolean j() {
            return this.a.mIsPreLayout;
        }

        public boolean k() {
            return this.a.mOnRefresLayout;
        }

        public View l(RecyclerView.Recycler recycler) {
            return this.a.next(recycler);
        }

        public View m(RecyclerView.Recycler recycler, int i) {
            ExposeLinearLayoutManagerEx.C3282c c3282c = this.a;
            int i2 = c3282c.mCurrentPosition;
            c3282c.mCurrentPosition = i;
            View l = l(recycler);
            this.a.mCurrentPosition = i2;
            return l;
        }

        public void n() {
            ExposeLinearLayoutManagerEx.C3282c c3282c = this.a;
            c3282c.mCurrentPosition += c3282c.mItemDirection;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.android.vlayout.VirtualLayoutManager$e */
    /* loaded from: classes6.dex */
    private static class C3288e extends RecyclerView.ViewHolder {
        public C3288e(View view) {
            super(view);
        }
    }

    public VirtualLayoutManager(@NonNull Context context) {
        this(context, 1);
    }

    public static void enableDebugging(boolean z) {
        sDebuggable = z;
    }

    @Nullable
    private int findRangeLength(@NonNull py1<Integer> py1Var) {
        Pair<py1<Integer>, Integer> pair;
        Pair<py1<Integer>, Integer> pair2;
        int size = this.mRangeLengths.size();
        if (size == 0) {
            return -1;
        }
        int i = 0;
        int i2 = size - 1;
        int i3 = -1;
        while (true) {
            pair = null;
            if (i > i2) {
                break;
            }
            i3 = (i + i2) / 2;
            pair2 = this.mRangeLengths.get(i3);
            py1<Integer> py1Var2 = (py1) pair2.first;
            if (py1Var2 == null) {
                break;
            } else if (py1Var2.a(py1Var.d()) || py1Var2.a(py1Var.e()) || py1Var.b(py1Var2)) {
                break;
            } else if (py1Var2.d().intValue() > py1Var.e().intValue()) {
                i2 = i3 - 1;
            } else if (py1Var2.e().intValue() < py1Var.d().intValue()) {
                i = i3 + 1;
            }
        }
        pair = pair2;
        if (pair == null) {
            return -1;
        }
        return i3;
    }

    private void measureChildWithDecorations(View view, int i, int i2) {
        calculateItemDecorationsForChild(view, this.mDecorInsets);
        Rect rect = this.mDecorInsets;
        int updateSpecWithExtra = updateSpecWithExtra(i, rect.left, rect.right);
        Rect rect2 = this.mDecorInsets;
        int updateSpecWithExtra2 = updateSpecWithExtra(i2, rect2.top, rect2.bottom);
        PerformanceMonitor performanceMonitor = this.mPerformanceMonitor;
        if (performanceMonitor != null) {
            performanceMonitor.recordStart(PHASE_MEASURE, view);
        }
        view.measure(updateSpecWithExtra, updateSpecWithExtra2);
        PerformanceMonitor performanceMonitor2 = this.mPerformanceMonitor;
        if (performanceMonitor2 != null) {
            performanceMonitor2.recordEnd(PHASE_MEASURE, view);
        }
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2) {
        calculateItemDecorationsForChild(view, this.mDecorInsets);
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (getOrientation() == 1) {
            int i3 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            Rect rect = this.mDecorInsets;
            i = updateSpecWithExtra(i, i3 + rect.left, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + rect.right);
        }
        if (getOrientation() == 0) {
            Rect rect2 = this.mDecorInsets;
            i2 = updateSpecWithExtra(i2, rect2.top, rect2.bottom);
        }
        PerformanceMonitor performanceMonitor = this.mPerformanceMonitor;
        if (performanceMonitor != null) {
            performanceMonitor.recordStart(PHASE_MEASURE, view);
        }
        view.measure(i, i2);
        PerformanceMonitor performanceMonitor2 = this.mPerformanceMonitor;
        if (performanceMonitor2 != null) {
            performanceMonitor2.recordEnd(PHASE_MEASURE, view);
        }
    }

    private void runPostLayout(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        int i2 = this.mNested - 1;
        this.mNested = i2;
        if (i2 <= 0) {
            this.mNested = 0;
            int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = findLastVisibleItemPosition();
            for (AbstractC3289a abstractC3289a : this.mHelperFinder.b()) {
                try {
                    abstractC3289a.afterLayout(recycler, state, findFirstVisibleItemPosition, findLastVisibleItemPosition, i, this);
                } catch (Exception e) {
                    if (sDebuggable) {
                        throw e;
                    }
                }
            }
            ViewLifeCycleHelper viewLifeCycleHelper = this.mViewLifeCycleHelper;
            if (viewLifeCycleHelper != null) {
                viewLifeCycleHelper.a();
            }
        }
    }

    private void runPreLayout(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.mNested == 0) {
            for (AbstractC3289a abstractC3289a : this.mHelperFinder.c()) {
                abstractC3289a.beforeLayout(recycler, state, this);
            }
        }
        this.mNested++;
    }

    private void setDefaultLayoutHelper(@NonNull AbstractC3289a abstractC3289a) {
        if (abstractC3289a != null) {
            this.mDefaultLayoutHelper = abstractC3289a;
            return;
        }
        throw new IllegalArgumentException("layoutHelper should not be null");
    }

    private int updateSpecWithExtra(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        if (mode == Integer.MIN_VALUE || mode == 1073741824) {
            if ((View.MeasureSpec.getSize(i) - i2) - i3 < 0) {
                return View.MeasureSpec.makeMeasureSpec(0, mode);
            }
            return View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i) - i2) - i3, mode);
        }
        return i;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addBackgroundView(View view, boolean z) {
        showView(view);
        addView(view, z ? 0 : -1);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addChildView(View view, int i) {
        super.addView(view, i);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addFixedView(View view) {
        addOffFlowView(view, false);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addOffFlowView(View view, boolean z) {
        showView(view);
        addHiddenView(view, z);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public /* bridge */ /* synthetic */ void assertNotInLayoutOrScroll(String str) {
        super.assertNotInLayoutOrScroll(str);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        LayoutManagerCanScrollListener layoutManagerCanScrollListener = this.layoutManagerCanScrollListener;
        return this.mCanScrollHorizontally && !this.mNoScrolling && (layoutManagerCanScrollListener == null || layoutManagerCanScrollListener.canScrollHorizontally());
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        LayoutManagerCanScrollListener layoutManagerCanScrollListener = this.layoutManagerCanScrollListener;
        return this.mCanScrollVertically && !this.mNoScrolling && (layoutManagerCanScrollListener == null || layoutManagerCanScrollListener.canScrollVertically());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    protected int computeAlignOffset(View view, boolean z, boolean z2) {
        return computeAlignOffset(getPosition(view), z, z2);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public /* bridge */ /* synthetic */ PointF computeScrollVectorForPosition(int i) {
        return super.computeScrollVectorForPosition(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void detachAndScrapAttachedViews(RecyclerView.Recycler recycler) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            RecyclerView.ViewHolder childViewHolder = getChildViewHolder(getChildAt(childCount));
            if ((childViewHolder instanceof CacheViewHolder) && ((CacheViewHolder) childViewHolder).needCached()) {
                ExposeLinearLayoutManagerEx.C3283d.e(childViewHolder, 0, 6);
            }
        }
        super.detachAndScrapAttachedViews(recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void detachAndScrapView(View view, RecyclerView.Recycler recycler) {
        super.detachAndScrapView(view, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void detachAndScrapViewAt(int i, RecyclerView.Recycler recycler) {
        RecyclerView.ViewHolder childViewHolder = getChildViewHolder(getChildAt(i));
        if ((childViewHolder instanceof CacheViewHolder) && ((CacheViewHolder) childViewHolder).needCached()) {
            ExposeLinearLayoutManagerEx.C3283d.e(childViewHolder, 0, 4);
        }
        super.detachAndScrapViewAt(i, recycler);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public /* bridge */ /* synthetic */ void ensureLayoutStateExpose() {
        super.ensureLayoutStateExpose();
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public /* bridge */ /* synthetic */ int findFirstVisibleItemPosition() {
        return super.findFirstVisibleItemPosition();
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public /* bridge */ /* synthetic */ int findLastVisibleItemPosition() {
        return super.findLastVisibleItemPosition();
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public AbstractC3289a findLayoutHelperByPosition(int i) {
        return this.mHelperFinder.a(i);
    }

    public AbstractC3289a findNeighbourNonfixLayoutHelper(AbstractC3289a abstractC3289a, boolean z) {
        List<AbstractC3289a> b;
        int indexOf;
        AbstractC3289a abstractC3289a2;
        if (abstractC3289a == null || (indexOf = (b = this.mHelperFinder.b()).indexOf(abstractC3289a)) == -1) {
            return null;
        }
        int i = z ? indexOf - 1 : indexOf + 1;
        if (i < 0 || i >= b.size() || (abstractC3289a2 = b.get(i)) == null || abstractC3289a2.isFixLayout()) {
            return null;
        }
        return abstractC3289a2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int i) {
        View findViewByPosition = super.findViewByPosition(i);
        if (findViewByPosition == null || getPosition(findViewByPosition) != i) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt != null && getPosition(childAt) == i) {
                    return childAt;
                }
            }
            return null;
        }
        return findViewByPosition;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((RecyclerView.LayoutParams) ((LayoutParams) layoutParams));
        }
        if (layoutParams instanceof RecyclerView.LayoutParams) {
            return new LayoutParams((RecyclerView.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public final View generateLayoutView() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return null;
        }
        View generateLayoutView = this.mLayoutViewFatory.generateLayoutView(recyclerView.getContext());
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        ExposeLinearLayoutManagerEx.attachViewHolder(layoutParams, new C3288e(generateLayoutView));
        generateLayoutView.setLayoutParams(layoutParams);
        return generateLayoutView;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public int getChildMeasureSpec(int i, int i2, boolean z) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(i, 0, i2, z);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public RecyclerView.ViewHolder getChildViewHolder(View view) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getChildViewHolder(view);
        }
        return null;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public int getContentHeight() {
        return super.getHeight();
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public int getContentWidth() {
        return super.getWidth();
    }

    public List<View> getFixedViews() {
        if (this.mRecyclerView == null) {
            return Collections.emptyList();
        }
        LinkedList linkedList = new LinkedList();
        for (AbstractC3289a abstractC3289a : this.mHelperFinder.b()) {
            View fixedView = abstractC3289a.getFixedView();
            if (fixedView != null) {
                linkedList.add(fixedView);
            }
        }
        return linkedList;
    }

    @NonNull
    public List<AbstractC3289a> getLayoutHelpers() {
        return this.mHelperFinder.b();
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public AbstractC3291c getMainOrientationHelper() {
        return this.mOrientationHelper;
    }

    public int getOffsetToStart() {
        int i = -1;
        if (getChildCount() == 0) {
            return -1;
        }
        View childAt = getChildAt(0);
        if (childAt == null) {
            return -1;
        }
        int position = getPosition(childAt);
        int findRangeLength = findRangeLength(py1.c(Integer.valueOf(position), Integer.valueOf(position)));
        if (findRangeLength >= 0 && findRangeLength < this.mRangeLengths.size()) {
            i = -this.mOrientationHelper.g(childAt);
            for (int i2 = 0; i2 < findRangeLength; i2++) {
                Pair<py1<Integer>, Integer> pair = this.mRangeLengths.get(i2);
                if (pair != null) {
                    i += ((Integer) pair.second).intValue();
                }
            }
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, com.alibaba.android.vlayout.LayoutManagerHelper
    public int getOrientation() {
        return super.getOrientation();
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public AbstractC3291c getSecondaryOrientationHelper() {
        return this.mSecondaryOrientationHelper;
    }

    public int getVirtualLayoutDirection() {
        return ((ExposeLinearLayoutManagerEx) this).mLayoutState.mLayoutDirection;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, com.alibaba.android.vlayout.LayoutManagerHelper
    public void hideView(View view) {
        super.hideView(view);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public boolean isDoLayoutRTL() {
        return isLayoutRTL();
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, com.alibaba.android.vlayout.LayoutManagerHelper
    public boolean isEnableMarginOverLap() {
        return this.mEnableMarginOverlapping;
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public boolean isViewHolderUpdated(View view) {
        RecyclerView.ViewHolder childViewHolder = getChildViewHolder(view);
        return childViewHolder == null || ExposeLinearLayoutManagerEx.isViewHolderUpdated(childViewHolder);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void layoutChild(View view, int i, int i2, int i3, int i4) {
        PerformanceMonitor performanceMonitor = this.mPerformanceMonitor;
        if (performanceMonitor != null) {
            performanceMonitor.recordStart("layout", view);
        }
        layoutDecorated(view, i, i2, i3, i4);
        PerformanceMonitor performanceMonitor2 = this.mPerformanceMonitor;
        if (performanceMonitor2 != null) {
            performanceMonitor2.recordEnd("layout", view);
        }
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void layoutChildWithMargins(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        PerformanceMonitor performanceMonitor = this.mPerformanceMonitor;
        if (performanceMonitor != null) {
            performanceMonitor.recordStart("layout", view);
        }
        layoutDecorated(view, i + marginLayoutParams.leftMargin, i2 + marginLayoutParams.topMargin, i3 - marginLayoutParams.rightMargin, i4 - marginLayoutParams.bottomMargin);
        PerformanceMonitor performanceMonitor2 = this.mPerformanceMonitor;
        if (performanceMonitor2 != null) {
            performanceMonitor2.recordEnd("layout", view);
        }
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    protected void layoutChunk(RecyclerView.Recycler recycler, RecyclerView.State state, ExposeLinearLayoutManagerEx.C3282c c3282c, m81 m81Var) {
        int i = c3282c.mCurrentPosition;
        this.mTempLayoutStateWrapper.a = c3282c;
        AbstractC3290b abstractC3290b = this.mHelperFinder;
        AbstractC3289a a = abstractC3290b == null ? null : abstractC3290b.a(i);
        if (a == null) {
            a = this.mDefaultLayoutHelper;
        }
        a.doLayout(recycler, state, this.mTempLayoutStateWrapper, m81Var, this);
        this.mTempLayoutStateWrapper.a = null;
        int i2 = c3282c.mCurrentPosition;
        if (i2 == i) {
            if (sDebuggable) {
                Log.w(TAG, "layoutHelper[" + a.getClass().getSimpleName() + m80.DINAMIC_PREFIX_AT + a.toString() + "] consumes no item!");
            }
            m81Var.b = true;
            return;
        }
        int i3 = i2 - c3282c.mItemDirection;
        int i4 = m81Var.c ? 0 : m81Var.a;
        py1<Integer> py1Var = new py1<>(Integer.valueOf(Math.min(i, i3)), Integer.valueOf(Math.max(i, i3)));
        int findRangeLength = findRangeLength(py1Var);
        if (findRangeLength >= 0) {
            Pair<py1<Integer>, Integer> pair = this.mRangeLengths.get(findRangeLength);
            if (pair != null && ((py1) pair.first).equals(py1Var) && ((Integer) pair.second).intValue() == i4) {
                return;
            }
            this.mRangeLengths.remove(findRangeLength);
        }
        this.mRangeLengths.add(Pair.create(py1Var, Integer.valueOf(i4)));
        Collections.sort(this.mRangeLengths, this.mRangeComparator);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, com.alibaba.android.vlayout.LayoutManagerHelper
    public void measureChild(View view, int i, int i2) {
        measureChildWithDecorations(view, i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager, com.alibaba.android.vlayout.LayoutManagerHelper
    public void measureChildWithMargins(View view, int i, int i2) {
        measureChildWithDecorationsAndMargin(view, i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void moveView(int i, int i2) {
        super.moveView(i, i2);
    }

    public int obtainExtraMargin(View view, boolean z) {
        return obtainExtraMargin(view, z, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (AbstractC3289a abstractC3289a : this.mHelperFinder.b()) {
            abstractC3289a.onOffsetChildrenHorizontal(i, this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (AbstractC3289a abstractC3289a : this.mHelperFinder.b()) {
            abstractC3289a.onOffsetChildrenVertical(i, this);
        }
        ViewLifeCycleHelper viewLifeCycleHelper = this.mViewLifeCycleHelper;
        if (viewLifeCycleHelper != null) {
            viewLifeCycleHelper.a();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        super.onAdapterChanged(adapter, adapter2);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public void onAnchorReady(RecyclerView.State state, ExposeLinearLayoutManagerEx.C3280a c3280a) {
        super.onAnchorReady(state, c3280a);
        boolean z = true;
        while (z) {
            C3286c c3286c = this.mTempAnchorInfoWrapper;
            int i = c3280a.a;
            c3286c.a = i;
            c3286c.b = c3280a.b;
            c3286c.c = c3280a.c;
            AbstractC3289a a = this.mHelperFinder.a(i);
            if (a != null) {
                a.checkAnchorInfo(state, this.mTempAnchorInfoWrapper, this);
            }
            C3286c c3286c2 = this.mTempAnchorInfoWrapper;
            int i2 = c3286c2.a;
            if (i2 == c3280a.a) {
                z = false;
            } else {
                c3280a.a = i2;
            }
            c3280a.b = c3286c2.b;
            c3286c2.a = -1;
        }
        C3286c c3286c3 = this.mTempAnchorInfoWrapper;
        c3286c3.a = c3280a.a;
        c3286c3.b = c3280a.b;
        for (AbstractC3289a abstractC3289a : this.mHelperFinder.b()) {
            abstractC3289a.onRefreshLayout(state, this.mTempAnchorInfoWrapper, this);
        }
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mRecyclerView = recyclerView;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        for (AbstractC3289a abstractC3289a : this.mHelperFinder.b()) {
            abstractC3289a.clear(this);
        }
        this.mRecyclerView = null;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public /* bridge */ /* synthetic */ View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.onFocusSearchFailed(view, i, recycler, state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        onItemsChanged(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        for (AbstractC3289a abstractC3289a : this.mHelperFinder.b()) {
            abstractC3289a.onItemsChanged(this);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        onItemsChanged(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        onItemsChanged(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2) {
        onItemsChanged(recyclerView);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 18) {
            Trace.beginSection(TRACE_LAYOUT);
        }
        if (this.mNoScrolling && state.didStructureChange()) {
            this.mSpaceMeasured = false;
            this.mSpaceMeasuring = true;
        }
        runPreLayout(recycler, state);
        try {
            try {
                super.onLayoutChildren(recycler, state);
                runPostLayout(recycler, state, Integer.MAX_VALUE);
                if ((this.mNestedScrolling || this.mNoScrolling) && this.mSpaceMeasuring) {
                    this.mSpaceMeasured = true;
                    View childAt = getChildAt(getChildCount() - 1);
                    if (childAt != null) {
                        this.mMeasuredFullSpace = getDecoratedBottom(childAt) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin + computeAlignOffset(childAt, true, false);
                        RecyclerView recyclerView = this.mRecyclerView;
                        if (recyclerView != null && this.mNestedScrolling) {
                            ViewParent parent = recyclerView.getParent();
                            if (parent instanceof View) {
                                this.mMeasuredFullSpace = Math.min(this.mMeasuredFullSpace, ((View) parent).getMeasuredHeight());
                            }
                        }
                    } else {
                        this.mSpaceMeasuring = false;
                    }
                    this.mSpaceMeasuring = false;
                    if (this.mRecyclerView != null && getItemCount() > 0) {
                        this.mRecyclerView.post(new Runnable() { // from class: com.alibaba.android.vlayout.VirtualLayoutManager.2
                            @Override // java.lang.Runnable
                            public void run() {
                                if (VirtualLayoutManager.this.mRecyclerView != null) {
                                    VirtualLayoutManager.this.mRecyclerView.requestLayout();
                                }
                            }
                        });
                    }
                }
                if (i >= 18) {
                    Trace.endSection();
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw e;
            }
        } catch (Throwable th) {
            runPostLayout(recycler, state, Integer.MAX_VALUE);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a1  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMeasure(androidx.recyclerview.widget.RecyclerView.Recycler r9, androidx.recyclerview.widget.RecyclerView.State r10, int r11, int r12) {
        /*
            r8 = this;
            boolean r0 = r8.mNoScrolling
            if (r0 != 0) goto Lc
            boolean r0 = r8.mNestedScrolling
            if (r0 != 0) goto Lc
            super.onMeasure(r9, r10, r11, r12)
            return
        Lc:
            androidx.recyclerview.widget.RecyclerView r0 = r8.mRecyclerView
            r1 = 134217727(0x7ffffff, float:3.8518597E-34)
            if (r0 == 0) goto L2b
            boolean r2 = r8.mNestedScrolling
            if (r2 == 0) goto L2b
            int r2 = r8.mMaxMeasureSize
            if (r2 <= 0) goto L1c
            goto L2e
        L1c:
            android.view.ViewParent r0 = r0.getParent()
            boolean r2 = r0 instanceof android.view.View
            if (r2 == 0) goto L2b
            android.view.View r0 = (android.view.View) r0
            int r2 = r0.getMeasuredHeight()
            goto L2e
        L2b:
            r2 = 134217727(0x7ffffff, float:3.8518597E-34)
        L2e:
            boolean r0 = r8.mSpaceMeasured
            if (r0 == 0) goto L34
            int r2 = r8.mMeasuredFullSpace
        L34:
            boolean r3 = r8.mNoScrolling
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L91
            r0 = r0 ^ r5
            r8.mSpaceMeasuring = r0
            int r0 = r8.getChildCount()
            if (r0 > 0) goto L5a
            int r0 = r8.getChildCount()
            int r3 = r8.getItemCount()
            if (r0 == r3) goto L4e
            goto L5a
        L4e:
            int r0 = r8.getItemCount()
            if (r0 != 0) goto L91
            r8.mSpaceMeasured = r5
            r8.mSpaceMeasuring = r4
            r2 = 0
            goto L91
        L5a:
            int r0 = r8.getChildCount()
            int r0 = r0 - r5
            android.view.View r0 = r8.getChildAt(r0)
            int r3 = r8.mMeasuredFullSpace
            if (r0 == 0) goto L79
            android.view.ViewGroup$LayoutParams r3 = r0.getLayoutParams()
            androidx.recyclerview.widget.RecyclerView$LayoutParams r3 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r3
            int r6 = r8.getDecoratedBottom(r0)
            int r3 = r3.bottomMargin
            int r6 = r6 + r3
            int r3 = r8.computeAlignOffset(r0, r5, r4)
            int r3 = r3 + r6
        L79:
            int r6 = r8.getChildCount()
            int r7 = r8.getItemCount()
            if (r6 != r7) goto L8c
            if (r0 == 0) goto L8a
            int r0 = r8.mMeasuredFullSpace
            if (r3 == r0) goto L8a
            goto L8c
        L8a:
            r1 = r2
            goto L90
        L8c:
            r8.mSpaceMeasured = r4
            r8.mSpaceMeasuring = r5
        L90:
            r2 = r1
        L91:
            int r0 = r8.getOrientation()
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r5) goto La1
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            super.onMeasure(r9, r10, r11, r12)
            goto La8
        La1:
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            super.onMeasure(r9, r10, r11, r12)
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.android.vlayout.VirtualLayoutManager.onMeasure(androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State, int, int):void");
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public /* bridge */ /* synthetic */ void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(parcelable);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState() {
        return super.onSaveInstanceState();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        super.onScrollStateChanged(i);
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        for (AbstractC3289a abstractC3289a : this.mHelperFinder.b()) {
            abstractC3289a.onScrollStateChanged(i, findFirstVisibleItemPosition, findLastVisibleItemPosition, this);
        }
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    protected void recycleChildren(RecyclerView.Recycler recycler, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (sDebuggable) {
            Log.d(TAG, "Recycling " + Math.abs(i - i2) + " items");
        }
        if (i2 > i) {
            View childAt = getChildAt(i2 - 1);
            int position = getPosition(getChildAt(i));
            int position2 = getPosition(childAt);
            int i3 = i;
            while (i < i2) {
                int position3 = getPosition(getChildAt(i3));
                if (position3 != -1) {
                    AbstractC3289a a = this.mHelperFinder.a(position3);
                    if (a == null || a.isRecyclable(position3, position, position2, this, true)) {
                        removeAndRecycleViewAt(i3, recycler);
                    } else {
                        i3++;
                    }
                } else {
                    removeAndRecycleViewAt(i3, recycler);
                }
                i++;
            }
            return;
        }
        View childAt2 = getChildAt(i);
        int position4 = getPosition(getChildAt(i2 + 1));
        int position5 = getPosition(childAt2);
        while (i > i2) {
            int position6 = getPosition(getChildAt(i));
            if (position6 != -1) {
                AbstractC3289a a2 = this.mHelperFinder.a(position6);
                if (a2 == null || a2.isRecyclable(position6, position4, position5, this, false)) {
                    removeAndRecycleViewAt(i, recycler);
                }
            } else {
                removeAndRecycleViewAt(i, recycler);
            }
            i--;
        }
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void recycleView(View view) {
        ViewParent parent;
        RecyclerView recyclerView;
        if (this.mRecyclerView == null || (parent = view.getParent()) == null || parent != (recyclerView = this.mRecyclerView)) {
            return;
        }
        this.mRecyclerView.getRecycledViewPool().putRecycledView(recyclerView.getChildViewHolder(view));
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void removeChildView(View view) {
        removeView(view);
    }

    public void runAdjustLayout() {
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        AbstractC3289a a = this.mHelperFinder.a(findFirstVisibleItemPosition);
        int findLastVisibleItemPosition = findLastVisibleItemPosition();
        AbstractC3289a a2 = this.mHelperFinder.a(findLastVisibleItemPosition);
        List<AbstractC3289a> b = this.mHelperFinder.b();
        int indexOf = b.indexOf(a2);
        for (int indexOf2 = b.indexOf(a); indexOf2 <= indexOf; indexOf2++) {
            try {
                b.get(indexOf2).adjustLayout(findFirstVisibleItemPosition, findLastVisibleItemPosition, this);
            } catch (Exception e) {
                if (sDebuggable) {
                    throw e;
                }
            }
        }
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public /* bridge */ /* synthetic */ int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    protected int scrollInternalBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(TRACE_SCROLL);
        }
        runPreLayout(recycler, state);
        int i2 = 0;
        try {
            try {
                if (!this.mNoScrolling) {
                    i = super.scrollInternalBy(i, recycler, state);
                } else {
                    if (getChildCount() != 0 && i != 0) {
                        ((ExposeLinearLayoutManagerEx) this).mLayoutState.mRecycle = true;
                        ensureLayoutStateExpose();
                        int i3 = i > 0 ? 1 : -1;
                        int abs = Math.abs(i);
                        updateLayoutStateExpose(i3, abs, true, state);
                        ExposeLinearLayoutManagerEx.C3282c c3282c = ((ExposeLinearLayoutManagerEx) this).mLayoutState;
                        int fill = c3282c.mScrollingOffset + fill(recycler, c3282c, state, false);
                        if (fill < 0) {
                            return 0;
                        }
                        if (abs > fill) {
                            i = i3 * fill;
                        }
                    }
                    return 0;
                }
                i2 = i;
            } catch (Exception e) {
                Log.w(TAG, Log.getStackTraceString(e), e);
                if (sDebuggable) {
                    throw e;
                }
            }
            if (Build.VERSION.SDK_INT >= 18) {
                Trace.endSection();
            }
            return i2;
        } finally {
            runPostLayout(recycler, state, 0);
        }
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        super.scrollToPosition(i);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public void scrollToPositionWithOffset(int i, int i2) {
        super.scrollToPositionWithOffset(i, i2);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public /* bridge */ /* synthetic */ int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return super.scrollVerticallyBy(i, recycler, state);
    }

    public void setCanScrollHorizontally(boolean z) {
        this.mCanScrollHorizontally = z;
    }

    public void setCanScrollVertically(boolean z) {
        this.mCanScrollVertically = z;
    }

    public void setEnableMarginOverlapping(boolean z) {
        this.mEnableMarginOverlapping = z;
    }

    public void setFixOffset(int i, int i2, int i3, int i4) {
        this.mFixAreaAdjustor = new wj0(i, i2, i3, i4);
    }

    public void setHelperFinder(@NonNull AbstractC3290b abstractC3290b) {
        if (abstractC3290b != null) {
            LinkedList linkedList = new LinkedList();
            AbstractC3290b abstractC3290b2 = this.mHelperFinder;
            if (abstractC3290b2 != null) {
                for (AbstractC3289a abstractC3289a : abstractC3290b2.b()) {
                    linkedList.add(abstractC3289a);
                }
            }
            this.mHelperFinder = abstractC3290b;
            if (linkedList.size() > 0) {
                this.mHelperFinder.d(linkedList);
            }
            this.mSpaceMeasured = false;
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("finder is null");
    }

    public void setLayoutHelpers(@Nullable List<AbstractC3289a> list) {
        BaseLayoutHelper.LayoutViewBindListener layoutViewBindListener;
        for (AbstractC3289a abstractC3289a : this.mHelperFinder.b()) {
            this.oldHelpersSet.put(Integer.valueOf(System.identityHashCode(abstractC3289a)), abstractC3289a);
        }
        if (list != null) {
            int i = 0;
            for (AbstractC3289a abstractC3289a2 : list) {
                if (abstractC3289a2 instanceof FixAreaLayoutHelper) {
                    ((FixAreaLayoutHelper) abstractC3289a2).a(this.mFixAreaAdjustor);
                }
                if ((abstractC3289a2 instanceof BaseLayoutHelper) && (layoutViewBindListener = this.mLayoutViewBindListener) != null) {
                    ((BaseLayoutHelper) abstractC3289a2).setLayoutViewBindListener(layoutViewBindListener);
                }
                if (abstractC3289a2.getItemCount() > 0) {
                    abstractC3289a2.setRange(i, (abstractC3289a2.getItemCount() + i) - 1);
                } else {
                    abstractC3289a2.setRange(-1, -1);
                }
                i += abstractC3289a2.getItemCount();
            }
        }
        this.mHelperFinder.d(list);
        for (AbstractC3289a abstractC3289a3 : this.mHelperFinder.b()) {
            this.newHelpersSet.put(Integer.valueOf(System.identityHashCode(abstractC3289a3)), abstractC3289a3);
        }
        Iterator<Map.Entry<Integer, AbstractC3289a>> it = this.oldHelpersSet.entrySet().iterator();
        while (it.hasNext()) {
            Integer key = it.next().getKey();
            if (this.newHelpersSet.containsKey(key)) {
                this.newHelpersSet.remove(key);
                it.remove();
            }
        }
        for (AbstractC3289a abstractC3289a4 : this.oldHelpersSet.values()) {
            abstractC3289a4.clear(this);
        }
        if (!this.oldHelpersSet.isEmpty() || !this.newHelpersSet.isEmpty()) {
            this.mSpaceMeasured = false;
        }
        this.oldHelpersSet.clear();
        this.newHelpersSet.clear();
        requestLayout();
    }

    public void setLayoutManagerCanScrollListener(LayoutManagerCanScrollListener layoutManagerCanScrollListener) {
        this.layoutManagerCanScrollListener = layoutManagerCanScrollListener;
    }

    public void setLayoutViewFactory(@NonNull LayoutViewFactory layoutViewFactory) {
        if (layoutViewFactory != null) {
            this.mLayoutViewFatory = layoutViewFactory;
            return;
        }
        throw new IllegalArgumentException("factory should not be null");
    }

    public void setNestedScrolling(boolean z) {
        setNestedScrolling(z, -1);
    }

    public void setNoScrolling(boolean z) {
        this.mNoScrolling = z;
        this.mSpaceMeasured = false;
        this.mMeasuredFullSpace = 0;
        this.mSpaceMeasuring = false;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager
    public void setOrientation(int i) {
        this.mOrientationHelper = AbstractC3291c.b(this, i);
        super.setOrientation(i);
    }

    public void setPerformanceMonitor(PerformanceMonitor performanceMonitor) {
        this.mPerformanceMonitor = performanceMonitor;
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    public /* bridge */ /* synthetic */ void setRecycleOffset(int i) {
        super.setRecycleOffset(i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setReverseLayout(boolean z) {
        if (!z) {
            super.setReverseLayout(false);
            return;
        }
        throw new UnsupportedOperationException("VirtualLayoutManager does not support reverse layout in current version.");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("VirtualLayoutManager does not support stack from end.");
    }

    public void setViewLifeCycleListener(@NonNull ViewLifeCycleListener viewLifeCycleListener) {
        if (viewLifeCycleListener != null) {
            this.mViewLifeCycleHelper = new ViewLifeCycleHelper(this, viewLifeCycleListener);
            return;
        }
        throw new IllegalArgumentException("ViewLifeCycleListener should not be null!");
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, com.alibaba.android.vlayout.LayoutManagerHelper
    public void showView(View view) {
        super.showView(view);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        super.smoothScrollToPosition(recyclerView, state, i);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mCurrentPendingSavedState == null;
    }

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALIDE_SIZE = Integer.MIN_VALUE;
        public float a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = Float.NaN;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.a = Float.NaN;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = Float.NaN;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = Float.NaN;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = Float.NaN;
        }
    }

    public VirtualLayoutManager(@NonNull Context context, int i) {
        this(context, i, false);
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addChildView(C3287d c3287d, View view) {
        addChildView(c3287d, view, c3287d.e() == 1 ? -1 : 0);
    }

    @Override // com.alibaba.android.vlayout.ExposeLinearLayoutManagerEx
    protected int computeAlignOffset(int i, boolean z, boolean z2) {
        AbstractC3289a a;
        if (i == -1 || (a = this.mHelperFinder.a(i)) == null) {
            return 0;
        }
        return a.computeAlignOffset(i - a.getRange().d().intValue(), z, z2, this);
    }

    public int obtainExtraMargin(View view, boolean z, boolean z2) {
        if (view != null) {
            return computeAlignOffset(view, z, z2);
        }
        return 0;
    }

    public void setNestedScrolling(boolean z, int i) {
        this.mNestedScrolling = z;
        this.mSpaceMeasured = false;
        this.mSpaceMeasuring = false;
        this.mMeasuredFullSpace = 0;
    }

    public VirtualLayoutManager(@NonNull Context context, int i, boolean z) {
        super(context, i, z);
        this.mNoScrolling = false;
        this.mNestedScrolling = false;
        this.mEnableMarginOverlapping = false;
        this.mMaxMeasureSize = -1;
        this.mRangeComparator = new C3284a(this);
        this.mFixAreaAdjustor = wj0.mDefaultAdjuster;
        this.newHelpersSet = new HashMap<>();
        this.oldHelpersSet = new HashMap<>();
        this.mTempAnchorInfoWrapper = new C3286c();
        this.mNested = 0;
        this.mTempLayoutStateWrapper = new C3287d();
        this.mRangeLengths = new ArrayList();
        this.mDefaultLayoutHelper = DEFAULT_LAYOUT_HELPER;
        this.mLayoutViewFatory = new C3285b(this);
        this.mDecorInsets = new Rect();
        this.mSpaceMeasured = false;
        this.mMeasuredFullSpace = 0;
        this.mSpaceMeasuring = false;
        this.mOrientationHelper = AbstractC3291c.b(this, i);
        this.mSecondaryOrientationHelper = AbstractC3291c.b(this, i != 1 ? 1 : 0);
        this.mCanScrollVertically = super.canScrollVertically();
        this.mCanScrollHorizontally = super.canScrollHorizontally();
        setHelperFinder(new C3294d());
    }

    @Override // com.alibaba.android.vlayout.LayoutManagerHelper
    public void addChildView(C3287d c3287d, View view, int i) {
        showView(view);
        if (!c3287d.i()) {
            addView(view, i);
        } else {
            addDisappearingView(view, i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new InflateLayoutParams(context, attributeSet);
    }
}
