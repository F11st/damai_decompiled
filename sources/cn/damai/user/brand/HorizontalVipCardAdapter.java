package cn.damai.user.brand;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.user.C0529c;
import cn.damai.uikit.R$id;
import cn.damai.uikit.R$layout;
import cn.damai.user.brand.bean.VipCard;
import com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.List;
import tb.m62;
import tb.t60;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class HorizontalVipCardAdapter extends RecyclerView.Adapter<CardHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<VipCard> b;
    private View.OnClickListener c;
    private String d;
    private String e;
    HashMap<String, String> f;

    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public class CardHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        private TextView a;
        private TextView b;
        private TextView c;
        private TextView d;
        private View e;
        public View f;

        public CardHolder(HorizontalVipCardAdapter horizontalVipCardAdapter, View view, Context context) {
            super(view);
            horizontalVipCardAdapter.a = context;
            this.a = (TextView) this.itemView.findViewById(R$id.vip_card_top_value);
            this.b = (TextView) this.itemView.findViewById(R$id.vip_card_top_info);
            this.c = (TextView) this.itemView.findViewById(R$id.item_header_coupon_got);
            this.d = (TextView) this.itemView.findViewById(R$id.vip_card_bottom_text);
            this.e = this.itemView.findViewById(R$id.item_header_coupon_want);
            this.f = this.itemView.findViewById(R$id.vip_top_space);
        }

        public void a(VipCard vipCard) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "296733748")) {
                ipChange.ipc$dispatch("296733748", new Object[]{this, vipCard});
            } else if (vipCard == null) {
            } else {
                this.a.setText(vipCard.decreaseMoneyNum);
                this.b.setText(vipCard.overAmountText);
                int i = vipCard.gainCouponButtonCode;
                if (i != 2 && i != 3) {
                    this.e.setVisibility(0);
                    this.c.setVisibility(8);
                    this.d.setText(vipCard.gainCouponButtonText);
                    return;
                }
                this.e.setVisibility(8);
                this.c.setVisibility(0);
                this.c.setText(vipCard.gainCouponButtonText);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: b */
    public void onBindViewHolder(CardHolder cardHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1137179638")) {
            ipChange.ipc$dispatch("-1137179638", new Object[]{this, cardHolder, Integer.valueOf(i)});
        } else if (cardHolder != null) {
            cardHolder.a(this.b.get(i));
            cardHolder.itemView.setTag(this.b.get(i));
            cardHolder.itemView.setOnClickListener(this.c);
            this.b.get(i).index = i;
            this.f.clear();
            this.f.put("usercode", z20.E());
            this.f.put("biz_id", this.d);
            this.f.put("biz_type", this.e);
            this.f.put("coupon_id", this.b.get(i).cardObjId);
            C0529c e = C0529c.e();
            View view = cardHolder.itemView;
            e.G(view, "item_" + i, "coupon", "brand", this.f);
            if (getItemCount() == 1) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, t60.a(this.a, 88.0f));
                layoutParams.setMargins(t60.a(this.a, 16.0f), 0, t60.a(this.a, 16.0f), 0);
                cardHolder.itemView.setLayoutParams(layoutParams);
            }
            if (getItemCount() > 1) {
                if (i == 0) {
                    cardHolder.f.setVisibility(0);
                } else {
                    cardHolder.f.setVisibility(8);
                }
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((DisplayMetrics.getwidthPixels(m62.b(this.a)) - t60.a(this.a, 35.0f)) / 2, t60.a(this.a, 88.0f));
                layoutParams2.setMargins(0, 0, t60.a(this.a, 3.0f), 0);
                cardHolder.itemView.findViewById(cn.damai.homepage.R$id.brand_banner).setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public CardHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "368439148")) {
            return (CardHolder) ipChange.ipc$dispatch("368439148", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (getItemCount() == 1) {
            inflate = from.inflate(R$layout.layout_uikit_vip_card_w, (ViewGroup) null);
        } else {
            inflate = from.inflate(R$layout.layout_uikit_vip_card, (ViewGroup) null);
        }
        return new CardHolder(this, inflate, this.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-781835911")) {
            return ((Integer) ipChange.ipc$dispatch("-781835911", new Object[]{this})).intValue();
        }
        List<VipCard> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
