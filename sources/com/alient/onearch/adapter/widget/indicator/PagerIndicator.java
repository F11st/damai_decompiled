package com.alient.onearch.adapter.widget.indicator;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alient.onearch.adapter.widget.indicator.BasePagerIndicator;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class PagerIndicator extends BasePagerIndicator {
    private final DataSetObserver mInternalDataSetObserver;
    private final ViewPager.OnPageChangeListener mInternalPageChangeListener;
    private ViewPager viewpager;

    public PagerIndicator(Context context) {
        super(context);
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (PagerIndicator.this.viewpager.getAdapter() == null || PagerIndicator.this.viewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                PagerIndicator.this.animatePageSelected(i);
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (PagerIndicator.this.viewpager == null) {
                    return;
                }
                PagerAdapter adapter = PagerIndicator.this.viewpager.getAdapter();
                int count = adapter != null ? adapter.getCount() : 0;
                if (count == PagerIndicator.this.getChildCount()) {
                    return;
                }
                PagerIndicator pagerIndicator = PagerIndicator.this;
                if (pagerIndicator.mLastPosition < count) {
                    pagerIndicator.mLastPosition = pagerIndicator.viewpager.getCurrentItem();
                } else {
                    pagerIndicator.mLastPosition = -1;
                }
                PagerIndicator.this.createIndicators();
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

    public DataSetObserver getDataSetObserver() {
        return this.mInternalDataSetObserver;
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void initialize(Config config) {
        super.initialize(config);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void setIndicatorCreatedListener(@Nullable BasePagerIndicator.IndicatorCreatedListener indicatorCreatedListener) {
        super.setIndicatorCreatedListener(indicatorCreatedListener);
    }

    public void setViewPager(@Nullable ViewPager viewPager) {
        this.viewpager = viewPager;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        this.mLastPosition = -1;
        createIndicators();
        this.viewpager.removeOnPageChangeListener(this.mInternalPageChangeListener);
        this.viewpager.addOnPageChangeListener(this.mInternalPageChangeListener);
        this.mInternalPageChangeListener.onPageSelected(this.viewpager.getCurrentItem());
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(@ColorInt int i) {
        super.tintIndicator(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createIndicators() {
        PagerAdapter adapter = this.viewpager.getAdapter();
        int count = adapter == null ? 0 : adapter.getCount();
        createIndicators(count, this.viewpager.getCurrentItem());
        if (this.autoSize) {
            if (getOrientation() == 0) {
                getLayoutParams().width = this.mIndicatorWidth * count;
            } else {
                getLayoutParams().height = this.mIndicatorHeight * count;
            }
            invalidate();
        }
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void changeIndicatorResource(@DrawableRes int i, @DrawableRes int i2) {
        super.changeIndicatorResource(i, i2);
    }

    @Override // com.alient.onearch.adapter.widget.indicator.BasePagerIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(@ColorInt int i, @ColorInt int i2) {
        super.tintIndicator(i, i2);
    }

    public PagerIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (PagerIndicator.this.viewpager.getAdapter() == null || PagerIndicator.this.viewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                PagerIndicator.this.animatePageSelected(i);
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (PagerIndicator.this.viewpager == null) {
                    return;
                }
                PagerAdapter adapter = PagerIndicator.this.viewpager.getAdapter();
                int count = adapter != null ? adapter.getCount() : 0;
                if (count == PagerIndicator.this.getChildCount()) {
                    return;
                }
                PagerIndicator pagerIndicator = PagerIndicator.this;
                if (pagerIndicator.mLastPosition < count) {
                    pagerIndicator.mLastPosition = pagerIndicator.viewpager.getCurrentItem();
                } else {
                    pagerIndicator.mLastPosition = -1;
                }
                PagerIndicator.this.createIndicators();
            }
        };
    }

    public PagerIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (PagerIndicator.this.viewpager.getAdapter() == null || PagerIndicator.this.viewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                PagerIndicator.this.animatePageSelected(i2);
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (PagerIndicator.this.viewpager == null) {
                    return;
                }
                PagerAdapter adapter = PagerIndicator.this.viewpager.getAdapter();
                int count = adapter != null ? adapter.getCount() : 0;
                if (count == PagerIndicator.this.getChildCount()) {
                    return;
                }
                PagerIndicator pagerIndicator = PagerIndicator.this;
                if (pagerIndicator.mLastPosition < count) {
                    pagerIndicator.mLastPosition = pagerIndicator.viewpager.getCurrentItem();
                } else {
                    pagerIndicator.mLastPosition = -1;
                }
                PagerIndicator.this.createIndicators();
            }
        };
    }

    @TargetApi(21)
    public PagerIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i22, float f, int i222) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i22) {
                if (PagerIndicator.this.viewpager.getAdapter() == null || PagerIndicator.this.viewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                PagerIndicator.this.animatePageSelected(i22);
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: com.alient.onearch.adapter.widget.indicator.PagerIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (PagerIndicator.this.viewpager == null) {
                    return;
                }
                PagerAdapter adapter = PagerIndicator.this.viewpager.getAdapter();
                int count = adapter != null ? adapter.getCount() : 0;
                if (count == PagerIndicator.this.getChildCount()) {
                    return;
                }
                PagerIndicator pagerIndicator = PagerIndicator.this;
                if (pagerIndicator.mLastPosition < count) {
                    pagerIndicator.mLastPosition = pagerIndicator.viewpager.getCurrentItem();
                } else {
                    pagerIndicator.mLastPosition = -1;
                }
                PagerIndicator.this.createIndicators();
            }
        };
    }
}
