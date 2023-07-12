package cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.net.mtop.netfit.DMMtopRequestListener;
import cn.damai.common.user.C0529c;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.calendar.remind.CalendarsResolver;
import cn.damai.commonbusiness.update.UpdateUtil;
import cn.damai.login.LoginManager;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectTickGuidePreBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.bean.LoginBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.request.LoginCheckRequest;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.DashedLine;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import mtopsdk.mtop.util.ErrorConstant;
import tb.gn2;
import tb.hw1;
import tb.ir1;
import tb.m62;
import tb.mr1;
import tb.pp2;
import tb.qv1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class TicketGuidePreLineViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private DMIconFontTextView a;
    private TextView b;
    private TextView c;
    private LinearLayout d;
    private DMIconFontTextView e;
    private TextView f;
    private DashedLine g;
    private DashedLine h;
    private Activity i;
    private int j;
    private int k;
    private int l;
    private int m;
    private CalendarsResolver.RemindMeListener n;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuidePreLineViewHolder$a */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2425a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        View$OnClickListenerC2425a(TicketGuidePreLineViewHolder ticketGuidePreLineViewHolder, String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1746161327")) {
                ipChange.ipc$dispatch("-1746161327", new Object[]{this, view});
                return;
            }
            C0529c.e().x(pp2.u().F2(this.a));
            UpdateUtil.d();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuidePreLineViewHolder$b */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2426b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        View$OnClickListenerC2426b(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "365129042")) {
                ipChange.ipc$dispatch("365129042", new Object[]{this, view});
                return;
            }
            C0529c.e().x(pp2.u().D2(this.a));
            LoginManager.k().w(TicketGuidePreLineViewHolder.this.i, new Intent());
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuidePreLineViewHolder$c */
    /* loaded from: classes16.dex */
    public class View$OnClickListenerC2427c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ProjectTickGuidePreBean a;

        View$OnClickListenerC2427c(ProjectTickGuidePreBean projectTickGuidePreBean) {
            this.a = projectTickGuidePreBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "292742484")) {
                ipChange.ipc$dispatch("292742484", new Object[]{this, view});
                return;
            }
            C0529c.e().x(pp2.u().E2(this.a.projectId));
            Activity activity = TicketGuidePreLineViewHolder.this.i;
            ProjectTickGuidePreBean projectTickGuidePreBean = this.a;
            qv1.e(activity, projectTickGuidePreBean.calendarRemindTitle, projectTickGuidePreBean.sellStartTime, TicketGuidePreLineViewHolder.this.n);
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuidePreLineViewHolder$d */
    /* loaded from: classes8.dex */
    public class C2428d implements CalendarsResolver.RemindMeListener {
        private static transient /* synthetic */ IpChange $ipChange;

        C2428d() {
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void addRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1631918273")) {
                ipChange.ipc$dispatch("-1631918273", new Object[]{this});
                return;
            }
            TicketGuidePreLineViewHolder.this.f.setText("取消设置");
            qv1.f(TicketGuidePreLineViewHolder.this.i, "添加日历提醒成功", "开抢前10分钟将收到手机日历提醒，可在系统日历中更改提醒时间");
        }

        @Override // cn.damai.commonbusiness.calendar.remind.CalendarsResolver.RemindMeListener
        public void candelRemindmeSuccess() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1655647771")) {
                ipChange.ipc$dispatch("1655647771", new Object[]{this});
                return;
            }
            TicketGuidePreLineViewHolder.this.f.setText("设置");
            ToastUtil.i("取消提醒成功");
        }
    }

    public TicketGuidePreLineViewHolder(Activity activity) {
        super(LayoutInflater.from(activity).inflate(R$layout.layout_ticket_guide_pre_line, (ViewGroup) null, false));
        this.n = new C2428d();
        this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        this.i = activity;
        this.a = (DMIconFontTextView) this.itemView.findViewById(R$id.icon_guide);
        this.b = (TextView) this.itemView.findViewById(R$id.tv_guide_name);
        this.c = (TextView) this.itemView.findViewById(R$id.tv_guide_desc);
        this.d = (LinearLayout) this.itemView.findViewById(R$id.ll_button);
        this.e = (DMIconFontTextView) this.itemView.findViewById(R$id.icon_button_text);
        this.f = (TextView) this.itemView.findViewById(R$id.tv_button_text);
        DashedLine dashedLine = (DashedLine) this.itemView.findViewById(R$id.dash_vertical_view);
        this.g = dashedLine;
        dashedLine.setVisibility(0);
        this.h = (DashedLine) this.itemView.findViewById(R$id.top_dash_line);
        this.j = m62.a(activity, 21.0f);
        e();
    }

    private void e() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1438578492")) {
            ipChange.ipc$dispatch("-1438578492", new Object[]{this});
            return;
        }
        this.k = ContextCompat.getColor(this.i, R$color.color_00BD67);
        this.l = ContextCompat.getColor(this.i, R$color.color_666666);
        this.m = ContextCompat.getColor(this.i, R$color.color_cccccc);
    }

    private void f(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1135403880")) {
            ipChange.ipc$dispatch("1135403880", new Object[]{this, Integer.valueOf(i)});
        } else if (i % 2 == 1) {
            this.g.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams.leftMargin = this.j;
            layoutParams.rightMargin = 0;
            this.h.setLayoutParams(layoutParams);
        } else {
            this.g.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams2.leftMargin = 0;
            layoutParams2.rightMargin = this.j;
            this.h.setLayoutParams(layoutParams2);
        }
    }

    private void g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "613422913")) {
            ipChange.ipc$dispatch("613422913", new Object[]{this, str});
            return;
        }
        this.d.setVisibility(0);
        this.d.setBackgroundResource(R$drawable.bg_ticket_guide_btn);
        this.e.setVisibility(8);
        this.f.setTextColor(Color.parseColor("#ffffff"));
        this.f.setText(str);
    }

    private void h(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1239860530")) {
            ipChange.ipc$dispatch("-1239860530", new Object[]{this, str});
            return;
        }
        this.d.setVisibility(0);
        this.d.setBackgroundColor(Color.parseColor("#ffffff"));
        this.d.setOnClickListener(null);
        this.f.setTextColor(this.k);
        this.e.setTextColor(this.k);
        this.e.setText(this.i.getString(R$string.iconfont_duihaomian_));
        this.e.setVisibility(0);
        this.f.setText(str);
    }

    private void i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "83017188")) {
            ipChange.ipc$dispatch("83017188", new Object[]{this, str});
            return;
        }
        String a = hw1.a();
        if (a != null) {
            if ("true".equals(a)) {
                g("升级");
                this.d.setOnClickListener(new View$OnClickListenerC2425a(this, str));
                return;
            }
            h("最新版");
            return;
        }
        h("最新版");
    }

    private void j(final String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1506751949")) {
            ipChange.ipc$dispatch("-1506751949", new Object[]{this, str});
        } else if (!LoginManager.k().q()) {
            g("登录");
            this.d.setOnClickListener(new View$OnClickListenerC2426b(str));
        } else {
            g("去检查");
            this.d.setOnClickListener(new View.OnClickListener(this) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuidePreLineViewHolder.3
                private static transient /* synthetic */ IpChange $ipChange;

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    IpChange ipChange2 = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange2, "-1818547885")) {
                        ipChange2.ipc$dispatch("-1818547885", new Object[]{this, view});
                        return;
                    }
                    C0529c.e().x(pp2.u().D2(str));
                    new LoginCheckRequest().request(new DMMtopRequestListener<LoginBean>(LoginBean.class) { // from class: cn.damai.trade.newtradeorder.ui.projectdetail.robticketstrategy.viewholder.TicketGuidePreLineViewHolder.3.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                        public void onFail(String str2, String str3) {
                            IpChange ipChange3 = $ipChange;
                            boolean z = true;
                            if (AndroidInstantRuntime.support(ipChange3, "-422905850")) {
                                ipChange3.ipc$dispatch("-422905850", new Object[]{this, str2, str3});
                                return;
                            }
                            boolean isSessionInvalid = ErrorConstant.isSessionInvalid(str2);
                            if (TextUtils.isEmpty(str2) || !ErrorConstant.ERRCODE_ANDROID_SYS_LOGIN_CANCEL.equals(str2)) {
                                z = isSessionInvalid;
                            }
                            if (z || TextUtils.isEmpty(str3)) {
                                return;
                            }
                            ToastUtil.i(str3);
                        }

                        @Override // cn.damai.common.net.mtop.netfit.DMMtopRequestListener
                        public void onSuccess(LoginBean loginBean) {
                            IpChange ipChange3 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange3, "1155589740")) {
                                ipChange3.ipc$dispatch("1155589740", new Object[]{this, loginBean});
                            } else {
                                ToastUtil.i("已登录");
                            }
                        }
                    });
                }
            });
        }
    }

    private void k() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2100940430")) {
            ipChange.ipc$dispatch("-2100940430", new Object[]{this});
            return;
        }
        if (hw1.b()) {
            this.f.setTextColor(this.k);
            this.e.setTextColor(this.k);
            this.e.setText(this.i.getString(R$string.iconfont_duihaomian_));
            str = "Wi-Fi/4G";
        } else {
            this.f.setTextColor(this.l);
            this.e.setTextColor(this.m);
            this.e.setText(this.i.getString(R$string.iconfont_tixing24));
            str = "较差";
        }
        this.f.setText(str);
        this.e.setVisibility(0);
        this.d.setBackgroundColor(Color.parseColor("#ffffff"));
        this.d.setOnClickListener(null);
    }

    private void l(ProjectTickGuidePreBean projectTickGuidePreBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1109589087")) {
            ipChange.ipc$dispatch("1109589087", new Object[]{this, projectTickGuidePreBean});
        } else if (!gn2.b().g()) {
            this.d.setVisibility(4);
            this.d.setOnClickListener(null);
        } else {
            if (!ir1.i(mr1.CALENDAR)) {
                g("设置");
            } else if (qv1.d(this.i, projectTickGuidePreBean.calendarRemindTitle, projectTickGuidePreBean.sellStartTime)) {
                g("取消设置");
            } else {
                g("设置");
            }
            this.d.setOnClickListener(new View$OnClickListenerC2427c(projectTickGuidePreBean));
        }
    }

    public void d(ProjectTickGuidePreBean projectTickGuidePreBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-102520573")) {
            ipChange.ipc$dispatch("-102520573", new Object[]{this, projectTickGuidePreBean, Integer.valueOf(i)});
        } else if (projectTickGuidePreBean == null) {
        } else {
            this.a.setText(gn2.b().d(projectTickGuidePreBean.name));
            this.b.setText(projectTickGuidePreBean.title);
            this.c.setText(projectTickGuidePreBean.desc);
            int c = gn2.b().c(projectTickGuidePreBean.name);
            if (1 == c) {
                i(projectTickGuidePreBean.projectId);
            } else if (2 == c) {
                j(projectTickGuidePreBean.projectId);
            } else if (3 == c) {
                k();
            } else if (4 == c) {
                l(projectTickGuidePreBean);
            }
            f(i);
        }
    }
}
