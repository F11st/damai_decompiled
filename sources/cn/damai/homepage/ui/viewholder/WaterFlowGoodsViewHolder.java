package cn.damai.homepage.ui.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.baseview.RCRelativeLayoutView;
import cn.damai.common.image.DMImageCreator;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.util.ToastUtil;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.homepage.bean.WaterFlowRecommendItem;
import cn.damai.homepage.ui.adapter.GuessAdapter;
import cn.damai.uikit.number.DMDigitTextView;
import cn.damai.uikit.tag.DMCommonTagView;
import cn.damai.uikit.tag.DMTagType;
import cn.damai.uikit.view.DMLabelType;
import cn.damai.uikit.view.DMPosterView;
import cn.damai.uikit.view.LiveRoomView;
import com.alibaba.pictures.bricks.view.DMLabelView;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.a21;
import tb.cb1;
import tb.cs;
import tb.py0;
import tb.sx0;
import tb.t60;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class WaterFlowGoodsViewHolder extends RecyclerView.ViewHolder {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private FrameLayout b;
    private View c;
    private RCRelativeLayoutView d;
    private DMCommonTagView e;
    private TextView f;
    private TextView g;
    private TextView h;
    private View i;
    private DMDigitTextView j;
    private DMDigitTextView k;
    private TextView l;
    private View m;
    private LinearLayout n;
    private DMDigitTextView o;
    private TextView p;
    private String q;
    private int r;
    private int s;
    private DMPosterView t;
    private GuessAdapter u;
    private int v;
    private View.OnClickListener w;
    private View.OnLongClickListener x;

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-450551810")) {
                ipChange.ipc$dispatch("-450551810", new Object[]{this, view});
            } else if (view.getId() == R$id.homepage_waterflow_goods_feedback_layer) {
            } else {
                if (view.getId() == R$id.homepage_waterflow_goods_feedback_btn) {
                    ToastUtil.a().e(WaterFlowGoodsViewHolder.this.a, "商品不感兴趣");
                    WaterFlowGoodsViewHolder.this.u.c(WaterFlowGoodsViewHolder.this.v);
                    return;
                }
                WaterFlowRecommendItem waterFlowRecommendItem = (WaterFlowRecommendItem) view.getTag();
                cn.damai.common.user.c e = cn.damai.common.user.c.e();
                py0 I = py0.I();
                String str = WaterFlowGoodsViewHolder.this.q;
                String str2 = waterFlowRecommendItem.projectId;
                e.x(I.M(str, str2, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, str2, waterFlowRecommendItem.pageNum, waterFlowRecommendItem.index, waterFlowRecommendItem.title, waterFlowRecommendItem.schema));
                if (!"4".equals(waterFlowRecommendItem.cardType)) {
                    DMNav.from(WaterFlowGoodsViewHolder.this.a).toUri(waterFlowRecommendItem.schema);
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("from_page", "homepage");
                bundle.putString("projectImage", waterFlowRecommendItem.projectPic);
                bundle.putString("id", waterFlowRecommendItem.projectId);
                if (wh2.j(waterFlowRecommendItem.schema)) {
                    DMNav.from(WaterFlowGoodsViewHolder.this.a).withExtras(bundle).toUri(NavUri.b(cs.b));
                } else {
                    DMNav.from(WaterFlowGoodsViewHolder.this.a).toUri(waterFlowRecommendItem.schema);
                }
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes14.dex */
    public class b implements View.OnLongClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        b(WaterFlowGoodsViewHolder waterFlowGoodsViewHolder) {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "292201191")) {
                return ((Boolean) ipChange.ipc$dispatch("292201191", new Object[]{this, view})).booleanValue();
            }
            return true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public class c implements DMImageCreator.DMImageSuccListener {
        private static transient /* synthetic */ IpChange $ipChange;
        final /* synthetic */ SpannableStringBuilder a;

        c(SpannableStringBuilder spannableStringBuilder) {
            this.a = spannableStringBuilder;
        }

        @Override // cn.damai.common.image.DMImageCreator.DMImageSuccListener
        public void onSuccess(DMImageCreator.e eVar) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-849158778")) {
                ipChange.ipc$dispatch("-849158778", new Object[]{this, eVar});
            } else {
                WaterFlowGoodsViewHolder.this.showAtmospheric(this.a, eVar.b);
            }
        }
    }

    public WaterFlowGoodsViewHolder(String str, Context context) {
        super(LayoutInflater.from(context).inflate(R$layout.homepage_waterflow_recommend_goodscard, (ViewGroup) null));
        this.w = new a();
        this.x = new b(this);
        this.q = str;
        this.a = context;
        this.b = (FrameLayout) this.itemView.findViewById(R$id.homepage_waterflow_goods_feedback_layer);
        this.c = this.itemView.findViewById(R$id.homepage_waterflow_goods_feedback_btn);
        this.d = (RCRelativeLayoutView) this.itemView.findViewById(R$id.homepage_waterflow_goods_layout);
        DMPosterView dMPosterView = (DMPosterView) this.itemView.findViewById(R$id.homepage_waterflow_goods_card);
        this.t = dMPosterView;
        dMPosterView.setPlaceholder(R$drawable.homepage_waterflow_poster_bg);
        this.t.setVideoIconSize(24.0f, 6.0f);
        this.t.setCategoryMargin(6.0f, 6.0f);
        DMLabelView labelView = this.t.getLabelView();
        if (labelView != null) {
            float a2 = t60.a(context, 12.0f);
            labelView.setCornerRadii(a2, a2, a2, 0.0f);
        }
        this.e = (DMCommonTagView) this.itemView.findViewById(R$id.homepage_waterflow_goodscard_tag);
        this.g = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_title);
        this.h = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_time);
        this.i = this.itemView.findViewById(R$id.homepage_waterflow_goods_price_layout);
        this.j = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_price);
        DMDigitTextView dMDigitTextView = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_price_unknown);
        this.k = dMDigitTextView;
        dMDigitTextView.setVisibility(8);
        this.f = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_wantsee);
        this.l = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_price_suffix);
        this.m = this.itemView.findViewById(R$id.homepage_waterflow_recommend_goods_ticket);
        this.n = (LinearLayout) this.itemView.findViewById(R$id.homepage_waterflow_goods_ticket_price_layout);
        this.o = (DMDigitTextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_ticket_price);
        this.p = (TextView) this.itemView.findViewById(R$id.homepage_waterflow_goods_buy_btn);
        this.r = ((DisplayMetrics.getwidthPixels(t60.b(context)) - t60.a(context, 24.0f)) / 2) - t60.a(context, 4.5f);
        ViewGroup.LayoutParams layoutParams = this.d.getLayoutParams();
        layoutParams.width = this.r;
        layoutParams.height = -2;
        this.d.setLayoutParams(layoutParams);
        this.s = (int) (((this.r * 224) * 1.0f) / 168.0f);
        this.itemView.setOnClickListener(this.w);
        this.itemView.setOnLongClickListener(this.x);
        this.b.setOnClickListener(this.w);
        this.c.setOnClickListener(this.w);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAtmospheric(SpannableStringBuilder spannableStringBuilder, Bitmap bitmap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2017111003")) {
            ipChange.ipc$dispatch("-2017111003", new Object[]{this, spannableStringBuilder, bitmap});
            return;
        }
        spannableStringBuilder.insert(0, "123");
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        int a2 = t60.a(this.a, 16.0f);
        spannableStringBuilder.setSpan(new ImageSpan(this.a, a21.f(bitmap, (width * a2) / height, a2), 1), 0, 3, 18);
        this.g.setText(spannableStringBuilder);
    }

    public void f(WaterFlowRecommendItem waterFlowRecommendItem, GuessAdapter guessAdapter, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1305580730")) {
            ipChange.ipc$dispatch("1305580730", new Object[]{this, waterFlowRecommendItem, guessAdapter, Integer.valueOf(i)});
        } else if (waterFlowRecommendItem == null) {
        } else {
            this.u = guessAdapter;
            this.v = i;
            this.t.setBorderVisibility(8);
            this.t.setCategoryTagName(waterFlowRecommendItem.categoryName);
            int i2 = waterFlowRecommendItem.liveStatus;
            if (i2 == 0) {
                this.t.setLiveRoom(false, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            } else if (i2 == 1) {
                this.t.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_DEFAULT);
            } else if (i2 == 2) {
                this.t.setLiveRoom(true, LiveRoomView.DMLiveRoomType.TAG_TYPE_LIVE);
            }
            if (sx0.a(waterFlowRecommendItem.cardType) == 4) {
                if ("1".equals(waterFlowRecommendItem.tagType)) {
                    this.t.setLabelType(DMLabelType.LABEL_TYPE_UPCOMING_BUY);
                    this.f.setVisibility(8);
                } else if ("2".equals(waterFlowRecommendItem.tagType)) {
                    this.t.setLabelType(DMLabelType.LABEL_TYPE_BUYING);
                    this.f.setVisibility(8);
                } else if ("3".equals(waterFlowRecommendItem.tagType)) {
                    this.t.setLabelType(null);
                    this.f.setVisibility(0);
                } else if ("4".equals(waterFlowRecommendItem.tagType)) {
                    this.t.setLabelType(DMLabelType.LABEL_TYPE_NEW_SALE);
                    this.f.setVisibility(8);
                } else {
                    this.t.setLabelType(null);
                    this.f.setVisibility(8);
                }
            }
            this.t.setScoreStar(waterFlowRecommendItem.itemScore);
            this.t.setBorderRadius(0);
            this.t.setVideoIconVisibility(waterFlowRecommendItem.hasVideo ? 0 : 8);
            this.t.setImageUrlForWebp(waterFlowRecommendItem.projectPic, this.r, this.s);
            this.itemView.setTag(waterFlowRecommendItem);
            if (TextUtils.isEmpty(waterFlowRecommendItem.projectName)) {
                this.g.setText("");
            } else {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(waterFlowRecommendItem.projectName);
                try {
                    if (waterFlowRecommendItem.atmospheric) {
                        if (!wh2.j(waterFlowRecommendItem.atmosphericPic)) {
                            cn.damai.common.image.a.b().h(this.a).c(waterFlowRecommendItem.atmosphericPic).n(new c(spannableStringBuilder)).f();
                        }
                    } else {
                        if (waterFlowRecommendItem.projectName.contains("【")) {
                            int indexOf = waterFlowRecommendItem.projectName.indexOf("【");
                            spannableStringBuilder.setSpan(new ImageSpan(this.a, R$drawable.homepage_city_name_left, 1), indexOf, indexOf + 1, 18);
                        }
                        if (waterFlowRecommendItem.projectName.contains("】")) {
                            int indexOf2 = waterFlowRecommendItem.projectName.indexOf("】");
                            spannableStringBuilder.setSpan(new ImageSpan(this.a, R$drawable.homepage_city_name_right, 1), indexOf2, indexOf2 + 1, 18);
                        }
                    }
                } catch (Exception e) {
                    cb1.c("WaterFlowGoodsViewHolder", e.getMessage());
                }
                this.g.setText(spannableStringBuilder);
            }
            if (sx0.a(waterFlowRecommendItem.cardType) == 4) {
                if (!TextUtils.isEmpty(waterFlowRecommendItem.title)) {
                    this.e.setTagType(DMTagType.TAG_TYPE_RANK);
                    this.e.setTagName(waterFlowRecommendItem.title);
                    this.e.setVisibility(0);
                } else {
                    this.e.setVisibility(8);
                }
                this.i.setVisibility(0);
                this.m.setVisibility(8);
                if (!TextUtils.isEmpty(waterFlowRecommendItem.liveStartTime)) {
                    this.h.setText(waterFlowRecommendItem.liveStartTime);
                } else if (wh2.j(waterFlowRecommendItem.projectDatetime)) {
                    this.h.setText("");
                } else {
                    this.h.setText(waterFlowRecommendItem.projectDatetime);
                }
                if (!TextUtils.isEmpty(waterFlowRecommendItem.priceLow) && !waterFlowRecommendItem.priceLow.equals("价格待定") && !waterFlowRecommendItem.priceLow.equals("待定")) {
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(String.format("¥%s", waterFlowRecommendItem.priceLow));
                    spannableStringBuilder2.setSpan(new AbsoluteSizeSpan(t60.a(this.a, 12.0f)), 0, 1, 0);
                    this.j.setText(spannableStringBuilder2);
                    this.l.setVisibility(0);
                    this.k.setVisibility(8);
                } else {
                    this.j.setVisibility(8);
                    this.l.setVisibility(8);
                    this.k.setVisibility(0);
                }
            } else {
                this.e.setVisibility(8);
                this.i.setVisibility(8);
                this.k.setVisibility(8);
                this.m.setVisibility(0);
                if (wh2.j(waterFlowRecommendItem.lotteryDate)) {
                    this.h.setText("");
                } else {
                    this.h.setText(waterFlowRecommendItem.lotteryDate);
                }
                if (!wh2.j(waterFlowRecommendItem.price)) {
                    this.o.setText(waterFlowRecommendItem.price);
                    DMDigitTextView dMDigitTextView = this.o;
                    dMDigitTextView.setPaintFlags(dMDigitTextView.getPaintFlags() | 16);
                    this.n.setVisibility(0);
                } else {
                    this.o.setText("");
                    this.n.setVisibility(4);
                }
                if (wh2.j(waterFlowRecommendItem.priceLow)) {
                    this.p.setVisibility(4);
                } else {
                    this.p.setText(waterFlowRecommendItem.priceLow);
                    this.p.setVisibility(0);
                }
            }
            py0 I = py0.I();
            View view = this.itemView;
            String str = this.q;
            String str2 = waterFlowRecommendItem.projectId;
            I.T(view, str, str2, waterFlowRecommendItem.alg, waterFlowRecommendItem.scm, waterFlowRecommendItem.cardType, str2, waterFlowRecommendItem.index);
            this.b.setVisibility(8);
        }
    }
}
