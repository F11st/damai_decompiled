package com.taobao.uikit.feature.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.taobao.uikit.feature.callback.CanvasCallback;
import com.taobao.uikit.feature.callback.FocusCallback;
import com.taobao.uikit.feature.callback.InterceptTouchEventCallback;
import com.taobao.uikit.feature.callback.LayoutCallback;
import com.taobao.uikit.feature.callback.MeasureCallback;
import com.taobao.uikit.feature.callback.RecyclerAdapterCallback;
import com.taobao.uikit.feature.callback.ScrollCallback;
import com.taobao.uikit.feature.callback.TouchEventCallback;
import com.taobao.uikit.feature.features.AbsFeature;
import com.taobao.uikit.utils.FeatureList;
import com.taobao.uikit.utils.IFeatureList;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TRecyclerView extends RecyclerView implements ViewHelper, ViewGroupHelper, IFeatureList<RecyclerView> {
    public static final long ID_FOOTER = 2305843009213693952L;
    public static final long ID_HEADER = 1152921504606846976L;
    public static final int ITEM_VIEW_TYPE_HEADER_FOOTER = Integer.MIN_VALUE;
    private FeatureList<RecyclerView> mFeatureList;
    private ArrayList<View> mFooterViews;
    private GestureDetector mGestureDetector;
    private ArrayList<View> mHeaderViews;
    private OnItemClickListener mItemClickListener;
    private OnItemLongClickListener mItemLongClickListener;
    private List<RecyclerView.OnScrollListener> mOnScrollListeners;
    private RecyclerView.Adapter mRawAdapter;
    private List<RecyclerView.RecyclerListener> mRecyclerListeners;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class HeaderViewAdapter extends RecyclerView.Adapter implements Filterable {
        static final ArrayList<View> EMPTY_INFO_LIST = new ArrayList<>();
        private final RecyclerView.Adapter mAdapter;
        ArrayList<View> mFooterViews;
        ArrayList<View> mHeaderViews;
        private final boolean mIsFilterable;
        private final TRecyclerView mRecyclerView;

        public HeaderViewAdapter(ArrayList<View> arrayList, ArrayList<View> arrayList2, RecyclerView.Adapter adapter, TRecyclerView tRecyclerView) {
            this.mAdapter = adapter;
            this.mRecyclerView = tRecyclerView;
            this.mIsFilterable = adapter instanceof Filterable;
            if (arrayList == null) {
                this.mHeaderViews = EMPTY_INFO_LIST;
            } else {
                this.mHeaderViews = arrayList;
            }
            if (arrayList2 == null) {
                this.mFooterViews = EMPTY_INFO_LIST;
            } else {
                this.mFooterViews = arrayList2;
            }
            if (adapter != null) {
                super.setHasStableIds(adapter.hasStableIds());
            }
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            if (this.mIsFilterable) {
                return ((Filterable) this.mAdapter).getFilter();
            }
            return null;
        }

        public int getFootersCount() {
            return this.mFooterViews.size();
        }

        public int getHeadersCount() {
            return this.mHeaderViews.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int footersCount;
            int headersCount;
            if (this.mAdapter != null) {
                footersCount = getFootersCount() + getHeadersCount();
                headersCount = this.mAdapter.getItemCount();
            } else {
                footersCount = getFootersCount();
                headersCount = getHeadersCount();
            }
            return footersCount + headersCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            int i2;
            int headersCount = getHeadersCount();
            int footersCount = getFootersCount();
            if (i < headersCount) {
                return i + 1152921504606846976L;
            }
            if (i >= getItemCount() - footersCount) {
                int i3 = i - headersCount;
                RecyclerView.Adapter adapter = this.mAdapter;
                return (i3 + 2305843009213693952L) - (adapter != null ? adapter.getItemCount() : 0);
            }
            RecyclerView.Adapter adapter2 = this.mAdapter;
            if (adapter2 == null || i < headersCount || (i2 = i - headersCount) >= adapter2.getItemCount()) {
                return -1L;
            }
            return this.mAdapter.getItemId(i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            int i2;
            int headersCount = getHeadersCount();
            RecyclerView.Adapter adapter = this.mAdapter;
            if (adapter == null || i < headersCount || (i2 = i - headersCount) >= adapter.getItemCount()) {
                return Integer.MIN_VALUE;
            }
            return this.mAdapter.getItemViewType(i2);
        }

        public RecyclerView.Adapter getWrappedAdapter() {
            return this.mAdapter;
        }

        public boolean isEmpty() {
            RecyclerView.Adapter adapter = this.mAdapter;
            return adapter == null || adapter.getItemCount() == 0;
        }

        public void onAttachedHeaderOrFooter(RecyclerView.ViewHolder viewHolder) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            RecyclerView.Adapter adapter = this.mAdapter;
            if (adapter != null) {
                adapter.onAttachedToRecyclerView(recyclerView);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            int headersCount = getHeadersCount();
            int footersCount = getFootersCount();
            if (i >= headersCount && i < getItemCount() - footersCount) {
                int i2 = i - headersCount;
                RecyclerView.Adapter adapter = this.mAdapter;
                if (adapter != null) {
                    adapter.onBindViewHolder(viewHolder, i2);
                    return;
                }
                return;
            }
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) viewHolder;
            headerViewHolder.mContainer.removeAllViews();
            if (i < headersCount) {
                View view = this.mHeaderViews.get(i);
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                headerViewHolder.mContainer.addView(view);
            } else {
                int i3 = i - headersCount;
                RecyclerView.Adapter adapter2 = this.mAdapter;
                View view2 = this.mFooterViews.get(i3 - (adapter2 != null ? adapter2.getItemCount() : 0));
                if (view2.getParent() != null) {
                    ((ViewGroup) view2.getParent()).removeView(view2);
                }
                headerViewHolder.mContainer.addView(view2);
            }
            ViewGroup.LayoutParams layoutParams = headerViewHolder.itemView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = this.mRecyclerView.getLayoutManager().generateDefaultLayoutParams();
                headerViewHolder.itemView.setLayoutParams(layoutParams);
            }
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            } else if (layoutParams instanceof RecyclerView.LayoutParams) {
                int orientation = this.mRecyclerView.getOrientation();
                layoutParams.width = 1 == orientation ? -1 : -2;
                layoutParams.height = 1 == orientation ? -2 : -1;
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i != Integer.MIN_VALUE) {
                RecyclerView.Adapter adapter = this.mAdapter;
                if (adapter != null) {
                    return adapter.onCreateViewHolder(viewGroup, i);
                }
                return null;
            }
            return new HeaderViewHolder(new FrameLayout(this.mRecyclerView.getContext()));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
            RecyclerView.Adapter adapter = this.mAdapter;
            if (adapter != null) {
                adapter.onDetachedFromRecyclerView(recyclerView);
            }
        }

        public void onDetachedHeaderOrFooter(RecyclerView.ViewHolder viewHolder) {
        }

        public boolean onFailedHeaderOrFooter(RecyclerView.ViewHolder viewHolder) {
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
            if (this.mAdapter != null && viewHolder != null) {
                if (viewHolder.getItemViewType() == Integer.MIN_VALUE) {
                    return onFailedHeaderOrFooter(viewHolder);
                }
                return this.mAdapter.onFailedToRecycleView(viewHolder);
            }
            return super.onFailedToRecycleView(viewHolder);
        }

        public void onRecycledHeaderOrFooter(RecyclerView.ViewHolder viewHolder) {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            if (this.mAdapter == null || viewHolder == null) {
                return;
            }
            if (viewHolder.getItemViewType() == Integer.MIN_VALUE) {
                onAttachedHeaderOrFooter(viewHolder);
            } else {
                this.mAdapter.onViewAttachedToWindow(viewHolder);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            if (this.mAdapter == null || viewHolder == null) {
                return;
            }
            if (viewHolder.getItemViewType() == Integer.MIN_VALUE) {
                onDetachedHeaderOrFooter(viewHolder);
            } else {
                this.mAdapter.onViewDetachedFromWindow(viewHolder);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            if (this.mAdapter == null || viewHolder == null) {
                return;
            }
            if (viewHolder.getItemViewType() == Integer.MIN_VALUE) {
                onRecycledHeaderOrFooter(viewHolder);
            } else {
                this.mAdapter.onViewRecycled(viewHolder);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            RecyclerView.Adapter adapter = this.mAdapter;
            if (adapter != null) {
                adapter.registerAdapterDataObserver(adapterDataObserver);
            }
            super.registerAdapterDataObserver(adapterDataObserver);
        }

        public boolean removeFooter(View view) {
            int size = this.mFooterViews.size();
            for (int i = 0; i < size; i++) {
                if (this.mFooterViews.get(i) == view) {
                    this.mFooterViews.remove(i);
                    return true;
                }
            }
            return false;
        }

        public boolean removeHeader(View view) {
            int size = this.mHeaderViews.size();
            for (int i = 0; i < size; i++) {
                if (this.mHeaderViews.get(i) == view) {
                    this.mHeaderViews.remove(i);
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            RecyclerView.Adapter adapter = this.mAdapter;
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(adapterDataObserver);
            }
            super.unregisterAdapterDataObserver(adapterDataObserver);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public final FrameLayout mContainer;

        public HeaderViewHolder(View view) {
            super(view);
            this.mContainer = (FrameLayout) view;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class InnerOnScrollListener extends RecyclerView.OnScrollListener {
        InnerOnScrollListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int size = TRecyclerView.this.mOnScrollListeners.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView.OnScrollListener onScrollListener = (RecyclerView.OnScrollListener) TRecyclerView.this.mOnScrollListeners.get(i2);
                if (onScrollListener != null) {
                    onScrollListener.onScrollStateChanged(recyclerView, i);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int size = TRecyclerView.this.mOnScrollListeners.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((RecyclerView.OnScrollListener) TRecyclerView.this.mOnScrollListeners.get(i3)).onScrolled(recyclerView, i, i2);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    class InnerRecyclerListener implements RecyclerView.RecyclerListener {
        InnerRecyclerListener() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.RecyclerListener
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            int size = TRecyclerView.this.mRecyclerListeners.size();
            for (int i = 0; i < size; i++) {
                RecyclerView.RecyclerListener recyclerListener = (RecyclerView.RecyclerListener) TRecyclerView.this.mRecyclerListeners.get(i);
                if (recyclerListener != null) {
                    recyclerListener.onViewRecycled(viewHolder);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static abstract class ItemClickGestureListener extends GestureDetector.SimpleOnGestureListener {
        private final TRecyclerView mHostView;
        private View mTargetChild;

        public ItemClickGestureListener(TRecyclerView tRecyclerView) {
            this.mHostView = tRecyclerView;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            View findChildViewUnder = this.mHostView.findChildViewUnder((int) motionEvent.getX(), (int) motionEvent.getY());
            this.mTargetChild = findChildViewUnder;
            return findChildViewUnder != null;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View view = this.mTargetChild;
            if (view == null) {
                return;
            }
            int childPosition = this.mHostView.getChildPosition(view);
            if (!this.mHostView.isHeaderOrFooter(childPosition) ? performItemLongClick(this.mHostView, this.mTargetChild, childPosition - this.mHostView.getHeaderViewsCount(), this.mHostView.getAdapter().getItemId(childPosition)) : false) {
                this.mTargetChild.setPressed(false);
                this.mTargetChild = null;
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            View view = this.mTargetChild;
            if (view != null) {
                view.setPressed(false);
                this.mTargetChild = null;
                return true;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            View view = this.mTargetChild;
            if (view != null) {
                view.setPressed(true);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            View view = this.mTargetChild;
            if (view != null) {
                view.setPressed(false);
                int childPosition = this.mHostView.getChildPosition(this.mTargetChild);
                r0 = this.mHostView.isHeaderOrFooter(childPosition) ? false : performItemClick(this.mHostView, this.mTargetChild, childPosition - this.mHostView.getHeaderViewsCount(), this.mHostView.getAdapter().getItemId(childPosition));
                this.mTargetChild = null;
            }
            return r0;
        }

        abstract boolean performItemClick(TRecyclerView tRecyclerView, View view, int i, long j);

        abstract boolean performItemLongClick(TRecyclerView tRecyclerView, View view, int i, long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnItemClickListener {
        void onItemClick(TRecyclerView tRecyclerView, View view, int i, long j);
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public interface OnItemLongClickListener {
        boolean onItemLongClick(TRecyclerView tRecyclerView, View view, int i, long j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public class SpanSizeLookupCompat extends GridLayoutManager.SpanSizeLookup {
        private final GridLayoutManager.SpanSizeLookup mSpanSizeLookup;

        public SpanSizeLookupCompat(GridLayoutManager.SpanSizeLookup spanSizeLookup) {
            this.mSpanSizeLookup = spanSizeLookup;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanGroupIndex(int i, int i2) {
            GridLayoutManager.SpanSizeLookup spanSizeLookup;
            if (TRecyclerView.this.isHeaderOrFooter(i) || (spanSizeLookup = this.mSpanSizeLookup) == null) {
                return 0;
            }
            return spanSizeLookup.getSpanGroupIndex(i - TRecyclerView.this.getHeaderViewsCount(), i2);
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int i, int i2) {
            GridLayoutManager.SpanSizeLookup spanSizeLookup;
            if (TRecyclerView.this.isHeaderOrFooter(i) || (spanSizeLookup = this.mSpanSizeLookup) == null) {
                return 0;
            }
            return spanSizeLookup.getSpanIndex(i - TRecyclerView.this.getHeaderViewsCount(), i2);
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            if (TRecyclerView.this.isHeaderOrFooter(i)) {
                return ((GridLayoutManager) TRecyclerView.this.getLayoutManager()).getSpanCount();
            }
            GridLayoutManager.SpanSizeLookup spanSizeLookup = this.mSpanSizeLookup;
            if (spanSizeLookup != null) {
                return spanSizeLookup.getSpanSize(i - TRecyclerView.this.getHeaderViewsCount());
            }
            return 1;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public void invalidateSpanIndexCache() {
            GridLayoutManager.SpanSizeLookup spanSizeLookup = this.mSpanSizeLookup;
            if (spanSizeLookup != null) {
                spanSizeLookup.invalidateSpanIndexCache();
            } else {
                super.invalidateSpanIndexCache();
            }
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public boolean isSpanIndexCacheEnabled() {
            GridLayoutManager.SpanSizeLookup spanSizeLookup = this.mSpanSizeLookup;
            if (spanSizeLookup != null) {
                return spanSizeLookup.isSpanIndexCacheEnabled();
            }
            return super.isSpanIndexCacheEnabled();
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public void setSpanIndexCacheEnabled(boolean z) {
            GridLayoutManager.SpanSizeLookup spanSizeLookup = this.mSpanSizeLookup;
            if (spanSizeLookup != null) {
                spanSizeLookup.setSpanIndexCacheEnabled(z);
            } else {
                super.setSpanIndexCacheEnabled(z);
            }
        }
    }

    public TRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFeatureList = new FeatureList<>(this);
        this.mOnScrollListeners = new ArrayList();
        this.mRecyclerListeners = new ArrayList();
        this.mHeaderViews = new ArrayList<>();
        this.mFooterViews = new ArrayList<>();
        super.setOnScrollListener(new InnerOnScrollListener());
        super.setRecyclerListener(new InnerRecyclerListener());
        this.mFeatureList.init(context, attributeSet, i);
    }

    private void addGestureDetectorIfNeed() {
        if (this.mGestureDetector == null) {
            this.mGestureDetector = new GestureDetector(getContext(), new ItemClickGestureListener(this) { // from class: com.taobao.uikit.feature.view.TRecyclerView.1
                @Override // com.taobao.uikit.feature.view.TRecyclerView.ItemClickGestureListener
                boolean performItemClick(TRecyclerView tRecyclerView, View view, int i, long j) {
                    if (TRecyclerView.this.mItemClickListener != null) {
                        TRecyclerView.this.mItemClickListener.onItemClick(tRecyclerView, view, i, j);
                        return true;
                    }
                    return false;
                }

                @Override // com.taobao.uikit.feature.view.TRecyclerView.ItemClickGestureListener
                boolean performItemLongClick(TRecyclerView tRecyclerView, View view, int i, long j) {
                    return TRecyclerView.this.mItemLongClickListener != null && TRecyclerView.this.mItemLongClickListener.onItemLongClick(tRecyclerView, view, i, j);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isHeaderOrFooter(int i) {
        return getAdapter() == null || i < getHeaderViewsCount() || i >= getAdapter().getItemCount() - getFooterViewsCount();
    }

    private void removeFixedViewInfo(View view, ArrayList<View> arrayList) {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (arrayList.get(i) == view) {
                arrayList.remove(i);
                return;
            }
        }
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public boolean addFeature(AbsFeature<? super RecyclerView> absFeature) {
        return this.mFeatureList.addFeature(absFeature);
    }

    public void addFooterView(View view) {
        addFooterView(this.mFooterViews.size(), view);
    }

    public void addHeaderView(View view) {
        addHeaderView(this.mHeaderViews.size(), view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        if (onScrollListener == null) {
            return;
        }
        if (this.mOnScrollListeners == null) {
            this.mOnScrollListeners = new ArrayList();
        }
        this.mOnScrollListeners.add(onScrollListener);
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public void clearFeatures() {
        this.mFeatureList.clearFeatures();
    }

    @Override // android.view.View
    public void computeScroll() {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof ScrollCallback) {
                ((ScrollCallback) absFeature).beforeComputeScroll();
            }
        }
        super.computeScroll();
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof ScrollCallback) {
                ((ScrollCallback) absFeature2).afterComputeScroll();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof CanvasCallback) {
                ((CanvasCallback) absFeature).beforeDispatchDraw(canvas);
            }
        }
        super.dispatchDraw(canvas);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof CanvasCallback) {
                ((CanvasCallback) absFeature2).afterDispatchDraw(canvas);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof TouchEventCallback) {
                ((TouchEventCallback) absFeature).beforeDispatchTouchEvent(motionEvent);
            }
        }
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof TouchEventCallback) {
                ((TouchEventCallback) absFeature2).afterDispatchTouchEvent(motionEvent);
            }
        }
        return dispatchTouchEvent;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas canvas) {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof CanvasCallback) {
                ((CanvasCallback) absFeature).beforeDraw(canvas);
            }
        }
        super.draw(canvas);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof CanvasCallback) {
                ((CanvasCallback) absFeature2).afterDraw(canvas);
            }
        }
    }

    @Override // com.taobao.uikit.feature.view.ViewGroupHelper
    public boolean drawChild(Canvas canvas, View view, long j, int i) {
        return super.drawChild(canvas, view, j);
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public AbsFeature<? super RecyclerView> findFeature(Class<? extends AbsFeature<? super RecyclerView>> cls) {
        return this.mFeatureList.findFeature(cls);
    }

    public int getFooterViewsCount() {
        return this.mFooterViews.size();
    }

    public int getHeaderViewsCount() {
        return this.mHeaderViews.size();
    }

    public int getHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int getItemCount() {
        return (getTotalCount() - getHeaderViewsCount()) - getFooterViewsCount();
    }

    public int getOrientation() {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) layoutManager).getOrientation();
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) layoutManager).getOrientation();
        }
        return 1;
    }

    public RecyclerView.Adapter getRawAdapter() {
        return this.mRawAdapter;
    }

    public int getTotalCount() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            return 0;
        }
        return adapter.getItemCount();
    }

    public int getVerticalScrollOffset() {
        return super.computeVerticalScrollOffset();
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public void init(Context context, AttributeSet attributeSet, int i) {
        this.mFeatureList.init(context, attributeSet, i);
    }

    @Override // com.taobao.uikit.feature.view.ViewGroupHelper
    public void measureChild(View view, int i, int i2, int i3) {
        super.measureChild(view, i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof CanvasCallback) {
                ((CanvasCallback) absFeature).beforeOnDraw(canvas);
            }
        }
        super.onDraw(canvas);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof CanvasCallback) {
                ((CanvasCallback) absFeature2).afterOnDraw(canvas);
            }
        }
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        int size = this.mFeatureList.size();
        for (int i2 = 0; i2 < size; i2++) {
            AbsFeature absFeature = this.mFeatureList.get(i2);
            if (absFeature instanceof FocusCallback) {
                ((FocusCallback) absFeature).beforeOnFocusChanged(z, i, rect);
            }
        }
        super.onFocusChanged(z, i, rect);
        for (int i3 = size - 1; i3 >= 0; i3--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i3);
            if (absFeature2 instanceof FocusCallback) {
                ((FocusCallback) absFeature2).afterOnFocusChanged(z, i, rect);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        for (int size = this.mFeatureList.size() - 1; size >= 0; size--) {
            AbsFeature absFeature = this.mFeatureList.get(size);
            if (absFeature instanceof InterceptTouchEventCallback) {
                onInterceptTouchEvent |= ((InterceptTouchEventCallback) absFeature).onInterceptTouchEvent(motionEvent);
            }
        }
        return onInterceptTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int size = this.mFeatureList.size();
        for (int i5 = 0; i5 < size; i5++) {
            AbsFeature absFeature = this.mFeatureList.get(i5);
            if (absFeature instanceof LayoutCallback) {
                ((LayoutCallback) absFeature).beforeOnLayout(z, i, i2, i3, i4);
            }
        }
        super.onLayout(z, i, i2, i3, i4);
        for (int i6 = size - 1; i6 >= 0; i6--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i6);
            if (absFeature2 instanceof LayoutCallback) {
                ((LayoutCallback) absFeature2).afterOnLayout(z, i, i2, i3, i4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = this.mFeatureList.size();
        for (int i3 = 0; i3 < size; i3++) {
            AbsFeature absFeature = this.mFeatureList.get(i3);
            if (absFeature instanceof MeasureCallback) {
                ((MeasureCallback) absFeature).beforeOnMeasure(i, i2);
            }
        }
        super.onMeasure(i, i2);
        for (int i4 = size - 1; i4 >= 0; i4--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i4);
            if (absFeature2 instanceof MeasureCallback) {
                ((MeasureCallback) absFeature2).afterOnMeasure(i, i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof TouchEventCallback) {
                ((TouchEventCallback) absFeature).beforeOnTouchEvent(motionEvent);
            }
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        GestureDetector gestureDetector = this.mGestureDetector;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof TouchEventCallback) {
                ((TouchEventCallback) absFeature2).afterOnTouchEvent(motionEvent);
            }
        }
        return onTouchEvent;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof FocusCallback) {
                ((FocusCallback) absFeature).beforeOnWindowFocusChanged(z);
            }
        }
        super.onWindowFocusChanged(z);
        for (int i2 = size - 1; i2 >= 0; i2--) {
            AbsFeature absFeature2 = this.mFeatureList.get(i2);
            if (absFeature2 instanceof FocusCallback) {
                ((FocusCallback) absFeature2).afterOnWindowFocusChanged(z);
            }
        }
    }

    @Override // com.taobao.uikit.utils.IFeatureList
    public boolean removeFeature(Class<? extends AbsFeature<? super RecyclerView>> cls) {
        return this.mFeatureList.removeFeature(cls);
    }

    public final boolean removeFooterView(View view) {
        boolean z = false;
        if (this.mFooterViews.size() > 0) {
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null && ((HeaderViewAdapter) adapter).removeFooter(view)) {
                adapter.notifyDataSetChanged();
                z = true;
            }
            removeFixedViewInfo(view, this.mFooterViews);
        }
        return z;
    }

    public final boolean removeHeaderView(View view) {
        boolean z = false;
        if (this.mHeaderViews.size() > 0) {
            RecyclerView.Adapter adapter = getAdapter();
            if (adapter != null && ((HeaderViewAdapter) adapter).removeHeader(view)) {
                adapter.notifyDataSetChanged();
                z = true;
            }
            removeFixedViewInfo(view, this.mHeaderViews);
        }
        return z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void removeOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        if (onScrollListener == null) {
            return;
        }
        this.mOnScrollListeners.remove(onScrollListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void removeRecyclerListener(RecyclerView.RecyclerListener recyclerListener) {
        if (recyclerListener == null) {
            return;
        }
        this.mRecyclerListeners.remove(recyclerListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        if (adapter instanceof HeaderViewAdapter) {
            this.mRawAdapter = ((HeaderViewAdapter) adapter).getWrappedAdapter();
        } else if (this.mRawAdapter == null) {
            this.mRawAdapter = adapter;
        }
        int size = this.mFeatureList.size();
        for (int i = 0; i < size; i++) {
            AbsFeature absFeature = this.mFeatureList.get(i);
            if (absFeature instanceof RecyclerAdapterCallback) {
                if (adapter instanceof HeaderViewAdapter) {
                    adapter = ((RecyclerAdapterCallback) absFeature).wrapAdapter(((HeaderViewAdapter) adapter).getWrappedAdapter());
                } else {
                    adapter = ((RecyclerAdapterCallback) absFeature).wrapAdapter(adapter);
                }
            }
        }
        if (adapter != null && !(adapter instanceof HeaderViewAdapter) && (this.mHeaderViews.size() > 0 || this.mFooterViews.size() > 0)) {
            super.setAdapter(new HeaderViewAdapter(this.mHeaderViews, this.mFooterViews, adapter, this));
        } else {
            super.setAdapter(adapter);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        GridLayoutManager gridLayoutManager;
        GridLayoutManager.SpanSizeLookup spanSizeLookup;
        if ((layoutManager instanceof GridLayoutManager) && ((this.mHeaderViews.size() > 0 || this.mFooterViews.size() > 0) && ((spanSizeLookup = (gridLayoutManager = (GridLayoutManager) layoutManager).getSpanSizeLookup()) == null || !(spanSizeLookup instanceof SpanSizeLookupCompat)))) {
            gridLayoutManager.setSpanSizeLookup(new SpanSizeLookupCompat(spanSizeLookup));
        }
        super.setLayoutManager(layoutManager);
    }

    @Override // com.taobao.uikit.feature.view.ViewHelper
    public void setMeasuredDimension(long j, long j2) {
        super.setMeasuredDimension((int) j, (int) j2);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
        if (onItemClickListener != null) {
            addGestureDetectorIfNeed();
        }
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        if (!isLongClickable()) {
            setLongClickable(true);
        }
        this.mItemLongClickListener = onItemLongClickListener;
        if (onItemLongClickListener != null) {
            addGestureDetectorIfNeed();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    @Deprecated
    public void setOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        if (onScrollListener == null) {
            return;
        }
        if (this.mOnScrollListeners == null) {
            this.mOnScrollListeners = new ArrayList();
        }
        this.mOnScrollListeners.add(onScrollListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setRecyclerListener(RecyclerView.RecyclerListener recyclerListener) {
        this.mRecyclerListeners.add(recyclerListener);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void swapAdapter(RecyclerView.Adapter adapter, boolean z) {
        if (adapter != null && !(adapter instanceof HeaderViewAdapter) && (this.mHeaderViews.size() > 0 || this.mFooterViews.size() > 0)) {
            super.swapAdapter(new HeaderViewAdapter(this.mHeaderViews, this.mFooterViews, adapter, this), z);
        } else {
            super.swapAdapter(adapter, z);
        }
    }

    public void addFooterView(int i, View view) {
        this.mFooterViews.add(i, view);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            if (!(adapter instanceof HeaderViewAdapter)) {
                setAdapter(new HeaderViewAdapter(this.mHeaderViews, this.mFooterViews, adapter, this));
            } else {
                adapter.notifyDataSetChanged();
            }
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null) {
            setLayoutManager(layoutManager);
        }
    }

    public void addHeaderView(int i, View view) {
        this.mHeaderViews.add(i, view);
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter != null) {
            if (!(adapter instanceof HeaderViewAdapter)) {
                setAdapter(new HeaderViewAdapter(this.mHeaderViews, this.mFooterViews, adapter, this));
            } else {
                adapter.notifyDataSetChanged();
            }
        }
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager != null) {
            setLayoutManager(layoutManager);
        }
    }

    public TRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TRecyclerView(Context context) {
        this(context, null);
    }
}
