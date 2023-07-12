package cn.damai.category.common.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import cn.damai.category.calendar.bean.Day;
import cn.damai.category.common.bean.CalendarMonthBean;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.b40;
import tb.rf;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CalendarView extends ViewGroup {
    private static transient /* synthetic */ IpChange $ipChange;
    private int mBubbleColumn;
    private int mBubbleRow;
    private Context mContext;
    private int mDayHeigth;
    private int mDayWidth;
    private List<Day> mDays;
    private boolean mIsCurrentMonth;
    private View.OnClickListener mItemClickListener;
    private int mMonth;
    private String mProjectTag;
    private int mRowNum;
    private int mStartWeek;
    private int mWidth;
    private int mYear;

    public CalendarView(Context context) {
        this(context, null);
    }

    private void rePaintView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1758799739")) {
            ipChange.ipc$dispatch("-1758799739", new Object[]{this});
            return;
        }
        removeAllViews();
        int i = DisplayMetrics.getwidthPixels(this.mContext.getResources().getDisplayMetrics());
        this.mWidth = i;
        this.mDayWidth = (i - ScreenUtil.dip2px(this.mContext, 36.0f)) / 7;
        this.mDayHeigth = ScreenUtil.dip2px(this.mContext, 46.0f);
        if (((this.mDays.size() + this.mStartWeek) - 1) % 7 == 0) {
            this.mRowNum = ((this.mDays.size() + this.mStartWeek) - 1) / 7;
        } else {
            this.mRowNum = (((this.mDays.size() + this.mStartWeek) - 1) / 7) + 1;
        }
        for (int i2 = 0; i2 < this.mDays.size(); i2++) {
            Day day = this.mDays.get(i2);
            if (day != null) {
                if (this.mIsCurrentMonth) {
                    if (rf.n() > day.day) {
                        day.showType = 0;
                    } else if (rf.n() == day.day) {
                        day.showType = 1;
                    } else {
                        day.showType = 2;
                    }
                } else {
                    day.showType = 2;
                }
                View b = b40.a().b(this.mContext, day);
                b.setTag(day);
                b.setOnClickListener(this.mItemClickListener);
                addView(b);
            }
        }
    }

    private void reSetProjectName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "561548416")) {
            ipChange.ipc$dispatch("561548416", new Object[]{this});
            return;
        }
        this.mProjectTag = null;
        this.mBubbleRow = 0;
        this.mBubbleColumn = 0;
    }

    public int getDayWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-147582808") ? ((Integer) ipChange.ipc$dispatch("-147582808", new Object[]{this})).intValue() : this.mDayWidth;
    }

    public int[] getLocation() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1800274566") ? (int[]) ipChange.ipc$dispatch("-1800274566", new Object[]{this}) : new int[]{this.mBubbleRow, this.mBubbleColumn};
    }

    public String getProjectTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "53226434") ? (String) ipChange.ipc$dispatch("53226434", new Object[]{this}) : this.mProjectTag;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-436351384")) {
            ipChange.ipc$dispatch("-436351384", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int dip2px = ScreenUtil.dip2px(this.mContext, 18.0f);
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            int i6 = this.mStartWeek;
            int i7 = this.mDayWidth;
            int i8 = this.mDayHeigth;
            childAt.layout(((((i5 + i6) - 1) % 7) * i7) + dip2px, (((i5 + i6) - 1) / 7) * i8, (((((i5 + i6) - 1) % 7) + 1) * i7) + dip2px, i8 * ((((i6 + i5) - 1) / 7) + 1));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-92180042")) {
            ipChange.ipc$dispatch("-92180042", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).measure(View.MeasureSpec.makeMeasureSpec(this.mDayWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(getChildAt(i3).getLayoutParams().height, 1073741824));
        }
        setMeasuredDimension(this.mWidth, this.mRowNum * ScreenUtil.dip2px(this.mContext, 46.0f));
    }

    public void setMonth(int i, int i2, List<Day> list, CalendarMonthBean calendarMonthBean, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734990209")) {
            ipChange.ipc$dispatch("1734990209", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), list, calendarMonthBean, onClickListener});
            return;
        }
        reSetProjectName();
        this.mItemClickListener = onClickListener;
        this.mYear = i;
        this.mMonth = i2;
        this.mIsCurrentMonth = rf.r(i, i2);
        this.mDays = rf.d(i, i2, list, calendarMonthBean);
        this.mStartWeek = rf.h(i, i2);
        for (int i3 = 0; i3 < this.mDays.size(); i3++) {
            if (this.mDays.get(i3) != null && !TextUtils.isEmpty(this.mDays.get(i3).projectName)) {
                this.mProjectTag = this.mDays.get(i3).projectName;
                int i4 = this.mStartWeek;
                this.mBubbleRow = (((i3 + i4) - 1) / 7) + 1;
                this.mBubbleColumn = (((i4 + i3) - 1) % 7) + 1;
            }
        }
        if (!isInEditMode()) {
            rePaintView();
        }
        requestLayout();
    }

    public CalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBubbleRow = 0;
        this.mBubbleColumn = 0;
        this.mContext = context;
    }
}
