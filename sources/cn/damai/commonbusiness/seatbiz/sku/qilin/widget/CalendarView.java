package cn.damai.commonbusiness.seatbiz.sku.qilin.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.ali.user.mobile.utils.ScreenUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.a40;
import tb.pf;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CalendarView extends ViewGroup {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private int mDayHeigth;
    private int mDayWidth;
    private List<DayEntity> mDays;
    private View.OnClickListener mItemClickListener;
    private int mRowNum;
    private int mStartWeek;
    private int mWidth;

    public CalendarView(Context context) {
        this(context, null);
        this.mContext = context;
    }

    private void rePaintView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1178300959")) {
            ipChange.ipc$dispatch("-1178300959", new Object[]{this});
            return;
        }
        removeAllViews();
        int i = DisplayMetrics.getwidthPixels(this.mContext.getResources().getDisplayMetrics());
        this.mWidth = i;
        this.mDayWidth = (i - ScreenUtil.dip2px(this.mContext, 42.0f)) / 7;
        this.mDayHeigth = ScreenUtil.dip2px(this.mContext, 46.0f);
        if (((this.mDays.size() + this.mStartWeek) - 1) % 7 == 0) {
            this.mRowNum = ((this.mDays.size() + this.mStartWeek) - 1) / 7;
        } else {
            this.mRowNum = (((this.mDays.size() + this.mStartWeek) - 1) / 7) + 1;
        }
        for (int i2 = 0; i2 < this.mDays.size(); i2++) {
            DayEntity dayEntity = this.mDays.get(i2);
            if (dayEntity != null) {
                View b = a40.a().b(this.mContext, dayEntity);
                b.setTag(dayEntity);
                b.setOnClickListener(this.mItemClickListener);
                addView(b);
            }
        }
    }

    public void initMonth(MonthEntity monthEntity, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1476588115")) {
            ipChange.ipc$dispatch("1476588115", new Object[]{this, monthEntity, onClickListener});
            return;
        }
        this.mItemClickListener = onClickListener;
        if (monthEntity == null) {
            return;
        }
        this.mDays = monthEntity.days;
        this.mStartWeek = pf.f(monthEntity.year, monthEntity.month);
        if (isInEditMode()) {
            return;
        }
        rePaintView();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-922772284")) {
            ipChange.ipc$dispatch("-922772284", new Object[]{this, Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            return;
        }
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt = getChildAt(i5);
            int i6 = this.mStartWeek;
            int i7 = this.mDayWidth;
            int i8 = this.mDayHeigth;
            childAt.layout(((((i5 + i6) - 1) % 7) * i7) + 0, (((i5 + i6) - 1) / 7) * i8, (((((i5 + i6) - 1) % 7) + 1) * i7) + 0, i8 * ((((i6 + i5) - 1) / 7) + 1));
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "488318738")) {
            ipChange.ipc$dispatch("488318738", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        super.onMeasure(i, i2);
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            getChildAt(i3).measure(View.MeasureSpec.makeMeasureSpec(this.mDayWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(getChildAt(i3).getLayoutParams().height, 1073741824));
        }
        setMeasuredDimension(this.mWidth, this.mRowNum * ScreenUtil.dip2px(this.mContext, 46.0f));
    }

    public CalendarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }
}
