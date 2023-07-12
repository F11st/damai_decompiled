package tb;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.damai.common.image.C0504a;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.C0529c;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.login.LoginManager;
import cn.damai.mine.userinfo.bean.UserCenterDataBean;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class xf1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private Activity a;
    private View b;
    private View c;
    private ImageView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private LinearLayout h;
    private TextView i;
    private DMIconFontTextView j;

    /* compiled from: Taobao */
    /* renamed from: tb.xf1$a */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC9925a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC9925a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "647963276")) {
                ipChange.ipc$dispatch("647963276", new Object[]{this, view});
                return;
            }
            String str = (String) view.getTag();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            C0529c.e().x(vf1.x().g0("myordersfirst"));
            xf1.this.e(str);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.xf1$b */
    /* loaded from: classes6.dex */
    public class View$OnClickListenerC9926b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        View$OnClickListenerC9926b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1535713651")) {
                ipChange.ipc$dispatch("-1535713651", new Object[]{this, view});
                return;
            }
            Object tag = view.getTag();
            if (tag != null) {
                xf1.this.c((String) tag);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.xf1$c */
    /* loaded from: classes6.dex */
    public class C9927c implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C9927c(xf1 xf1Var) {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.C0501d c0501d) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "220223168")) {
                ipChange.ipc$dispatch("220223168", new Object[]{this, c0501d});
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.xf1$d */
    /* loaded from: classes6.dex */
    public class C9928d implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C9928d() {
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.C0502e c0502e) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-908576683")) {
                ipChange.ipc$dispatch("-908576683", new Object[]{this, c0502e});
            } else if (c0502e == null || c0502e.a == null) {
            } else {
                xf1.this.d.setImageDrawable(c0502e.a);
            }
        }
    }

    public xf1(Activity activity, View view) {
        this.a = activity;
        this.b = (View) view.getParent();
        g();
        i();
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-895059385")) {
            ipChange.ipc$dispatch("-895059385", new Object[]{this, str});
            return;
        }
        this.h.setVisibility(8);
        z20.T("closed_announcement", "true");
        z20.T("closed_notice_str", str);
        C0529c.e().x(vf1.x().h0());
    }

    private UserCenterDataBean.TransitStepInfo d(UserCenterDataBean.LogisticsInfo logisticsInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1522756557")) {
            return (UserCenterDataBean.TransitStepInfo) ipChange.ipc$dispatch("-1522756557", new Object[]{this, logisticsInfo});
        }
        if (logisticsInfo == null || logisticsInfo.getTransitStepInfos().isEmpty()) {
            return null;
        }
        return logisticsInfo.getTransitStepInfos().get(0);
    }

    private void g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "761087060")) {
            ipChange.ipc$dispatch("761087060", new Object[]{this});
            return;
        }
        View findViewById = this.b.findViewById(R$id.ll_mine_order_logistics);
        this.c = findViewById;
        findViewById.setVisibility(8);
        this.d = (ImageView) this.c.findViewById(R$id.iv_mine_logistics_image);
        this.e = (TextView) this.c.findViewById(R$id.tv_mine_logistics_status);
        this.f = (TextView) this.c.findViewById(R$id.tv_mine_logistics_action);
        this.g = (TextView) this.c.findViewById(R$id.tv_mine_logistics_status_time);
        this.c.setOnClickListener(new View$OnClickListenerC9925a());
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "457053409")) {
            ipChange.ipc$dispatch("457053409", new Object[]{this});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R$id.rv_mine_announcement);
        this.h = linearLayout;
        linearLayout.setVisibility(8);
        this.i = (TextView) this.b.findViewById(R$id.tv_mine_announcement_content);
        DMIconFontTextView dMIconFontTextView = (DMIconFontTextView) this.b.findViewById(R$id.tv_mine_announcement_close);
        this.j = dMIconFontTextView;
        dMIconFontTextView.setOnClickListener(new View$OnClickListenerC9926b());
    }

    private void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1453489607")) {
            ipChange.ipc$dispatch("-1453489607", new Object[]{this});
        }
    }

    private void j(UserCenterDataBean.LogisticsInfo logisticsInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1734295118")) {
            ipChange.ipc$dispatch("1734295118", new Object[]{this, logisticsInfo});
        } else if (logisticsInfo == null || this.a == null) {
        } else {
            DMImageCreator e = C0504a.b().e(logisticsInfo.getPerformImageUrl());
            int i = R$drawable.uikit_default_image_bg_gradient;
            e.i(i).c(i).k(new DMRoundedCornersBitmapProcessor(m62.a(this.a, 6.0f), 0)).n(new C9928d()).e(new C9927c(this)).f();
        }
    }

    private void k(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-124765722")) {
            ipChange.ipc$dispatch("-124765722", new Object[]{this, str});
        } else if (!TextUtils.isEmpty(str)) {
            this.h.setVisibility(0);
            this.j.setTag(str);
            this.i.setText(str);
        } else {
            this.h.setVisibility(8);
        }
    }

    public void e(String str) {
        Activity activity;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1033853221")) {
            ipChange.ipc$dispatch("-1033853221", new Object[]{this, str});
        } else if (LoginManager.k().q()) {
            if (TextUtils.isEmpty(str) || (activity = this.a) == null) {
                return;
            }
            DMNav.from(activity).toUri(str);
        } else {
            wf1.c(this.a);
        }
    }

    public void f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1540752425")) {
            ipChange.ipc$dispatch("-1540752425", new Object[]{this});
            return;
        }
        View view = this.c;
        if (view != null) {
            view.setTag(null);
            this.c.setVisibility(8);
        }
    }

    public void l(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-338880166")) {
            ipChange.ipc$dispatch("-338880166", new Object[]{this, str});
            return;
        }
        String B = z20.B("closed_announcement");
        String B2 = z20.B("closed_notice_str");
        if ("true".equals(B)) {
            if (!TextUtils.isEmpty(str) && !B2.equals(str)) {
                z20.T("closed_announcement", "false");
                this.h.setVisibility(0);
                this.j.setTag(str);
                this.i.setText(str);
                return;
            }
            this.h.setVisibility(8);
            return;
        }
        k(str);
    }

    public void m(UserCenterDataBean.LogisticsInfo logisticsInfo) {
        String str;
        String str2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1557991562")) {
            ipChange.ipc$dispatch("-1557991562", new Object[]{this, logisticsInfo});
        } else if (logisticsInfo == null) {
            this.c.setVisibility(8);
        } else {
            this.c.setVisibility(0);
            this.c.setTag(logisticsInfo.getOrderDetailUrl());
            String waybillId = logisticsInfo.getWaybillId();
            String waybillName = logisticsInfo.getWaybillName();
            String status = logisticsInfo.getStatus();
            j(logisticsInfo);
            UserCenterDataBean.TransitStepInfo d = d(logisticsInfo);
            if (d != null) {
                str2 = d.getStatusTime();
                str = d.getStatusDesc();
            } else {
                str = "";
                str2 = str;
            }
            if (TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                if (TextUtils.isEmpty(waybillName)) {
                    waybillName = "";
                }
                sb.append(waybillName);
                sb.append(" ");
                if (TextUtils.isEmpty(waybillId)) {
                    waybillId = "";
                }
                sb.append(waybillId);
                str = sb.toString();
            }
            TextView textView = this.e;
            if (TextUtils.isEmpty(status)) {
                status = "";
            }
            textView.setText(status);
            TextView textView2 = this.f;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            textView2.setText(str);
            this.g.setText(TextUtils.isEmpty(str2) ? "" : str2);
        }
    }
}
