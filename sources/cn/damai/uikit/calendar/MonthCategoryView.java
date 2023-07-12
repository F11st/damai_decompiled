package cn.damai.uikit.calendar;

import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.NonNull;
import cn.damai.uikit.calendar.CalendarPagerView;
import cn.damai.uikit.calendar.MaterialCalendarView;
import cn.damai.uikit.calendar.format.DayFormatter;
import cn.damai.uikit.calendar.format.WeekDayFormatter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import tb.l62;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class MonthCategoryView extends CalendarPagerView {
    private static transient /* synthetic */ IpChange $ipChange;

    public MonthCategoryView(@NonNull MaterialCalendarView materialCalendarView, CalendarDay calendarDay, int i) {
        super(materialCalendarView, calendarDay, i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    protected void buildDayViews(Calendar calendar) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1659434628")) {
            ipChange.ipc$dispatch("1659434628", new Object[]{this, calendar});
            return;
        }
        for (int i = 0; i < 6; i++) {
            for (int i2 = 0; i2 < 7; i2++) {
                if (i2 != 0 && i2 != 6) {
                    addDayCategoryView(calendar, false);
                } else {
                    addDayCategoryView(calendar, true);
                }
            }
        }
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView, android.view.ViewGroup
    public /* bridge */ /* synthetic */ CalendarPagerView.C2481a generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public CalendarDay getMonth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2007240809") ? (CalendarDay) ipChange.ipc$dispatch("2007240809", new Object[]{this}) : getFirstViewDay();
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    protected int getRows() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1555563081")) {
            return ((Integer) ipChange.ipc$dispatch("-1555563081", new Object[]{this})).intValue();
        }
        return 6;
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    protected void invalidateDecorators() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "703743268")) {
            ipChange.ipc$dispatch("703743268", new Object[]{this});
            return;
        }
        C2490a c2490a = new C2490a();
        for (DayCategoryView dayCategoryView : this.dayCategoryViews) {
            c2490a.q();
            Iterator<C2492b> it = this.decoratorResults.iterator();
            while (it.hasNext()) {
                C2492b next = it.next();
                if (next.a.shouldDecorate(dayCategoryView.getDayView().getDate())) {
                    next.b.b(c2490a);
                    if (next.a.updateFacade()) {
                        c2490a.s(next.a.updateFacadeDesc(dayCategoryView.getDayView().getDate()));
                    }
                }
            }
            dayCategoryView.applyFacade(c2490a);
        }
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    protected boolean isDayEnabled(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-761260024") ? ((Boolean) ipChange.ipc$dispatch("-761260024", new Object[]{this, calendarDay})).booleanValue() : calendarDay.getMonth() == getFirstViewDay().getMonth();
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView, android.view.View.OnClickListener
    public /* bridge */ /* synthetic */ void onClick(View view) {
        super.onClick(view);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView, android.view.View
    public /* bridge */ /* synthetic */ void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView, android.view.View
    public /* bridge */ /* synthetic */ void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView, android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1015777420")) {
            ipChange.ipc$dispatch("-1015777420", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 0 && mode != 0) {
            int i3 = size / 7;
            int a = l62.a(getContext(), 60.0f);
            setMeasuredDimension(size, size2);
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                getChildAt(i4).measure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), View.MeasureSpec.makeMeasureSpec(a, 1073741824));
            }
            return;
        }
        throw new IllegalStateException("CalendarPagerView should never be left to decide it's size");
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setDateTextAppearance(int i) {
        super.setDateTextAppearance(i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setDayFormatter(DayFormatter dayFormatter) {
        super.setDayFormatter(dayFormatter);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setMaximumDate(CalendarDay calendarDay) {
        super.setMaximumDate(calendarDay);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setMinimumDate(CalendarDay calendarDay) {
        super.setMinimumDate(calendarDay);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public void setSelectedDates(Collection<CalendarDay> collection) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2095274432")) {
            ipChange.ipc$dispatch("-2095274432", new Object[]{this, collection});
            return;
        }
        for (DayCategoryView dayCategoryView : this.dayCategoryViews) {
            DayView dayView = dayCategoryView.getDayView();
            if (dayView == null) {
                return;
            }
            CalendarDay date = dayView.getDate();
            if (collection != null && collection.contains(date)) {
                dayView.setChecked(true);
            } else {
                dayView.setChecked(false);
            }
        }
        postInvalidate();
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setSelectionColor(int i) {
        super.setSelectionColor(i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setSelectionEnabled(boolean z) {
        super.setSelectionEnabled(z);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setShowOtherDates(@MaterialCalendarView.ShowOtherDates int i) {
        super.setShowOtherDates(i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setWeekDayFormatter(WeekDayFormatter weekDayFormatter) {
        super.setWeekDayFormatter(weekDayFormatter);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView
    public /* bridge */ /* synthetic */ void setWeekDayTextAppearance(int i) {
        super.setWeekDayTextAppearance(i);
    }

    @Override // cn.damai.uikit.calendar.CalendarPagerView, android.view.ViewGroup
    public /* bridge */ /* synthetic */ boolean shouldDelayChildPressedState() {
        return super.shouldDelayChildPressedState();
    }
}
