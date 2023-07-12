package cn.damai.category.calendar.ui.viewholder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.category.calendar.bean.Day;
import cn.damai.category.common.bean.CalendarBean;
import cn.damai.category.common.bean.CalendarMonthBean;
import cn.damai.category.common.bean.CalendarYearBean;
import cn.damai.category.common.widget.CalendarView;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.rf;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class CalendarViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private CalendarView c;
    private LinearLayout d;
    private TextView e;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ ScaleAnimation b;

        a(CalendarViewHolder calendarViewHolder, View view, ScaleAnimation scaleAnimation) {
            this.a = view;
            this.b = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "938553409")) {
                ipChange.ipc$dispatch("938553409", new Object[]{this, animation});
            } else {
                this.a.startAnimation(this.b);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-305095789")) {
                ipChange.ipc$dispatch("-305095789", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1498106022")) {
                ipChange.ipc$dispatch("-1498106022", new Object[]{this, animation});
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ ScaleAnimation b;

        b(CalendarViewHolder calendarViewHolder, View view, ScaleAnimation scaleAnimation) {
            this.a = view;
            this.b = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1631946114")) {
                ipChange.ipc$dispatch("1631946114", new Object[]{this, animation});
            } else {
                this.a.startAnimation(this.b);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "2059252402")) {
                ipChange.ipc$dispatch("2059252402", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-867647397")) {
                ipChange.ipc$dispatch("-867647397", new Object[]{this, animation});
            }
        }
    }

    public CalendarViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.calendar_pop_item, (ViewGroup) null));
        this.a = (TextView) this.itemView.findViewById(R$id.tv_calendar_month);
        this.b = (TextView) this.itemView.findViewById(R$id.tv_shenhua);
        this.c = (CalendarView) this.itemView.findViewById(R$id.view_calendar);
        this.d = (LinearLayout) this.itemView.findViewById(R$id.layout_project_tag);
        this.e = (TextView) this.itemView.findViewById(R$id.tv_project);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1762632421")) {
            ipChange.ipc$dispatch("-1762632421", new Object[]{this, view});
            return;
        }
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.4f, 1.0f, 1.4f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setRepeatCount(0);
        scaleAnimation.setFillAfter(true);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.4f, 0.7f, 1.4f, 0.7f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(200L);
        scaleAnimation2.setRepeatCount(0);
        scaleAnimation2.setFillAfter(true);
        ScaleAnimation scaleAnimation3 = new ScaleAnimation(0.7f, 1.0f, 0.7f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation3.setDuration(200L);
        scaleAnimation3.setRepeatCount(0);
        scaleAnimation3.setFillAfter(false);
        scaleAnimation.setAnimationListener(new a(this, view, scaleAnimation2));
        scaleAnimation2.setAnimationListener(new b(this, view, scaleAnimation3));
        view.startAnimation(scaleAnimation);
    }

    public void a(int i, int i2, List<Day> list, CalendarBean calendarBean, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1784169945")) {
            ipChange.ipc$dispatch("-1784169945", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), list, calendarBean, onClickListener});
            return;
        }
        TextView textView = this.a;
        textView.setText(i + "/" + rf.e(i2));
        String f = rf.f(i, i2, calendarBean);
        if (!TextUtils.isEmpty(f)) {
            this.b.setVisibility(0);
            this.b.setText(f);
        } else {
            this.b.setText("");
            this.b.setVisibility(8);
        }
        CalendarMonthBean calendarMonthBean = null;
        if (calendarBean != null && wh2.e(calendarBean.calendar) > 0) {
            for (int i3 = 0; i3 < calendarBean.calendar.size(); i3++) {
                CalendarYearBean calendarYearBean = calendarBean.calendar.get(i3);
                if (calendarYearBean != null && wh2.e(calendarYearBean.months) > 0) {
                    for (int i4 = 0; i4 < calendarYearBean.months.size(); i4++) {
                        CalendarMonthBean calendarMonthBean2 = calendarYearBean.months.get(i4);
                        if (calendarMonthBean2 != null && calendarYearBean.year == i && calendarMonthBean2.month == i2) {
                            calendarMonthBean = calendarMonthBean2;
                        }
                    }
                }
            }
        }
        this.c.setMonth(i, i2, list, calendarMonthBean, onClickListener);
        int i5 = this.c.getLocation()[0];
        int i6 = this.c.getLocation()[1];
        if (i5 > 0 && i6 > 0 && !TextUtils.isEmpty(this.c.getProjectTag())) {
            this.d.setVisibility(0);
            this.e.setText(this.c.getProjectTag());
            int dayWidth = this.c.getDayWidth();
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            this.e.measure(makeMeasureSpec, makeMeasureSpec);
            ((FrameLayout.LayoutParams) this.d.getLayoutParams()).setMargins(ScreenUtil.dip2px(this.itemView.getContext(), 18.0f) + ((i6 - 1) * dayWidth) + ((dayWidth / 2) - (this.e.getMeasuredWidth() / 2)), ScreenUtil.dip2px(this.itemView.getContext(), 4.0f) + ScreenUtil.dip2px(this.itemView.getContext(), (i5 - 1) * 46), 0, 0);
            b(this.d);
            return;
        }
        this.d.setVisibility(8);
    }
}
