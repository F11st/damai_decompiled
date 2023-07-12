package cn.damai.mine.adapter;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cn.damai.common.nav.DMNav;
import cn.damai.common.nav.NavUri;
import cn.damai.common.user.C0529c;
import cn.damai.homepage.R$color;
import cn.damai.homepage.R$drawable;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.mine.bean.CouponData;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import tb.cs;
import tb.vf1;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class CouponListNewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static transient /* synthetic */ IpChange $ipChange;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private Context f;
    private List<CouponData.Coupon> g;

    /* compiled from: Taobao */
    /* loaded from: classes6.dex */
    public class CouponsViewHolder extends RecyclerView.ViewHolder {
        private static transient /* synthetic */ IpChange $ipChange;
        TextView a;
        TextView b;
        TextView c;
        TextView d;
        TextView e;
        LinearLayout f;
        TextView g;

        /* compiled from: Taobao */
        /* renamed from: cn.damai.mine.adapter.CouponListNewAdapter$CouponsViewHolder$a */
        /* loaded from: classes15.dex */
        public class View$OnClickListenerC1421a implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ CouponData.Coupon a;
            final /* synthetic */ int b;

            View$OnClickListenerC1421a(CouponData.Coupon coupon, int i) {
                this.a = coupon;
                this.b = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "-913144223")) {
                    ipChange.ipc$dispatch("-913144223", new Object[]{this, view});
                } else if (this.a == null) {
                } else {
                    C0529c.e().x(vf1.x().E(this.a.id, this.b));
                    if (!TextUtils.isEmpty(this.a.useCouponUrlMobile)) {
                        DMNav.from(CouponListNewAdapter.this.f).toUri(this.a.useCouponUrlMobile);
                        return;
                    }
                    Bundle bundle = new Bundle();
                    if (TextUtils.isEmpty(this.a.unLimitItem) || this.a.unLimitItem.equals("false")) {
                        bundle.putString("favourableId", "12-" + this.a.subCouponActId);
                    }
                    if (TextUtils.isEmpty(this.a.tag)) {
                        bundle.putString("favourableTag", this.a.overAmountText);
                    } else {
                        bundle.putString("favourableTag", this.a.tag);
                    }
                    bundle.putString("hint", "筛选可使用优惠券的项目");
                    DMNav.from(CouponListNewAdapter.this.f).withExtras(bundle).toUri(NavUri.b("search_result"));
                }
            }
        }

        /* compiled from: Taobao */
        /* renamed from: cn.damai.mine.adapter.CouponListNewAdapter$CouponsViewHolder$b */
        /* loaded from: classes15.dex */
        public class View$OnClickListenerC1422b implements View.OnClickListener {
            private static transient /* synthetic */ IpChange $ipChange;
            final /* synthetic */ CouponData.Coupon a;

            View$OnClickListenerC1422b(CouponData.Coupon coupon) {
                this.a = coupon;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange = $ipChange;
                if (AndroidInstantRuntime.support(ipChange, "1198146146")) {
                    ipChange.ipc$dispatch("1198146146", new Object[]{this, view});
                } else if (CouponListNewAdapter.this.a != 0 || this.a == null) {
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("coupon", this.a);
                    DMNav.from(CouponListNewAdapter.this.f).forResult(1000).withExtras(bundle).toUri(cs.c());
                }
            }
        }

        public CouponsViewHolder(Context context) {
            super(LayoutInflater.from(context).inflate(R$layout.list_item_coupon, (ViewGroup) null));
            this.itemView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
            b(this.itemView);
        }

        private void b(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "327875620")) {
                ipChange.ipc$dispatch("327875620", new Object[]{this, view});
                return;
            }
            this.a = (TextView) view.findViewById(R$id.tv_coupon_num);
            this.b = (TextView) view.findViewById(R$id.tv_coupon_tag);
            this.c = (TextView) view.findViewById(R$id.tv_coupon_title);
            this.d = (TextView) view.findViewById(R$id.tv_coupon_channel);
            this.e = (TextView) view.findViewById(R$id.tv_coupon_time);
            this.f = (LinearLayout) view.findViewById(R$id.ll_coupon_user);
            this.g = (TextView) view.findViewById(R$id.tv_coupon_user);
        }

        private void c(int i, boolean z, boolean z2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1014114492")) {
                ipChange.ipc$dispatch("1014114492", new Object[]{this, Integer.valueOf(i), Boolean.valueOf(z), Boolean.valueOf(z2)});
            } else if (i == 0) {
                if (z) {
                    this.g.setText("去使用");
                    if (z2) {
                        this.g.setBackgroundResource(R$drawable.bg_border_red_trans);
                        this.g.setTextColor(CouponListNewAdapter.this.b);
                        this.f.setEnabled(true);
                    } else {
                        d();
                    }
                }
                this.a.setTextColor(CouponListNewAdapter.this.b);
                this.c.setTextColor(CouponListNewAdapter.this.c);
            } else if (i == 1) {
                if (z) {
                    this.g.setText("已过期");
                    d();
                }
                this.a.setTextColor(CouponListNewAdapter.this.d);
                this.c.setTextColor(CouponListNewAdapter.this.d);
            } else if (i == 2) {
                if (z) {
                    this.g.setText("已使用");
                    d();
                }
                this.a.setTextColor(CouponListNewAdapter.this.d);
                this.c.setTextColor(CouponListNewAdapter.this.d);
            } else {
                this.g.setText("");
            }
        }

        private void d() {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1096405135")) {
                ipChange.ipc$dispatch("-1096405135", new Object[]{this});
                return;
            }
            this.g.setTextColor(CouponListNewAdapter.this.e);
            this.g.setBackgroundResource(R$drawable.bg_border_gray_trans);
            this.f.setEnabled(false);
        }

        public void a(CouponData.Coupon coupon, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "706289370")) {
                ipChange.ipc$dispatch("706289370", new Object[]{this, coupon, Integer.valueOf(i)});
            } else if (coupon == null) {
            } else {
                String str = coupon.decreaseMoneyTag;
                if (TextUtils.isEmpty(str)) {
                    this.a.setText("");
                } else {
                    SpannableString spannableString = new SpannableString(str);
                    spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, 1, 33);
                    this.a.setText(spannableString);
                }
                if (TextUtils.isEmpty(coupon.overAmountText)) {
                    this.b.setVisibility(4);
                } else {
                    this.b.setVisibility(0);
                    this.b.setText(coupon.overAmountText);
                }
                this.c.setText(coupon.name);
                int i2 = CouponListNewAdapter.this.a;
                if (i2 == 0 || i2 == 1) {
                    if (!wh2.j(coupon.effectiveTimeText)) {
                        this.e.setVisibility(0);
                        TextView textView = this.e;
                        textView.setText("有效期:" + coupon.effectiveTimeText);
                    } else {
                        this.e.setVisibility(4);
                    }
                } else if (i2 == 2) {
                    if (!wh2.j(coupon.usedTimeStr)) {
                        this.e.setVisibility(0);
                        TextView textView2 = this.e;
                        textView2.setText("使用时间:" + coupon.usedTimeStr);
                    } else {
                        this.e.setVisibility(4);
                    }
                }
                if (TextUtils.isEmpty(coupon.itemChannelUsableStatus)) {
                    this.d.setVisibility(4);
                    this.f.setVisibility(8);
                    c(CouponListNewAdapter.this.a, false, false);
                } else if (coupon.itemChannelUsableStatus.equals("1")) {
                    this.d.setVisibility(4);
                    this.f.setVisibility(0);
                    c(CouponListNewAdapter.this.a, true, true);
                } else if (coupon.itemChannelUsableStatus.equals("2")) {
                    this.d.setVisibility(0);
                    this.d.setText("当前渠道不可用");
                    this.f.setVisibility(0);
                    c(CouponListNewAdapter.this.a, true, false);
                } else if (coupon.itemChannelUsableStatus.equals("3")) {
                    this.d.setVisibility(0);
                    this.d.setText("当前时间不可用");
                    this.f.setVisibility(0);
                    c(CouponListNewAdapter.this.a, true, false);
                } else {
                    this.d.setVisibility(4);
                    this.f.setVisibility(8);
                    c(CouponListNewAdapter.this.a, false, false);
                }
                this.f.setOnClickListener(new View$OnClickListenerC1421a(coupon, i));
                this.itemView.setOnClickListener(new View$OnClickListenerC1422b(coupon));
            }
        }
    }

    public CouponListNewAdapter(Context context, int i, List<CouponData.Coupon> list) {
        this.f = context;
        this.a = i;
        this.b = context.getResources().getColor(R$color.main_color);
        this.c = this.f.getResources().getColor(R$color.color_111111);
        this.d = this.f.getResources().getColor(R$color.color_888888);
        this.e = this.f.getResources().getColor(R$color.color_DDDDDD);
        this.g = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-488747338") ? ((Integer) ipChange.ipc$dispatch("-488747338", new Object[]{this})).intValue() : wh2.e(this.g);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1862783869")) {
            ipChange.ipc$dispatch("-1862783869", new Object[]{this, viewHolder, Integer.valueOf(i)});
        } else {
            ((CouponsViewHolder) viewHolder).a(this.g.get(i), i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-741549869") ? (RecyclerView.ViewHolder) ipChange.ipc$dispatch("-741549869", new Object[]{this, viewGroup, Integer.valueOf(i)}) : new CouponsViewHolder(this.f);
    }
}
