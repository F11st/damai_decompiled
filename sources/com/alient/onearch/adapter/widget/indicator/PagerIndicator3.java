package com.alient.onearch.adapter.widget.indicator;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.alient.onearch.adapter.widget.indicator.BasePagerIndicator;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PagerIndicator3 extends BasePagerIndicator {
    private final RecyclerView.AdapterDataObserver mAdapterDataObserver;
    private final ViewPager2.OnPageChangeCallback mInternalPageChangeCallback;
    private ViewPager2 viewpager;

    public PagerIndicator3(Context context) {
        super(context);
        this.mInternalPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator3.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                PagerIndicator3 pagerIndicator3 = PagerIndicator3.this;
                if (i == pagerIndicator3.mLastPosition || pagerIndicator3.viewpager.getAdapter() == null || PagerIndicator3.this.viewpager.getAdapter().getItemCount() <= 0) {
                    return;
                }
                PagerIndicator3.this.animatePageSelected(i);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator3.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (PagerIndicator3.this.viewpager == null) {
                    return;
                }
                RecyclerView.Adapter adapter = PagerIndicator3.this.viewpager.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == PagerIndicator3.this.getChildCount()) {
                    return;
                }
                PagerIndicator3 pagerIndicator3 = PagerIndicator3.this;
                if (pagerIndicator3.mLastPosition < itemCount) {
                    pagerIndicator3.mLastPosition = pagerIndicator3.viewpager.getCurrentItem();
                } else {
                    pagerIndicator3.mLastPosition = -1;
                }
                PagerIndicator3.this.createIndicators();
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

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void initialize(Config config) {
        super.initialize(config);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void setIndicatorCreatedListener(@Nullable BasePagerIndicator.IndicatorCreatedListener indicatorCreatedListener) {
        super.setIndicatorCreatedListener(indicatorCreatedListener);
    }

    public void setViewPager(@Nullable ViewPager2 viewPager2) {
        this.viewpager = viewPager2;
        if (viewPager2 == null || viewPager2.getAdapter() == null) {
            return;
        }
        this.mLastPosition = -1;
        createIndicators();
        this.viewpager.unregisterOnPageChangeCallback(this.mInternalPageChangeCallback);
        this.viewpager.registerOnPageChangeCallback(this.mInternalPageChangeCallback);
        this.mInternalPageChangeCallback.onPageSelected(this.viewpager.getCurrentItem());
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(@ColorInt int i) {
        super.tintIndicator(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createIndicators() {
        RecyclerView.Adapter adapter = this.viewpager.getAdapter();
        createIndicators(adapter == null ? 0 : adapter.getItemCount(), this.viewpager.getCurrentItem());
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void changeIndicatorResource(@DrawableRes int i, @DrawableRes int i2) {
        super.changeIndicatorResource(i, i2);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(@ColorInt int i, @ColorInt int i2) {
        super.tintIndicator(i, i2);
    }

    public PagerIndicator3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInternalPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator3.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                PagerIndicator3 pagerIndicator3 = PagerIndicator3.this;
                if (i == pagerIndicator3.mLastPosition || pagerIndicator3.viewpager.getAdapter() == null || PagerIndicator3.this.viewpager.getAdapter().getItemCount() <= 0) {
                    return;
                }
                PagerIndicator3.this.animatePageSelected(i);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator3.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (PagerIndicator3.this.viewpager == null) {
                    return;
                }
                RecyclerView.Adapter adapter = PagerIndicator3.this.viewpager.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == PagerIndicator3.this.getChildCount()) {
                    return;
                }
                PagerIndicator3 pagerIndicator3 = PagerIndicator3.this;
                if (pagerIndicator3.mLastPosition < itemCount) {
                    pagerIndicator3.mLastPosition = pagerIndicator3.viewpager.getCurrentItem();
                } else {
                    pagerIndicator3.mLastPosition = -1;
                }
                PagerIndicator3.this.createIndicators();
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

    public PagerIndicator3(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInternalPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator3.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                PagerIndicator3 pagerIndicator3 = PagerIndicator3.this;
                if (i2 == pagerIndicator3.mLastPosition || pagerIndicator3.viewpager.getAdapter() == null || PagerIndicator3.this.viewpager.getAdapter().getItemCount() <= 0) {
                    return;
                }
                PagerIndicator3.this.animatePageSelected(i2);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator3.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (PagerIndicator3.this.viewpager == null) {
                    return;
                }
                RecyclerView.Adapter adapter = PagerIndicator3.this.viewpager.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == PagerIndicator3.this.getChildCount()) {
                    return;
                }
                PagerIndicator3 pagerIndicator3 = PagerIndicator3.this;
                if (pagerIndicator3.mLastPosition < itemCount) {
                    pagerIndicator3.mLastPosition = pagerIndicator3.viewpager.getCurrentItem();
                } else {
                    pagerIndicator3.mLastPosition = -1;
                }
                PagerIndicator3.this.createIndicators();
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
    public PagerIndicator3(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mInternalPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator3.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i22) {
                PagerIndicator3 pagerIndicator3 = PagerIndicator3.this;
                if (i22 == pagerIndicator3.mLastPosition || pagerIndicator3.viewpager.getAdapter() == null || PagerIndicator3.this.viewpager.getAdapter().getItemCount() <= 0) {
                    return;
                }
                PagerIndicator3.this.animatePageSelected(i22);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator3.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (PagerIndicator3.this.viewpager == null) {
                    return;
                }
                RecyclerView.Adapter adapter = PagerIndicator3.this.viewpager.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == PagerIndicator3.this.getChildCount()) {
                    return;
                }
                PagerIndicator3 pagerIndicator3 = PagerIndicator3.this;
                if (pagerIndicator3.mLastPosition < itemCount) {
                    pagerIndicator3.mLastPosition = pagerIndicator3.viewpager.getCurrentItem();
                } else {
                    pagerIndicator3.mLastPosition = -1;
                }
                PagerIndicator3.this.createIndicators();
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
