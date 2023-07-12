package com.youku.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.youku.resource.R;
import com.youku.resource.widget.YKPageFooter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class XRecyclerView extends RecyclerView implements GestureDetector.OnGestureListener {
    private static final float DRAG_RATE = 2.0f;
    public static final int HEADER_INIT_INDEX = 10000;
    public static final int TYPE_FOOTER = -3;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_REFRESH_HEADER = -5;
    private static List<Integer> sHeaderTypes = new ArrayList();
    private final String TAG;
    private boolean isLoadingData;
    private boolean isNoMore;
    private boolean loadingMoreEnabled;
    private final RecyclerView.AdapterDataObserver mDataObserver;
    private View mEmptyView;
    private ArrayList<View> mFootViews;
    private ArrayList<View> mHeaderViews;
    private float mLastY;
    private LoadingListener mLoadingListener;
    private LoadingListenerExtra mLoadingListenerExtra;
    private int mPageCount;
    private BaseRefreshHeader mRefreshHeader;
    private RecyclerView.Adapter mWrapAdapter;
    private int preloadItemNumber;
    private boolean pullRefreshEnabled;
    private GridLayoutManager.SpanSizeLookup spanSizeLookup;
    private XonGestureListener xonGestureListener;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private class DataObserver extends RecyclerView.AdapterDataObserver {
        private DataObserver() {
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [boolean, int] */
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            RecyclerView.Adapter adapter = XRecyclerView.this.getAdapter();
            if (adapter != null && XRecyclerView.this.mEmptyView != null) {
                ?? r1 = XRecyclerView.this.pullRefreshEnabled;
                int i = r1;
                if (XRecyclerView.this.loadingMoreEnabled) {
                    i = r1 + 1;
                }
                if (adapter.getItemCount() == i) {
                    XRecyclerView.this.mEmptyView.setVisibility(0);
                    XRecyclerView.this.setVisibility(8);
                } else {
                    XRecyclerView.this.mEmptyView.setVisibility(8);
                    XRecyclerView.this.setVisibility(0);
                }
            }
            if (XRecyclerView.this.mWrapAdapter != null) {
                XRecyclerView.this.mWrapAdapter.notifyDataSetChanged();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            onItemRangeChanged(i, i2, null);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            XRecyclerView.this.mWrapAdapter.notifyItemRangeInserted(i + XRecyclerView.this.mHeaderViews.size(), i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            XRecyclerView.this.mWrapAdapter.notifyItemMoved(i + XRecyclerView.this.mHeaderViews.size(), i2 + XRecyclerView.this.mHeaderViews.size());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            XRecyclerView.this.mWrapAdapter.notifyItemRangeRemoved(i + XRecyclerView.this.mHeaderViews.size(), i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2, Object obj) {
            XRecyclerView.this.mWrapAdapter.notifyItemRangeChanged(i + XRecyclerView.this.mHeaderViews.size(), i2, obj);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface LoadingListener {
        void onLoadMore();

        void onRefresh();
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private class WrapAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private RecyclerView.Adapter adapter;
        private int headerPosition = 1;
        private int mCurrentPosition;

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        private class SimpleViewHolder extends RecyclerView.ViewHolder {
            public SimpleViewHolder(View view) {
                super(view);
            }
        }

        public WrapAdapter(RecyclerView.Adapter adapter) {
            this.adapter = adapter;
            setHasStableIds(adapter.hasStableIds());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAdapterObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            this.adapter.unregisterAdapterDataObserver(adapterDataObserver);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAdapterObserver(RecyclerView.AdapterDataObserver adapterDataObserver) {
            this.adapter.registerAdapterDataObserver(adapterDataObserver);
        }

        public int getFootersCount() {
            return XRecyclerView.this.mFootViews.size();
        }

        public int getHeadersCount() {
            return XRecyclerView.this.mHeaderViews.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int headersCount;
            int footersCount;
            if (this.adapter != null) {
                headersCount = getHeadersCount() + getFootersCount();
                footersCount = this.adapter.getItemCount();
            } else {
                headersCount = getHeadersCount();
                footersCount = getFootersCount();
            }
            return headersCount + footersCount;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public long getItemId(int i) {
            int headersCount;
            if (this.adapter == null || i < getHeadersCount() || (headersCount = i - getHeadersCount()) >= this.adapter.getItemCount()) {
                return -1L;
            }
            return this.adapter.getItemId(headersCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemViewType(int i) {
            if (isRefreshHeader(i)) {
                return -5;
            }
            if (isHeader(i)) {
                return ((Integer) XRecyclerView.sHeaderTypes.get(i - 1)).intValue();
            } else if (isFooter(i)) {
                return -3;
            } else {
                int headersCount = i - getHeadersCount();
                RecyclerView.Adapter adapter = this.adapter;
                if (adapter == null || headersCount >= adapter.getItemCount()) {
                    return 0;
                }
                return this.adapter.getItemViewType(headersCount);
            }
        }

        public boolean isContentHeader(int i) {
            return i >= 1 && i < XRecyclerView.this.mHeaderViews.size();
        }

        public boolean isFooter(int i) {
            return i < getItemCount() && i >= getItemCount() - XRecyclerView.this.mFootViews.size();
        }

        public boolean isHeader(int i) {
            return i >= 0 && i < XRecyclerView.this.mHeaderViews.size();
        }

        public boolean isRefreshHeader(int i) {
            return i == 0;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.youku.widget.XRecyclerView.WrapAdapter.1
                    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                    public int getSpanSize(int i) {
                        int spanCount = gridLayoutManager.getSpanCount();
                        if (XRecyclerView.this.spanSizeLookup != null) {
                            int headersCount = i - WrapAdapter.this.getHeadersCount();
                            if (WrapAdapter.this.adapter != null && headersCount < WrapAdapter.this.adapter.getItemCount()) {
                                spanCount = XRecyclerView.this.spanSizeLookup.getSpanSize(headersCount);
                            }
                        }
                        if (!WrapAdapter.this.isHeader(i) && !WrapAdapter.this.isFooter(i)) {
                            if (XRecyclerView.this.spanSizeLookup == null) {
                                return 1;
                            }
                            return spanCount;
                        }
                        return gridLayoutManager.getSpanCount();
                    }
                });
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (isHeader(i)) {
                return;
            }
            int headersCount = i - getHeadersCount();
            RecyclerView.Adapter adapter = this.adapter;
            if (adapter == null || headersCount >= adapter.getItemCount()) {
                return;
            }
            this.adapter.onBindViewHolder(viewHolder, headersCount);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == -5) {
                this.mCurrentPosition++;
                return new SimpleViewHolder((View) XRecyclerView.this.mHeaderViews.get(0));
            }
            if (isContentHeader(this.mCurrentPosition)) {
                if (i == ((Integer) XRecyclerView.sHeaderTypes.get(this.mCurrentPosition - 1)).intValue()) {
                    this.mCurrentPosition++;
                    ArrayList arrayList = XRecyclerView.this.mHeaderViews;
                    int i2 = this.headerPosition;
                    this.headerPosition = i2 + 1;
                    return new SimpleViewHolder((View) arrayList.get(i2));
                }
            } else if (i == -3) {
                if (XRecyclerView.this.mFootViews.get(0) instanceof LoadingMoreFooter_Logo) {
                    ViewGroup.LayoutParams layoutParams = ((View) XRecyclerView.this.mFootViews.get(0)).getLayoutParams();
                    layoutParams.height = XRecyclerView.this.getResources().getDimensionPixelOffset(R.dimen.home_card_item_box_title_layout_height);
                    ((View) XRecyclerView.this.mFootViews.get(0)).setLayoutParams(layoutParams);
                }
                return new SimpleViewHolder((View) XRecyclerView.this.mFootViews.get(0));
            }
            return this.adapter.onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
            RecyclerView.Adapter adapter;
            super.onViewAttachedToWindow(viewHolder);
            ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
            if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) && (isHeader(viewHolder.getLayoutPosition()) || isFooter(viewHolder.getLayoutPosition()))) {
                ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
            }
            if (viewHolder.getItemViewType() == -5 || viewHolder.getItemViewType() == -3 || XRecyclerView.sHeaderTypes.contains(Integer.valueOf(viewHolder.getItemViewType())) || (adapter = this.adapter) == null) {
                return;
            }
            adapter.onViewAttachedToWindow(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
            RecyclerView.Adapter adapter;
            super.onViewDetachedFromWindow(viewHolder);
            if (viewHolder.getItemViewType() == -5 || viewHolder.getItemViewType() == -3 || XRecyclerView.sHeaderTypes.contains(Integer.valueOf(viewHolder.getItemViewType())) || (adapter = this.adapter) == null) {
                return;
            }
            adapter.onViewDetachedFromWindow(viewHolder);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
            if (viewHolder instanceof SimpleViewHolder) {
                super.onViewRecycled(viewHolder);
            } else {
                this.adapter.onViewRecycled(viewHolder);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface XonGestureListener {
        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2);
    }

    public XRecyclerView(Context context) {
        this(context, null);
    }

    private int findMax(int[] iArr) {
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    private int findMin(int[] iArr) {
        int i = iArr[0];
        for (int i2 : iArr) {
            if (i2 < i) {
                i = i2;
            }
        }
        return i;
    }

    private void init() {
        addFootView(new YKPageFooter(getContext()));
        this.mFootViews.get(0).setVisibility(8);
    }

    private boolean isOnTop() {
        ArrayList<View> arrayList = this.mHeaderViews;
        return (arrayList == null || arrayList.isEmpty() || this.mHeaderViews.get(0).getParent() == null) ? false : true;
    }

    public void addFootView(View view) {
        if (view instanceof FooterImpl) {
            this.mFootViews.clear();
            this.mFootViews.add(view);
        }
    }

    public void addHeaderView(View view) {
        if (this.pullRefreshEnabled && !(this.mHeaderViews.get(0) instanceof ArrowRefreshHeader)) {
            ArrowRefreshHeader arrowRefreshHeader = new ArrowRefreshHeader(getContext());
            this.mHeaderViews.add(0, arrowRefreshHeader);
            this.mRefreshHeader = arrowRefreshHeader;
        }
        this.mHeaderViews.add(view);
        sHeaderTypes.add(Integer.valueOf(this.mHeaderViews.size() + 10000));
    }

    public void deinit() {
        super.setAdapter(null);
        ((WrapAdapter) this.mWrapAdapter).clearAdapterObserver(this.mDataObserver);
    }

    public View getEmptyView() {
        return this.mEmptyView;
    }

    public int getHeadersCount() {
        return this.mHeaderViews.size();
    }

    public boolean isLoadingMore() {
        return this.isLoadingData;
    }

    public boolean isRefreshHeaderSetted() {
        ArrayList<View> arrayList = this.mHeaderViews;
        return arrayList != null && arrayList.size() > 0;
    }

    public boolean isRefreshing() {
        BaseRefreshHeader baseRefreshHeader = this.mRefreshHeader;
        return (baseRefreshHeader == null || baseRefreshHeader.getState() == 0) ? false : true;
    }

    public void loadMoreComplete() {
        this.isLoadingData = false;
        if (this.loadingMoreEnabled || this.mFootViews.size() <= 0) {
            return;
        }
        View view = this.mFootViews.get(0);
        if (view instanceof LoadingMoreFooter) {
            ((LoadingMoreFooter) view).setState(1);
        } else if (view instanceof YKPageFooter) {
            ((YKPageFooter) view).setState(1);
        } else {
            view.setVisibility(8);
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        XonGestureListener xonGestureListener = this.xonGestureListener;
        if (xonGestureListener != null) {
            return xonGestureListener.onFling(motionEvent, motionEvent2, f, f2);
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        int findLastVisibleItemPosition;
        super.onScrollStateChanged(i);
        if (i == 0) {
            if ((this.mLoadingListener == null && this.mLoadingListenerExtra == null) || this.isLoadingData || !this.loadingMoreEnabled) {
                return;
            }
            RecyclerView.LayoutManager layoutManager = getLayoutManager();
            if (layoutManager instanceof GridLayoutManager) {
                findLastVisibleItemPosition = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
                findLastVisibleItemPosition = findMax(iArr);
            } else {
                findLastVisibleItemPosition = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
            if (layoutManager.getChildCount() <= 0 || findLastVisibleItemPosition < layoutManager.getItemCount() - this.preloadItemNumber || layoutManager.getItemCount() <= layoutManager.getChildCount() || this.isNoMore || this.mRefreshHeader.getState() >= 2 || !this.loadingMoreEnabled || this.mFootViews.size() <= 0) {
                return;
            }
            View view = this.mFootViews.get(0);
            this.isLoadingData = true;
            if (view instanceof LoadingMoreFooter) {
                ((LoadingMoreFooter) view).setState(0);
            } else if (view instanceof YKPageFooter) {
                ((YKPageFooter) view).setState(0);
            } else {
                view.setVisibility(0);
            }
            LoadingListener loadingListener = this.mLoadingListener;
            if (loadingListener != null) {
                loadingListener.onLoadMore();
            }
            LoadingListenerExtra loadingListenerExtra = this.mLoadingListenerExtra;
            if (loadingListenerExtra != null) {
                loadingListenerExtra.onLoadMore();
            }
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        BaseRefreshHeader baseRefreshHeader;
        BaseRefreshHeader baseRefreshHeader2;
        if (this.mLastY == -1.0f) {
            this.mLastY = motionEvent.getRawY();
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastY = motionEvent.getRawY();
        } else if (action != 2) {
            this.mLastY = -1.0f;
            if (isOnTop() && this.pullRefreshEnabled && (baseRefreshHeader2 = this.mRefreshHeader) != null) {
                if (baseRefreshHeader2.releaseAction()) {
                    LoadingListener loadingListener = this.mLoadingListener;
                    if (loadingListener != null) {
                        loadingListener.onRefresh();
                    }
                    if (this.mLoadingListenerExtra != null) {
                        if (this.mRefreshHeader.getState() == 3) {
                            this.mLoadingListenerExtra.onFullScreenShow();
                        } else {
                            this.mLoadingListenerExtra.onRefresh();
                        }
                    }
                } else {
                    LoadingListenerExtra loadingListenerExtra = this.mLoadingListenerExtra;
                    if (loadingListenerExtra != null) {
                        loadingListenerExtra.onMove(0.0f);
                    }
                }
            }
        } else {
            float rawY = motionEvent.getRawY() - this.mLastY;
            this.mLastY = motionEvent.getRawY();
            if (isOnTop() && this.pullRefreshEnabled && (baseRefreshHeader = this.mRefreshHeader) != null) {
                baseRefreshHeader.onMove(rawY / DRAG_RATE);
                LoadingListenerExtra loadingListenerExtra2 = this.mLoadingListenerExtra;
                if (loadingListenerExtra2 != null) {
                    loadingListenerExtra2.onMove(this.mRefreshHeader.getVisibleHeight() - this.mRefreshHeader.getInitHeight());
                }
                if (this.mRefreshHeader.getVisibleHeight() > this.mRefreshHeader.getInitHeight() && this.mRefreshHeader.getState() < 2) {
                    return false;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void refreshComplete() {
        BaseRefreshHeader baseRefreshHeader = this.mRefreshHeader;
        if (baseRefreshHeader != null) {
            baseRefreshHeader.refreshComplete();
        }
    }

    public void removeRefreshHeader() {
        this.mHeaderViews.clear();
        this.mRefreshHeader = null;
    }

    public void reset() {
        setNoMore(false);
        loadMoreComplete();
        refreshComplete();
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        WrapAdapter wrapAdapter = new WrapAdapter(adapter);
        this.mWrapAdapter = wrapAdapter;
        super.setAdapter(wrapAdapter);
        ((WrapAdapter) this.mWrapAdapter).setAdapterObserver(this.mDataObserver);
        this.mDataObserver.onChanged();
    }

    public void setArrowBgColor(String str) {
        BaseRefreshHeader baseRefreshHeader = this.mRefreshHeader;
        if (baseRefreshHeader == null || !(baseRefreshHeader instanceof ArrowRefreshHeader)) {
            return;
        }
        ((ArrowRefreshHeader) baseRefreshHeader).setBgColor(str);
    }

    public void setArrowBgImage(String str) {
        BaseRefreshHeader baseRefreshHeader = this.mRefreshHeader;
        if (baseRefreshHeader == null || !(baseRefreshHeader instanceof ArrowRefreshHeader)) {
            return;
        }
        ((ArrowRefreshHeader) baseRefreshHeader).setBgImage(str);
    }

    public void setArrowImageView(int i) {
        BaseRefreshHeader baseRefreshHeader = this.mRefreshHeader;
        if (baseRefreshHeader == null || !(baseRefreshHeader instanceof ArrowRefreshHeader)) {
            return;
        }
        ((ArrowRefreshHeader) baseRefreshHeader).setArrowImageView(i);
    }

    public void setEmptyView(View view) {
        this.mEmptyView = view;
        this.mDataObserver.onChanged();
    }

    public void setFooterVisiable(boolean z) {
        if (z || !this.loadingMoreEnabled || this.mFootViews.size() <= 0) {
            return;
        }
        this.mFootViews.get(0).setVisibility(8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        super.setLayoutManager(layoutManager);
        if (layoutManager == null || !(layoutManager instanceof GridLayoutManager)) {
            return;
        }
        this.spanSizeLookup = ((GridLayoutManager) layoutManager).getSpanSizeLookup();
    }

    public void setLoadingListener(LoadingListener loadingListener) {
        this.mLoadingListener = loadingListener;
    }

    public void setLoadingListenerExtra(LoadingListenerExtra loadingListenerExtra) {
        this.mLoadingListenerExtra = loadingListenerExtra;
    }

    public void setLoadingMoreEnabled(boolean z) {
        this.loadingMoreEnabled = z;
        if (z || this.mFootViews.size() <= 0) {
            return;
        }
        this.mFootViews.clear();
    }

    public void setNoMore(boolean z) {
        this.isNoMore = z;
        this.isLoadingData = false;
        if (this.loadingMoreEnabled) {
            if (z) {
                if (this.mFootViews.size() > 0) {
                    View view = this.mFootViews.get(0);
                    if (view instanceof LoadingMoreFooter) {
                        ((LoadingMoreFooter) view).setState(2);
                    } else if (view instanceof YKPageFooter) {
                        ((YKPageFooter) view).setState(3);
                    }
                    if (((FooterImpl) view).isNoMoreHintStay()) {
                        return;
                    }
                    this.mFootViews.clear();
                    this.mWrapAdapter.notifyDataSetChanged();
                }
            } else if (this.mFootViews.size() > 0) {
                View view2 = this.mFootViews.get(0);
                if (view2 instanceof LoadingMoreFooter) {
                    ((LoadingMoreFooter) view2).setState(1);
                } else if (view2 instanceof YKPageFooter) {
                    ((YKPageFooter) view2).setState(1);
                }
            } else {
                addFootView(new YKPageFooter(getContext()));
                this.mFootViews.get(0).setVisibility(8);
                this.mWrapAdapter.notifyDataSetChanged();
            }
        }
    }

    public void setNoMoreHintStay(boolean z) {
        if (!this.loadingMoreEnabled || this.mFootViews.size() <= 0) {
            return;
        }
        ((FooterImpl) this.mFootViews.get(0)).setNoMoreHintStay(z);
    }

    public void setOnGestureListener(XonGestureListener xonGestureListener) {
        this.xonGestureListener = xonGestureListener;
    }

    public void setPreloadItemNumber(int i) {
        this.preloadItemNumber = i;
    }

    public void setPullRefreshEnabled(boolean z) {
        this.pullRefreshEnabled = z;
    }

    public void setRefreshHeader(BaseRefreshHeader baseRefreshHeader) {
        if (this.pullRefreshEnabled) {
            this.mHeaderViews.add(0, (View) baseRefreshHeader);
            this.mRefreshHeader = baseRefreshHeader;
        }
    }

    public void setRefreshing(boolean z) {
        BaseRefreshHeader baseRefreshHeader;
        if (z && this.pullRefreshEnabled && ((this.mLoadingListener != null || this.mLoadingListenerExtra != null) && (baseRefreshHeader = this.mRefreshHeader) != null)) {
            baseRefreshHeader.onMove(baseRefreshHeader.getRefreshingHeight() - this.mRefreshHeader.getInitHeight());
            this.mRefreshHeader.releaseAction();
            LoadingListener loadingListener = this.mLoadingListener;
            if (loadingListener != null) {
                loadingListener.onRefresh();
            }
            LoadingListenerExtra loadingListenerExtra = this.mLoadingListenerExtra;
            if (loadingListenerExtra != null) {
                loadingListenerExtra.onRefresh();
                return;
            }
            return;
        }
        LoadingListener loadingListener2 = this.mLoadingListener;
        if (loadingListener2 == null && this.mLoadingListenerExtra == null) {
            return;
        }
        if (loadingListener2 != null) {
            loadingListener2.onRefresh();
        }
        LoadingListenerExtra loadingListenerExtra2 = this.mLoadingListenerExtra;
        if (loadingListenerExtra2 != null) {
            loadingListenerExtra2.onRefresh();
        }
    }

    public XRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = getClass().getSimpleName();
        this.isLoadingData = false;
        this.isNoMore = false;
        this.mHeaderViews = new ArrayList<>();
        this.mFootViews = new ArrayList<>();
        this.mLastY = -1.0f;
        this.pullRefreshEnabled = false;
        this.loadingMoreEnabled = false;
        this.mPageCount = 0;
        this.mDataObserver = new DataObserver();
        this.preloadItemNumber = 1;
        init();
    }

    public void refreshComplete(SpannableStringBuilder spannableStringBuilder) {
        BaseRefreshHeader baseRefreshHeader = this.mRefreshHeader;
        if (baseRefreshHeader != null) {
            baseRefreshHeader.refreshComplete(spannableStringBuilder);
        }
    }
}
