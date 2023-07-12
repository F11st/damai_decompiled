package cn.damai.tetris.component.brand;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.tetris.component.brand.bean.CommonCard;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.t60;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class BrandCouponAdapter extends RecyclerView.Adapter<CardHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private Context a;
    private List<CommonCard> b;
    private View.OnClickListener c;
    private BrandHeaderPresenter d;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public class CardHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        public View a;
        private TextView b;
        private TextView c;
        private TextView d;
        private TextView e;
        private TextView f;
        private TextView g;
        private View h;

        public CardHolder(View view, Context context) {
            super(view);
            BrandCouponAdapter.this.a = context;
            this.b = (TextView) this.itemView.findViewById(R$id.common_card_top_value);
            this.c = (TextView) this.itemView.findViewById(R$id.common_card_top_info);
            this.d = (TextView) this.itemView.findViewById(R$id.item_header_coupon_want);
            this.e = (TextView) this.itemView.findViewById(R$id.common_card_bottom_text);
            this.h = this.itemView.findViewById(R$id.item_header_coupon_got);
            this.a = this.itemView.findViewById(R$id.common_top_space);
            this.f = (TextView) this.itemView.findViewById(R$id.common_card_desc_info);
            this.g = (TextView) this.itemView.findViewById(R$id.common_card_desc_info2);
        }

        public void c(CommonCard commonCard) {
            String str;
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-149319400")) {
                ipChange.ipc$dispatch("-149319400", new Object[]{this, commonCard});
            } else if (commonCard == null) {
            } else {
                this.b.setText(commonCard.decreaseMoneyNum);
                this.c.setText(commonCard.overAmountText);
                this.f.setText(commonCard.name);
                if (BrandCouponAdapter.this.getItemCount() > 1) {
                    this.f.post(new Runnable() { // from class: cn.damai.tetris.component.brand.BrandCouponAdapter.CardHolder.1
                        private static transient /* synthetic */ IpChange $ipChange;

                        @Override // java.lang.Runnable
                        public void run() {
                            IpChange ipChange2 = $ipChange;
                            if (AndroidInstantRuntime.support(ipChange2, "1358462764")) {
                                ipChange2.ipc$dispatch("1358462764", new Object[]{this});
                            } else if (BrandCouponAdapter.this.a == null) {
                            } else {
                                if (CardHolder.this.f.getLayout().getLineCount() > 1) {
                                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) CardHolder.this.f.getLayoutParams();
                                    layoutParams.setMargins(t60.a(BrandCouponAdapter.this.a, 9.0f), t60.a(BrandCouponAdapter.this.a, 9.0f), t60.a(BrandCouponAdapter.this.a, 3.0f), 0);
                                    CardHolder.this.f.setLayoutParams(layoutParams);
                                    return;
                                }
                                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) CardHolder.this.f.getLayoutParams();
                                layoutParams2.setMargins(t60.a(BrandCouponAdapter.this.a, 9.0f), t60.a(BrandCouponAdapter.this.a, 15.0f), t60.a(BrandCouponAdapter.this.a, 3.0f), 0);
                                CardHolder.this.f.setLayoutParams(layoutParams2);
                            }
                        }
                    });
                }
                TextView textView = this.g;
                if (textView != null && (str = commonCard.tag) != null) {
                    textView.setText(str);
                }
                if (commonCard.gainCouponButtonCode == 1) {
                    this.d.setVisibility(8);
                    this.h.setVisibility(0);
                    this.e.setText("已领取");
                    return;
                }
                this.d.setVisibility(0);
                this.h.setVisibility(8);
                if (commonCard.gainCouponButtonCode == 2) {
                    this.d.setText("关注领取");
                } else {
                    this.d.setText("立即领取");
                }
            }
        }
    }

    public BrandCouponAdapter(Context context, String str, String str2, View.OnClickListener onClickListener, BrandHeaderPresenter brandHeaderPresenter) {
        this.a = context;
        this.c = onClickListener;
        this.d = brandHeaderPresenter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: c */
    public void onBindViewHolder(final CardHolder cardHolder, @SuppressLint({"RecyclerView"}) int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-345850230")) {
            ipChange.ipc$dispatch("-345850230", new Object[]{this, cardHolder, Integer.valueOf(i)});
        } else if (cardHolder != null) {
            cardHolder.c(this.b.get(i));
            cardHolder.itemView.setTag(this.b.get(i));
            CommonCard commonCard = this.b.get(i);
            if (commonCard != null && commonCard.gainCouponButtonCode != 1) {
                cardHolder.itemView.setOnClickListener(this.c);
            }
            commonCard.index = i;
            if (getItemCount() == 1) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, t60.a(this.a, 64.0f));
                layoutParams.setMargins(t60.a(this.a, 12.0f), 0, t60.a(this.a, 12.0f), 0);
                cardHolder.itemView.setLayoutParams(layoutParams);
            } else {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) cardHolder.itemView.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new RecyclerView.LayoutParams(-2, -2);
                }
                if (i == getItemCount() - 1) {
                    layoutParams2.setMargins(0, 0, t60.a(this.a, 12.0f), 0);
                } else {
                    layoutParams2.setMargins(0, 0, 0, 0);
                }
                cardHolder.itemView.setLayoutParams(layoutParams2);
                cardHolder.c.post(new Runnable() { // from class: cn.damai.tetris.component.brand.BrandCouponAdapter.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // java.lang.Runnable
                    public void run() {
                        IpChange ipChange2 = $ipChange;
                        if (AndroidInstantRuntime.support(ipChange2, "-430963930")) {
                            ipChange2.ipc$dispatch("-430963930", new Object[]{this});
                        } else if (BrandCouponAdapter.this.a == null) {
                        } else {
                            int lineCount = cardHolder.c.getLayout().getLineCount();
                            View findViewById = cardHolder.itemView.findViewById(R$id.common_card_top_vv);
                            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) findViewById.getLayoutParams();
                            if (lineCount > 1) {
                                layoutParams3.setMargins(0, t60.a(BrandCouponAdapter.this.a, 5.0f), 0, 0);
                                findViewById.setLayoutParams(layoutParams3);
                                return;
                            }
                            layoutParams3.setMargins(0, t60.a(BrandCouponAdapter.this.a, 10.0f), 0, 0);
                            findViewById.setLayoutParams(layoutParams3);
                        }
                    }
                });
            }
            BrandHeaderPresenter brandHeaderPresenter = this.d;
            if (brandHeaderPresenter != null) {
                brandHeaderPresenter.trackExpo(commonCard);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: d */
    public CardHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1494945004")) {
            return (CardHolder) ipChange.ipc$dispatch("1494945004", new Object[]{this, viewGroup, Integer.valueOf(i)});
        }
        LayoutInflater from = LayoutInflater.from(this.a);
        if (getItemCount() == 1) {
            inflate = from.inflate(R$layout.layout_coupon_common_card_w, (ViewGroup) null);
        } else {
            inflate = from.inflate(R$layout.layout_coupon_common_card, (ViewGroup) null);
        }
        return new CardHolder(inflate, this.a);
    }

    public void e(List<CommonCard> list) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1687381494")) {
            ipChange.ipc$dispatch("-1687381494", new Object[]{this, list});
        } else if (list == null || list.size() <= 0) {
        } else {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-438595207")) {
            return ((Integer) ipChange.ipc$dispatch("-438595207", new Object[]{this})).intValue();
        }
        List<CommonCard> list = this.b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
