package com.alient.onearch.adapter.widget.indicator;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.alient.onearch.adapter.widget.indicator.BasePagerIndicator;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PagerIndicator2 extends BasePagerIndicator {
    private final RecyclerView.AdapterDataObserver mAdapterDataObserver;
    private final RecyclerView.OnScrollListener mInternalOnScrollListener;
    private RecyclerView recyclerView;
    private SnapHelper snapHelper;

    public PagerIndicator2(Context context) {
        super(context);
        this.mInternalOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator2.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int snapPosition = PagerIndicator2.this.getSnapPosition(recyclerView.getLayoutManager());
                if (snapPosition == -1) {
                    return;
                }
                PagerIndicator2.this.animatePageSelected(snapPosition);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator2.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (PagerIndicator2.this.recyclerView == null) {
                    return;
                }
                RecyclerView.Adapter adapter = PagerIndicator2.this.recyclerView.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == PagerIndicator2.this.getChildCount()) {
                    return;
                }
                PagerIndicator2 pagerIndicator2 = PagerIndicator2.this;
                if (pagerIndicator2.mLastPosition < itemCount) {
                    pagerIndicator2.mLastPosition = pagerIndicator2.getSnapPosition(pagerIndicator2.recyclerView.getLayoutManager());
                } else {
                    pagerIndicator2.mLastPosition = -1;
                }
                PagerIndicator2.this.createIndicators();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2) {
                super.onItemRangeChanged(i, i2);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                super.onItemRangeInserted(i, i2);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i, int i2, int i3) {
                super.onItemRangeMoved(i, i2, i3);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                super.onItemRangeRemoved(i, i2);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
                super.onItemRangeChanged(i, i2, obj);
                onChanged();
            }
        };
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void animatePageSelected(int i) {
        super.animatePageSelected(i);
    }

    public void attachToRecyclerView(@NonNull RecyclerView recyclerView, @NonNull SnapHelper snapHelper) {
        this.recyclerView = recyclerView;
        this.snapHelper = snapHelper;
        this.mLastPosition = -1;
        createIndicators();
        recyclerView.removeOnScrollListener(this.mInternalOnScrollListener);
        recyclerView.addOnScrollListener(this.mInternalOnScrollListener);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void changeIndicatorResource(@DrawableRes int i) {
        super.changeIndicatorResource(i);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void createIndicators(int i, int i2) {
        super.createIndicators(i, i2);
    }

    public RecyclerView.AdapterDataObserver getAdapterDataObserver() {
        return this.mAdapterDataObserver;
    }

    public int getSnapPosition(@Nullable RecyclerView.LayoutManager layoutManager) {
        View findSnapView;
        if (layoutManager == null || (findSnapView = this.snapHelper.findSnapView(layoutManager)) == null) {
            return -1;
        }
        return layoutManager.getPosition(findSnapView);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void initialize(Config config) {
        super.initialize(config);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void setIndicatorCreatedListener(@Nullable BasePagerIndicator.IndicatorCreatedListener indicatorCreatedListener) {
        super.setIndicatorCreatedListener(indicatorCreatedListener);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(@ColorInt int i) {
        super.tintIndicator(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createIndicators() {
        RecyclerView.Adapter adapter = this.recyclerView.getAdapter();
        createIndicators(adapter == null ? 0 : adapter.getItemCount(), getSnapPosition(this.recyclerView.getLayoutManager()));
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void changeIndicatorResource(@DrawableRes int i, @DrawableRes int i2) {
        super.changeIndicatorResource(i, i2);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(@ColorInt int i, @ColorInt int i2) {
        super.tintIndicator(i, i2);
    }

    public PagerIndicator2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInternalOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator2.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int snapPosition = PagerIndicator2.this.getSnapPosition(recyclerView.getLayoutManager());
                if (snapPosition == -1) {
                    return;
                }
                PagerIndicator2.this.animatePageSelected(snapPosition);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator2.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (PagerIndicator2.this.recyclerView == null) {
                    return;
                }
                RecyclerView.Adapter adapter = PagerIndicator2.this.recyclerView.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == PagerIndicator2.this.getChildCount()) {
                    return;
                }
                PagerIndicator2 pagerIndicator2 = PagerIndicator2.this;
                if (pagerIndicator2.mLastPosition < itemCount) {
                    pagerIndicator2.mLastPosition = pagerIndicator2.getSnapPosition(pagerIndicator2.recyclerView.getLayoutManager());
                } else {
                    pagerIndicator2.mLastPosition = -1;
                }
                PagerIndicator2.this.createIndicators();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2) {
                super.onItemRangeChanged(i, i2);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                super.onItemRangeInserted(i, i2);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i, int i2, int i3) {
                super.onItemRangeMoved(i, i2, i3);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                super.onItemRangeRemoved(i, i2);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2, @Nullable Object obj) {
                super.onItemRangeChanged(i, i2, obj);
                onChanged();
            }
        };
    }

    public PagerIndicator2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInternalOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator2.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                int snapPosition = PagerIndicator2.this.getSnapPosition(recyclerView.getLayoutManager());
                if (snapPosition == -1) {
                    return;
                }
                PagerIndicator2.this.animatePageSelected(snapPosition);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator2.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (PagerIndicator2.this.recyclerView == null) {
                    return;
                }
                RecyclerView.Adapter adapter = PagerIndicator2.this.recyclerView.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == PagerIndicator2.this.getChildCount()) {
                    return;
                }
                PagerIndicator2 pagerIndicator2 = PagerIndicator2.this;
                if (pagerIndicator2.mLastPosition < itemCount) {
                    pagerIndicator2.mLastPosition = pagerIndicator2.getSnapPosition(pagerIndicator2.recyclerView.getLayoutManager());
                } else {
                    pagerIndicator2.mLastPosition = -1;
                }
                PagerIndicator2.this.createIndicators();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i2, int i22) {
                super.onItemRangeChanged(i2, i22);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i2, int i22) {
                super.onItemRangeInserted(i2, i22);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i2, int i22, int i3) {
                super.onItemRangeMoved(i2, i22, i3);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i2, int i22) {
                super.onItemRangeRemoved(i2, i22);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i2, int i22, @Nullable Object obj) {
                super.onItemRangeChanged(i2, i22, obj);
                onChanged();
            }
        };
    }

    @TargetApi(21)
    public PagerIndicator2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mInternalOnScrollListener = new RecyclerView.OnScrollListener() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator2.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(@NonNull RecyclerView recyclerView, int i22, int i222) {
                super.onScrolled(recyclerView, i22, i222);
                int snapPosition = PagerIndicator2.this.getSnapPosition(recyclerView.getLayoutManager());
                if (snapPosition == -1) {
                    return;
                }
                PagerIndicator2.this.animatePageSelected(snapPosition);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator2.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (PagerIndicator2.this.recyclerView == null) {
                    return;
                }
                RecyclerView.Adapter adapter = PagerIndicator2.this.recyclerView.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == PagerIndicator2.this.getChildCount()) {
                    return;
                }
                PagerIndicator2 pagerIndicator2 = PagerIndicator2.this;
                if (pagerIndicator2.mLastPosition < itemCount) {
                    pagerIndicator2.mLastPosition = pagerIndicator2.getSnapPosition(pagerIndicator2.recyclerView.getLayoutManager());
                } else {
                    pagerIndicator2.mLastPosition = -1;
                }
                PagerIndicator2.this.createIndicators();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i22, int i222) {
                super.onItemRangeChanged(i22, i222);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i22, int i222) {
                super.onItemRangeInserted(i22, i222);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i22, int i222, int i3) {
                super.onItemRangeMoved(i22, i222, i3);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i22, int i222) {
                super.onItemRangeRemoved(i22, i222);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i22, int i222, @Nullable Object obj) {
                super.onItemRangeChanged(i22, i222, obj);
                onChanged();
            }
        };
    }
}
