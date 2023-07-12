package cn.damai.launcher.splash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.damai.commonbusiness.search.TimerView;
import cn.damai.homepage.R$id;
import cn.damai.launcher.splash.api.Coupon;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.d13;
import tb.m62;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class CouponViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    public ViewGroup a;
    private Context b;
    private TextView c;
    private TextView d;
    private TextView e;
    private TextView f;
    private RelativeLayout g;
    private RelativeLayout h;
    private View i;
    private TimerView j;
    private View k;
    Coupon l;

    public CouponViewHolder(ViewGroup viewGroup, Context context) {
        this.a = viewGroup;
        this.b = context;
        this.c = (TextView) viewGroup.findViewById(R$id.common_card_top_value);
        this.d = (TextView) this.a.findViewById(R$id.common_card_top_info);
        this.e = (TextView) this.a.findViewById(R$id.common_card_desc_info);
        TextView textView = (TextView) this.a.findViewById(R$id.common_card_desc_info2);
        this.f = textView;
        textView.setVisibility(0);
        this.g = (RelativeLayout) this.a.findViewById(R$id.rl_guide_left);
        this.h = (RelativeLayout) this.a.findViewById(R$id.rl_guide_right);
        this.i = this.a.findViewById(R$id.guide_coupon_gap);
        TimerView timerView = (TimerView) this.a.findViewById(R$id.common_card_desc_timer);
        this.j = timerView;
        timerView.setVisibility(8);
        View findViewById = this.a.findViewById(R$id.common_card_desc_timer_desc);
        this.k = findViewById;
        findViewById.setVisibility(8);
    }

    public void b(Coupon coupon) {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "872906892")) {
            ipChange.ipc$dispatch("872906892", new Object[]{this, coupon});
        } else if (coupon == null) {
        } else {
            this.l = coupon;
            this.c.setText(coupon.decreaseMoneyNum);
            this.d.setText(coupon.overAmountText);
            this.e.setText(coupon.name);
            TextView textView = this.f;
            if (textView == null || (str = coupon.tag) == null) {
                return;
            }
            textView.setText(str);
        }
    }

    public void c(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "686223874")) {
            ipChange.ipc$dispatch("686223874", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        this.a.findViewById(R$id.guide_coupon_gapleft).setVisibility(i);
        this.i.setVisibility(i2);
    }

    public void d(int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1233357961")) {
            ipChange.ipc$dispatch("-1233357961", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)});
            return;
        }
        ViewGroup.LayoutParams layoutParams = this.g.getLayoutParams();
        layoutParams.width = m62.a(this.b, i);
        layoutParams.height = -1;
        this.g.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams2 = this.h.getLayoutParams();
        layoutParams2.width = m62.a(this.b, i2);
        layoutParams2.height = -1;
        this.h.setLayoutParams(layoutParams2);
    }

    public Coupon getCoupon() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1619027736") ? (Coupon) ipChange.ipc$dispatch("-1619027736", new Object[]{this}) : this.l;
    }

    public void setCouponTextLine(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1604546390")) {
            ipChange.ipc$dispatch("-1604546390", new Object[]{this, Integer.valueOf(i)});
            return;
        }
        this.d.setMaxLines(i);
        ViewGroup viewGroup = this.a;
        int i2 = R$id.common_card_top_vv;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup.findViewById(i2).getLayoutParams();
        if (i == 2) {
            layoutParams.setMargins(0, t60.a(this.b, 5.0f), 0, 0);
        } else {
            layoutParams.setMargins(0, t60.a(this.b, 10.0f), 0, 0);
        }
        this.a.findViewById(i2).setLayoutParams(layoutParams);
    }

    public void setTimer(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "210659871")) {
            ipChange.ipc$dispatch("210659871", new Object[]{this, Long.valueOf(j)});
            return;
        }
        this.j.setVisibility(8);
        this.k.setVisibility(8);
        this.f.setVisibility(8);
        Object tag = this.j.getTag();
        if (tag instanceof d13) {
            ((d13) tag).cancel();
            this.j.setTag(null);
        }
        if (j > 0) {
            long currentTimeMillis = j - System.currentTimeMillis();
            if (currentTimeMillis > 0) {
                d13 d13Var = new d13(currentTimeMillis, 1000L, this.j);
                d13Var.start();
                this.j.setTag(d13Var);
                this.j.setVisibility(0);
                this.k.setVisibility(0);
            } else {
                this.j.setTimeUp();
            }
        }
        this.j.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: cn.damai.launcher.splash.CouponViewHolder.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-581777008")) {
                    ipChange2.ipc$dispatch("-581777008", new Object[]{this, view});
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "-618452467")) {
                    ipChange2.ipc$dispatch("-618452467", new Object[]{this, view});
                    return;
                }
                Object tag2 = CouponViewHolder.this.j.getTag();
                if (tag2 instanceof d13) {
                    ((d13) tag2).cancel();
                    CouponViewHolder.this.j.setTag(null);
                }
            }
        });
    }
}
