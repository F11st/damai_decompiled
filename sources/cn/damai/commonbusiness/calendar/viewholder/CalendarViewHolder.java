package cn.damai.commonbusiness.calendar.viewholder;

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
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.calendar.bean.CalendarBean;
import cn.damai.commonbusiness.calendar.bean.CalendarMonthBean;
import cn.damai.commonbusiness.calendar.bean.CalendarYearBean;
import cn.damai.commonbusiness.calendar.bean.Day;
import cn.damai.commonbusiness.calendar.view.CalendarView;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.nf;
import tb.wh2;

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
    /* renamed from: cn.damai.commonbusiness.calendar.viewholder.CalendarViewHolder$a  reason: invalid class name */
    /* loaded from: classes14.dex */
    public class animationAnimation$AnimationListenerC0588a implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ ScaleAnimation b;

        animationAnimation$AnimationListenerC0588a(CalendarViewHolder calendarViewHolder, View view, ScaleAnimation scaleAnimation) {
            this.a = view;
            this.b = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-996318735")) {
                ipChange.ipc$dispatch("-996318735", new Object[]{this, animation});
            } else {
                this.a.startAnimation(this.b);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "674941923")) {
                ipChange.ipc$dispatch("674941923", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1189397238")) {
                ipChange.ipc$dispatch("-1189397238", new Object[]{this, animation});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.calendar.viewholder.CalendarViewHolder$b  reason: invalid class name */
    /* loaded from: classes14.dex */
    public class animationAnimation$AnimationListenerC0589b implements Animation.AnimationListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ ScaleAnimation b;

        animationAnimation$AnimationListenerC0589b(CalendarViewHolder calendarViewHolder, View view, ScaleAnimation scaleAnimation) {
            this.a = view;
            this.b = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-302926030")) {
                ipChange.ipc$dispatch("-302926030", new Object[]{this, animation});
            } else {
                this.a.startAnimation(this.b);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1255677182")) {
                ipChange.ipc$dispatch("-1255677182", new Object[]{this, animation});
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-558938613")) {
                ipChange.ipc$dispatch("-558938613", new Object[]{this, animation});
            }
        }
    }

    public CalendarViewHolder(LayoutInflater layoutInflater) {
        super(layoutInflater.inflate(R$layout.common_calendar_pop_item, (ViewGroup) null));
        this.a = (TextView) this.itemView.findViewById(R$id.tv_calendar_month);
        this.b = (TextView) this.itemView.findViewById(R$id.tv_shenhua);
        this.c = (CalendarView) this.itemView.findViewById(R$id.view_calendar);
        this.d = (LinearLayout) this.itemView.findViewById(R$id.layout_project_tag);
        this.e = (TextView) this.itemView.findViewById(R$id.tv_project);
    }

    private void b(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-659645749")) {
            ipChange.ipc$dispatch("-659645749", new Object[]{this, view});
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
        scaleAnimation.setAnimationListener(new animationAnimation$AnimationListenerC0588a(this, view, scaleAnimation2));
        scaleAnimation2.setAnimationListener(new animationAnimation$AnimationListenerC0589b(this, view, scaleAnimation3));
        view.startAnimation(scaleAnimation);
    }

    public void a(int i, int i2, List<Day> list, CalendarBean calendarBean, View.OnClickListener onClickListener) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-94534691")) {
            ipChange.ipc$dispatch("-94534691", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2), list, calendarBean, onClickListener});
            return;
        }
        TextView textView = this.a;
        textView.setText(i + "/" + nf.d(i2));
        String e = nf.e(i, i2, calendarBean);
        if (!TextUtils.isEmpty(e)) {
            this.b.setVisibility(0);
            this.b.setText(e);
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
