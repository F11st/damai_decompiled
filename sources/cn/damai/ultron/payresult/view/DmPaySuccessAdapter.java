package cn.damai.ultron.payresult.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.user.c;
import cn.damai.commonbusiness.banner.bean.PageBanner;
import cn.damai.commonbusiness.banner.bean.PayAdvertBean;
import cn.damai.commonbusiness.search.bean.BaccountInfo;
import cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow;
import cn.damai.tetris.component.brand.bean.BrandInfoBean;
import cn.damai.tetris.core.BaseLayer;
import cn.damai.tetris.core.BaseSection;
import cn.damai.uikit.iconfont.DMIconFontTextView;
import cn.damai.uikit.view.MarqueTextView;
import cn.damai.uikit.view.RoundImageView;
import cn.damai.ultron.R$color;
import cn.damai.ultron.R$drawable;
import cn.damai.ultron.R$id;
import cn.damai.ultron.R$layout;
import cn.damai.ultron.R$string;
import cn.damai.ultron.payresult.bean.DmPayButtonBean;
import cn.damai.ultron.payresult.bean.DmPaySuccessBean;
import cn.damai.ultron.payresult.bean.DmPaySuccessDataHolder;
import cn.damai.user.userprofile.FeedsViewModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.pictures.bricks.gaiaxholder.NativeGaiaXViewHolder;
import com.alibaba.pictures.bricks.orderresult.couponpayresult.viewholder.RecommendTitleViewHolder;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.DeviceInfoProviderProxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tb.k23;
import tb.kz1;
import tb.t60;
import tb.wh2;
import tb.xa0;
import tb.z20;
import tb.zx2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DmPaySuccessAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private List<DmPaySuccessDataHolder> a;
    private Context b;
    private zx2 c;
    public HashMap<String, String> d = null;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class BannerViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private ImageView b;
        private RelativeLayout c;
        private RoundImageView d;
        private ImageView e;
        private TextView f;
        private TextView g;
        private TextView h;
        private String i;

        /* compiled from: Taobao */
        /* loaded from: classes17.dex */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;

            a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1056155823")) {
                    ipChange.ipc$dispatch("-1056155823", new Object[]{this, view});
                    return;
                }
                cn.damai.common.user.c.e().x(xa0.h().k(BannerViewHolder.this.i));
                DMNav.from(DmPaySuccessAdapter.this.b).toUri(k23.j());
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes17.dex */
        public class b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ PayAdvertBean a;

            /* compiled from: Taobao */
            /* loaded from: classes9.dex */
            public class a implements MemberAuthPopWindow.ICustomDialogEventListener {
                private static transient /* synthetic */ IpChange $ipChange;
                final /* synthetic */ DmPayResultActivity a;

                a(b bVar, DmPayResultActivity dmPayResultActivity) {
                    this.a = dmPayResultActivity;
                }

                @Override // cn.damai.commonbusiness.yymember.view.MemberAuthPopWindow.ICustomDialogEventListener
                public void dialogItemEvent(String str) {
                    IpChange ipChange = $ipChange;
                    if (AndroidInstantRuntime.support(ipChange, "1990318567")) {
                        ipChange.ipc$dispatch("1990318567", new Object[]{this, str});
                        return;
                    }
                    DmPayResultActivity dmPayResultActivity = this.a;
                    if (dmPayResultActivity == null || dmPayResultActivity.isFinishing() || !"success".equals(str)) {
                        return;
                    }
                    this.a.onRefreshBanner();
                }
            }

            b(PayAdvertBean payAdvertBean) {
                this.a = payAdvertBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1055134546")) {
                    ipChange.ipc$dispatch("1055134546", new Object[]{this, view});
                    return;
                }
                cn.damai.common.user.c.e().x(xa0.h().k(BannerViewHolder.this.i));
                if (this.a.vipScore.memberThreshold) {
                    if (DmPaySuccessAdapter.this.b == null || !(DmPaySuccessAdapter.this.b instanceof DmPayResultActivity)) {
                        return;
                    }
                    DmPayResultActivity dmPayResultActivity = (DmPayResultActivity) DmPaySuccessAdapter.this.b;
                    k23.g(DmPaySuccessAdapter.this.b, dmPayResultActivity, xa0.DM_PAY_SUCCESS, new a(this, dmPayResultActivity));
                    return;
                }
                DMNav.from(DmPaySuccessAdapter.this.b).toUri(k23.j());
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes17.dex */
        public class c implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ String a;
            final /* synthetic */ String b;
            final /* synthetic */ PayAdvertBean c;

            c(String str, String str2, PayAdvertBean payAdvertBean) {
                this.a = str;
                this.b = str2;
                this.c = payAdvertBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1128542381")) {
                    ipChange.ipc$dispatch("-1128542381", new Object[]{this, view});
                    return;
                }
                cn.damai.common.user.c.e().x(xa0.h().l(this.a, this.b, String.valueOf(this.c.vipScore.memberFlag)));
                DMNav.from(DmPaySuccessAdapter.this.b).toUri(k23.j());
            }
        }

        /* compiled from: Taobao */
        /* loaded from: classes17.dex */
        public class d implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ String a;

            d(String str) {
                this.a = str;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "982747988")) {
                    ipChange.ipc$dispatch("982747988", new Object[]{this, view});
                    return;
                }
                String str = (String) view.getTag();
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                cn.damai.common.user.c.e().x(xa0.h().i(str, this.a));
                DMNav.from(BannerViewHolder.this.a).toUri(str);
            }
        }

        public BannerViewHolder(Context context) {
            super(LayoutInflater.from(context).inflate(R$layout.dm_pay_success_banner, (ViewGroup) null));
            this.i = "-1";
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.a = context;
            this.b = (ImageView) this.itemView.findViewById(R$id.iv_banner);
            int i = DisplayMetrics.getwidthPixels(t60.b(context));
            this.b.setLayoutParams(new LinearLayout.LayoutParams(i, (i * 95) / 375));
            RelativeLayout relativeLayout = (RelativeLayout) this.itemView.findViewById(R$id.payresult_score_info);
            this.c = relativeLayout;
            this.e = (ImageView) relativeLayout.findViewById(R$id.payresult_score_icon);
            this.f = (TextView) this.c.findViewById(R$id.tv_score_title);
            this.g = (TextView) this.c.findViewById(R$id.tv_score_sub_title);
            this.h = (TextView) this.c.findViewById(R$id.tv_score_btn);
            this.c.setVisibility(8);
            RoundImageView roundImageView = (RoundImageView) this.c.findViewById(R$id.iv_score);
            this.d = roundImageView;
            roundImageView.setType(1);
            this.d.setBorderRadius(12);
            this.d.setImageResource(R$drawable.score_bg);
        }

        private void d(int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1410840193")) {
                ipChange.ipc$dispatch("1410840193", new Object[]{this, Integer.valueOf(i)});
            } else if (i == 1) {
                this.d.setImageResource(R$drawable.dm_pay_success_banner_member_bg);
                this.h.setBackgroundResource(R$drawable.bg_score_btn_memner);
                this.h.setTextColor(Color.parseColor("#FFFFFF"));
                this.f.setTextColor(Color.parseColor("#582331"));
                this.g.setTextColor(Color.parseColor("#A67070"));
            } else if (i != 10) {
                this.d.setImageResource(R$drawable.dm_pay_success_banner_normal_bg);
                this.h.setBackgroundResource(R$drawable.bg_score_btn);
                this.h.setTextColor(Color.parseColor("#582331"));
                this.f.setTextColor(Color.parseColor("#582331"));
                this.g.setTextColor(Color.parseColor("#A67070"));
            } else {
                this.d.setImageResource(R$drawable.dm_pay_success_banner_black_diamond_bg);
                this.h.setBackgroundResource(R$drawable.bg_score_btn_black_diamond);
                this.h.setTextColor(Color.parseColor("#FFD0B5"));
                this.f.setTextColor(Color.parseColor("#2E333E"));
                this.g.setTextColor(Color.parseColor("#6277A7"));
            }
        }

        public void c(PayAdvertBean payAdvertBean, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-476761080")) {
                ipChange.ipc$dispatch("-476761080", new Object[]{this, payAdvertBean, str, str2});
            } else if (payAdvertBean == null) {
            } else {
                if (payAdvertBean.vipScore != null) {
                    this.c.setVisibility(0);
                    xa0.h().n(this.c, str, str2, String.valueOf(payAdvertBean.vipScore.memberFlag));
                    if (payAdvertBean.vipScore.isUnbind()) {
                        this.i = "3";
                        xa0.h().m(this.c, this.i);
                        this.f.setText(payAdvertBean.vipScore.primaryContent);
                        this.g.setText(payAdvertBean.vipScore.secondaryContent);
                        this.h.setText("升级会员");
                        this.e.setImageResource(R$drawable.score_upgrade_icon);
                        this.c.setOnClickListener(new a());
                    } else if (payAdvertBean.vipScore.isbindNotAuth()) {
                        if (payAdvertBean.vipScore.memberThreshold) {
                            this.i = "1";
                        } else {
                            this.i = "3";
                        }
                        xa0.h().m(this.c, this.i);
                        this.f.setText(payAdvertBean.vipScore.primaryContent);
                        this.g.setText(payAdvertBean.vipScore.secondaryContent);
                        this.h.setText("升级会员");
                        this.e.setImageResource(R$drawable.score_upgrade_icon);
                        this.c.setOnClickListener(new b(payAdvertBean));
                    } else if (!payAdvertBean.vipScore.isEmpty()) {
                        this.e.setImageResource(R$drawable.score_icon);
                        d(payAdvertBean.vipScore.memberFlag);
                        this.f.setText(Html.fromHtml("恭喜购票获得<font color= '#FF1268'>" + payAdvertBean.vipScore.oriScore + "</font>会员积分"));
                        if (payAdvertBean.isVipMember()) {
                            this.g.setText("积分可免费兑换代金券哦~");
                            this.h.setText("去兑换");
                        } else {
                            this.g.setText("升级会员可免费兑换代金券哦~");
                            this.h.setText("去看看");
                        }
                        this.c.setOnClickListener(new c(str, str2, payAdvertBean));
                    } else {
                        this.c.setVisibility(8);
                    }
                } else {
                    this.c.setVisibility(8);
                }
                PageBanner pageBanner = payAdvertBean.advertisement;
                if (pageBanner != null && !TextUtils.isEmpty(pageBanner.picUrl) && !TextUtils.isEmpty(pageBanner.schema)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("titlelabel", pageBanner.schema);
                    hashMap.put("item_id", str2);
                    hashMap.put("city", z20.d());
                    hashMap.put(FeedsViewModel.ARG_USERID, z20.i());
                    hashMap.put("usercode", z20.E());
                    cn.damai.common.user.c.e().G(this.b, "bannerimg", "banners", xa0.DM_PAY_SUCCESS, hashMap);
                    this.b.setVisibility(0);
                    DMImageCreator c2 = cn.damai.common.image.a.b().c(pageBanner.picUrl);
                    int i = R$drawable.uikit_default_image_bg_gradient;
                    c2.i(i).c(i).g(this.b);
                    this.b.setTag(pageBanner.schema);
                    this.b.setOnClickListener(new d(str2));
                    return;
                }
                this.b.setVisibility(8);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class PayStateViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private Context a;
        private MarqueTextView b;
        private DMIconFontTextView c;
        private TextView d;
        private TextView e;
        private TextView f;
        private TextView g;
        private TextView h;
        private String i;
        private String j;

        /* compiled from: Taobao */
        /* loaded from: classes17.dex */
        public class a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ String a;
            final /* synthetic */ String b;

            a(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-1741861330")) {
                    ipChange.ipc$dispatch("-1741861330", new Object[]{this, view});
                    return;
                }
                c.e().x(xa0.h().j(PayStateViewHolder.this.j, PayStateViewHolder.this.i, this.a));
                String str = this.b;
                if (str != null && str.contains("HNOrderDetailPage")) {
                    str = this.b + "&HNCreateOrderPage=true";
                }
                DMNav.from(PayStateViewHolder.this.a).toUri(str);
                ((Activity) PayStateViewHolder.this.a).finish();
            }
        }

        public PayStateViewHolder(DmPaySuccessAdapter dmPaySuccessAdapter, Context context) {
            super(LayoutInflater.from(context).inflate(R$layout.dm_pay_success_info, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            this.a = context;
            e(this.itemView);
        }

        private void e(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1270974135")) {
                ipChange.ipc$dispatch("1270974135", new Object[]{this, view});
                return;
            }
            this.b = (MarqueTextView) view.findViewById(R$id.tv_tip);
            this.c = (DMIconFontTextView) view.findViewById(R$id.icon_pay_result);
            this.d = (TextView) view.findViewById(R$id.tv_pay_result);
            this.e = (TextView) view.findViewById(R$id.tv_order_money);
            this.f = (TextView) view.findViewById(R$id.tv_delivery_tip);
            this.g = (TextView) view.findViewById(R$id.tv_left);
            this.h = (TextView) view.findViewById(R$id.tv_right);
        }

        public void d(DmPaySuccessBean dmPaySuccessBean) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1925361003")) {
                ipChange.ipc$dispatch("-1925361003", new Object[]{this, dmPaySuccessBean});
            } else if (dmPaySuccessBean != null) {
                this.i = dmPaySuccessBean.orderId;
                this.j = dmPaySuccessBean.projectId;
                if (TextUtils.isEmpty(dmPaySuccessBean.reservedDesc)) {
                    this.b.setVisibility(8);
                } else {
                    this.b.setText(dmPaySuccessBean.reservedDesc);
                    this.b.setVisibility(0);
                }
                this.d.setText(dmPaySuccessBean.resultDesc);
                if (dmPaySuccessBean.isPayState()) {
                    this.c.setText(this.a.getString(R$string.iconfont_Successfulpayment));
                    this.c.setTextColor(ContextCompat.getColor(this.a, R$color.pay_state_success));
                    this.d.setTextColor(ContextCompat.getColor(this.a, R$color.pay_state_fail));
                } else {
                    this.c.setText(this.a.getString(R$string.iconfont_Inprocessing));
                    DMIconFontTextView dMIconFontTextView = this.c;
                    Context context = this.a;
                    int i = R$color.color_ffaa00;
                    dMIconFontTextView.setTextColor(ContextCompat.getColor(context, i));
                    this.d.setTextColor(ContextCompat.getColor(this.a, i));
                }
                this.e.setVisibility(TextUtils.isEmpty(dmPaySuccessBean.paymentInfo) ? 8 : 0);
                TextView textView = this.e;
                String str = dmPaySuccessBean.paymentInfo;
                if (str == null) {
                    str = "";
                }
                textView.setText(str);
                this.f.setVisibility(TextUtils.isEmpty(dmPaySuccessBean.tip) ? 8 : 0);
                TextView textView2 = this.f;
                String str2 = dmPaySuccessBean.tip;
                textView2.setText(str2 != null ? str2 : "");
                this.g.setVisibility(8);
                this.h.setVisibility(8);
                int e = wh2.e(dmPaySuccessBean.buttons);
                if (e == 1) {
                    DmPayButtonBean dmPayButtonBean = dmPaySuccessBean.buttons.get(0);
                    if (dmPayButtonBean != null) {
                        this.g.setVisibility(0);
                        this.h.setVisibility(8);
                        this.g.setText(dmPayButtonBean.buttonText);
                        h(this.g, dmPayButtonBean.nativeUrl, dmPayButtonBean.buttonText);
                        g(this.g, dmPayButtonBean.nativeUrl);
                        return;
                    }
                    return;
                }
                int i2 = e <= 1 ? e : 2;
                for (int i3 = 0; i3 < i2; i3++) {
                    DmPayButtonBean dmPayButtonBean2 = dmPaySuccessBean.buttons.get(i3);
                    if (dmPayButtonBean2 != null) {
                        if (i3 == 0) {
                            this.g.setVisibility(0);
                            this.g.setText(dmPayButtonBean2.buttonText);
                            h(this.g, dmPayButtonBean2.nativeUrl, dmPayButtonBean2.buttonText);
                            g(this.g, dmPayButtonBean2.nativeUrl);
                        } else {
                            this.h.setVisibility(0);
                            this.h.setText(dmPayButtonBean2.buttonText);
                            h(this.h, dmPayButtonBean2.nativeUrl, dmPayButtonBean2.buttonText);
                            g(this.h, dmPayButtonBean2.nativeUrl);
                        }
                    }
                }
            }
        }

        public boolean f(String str) {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-234796328") ? ((Boolean) ipChange.ipc$dispatch("-234796328", new Object[]{this, str})).booleanValue() : !TextUtils.isEmpty(str) && str.contains("HomePage");
        }

        public void g(TextView textView, String str) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-478690019")) {
                ipChange.ipc$dispatch("-478690019", new Object[]{this, textView, str});
            } else if (textView == null) {
            } else {
                if (f(str)) {
                    textView.setBackgroundResource(R$drawable.bg_pay_success_home);
                    textView.setTextColor(ContextCompat.getColor(this.a, R$color.color_FF2D79));
                    return;
                }
                textView.setBackgroundResource(R$drawable.bg_pay_success_detail);
                textView.setTextColor(ContextCompat.getColor(this.a, R$color.white));
            }
        }

        public void h(View view, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-446991664")) {
                ipChange.ipc$dispatch("-446991664", new Object[]{this, view, str, str2});
            } else if (view == null || str == null) {
            } else {
                view.setOnClickListener(new a(str2, str));
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class a extends kz1 {
        private static transient /* synthetic */ IpChange $ipChange;

        a(Context context) {
            super(context);
        }

        @Override // tb.kz1, tb.xi1
        public void f(@NonNull View view, @NonNull JSONObject jSONObject, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-2031600045")) {
                ipChange.ipc$dispatch("-2031600045", new Object[]{this, view, jSONObject, Integer.valueOf(i)});
                return;
            }
            super.f(view, jSONObject, i);
            c e = c.e();
            e.G(view, "item_" + i, "otherperform", xa0.DM_PAY_SUCCESS, DmPaySuccessAdapter.this.d);
        }
    }

    public DmPaySuccessAdapter(Context context, List<DmPaySuccessDataHolder> list) {
        this.a = list;
        this.b = context;
    }

    private ArrayList<BaseLayer> c(DmPaySuccessDataHolder dmPaySuccessDataHolder) {
        BaccountInfo baccountInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-310700899")) {
            return (ArrayList) ipChange.ipc$dispatch("-310700899", new Object[]{this, dmPaySuccessDataHolder});
        }
        ArrayList<BaseLayer> arrayList = new ArrayList<>();
        BaseLayer baseLayer = new BaseLayer();
        ArrayList arrayList2 = new ArrayList();
        BaseSection baseSection = new BaseSection();
        baseSection.setComponentId("dm_card_ip_brand");
        JSONObject jSONObject = new JSONObject();
        if (dmPaySuccessDataHolder != null && dmPaySuccessDataHolder.mAdvertBean.baccount != null) {
            BrandInfoBean brandInfoBean = new BrandInfoBean();
            BaccountInfo baccountInfo2 = dmPaySuccessDataHolder.mAdvertBean.baccount;
            brandInfoBean.id = baccountInfo2.id;
            brandInfoBean.name = baccountInfo2.name;
            brandInfoBean.subTitle = baccountInfo2.subTitle;
            brandInfoBean.followStatus = baccountInfo2.followStatus;
            brandInfoBean.pic = baccountInfo2.headPic;
            brandInfoBean.backgroundPic = baccountInfo2.backgroundPic;
            brandInfoBean.activityDO = baccountInfo2.activityDO;
            jSONObject.put("brand", (Object) brandInfoBean);
            JSON.parseObject(JSON.toJSONString(jSONObject));
            baseSection.setItem(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("brandId", (Object) dmPaySuccessDataHolder.mAdvertBean.baccount.id);
            jSONObject2.put("orderid", (Object) dmPaySuccessDataHolder.mOrderId);
            PayAdvertBean payAdvertBean = dmPaySuccessDataHolder.mAdvertBean;
            if (payAdvertBean != null && (baccountInfo = payAdvertBean.baccount) != null && !TextUtils.isEmpty(baccountInfo.followStatus)) {
                jSONObject2.put("status", (Object) dmPaySuccessDataHolder.mAdvertBean.baccount.followStatus);
            }
            baseSection.setTrackInfoBeta(jSONObject2);
            baseSection.getTrackInfo().trackB = xa0.DM_PAY_SUCCESS;
            baseSection.getTrackInfo().trackC = "brand";
            arrayList2.add(baseSection);
            baseLayer.setSections(arrayList2);
            arrayList.add(baseLayer);
        }
        return arrayList;
    }

    public void b(zx2 zx2Var) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "884751780")) {
            ipChange.ipc$dispatch("884751780", new Object[]{this, zx2Var});
        } else {
            this.c = zx2Var;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "607643853") ? ((Integer) ipChange.ipc$dispatch("607643853", new Object[]{this})).intValue() : wh2.e(this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1131001076") ? ((Integer) ipChange.ipc$dispatch("1131001076", new Object[]{this, Integer.valueOf(i)})).intValue() : this.a.get(i).type;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "917346316")) {
            ipChange.ipc$dispatch("917346316", new Object[]{this, viewHolder, Integer.valueOf(i)});
            return;
        }
        DmPaySuccessDataHolder dmPaySuccessDataHolder = this.a.get(i);
        if (dmPaySuccessDataHolder == null) {
            return;
        }
        int i2 = dmPaySuccessDataHolder.type;
        if (i2 == 0) {
            ((PayStateViewHolder) viewHolder).d(dmPaySuccessDataHolder.mPayResponse);
        } else if (i2 != 1) {
            if (i2 != 3) {
                return;
            }
            ((NativeGaiaXViewHolder) viewHolder).d("damai", kz1.TEMPLATE_ID, "4", DeviceInfoProviderProxy.getWindowWidth(), i, dmPaySuccessDataHolder.recommendMo);
        } else if (dmPaySuccessDataHolder.mAdvertBean != null) {
            LinearLayout c = this.c.c(c(dmPaySuccessDataHolder), (ViewGroup) viewHolder.itemView);
            ViewGroup viewGroup = (ViewGroup) viewHolder.itemView.findViewById(R$id.payresult_brand_area);
            viewGroup.removeAllViews();
            viewGroup.addView(c);
            View findViewById = viewGroup.findViewById(cn.damai.commonbusiness.R$id.ip_brand_title);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            ((BannerViewHolder) viewHolder).c(dmPaySuccessDataHolder.mAdvertBean, dmPaySuccessDataHolder.mOrderId, dmPaySuccessDataHolder.mProjectId);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1724074346")) {
            return (RecyclerView.ViewHolder) ipChange.ipc$dispatch("1724074346", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return new NativeGaiaXViewHolder(viewGroup.getContext(), new a(viewGroup.getContext()));
                }
                return new RecommendTitleViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_coupon_order_result_recommend_title, viewGroup, false));
            }
            return new BannerViewHolder(viewGroup.getContext());
        }
        return new PayStateViewHolder(this, viewGroup.getContext());
    }
}
