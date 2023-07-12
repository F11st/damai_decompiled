package com.taobao.weex.ui.view.listview.adapter;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.taobao.weex.utils.WXLogUtils;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class WXRecyclerViewOnScrollListener extends RecyclerView.OnScrollListener {
    protected LAYOUT_MANAGER_TYPE layoutManagerType;
    private WeakReference<IOnLoadMoreListener> listener;
    private int mCurrentScrollState = 0;
    private int[] mFirstPositions;
    private int mFirstVisibleItemPosition;
    private int[] mLastPositions;
    private int mLastVisibleItemPosition;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public enum LAYOUT_MANAGER_TYPE {
        LINEAR,
        GRID,
        STAGGERED_GRID
    }

    public WXRecyclerViewOnScrollListener(IOnLoadMoreListener iOnLoadMoreListener) {
        this.listener = new WeakReference<>(iOnLoadMoreListener);
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

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        WeakReference<IOnLoadMoreListener> weakReference;
        super.onScrollStateChanged(recyclerView, i);
        this.mCurrentScrollState = i;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int itemCount = layoutManager.getItemCount();
        if (childCount != 0) {
            int height = (((itemCount - this.mLastVisibleItemPosition) - 1) * recyclerView.getHeight()) / childCount;
            if (childCount <= 0 || this.mCurrentScrollState != 0 || (weakReference = this.listener) == null || weakReference.get() == null) {
                return;
            }
            this.listener.get().onLoadMore(height);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        IOnLoadMoreListener iOnLoadMoreListener;
        super.onScrolled(recyclerView, i, i2);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        WeakReference<IOnLoadMoreListener> weakReference = this.listener;
        if (weakReference == null || (iOnLoadMoreListener = weakReference.get()) == null) {
            return;
        }
        iOnLoadMoreListener.onBeforeScroll(i, i2);
        if (layoutManager instanceof LinearLayoutManager) {
            this.layoutManagerType = LAYOUT_MANAGER_TYPE.LINEAR;
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            this.mLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            iOnLoadMoreListener.notifyAppearStateChange(linearLayoutManager.findFirstVisibleItemPosition(), this.mLastVisibleItemPosition, i, i2);
        } else if (layoutManager instanceof GridLayoutManager) {
            this.layoutManagerType = LAYOUT_MANAGER_TYPE.GRID;
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            this.mLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
            iOnLoadMoreListener.notifyAppearStateChange(gridLayoutManager.findFirstVisibleItemPosition(), this.mLastVisibleItemPosition, i, i2);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            this.layoutManagerType = LAYOUT_MANAGER_TYPE.STAGGERED_GRID;
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int spanCount = staggeredGridLayoutManager.getSpanCount();
            int[] iArr = this.mLastPositions;
            if (iArr == null || spanCount != iArr.length) {
                this.mLastPositions = new int[spanCount];
            }
            int[] iArr2 = this.mFirstPositions;
            if (iArr2 == null || spanCount != iArr2.length) {
                this.mFirstPositions = new int[spanCount];
            }
            try {
                staggeredGridLayoutManager.findFirstVisibleItemPositions(this.mFirstPositions);
                this.mFirstVisibleItemPosition = findMin(this.mFirstPositions);
                staggeredGridLayoutManager.findLastVisibleItemPositions(this.mLastPositions);
                int findMax = findMax(this.mLastPositions);
                this.mLastVisibleItemPosition = findMax;
                iOnLoadMoreListener.notifyAppearStateChange(this.mFirstVisibleItemPosition, findMax, i, i2);
            } catch (Exception e) {
                e.printStackTrace();
                WXLogUtils.e(e.toString());
            }
        } else {
            throw new RuntimeException("Unsupported LayoutManager used. Valid ones are LinearLayoutManager, GridLayoutManager and StaggeredGridLayoutManager");
        }
    }
}
