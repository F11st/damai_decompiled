package cn.damai.commonbusiness.seatbiz.promotion.viewholder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.app.base.BaseActivity;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.discover.bean.GridBean;
import cn.damai.commonbusiness.seatbiz.promotion.OnCouponApplyClickListener;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponActivityBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.CouponSubActBean;
import cn.damai.commonbusiness.seatbiz.promotion.bean.UserProfitInfoBean;
import cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow;
import cn.damai.uikit.number.DMDigitTextView;
import com.alibaba.pictures.bricks.view.BricksThemeDialog;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.k23;
import tb.m91;
import tb.yw1;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ProjectProfitViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private OnCouponApplyClickListener a;
    private LinearLayout b;
    private DMDigitTextView c;
    private DMDigitTextView d;
    private TextView e;
    private TextView f;
    private TextView g;
    private LinearLayout h;
    private TextView i;
    private LinearLayout j;
    private TextView k;
    private TextView l;
    private View m;
    private LinearLayout n;
    private TextView o;
    private Context p;
    private ViewGroup q;
    private TextView r;
    private ViewGroup s;
    private TextView t;
    private ViewGroup u;
    boolean v;
    private String w;
    private String x;
    private BricksThemeDialog y;
    private StringBuilder z;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-525187687")) {
                ipChange.ipc$dispatch("-525187687", new Object[]{this, view});
                return;
            }
            cn.damai.common.user.c.e().x(yw1.f().h(ProjectProfitViewHolder.this.w, this.a));
            ProjectProfitViewHolder.this.k();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ CouponActivityBean a;
        final /* synthetic */ UserProfitInfoBean b;
        final /* synthetic */ int c;
        final /* synthetic */ boolean d;
        final /* synthetic */ CouponSubActBean e;

        b(CouponActivityBean couponActivityBean, UserProfitInfoBean userProfitInfoBean, int i, boolean z, CouponSubActBean couponSubActBean) {
            this.a = couponActivityBean;
            this.b = userProfitInfoBean;
            this.c = i;
            this.d = z;
            this.e = couponSubActBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1586102682")) {
                ipChange.ipc$dispatch("1586102682", new Object[]{this, view});
                return;
            }
            ProjectProfitViewHolder projectProfitViewHolder = ProjectProfitViewHolder.this;
            if (projectProfitViewHolder.v) {
                if (this.a.isMaxVipEnable()) {
                    ProjectProfitViewHolder.this.i(this.a, this.b, this.c);
                } else if (this.a.isNoauthIsVip()) {
                    cn.damai.common.user.c.e().x(yw1.f().i(ProjectProfitViewHolder.this.w, ProjectProfitViewHolder.this.x, String.valueOf(this.b.vipLevel), this.a.getProfitDrawStatus(), this.a.getProfitPoolId(), "1"));
                    ProjectProfitViewHolder.this.k();
                }
            } else if (this.a == null || !this.d) {
            } else {
                OnCouponApplyClickListener onCouponApplyClickListener = projectProfitViewHolder.a;
                CouponActivityBean couponActivityBean = this.a;
                onCouponApplyClickListener.onClick(couponActivityBean, this.c, couponActivityBean.getCouponActSpreadId(), this.e.getName(), this.e.getAppAsacCode());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c implements MemberAuthPopWindow.ICustomDialogEventListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow.ICustomDialogEventListener
        public void dialogItemEvent(String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1095159467")) {
                ipChange.ipc$dispatch("1095159467", new Object[]{this, str});
            } else if (!"success".equals(str) || ProjectProfitViewHolder.this.a == null) {
            } else {
                ProjectProfitViewHolder.this.a.refreshCouponRequest();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ CouponActivityBean b;

        d(String str, CouponActivityBean couponActivityBean) {
            this.a = str;
            this.b = couponActivityBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1513716124")) {
                ipChange.ipc$dispatch("1513716124", new Object[]{this, view});
            } else {
                cn.damai.common.user.c.e().x(yw1.f().j(ProjectProfitViewHolder.this.w, ProjectProfitViewHolder.this.x, this.a, this.b.getProfitPoolId()));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e(ProjectProfitViewHolder projectProfitViewHolder) {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1611619634")) {
                ipChange.ipc$dispatch("1611619634", new Object[]{this, dialogInterface, Integer.valueOf(i)});
            } else {
                dialogInterface.dismiss();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ CouponActivityBean b;
        final /* synthetic */ int c;

        f(String str, CouponActivityBean couponActivityBean, int i) {
            this.a = str;
            this.b = couponActivityBean;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1441329566")) {
                ipChange.ipc$dispatch("1441329566", new Object[]{this, view});
            } else if (ProjectProfitViewHolder.this.a != null) {
                cn.damai.common.user.c.e().x(yw1.f().k(ProjectProfitViewHolder.this.w, ProjectProfitViewHolder.this.x, this.a, this.b.getProfitPoolId()));
                ProjectProfitViewHolder.this.a.onIntegralConvertClick(this.c, this.b.getProfitPoolSpreadId(), this.b.getExchange4Dm(), this.b.getProfitAsac());
            }
        }
    }

    public ProjectProfitViewHolder(Context context, View view, OnCouponApplyClickListener onCouponApplyClickListener) {
        super(view);
        this.z = new StringBuilder();
        this.p = context;
        this.a = onCouponApplyClickListener;
        this.b = (LinearLayout) view.findViewById(R$id.ll_container);
        this.c = (DMDigitTextView) view.findViewById(R$id.tv_money);
        this.d = (DMDigitTextView) view.findViewById(R$id.tv_money_prefix);
        this.e = (TextView) view.findViewById(R$id.tv_money_desc);
        this.f = (TextView) view.findViewById(R$id.tv_title);
        this.g = (TextView) view.findViewById(R$id.tv_desc);
        this.h = (LinearLayout) view.findViewById(R$id.ll_integral_convert);
        this.i = (TextView) view.findViewById(R$id.btn_integral_convert);
        this.j = (LinearLayout) view.findViewById(R$id.ll_integral_value);
        this.k = (TextView) view.findViewById(R$id.btn_integral_value);
        this.l = (TextView) view.findViewById(R$id.btn_integral_des);
        this.m = view.findViewById(R$id.vip_tag);
        this.n = (LinearLayout) view.findViewById(R$id.ll_member_authorithize);
        this.o = (TextView) view.findViewById(R$id.tv_member_authorithize_desc);
        TextView textView = (TextView) view.findViewById(R$id.tv_member_authorithize_action);
        this.q = (ViewGroup) view.findViewById(R$id.container_one_plus_one);
        this.r = (TextView) view.findViewById(R$id.tv_coupon_single_name);
        this.s = (ViewGroup) view.findViewById(R$id.container_fixed_price);
        this.t = (TextView) view.findViewById(R$id.tv_fixed_price_money);
        this.u = (ViewGroup) view.findViewById(R$id.container_common_price);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CouponActivityBean couponActivityBean, UserProfitInfoBean userProfitInfoBean, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-539554467")) {
            ipChange.ipc$dispatch("-539554467", new Object[]{this, couponActivityBean, userProfitInfoBean, Integer.valueOf(i)});
        } else if (couponActivityBean == null || couponActivityBean.getSubCouponActExs() == null || couponActivityBean.getSubCouponActExs().size() == 0) {
        } else {
            String valueOf = String.valueOf(userProfitInfoBean.vipLevel);
            cn.damai.common.user.c.e().x(yw1.f().i(this.w, this.x, valueOf, couponActivityBean.getProfitDrawStatus(), couponActivityBean.getProfitPoolId(), "0"));
            int parseColor = Color.parseColor("#F38066");
            int color = ContextCompat.getColor(this.p, R$color.color_582331);
            boolean equals = valueOf.equals("10");
            if (equals) {
                parseColor = Color.parseColor("#210276");
                color = Color.parseColor("#DCE6FF");
            }
            StringBuilder sb = this.z;
            sb.delete(0, sb.length());
            this.z.append("本次兑换将消耗");
            int length = this.z.length();
            this.z.append(couponActivityBean.getProfitPoint());
            int length2 = this.z.length();
            StringBuilder sb2 = this.z;
            sb2.append("积分\n（当前有" + couponActivityBean.getProfitCurrentPoint() + "积分）");
            SpannableString spannableString = new SpannableString(this.z.toString());
            spannableString.setSpan(new ForegroundColorSpan(parseColor), length, length2, 18);
            SpannableString spannableString2 = null;
            if (!TextUtils.isEmpty(couponActivityBean.getDesc())) {
                spannableString2 = new SpannableString("使用规则\n" + couponActivityBean.getDesc());
                spannableString2.setSpan(new ForegroundColorSpan(Color.parseColor("#000000")), 0, 4, 18);
                spannableString2.setSpan(new AbsoluteSizeSpan(16, true), 0, 4, 18);
            }
            if (this.y == null) {
                this.y = new BricksThemeDialog(this.p);
            }
            if (this.y.isShowing()) {
                return;
            }
            if (equals) {
                SeniorVipAdditionalView seniorVipAdditionalView = new SeniorVipAdditionalView(this.p);
                seniorVipAdditionalView.setData(couponActivityBean.getProfitPointDiscount(), couponActivityBean.getReductionProfitPoint());
                this.y.o(R$drawable.score_icon).r(GridBean.TYPE_PIC_URL, 83).e(seniorVipAdditionalView).q(GridBean.TYPE_PIC_URL, 55).p(R$drawable.senior_vip_score_bg).l(GravityCompat.START).n("确认兑换此优惠券吗").m(spannableString).k(spannableString2).f(R$drawable.bg_senior_vip_exchange_dialog_cancel).g(R$drawable.sku_senior_vip_promotion_profit_bg);
            } else {
                this.y.o(R$drawable.score_icon).r(GridBean.TYPE_PIC_URL, 83).q(GridBean.TYPE_PIC_URL, 55).p(R$drawable.score_bg).l(GravityCompat.START).n("确认兑换此优惠券吗").m(spannableString).k(spannableString2).f(R$drawable.bg_vip_exchange_dialog_cancel).g(R$drawable.sku_promotion_profit_bg);
            }
            this.y.j("确认兑换", color, new f(valueOf, couponActivityBean, i)).h("放弃优惠", parseColor, new e(this)).i(true, new d(valueOf, couponActivityBean));
            Context context = this.p;
            if (context == null || !(context instanceof Activity) || ((BaseActivity) context).isActivityFinsihed()) {
                return;
            }
            this.y.show();
        }
    }

    private void j(CouponSubActBean couponSubActBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-227813878")) {
            ipChange.ipc$dispatch("-227813878", new Object[]{this, couponSubActBean});
            return;
        }
        String decreaseMoneyTag = couponSubActBean.getDecreaseMoneyTag();
        if (CouponSubActBean.SUB_BIZ_TYPE_MEMBER_COUPON_ORDER_BOGO.equals(couponSubActBean.subBizType)) {
            this.q.setVisibility(0);
            this.s.setVisibility(8);
            this.u.setVisibility(8);
            if (TextUtils.isEmpty(decreaseMoneyTag)) {
                this.r.setText("");
                return;
            }
            if (decreaseMoneyTag.startsWith("￥")) {
                decreaseMoneyTag = decreaseMoneyTag.substring(1);
            }
            this.r.setText(decreaseMoneyTag);
        } else if (CouponSubActBean.SUB_BIZ_TYPE_MEMBER_COUPON_ORDER_REDUCE_TO.equals(couponSubActBean.subBizType)) {
            this.q.setVisibility(8);
            this.s.setVisibility(0);
            this.u.setVisibility(8);
            if (TextUtils.isEmpty(decreaseMoneyTag)) {
                this.t.setText("");
                return;
            }
            if (decreaseMoneyTag.startsWith("￥")) {
                decreaseMoneyTag = decreaseMoneyTag.substring(1);
            }
            int length = decreaseMoneyTag.length();
            if (length > 5) {
                this.t.setTextSize(1, 16.0f);
            } else if (length > 4) {
                this.t.setTextSize(1, 19.0f);
            } else if (length > 3) {
                this.t.setTextSize(1, 22.0f);
            } else {
                this.t.setTextSize(1, 25.0f);
            }
            this.t.setText(decreaseMoneyTag);
        } else {
            this.q.setVisibility(8);
            this.s.setVisibility(8);
            this.u.setVisibility(0);
            if (TextUtils.isEmpty(decreaseMoneyTag)) {
                this.c.setText("");
                return;
            }
            if (decreaseMoneyTag.startsWith("￥")) {
                decreaseMoneyTag = decreaseMoneyTag.substring(1);
            }
            if (decreaseMoneyTag.length() > 5) {
                this.c.setTextSize(1, 22.0f);
            } else {
                this.c.setTextSize(1, 26.0f);
            }
            this.c.setText(decreaseMoneyTag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1750641347")) {
            ipChange.ipc$dispatch("1750641347", new Object[]{this});
            return;
        }
        Context context = this.p;
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        k23.g(context, (Activity) context, this.w, new c());
    }

    public void f(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-917328712")) {
            ipChange.ipc$dispatch("-917328712", new Object[]{this, Boolean.valueOf(z)});
        } else if (!z) {
            this.c.setTextColor(Color.parseColor("#FF4886"));
            DMDigitTextView dMDigitTextView = this.d;
            if (dMDigitTextView != null) {
                dMDigitTextView.setTextColor(Color.parseColor("#FF4886"));
            }
            this.e.setTextColor(Color.parseColor("#999999"));
            this.f.setTextColor(Color.parseColor("#2E333E"));
            this.g.setTextColor(Color.parseColor("#999999"));
        } else {
            this.c.setTextColor(Color.parseColor("#582331"));
            DMDigitTextView dMDigitTextView2 = this.d;
            if (dMDigitTextView2 != null) {
                dMDigitTextView2.setTextColor(Color.parseColor("#582331"));
            }
            this.e.setTextColor(Color.parseColor("#A67070"));
            this.f.setTextColor(Color.parseColor("#582331"));
            this.g.setTextColor(Color.parseColor("#999999"));
        }
    }

    public void g(CouponActivityBean couponActivityBean, UserProfitInfoBean userProfitInfoBean, String str, String str2, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "973462249")) {
            ipChange.ipc$dispatch("973462249", new Object[]{this, couponActivityBean, userProfitInfoBean, str, str2, Integer.valueOf(i)});
        } else if (couponActivityBean == null || m91.a(couponActivityBean.getSubCouponActExs()) || couponActivityBean.getSubCouponActExs().get(0) == null) {
        } else {
            CouponSubActBean couponSubActBean = couponActivityBean.getSubCouponActExs().get(0);
            j(couponSubActBean);
            if (!TextUtils.isEmpty(couponSubActBean.getTag())) {
                this.e.setVisibility(0);
                this.e.setText(couponSubActBean.getTag());
            } else {
                this.e.setVisibility(4);
            }
            this.f.setText(couponSubActBean.getName());
            String effectiveTimeText = couponSubActBean.getEffectiveTimeText();
            if (!TextUtils.isEmpty(effectiveTimeText)) {
                this.g.setVisibility(0);
                this.g.setText(effectiveTimeText);
            } else {
                this.g.setVisibility(4);
            }
            boolean isTaoMaxVip = couponActivityBean.isTaoMaxVip();
            this.v = isTaoMaxVip;
            this.x = str2;
            this.w = str;
            f(isTaoMaxVip);
            String isApplicable = couponActivityBean.isApplicable();
            boolean h = h(isApplicable);
            if (this.v) {
                this.m.setVisibility(0);
                this.j.setVisibility(0);
                this.b.setBackgroundResource(R$drawable.sku_profit_convert_bg);
                yw1.f().m(this.h, str, str2, userProfitInfoBean != null ? String.valueOf(userProfitInfoBean.vipLevel) : "0", couponActivityBean.getProfitDrawStatus(), couponActivityBean.getProfitPoolId(), i);
                if (TextUtils.isEmpty(couponActivityBean.getProfitPoint())) {
                    if (this.j.getVisibility() == 0) {
                        this.j.setVisibility(8);
                    }
                } else {
                    TextView textView = this.k;
                    textView.setText(couponActivityBean.getProfitPoint() + "积分");
                    if (this.j.getVisibility() == 8) {
                        this.j.setVisibility(0);
                    }
                }
                if (!TextUtils.isEmpty(couponActivityBean.getDiscountDesc())) {
                    this.l.setText(couponActivityBean.getDiscountDesc());
                    this.l.setVisibility(0);
                } else {
                    this.l.setVisibility(8);
                }
                this.i.setText(!TextUtils.isEmpty(couponActivityBean.getProfitDrawButtonText()) ? couponActivityBean.getProfitDrawButtonText() : "");
                if (!couponActivityBean.isMaxVipEnable() && !couponActivityBean.isNoauthIsVip()) {
                    this.i.setBackgroundResource(R$drawable.sku_promotion_profit_bg_has);
                    this.i.setTextColor(Color.parseColor("#4D582331"));
                } else {
                    this.i.setBackgroundResource(R$drawable.sku_promotion_profit_bg);
                    this.i.setTextColor(Color.parseColor("#582331"));
                }
                String str3 = couponActivityBean.isNoauthIsVip() ? "1" : "2";
                if (couponActivityBean.isMaxVipLastOne() && couponActivityBean.isNeedAuthorizeProfit() && !TextUtils.isEmpty(couponActivityBean.getAuthorizeProfitText())) {
                    this.o.setText(couponActivityBean.getAuthorizeProfitText());
                    this.n.setVisibility(0);
                    yw1.f().l(this.n, this.w, str3);
                    this.n.setOnClickListener(new a(str3));
                } else {
                    this.n.setVisibility(8);
                }
            } else {
                this.m.setVisibility(8);
                this.j.setVisibility(8);
                this.n.setVisibility(8);
                this.b.setBackgroundResource(R$drawable.sku_profit_coupon_bg);
                if (h) {
                    this.i.setText("领取");
                    this.i.setTextColor(Color.parseColor("#FF2869"));
                    this.i.setBackgroundResource(R$drawable.sku_promotion_coupon_bg);
                } else if ("false".equals(isApplicable)) {
                    this.i.setText("已领取");
                    this.i.setTextColor(Color.parseColor("#4DFF2869"));
                    this.i.setBackgroundResource(R$drawable.sku_promotion_coupon_has_bg);
                }
            }
            this.h.setOnClickListener(new b(couponActivityBean, userProfitInfoBean, i, h, couponSubActBean));
        }
    }

    public boolean h(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-893140541") ? ((Boolean) ipChange.ipc$dispatch("-893140541", new Object[]{this, str})).booleanValue() : "true".equals(str);
    }
}
