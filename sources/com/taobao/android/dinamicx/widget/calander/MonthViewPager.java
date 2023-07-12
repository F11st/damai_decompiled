package com.taobao.android.dinamicx.widget.calander;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.taobao.android.dinamicx.widget.calander.CalendarView;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class MonthViewPager extends ViewPager {
    private boolean isUpdateMonthView;
    private boolean isUsingScrollToCalendar;
    private int mCurrentViewHeight;
    private C6488b mDelegate;
    private int mMonthCount;
    private int mNextViewHeight;
    private int mPreViewHeight;
    WeekBar mWeekBar;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.calander.MonthViewPager$a */
    /* loaded from: classes11.dex */
    public class C6485a implements ViewPager.OnPageChangeListener {
        C6485a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
            float f2;
            int i3;
            if (MonthViewPager.this.mDelegate.w() == 0) {
                return;
            }
            if (i < MonthViewPager.this.getCurrentItem()) {
                f2 = MonthViewPager.this.mPreViewHeight * (1.0f - f);
                i3 = MonthViewPager.this.mCurrentViewHeight;
            } else {
                f2 = MonthViewPager.this.mCurrentViewHeight * (1.0f - f);
                i3 = MonthViewPager.this.mNextViewHeight;
            }
            ViewGroup.LayoutParams layoutParams = MonthViewPager.this.getLayoutParams();
            layoutParams.height = (int) (f2 + (i3 * f));
            MonthViewPager.this.setLayoutParams(layoutParams);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            Calendar e = C6487a.e(i, MonthViewPager.this.mDelegate);
            if (MonthViewPager.this.getVisibility() == 0) {
                if (MonthViewPager.this.mDelegate.M != null && e.getYear() != MonthViewPager.this.mDelegate.M.getYear() && MonthViewPager.this.mDelegate.H != null) {
                    MonthViewPager.this.mDelegate.H.onYearChange(e.getYear());
                }
                MonthViewPager.this.mDelegate.M = e;
            }
            if (MonthViewPager.this.mDelegate.I != null) {
                MonthViewPager.this.mDelegate.I.onMonthChange(e.getYear(), e.getMonth());
            }
            if (MonthViewPager.this.mDelegate.y() != 0) {
                if (e.isSameMonth(MonthViewPager.this.mDelegate.L)) {
                    MonthViewPager.this.mDelegate.M = MonthViewPager.this.mDelegate.L;
                }
            } else {
                if (!e.isCurrentMonth()) {
                    MonthViewPager.this.mDelegate.L = e;
                } else {
                    MonthViewPager.this.mDelegate.L = C6487a.m(e, MonthViewPager.this.mDelegate);
                }
                MonthViewPager.this.mDelegate.M = MonthViewPager.this.mDelegate.L;
            }
            if (!MonthViewPager.this.isUsingScrollToCalendar && MonthViewPager.this.mDelegate.y() == 0) {
                MonthViewPager monthViewPager = MonthViewPager.this;
                monthViewPager.mWeekBar.onDateSelected(monthViewPager.mDelegate.L, MonthViewPager.this.mDelegate.E(), false);
                if (MonthViewPager.this.mDelegate.E != null && MonthViewPager.this.mDelegate.L != null) {
                    MonthViewPager.this.mDelegate.E.onCalendarSelect(MonthViewPager.this.mDelegate.L, false);
                }
            }
            BaseMonthView baseMonthView = (BaseMonthView) MonthViewPager.this.findViewWithTag(Integer.valueOf(i));
            if (baseMonthView != null) {
                int selectedIndex = baseMonthView.getSelectedIndex(MonthViewPager.this.mDelegate.M);
                if (MonthViewPager.this.mDelegate.y() == 0) {
                    baseMonthView.mCurrentItem = selectedIndex;
                }
                baseMonthView.invalidate();
                if (MonthViewPager.this.mDelegate.J != null) {
                    MonthViewPager.this.mDelegate.J.onMonthUIRangeChange(MonthViewPager.this.mDelegate.L, C6487a.f(e.getYear(), e.getMonth()), MonthViewPager.this.mDelegate.x(e.getYear(), e.getMonth()));
                }
            }
            MonthViewPager.this.updateMonthViewHeight(e.getYear(), e.getMonth());
            MonthViewPager.this.isUsingScrollToCalendar = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.calander.MonthViewPager$b */
    /* loaded from: classes11.dex */
    public final class C6486b extends PagerAdapter {
        private C6486b() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
            BaseView baseView = (BaseView) obj;
            baseView.onDestroy();
            viewGroup.removeView(baseView);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return MonthViewPager.this.mMonthCount;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(@NonNull Object obj) {
            if (MonthViewPager.this.isUpdateMonthView) {
                return -2;
            }
            return super.getItemPosition(obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        @NonNull
        public Object instantiateItem(@NonNull ViewGroup viewGroup, int i) {
            int v = (((MonthViewPager.this.mDelegate.v() + i) - 1) / 12) + MonthViewPager.this.mDelegate.t();
            int v2 = (((MonthViewPager.this.mDelegate.v() + i) - 1) % 12) + 1;
            CustomMonthView customMonthView = new CustomMonthView(MonthViewPager.this.getContext());
            MonthViewPager monthViewPager = MonthViewPager.this;
            customMonthView.mMonthViewPager = monthViewPager;
            customMonthView.setup(monthViewPager.mDelegate);
            customMonthView.setTag(Integer.valueOf(i));
            customMonthView.initMonthWithDate(v, v2);
            customMonthView.setSelectedCalendar(MonthViewPager.this.mDelegate.L);
            viewGroup.addView(customMonthView);
            if (i == MonthViewPager.this.getCurrentItem() && MonthViewPager.this.mDelegate.J != null) {
                MonthViewPager.this.mDelegate.J.onMonthUIRangeChange(MonthViewPager.this.mDelegate.L, C6487a.f(v, v2), MonthViewPager.this.mDelegate.x(v, v2));
            }
            return customMonthView;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, @NonNull Object obj) {
            return view.equals(obj);
        }

        /* synthetic */ C6486b(MonthViewPager monthViewPager, C6485a c6485a) {
            this();
        }
    }

    public MonthViewPager(Context context) {
        this(context, null);
    }

    private void init() {
        setAdapter(new C6486b(this, null));
        addOnPageChangeListener(new C6485a());
    }

    private void notifyAdapterDataSetChanged() {
        if (getAdapter() == null) {
            return;
        }
        getAdapter().notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateMonthViewHeight(int i, int i2) {
        if (this.mDelegate.w() == 0) {
            this.mCurrentViewHeight = this.mDelegate.d() * 6;
            getLayoutParams().height = this.mCurrentViewHeight;
            return;
        }
        this.mCurrentViewHeight = C6487a.k(i, i2, this.mDelegate.d(), this.mDelegate.E(), this.mDelegate.w());
        if (i2 == 1) {
            this.mPreViewHeight = C6487a.k(i - 1, 12, this.mDelegate.d(), this.mDelegate.E(), this.mDelegate.w());
            this.mNextViewHeight = C6487a.k(i, 2, this.mDelegate.d(), this.mDelegate.E(), this.mDelegate.w());
            return;
        }
        this.mPreViewHeight = C6487a.k(i, i2 - 1, this.mDelegate.d(), this.mDelegate.E(), this.mDelegate.w());
        if (i2 == 12) {
            this.mNextViewHeight = C6487a.k(i + 1, 1, this.mDelegate.d(), this.mDelegate.E(), this.mDelegate.w());
        } else {
            this.mNextViewHeight = C6487a.k(i, i2 + 1, this.mDelegate.d(), this.mDelegate.E(), this.mDelegate.w());
        }
    }

    void notifyDataSetChanged() {
        this.mMonthCount = (((this.mDelegate.p() - this.mDelegate.t()) * 12) - this.mDelegate.v()) + 1 + this.mDelegate.r();
        notifyAdapterDataSetChanged();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.mDelegate.J() && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mDelegate.J() && super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scrollToCalendar(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        this.isUsingScrollToCalendar = true;
        Calendar calendar = new Calendar();
        calendar.setYear(i);
        calendar.setMonth(i2);
        calendar.setDay(i3);
        calendar.setCurrentDay(calendar.equals(this.mDelegate.g()));
        if (z3) {
            C6488b c6488b = this.mDelegate;
            c6488b.M = calendar;
            c6488b.L = calendar;
        }
        int year = (((calendar.getYear() - this.mDelegate.t()) * 12) + calendar.getMonth()) - this.mDelegate.v();
        if (getCurrentItem() == year) {
            this.isUsingScrollToCalendar = false;
        }
        setCurrentItem(year, z);
        BaseMonthView baseMonthView = (BaseMonthView) findViewWithTag(Integer.valueOf(year));
        if (baseMonthView != null && z3) {
            baseMonthView.setSelectedCalendar(this.mDelegate.M);
            baseMonthView.invalidate();
        }
        CalendarView.OnCalendarSelectListener onCalendarSelectListener = this.mDelegate.E;
        if (onCalendarSelectListener != null && z2 && z3) {
            onCalendarSelectListener.onCalendarSelect(calendar, false);
        }
        CalendarView.OnInnerDateSelectedListener onInnerDateSelectedListener = this.mDelegate.G;
        if (onInnerDateSelectedListener != null && z3) {
            onInnerDateSelectedListener.onMonthDateSelected(calendar, false);
        }
        CalendarView.OnMonthChangeListener onMonthChangeListener = this.mDelegate.I;
        if (onMonthChangeListener != null) {
            onMonthChangeListener.onMonthChange(calendar.getYear(), calendar.getMonth());
        }
        updateSelected();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void scrollToCurrent(boolean z) {
        C6488b c6488b;
        Calendar calendar;
        this.isUsingScrollToCalendar = true;
        int year = (((this.mDelegate.g().getYear() - this.mDelegate.t()) * 12) + this.mDelegate.g().getMonth()) - this.mDelegate.v();
        if (getCurrentItem() == year) {
            this.isUsingScrollToCalendar = false;
        }
        setCurrentItem(year, z);
        BaseMonthView baseMonthView = (BaseMonthView) findViewWithTag(Integer.valueOf(year));
        if (baseMonthView != null && this.mDelegate.g().equals(this.mDelegate.L)) {
            baseMonthView.setSelectedCalendar(this.mDelegate.g());
            baseMonthView.invalidate();
        }
        if (this.mDelegate.E == null || getVisibility() != 0 || (calendar = (c6488b = this.mDelegate).L) == null) {
            return;
        }
        c6488b.E.onCalendarSelect(calendar, false);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i) {
        setCurrentItem(i, true);
    }

    public void setScrollable(boolean z) {
        C6488b c6488b = this.mDelegate;
        if (c6488b != null) {
            c6488b.V(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setup(C6488b c6488b) {
        this.mDelegate = c6488b;
        updateMonthViewHeight(c6488b.g().getYear(), this.mDelegate.g().getMonth());
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.mCurrentViewHeight;
        setLayoutParams(layoutParams);
        init();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void updateItemHeight() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseMonthView baseMonthView = (BaseMonthView) getChildAt(i);
            baseMonthView.updateItemHeight();
            baseMonthView.requestLayout();
        }
        C6488b c6488b = this.mDelegate;
        Calendar calendar = c6488b.M;
        if (calendar == null) {
            calendar = c6488b.g();
        }
        if (!C6487a.q(calendar, this.mDelegate)) {
            calendar = this.mDelegate.s();
        }
        int year = calendar.getYear();
        int month = calendar.getMonth();
        this.mCurrentViewHeight = C6487a.k(year, month, this.mDelegate.d(), this.mDelegate.E(), this.mDelegate.w());
        if (month == 1) {
            this.mPreViewHeight = C6487a.k(year - 1, 12, this.mDelegate.d(), this.mDelegate.E(), this.mDelegate.w());
            this.mNextViewHeight = C6487a.k(year, 2, this.mDelegate.d(), this.mDelegate.E(), this.mDelegate.w());
        } else {
            this.mPreViewHeight = C6487a.k(year, month - 1, this.mDelegate.d(), this.mDelegate.E(), this.mDelegate.w());
            if (month == 12) {
                this.mNextViewHeight = C6487a.k(year + 1, 1, this.mDelegate.d(), this.mDelegate.E(), this.mDelegate.w());
            } else {
                this.mNextViewHeight = C6487a.k(year, month + 1, this.mDelegate.d(), this.mDelegate.E(), this.mDelegate.w());
            }
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = this.mCurrentViewHeight;
        setLayoutParams(layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void updateRange() {
        this.isUpdateMonthView = true;
        notifyDataSetChanged();
        this.isUpdateMonthView = false;
        if (getVisibility() != 0) {
            return;
        }
        this.isUsingScrollToCalendar = false;
        C6488b c6488b = this.mDelegate;
        Calendar calendar = c6488b.K;
        if (calendar == null) {
            calendar = c6488b.L;
        }
        if (calendar == null) {
            calendar = c6488b.g();
        }
        if (!C6487a.q(calendar, this.mDelegate)) {
            calendar = this.mDelegate.s();
        }
        int year = (((calendar.getYear() - this.mDelegate.t()) * 12) + calendar.getMonth()) - this.mDelegate.v();
        if (getCurrentItem() != year) {
            setCurrentItem(year, false);
        }
        BaseMonthView baseMonthView = (BaseMonthView) findViewWithTag(Integer.valueOf(year));
        if (baseMonthView != null) {
            baseMonthView.setSelectedCalendar(this.mDelegate.M);
            baseMonthView.invalidate();
        }
        C6488b c6488b2 = this.mDelegate;
        Calendar calendar2 = c6488b2.L;
        if (calendar2 != null) {
            CalendarView.OnInnerDateSelectedListener onInnerDateSelectedListener = c6488b2.G;
            if (onInnerDateSelectedListener != null) {
                onInnerDateSelectedListener.onMonthDateSelected(calendar2, false);
            }
            C6488b c6488b3 = this.mDelegate;
            CalendarView.OnCalendarSelectListener onCalendarSelectListener = c6488b3.E;
            if (onCalendarSelectListener != null) {
                onCalendarSelectListener.onCalendarSelect(c6488b3.L, false);
            }
        }
        updateSelected();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateScheme() {
        for (int i = 0; i < getChildCount(); i++) {
            ((BaseMonthView) getChildAt(i)).update();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateSelected() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseMonthView baseMonthView = (BaseMonthView) getChildAt(i);
            baseMonthView.setSelectedCalendar(this.mDelegate.L);
            baseMonthView.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void updateStyle() {
        for (int i = 0; i < getChildCount(); i++) {
            BaseMonthView baseMonthView = (BaseMonthView) getChildAt(i);
            baseMonthView.updateStyle();
            baseMonthView.invalidate();
        }
    }

    public MonthViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isUsingScrollToCalendar = false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i, boolean z) {
        if (Math.abs(getCurrentItem() - i) > 1) {
            super.setCurrentItem(i, false);
        } else {
            super.setCurrentItem(i, z);
        }
    }
}
