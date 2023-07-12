package cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.TextViewCompat;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.image.DMRoundedCornersBitmapProcessor;
import cn.damai.trade.R$color;
import cn.damai.trade.R$drawable;
import cn.damai.trade.R$id;
import cn.damai.trade.R$layout;
import cn.damai.trade.R$string;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.EarlyBirdVO;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectDetailDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectItemDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticDataBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.ProjectStaticItemBaseBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.PromotionItemBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.TagBean;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.bean.WedHalfPriceVO;
import cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.fragment.ProjectDetailItemMainFragment;
import cn.damai.trade.newtradeorder.ui.projectdetail.ui.activity.ProjectDetailActivity;
import cn.damai.trade.newtradeorder.ui.projectdetail.xflush.ProjectDetailXFlushUtil;
import cn.damai.uikit.flowlayout.FlowLayout;
import cn.damai.uikit.tag.DMCategroyTagView;
import cn.damai.uikit.view.RoundImageView;
import com.ali.user.mobile.utils.ScreenUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cb2;
import tb.cm2;
import tb.m62;
import tb.mu0;
import tb.pp2;
import tb.t60;
import tb.wh2;
import tb.xv1;
import tb.yb;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class b extends cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.a implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private RoundImageView e;
    private FlowLayout f;
    private TextView g;
    private TextView h;
    private TextView i;
    private View j;
    private View k;
    private TextView l;
    private TextView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TextView q;
    private c r;
    private View s;
    private ImageView t;
    private TextView u;
    private LinearLayout v;
    private DMCategroyTagView w;
    private TextView x;
    private ViewGroup y;
    private ViewGroup z;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public class a implements DMImageCreator.DMImageFailListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageFailListener
        public void onFail(DMImageCreator.d dVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "596802219")) {
                ipChange.ipc$dispatch("596802219", new Object[]{this, dVar});
            } else {
                ProjectDetailXFlushUtil.n(dVar != null ? String.valueOf(dVar.a) : "", this.a, String.valueOf(b.this.b));
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0085b implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ String a;
        final /* synthetic */ boolean b;

        C0085b(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-868450304")) {
                ipChange.ipc$dispatch("-868450304", new Object[]{this, eVar});
            } else if (eVar != null) {
                if (eVar.a != null) {
                    b.this.e.setImageDrawable(eVar.a);
                    b.this.e.setOnClickListener(b.this);
                }
                Bitmap bitmap = eVar.b;
                if (bitmap != null) {
                    b.this.d.onLoadedPosterPic(this.a, bitmap, this.b);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes16.dex */
    public class c extends CountDownTimer {
        private static transient /* synthetic */ IpChange $ipChange;

        public c(long j) {
            super(j, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1535142228")) {
                ipChange.ipc$dispatch("1535142228", new Object[]{this});
                return;
            }
            Activity activity = b.this.a;
            if (activity == null || activity.isDestroyed()) {
                return;
            }
            Activity activity2 = b.this.a;
            if ((activity2 instanceof ProjectDetailActivity) && ((ProjectDetailActivity) activity2).getCurrentFragment() != null && (((ProjectDetailActivity) b.this.a).getCurrentFragment() instanceof ProjectDetailItemMainFragment)) {
                ((ProjectDetailItemMainFragment) ((ProjectDetailActivity) b.this.a).getCurrentFragment()).onRefresh();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1913369734")) {
                ipChange.ipc$dispatch("-1913369734", new Object[]{this, Long.valueOf(j)});
                return;
            }
            String[] a = xv1.a(j / 1000);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("还剩");
            if (!TextUtils.isEmpty(a[0])) {
                stringBuffer.append(a[0]);
                stringBuffer.append("天 ");
            }
            stringBuffer.append(a[1]);
            stringBuffer.append(":");
            stringBuffer.append(a[2]);
            stringBuffer.append(":");
            stringBuffer.append(a[3]);
            b.this.i.setText(stringBuffer);
        }
    }

    public b(Activity activity, long j, View view, OnHeadClickListener onHeadClickListener) {
        super(activity, j, view, onHeadClickListener);
        this.e = (RoundImageView) view.findViewById(R$id.project_item_poster_image_iv);
        this.y = (ViewGroup) view.findViewById(R$id.title_layout);
        this.f = (FlowLayout) view.findViewById(R$id.project_show_tags_fl);
        this.g = (TextView) view.findViewById(R$id.project_price_tv);
        this.h = (TextView) view.findViewById(R$id.project_price_tv_inner);
        this.i = (TextView) view.findViewById(R$id.project_detail_countdown_tv);
        this.s = view.findViewById(R$id.project_price_promotion);
        this.t = (ImageView) view.findViewById(R$id.iv_project_price_promotion);
        this.u = (TextView) view.findViewById(R$id.project_dash_price_tv);
        this.v = (LinearLayout) view.findViewById(R$id.header_promotion_newll);
        TextView textView = (TextView) view.findViewById(R$id.tv_project_coupon_mark);
        this.w = (DMCategroyTagView) view.findViewById(R$id.project_detail_agency_tag_fv);
        this.x = (TextView) view.findViewById(R$id.project_detail_image_num_tv);
        this.j = view.findViewById(R$id.sfpt_container);
        this.l = (TextView) view.findViewById(R$id.sfpt_prefix_tv);
        this.m = (TextView) view.findViewById(R$id.sfpt_tv);
        this.n = (TextView) view.findViewById(R$id.sfpt_suffix_tv);
        this.k = view.findViewById(R$id.sfpt_container_inner);
        this.o = (TextView) view.findViewById(R$id.sfpt_prefix_tv_inner);
        this.p = (TextView) view.findViewById(R$id.sfpt_tv_inner);
        this.q = (TextView) view.findViewById(R$id.sfpt_suffix_tv_inner);
        this.z = (ViewGroup) view.findViewById(R$id.header_base_uill);
        this.f.setSingleLine(true);
    }

    private ImageView h(TagBean tagBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-251590025")) {
            return (ImageView) ipChange.ipc$dispatch("-251590025", new Object[]{this, tagBean});
        }
        if (tagBean.ids <= 0) {
            return null;
        }
        int a2 = m62.a(this.a, 16.0f);
        FlowLayout.LayoutParams layoutParams = new FlowLayout.LayoutParams((tagBean.picWidth * a2) / tagBean.picHeight, a2);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = m62.a(this.a, 3.0f);
        ImageView imageView = new ImageView(this.a);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(tagBean.ids);
        return imageView;
    }

    private View i(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "593113345")) {
            return (View) ipChange.ipc$dispatch("593113345", new Object[]{this, str});
        }
        View inflate = LayoutInflater.from(this.a).inflate(R$layout.project_item_basic_mark_layout, (ViewGroup) this.f, false);
        TextView textView = (TextView) inflate.findViewById(R$id.tv_show_tag);
        textView.setBackgroundResource(R$drawable.project_detail_show_tag_bg);
        textView.setText(str);
        return inflate;
    }

    private void j(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-945909966")) {
            ipChange.ipc$dispatch("-945909966", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        this.e.setOnClickListener(null);
        if (str == null) {
            return;
        }
        DMImageCreator k = cn.damai.common.image.a.b().f(str, ScreenUtil.dip2px(mu0.a(), 93.0f), ScreenUtil.dip2px(mu0.a(), 131.0f)).k(new DMRoundedCornersBitmapProcessor(6, 0));
        int i = R$drawable.uikit_default_image_bg_trans_white;
        k.i(i).c(i).n(new C0085b(str, z)).e(new a(str)).f();
        pp2.u().N1(this.e, String.valueOf(this.b));
    }

    private void l(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1724671320")) {
            ipChange.ipc$dispatch("1724671320", new Object[]{this, textView, str});
            return;
        }
        int length = str.length();
        int length2 = str.split("\\d")[0].length();
        SpannableString spannableString = new SpannableString(str);
        int a2 = t60.a(this.a, 10.0f);
        int a3 = t60.a(this.a, 11.0f);
        spannableString.setSpan(new AbsoluteSizeSpan(a2), 0, length2, 18);
        spannableString.setSpan(new AbsoluteSizeSpan(a3), length2, length, 18);
        textView.setText(spannableString);
    }

    private void m(List<PromotionItemBean> list, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "95955078")) {
            ipChange.ipc$dispatch("95955078", new Object[]{this, list, str});
        } else if (cb2.d(list)) {
            this.v.setOnClickListener(null);
            this.v.setVisibility(8);
        } else {
            if (list.get(0) != null) {
                this.v.setVisibility(0);
                ViewGroup viewGroup = (ViewGroup) this.v.findViewById(R$id.fl_sub_tags_container);
                viewGroup.removeAllViews();
                list.get(0).addTagView(viewGroup, new int[]{0, 0, t60.a(this.a, 4.5f), 0});
            }
            ViewGroup viewGroup2 = (ViewGroup) this.v.findViewById(R$id.sub_marketing_item_container);
            viewGroup2.removeAllViews();
            for (int i = 1; i < list.size(); i++) {
                list.get(i).addTagView(viewGroup2, new int[]{0, t60.a(this.a, 4.5f), t60.a(this.a, 4.5f), 0});
            }
            this.v.setOnClickListener(this);
            pp2.u().s2(this.v, str, list);
        }
    }

    private void n(List<TagBean> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1456571867")) {
            ipChange.ipc$dispatch("-1456571867", new Object[]{this, list});
        } else if (cb2.d(list)) {
            this.f.setVisibility(8);
        } else {
            this.f.setVisibility(0);
            this.f.removeAllViews();
            for (int i = 0; i < list.size(); i++) {
                TagBean tagBean = list.get(i);
                if (tagBean != null) {
                    int i2 = tagBean.type;
                    if (i2 == TagBean.TYPE_TEXT) {
                        if (!TextUtils.isEmpty(tagBean.text)) {
                            this.f.addView(i(tagBean.text));
                        }
                    } else if (i2 == TagBean.TYPE_IMAGE) {
                        this.f.addView(h(tagBean));
                    }
                }
            }
        }
    }

    @Override // cn.damai.trade.newtradeorder.ui.projectdetail.projectdetailitem.ui.view.projectheader.a
    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1603899377") ? ((Integer) ipChange.ipc$dispatch("-1603899377", new Object[]{this})).intValue() : R$id.header_base_info_ui;
    }

    public void f(ProjectDetailDataBean projectDetailDataBean, boolean z) {
        EarlyBirdVO earlyBirdVO;
        WedHalfPriceVO wedHalfPriceVO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1649191225")) {
            ipChange.ipc$dispatch("-1649191225", new Object[]{this, projectDetailDataBean, Boolean.valueOf(z)});
        } else if (projectDetailDataBean == null) {
        } else {
            ProjectStaticDataBean staticData = projectDetailDataBean.getStaticData();
            ProjectItemDataBean item = projectDetailDataBean.getItem();
            ProjectStaticItemBaseBean c2 = yb.c(staticData);
            List<TagBean> k = yb.k(staticData);
            String itemName = c2 == null ? "" : c2.getItemName();
            n(k);
            String valueOf = c2 == null ? "" : String.valueOf(c2.getItemId());
            o(itemName, wh2.e(k) > 0);
            String priceRange = item != null ? item.getPriceRange() : "";
            if (TextUtils.isEmpty(priceRange) || priceRange.contains(cm2.b(this.a, R$string.damai_projectdetail_tbd)) || priceRange.contains(cm2.b(this.a, R$string.damai_search_prize))) {
                priceRange = this.a.getResources().getString(R$string.damai_search_prize);
            }
            CharSequence n = yb.n(priceRange, 12);
            this.g.setText(n);
            if (c2 != null) {
                long j = c2.sfpt;
                if (c2.hasServiceFee) {
                    if (item != null && (item.hasEarlyBird || item.hasWedHalfPrice)) {
                        this.k.setVisibility(0);
                        l(this.p, c2.sfptTip);
                        this.o.setText(c2.sfptPrefix);
                        this.q.setText(c2.sfptSuffix);
                    } else {
                        this.j.setVisibility(0);
                        this.m.setTextColor(this.a.getResources().getColor(j == 0 ? R$color.color_9C9CA5 : R$color.color_FF2869));
                        l(this.m, c2.sfptTip);
                        this.l.setText(c2.sfptPrefix);
                        this.n.setText(c2.sfptSuffix);
                    }
                } else {
                    this.j.setVisibility(8);
                }
            }
            if (item != null && (item.hasEarlyBird || item.hasWedHalfPrice)) {
                this.s.setVisibility(0);
                ViewGroup viewGroup = this.z;
                if (viewGroup != null) {
                    viewGroup.setBackgroundResource(R$drawable.bg_header_corner_pink_shape);
                }
                if (item.hasWedHalfPrice) {
                    this.t.setImageResource(R$drawable.icon_promotion_wedensday_half_price);
                } else if (item.hasEarlyBird) {
                    this.t.setImageResource(R$drawable.icon_market_earlybird_inner);
                }
                this.g.setVisibility(8);
                this.h.setText(n);
                if (item.hasWedHalfPrice && (wedHalfPriceVO = item.wedHalfPriceVO) != null) {
                    String str = wedHalfPriceVO.tips;
                    if (str != null) {
                        this.i.setText(str);
                    } else {
                        this.i.setText("");
                    }
                    c cVar = this.r;
                    if (cVar != null) {
                        cVar.cancel();
                    }
                } else if (item.hasEarlyBird && (earlyBirdVO = item.earlyBirdVO) != null) {
                    if (earlyBirdVO.showTips) {
                        this.i.setText(earlyBirdVO.tips);
                    } else {
                        c cVar2 = this.r;
                        if (cVar2 != null) {
                            cVar2.cancel();
                        }
                        if (item.earlyBirdVO.countdown > 0) {
                            c cVar3 = new c(item.earlyBirdVO.countdown);
                            this.r = cVar3;
                            cVar3.start();
                        }
                    }
                }
            } else {
                ViewGroup viewGroup2 = this.z;
                if (viewGroup2 != null) {
                    viewGroup2.setBackgroundResource(R$drawable.bg_header_corner_white_shape);
                }
            }
            this.u.setVisibility(8);
            m(item.promotionList, valueOf);
            int e = wh2.e(yb.f(staticData));
            if (e > 1) {
                this.x.setText(cm2.c(this.a, R$string.project_total_image_num, Integer.valueOf(e)));
                this.x.setVisibility(0);
            } else {
                this.x.setVisibility(8);
            }
            this.w.setVisibility(8);
            j(yb.h(staticData), z);
        }
    }

    public void g(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-670816066")) {
            ipChange.ipc$dispatch("-670816066", new Object[]{this, str, str2});
            return;
        }
        o(str2, false);
        j(str, false);
        this.g.setVisibility(8);
        this.u.setVisibility(8);
        n(null);
        m(null, null);
        this.x.setVisibility(8);
        this.w.setVisibility(8);
    }

    public void k() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1753785562")) {
            ipChange.ipc$dispatch("1753785562", new Object[]{this});
            return;
        }
        c cVar = this.r;
        if (cVar != null) {
            cVar.cancel();
            this.r = null;
        }
    }

    public void o(String str, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1209254358")) {
            ipChange.ipc$dispatch("1209254358", new Object[]{this, str, Boolean.valueOf(z)});
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.y.removeAllViews();
        AppCompatTextView appCompatTextView = new AppCompatTextView(this.a);
        appCompatTextView.setMaxLines(z ? 2 : 3);
        appCompatTextView.setTextColor(-16777216);
        appCompatTextView.setLineSpacing(6.0f, 1.0f);
        appCompatTextView.setEllipsize(TextUtils.TruncateAt.END);
        appCompatTextView.setTextSize(1, 16.0f);
        TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(appCompatTextView, 6, 16, 1, 1);
        appCompatTextView.setText(str);
        this.y.addView(appCompatTextView, -1, -2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "327004396")) {
            ipChange.ipc$dispatch("327004396", new Object[]{this, view});
            return;
        }
        int id = view.getId();
        if (id == this.e.getId()) {
            this.d.onPosterClick();
        } else if (id == this.v.getId()) {
            this.d.onPromotionTagsClick();
        }
    }
}
