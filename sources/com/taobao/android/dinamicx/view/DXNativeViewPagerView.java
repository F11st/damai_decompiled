package com.taobao.android.dinamicx.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.taobao.android.dinamicx.widget.viewpager.LazyViewPagerAdapter;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXNativeViewPagerView extends ViewPager {
    private static final float DEFAULT_OFFSET = 0.1f;
    private LazyViewPagerAdapter mLazyPagerAdapter;
    private boolean scrollable;

    public DXNativeViewPagerView(Context context) {
        super(context);
        this.scrollable = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean canScrollHorizontally(int i) {
        boolean z = this.scrollable;
        return z ? super.canScrollHorizontally(i) : z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager
    public void onPageScrolled(int i, float f, int i2) {
        if (this.mLazyPagerAdapter != null) {
            if (getCurrentItem() == i) {
                int i3 = i + 1;
                if (this.mLazyPagerAdapter.d(i3) && f >= 0.1f) {
                    this.mLazyPagerAdapter.startUpdate((ViewGroup) this);
                    this.mLazyPagerAdapter.g(this, i3);
                    this.mLazyPagerAdapter.finishUpdate((ViewGroup) this);
                }
            } else if (getCurrentItem() > i && this.mLazyPagerAdapter.d(i) && 1.0f - f >= 0.1f) {
                this.mLazyPagerAdapter.startUpdate((ViewGroup) this);
                this.mLazyPagerAdapter.g(this, i);
                this.mLazyPagerAdapter.finishUpdate((ViewGroup) this);
            }
        }
        super.onPageScrolled(i, f, i2);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(PagerAdapter pagerAdapter) {
        super.setAdapter(pagerAdapter);
        this.mLazyPagerAdapter = pagerAdapter instanceof LazyViewPagerAdapter ? (LazyViewPagerAdapter) pagerAdapter : null;
    }

    public void setScrollable(boolean z) {
        this.scrollable = z;
    }

    public DXNativeViewPagerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.scrollable = true;
    }
}
