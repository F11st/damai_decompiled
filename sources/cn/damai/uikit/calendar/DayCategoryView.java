package cn.damai.uikit.calendar;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import cn.damai.uikit.R$color;
import cn.damai.uikit.R$drawable;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Date;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class DayCategoryView extends LinearLayout {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context mContext;
    private DayView mDayView;
    private TextView mMarkClass;
    private TextView mMarkHoliday;
    private TextView mMarkProject;

    public DayCategoryView(@NonNull Context context, CalendarDay calendarDay) {
        super(context);
        this.mContext = context;
        initView(context);
        initData(calendarDay);
    }

    private void initData(CalendarDay calendarDay) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-833890125")) {
            ipChange.ipc$dispatch("-833890125", new Object[]{this, calendarDay});
        } else {
            this.mDayView.setDay(calendarDay);
        }
    }

    private void initView(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "174513258")) {
            ipChange.ipc$dispatch("174513258", new Object[]{this, context});
            return;
        }
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R$layout.layout_day_category_view, this);
        this.mDayView = (DayView) inflate.findViewById(R$id.day_view);
        this.mMarkClass = (TextView) inflate.findViewById(R$id.tv_mark_class);
        this.mMarkProject = (TextView) inflate.findViewById(R$id.tv_mark_project);
        this.mMarkHoliday = (TextView) inflate.findViewById(R$id.tv_mark_holiday);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void applyFacade(a aVar) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "1595706176")) {
            ipChange.ipc$dispatch("1595706176", new Object[]{this, aVar});
        } else if (aVar == null) {
        } else {
            boolean z2 = this.mDayView.isInMonth() && this.mDayView.isInRange();
            boolean equals = this.mDayView.getDate().equals(CalendarDay.from(new Date()));
            if (aVar.f()) {
                this.mMarkProject.setVisibility(0);
                if (z2) {
                    this.mMarkProject.setBackgroundResource(R$drawable.red_radius);
                } else {
                    this.mMarkProject.setBackgroundResource(R$drawable.grey_radius);
                }
            } else {
                this.mMarkProject.setVisibility(4);
            }
            if (aVar.g()) {
                this.mMarkClass.setText("休");
                this.mMarkClass.setBackgroundResource(R$drawable.icon_calendar_ban);
            } else if (aVar.h()) {
                this.mMarkClass.setText("班");
                this.mMarkClass.setBackgroundResource(R$drawable.icon_calendar_xiu);
            } else {
                z = false;
            }
            this.mMarkClass.setVisibility(z ? 0 : 4);
            if (equals) {
                this.mMarkHoliday.setVisibility(0);
                this.mMarkHoliday.setText("今天");
                this.mMarkHoliday.setTextColor(ContextCompat.getColor(this.mContext, R$color.day_default_day));
            } else if (TextUtils.isEmpty(aVar.e())) {
                this.mMarkHoliday.setVisibility(4);
            } else {
                this.mMarkHoliday.setVisibility(0);
                this.mMarkHoliday.setText(aVar.e());
                if (z2) {
                    this.mMarkHoliday.setTextColor(ContextCompat.getColor(this.mContext, R$color.coupon_item_price_red));
                } else {
                    this.mMarkHoliday.setTextColor(ContextCompat.getColor(this.mContext, R$color.text_ddd));
                }
            }
            this.mDayView.applyFacade(aVar);
            if (aVar.n() && z2) {
                this.mDayView.setTextColor(ContextCompat.getColor(this.mContext, R$color.coupon_item_price_red));
            }
        }
    }

    public DayView getDayView() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "849924161") ? (DayView) ipChange.ipc$dispatch("849924161", new Object[]{this}) : this.mDayView;
    }
}
