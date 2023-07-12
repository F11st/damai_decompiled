package com.taobao.android.dinamicx.widget.calander;

import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import com.taobao.android.dinamicx.widget.calander.CalendarView;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class MonthView extends BaseMonthView {
    public MonthView(Context context) {
        super(context);
    }

    private void draw(Canvas canvas, Calendar calendar, int i, int i2, int i3) {
        int e = (i2 * this.mItemWidth) + this.mDelegate.e();
        int i4 = i * this.mItemHeight;
        onLoopStart(e, i4);
        boolean z = i3 == this.mCurrentItem;
        if (calendar.containHighLightCalendarInfo()) {
            onDrawCalendarInfo(canvas, calendar, e, i4);
        }
        if (z) {
            onDrawSelected(canvas, calendar, e, i4, false);
        }
        onDrawText(canvas, calendar, e, i4, false, z);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Calendar index;
        MonthViewPager monthViewPager;
        if (this.isClick && (index = getIndex()) != null) {
            if (this.mDelegate.w() != 1 || index.isCurrentMonth()) {
                if (onCalendarIntercept(index)) {
                    this.mDelegate.D.onCalendarInterceptClick(index, true);
                } else if (!isInRange(index)) {
                    CalendarView.OnCalendarSelectListener onCalendarSelectListener = this.mDelegate.E;
                    if (onCalendarSelectListener != null) {
                        onCalendarSelectListener.onCalendarOutOfRange(index);
                    }
                } else {
                    CalendarView.OnInnerDateSelectedListener onInnerDateSelectedListener = this.mDelegate.G;
                    if (onInnerDateSelectedListener != null) {
                        onInnerDateSelectedListener.onMonthDateSelected(index, true);
                    }
                    CalendarView.OnCalendarSelectListener onCalendarSelectListener2 = this.mDelegate.E;
                    if (onCalendarSelectListener2 != null) {
                        onCalendarSelectListener2.onCalendarSelect(index, true);
                    }
                    this.mCurrentItem = this.mItems.indexOf(index);
                    if (!this.mDelegate.I() || index.isCurrentMonth() || (monthViewPager = this.mMonthViewPager) == null) {
                        return;
                    }
                    int currentItem = monthViewPager.getCurrentItem();
                    this.mMonthViewPager.setCurrentItem(this.mCurrentItem < 7 ? currentItem - 1 : currentItem + 1);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mLineCount == 0) {
            return;
        }
        this.mItemWidth = ((getWidth() - this.mDelegate.e()) - this.mDelegate.f()) / 7;
        onPreviewHook();
        int i = this.mLineCount * 7;
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.mLineCount) {
            int i4 = i2;
            for (int i5 = 0; i5 < 7; i5++) {
                Calendar calendar = this.mItems.get(i4);
                if (this.mDelegate.w() == 1) {
                    if (i4 > this.mItems.size() - this.mNextDiff) {
                        return;
                    }
                    if (!calendar.isCurrentMonth()) {
                        i4++;
                    }
                } else if (this.mDelegate.w() == 2 && i4 >= i) {
                    return;
                }
                draw(canvas, calendar, i3, i5, i4);
                i4++;
            }
            i3++;
            i2 = i4;
        }
    }

    protected abstract void onDrawCalendarInfo(Canvas canvas, Calendar calendar, int i, int i2);

    protected abstract void onDrawSelected(Canvas canvas, Calendar calendar, int i, int i2, boolean z);

    protected abstract void onDrawText(Canvas canvas, Calendar calendar, int i, int i2, boolean z, boolean z2);

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        Calendar index;
        MonthViewPager monthViewPager;
        if (this.mDelegate.F == null || !this.isClick || (index = getIndex()) == null) {
            return false;
        }
        if (this.mDelegate.w() != 1 || index.isCurrentMonth()) {
            if (onCalendarIntercept(index)) {
                this.mDelegate.D.onCalendarInterceptClick(index, true);
                return false;
            } else if (!isInRange(index)) {
                CalendarView.OnCalendarLongClickListener onCalendarLongClickListener = this.mDelegate.F;
                if (onCalendarLongClickListener != null) {
                    onCalendarLongClickListener.onCalendarLongClickOutOfRange(index);
                }
                return true;
            } else if (this.mDelegate.K()) {
                CalendarView.OnCalendarLongClickListener onCalendarLongClickListener2 = this.mDelegate.F;
                if (onCalendarLongClickListener2 != null) {
                    onCalendarLongClickListener2.onCalendarLongClick(index);
                }
                return true;
            } else {
                this.mCurrentItem = this.mItems.indexOf(index);
                if (!index.isCurrentMonth() && (monthViewPager = this.mMonthViewPager) != null) {
                    int currentItem = monthViewPager.getCurrentItem();
                    this.mMonthViewPager.setCurrentItem(this.mCurrentItem < 7 ? currentItem - 1 : currentItem + 1);
                }
                CalendarView.OnInnerDateSelectedListener onInnerDateSelectedListener = this.mDelegate.G;
                if (onInnerDateSelectedListener != null) {
                    onInnerDateSelectedListener.onMonthDateSelected(index, true);
                }
                CalendarView.OnCalendarSelectListener onCalendarSelectListener = this.mDelegate.E;
                if (onCalendarSelectListener != null) {
                    onCalendarSelectListener.onCalendarSelect(index, true);
                }
                CalendarView.OnCalendarLongClickListener onCalendarLongClickListener3 = this.mDelegate.F;
                if (onCalendarLongClickListener3 != null) {
                    onCalendarLongClickListener3.onCalendarLongClick(index);
                }
                invalidate();
                return true;
            }
        }
        return false;
    }
}
