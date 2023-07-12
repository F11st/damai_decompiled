package com.taobao.android.dinamicx.widget.calander;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.taobao.android.dinamic.R$id;
import com.taobao.android.dinamic.R$layout;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CalendarView extends FrameLayout {
    private final C6488b mDelegate;
    private MonthViewPager mMonthPager;
    private WeekBar mWeekBar;
    private View mWeekLine;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnCalendarInterceptListener {
        boolean onCalendarIntercept(Calendar calendar);

        void onCalendarInterceptClick(Calendar calendar, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnCalendarLongClickListener {
        void onCalendarLongClick(Calendar calendar);

        void onCalendarLongClickOutOfRange(Calendar calendar);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnCalendarSelectListener {
        void onCalendarOutOfRange(Calendar calendar);

        void onCalendarSelect(@NonNull Calendar calendar, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnClickCalendarPaddingListener {
        void onClickCalendarPadding(float f, float f2, boolean z, Calendar calendar, Object obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnInnerDateSelectedListener {
        void onMonthDateSelected(Calendar calendar, boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnMonthChangeListener {
        void onMonthChange(int i, int i2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnMonthUIRangeChangeListener {
        void onMonthUIRangeChange(Calendar calendar, String str, Pair<String, String> pair);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnYearChangeListener {
        void onYearChange(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.android.dinamicx.widget.calander.CalendarView$a */
    /* loaded from: classes11.dex */
    public class C6484a implements OnInnerDateSelectedListener {
        C6484a() {
        }

        @Override // com.taobao.android.dinamicx.widget.calander.CalendarView.OnInnerDateSelectedListener
        public void onMonthDateSelected(Calendar calendar, boolean z) {
            if (calendar.getYear() == CalendarView.this.mDelegate.g().getYear() && calendar.getMonth() == CalendarView.this.mDelegate.g().getMonth() && CalendarView.this.mMonthPager.getCurrentItem() != CalendarView.this.mDelegate.B) {
                return;
            }
            CalendarView.this.mDelegate.M = calendar;
            if (CalendarView.this.mDelegate.y() == 0 || z) {
                CalendarView.this.mDelegate.L = calendar;
            }
            CalendarView.this.mMonthPager.updateSelected();
            if (CalendarView.this.mWeekBar != null) {
                if (CalendarView.this.mDelegate.y() == 0 || z) {
                    CalendarView.this.mWeekBar.onDateSelected(calendar, CalendarView.this.mDelegate.E(), z);
                }
            }
        }
    }

    public CalendarView(@NonNull Context context) {
        this(context, null);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R$layout.datepicker_layout_calendar_view, (ViewGroup) this, true);
        WeekBar weekBar = new WeekBar(context);
        this.mWeekBar = weekBar;
        ((FrameLayout) findViewById(R$id.frameContent)).addView(weekBar, 2);
        this.mWeekBar.setup(this.mDelegate);
        this.mWeekBar.onWeekStartChange(this.mDelegate.E());
        View findViewById = findViewById(R$id.line);
        this.mWeekLine = findViewById;
        findViewById.setBackgroundColor(this.mDelegate.C());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.mWeekLine.getLayoutParams();
        layoutParams.setMargins(this.mDelegate.D(), this.mDelegate.B(), this.mDelegate.D(), 0);
        this.mWeekLine.setLayoutParams(layoutParams);
        MonthViewPager monthViewPager = (MonthViewPager) findViewById(R$id.vp_month);
        this.mMonthPager = monthViewPager;
        monthViewPager.mWeekBar = this.mWeekBar;
        this.mDelegate.G = new C6484a();
        WeekBar weekBar2 = this.mWeekBar;
        C6488b c6488b = this.mDelegate;
        weekBar2.onDateSelected(c6488b.L, c6488b.E(), false);
        this.mMonthPager.setup(this.mDelegate);
        this.mMonthPager.setCurrentItem(this.mDelegate.B);
    }

    public final boolean isInRange(Calendar calendar) {
        C6488b c6488b = this.mDelegate;
        return c6488b != null && C6487a.q(calendar, c6488b);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        C6488b c6488b = this.mDelegate;
        if (c6488b == null) {
            super.onMeasure(i, i2);
            return;
        }
        setCalendarItemHeight(((size - c6488b.B()) - this.mDelegate.k()) / 6);
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Calendar calendar;
        Bundle bundle = (Bundle) parcelable;
        Parcelable parcelable2 = bundle.getParcelable("super");
        this.mDelegate.L = (Calendar) bundle.getSerializable("selected_calendar");
        this.mDelegate.M = (Calendar) bundle.getSerializable("index_calendar");
        C6488b c6488b = this.mDelegate;
        OnCalendarSelectListener onCalendarSelectListener = c6488b.E;
        if (onCalendarSelectListener != null && (calendar = c6488b.L) != null) {
            onCalendarSelectListener.onCalendarSelect(calendar, false);
        }
        Calendar calendar2 = this.mDelegate.M;
        if (calendar2 != null) {
            scrollToCalendar(calendar2.getYear(), this.mDelegate.M.getMonth(), this.mDelegate.M.getDay());
        }
        update();
        super.onRestoreInstanceState(parcelable2);
    }

    @Override // android.view.View
    @Nullable
    protected Parcelable onSaveInstanceState() {
        if (this.mDelegate == null) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putSerializable("selected_calendar", this.mDelegate.L);
        bundle.putSerializable("index_calendar", this.mDelegate.M);
        return bundle;
    }

    public void scrollToCalendar(int i, int i2, int i3) {
        scrollToCalendar(i, i2, i3, false, true);
    }

    public void scrollToCurrent() {
        scrollToCurrent(false);
    }

    public void scrollToNext(boolean z) {
        MonthViewPager monthViewPager = this.mMonthPager;
        monthViewPager.setCurrentItem(monthViewPager.getCurrentItem() + 1, z);
    }

    public void scrollToPre(boolean z) {
        MonthViewPager monthViewPager = this.mMonthPager;
        monthViewPager.setCurrentItem(monthViewPager.getCurrentItem() - 1, z);
    }

    public void setAnchorCalendar(Calendar calendar) {
        C6488b c6488b = this.mDelegate;
        if (c6488b != null) {
            c6488b.K = calendar;
        }
    }

    public void setAutoChangeMonth(boolean z) {
        C6488b c6488b = this.mDelegate;
        if (c6488b != null) {
            c6488b.M(z);
        }
    }

    public void setBackground(int i, int i2) {
        this.mWeekBar.setBackgroundColor(i);
        this.mWeekLine.setBackgroundColor(i2);
    }

    public final void setCalendarItemHeight(int i) {
        if (this.mDelegate.d() == i) {
            return;
        }
        this.mDelegate.P(i);
        this.mMonthPager.updateItemHeight();
    }

    public void setCurrentDayTextSize(int i) {
        this.mDelegate.Q(i);
    }

    public void setDateTextFont(String str) {
        this.mDelegate.R(str);
    }

    public void setDateTextGravity(int i) {
        C6488b c6488b = this.mDelegate;
        CalendarDateTextGravity calendarDateTextGravity = CalendarDateTextGravity.Top;
        if (i != calendarDateTextGravity.getCode()) {
            calendarDateTextGravity = CalendarDateTextGravity.Center;
        }
        c6488b.N(calendarDateTextGravity);
    }

    public void setDateTopGap(int i) {
        C6488b c6488b = this.mDelegate;
        if (c6488b != null) {
            c6488b.S(i);
            MonthViewPager monthViewPager = this.mMonthPager;
            if (monthViewPager != null) {
                ViewGroup.LayoutParams layoutParams = monthViewPager.getLayoutParams();
                if (layoutParams instanceof FrameLayout.LayoutParams) {
                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                    layoutParams2.topMargin = C6487a.c(getContext(), 41.0f) + i;
                    this.mMonthPager.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public void setDayTextSize(int i) {
        this.mDelegate.T(i);
    }

    public void setDisableRanges(List<Pair<Calendar, Calendar>> list) {
        if (C6487a.r(list)) {
            this.mDelegate.U(list);
            Calendar calendar = this.mDelegate.L;
            if (calendar != null && !isInRange(calendar)) {
                C6488b c6488b = this.mDelegate;
                c6488b.L = c6488b.s();
                C6488b c6488b2 = this.mDelegate;
                c6488b2.M = c6488b2.L;
            }
            this.mMonthPager.updateRange();
        }
    }

    public void setOnCalendarSelectListener(OnCalendarSelectListener onCalendarSelectListener) {
        this.mDelegate.E = onCalendarSelectListener;
    }

    public void setOnMonthChangeListener(OnMonthChangeListener onMonthChangeListener) {
        this.mDelegate.I = onMonthChangeListener;
    }

    public void setOnMonthUIRangeChangeListener(OnMonthUIRangeChangeListener onMonthUIRangeChangeListener) {
        this.mDelegate.J = onMonthUIRangeChangeListener;
    }

    public void setRange(int i, int i2, int i3, int i4, int i5, int i6) {
        setRange(i, i2, i3, i4, i5, i6, null);
    }

    public void setScrollable(boolean z) {
        MonthViewPager monthViewPager = this.mMonthPager;
        if (monthViewPager != null) {
            monthViewPager.setScrollable(z);
        }
    }

    public void setSelectedTextColor(int i) {
        C6488b c6488b = this.mDelegate;
        if (c6488b == null || c6488b.z() == i) {
            return;
        }
        this.mDelegate.Y(i);
        MonthViewPager monthViewPager = this.mMonthPager;
        if (monthViewPager != null) {
            monthViewPager.updateStyle();
        }
    }

    public void setTextColor(int i, int i2, int i3, int i4, int i5) {
        C6488b c6488b = this.mDelegate;
        if (c6488b == null || this.mMonthPager == null) {
            return;
        }
        c6488b.Z(i, i2, i3, i4, i5);
        this.mMonthPager.updateStyle();
    }

    public void setWeekBarTextColor(int i) {
        C6488b c6488b = this.mDelegate;
        if (c6488b == null || c6488b.F() == i) {
            return;
        }
        this.mDelegate.a0(i);
        WeekBar weekBar = this.mWeekBar;
        if (weekBar != null) {
            weekBar.setTextColor(this.mDelegate.F());
        }
    }

    public final void update() {
        this.mWeekBar.onWeekStartChange(this.mDelegate.E());
        this.mMonthPager.updateScheme();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void updateMonthArrowStatus() {
        /*
            r6 = this;
            com.taobao.android.dinamicx.widget.calander.MonthViewPager r0 = r6.mMonthPager
            androidx.viewpager.widget.PagerAdapter r0 = r0.getAdapter()
            r1 = 0
            if (r0 == 0) goto L4c
            int r2 = r0.getCount()
            r3 = 2
            r4 = 1
            if (r2 != r3) goto L29
            com.taobao.android.dinamicx.widget.calander.MonthViewPager r0 = r6.mMonthPager
            int r0 = r0.getCurrentItem()
            if (r0 == 0) goto L1b
            r0 = 1
            goto L1c
        L1b:
            r0 = 0
        L1c:
            com.taobao.android.dinamicx.widget.calander.MonthViewPager r2 = r6.mMonthPager
            int r2 = r2.getCurrentItem()
            if (r2 != 0) goto L25
            r1 = 1
        L25:
            r5 = r1
            r1 = r0
            r0 = r5
            goto L4d
        L29:
            int r2 = r0.getCount()
            r3 = 3
            if (r2 < r3) goto L4c
            com.taobao.android.dinamicx.widget.calander.MonthViewPager r2 = r6.mMonthPager
            int r2 = r2.getCurrentItem()
            if (r2 == 0) goto L3a
            r2 = 1
            goto L3b
        L3a:
            r2 = 0
        L3b:
            com.taobao.android.dinamicx.widget.calander.MonthViewPager r3 = r6.mMonthPager
            int r3 = r3.getCurrentItem()
            int r0 = r0.getCount()
            int r0 = r0 - r4
            if (r3 == r0) goto L49
            r1 = 1
        L49:
            r0 = r1
            r1 = r2
            goto L4d
        L4c:
            r0 = 0
        L4d:
            int r2 = com.taobao.android.dinamic.R$id.iv_left
            java.lang.Object r2 = r6.getTag(r2)
            boolean r3 = r2 instanceof android.view.View
            if (r3 == 0) goto L5c
            android.view.View r2 = (android.view.View) r2
            r2.setEnabled(r1)
        L5c:
            int r1 = com.taobao.android.dinamic.R$id.iv_right
            java.lang.Object r1 = r6.getTag(r1)
            boolean r2 = r1 instanceof android.view.View
            if (r2 == 0) goto L6b
            android.view.View r1 = (android.view.View) r1
            r1.setEnabled(r0)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.android.dinamicx.widget.calander.CalendarView.updateMonthArrowStatus():void");
    }

    public CalendarView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDelegate = new C6488b(context, attributeSet);
        init(context);
    }

    public void scrollToCalendar(int i, int i2, int i3, boolean z, boolean z2) {
        scrollToCalendar(i, i2, i3, z, z2, true);
    }

    public void scrollToCurrent(boolean z) {
        scrollToCurrent(z, false);
    }

    public void setRange(int i, int i2, int i3, int i4, int i5, int i6, List<Pair<Calendar, Calendar>> list) {
        setRange(i, i2, i3, i4, i5, i6, list, null);
    }

    public void scrollToCalendar(int i, int i2, int i3, boolean z, boolean z2, boolean z3) {
        Calendar calendar = new Calendar();
        calendar.setYear(i);
        calendar.setMonth(i2);
        calendar.setDay(i3);
        if (calendar.isAvailable() && isInRange(calendar)) {
            OnCalendarInterceptListener onCalendarInterceptListener = this.mDelegate.D;
            if (onCalendarInterceptListener != null && onCalendarInterceptListener.onCalendarIntercept(calendar)) {
                this.mDelegate.D.onCalendarInterceptClick(calendar, false);
            } else {
                this.mMonthPager.scrollToCalendar(i, i2, i3, z, z2, z3);
            }
        }
    }

    public void scrollToCurrent(boolean z, boolean z2) {
        if (isInRange(this.mDelegate.g())) {
            Calendar a = this.mDelegate.a();
            OnCalendarInterceptListener onCalendarInterceptListener = this.mDelegate.D;
            if (onCalendarInterceptListener != null && onCalendarInterceptListener.onCalendarIntercept(a)) {
                this.mDelegate.D.onCalendarInterceptClick(a, false);
                return;
            }
            if (!z2) {
                C6488b c6488b = this.mDelegate;
                c6488b.L = c6488b.a();
                C6488b c6488b2 = this.mDelegate;
                Calendar calendar = c6488b2.L;
                c6488b2.M = calendar;
                this.mWeekBar.onDateSelected(calendar, c6488b2.E(), false);
            } else {
                C6488b c6488b3 = this.mDelegate;
                c6488b3.L = null;
                c6488b3.M = null;
            }
            if (this.mMonthPager.getVisibility() == 0) {
                this.mMonthPager.scrollToCurrent(z);
            }
        }
    }

    public void setRange(int i, int i2, int i3, int i4, int i5, int i6, List<Pair<Calendar, Calendar>> list, HashMap<String, Calendar> hashMap) {
        if (C6487a.a(i, i2, i3, i4, i5, i6) > 0) {
            return;
        }
        if (list == null || C6487a.r(list)) {
            this.mDelegate.X(i, i2, i3, i4, i5, i6);
            this.mDelegate.U(list);
            this.mDelegate.O(hashMap);
            Calendar calendar = this.mDelegate.L;
            if (calendar != null && !isInRange(calendar)) {
                C6488b c6488b = this.mDelegate;
                c6488b.L = c6488b.s();
                C6488b c6488b2 = this.mDelegate;
                c6488b2.M = c6488b2.L;
            }
            this.mMonthPager.updateRange();
        }
    }
}
