package com.alibaba.pictures.bricks.view;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.util.Pools;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.k50;
import tb.nd;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class NestedBanner extends ViewPager implements Runnable {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final a Companion = new a(null);
    public static final long FLIP_TIME_MILLIS = 3000;
    private boolean isSelfAttachedToWindow;
    @NotNull
    private final TAdapter mAdapter;
    @Nullable
    private BannerAttachedAutoPlayCondition mAutoPlayCondition;
    @NotNull
    private final Handler mFlipHandler;
    @Nullable
    private BannerViewBinder mViewBinder;
    @Nullable
    private BannerViewIndicator mViewIndicator;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public final class TAdapter extends PagerAdapter {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final HashMap<Integer, Pools.SimplePool<View>> a = new HashMap<>();
        @NotNull
        private final ArrayList<Object> b = new ArrayList<>();

        public TAdapter() {
        }

        public final void a(@Nullable List<? extends Object> list) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "33010131")) {
                ipChange.ipc$dispatch("33010131", new Object[]{this, list});
                return;
            }
            this.b.clear();
            if (list != null) {
                this.b.addAll(list);
            }
            notifyDataSetChanged();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NotNull ViewGroup viewGroup, int i, @NotNull Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1784506670")) {
                ipChange.ipc$dispatch("1784506670", new Object[]{this, viewGroup, Integer.valueOf(i), obj});
                return;
            }
            b41.i(viewGroup, "container");
            b41.i(obj, "obj");
            viewGroup.removeView((View) obj);
            BannerViewBinder bannerViewBinder = NestedBanner.this.mViewBinder;
            if (bannerViewBinder != null) {
                int viewType = bannerViewBinder.getViewType(this.b.get(i % this.b.size()));
                Pools.SimplePool<View> simplePool = this.a.get(Integer.valueOf(viewType));
                if (simplePool == null) {
                    simplePool = new Pools.SimplePool<>(4);
                    this.a.put(Integer.valueOf(viewType), simplePool);
                }
                simplePool.release(obj);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1153383739")) {
                return ((Integer) ipChange.ipc$dispatch("-1153383739", new Object[]{this})).intValue();
            }
            if (this.b.size() >= 2) {
                return 1000;
            }
            return this.b.size();
        }

        public final int getRealCount() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-2050245501") ? ((Integer) ipChange.ipc$dispatch("-2050245501", new Object[]{this})).intValue() : this.b.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NotNull
        public Object instantiateItem(@NotNull ViewGroup viewGroup, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-915340880")) {
                return ipChange.ipc$dispatch("-915340880", new Object[]{this, viewGroup, Integer.valueOf(i)});
            }
            b41.i(viewGroup, "container");
            BannerViewBinder bannerViewBinder = NestedBanner.this.mViewBinder;
            View view = null;
            if (bannerViewBinder != null) {
                int size = i % this.b.size();
                Object obj = this.b.get(size);
                b41.h(obj, "mList[realPos]");
                int viewType = bannerViewBinder.getViewType(obj);
                Pools.SimplePool<View> simplePool = this.a.get(Integer.valueOf(viewType));
                view = bannerViewBinder.getView(viewType, size, obj, simplePool != null ? simplePool.acquire() : null, viewGroup);
                viewGroup.addView(view, -1, -1);
            }
            return view == null ? new View(NestedBanner.this.getContext()) : view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(@NotNull View view, @NotNull Object obj) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1591003105")) {
                return ((Boolean) ipChange.ipc$dispatch("-1591003105", new Object[]{this, view, obj})).booleanValue();
            }
            b41.i(view, "view");
            b41.i(obj, "obj");
            return b41.d(view, obj);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NestedBanner(@NotNull Context context) {
        this(context, null, 2, null);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
    }

    public /* synthetic */ NestedBanner(Context context, AttributeSet attributeSet, int i, k50 k50Var) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final boolean isCanAnimation() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-818479540") ? ((Boolean) ipChange.ipc$dispatch("-818479540", new Object[]{this})).booleanValue() : isSelfAttachedToWindow() && getVisibility() == 0 && this.mAdapter.getRealCount() >= 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateIndicator() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1730530018")) {
            ipChange.ipc$dispatch("-1730530018", new Object[]{this});
            return;
        }
        BannerViewIndicator bannerViewIndicator = this.mViewIndicator;
        if (bannerViewIndicator != null) {
            bannerViewIndicator.updateIndicator(this.mAdapter.getRealCount(), getCurrentItem());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent motionEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1146316394")) {
            return ((Boolean) ipChange.ipc$dispatch("1146316394", new Object[]{this, motionEvent})).booleanValue();
        }
        if (motionEvent != null) {
            if (motionEvent.getAction() == 0) {
                stopAnimation();
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                startAnimation();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void forceUpdate(@Nullable List<? extends Object> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "618998401")) {
            ipChange.ipc$dispatch("618998401", new Object[]{this, list});
            return;
        }
        stopAnimation();
        super.setAdapter(null);
        this.mAdapter.a(list);
        super.setAdapter(this.mAdapter);
        updateIndicator();
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1921748957")) {
            return ((Integer) ipChange.ipc$dispatch("-1921748957", new Object[]{this})).intValue();
        }
        int currentItem = super.getCurrentItem();
        int realCount = this.mAdapter.getRealCount();
        if (realCount == 0) {
            return 0;
        }
        return currentItem % realCount;
    }

    public final boolean isSelfAttachedToWindow() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-128235515") ? ((Boolean) ipChange.ipc$dispatch("-128235515", new Object[]{this})).booleanValue() : this.isSelfAttachedToWindow;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "199075736")) {
            ipChange.ipc$dispatch("199075736", new Object[]{this});
            return;
        }
        super.onAttachedToWindow();
        nd.b("Banner " + hashCode() + " onAttachedToWindow", null, 2, null);
        this.isSelfAttachedToWindow = true;
        BannerAttachedAutoPlayCondition bannerAttachedAutoPlayCondition = this.mAutoPlayCondition;
        if (bannerAttachedAutoPlayCondition == null || !bannerAttachedAutoPlayCondition.isCanAutoPlay()) {
            return;
        }
        startAnimation();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1423669435")) {
            ipChange.ipc$dispatch("1423669435", new Object[]{this});
            return;
        }
        super.onDetachedFromWindow();
        this.isSelfAttachedToWindow = false;
        nd.b("Banner " + hashCode() + " onDetachedFromWindow", null, 2, null);
        stopAnimation();
    }

    @Override // java.lang.Runnable
    public void run() {
        IpChange ipChange = $ipChange;
        int i = 0;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "912571961")) {
            ipChange.ipc$dispatch("912571961", new Object[]{this});
            return;
        }
        this.mFlipHandler.removeCallbacks(this);
        if (isCanAnimation()) {
            int currentItem = super.getCurrentItem() + 1;
            if (currentItem >= this.mAdapter.getCount()) {
                z = false;
            } else {
                i = currentItem;
            }
            setCurrentItem(i, z);
            startAnimation();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setAdapter(@Nullable PagerAdapter pagerAdapter) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "122082632")) {
            ipChange.ipc$dispatch("122082632", new Object[]{this, pagerAdapter});
        }
    }

    public final void setAutoPlayCondition(@NotNull BannerAttachedAutoPlayCondition bannerAttachedAutoPlayCondition) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1347451613")) {
            ipChange.ipc$dispatch("1347451613", new Object[]{this, bannerAttachedAutoPlayCondition});
            return;
        }
        b41.i(bannerAttachedAutoPlayCondition, "autoPlayCondition");
        this.mAutoPlayCondition = bannerAttachedAutoPlayCondition;
    }

    public final void setViewBinder(@NotNull BannerViewBinder bannerViewBinder) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-365958643")) {
            ipChange.ipc$dispatch("-365958643", new Object[]{this, bannerViewBinder});
            return;
        }
        b41.i(bannerViewBinder, "viewBinder");
        this.mViewBinder = bannerViewBinder;
    }

    public final void setViewIndicator(@NotNull BannerViewIndicator bannerViewIndicator) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1438997259")) {
            ipChange.ipc$dispatch("-1438997259", new Object[]{this, bannerViewIndicator});
            return;
        }
        b41.i(bannerViewIndicator, "viewIndicator");
        this.mViewIndicator = bannerViewIndicator;
    }

    public final void startAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-168917404")) {
            ipChange.ipc$dispatch("-168917404", new Object[]{this});
            return;
        }
        this.mFlipHandler.removeCallbacks(this);
        if (isCanAnimation()) {
            this.mFlipHandler.postDelayed(this, 3000L);
        }
    }

    public final void stopAnimation() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-85686014")) {
            ipChange.ipc$dispatch("-85686014", new Object[]{this});
        } else {
            this.mFlipHandler.removeCallbacks(this);
        }
    }

    public final void update(@Nullable List<? extends Object> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-890894994")) {
            ipChange.ipc$dispatch("-890894994", new Object[]{this, list});
            return;
        }
        stopAnimation();
        this.mAdapter.a(list);
        updateIndicator();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public NestedBanner(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        this.mAdapter = new TAdapter();
        this.mFlipHandler = new Handler();
        try {
            Field declaredField = ViewPager.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            BannerScroller bannerScroller = new BannerScroller(context);
            bannerScroller.setDuration(800);
            declaredField.set(this, bannerScroller);
        } catch (Exception e) {
            String message = e.getMessage();
            if (message != null) {
                Log.e("XunYanBanner", message);
            }
        }
        addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.alibaba.pictures.bricks.view.NestedBanner.2
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "764931597")) {
                    ipChange.ipc$dispatch("764931597", new Object[]{this, Integer.valueOf(i)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-300951636")) {
                    ipChange.ipc$dispatch("-300951636", new Object[]{this, Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)});
                }
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-335902312")) {
                    ipChange.ipc$dispatch("-335902312", new Object[]{this, Integer.valueOf(i)});
                } else {
                    NestedBanner.this.updateIndicator();
                }
            }
        });
        super.setAdapter(this.mAdapter);
    }
}
