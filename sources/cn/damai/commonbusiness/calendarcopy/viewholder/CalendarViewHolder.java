package cn.damai.commonbusiness.calendarcopy.viewholder;

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
import cn.damai.commonbusiness.calendarcopy.bean.CalendarBean;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarMonthBean;
import cn.damai.commonbusiness.calendarcopy.bean.CalendarYearBean;
import cn.damai.commonbusiness.calendarcopy.bean.Day;
import cn.damai.commonbusiness.calendarcopy.view.CalendarView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.bb2;
import tb.k62;
import tb.of;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class CalendarViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;
    private CalendarView c;
    private LinearLayout d;
    private TextView e;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendarcopy.viewholder.CalendarViewHolder$a  reason: invalid class name */
    /* loaded from: classes14.dex */
    public class animationAnimation$AnimationListenerC0597a implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ ScaleAnimation b;

        animationAnimation$AnimationListenerC0597a(CalendarViewHolder calendarViewHolder, View view, ScaleAnimation scaleAnimation) {
            this.a = view;
            this.b = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1072078298")) {
                ipChange.ipc$dispatch("-1072078298", new Object[]{this, animation});
            } else {
                this.a.startAnimation(this.b);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1420369010")) {
                ipChange.ipc$dispatch("-1420369010", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-979893249")) {
                ipChange.ipc$dispatch("-979893249", new Object[]{this, animation});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendarcopy.viewholder.CalendarViewHolder$b  reason: invalid class name */
    /* loaded from: classes14.dex */
    public class animationAnimation$AnimationListenerC0598b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ ScaleAnimation b;

        animationAnimation$AnimationListenerC0598b(CalendarViewHolder calendarViewHolder, View view, ScaleAnimation scaleAnimation) {
            this.a = view;
            this.b = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-378685593")) {
                ipChange.ipc$dispatch("-378685593", new Object[]{this, animation});
            } else {
                this.a.startAnimation(this.b);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "943979181")) {
                ipChange.ipc$dispatch("943979181", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-349434624")) {
                ipChange.ipc$dispatch("-349434624", new Object[]{this, animation});
            }
        }
    }

    public CalendarViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.copy_common_calendar_pop_item, (ViewGroup) null));
        this.a = (TextView) this.itemView.findViewById(R$id.tv_calendar_month);
        this.b = (TextView) this.itemView.findViewById(R$id.tv_shenhua);
        this.c = (CalendarView) this.itemView.findViewById(R$id.view_calendar);
        this.d = (LinearLayout) this.itemView.findViewById(R$id.layout_project_tag);
        this.e = (TextView) this.itemView.findViewById(R$id.tv_project);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1895125440")) {
            ipChange.ipc$dispatch("-1895125440", new Object[]{this, view});
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
        scaleAnimation.setAnimationListener(new animationAnimation$AnimationListenerC0597a(this, view, scaleAnimation2));
        scaleAnimation2.setAnimationListener(new animationAnimation$AnimationListenerC0598b(this, view, scaleAnimation3));
        view.startAnimation(scaleAnimation);
    }

    public void a(int i, int i2, List<Day> list, CalendarBean calendarBean, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1691596231")) {
            ipChange.ipc$dispatch("1691596231", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), list, calendarBean, onClickListener});
            return;
        }
        TextView textView = this.a;
        textView.setText(i + "/" + of.d(i2));
        String e = of.e(i, i2, calendarBean);
        if (!TextUtils.isEmpty(e)) {
            this.b.setVisibility(0);
            this.b.setText(e);
        } else {
            this.b.setText("");
            this.b.setVisibility(8);
        }
        CalendarMonthBean calendarMonthBean = null;
        if (calendarBean != null && bb2.c(calendarBean.calendar) > 0) {
            for (int i3 = 0; i3 < calendarBean.calendar.size(); i3++) {
                CalendarYearBean calendarYearBean = calendarBean.calendar.get(i3);
                if (calendarYearBean != null && bb2.c(calendarYearBean.months) > 0) {
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
            ((FrameLayout.LayoutParams) this.d.getLayoutParams()).setMargins(k62.a(this.itemView.getContext(), 18.0f) + ((i6 - 1) * dayWidth) + ((dayWidth / 2) - (this.e.getMeasuredWidth() / 2)), k62.a(this.itemView.getContext(), 4.0f) + k62.a(this.itemView.getContext(), (i5 - 1) * 46), 0, 0);
            b(this.d);
            return;
        }
        this.d.setVisibility(8);
    }
}