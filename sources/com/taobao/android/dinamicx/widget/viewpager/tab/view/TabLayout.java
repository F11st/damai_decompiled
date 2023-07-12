package com.taobao.android.dinamicx.widget.viewpager.tab.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.util.Pools;
import androidx.core.view.GravityCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import tb.wt;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class TabLayout extends HorizontalScrollView {
    private static final int ANIMATION_DURATION = 300;
    static final int DEFAULT_GAP_TEXT_ICON = 8;
    private static final int DEFAULT_HEIGHT = 48;
    private static final int DEFAULT_HEIGHT_WITH_TEXT_ICON = 72;
    public static final int DEFAULT_INDICATOR_Z_INDEX = 1;
    static final int FIXED_WRAP_GUTTER_MIN = 16;
    public static final int GRAVITY_CENTER = 1;
    public static final int GRAVITY_FILL = 0;
    private static final int INVALID_WIDTH = -1;
    public static final int MODE_FIXED = 1;
    public static final int MODE_SCROLLABLE = 0;
    static final int MOTION_NON_ADJACENT_OFFSET = 24;
    private static final int TAB_MIN_WIDTH_MARGIN = 56;
    private C6544b mAdapterChangeListener;
    private int mContentInsetStart;
    private OnTabSelectedListener mCurrentVpSelectedListener;
    int mMode;
    private final ArrayList<OnTabClickListener> mOnTabClickListeners;
    private TabLayoutOnPageChangeListener mPageChangeListener;
    private PagerAdapter mPagerAdapter;
    private DataSetObserver mPagerAdapterObserver;
    private int mRequestedTabMaxWidth;
    private int mRequestedTabMinWidth;
    private ValueAnimator mScrollAnimator;
    private int mScrollableTabMinWidth;
    private OnTabSelectedListener mSelectedListener;
    private final ArrayList<OnTabSelectedListener> mSelectedListeners;
    private C6546d mSelectedTab;
    private boolean mSetupViewPagerImplicitly;
    int mTabGravity;
    int mTabMaxWidth;
    int mTabPaddingBottom;
    int mTabPaddingEnd;
    int mTabPaddingStart;
    int mTabPaddingTop;
    private final SlidingTabStrip mTabStrip;
    int mTabTextAppearance;
    ColorStateList mTabTextColors;
    float mTabTextMultiLineSize;
    float mTabTextSize;
    private final Pools.Pool<TabView> mTabViewPool;
    private final ArrayList<C6546d> mTabs;
    ViewPager mViewPager;
    boolean mViewPagerSmoothScroll;
    static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    static final Interpolator FAST_OUT_SLOW_IN_INTERPOLATOR = new FastOutSlowInInterpolator();
    static final Interpolator FAST_OUT_LINEAR_IN_INTERPOLATOR = new FastOutLinearInInterpolator();
    static final Interpolator LINEAR_OUT_SLOW_IN_INTERPOLATOR = new LinearOutSlowInInterpolator();
    static final Interpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    private static final Pools.Pool<C6546d> sTabPool = new Pools.SynchronizedPool(16);

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes12.dex */
    public @interface Mode {
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnTabClickListener {
        void onTabClick(C6546d c6546d);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnTabSelectedListener {
        void onTabReselected(C6546d c6546d);

        void onTabSelected(C6546d c6546d);

        void onTabUnselected(C6546d c6546d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class SlidingTabStrip extends LinearLayout {
        private ValueAnimator mIndicatorAnimator;
        private int mIndicatorLeft;
        private int mIndicatorRight;
        private int mLayoutDirection;
        private int mSelectedIndicatorBottomGap;
        private int mSelectedIndicatorHeight;
        private final Paint mSelectedIndicatorPaint;
        private int mSelectedIndicatorRadius;
        private int mSelectedIndicatorWidth;
        private int mSelectedIndicatorZIndex;
        int mSelectedPosition;
        float mSelectionOffset;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout$SlidingTabStrip$a */
        /* loaded from: classes12.dex */
        public class C6541a implements ValueAnimator.AnimatorUpdateListener {
            final /* synthetic */ int a;
            final /* synthetic */ int b;
            final /* synthetic */ int c;
            final /* synthetic */ int d;

            C6541a(int i, int i2, int i3, int i4) {
                this.a = i;
                this.b = i2;
                this.c = i3;
                this.d = i4;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                SlidingTabStrip.this.setIndicatorPosition(C6548a.a(this.a, this.b, animatedFraction), C6548a.a(this.c, this.d, animatedFraction));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout$SlidingTabStrip$b */
        /* loaded from: classes12.dex */
        public class C6542b extends AnimatorListenerAdapter {
            final /* synthetic */ int a;

            C6542b(int i) {
                this.a = i;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SlidingTabStrip slidingTabStrip = SlidingTabStrip.this;
                slidingTabStrip.mSelectedPosition = this.a;
                slidingTabStrip.mSelectionOffset = 0.0f;
            }
        }

        SlidingTabStrip(Context context) {
            super(context);
            this.mSelectedIndicatorZIndex = 1;
            this.mSelectedPosition = -1;
            this.mLayoutDirection = -1;
            this.mIndicatorLeft = -1;
            this.mIndicatorRight = -1;
            setWillNotDraw(false);
            this.mSelectedIndicatorPaint = new Paint();
        }

        private void updateIndicatorPosition() {
            int i;
            int i2;
            View childAt = getChildAt(this.mSelectedPosition);
            if (childAt == null || childAt.getWidth() <= 0) {
                i = -1;
                i2 = -1;
            } else {
                i = childAt.getLeft();
                i2 = childAt.getRight();
                if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                    View childAt2 = getChildAt(this.mSelectedPosition + 1);
                    float left = this.mSelectionOffset * childAt2.getLeft();
                    float f = this.mSelectionOffset;
                    i = (int) (left + ((1.0f - f) * i));
                    i2 = (int) ((f * childAt2.getRight()) + ((1.0f - this.mSelectionOffset) * i2));
                }
            }
            setIndicatorPosition(i, i2);
        }

        void animateIndicatorToPosition(int i, int i2) {
            int i3;
            int i4;
            ValueAnimator valueAnimator = this.mIndicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
            }
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                updateIndicatorPosition();
                return;
            }
            int left = childAt.getLeft();
            int right = childAt.getRight();
            if (Math.abs(i - this.mSelectedPosition) <= 1) {
                i3 = this.mIndicatorLeft;
                i4 = this.mIndicatorRight;
            } else {
                int dpToPx = TabLayout.this.dpToPx(24);
                i3 = (i >= this.mSelectedPosition ? !z : z) ? left - dpToPx : dpToPx + right;
                i4 = i3;
            }
            if (i3 == left && i4 == right) {
                return;
            }
            ValueAnimator valueAnimator2 = new ValueAnimator();
            this.mIndicatorAnimator = valueAnimator2;
            valueAnimator2.setInterpolator(C6548a.b);
            valueAnimator2.setDuration(i2);
            valueAnimator2.setFloatValues(0.0f, 1.0f);
            valueAnimator2.addUpdateListener(new C6541a(i3, left, i4, right));
            valueAnimator2.addListener(new C6542b(i));
            valueAnimator2.start();
        }

        boolean childrenNeedLayout() {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (getChildAt(i).getWidth() <= 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            if (this.mSelectedIndicatorZIndex < 1) {
                drawIndicator(canvas);
            }
            super.draw(canvas);
            if (this.mSelectedIndicatorZIndex >= 1) {
                drawIndicator(canvas);
            }
        }

        protected void drawIndicator(Canvas canvas) {
            int i;
            int i2 = this.mIndicatorLeft;
            if (i2 < 0 || (i = this.mIndicatorRight) <= i2) {
                return;
            }
            int i3 = this.mSelectedIndicatorWidth;
            if (i3 > 0 && i - i2 > i3) {
                int i4 = ((i - i2) - i3) / 2;
                this.mIndicatorLeft = i2 + i4;
                this.mIndicatorRight = i - i4;
            }
            RectF rectF = new RectF();
            rectF.left = this.mIndicatorLeft;
            rectF.right = this.mIndicatorRight;
            if (this.mSelectedIndicatorBottomGap > 0) {
                rectF.top = (getHeight() - this.mSelectedIndicatorHeight) - this.mSelectedIndicatorBottomGap;
                rectF.bottom = getHeight() - this.mSelectedIndicatorBottomGap;
            } else {
                rectF.top = getHeight() - this.mSelectedIndicatorHeight;
                rectF.bottom = getHeight();
            }
            int i5 = this.mSelectedIndicatorRadius;
            if (i5 > 0) {
                canvas.drawRoundRect(rectF, i5, i5, this.mSelectedIndicatorPaint);
            } else {
                canvas.drawRect(rectF, this.mSelectedIndicatorPaint);
            }
        }

        float getIndicatorPosition() {
            return this.mSelectedPosition + this.mSelectionOffset;
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            ValueAnimator valueAnimator = this.mIndicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
                animateIndicatorToPosition(this.mSelectedPosition, Math.round((1.0f - this.mIndicatorAnimator.getAnimatedFraction()) * ((float) this.mIndicatorAnimator.getDuration())));
                return;
            }
            updateIndicatorPosition();
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (View.MeasureSpec.getMode(i) != 1073741824) {
                return;
            }
            TabLayout tabLayout = TabLayout.this;
            boolean z = true;
            if (tabLayout.mMode == 1 && tabLayout.mTabGravity == 1) {
                int childCount = getChildCount();
                int i3 = 0;
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt = getChildAt(i4);
                    if (childAt.getVisibility() == 0) {
                        i3 = Math.max(i3, childAt.getMeasuredWidth());
                    }
                }
                if (i3 <= 0) {
                    return;
                }
                if (i3 * childCount <= getMeasuredWidth() - (TabLayout.this.dpToPx(16) * 2)) {
                    boolean z2 = false;
                    for (int i5 = 0; i5 < childCount; i5++) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i5).getLayoutParams();
                        if (layoutParams.width != i3 || layoutParams.weight != 0.0f) {
                            layoutParams.width = i3;
                            layoutParams.weight = 0.0f;
                            z2 = true;
                        }
                    }
                    z = z2;
                } else {
                    TabLayout tabLayout2 = TabLayout.this;
                    tabLayout2.mTabGravity = 0;
                    tabLayout2.updateTabViews(false);
                }
                if (z) {
                    super.onMeasure(i, i2);
                }
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onRtlPropertiesChanged(int i) {
            super.onRtlPropertiesChanged(i);
            if (Build.VERSION.SDK_INT >= 23 || this.mLayoutDirection == i) {
                return;
            }
            requestLayout();
            this.mLayoutDirection = i;
        }

        void setIndicatorPosition(int i, int i2) {
            if (i == this.mIndicatorLeft && i2 == this.mIndicatorRight) {
                return;
            }
            this.mIndicatorLeft = i;
            this.mIndicatorRight = i2;
            ViewCompat.postInvalidateOnAnimation(this);
        }

        void setIndicatorPositionFromTabPosition(int i, float f) {
            ValueAnimator valueAnimator = this.mIndicatorAnimator;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mIndicatorAnimator.cancel();
            }
            this.mSelectedPosition = i;
            this.mSelectionOffset = f;
            updateIndicatorPosition();
        }

        void setSelectedIndicatorColor(int i) {
            if (this.mSelectedIndicatorPaint.getColor() != i) {
                this.mSelectedIndicatorPaint.setColor(i);
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setSelectedIndicatorHeight(int i) {
            if (this.mSelectedIndicatorHeight != i) {
                this.mSelectedIndicatorHeight = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setSelectedIndicatorWidth(int i) {
            if (this.mSelectedIndicatorWidth != i) {
                this.mSelectedIndicatorWidth = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setSelectedTabIndicatorBottomGap(int i) {
            if (this.mSelectedIndicatorBottomGap != i) {
                this.mSelectedIndicatorBottomGap = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setSelectedTabIndicatorRadius(int i) {
            if (this.mSelectedIndicatorRadius != i) {
                this.mSelectedIndicatorRadius = i;
                ViewCompat.postInvalidateOnAnimation(this);
            }
        }

        void setSelectedTabIndicatorZIndex(int i) {
            this.mSelectedIndicatorZIndex = i;
        }
    }

    /* compiled from: Taobao */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes12.dex */
    public @interface TabGravity {
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class TabLayoutOnPageChangeListener implements ViewPager.OnPageChangeListener {
        private final WeakReference<TabLayout> a;
        private int b;
        private int c;

        public TabLayoutOnPageChangeListener(TabLayout tabLayout) {
            this.a = new WeakReference<>(tabLayout);
        }

        void a() {
            this.c = 0;
            this.b = 0;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
            this.b = this.c;
            this.c = i;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            boolean z;
            boolean z2;
            TabLayout tabLayout = this.a.get();
            if (tabLayout != null) {
                int i3 = this.c;
                boolean z3 = false;
                boolean z4 = i3 != 2 || this.b == 1;
                boolean z5 = (i3 == 2 && this.b == 0) ? false : true;
                if (wt.t0()) {
                    int i4 = this.c;
                    boolean z6 = i4 == 2;
                    if (this.b == 0 && i4 == 0) {
                        z = z6;
                        z2 = false;
                        tabLayout.setScrollPosition(i, f, z3, z2, z, !tabLayout.mViewPagerSmoothScroll);
                    }
                    z = z6;
                    z3 = z4;
                } else {
                    z3 = z4;
                    z = false;
                }
                z2 = z5;
                tabLayout.setScrollPosition(i, f, z3, z2, z, !tabLayout.mViewPagerSmoothScroll);
            }
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            TabLayout tabLayout = this.a.get();
            if (tabLayout == null || tabLayout.getSelectedTabPosition() == i || i >= tabLayout.getTabCount()) {
                return;
            }
            int i2 = this.c;
            boolean z = i2 == 0 || (i2 == 2 && this.b == 0);
            C6546d tabAt = tabLayout.getTabAt(i);
            if (tabAt != null) {
                tabAt.p(false);
            }
            tabLayout.selectTab(tabAt, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class TabView extends LinearLayout {
        private ImageView mCustomIconView;
        private TextView mCustomTextView;
        private View mCustomView;
        private int mDefaultMaxLines;
        private ImageView mIconView;
        private C6546d mTab;
        private TextView mTextView;

        public TabView(Context context) {
            super(context);
            this.mDefaultMaxLines = 2;
            ViewCompat.setPaddingRelative(this, TabLayout.this.mTabPaddingStart, TabLayout.this.mTabPaddingTop, TabLayout.this.mTabPaddingEnd, TabLayout.this.mTabPaddingBottom);
            setGravity(17);
            setOrientation(1);
            setClickable(true);
            ViewCompat.setPointerIcon(this, PointerIconCompat.getSystemIcon(getContext(), 1002));
        }

        private float approximateLineWidth(Layout layout, int i, float f) {
            return layout.getLineWidth(i) * (f / layout.getPaint().getTextSize());
        }

        private void updateTextAndIcon(@Nullable TextView textView, @Nullable ImageView imageView) {
            C6546d c6546d = this.mTab;
            Drawable c = c6546d != null ? c6546d.c() : null;
            C6546d c6546d2 = this.mTab;
            CharSequence e = c6546d2 != null ? c6546d2.e() : null;
            C6546d c6546d3 = this.mTab;
            CharSequence a = c6546d3 != null ? c6546d3.a() : null;
            int i = 0;
            if (imageView != null) {
                if (c != null) {
                    imageView.setImageDrawable(c);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
                imageView.setContentDescription(a);
            }
            boolean z = !TextUtils.isEmpty(e);
            if (textView != null) {
                if (z) {
                    textView.setText(e);
                    textView.setVisibility(0);
                    setVisibility(0);
                } else {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                }
                textView.setContentDescription(a);
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                if (z && imageView.getVisibility() == 0) {
                    i = TabLayout.this.dpToPx(8);
                }
                if (i != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = i;
                    imageView.requestLayout();
                }
            }
            TooltipCompat.setTooltipText(this, z ? null : a);
        }

        public C6546d getTab() {
            return this.mTab;
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.view.View
        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ActionBar.Tab.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            Layout layout;
            int size = View.MeasureSpec.getSize(i);
            int mode = View.MeasureSpec.getMode(i);
            int tabMaxWidth = TabLayout.this.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i = View.MeasureSpec.makeMeasureSpec(TabLayout.this.mTabMaxWidth, Integer.MIN_VALUE);
            }
            super.onMeasure(i, i2);
            if (this.mTextView != null) {
                getResources();
                float f = TabLayout.this.mTabTextSize;
                int i3 = this.mDefaultMaxLines;
                ImageView imageView = this.mIconView;
                boolean z = true;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.mTextView;
                    if (textView != null && textView.getLineCount() > 1) {
                        f = TabLayout.this.mTabTextMultiLineSize;
                    }
                } else {
                    i3 = 1;
                }
                float textSize = this.mTextView.getTextSize();
                int lineCount = this.mTextView.getLineCount();
                int maxLines = TextViewCompat.getMaxLines(this.mTextView);
                int i4 = (f > textSize ? 1 : (f == textSize ? 0 : -1));
                if (i4 != 0 || (maxLines >= 0 && i3 != maxLines)) {
                    if (TabLayout.this.mMode == 1 && i4 > 0 && lineCount == 1 && ((layout = this.mTextView.getLayout()) == null || approximateLineWidth(layout, 0, f) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight())) {
                        z = false;
                    }
                    if (z) {
                        this.mTextView.setTextSize(0, f);
                        this.mTextView.setMaxLines(i3);
                        super.onMeasure(i, i2);
                    }
                }
            }
        }

        @Override // android.view.View
        public boolean performClick() {
            boolean performClick = super.performClick();
            if (this.mTab != null) {
                if (!performClick) {
                    playSoundEffect(0);
                }
                this.mTab.h();
                this.mTab.j(true);
                return true;
            }
            return performClick;
        }

        void reset() {
            setTab(null);
            setSelected(false);
        }

        @Override // android.view.View
        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z && Build.VERSION.SDK_INT < 16) {
                sendAccessibilityEvent(4);
            }
            TextView textView = this.mTextView;
            if (textView != null) {
                textView.setSelected(z);
            }
            ImageView imageView = this.mIconView;
            if (imageView != null) {
                imageView.setSelected(z);
            }
            View view = this.mCustomView;
            if (view != null) {
                view.setSelected(z);
            }
        }

        void setTab(@Nullable C6546d c6546d) {
            if (c6546d != this.mTab) {
                this.mTab = c6546d;
                update();
            }
        }

        final void update() {
            C6546d c6546d = this.mTab;
            View b = c6546d != null ? c6546d.b() : null;
            if (b != null) {
                ViewParent parent = b.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(b);
                    }
                    addView(b);
                }
                this.mCustomView = b;
                TextView textView = this.mTextView;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.mIconView;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.mIconView.setImageDrawable(null);
                }
                TextView textView2 = (TextView) b.findViewById(16908308);
                this.mCustomTextView = textView2;
                if (textView2 != null) {
                    this.mDefaultMaxLines = TextViewCompat.getMaxLines(textView2);
                }
                this.mCustomIconView = (ImageView) b.findViewById(16908294);
            } else {
                View view = this.mCustomView;
                if (view != null) {
                    removeView(view);
                    this.mCustomView = null;
                }
                this.mCustomTextView = null;
                this.mCustomIconView = null;
            }
            boolean z = false;
            if (this.mCustomView == null) {
                if (this.mIconView == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R.C4818layout.design_layout_tab_icon, (ViewGroup) this, false);
                    addView(imageView2, 0);
                    this.mIconView = imageView2;
                }
                if (this.mTextView == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R.C4818layout.design_layout_tab_text, (ViewGroup) this, false);
                    addView(textView3);
                    this.mTextView = textView3;
                    this.mDefaultMaxLines = TextViewCompat.getMaxLines(textView3);
                }
                TextViewCompat.setTextAppearance(this.mTextView, TabLayout.this.mTabTextAppearance);
                ColorStateList colorStateList = TabLayout.this.mTabTextColors;
                if (colorStateList != null) {
                    this.mTextView.setTextColor(colorStateList);
                }
                updateTextAndIcon(this.mTextView, this.mIconView);
            } else {
                TextView textView4 = this.mCustomTextView;
                if (textView4 != null || this.mCustomIconView != null) {
                    updateTextAndIcon(textView4, this.mCustomIconView);
                }
            }
            if (c6546d != null && c6546d.f()) {
                z = true;
            }
            setSelected(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout$a */
    /* loaded from: classes12.dex */
    public class C6543a implements ValueAnimator.AnimatorUpdateListener {
        C6543a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            TabLayout.this.scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout$b */
    /* loaded from: classes11.dex */
    public class C6544b implements ViewPager.OnAdapterChangeListener {
        private boolean a;

        C6544b() {
        }

        void a(boolean z) {
            this.a = z;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnAdapterChangeListener
        public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter pagerAdapter, @Nullable PagerAdapter pagerAdapter2) {
            TabLayout tabLayout = TabLayout.this;
            if (tabLayout.mViewPager == viewPager) {
                tabLayout.setPagerAdapter(pagerAdapter2, this.a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout$c */
    /* loaded from: classes12.dex */
    public class C6545c extends DataSetObserver {
        C6545c() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            TabLayout.this.populateFromPagerAdapter();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            TabLayout.this.populateFromPagerAdapter();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout$d */
    /* loaded from: classes12.dex */
    public static final class C6546d {
        public static final int INVALID_POSITION = -1;
        private Drawable a;
        private CharSequence b;
        private CharSequence c;
        private int d = -1;
        private View e;
        private boolean f;
        TabLayout g;
        TabView h;

        C6546d() {
        }

        @Nullable
        public CharSequence a() {
            return this.c;
        }

        @Nullable
        public View b() {
            return this.e;
        }

        @Nullable
        public Drawable c() {
            return this.a;
        }

        public int d() {
            return this.d;
        }

        @Nullable
        public CharSequence e() {
            return this.b;
        }

        public boolean f() {
            TabLayout tabLayout = this.g;
            if (tabLayout != null) {
                return tabLayout.getSelectedTabPosition() == this.d;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        public boolean g() {
            return this.f;
        }

        public void h() {
            TabLayout tabLayout = this.g;
            if (tabLayout != null) {
                tabLayout.onTabClick(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        void i() {
            this.g = null;
            this.h = null;
            this.a = null;
            this.b = null;
            this.c = null;
            this.d = -1;
            this.e = null;
        }

        public void j(boolean z) {
            if (this.g != null) {
                p(z);
                this.g.selectTab(this);
                return;
            }
            throw new IllegalArgumentException("Tab not attached to a TabLayout");
        }

        @NonNull
        public C6546d k(@Nullable CharSequence charSequence) {
            this.c = charSequence;
            r();
            return this;
        }

        @NonNull
        public C6546d l(@LayoutRes int i) {
            return m(LayoutInflater.from(this.h.getContext()).inflate(i, (ViewGroup) this.h, false));
        }

        @NonNull
        public C6546d m(@Nullable View view) {
            this.e = view;
            r();
            return this;
        }

        @NonNull
        public C6546d n(@Nullable Drawable drawable) {
            this.a = drawable;
            r();
            return this;
        }

        void o(int i) {
            this.d = i;
        }

        public void p(boolean z) {
            this.f = z;
        }

        @NonNull
        public C6546d q(@Nullable CharSequence charSequence) {
            this.b = charSequence;
            r();
            return this;
        }

        void r() {
            TabView tabView = this.h;
            if (tabView != null) {
                tabView.update();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout$e */
    /* loaded from: classes11.dex */
    public static class C6547e implements OnTabSelectedListener {
        private final ViewPager a;
        private final boolean b;

        public C6547e(ViewPager viewPager, boolean z) {
            this.a = viewPager;
            this.b = z;
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabSelectedListener
        public void onTabReselected(C6546d c6546d) {
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabSelectedListener
        public void onTabSelected(C6546d c6546d) {
            if (this.b) {
                this.a.setCurrentItem(c6546d.d());
            } else {
                this.a.setCurrentItem(c6546d.d(), false);
            }
        }

        @Override // com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.OnTabSelectedListener
        public void onTabUnselected(C6546d c6546d) {
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    private void addTabFromItemView(@NonNull TabItem tabItem) {
        C6546d newTab = newTab();
        CharSequence charSequence = tabItem.mText;
        if (charSequence != null) {
            newTab.q(charSequence);
        }
        Drawable drawable = tabItem.mIcon;
        if (drawable != null) {
            newTab.n(drawable);
        }
        int i = tabItem.mCustomLayout;
        if (i != 0) {
            newTab.l(i);
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            newTab.k(tabItem.getContentDescription());
        }
        addTab(newTab);
    }

    private void addTabView(C6546d c6546d) {
        this.mTabStrip.addView(c6546d.h, c6546d.d(), createLayoutParamsForTabs());
    }

    private void addViewInternal(View view) {
        if (view instanceof TabItem) {
            addTabFromItemView((TabItem) view);
            return;
        }
        throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
    }

    private void animateToTab(int i) {
        if (i == -1) {
            return;
        }
        if (getWindowToken() != null && ViewCompat.isLaidOut(this) && !this.mTabStrip.childrenNeedLayout()) {
            int scrollX = getScrollX();
            int calculateScrollXForTab = calculateScrollXForTab(i, 0.0f);
            if (scrollX != calculateScrollXForTab) {
                ensureScrollAnimator();
                this.mScrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
                this.mScrollAnimator.start();
            }
            this.mTabStrip.animateIndicatorToPosition(i, 300);
            return;
        }
        setScrollPosition(i, 0.0f, true);
    }

    private void applyModeAndGravity() {
        ViewCompat.setPaddingRelative(this.mTabStrip, this.mMode == 0 ? Math.max(0, this.mContentInsetStart - this.mTabPaddingStart) : 0, 0, 0, 0);
        int i = this.mMode;
        if (i == 0) {
            this.mTabStrip.setGravity(GravityCompat.START);
        } else if (i == 1) {
            this.mTabStrip.setGravity(1);
        }
        updateTabViews(true);
    }

    private int calculateScrollXForTab(int i, float f) {
        if (this.mMode == 0) {
            View childAt = this.mTabStrip.getChildAt(i);
            int i2 = i + 1;
            View childAt2 = i2 < this.mTabStrip.getChildCount() ? this.mTabStrip.getChildAt(i2) : null;
            int width = childAt != null ? childAt.getWidth() : 0;
            int width2 = childAt2 != null ? childAt2.getWidth() : 0;
            int left = (childAt.getLeft() + (width / 2)) - (getWidth() / 2);
            int i3 = (int) ((width + width2) * 0.5f * f);
            return ViewCompat.getLayoutDirection(this) == 0 ? left + i3 : left - i3;
        }
        return 0;
    }

    private void configureTab(C6546d c6546d, int i) {
        c6546d.o(i);
        this.mTabs.add(i, c6546d);
        int size = this.mTabs.size();
        while (true) {
            i++;
            if (i >= size) {
                return;
            }
            this.mTabs.get(i).o(i);
        }
    }

    private static ColorStateList createColorStateList(int i, int i2) {
        return new ColorStateList(new int[][]{HorizontalScrollView.SELECTED_STATE_SET, HorizontalScrollView.EMPTY_STATE_SET}, new int[]{i2, i});
    }

    private LinearLayout.LayoutParams createLayoutParamsForTabs() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        updateTabViewLayoutParams(layoutParams);
        return layoutParams;
    }

    private TabView createTabView(@NonNull C6546d c6546d) {
        Pools.Pool<TabView> pool = this.mTabViewPool;
        TabView acquire = pool != null ? pool.acquire() : null;
        if (acquire == null) {
            acquire = new TabView(getContext());
        }
        acquire.setTab(c6546d);
        acquire.setFocusable(true);
        return acquire;
    }

    private void dispatchTabReselected(@NonNull C6546d c6546d) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabReselected(c6546d);
        }
    }

    private void dispatchTabSelected(@NonNull C6546d c6546d) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabSelected(c6546d);
        }
    }

    private void dispatchTabUnselected(@NonNull C6546d c6546d) {
        for (int size = this.mSelectedListeners.size() - 1; size >= 0; size--) {
            this.mSelectedListeners.get(size).onTabUnselected(c6546d);
        }
    }

    private void ensureScrollAnimator() {
        if (this.mScrollAnimator == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.mScrollAnimator = valueAnimator;
            valueAnimator.setInterpolator(C6548a.a);
            this.mScrollAnimator.setDuration(300L);
            this.mScrollAnimator.addUpdateListener(new C6543a());
        }
    }

    private int getDefaultHeight() {
        int size = this.mTabs.size();
        boolean z = false;
        int i = 0;
        while (true) {
            if (i < size) {
                C6546d c6546d = this.mTabs.get(i);
                if (c6546d != null && c6546d.c() != null && !TextUtils.isEmpty(c6546d.e())) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return z ? 72 : 48;
    }

    private float getScrollPosition() {
        return this.mTabStrip.getIndicatorPosition();
    }

    private int getTabMinWidth() {
        int i = this.mRequestedTabMinWidth;
        if (i != -1) {
            return i;
        }
        if (this.mMode == 0) {
            return this.mScrollableTabMinWidth;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.mTabStrip.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void removeTabViewAt(int i) {
        TabView tabView = (TabView) this.mTabStrip.getChildAt(i);
        this.mTabStrip.removeViewAt(i);
        if (tabView != null) {
            tabView.reset();
            this.mTabViewPool.release(tabView);
        }
        requestLayout();
    }

    private void setSelectedTabView(int i) {
        int childCount = this.mTabStrip.getChildCount();
        if (i < childCount) {
            int i2 = 0;
            while (i2 < childCount) {
                this.mTabStrip.getChildAt(i2).setSelected(i2 == i);
                i2++;
            }
        }
    }

    private void updateAllTabs() {
        int size = this.mTabs.size();
        for (int i = 0; i < size; i++) {
            this.mTabs.get(i).r();
        }
    }

    private void updateTabViewLayoutParams(LinearLayout.LayoutParams layoutParams) {
        if (this.mMode == 1 && this.mTabGravity == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
            return;
        }
        layoutParams.width = -2;
        layoutParams.weight = 0.0f;
    }

    public void addOnTabClickListener(@NonNull OnTabClickListener onTabClickListener) {
        if (this.mOnTabClickListeners.contains(onTabClickListener)) {
            return;
        }
        this.mOnTabClickListeners.add(onTabClickListener);
    }

    public void addOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        if (this.mSelectedListeners.contains(onTabSelectedListener)) {
            return;
        }
        this.mSelectedListeners.add(onTabSelectedListener);
    }

    public void addTab(@NonNull C6546d c6546d) {
        addTab(c6546d, this.mTabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view) {
        addViewInternal(view);
    }

    public void clearOnTabClickListeners() {
        this.mOnTabClickListeners.clear();
    }

    public void clearOnTabSelectedListeners() {
        this.mSelectedListeners.clear();
    }

    int dpToPx(int i) {
        return Math.round(getResources().getDisplayMetrics().density * i);
    }

    public int getSelectedTabPosition() {
        C6546d c6546d = this.mSelectedTab;
        if (c6546d != null) {
            return c6546d.d();
        }
        return -1;
    }

    @Nullable
    public C6546d getTabAt(int i) {
        if (i < 0 || i >= getTabCount()) {
            return null;
        }
        return this.mTabs.get(i);
    }

    public int getTabCount() {
        return this.mTabs.size();
    }

    public int getTabGravity() {
        return this.mTabGravity;
    }

    int getTabMaxWidth() {
        return this.mTabMaxWidth;
    }

    public int getTabMode() {
        return this.mMode;
    }

    @Nullable
    public ColorStateList getTabTextColors() {
        return this.mTabTextColors;
    }

    @NonNull
    public C6546d newTab() {
        C6546d acquire = sTabPool.acquire();
        if (acquire == null) {
            acquire = new C6546d();
        }
        acquire.g = this;
        acquire.h = createTabView(acquire);
        return acquire;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mViewPager == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                setupWithViewPager((ViewPager) parent, true, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mSetupViewPagerImplicitly) {
            setupWithViewPager(null);
            this.mSetupViewPagerImplicitly = false;
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C6546d c6546d;
        super.onLayout(z, i, i2, i3, i4);
        if (this.mMode != 0 || (c6546d = this.mSelectedTab) == null || c6546d.d() <= 0) {
            return;
        }
        selectTab(this.mSelectedTab);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0067, code lost:
        if (r1.getMeasuredWidth() != getMeasuredWidth()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0072, code lost:
        if (r1.getMeasuredWidth() < getMeasuredWidth()) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0075, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0076, code lost:
        r6 = r0;
     */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.getDefaultHeight()
            int r0 = r5.dpToPx(r0)
            int r1 = r5.getPaddingTop()
            int r0 = r0 + r1
            int r1 = r5.getPaddingBottom()
            int r0 = r0 + r1
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r1 == r2) goto L24
            if (r1 == 0) goto L1f
            goto L30
        L1f:
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r3)
            goto L30
        L24:
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            int r7 = java.lang.Math.min(r0, r7)
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
        L30:
            int r0 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r6)
            if (r1 == 0) goto L49
            int r1 = r5.mRequestedTabMaxWidth
            if (r1 <= 0) goto L3f
            goto L47
        L3f:
            r1 = 56
            int r1 = r5.dpToPx(r1)
            int r1 = r0 - r1
        L47:
            r5.mTabMaxWidth = r1
        L49:
            super.onMeasure(r6, r7)
            int r6 = r5.getChildCount()
            r0 = 1
            if (r6 != r0) goto L97
            r6 = 0
            android.view.View r1 = r5.getChildAt(r6)
            int r2 = r5.mMode
            if (r2 == 0) goto L6a
            if (r2 == r0) goto L5f
            goto L77
        L5f:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 == r4) goto L75
            goto L76
        L6a:
            int r2 = r1.getMeasuredWidth()
            int r4 = r5.getMeasuredWidth()
            if (r2 >= r4) goto L75
            goto L76
        L75:
            r0 = 0
        L76:
            r6 = r0
        L77:
            if (r6 == 0) goto L97
            int r6 = r5.getPaddingTop()
            int r0 = r5.getPaddingBottom()
            int r6 = r6 + r0
            android.view.ViewGroup$LayoutParams r0 = r1.getLayoutParams()
            int r0 = r0.height
            int r6 = android.widget.HorizontalScrollView.getChildMeasureSpec(r7, r6, r0)
            int r7 = r5.getMeasuredWidth()
            int r7 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r3)
            r1.measure(r7, r6)
        L97:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.viewpager.tab.view.TabLayout.onMeasure(int, int):void");
    }

    void onTabClick(C6546d c6546d) {
        for (int i = 0; i < this.mOnTabClickListeners.size(); i++) {
            this.mOnTabClickListeners.get(i).onTabClick(c6546d);
        }
    }

    void populateFromPagerAdapter() {
        int currentItem;
        removeAllTabs();
        PagerAdapter pagerAdapter = this.mPagerAdapter;
        if (pagerAdapter != null) {
            int count = pagerAdapter.getCount();
            for (int i = 0; i < count; i++) {
                addTab(newTab().q(this.mPagerAdapter.getPageTitle(i)), false);
            }
            ViewPager viewPager = this.mViewPager;
            if (viewPager == null || count <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            C6546d tabAt = getTabAt(currentItem);
            if (tabAt != null) {
                tabAt.p(false);
            }
            selectTab(tabAt);
        }
    }

    public void removeAllTabs() {
        for (int childCount = this.mTabStrip.getChildCount() - 1; childCount >= 0; childCount--) {
            removeTabViewAt(childCount);
        }
        Iterator<C6546d> it = this.mTabs.iterator();
        while (it.hasNext()) {
            C6546d next = it.next();
            it.remove();
            next.i();
            sTabPool.release(next);
        }
        this.mSelectedTab = null;
    }

    public void removeOnTabClickListener(@NonNull OnTabClickListener onTabClickListener) {
        this.mOnTabClickListeners.remove(onTabClickListener);
    }

    public void removeOnTabSelectedListener(@NonNull OnTabSelectedListener onTabSelectedListener) {
        this.mSelectedListeners.remove(onTabSelectedListener);
    }

    public void removeTab(C6546d c6546d) {
        if (c6546d.g == this) {
            removeTabAt(c6546d.d());
            return;
        }
        throw new IllegalArgumentException("Tab does not belong to this TabLayout.");
    }

    public void removeTabAt(int i) {
        C6546d c6546d = this.mSelectedTab;
        int d = c6546d != null ? c6546d.d() : 0;
        removeTabViewAt(i);
        C6546d remove = this.mTabs.remove(i);
        if (remove != null) {
            remove.i();
            sTabPool.release(remove);
        }
        int size = this.mTabs.size();
        for (int i2 = i; i2 < size; i2++) {
            this.mTabs.get(i2).o(i2);
        }
        if (d == i) {
            C6546d c6546d2 = this.mTabs.isEmpty() ? null : this.mTabs.get(Math.max(0, i - 1));
            if (c6546d2 != null) {
                c6546d2.p(false);
            }
            selectTab(c6546d2);
        }
    }

    public void selectTab(C6546d c6546d) {
        selectTab(c6546d, true);
    }

    void setPagerAdapter(@Nullable PagerAdapter pagerAdapter, boolean z) {
        DataSetObserver dataSetObserver;
        PagerAdapter pagerAdapter2 = this.mPagerAdapter;
        if (pagerAdapter2 != null && (dataSetObserver = this.mPagerAdapterObserver) != null) {
            pagerAdapter2.unregisterDataSetObserver(dataSetObserver);
        }
        this.mPagerAdapter = pagerAdapter;
        if (z && pagerAdapter != null) {
            if (this.mPagerAdapterObserver == null) {
                this.mPagerAdapterObserver = new C6545c();
            }
            pagerAdapter.registerDataSetObserver(this.mPagerAdapterObserver);
        }
        populateFromPagerAdapter();
    }

    void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        ensureScrollAnimator();
        this.mScrollAnimator.addListener(animatorListener);
    }

    public void setScrollPosition(int i, float f, boolean z) {
        setScrollPosition(i, f, z, true);
    }

    public void setSelectedTab(C6546d c6546d) {
        this.mSelectedTab = c6546d;
    }

    public void setSelectedTabIndicatorBottomGap(int i) {
        this.mTabStrip.setSelectedTabIndicatorBottomGap(i);
    }

    public void setSelectedTabIndicatorColor(@ColorInt int i) {
        this.mTabStrip.setSelectedIndicatorColor(i);
    }

    public void setSelectedTabIndicatorHeight(int i) {
        this.mTabStrip.setSelectedIndicatorHeight(i);
    }

    public void setSelectedTabIndicatorRadius(int i) {
        this.mTabStrip.setSelectedTabIndicatorRadius(i);
    }

    public void setSelectedTabIndicatorWidth(int i) {
        this.mTabStrip.setSelectedIndicatorWidth(i);
    }

    public void setSelectedTabIndicatorZIndex(int i) {
        this.mTabStrip.setSelectedTabIndicatorZIndex(i);
    }

    public void setTabGravity(int i) {
        if (this.mTabGravity != i) {
            this.mTabGravity = i;
            applyModeAndGravity();
        }
    }

    public void setTabMode(int i) {
        if (i != this.mMode) {
            this.mMode = i;
            applyModeAndGravity();
        }
    }

    public void setTabTextColors(@Nullable ColorStateList colorStateList) {
        if (this.mTabTextColors != colorStateList) {
            this.mTabTextColors = colorStateList;
            updateAllTabs();
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(@Nullable PagerAdapter pagerAdapter) {
        setPagerAdapter(pagerAdapter, false);
    }

    public void setViewPagerSmoothScroll(boolean z) {
        this.mViewPagerSmoothScroll = z;
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager) {
        setupWithViewPager(viewPager, true);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    void updateTabViews(boolean z) {
        for (int i = 0; i < this.mTabStrip.getChildCount(); i++) {
            View childAt = this.mTabStrip.getChildAt(i);
            childAt.setMinimumWidth(getTabMinWidth());
            updateTabViewLayoutParams((LinearLayout.LayoutParams) childAt.getLayoutParams());
            if (z) {
                childAt.requestLayout();
            }
        }
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void addTab(@NonNull C6546d c6546d, int i) {
        addTab(c6546d, i, this.mTabs.isEmpty());
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i) {
        addViewInternal(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    void selectTab(C6546d c6546d, boolean z) {
        C6546d c6546d2 = this.mSelectedTab;
        if (c6546d2 == c6546d) {
            if (c6546d2 != null) {
                dispatchTabReselected(c6546d);
                animateToTab(c6546d.d());
                return;
            }
            return;
        }
        int d = c6546d != null ? c6546d.d() : -1;
        if (z) {
            if ((c6546d2 == null || c6546d2.d() == -1) && d != -1) {
                setScrollPosition(d, 0.0f, true);
            } else {
                animateToTab(d);
            }
            if (d != -1) {
                setSelectedTabView(d);
            }
        }
        if (c6546d2 != null) {
            dispatchTabUnselected(c6546d2);
        }
        this.mSelectedTab = c6546d;
        if (c6546d != null) {
            dispatchTabSelected(c6546d);
        }
    }

    void setScrollPosition(int i, float f, boolean z, boolean z2) {
        setScrollPosition(i, f, z, z2, false, false);
    }

    public void setupWithViewPager(@Nullable ViewPager viewPager, boolean z) {
        setupWithViewPager(viewPager, z, false);
    }

    public TabLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTabs = new ArrayList<>();
        this.mTabMaxWidth = Integer.MAX_VALUE;
        this.mRequestedTabMinWidth = -1;
        this.mRequestedTabMaxWidth = -1;
        this.mTabGravity = 0;
        this.mMode = 1;
        this.mOnTabClickListeners = new ArrayList<>();
        this.mSelectedListeners = new ArrayList<>();
        this.mTabViewPool = new Pools.SimplePool(12);
        C6549b.a(context);
        setHorizontalScrollBarEnabled(false);
        SlidingTabStrip slidingTabStrip = new SlidingTabStrip(context);
        this.mTabStrip = slidingTabStrip;
        super.addView(slidingTabStrip, 0, new FrameLayout.LayoutParams(-2, -1));
        Resources resources = getResources();
        this.mTabTextMultiLineSize = resources.getDimensionPixelSize(R.dimen.design_tab_text_size_2line);
        this.mScrollableTabMinWidth = resources.getDimensionPixelSize(R.dimen.design_tab_scrollable_min_width);
        applyModeAndGravity();
    }

    private void setupWithViewPager(@Nullable ViewPager viewPager, boolean z, boolean z2) {
        ViewPager viewPager2 = this.mViewPager;
        if (viewPager2 != null) {
            TabLayoutOnPageChangeListener tabLayoutOnPageChangeListener = this.mPageChangeListener;
            if (tabLayoutOnPageChangeListener != null) {
                viewPager2.removeOnPageChangeListener(tabLayoutOnPageChangeListener);
            }
            C6544b c6544b = this.mAdapterChangeListener;
            if (c6544b != null) {
                this.mViewPager.removeOnAdapterChangeListener(c6544b);
            }
        }
        OnTabSelectedListener onTabSelectedListener = this.mCurrentVpSelectedListener;
        if (onTabSelectedListener != null) {
            removeOnTabSelectedListener(onTabSelectedListener);
            this.mCurrentVpSelectedListener = null;
        }
        if (viewPager != null) {
            this.mViewPager = viewPager;
            if (this.mPageChangeListener == null) {
                this.mPageChangeListener = new TabLayoutOnPageChangeListener(this);
            }
            this.mPageChangeListener.a();
            viewPager.addOnPageChangeListener(this.mPageChangeListener);
            C6547e c6547e = new C6547e(viewPager, this.mViewPagerSmoothScroll);
            this.mCurrentVpSelectedListener = c6547e;
            addOnTabSelectedListener(c6547e);
            PagerAdapter adapter = viewPager.getAdapter();
            if (adapter != null) {
                setPagerAdapter(adapter, z);
            }
            if (this.mAdapterChangeListener == null) {
                this.mAdapterChangeListener = new C6544b();
            }
            this.mAdapterChangeListener.a(z);
            viewPager.addOnAdapterChangeListener(this.mAdapterChangeListener);
            setScrollPosition(viewPager.getCurrentItem(), 0.0f, true);
        } else {
            this.mViewPager = null;
            setPagerAdapter(null, false);
        }
        this.mSetupViewPagerImplicitly = z2;
    }

    public void addTab(@NonNull C6546d c6546d, boolean z) {
        addTab(c6546d, this.mTabs.size(), z);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    void setScrollPosition(int i, float f, boolean z, boolean z2, boolean z3, boolean z4) {
        int round = Math.round(i + f);
        if (z3 && round != getSelectedTabPosition()) {
            round = getSelectedTabPosition();
        }
        if (round < 0 || round >= this.mTabStrip.getChildCount()) {
            return;
        }
        if (z2) {
            this.mTabStrip.setIndicatorPositionFromTabPosition(i, f);
        }
        ValueAnimator valueAnimator = this.mScrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.mScrollAnimator.cancel();
        }
        int scrollX = getScrollX();
        int calculateScrollXForTab = calculateScrollXForTab(i, f);
        if (!z4) {
            scrollTo(calculateScrollXForTab(i, f), 0);
        } else if (scrollX != calculateScrollXForTab) {
            ensureScrollAnimator();
            this.mScrollAnimator.setIntValues(scrollX, calculateScrollXForTab);
            this.mScrollAnimator.start();
        }
        if (z) {
            setSelectedTabView(round);
        }
    }

    public void addTab(@NonNull C6546d c6546d, int i, boolean z) {
        if (c6546d.g == this) {
            configureTab(c6546d, i);
            addTabView(c6546d);
            if (z) {
                c6546d.j(false);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        addViewInternal(view);
    }

    public void setTabTextColors(int i, int i2) {
        setTabTextColors(createColorStateList(i, i2));
    }
}
