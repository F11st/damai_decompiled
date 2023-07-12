package tb;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import cn.damai.common.nav.DMNav;
import cn.damai.common.util.ToastUtil;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.BusinessInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.CalculatePriceControlBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.NcovSkuBottomInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.Tag;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.TipBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.WishHeatBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view.PromotionTagView;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.view.SeeAnimateView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dago.widgetlib.ailproom.adapter.chatinput.expression.VerticalImageSpan;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class hj1 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static boolean B;
    private WishHeatBean A;
    private View a;
    private View b;
    private TextView c;
    private FlowLayout d;
    @Deprecated
    private TextView e;
    private TextView f;
    private View g;
    private TextView h;
    private ij1 i;
    private View j;
    private TextView k;
    private ImageView l;
    private TextView m;
    private TextView n;
    private ImageView o;
    private View p;
    private View q;
    private View r;
    private Context s;
    private PerformBean t;
    private BusinessInfo u;
    private PriceBean v;
    private CalculatePriceControlBean w;
    private long x;
    private NcovSkuBottomInfo y;
    private int z = 1;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1397107199")) {
                ipChange.ipc$dispatch("-1397107199", new Object[]{this, view});
            } else {
                hj1.this.x();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "714183170")) {
                ipChange.ipc$dispatch("714183170", new Object[]{this, view});
                return;
            }
            int i = R$id.tag_sku_seat_image_uri;
            String str = view.getTag(i) != null ? (String) view.getTag(i) : "";
            int i2 = R$id.tag_sku_seat_image_title;
            hj1.this.n(str, view.getTag(i2) != null ? (String) view.getTag(i2) : "");
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1469493757")) {
                ipChange.ipc$dispatch("-1469493757", new Object[]{this, view});
            } else {
                hj1.this.s(2);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "641796612")) {
                ipChange.ipc$dispatch("641796612", new Object[]{this, view});
            } else {
                hj1.this.s(1);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class e implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1541880315")) {
                ipChange.ipc$dispatch("-1541880315", new Object[]{this, view});
            } else {
                hj1.this.t((PriceBean) view.getTag());
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class f implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ PriceBean a;

        f(hj1 hj1Var, PriceBean priceBean) {
            this.a = priceBean;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "569410054")) {
                ipChange.ipc$dispatch("569410054", new Object[]{this, view});
            } else {
                ToastUtil.f(this.a.toastTips);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class g implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ PromotionTagView b;

        g(View view, PromotionTagView promotionTagView) {
            this.a = view;
            this.b = promotionTagView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1983071722")) {
                ipChange.ipc$dispatch("1983071722", new Object[]{this});
                return;
            }
            TextView textView = (TextView) this.a.findViewById(R$id.item_text);
            DisplayMetrics displayMetrics = hj1.this.s.getResources().getDisplayMetrics();
            int width = this.a.getWidth();
            if (textView.getLineCount() > 1) {
                this.a.setMinimumWidth((com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) - t60.a(hj1.this.s, 33.0f)) - 1);
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), t60.a(hj1.this.s, 16.0f) + this.b.getCurrentView().getWidth(), textView.getPaddingBottom());
            } else {
                textView.setMaxWidth((width - t60.a(hj1.this.s, 16.0f)) - this.b.getCurrentView().getWidth());
            }
            this.b.getCurrentView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class h implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "497023496")) {
                ipChange.ipc$dispatch("497023496", new Object[]{this, view});
                return;
            }
            hj1.B = true;
            DMNav.from(hj1.this.s).toUri(hj1.this.u.serviceFeeAgreementURL);
        }
    }

    public hj1(Fragment fragment, View view, View view2, long j, NcovSkuBottomInfo ncovSkuBottomInfo) {
        this.a = view;
        this.b = view2;
        this.y = ncovSkuBottomInfo;
        this.x = j;
        this.s = view.getContext();
        m();
    }

    private void C(List<PriceBean> list) {
        PerformBean performBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-956566632")) {
            ipChange.ipc$dispatch("-956566632", new Object[]{this, list});
            return;
        }
        if (this.d.getChildCount() > 0) {
            this.d.removeAllViews();
        }
        this.j.setVisibility(8);
        this.g.setVisibility(8);
        this.z = 1;
        if (m91.a(list)) {
            return;
        }
        this.v = null;
        this.a.setVisibility(0);
        DisplayMetrics displayMetrics = this.s.getResources().getDisplayMetrics();
        for (int i = 0; i < list.size(); i++) {
            PriceBean priceBean = list.get(i);
            if (priceBean != null) {
                priceBean.index = i;
                View inflate = LayoutInflater.from(this.s).inflate(R$layout.sku_ncov_itembox_text, (ViewGroup) null);
                inflate.setMinimumWidth(((com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) - t60.a(this.s, 33.0f)) - 1) / 3);
                TextView textView = (TextView) inflate.findViewById(R$id.item_text);
                textView.setText(priceBean.priceName);
                PromotionTagView promotionTagView = (PromotionTagView) inflate.findViewById(R$id.layout_tag_righttop);
                TextView textView2 = (TextView) inflate.findViewById(R$id.tv_subtitle);
                Tag tag = priceBean.promotionTag;
                if (tag != null && !TextUtils.isEmpty(tag.subTagDesc)) {
                    textView2.setVisibility(0);
                    textView2.setText(priceBean.promotionTag.subTagDesc);
                } else {
                    textView2.setVisibility(8);
                }
                c(inflate, priceBean, promotionTagView);
                p(inflate);
                if (priceBean.clickable) {
                    textView.setTextColor(ContextCompat.getColor(this.s, R$color.color_666666));
                    textView2.setTextColor(ContextCompat.getColor(this.s, R$color.color_9c9ca5));
                    if (list.size() == 1 && (performBean = this.t) != null && performBean.chooseSeatType != 1) {
                        this.v = priceBean;
                    }
                } else {
                    Context context = this.s;
                    int i2 = R$color.color_cccccc;
                    textView.setTextColor(ContextCompat.getColor(context, i2));
                    textView2.setTextColor(ContextCompat.getColor(this.s, i2));
                }
                if (priceBean.clickable) {
                    inflate.setOnClickListener(new e());
                } else if (!TextUtils.isEmpty(priceBean.toastTips)) {
                    inflate.setOnClickListener(new f(this, priceBean));
                }
                inflate.setTag(priceBean);
                this.d.addView(inflate);
            }
        }
        r();
    }

    private void D(WishHeatBean wishHeatBean) {
        PriceBean priceBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1701546848")) {
            ipChange.ipc$dispatch("1701546848", new Object[]{this, wishHeatBean});
        } else if (wishHeatBean != null && !m91.a(wishHeatBean.prices) && (priceBean = this.v) != null) {
            this.i.e(wishHeatBean.prices, priceBean.priceId);
        } else {
            this.i.c(8);
        }
    }

    private void c(View view, PriceBean priceBean, PromotionTagView promotionTagView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "62220450")) {
            ipChange.ipc$dispatch("62220450", new Object[]{this, view, priceBean, promotionTagView});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.layout_tag);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.layout_tag_promotion);
        linearLayout2.removeAllViews();
        linearLayout.removeAllViews();
        promotionTagView.setVisibility(8);
        Tag tag = priceBean.otherTag;
        if (tag != null && !TextUtils.isEmpty(tag.tagDesc)) {
            View inflate = LayoutInflater.from(this.s).inflate(R$layout.sku_ncov_tag, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R$id.tv_tag);
            textView.setText(priceBean.otherTag.tagDesc);
            if (!priceBean.otherTag.isPositive()) {
                textView.setTextColor(this.s.getResources().getColor(R$color.color_6A7A99));
                textView.setBackgroundResource(R$drawable.ncov_sku_tag_normal_bg);
            } else {
                textView.setTextColor(this.s.getResources().getColor(R$color.color_FF2869));
            }
            linearLayout.addView(inflate);
        }
        promotionTagView.setTag(priceBean.promotionTag);
        Tag tag2 = priceBean.promotionTag;
        if (tag2 != null && !TextUtils.isEmpty(tag2.tagDesc)) {
            TextView textView2 = new TextView(k().getContext());
            textView2.setSingleLine();
            textView2.setText(priceBean.promotionTag.tagDesc);
            textView2.setPadding(t60.a(this.s, 2.0f), 0, 0, t60.a(this.s, 2.0f));
            textView2.setTextSize(1, 10.0f);
            textView2.setVisibility(4);
            if (PromotionTagView.HALF_PRICE.equals(priceBean.promotionTag.tag)) {
                textView2.setWidth(t60.a(this.s, 40.0f));
            } else if (PromotionTagView.VIP_BUY.equals(priceBean.promotionTag.tag)) {
                textView2.setWidth(t60.a(this.s, 75.0f));
            } else {
                textView2.setPadding(t60.a(this.s, 2.0f), 0, 0, 0);
            }
            linearLayout2.addView(textView2);
        }
        promotionTagView.getCurrentView().getViewTreeObserver().addOnGlobalLayoutListener(new g(view, promotionTagView));
    }

    private boolean f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1477850273")) {
            return ((Boolean) ipChange.ipc$dispatch("-1477850273", new Object[]{this})).booleanValue();
        }
        if (this.v.mq == 0) {
            this.z = 0;
            cn.damai.common.util.toastutil.a.i(this.s, "余票不足");
            u(this.z, false);
            this.y.isCanClickable = false;
            z();
            return true;
        }
        return false;
    }

    private int h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1249684280")) {
            return ((Integer) ipChange.ipc$dispatch("-1249684280", new Object[]{this})).intValue();
        }
        PriceBean priceBean = this.v;
        if (priceBean == null) {
            return 1;
        }
        int i = priceBean.mq;
        return priceBean.packagesFlag ? i * priceBean.auctionUnit : i;
    }

    private int j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1792700927")) {
            return ((Integer) ipChange.ipc$dispatch("1792700927", new Object[]{this})).intValue();
        }
        PriceBean priceBean = this.v;
        if (priceBean == null) {
            return 1;
        }
        return priceBean.mq;
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1225637857")) {
            ipChange.ipc$dispatch("-1225637857", new Object[]{this});
            return;
        }
        PriceBean priceBean = this.v;
        if (priceBean == null) {
            return;
        }
        if (!TextUtils.isEmpty(priceBean.mktPromotionTips)) {
            this.y.discountTip = this.v.mktPromotionTips;
        } else {
            this.y.discountTip = null;
        }
    }

    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1681274482")) {
            ipChange.ipc$dispatch("-1681274482", new Object[]{this});
            return;
        }
        this.c = (TextView) this.a.findViewById(R$id.tv_price_name);
        View findViewById = this.a.findViewById(R$id.tv_promotion_text);
        this.q = findViewById;
        findViewById.setOnClickListener(new a());
        this.r = this.a.findViewById(R$id.tv_promotion_text_line);
        View findViewById2 = this.a.findViewById(R$id.tv_seat_text);
        this.p = findViewById2;
        findViewById2.setOnClickListener(new b());
        this.d = (FlowLayout) this.a.findViewById(R$id.project_detail_perform_price_flowlayout);
        this.e = (TextView) this.a.findViewById(R$id.tv_preferential_tip);
        this.f = (TextView) this.a.findViewById(R$id.tv_kssj_tip);
        this.g = this.a.findViewById(R$id.layout_register);
        this.h = (TextView) this.a.findViewById(R$id.tv_register_tip);
        this.i = new ij1(this.a.findViewById(R$id.layout_see_heat));
        this.j = this.b.findViewById(R$id.layout_num);
        this.k = (TextView) this.b.findViewById(R$id.tv_limit_num);
        ImageView imageView = (ImageView) this.b.findViewById(R$id.img_jian);
        this.l = imageView;
        imageView.setEnabled(false);
        this.m = (TextView) this.b.findViewById(R$id.tv_num);
        this.n = (TextView) this.b.findViewById(R$id.tv_num_detail);
        this.o = (ImageView) this.b.findViewById(R$id.img_jia);
        this.l.setOnClickListener(new c());
        this.o.setOnClickListener(new d());
    }

    private void p(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-865759944")) {
            ipChange.ipc$dispatch("-865759944", new Object[]{this, view});
        } else if (this.y.pageType == 1) {
        } else {
            view.findViewById(R$id.layout_xin).setVisibility(0);
            ((SeeAnimateView) view.findViewById(R$id.image_xin)).setCancelImage();
            this.c.setText("想看哪个票档");
            this.c.setTextSize(1, 16.0f);
        }
    }

    private void q() {
        NcovSkuBottomInfo ncovSkuBottomInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-147497753")) {
            ipChange.ipc$dispatch("-147497753", new Object[]{this});
        } else if (this.v != null && this.d.getChildCount() != 0 && (ncovSkuBottomInfo = this.y) != null && ncovSkuBottomInfo.pageType != 1) {
            int childCount = this.d.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = this.d.getChildAt(i);
                LinearLayout linearLayout = (LinearLayout) childAt.findViewById(R$id.ll_perform_item);
                TextView textView = (TextView) childAt.findViewById(R$id.item_text);
                SeeAnimateView seeAnimateView = (SeeAnimateView) childAt.findViewById(R$id.image_xin);
                PriceBean priceBean = (PriceBean) childAt.getTag();
                if (priceBean != null) {
                    if (priceBean.priceId == this.v.priceId) {
                        linearLayout.setBackgroundResource(R$drawable.ncov_sku_perform_select_see_bg);
                        textView.setTextColor(ContextCompat.getColor(this.s, R$color.color_FF2869));
                        seeAnimateView.clickAnimate();
                    } else {
                        seeAnimateView.setCancelImage();
                    }
                }
            }
        }
    }

    private void r() {
        NcovSkuBottomInfo ncovSkuBottomInfo;
        TipBean tipBean;
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1016127253")) {
            ipChange.ipc$dispatch("-1016127253", new Object[]{this});
        } else if (this.v != null && this.d.getChildCount() != 0 && (ncovSkuBottomInfo = this.y) != null) {
            PriceBean priceBean = this.v;
            ncovSkuBottomInfo.followRelationTargetType = priceBean.followRelationTargetType;
            o(priceBean);
            this.z = 1;
            d();
            this.j.setVisibility(8);
            this.e.setVisibility(8);
            this.f.setVisibility(8);
            this.g.setVisibility(8);
            int childCount = this.d.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = this.d.getChildAt(i2);
                PriceBean priceBean2 = (PriceBean) childAt.getTag();
                LinearLayout linearLayout = (LinearLayout) childAt.findViewById(R$id.ll_perform_item);
                TextView textView = (TextView) childAt.findViewById(R$id.item_text);
                TextView textView2 = (TextView) childAt.findViewById(R$id.tv_subtitle);
                if (this.v.priceId == priceBean2.priceId) {
                    linearLayout.setBackgroundResource(R$drawable.ncov_sku_perform_select_bg);
                    Context context = this.s;
                    int i3 = R$color.color_000000;
                    textView.setTextColor(ContextCompat.getColor(context, i3));
                    textView2.setTextColor(ContextCompat.getColor(this.s, i3));
                } else {
                    if (priceBean2.clickable) {
                        textView.setTextColor(ContextCompat.getColor(this.s, R$color.color_666666));
                        textView2.setTextColor(ContextCompat.getColor(this.s, R$color.color_9c9ca5));
                    } else {
                        Context context2 = this.s;
                        int i4 = R$color.color_cccccc;
                        textView.setTextColor(ContextCompat.getColor(context2, i4));
                        textView2.setTextColor(ContextCompat.getColor(this.s, i4));
                    }
                    linearLayout.setBackgroundResource(R$drawable.ncov_sku_perform_bg);
                }
            }
            l();
            NcovSkuBottomInfo ncovSkuBottomInfo2 = this.y;
            int i5 = ncovSkuBottomInfo2.pageType;
            if (i5 == 1) {
                PriceBean priceBean3 = this.v;
                int i6 = priceBean3.frontEndStatus;
                if (i6 == 1) {
                    PerformBean performBean = this.t;
                    if (performBean != null) {
                        if (performBean.chooseSeatType == 1) {
                            ncovSkuBottomInfo2.buyStatus = 4;
                            ncovSkuBottomInfo2.isCanClickable = true;
                        } else {
                            String str = "每笔订单限购" + g() + "张";
                            if (this.t.skuList.size() <= 0 || TextUtils.isEmpty(this.t.skuList.get(0).sfpt)) {
                                i = 0;
                            } else {
                                str = str.concat("，每张服务费" + this.t.skuList.get(0).sfpt + "元 ");
                                i = str.length();
                            }
                            if (!TextUtils.isEmpty(this.t.performDesc)) {
                                str = str.concat("，" + this.t.performDesc);
                            }
                            if (i > 0) {
                                SpannableString spannableString = new SpannableString(str);
                                Drawable drawable = ResourcesCompat.getDrawable(this.s.getResources(), R$drawable.commonbusiness_help_icon, null);
                                if (drawable != null) {
                                    int a2 = t60.a(this.s, 14.0f);
                                    int a3 = t60.a(this.s, 0.5f);
                                    int a4 = t60.a(this.s, 1.5f);
                                    drawable.setBounds(a4, a3, a2 + a4, a2 + a3);
                                    drawable.setTint(Color.parseColor("#9C9CA5"));
                                    spannableString.setSpan(new VerticalImageSpan(drawable), i - 1, i, 33);
                                }
                                this.k.setText(spannableString);
                                this.k.setOnClickListener(new h());
                            } else {
                                this.k.setText(str);
                            }
                            this.y.buyStatus = 1;
                            if (f()) {
                                return;
                            }
                            u(this.z, false);
                            NcovSkuBottomInfo ncovSkuBottomInfo3 = this.y;
                            double d2 = this.v.price;
                            int i7 = this.z;
                            ncovSkuBottomInfo3.allPrice = d2 * i7;
                            ncovSkuBottomInfo3.promotionAmount = 0.0d;
                            CalculatePriceControlBean calculatePriceControlBean = this.w;
                            if (calculatePriceControlBean != null && calculatePriceControlBean.needCalc && i7 > 0) {
                                e(i7);
                            } else {
                                ncovSkuBottomInfo3.isCanClickable = true;
                            }
                        }
                    }
                } else if (i6 == 2 || i6 == 3) {
                    ncovSkuBottomInfo2.isCanClickable = true;
                    ncovSkuBottomInfo2.buyStatus = i6;
                    TipBean tipBean2 = priceBean3.tips;
                    if (tipBean2 != null) {
                        if (i6 == 2) {
                            if (!TextUtils.isEmpty(tipBean2.tagTip)) {
                                this.g.setVisibility(0);
                                this.h.setText(this.v.tips.tagTip);
                            }
                        } else if (i6 == 3) {
                            if (!TextUtils.isEmpty(tipBean2.saleTime)) {
                                this.f.setVisibility(0);
                                this.f.setText(this.v.tips.saleTime);
                            }
                            if (!TextUtils.isEmpty(this.v.tips.tagTip)) {
                                this.g.setVisibility(0);
                                this.h.setText(this.v.tips.tagTip);
                            }
                        }
                    }
                }
            } else if (i5 == 2) {
                ncovSkuBottomInfo2.isCanClickable = true;
                PriceBean priceBean4 = this.v;
                int i8 = priceBean4.frontEndStatus;
                ncovSkuBottomInfo2.buyStatus = i8;
                if (i8 == 3 && (tipBean = priceBean4.tips) != null) {
                    if (!TextUtils.isEmpty(tipBean.saleTime)) {
                        this.f.setVisibility(0);
                        this.f.setText(this.v.tips.saleTime);
                    }
                    if (!TextUtils.isEmpty(this.v.tips.tagTip)) {
                        this.g.setVisibility(0);
                        this.h.setText(this.v.tips.tagTip);
                    }
                }
            }
            cn.damai.common.user.c e2 = cn.damai.common.user.c.e();
            td2 i9 = td2.i();
            long j = this.x;
            PriceBean priceBean5 = this.v;
            e2.x(i9.o(j, priceBean5, priceBean5.index));
            q();
            z();
        }
    }

    private boolean u(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "237498194")) {
            return ((Boolean) ipChange.ipc$dispatch("237498194", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)})).booleanValue();
        }
        if (this.v == null) {
            return false;
        }
        this.j.setVisibility(0);
        if (this.v.packagesFlag) {
            TextView textView = this.m;
            textView.setText(i + "套");
            this.n.setVisibility(0);
            TextView textView2 = this.n;
            textView2.setText("/共" + (this.v.auctionUnit * i) + "张");
        } else {
            this.n.setVisibility(8);
            TextView textView3 = this.m;
            textView3.setText(i + "张");
        }
        return B(i, z);
    }

    public void A(boolean z, boolean z2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-555656885")) {
            ipChange.ipc$dispatch("-555656885", new Object[]{this, Boolean.valueOf(z), Boolean.valueOf(z2)});
            return;
        }
        if (z && z2) {
            this.r.setVisibility(0);
        } else {
            this.r.setVisibility(8);
        }
        this.q.setVisibility(z2 ? 0 : 8);
        this.p.setVisibility(z ? 0 : 8);
    }

    public boolean B(int i, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "145626725")) {
            return ((Boolean) ipChange.ipc$dispatch("145626725", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z)})).booleanValue();
        }
        int j = j();
        this.o.setEnabled(true);
        this.o.setImageResource(R$drawable.bricks_ic_plus_enable);
        if (i != 1 && i != 0) {
            this.l.setEnabled(true);
        } else {
            this.l.setEnabled(false);
        }
        if (i < j || i == 0) {
            return true;
        }
        this.o.setImageResource(R$drawable.bricks_ic_plus_unable);
        return i == j;
    }

    public void E(PerformBean performBean, List<PriceBean> list, CalculatePriceControlBean calculatePriceControlBean, WishHeatBean wishHeatBean, BusinessInfo businessInfo) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1267502500")) {
            ipChange.ipc$dispatch("-1267502500", new Object[]{this, performBean, list, calculatePriceControlBean, wishHeatBean, businessInfo});
            return;
        }
        this.c.setText("票档");
        this.c.setTextSize(1, 12.0f);
        if (wh2.e(list) == 0) {
            return;
        }
        this.t = performBean;
        this.u = businessInfo;
        this.w = calculatePriceControlBean;
        this.A = wishHeatBean;
        if (!TextUtils.isEmpty(performBean.seatImg)) {
            this.p.setVisibility(0);
            this.p.setTag(R$id.tag_sku_seat_image_uri, performBean.seatImg);
            this.p.setTag(R$id.tag_sku_seat_image_title, performBean.performName);
            td2.i().w(this.p, this.x, "查看座位图");
        } else {
            this.p.setVisibility(8);
        }
        C(list);
    }

    public void d() {
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1372224816")) {
            ipChange.ipc$dispatch("-1372224816", new Object[]{this});
            return;
        }
        NcovSkuBottomInfo ncovSkuBottomInfo = this.y;
        if ((ncovSkuBottomInfo != null && ncovSkuBottomInfo.pageType == 2) || this.t == null || this.v == null || ncovSkuBottomInfo == null) {
            return;
        }
        String[] b2 = x8.Companion.b(this.x + "", this.s);
        if (b2.length != 0) {
            if (b2.length == 1 && TextUtils.isEmpty(b2[0])) {
                return;
            }
            int length = b2.length;
            int g2 = g();
            int j = j();
            PriceBean priceBean = this.v;
            if (priceBean.packagesFlag && priceBean.auctionUnit != 0) {
                this.z = Math.min(j, Math.min(g2, length) / this.v.auctionUnit);
            } else {
                this.z = Math.min(j, Math.min(g2, length));
            }
            int i = this.z;
            this.z = i > 0 ? i : 1;
            int h2 = h();
            if (h2 < g2) {
                str = "余票不足";
            } else {
                str = "最多购买" + g2 + "张";
            }
            if ((g2 < length || h2 < length) && j() > 0) {
                cn.damai.common.util.toastutil.a.i(this.s, str);
            }
        }
    }

    public void e(int i) {
        throw null;
    }

    public int g() {
        Tag tag;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1869107152")) {
            return ((Integer) ipChange.ipc$dispatch("1869107152", new Object[]{this})).intValue();
        }
        PerformBean performBean = this.t;
        int i = performBean.limitQuantity;
        return (performBean.itemLimitPerOrder <= 0 || (tag = this.v.promotionTag) == null || !tag.tag.equals(PromotionTagView.VIP_BUY)) ? i : this.t.itemLimitPerOrder;
    }

    public int i() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-477196634") ? ((Integer) ipChange.ipc$dispatch("-477196634", new Object[]{this})).intValue() : this.z;
    }

    public View k() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1603986414") ? (View) ipChange.ipc$dispatch("1603986414", new Object[]{this}) : this.a;
    }

    public void n(String str, String str2) {
        throw null;
    }

    public void o(PriceBean priceBean) {
        throw null;
    }

    public void s(int i) {
        int i2;
        int i3;
        String str;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1237931873")) {
            ipChange.ipc$dispatch("-1237931873", new Object[]{this, Integer.valueOf(i)});
        } else if (this.t == null || this.v == null || this.y == null) {
        } else {
            if (i == 1) {
                cn.damai.common.user.c.e().x(td2.i().h(this.x, this.t, this.v));
                int g2 = g();
                if (h() < g2) {
                    str = "余票不足";
                } else {
                    str = "最多购买" + g2 + "张";
                }
                if (this.z < j()) {
                    this.z++;
                } else {
                    cn.damai.common.util.toastutil.a.i(this.s, str);
                    return;
                }
            } else if (i == 2 && (i2 = this.z) > 1) {
                this.z = i2 - 1;
                cn.damai.common.user.c.e().x(td2.i().g(this.x, this.t, this.v));
            }
            boolean u = u(this.z, true);
            CalculatePriceControlBean calculatePriceControlBean = this.w;
            if (calculatePriceControlBean != null && calculatePriceControlBean.needCalc && (i3 = this.z) > 0 && u) {
                e(i3);
                return;
            }
            this.y.allPrice = gm1.b(this.v.price, this.z);
            this.y.promotionAmount = 0.0d;
            z();
        }
    }

    public void t(PriceBean priceBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1771505155")) {
            ipChange.ipc$dispatch("-1771505155", new Object[]{this, priceBean});
            return;
        }
        this.v = priceBean;
        this.y.isCanClickable = false;
        r();
        D(this.A);
        y(this.A);
    }

    public void v(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1525851640")) {
            ipChange.ipc$dispatch("1525851640", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.i.c(i);
        }
    }

    public void w(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1937770704")) {
            ipChange.ipc$dispatch("1937770704", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a.setVisibility(i);
        }
    }

    public void x() {
        throw null;
    }

    public void y(WishHeatBean wishHeatBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1416757519")) {
            ipChange.ipc$dispatch("-1416757519", new Object[]{this, wishHeatBean});
            return;
        }
        this.i.c(8);
        if (wishHeatBean == null || m91.a(wishHeatBean.prices) || this.y.pageType != 2 || rd2.a(this.x) == null || this.v == null) {
            return;
        }
        this.i.c(0);
        td2.i().v(this.i.a(), this.x, 0);
    }

    public void z() {
        throw null;
    }
}
