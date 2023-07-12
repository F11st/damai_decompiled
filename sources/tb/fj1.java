package tb;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.notice.bean.ItemContent;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.NcovSkuBottomInfo;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PerformSummaryBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.PriceBean;
import cn.damai.commonbusiness.seatbiz.sku.qilin.bean.Tag;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ui.view.PromotionTagView;
import cn.damai.commonbusiness.seatbiz.sku.qilin.ut.SkuInfo;
import cn.damai.uikit.view.SeeAnimateView;
import com.alibaba.fastjson.JSON;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class fj1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private View a;
    private TextView b;
    private TextView c;
    private TextView d;
    private LinearLayout e;
    private Context f;
    private PerformSummaryBean h;
    private PerformBean i;
    private NcovSkuBottomInfo j;
    private long k;
    private boolean l;
    private boolean m;
    private Activity n;
    private List<View> g = new ArrayList();
    private long o = 0;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ ArrayList a;

        a(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-606175463")) {
                ipChange.ipc$dispatch("-606175463", new Object[]{this, view});
            } else {
                fj1.this.j(this.a);
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
            if (AndroidInstantRuntime.support(ipChange, "1505114906")) {
                ipChange.ipc$dispatch("1505114906", new Object[]{this, view});
                return;
            }
            PerformSummaryBean performSummaryBean = (PerformSummaryBean) view.getTag();
            if (performSummaryBean == null) {
                return;
            }
            if (fj1.this.h == null || performSummaryBean.performId != fj1.this.h.performId) {
                fj1.this.h = performSummaryBean;
                fj1 fj1Var = fj1.this;
                fj1Var.o = fj1Var.h.performId;
                fj1.this.i(performSummaryBean);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class c implements ViewTreeObserver.OnGlobalLayoutListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ View a;
        final /* synthetic */ PromotionTagView b;

        c(View view, PromotionTagView promotionTagView) {
            this.a = view;
            this.b = promotionTagView;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-560530178")) {
                ipChange.ipc$dispatch("-560530178", new Object[]{this});
                return;
            }
            TextView textView = (TextView) this.a.findViewById(R$id.item_text);
            DisplayMetrics displayMetrics = fj1.this.f.getResources().getDisplayMetrics();
            int width = this.a.getWidth();
            if (textView.getLineCount() > 1) {
                this.a.setMinimumWidth((com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) - t60.a(fj1.this.f, 33.0f)) - 1);
                textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), t60.a(fj1.this.f, 16.0f) + this.b.getCurrentView().getWidth(), textView.getPaddingBottom());
            } else {
                textView.setMaxWidth((width - t60.a(fj1.this.f, 16.0f)) - this.b.getCurrentView().getWidth());
            }
            this.b.getCurrentView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public fj1(View view, Activity activity, long j, NcovSkuBottomInfo ncovSkuBottomInfo) {
        this.j = null;
        this.a = view;
        this.f = view.getContext();
        this.n = activity;
        this.k = j;
        this.j = ncovSkuBottomInfo;
        h();
    }

    private void e(View view, Tag tag, Tag tag2, PromotionTagView promotionTagView) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "372216747")) {
            ipChange.ipc$dispatch("372216747", new Object[]{this, view, tag, tag2, promotionTagView});
            return;
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.layout_tag);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R$id.layout_tag_promotion);
        linearLayout2.removeAllViews();
        linearLayout.removeAllViews();
        promotionTagView.setVisibility(8);
        if (tag != null && !TextUtils.isEmpty(tag.tagDesc)) {
            View inflate = LayoutInflater.from(this.f).inflate(R$layout.sku_ncov_tag, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R$id.tv_tag);
            textView.setText(tag.tagDesc);
            if (!tag.isPositive()) {
                textView.setTextColor(this.f.getResources().getColor(R$color.color_6A7A99));
                textView.setBackgroundResource(R$drawable.ncov_sku_tag_normal_bg);
            } else {
                textView.setTextColor(this.f.getResources().getColor(R$color.color_FF2869));
            }
            linearLayout.addView(inflate);
        }
        promotionTagView.setTag(tag2);
        if (tag2 != null && !TextUtils.isEmpty(tag2.tagDesc)) {
            TextView textView2 = new TextView(g().getContext());
            textView2.setSingleLine();
            textView2.setText(tag2.tagDesc);
            textView2.setPadding(t60.a(this.f, 2.0f), 0, 0, t60.a(this.f, 2.0f));
            textView2.setTextSize(1, 10.0f);
            textView2.setVisibility(4);
            if (PromotionTagView.HALF_PRICE.equals(tag2.tag)) {
                textView2.setWidth(t60.a(this.f, 40.0f));
            } else if (PromotionTagView.VIP_BUY.equals(tag2.tag)) {
                textView2.setWidth(t60.a(this.f, 75.0f));
            } else {
                textView2.setPadding(t60.a(this.f, 2.0f), 0, 0, 0);
            }
            linearLayout2.addView(textView2);
        }
        promotionTagView.getCurrentView().getViewTreeObserver().addOnGlobalLayoutListener(new c(view, promotionTagView));
    }

    private String f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-42539110")) {
            return (String) ipChange.ipc$dispatch("-42539110", new Object[]{this});
        }
        if (wh2.e(this.i.skuList) > 0) {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.i.skuList.size(); i++) {
                PriceBean priceBean = this.i.skuList.get(i);
                if (priceBean != null) {
                    SkuInfo skuInfo = new SkuInfo();
                    skuInfo.sku_id = priceBean.skuId + "";
                    skuInfo.status = priceBean.frontEndStatus + "";
                    arrayList.add(skuInfo);
                }
            }
            return JSON.toJSONString(arrayList);
        }
        return "";
    }

    private void h() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-568594778")) {
            ipChange.ipc$dispatch("-568594778", new Object[]{this});
            return;
        }
        this.b = (TextView) this.a.findViewById(R$id.tv_perform_name);
        this.c = (TextView) this.a.findViewById(R$id.tv_perform_tip);
        this.d = (TextView) this.a.findViewById(R$id.tv_perform_changetip);
        this.e = (LinearLayout) this.a.findViewById(R$id.project_detail_perform_flowlayout);
    }

    private void k(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "408939088")) {
            ipChange.ipc$dispatch("408939088", new Object[]{this, view});
        } else if (this.j.pageType == 1) {
        } else {
            view.findViewById(R$id.layout_xin).setVisibility(0);
            ((SeeAnimateView) view.findViewById(R$id.image_xin)).setCancelImage();
            this.b.setText("想看哪场");
            this.b.setTextSize(1, 16.0f);
        }
    }

    private void l() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1505343180")) {
            ipChange.ipc$dispatch("1505343180", new Object[]{this});
        } else if (wh2.e(this.g) != 0 && this.i != null) {
            for (View view : this.g) {
                TextView textView = (TextView) view.findViewById(R$id.item_text);
                TextView textView2 = (TextView) view.findViewById(R$id.perform_des);
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R$id.ll_perform_item);
                PerformSummaryBean performSummaryBean = (PerformSummaryBean) view.getTag();
                if (performSummaryBean != null) {
                    if (performSummaryBean.performId == this.i.performId) {
                        linearLayout.setBackgroundResource(R$drawable.ncov_sku_perform_select_bg);
                        textView.setTextColor(ContextCompat.getColor(this.f, R$color.color_000000));
                        StringBuilder sb = new StringBuilder();
                        if (!TextUtils.isEmpty(performSummaryBean.remark)) {
                            sb.append(performSummaryBean.remark);
                        }
                        PerformBean performBean = this.i;
                        if (performBean != null && !TextUtils.isEmpty(performBean.performTimeDetailStr) && !this.i.performTimeDetailStr.equals(performSummaryBean.remark)) {
                            if (sb.length() > 0) {
                                sb.append(StringUtils.LF);
                            }
                            sb.append(this.i.performTimeDetailStr);
                        }
                        if (!TextUtils.isEmpty(sb.toString())) {
                            textView2.setText(sb);
                            textView2.setVisibility(0);
                        }
                    } else {
                        if (performSummaryBean.clickable) {
                            textView.setTextColor(ContextCompat.getColor(this.f, R$color.color_666666));
                        } else {
                            textView.setTextColor(ContextCompat.getColor(this.f, R$color.color_cccccc));
                        }
                        textView2.setVisibility(8);
                        linearLayout.setBackgroundResource(R$drawable.ncov_sku_perform_bg);
                    }
                }
            }
            m();
        }
    }

    private void m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1845696001")) {
            ipChange.ipc$dispatch("-1845696001", new Object[]{this});
        } else if (wh2.e(this.g) != 0 && this.i != null && this.j.pageType != 1) {
            for (View view : this.g) {
                View findViewById = view.findViewById(R$id.ll_perform_item);
                TextView textView = (TextView) view.findViewById(R$id.item_text);
                TextView textView2 = (TextView) view.findViewById(R$id.perform_des);
                SeeAnimateView seeAnimateView = (SeeAnimateView) view.findViewById(R$id.image_xin);
                PerformSummaryBean performSummaryBean = (PerformSummaryBean) view.getTag();
                if (performSummaryBean != null) {
                    if (performSummaryBean.performId == this.i.performId) {
                        findViewById.setBackgroundResource(R$drawable.ncov_sku_perform_select_see_bg);
                        textView.setTextColor(ContextCompat.getColor(this.f, R$color.color_FF2869));
                        textView2.setVisibility(0);
                        seeAnimateView.clickAnimate();
                    } else {
                        textView2.setVisibility(8);
                        seeAnimateView.setCancelImage();
                    }
                }
            }
        }
    }

    private void o(List<PerformSummaryBean> list, PerformBean performBean, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1965401917")) {
            ipChange.ipc$dispatch("1965401917", new Object[]{this, list, performBean, str});
            return;
        }
        this.a.setVisibility(0);
        this.b.setText("场次");
        this.b.setTextSize(1, 12.0f);
        if (!TextUtils.isEmpty(str)) {
            this.c.setText(str);
        }
        this.e.removeAllViews();
        this.g.clear();
        for (int i = 0; i < list.size(); i++) {
            PerformSummaryBean performSummaryBean = list.get(i);
            if (performSummaryBean != null) {
                performSummaryBean.index = i;
                View inflate = LayoutInflater.from(this.f).inflate(R$layout.sku_ncov_itembox_perform, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R$id.item_text);
                textView.setText(performSummaryBean.performName);
                TextView textView2 = (TextView) inflate.findViewById(R$id.perform_des);
                e(inflate, performSummaryBean.otherTag, performSummaryBean.promotionTag, (PromotionTagView) inflate.findViewById(R$id.layout_tag_righttop));
                k(inflate);
                if (performSummaryBean.clickable) {
                    textView.setTextColor(ContextCompat.getColor(this.f, R$color.color_666666));
                    inflate.setOnClickListener(new b());
                } else {
                    textView.setTextColor(ContextCompat.getColor(this.f, R$color.color_cccccc));
                }
                inflate.setTag(performSummaryBean);
                this.g.add(inflate);
                this.e.addView(inflate);
                if (performSummaryBean.checked && this.l && performSummaryBean.performId == this.o) {
                    NcovSkuBottomInfo ncovSkuBottomInfo = this.j;
                    if (ncovSkuBottomInfo.pageType == 2) {
                        this.i = performBean;
                        this.h = performSummaryBean;
                    } else if (this.m) {
                        if (performSummaryBean.salable) {
                            this.i = performBean;
                            this.h = performSummaryBean;
                        }
                    } else {
                        this.i = performBean;
                        this.h = performSummaryBean;
                        ncovSkuBottomInfo.discountTip = performSummaryBean.mktPromotionTips;
                    }
                }
            }
        }
        if (list.size() == 1 && list.get(0) != null && list.get(0).clickable) {
            PerformSummaryBean performSummaryBean2 = list.get(0);
            this.h = performSummaryBean2;
            this.i = performBean;
            this.o = performSummaryBean2.performId;
            this.j.discountTip = performSummaryBean2.mktPromotionTips;
        }
        if (this.i == null || this.h == null) {
            return;
        }
        cn.damai.common.user.c e = cn.damai.common.user.c.e();
        td2 i2 = td2.i();
        long j = this.k;
        PerformSummaryBean performSummaryBean3 = this.h;
        e.x(i2.p(j, performSummaryBean3, this.h.performBeginDTStr + " (" + this.h.performName + jn1.BRACKET_END_STR, this.h.index, f()));
        l();
        NcovSkuBottomInfo ncovSkuBottomInfo2 = this.j;
        if (ncovSkuBottomInfo2.pageType == 1) {
            PerformBean performBean2 = this.i;
            if (performBean2.chooseSeatType == 1) {
                ncovSkuBottomInfo2.buyStatus = 4;
                if (performBean2.performSalable && performBean2.buyPermission) {
                    ncovSkuBottomInfo2.isCanClickable = true;
                } else {
                    ncovSkuBottomInfo2.isCanClickable = false;
                }
            } else {
                ncovSkuBottomInfo2.buyStatus = 1;
            }
        }
        td2.i().y(this.k, this.n, this.i.chooseSeatType == 1 ? 1 : 0);
    }

    public View g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1323602390") ? (View) ipChange.ipc$dispatch("1323602390", new Object[]{this}) : this.a;
    }

    public void i(PerformSummaryBean performSummaryBean) {
        throw null;
    }

    public void j(ArrayList<ItemContent> arrayList) {
        throw null;
    }

    public void n(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1819802600")) {
            ipChange.ipc$dispatch("1819802600", new Object[]{this, Integer.valueOf(i)});
        } else {
            this.a.setVisibility(i);
        }
    }

    public void p(String str, List<PerformSummaryBean> list, PerformBean performBean, boolean z, boolean z2, long j, ArrayList<ItemContent> arrayList) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12526535")) {
            ipChange.ipc$dispatch("-12526535", new Object[]{this, str, list, performBean, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j), arrayList});
        } else if (wh2.e(list) == 0) {
        } else {
            this.l = z;
            this.m = z2;
            this.i = null;
            this.h = null;
            this.o = j;
            o(list, performBean, str);
            if (!cb2.d(arrayList)) {
                this.a.findViewById(R$id.tv_perform_changetip_icon).setVisibility(0);
                this.d.setVisibility(0);
                this.d.setOnClickListener(new a(arrayList));
                HashMap hashMap = new HashMap();
                hashMap.put("item_id", this.k + "");
                cn.damai.common.user.c.e().G(this.d, "showchange", "top", "screenings", hashMap);
                return;
            }
            this.a.findViewById(R$id.tv_perform_changetip_icon).setVisibility(8);
            this.d.setVisibility(8);
        }
    }
}
