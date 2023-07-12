package cn.damai.commonbusiness.calendar.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.calendar.bean.CalendarMonthBean;
import cn.damai.commonbusiness.calendar.bean.Day;
import cn.damai.commonbusiness.calendar.bean.DispatchDesc;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import tb.nf;
import tb.q60;
import tb.y30;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
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

    private void fakeday(Day day) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-563681485")) {
            ipChange.ipc$dispatch("-563681485", new Object[]{this, day});
            return;
        }
        int i = day.day;
        if (i % 3 == 0) {
            day.tip = "";
        } else if (i % 3 == 1) {
            day.tip = "一二三四";
        } else {
            day.tip = "一二三四五六七";
        }
        day.dayType = i % 3;
        if (i % 2 == 0) {
            day.tag = "国庆节";
        } else if (i % 3 == 1) {
            day.tag = "";
        }
        int i2 = i % 4;
        if (i2 == 0) {
            day.tipBg = DispatchDesc.TYPE.BLUE;
        } else if (i2 == 1) {
            day.tipBg = DispatchDesc.TYPE.PINK;
        } else if (i2 == 2) {
            day.tipBg = DispatchDesc.TYPE.YELLOW;
        } else if (i2 != 3) {
        } else {
            day.tipBg = DispatchDesc.TYPE.PURPLE;
        }
    }

    private void rePaintView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1367403808")) {
            ipChange.ipc$dispatch("-1367403808", new Object[]{this});
            return;
        }
        removeAllViews();
        int i = DisplayMetrics.getwidthPixels(this.mContext.getResources().getDisplayMetrics());
        this.mWidth = i;
        int dip2px = (i - ScreenUtil.dip2px(this.mContext, 18.0f)) / 7;
        this.mDayWidth = dip2px;
        this.mDayHeigth = (((dip2px - 6) * 56) / 45) + ScreenUtil.dip2px(this.mContext, 16.0f);
        if (((this.mDays.size() + this.mStartWeek) - 1) % 7 == 0) {
            this.mRowNum = ((this.mDays.size() + this.mStartWeek) - 1) / 7;
        } else {
            this.mRowNum = (((this.mDays.size() + this.mStartWeek) - 1) / 7) + 1;
        }
        for (int i2 = 0; i2 < this.mDays.size(); i2++) {
            Day day = this.mDays.get(i2);
            if (day != null) {
                if (this.mIsCurrentMonth) {
                    if (nf.k() > day.day) {
                        day.showType = 0;
                    } else if (nf.k() == day.day) {
                        day.showType = 1;
                    } else {
                        day.showType = 2;
                    }
                } else {
                    day.showType = 2;
                }
                View b = y30.a().b(this.mContext, day);
                b.setTag(day);
                b.setOnClickListener(this.mItemClickListener);
                addView(b);
                int i3 = R$id.view_bg;
                b.findViewById(i3).getLayoutParams().width = this.mDayWidth - q60.a(this.mContext, 6.0f);
                b.findViewById(i3).getLayoutParams().height = this.mDayHeigth - ScreenUtil.dip2px(this.mContext, 16.0f);
                int i4 = R$id.view_long_select;
                b.findViewById(i4).getLayoutParams().width = this.mDayWidth;
                b.findViewById(i4).getLayoutParams().height = this.mDayHeigth - ScreenUtil.dip2px(this.mContext, 16.0f);
                FrameLayout frameLayout = (FrameLayout) b.findViewById(i4);
                if (day.selectType > 0) {
                    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
                    calendar.set(day.year, day.month - 1, day.day);
                    int i5 = calendar.get(7);
                    int i6 = calendar.get(5);
                    boolean z = i6 == calendar.getActualMaximum(5);
                    if ((z && day.selectType == 4 && i5 == 1) || (i6 == 1 && day.selectType == 4 && i5 == 7)) {
                        frameLayout.findViewById(R$id.view_long_select_inner).setBackgroundResource(R$drawable.common_calendar_day_long_select_bg_all);
                    } else {
                        int i7 = day.selectType;
                        if ((i7 == 2 && z) || ((i7 == 2 && i5 == 7) || ((i7 == 3 && i5 == 1) || (i7 == 3 && i6 == 1)))) {
                            frameLayout.setVisibility(8);
                        } else if (i5 == 1 || i6 == 1) {
                            frameLayout.setPadding(q60.a(this.mContext, 3.0f), 0, 0, 0);
                            frameLayout.findViewById(R$id.view_long_select_inner).setBackgroundResource(R$drawable.common_calendar_day_long_select_bg_left);
                        } else if (i5 == 7 || z) {
                            frameLayout.setPadding(0, 0, q60.a(this.mContext, 3.0f), 0);
                            frameLayout.findViewById(R$id.view_long_select_inner).setBackgroundResource(R$drawable.common_calendar_day_long_select_bg_right);
                        }
                    }
                } else {
                    frameLayout.findViewById(R$id.view_long_select_inner).setBackgroundResource(R$drawable.common_calendar_day_long_select_bg);
                }
            }
        }
    }

    private void reSetProjectName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "318870277")) {
            ipChange.ipc$dispatch("318870277", new Object[]{this});
            return;
        }
        this.mProjectTag = null;
        this.mBubbleRow = 0;
        this.mBubbleColumn = 0;
    }

    public int getDayWidth() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "243813123") ? ((Integer) ipChange.ipc$dispatch("243813123", new Object[]{this})).intValue() : this.mDayWidth;
    }

    public int[] getLocation() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1743064703") ? (int[]) ipChange.ipc$dispatch("1743064703", new Object[]{this}) : new int[]{this.mBubbleRow, this.mBubbleColumn};
    }

    public String getProjectTag() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-462363257") ? (String) ipChange.ipc$dispatch("-462363257", new Object[]{this}) : this.mProjectTag;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2032983555")) {
            ipChange.ipc$dispatch("2032983555", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        int dip2px = ScreenUtil.dip2px(this.mContext, 9.0f);
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
        if (AndroidInstantRuntime.support(ipChange, "299215889")) {
            ipChange.ipc$dispatch("299215889", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).measure(View.MeasureSpec.makeMeasureSpec(this.mDayWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(getChildAt(i3).getLayoutParams().height, 1073741824));
        }
        setMeasuredDimension(this.mWidth, this.mRowNum * this.mDayHeigth);
    }

    @SuppressLint({"NewApi"})
    public void setMonth(int i, int i2, List<Day> list, CalendarMonthBean calendarMonthBean, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2090691072")) {
            ipChange.ipc$dispatch("-2090691072", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), list, calendarMonthBean, onClickListener});
            return;
        }
        reSetProjectName();
        this.mItemClickListener = onClickListener;
        this.mYear = i;
        this.mMonth = i2;
        this.mIsCurrentMonth = nf.r(i, i2);
        this.mDays = nf.c(i, i2, list, calendarMonthBean);
        this.mStartWeek = nf.h(i, i2);
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
