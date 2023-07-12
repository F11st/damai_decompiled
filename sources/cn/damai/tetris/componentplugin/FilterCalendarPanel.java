package cn.damai.tetris.componentplugin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.calendar.CalendarPopView;
import cn.damai.tetris.component.drama.bean.FilterDateBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.mu0;

/* compiled from: Taobao */
@Deprecated
/* loaded from: classes16.dex */
public class FilterCalendarPanel implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnCalendarListener a;
    private ViewGroup b;
    private ViewGroup c;
    private View d;
    private boolean e = false;
    private CalendarPopView f = new CalendarPopView(mu0.a(), true, true, 80, new a());

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public interface OnCalendarListener {
        void onCalendarChanged(FilterDateBean filterDateBean);

        void onVisibilityChanged(boolean z);
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class a implements CalendarPopView.OnDateClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // cn.damai.commonbusiness.calendar.CalendarPopView.OnDateClickListener
        public void onClose() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-723496045")) {
                ipChange.ipc$dispatch("-723496045", new Object[]{this});
            } else {
                FilterCalendarPanel.this.b();
            }
        }

        @Override // cn.damai.commonbusiness.calendar.CalendarPopView.OnDateClickListener
        public void onDateClick(int i, String str, String str2, int i2, String str3) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1255782375")) {
                ipChange.ipc$dispatch("1255782375", new Object[]{this, Integer.valueOf(i), str, str2, Integer.valueOf(i2), str3});
                return;
            }
            if (FilterCalendarPanel.this.a != null) {
                FilterCalendarPanel.this.a.onCalendarChanged(new FilterDateBean(str3, i, str, str2, i2));
            }
            FilterCalendarPanel.this.b();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public static class b implements OnCalendarListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private OnCalendarListener a;

        public b(OnCalendarListener onCalendarListener) {
            this.a = onCalendarListener;
        }

        @Override // cn.damai.tetris.componentplugin.FilterCalendarPanel.OnCalendarListener
        public void onCalendarChanged(FilterDateBean filterDateBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1509961108")) {
                ipChange.ipc$dispatch("-1509961108", new Object[]{this, filterDateBean});
                return;
            }
            OnCalendarListener onCalendarListener = this.a;
            if (onCalendarListener != null) {
                onCalendarListener.onCalendarChanged(filterDateBean);
            }
        }

        @Override // cn.damai.tetris.componentplugin.FilterCalendarPanel.OnCalendarListener
        public void onVisibilityChanged(boolean z) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1487203893")) {
                ipChange.ipc$dispatch("-1487203893", new Object[]{this, Boolean.valueOf(z)});
                return;
            }
            OnCalendarListener onCalendarListener = this.a;
            if (onCalendarListener != null) {
                onCalendarListener.onVisibilityChanged(z);
            }
        }
    }

    public FilterCalendarPanel(ViewGroup viewGroup, OnCalendarListener onCalendarListener) {
        this.c = viewGroup;
        this.b = (ViewGroup) LayoutInflater.from(mu0.a()).inflate(R$layout.item_tetris_filter_calendar_container, viewGroup, false);
        this.d = this.b.findViewById(R$id.calendar_top_padding);
        ((FrameLayout) this.b.findViewById(R$id.calendar_out_container)).addView(this.f.s(), -1, -1);
        viewGroup.addView(this.b, -1, -1);
        this.a = new b(onCalendarListener);
        this.d.setOnClickListener(this);
    }

    public void b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-220124689")) {
            ipChange.ipc$dispatch("-220124689", new Object[]{this});
        } else if (this.e) {
        } else {
            this.b.setVisibility(8);
            this.f.t();
            this.a.onVisibilityChanged(false);
        }
    }

    public void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "113468818")) {
            ipChange.ipc$dispatch("113468818", new Object[]{this});
        } else if (this.e) {
        } else {
            this.e = true;
            this.c.removeView(this.b);
        }
    }

    public void d(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1093783761")) {
            ipChange.ipc$dispatch("-1093783761", new Object[]{this, Integer.valueOf(i)});
        } else if (this.e) {
        } else {
            ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = i;
                this.d.requestLayout();
            }
            this.b.setVisibility(0);
            this.f.E();
            this.a.onVisibilityChanged(true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525527394")) {
            ipChange.ipc$dispatch("1525527394", new Object[]{this, view});
        } else {
            b();
        }
    }
}
