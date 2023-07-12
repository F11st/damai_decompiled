package cn.damai.category.discountticket.adapter;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import cn.damai.category.discountticket.adapter.DiscountTicketAdapter;
import cn.damai.category.discountticket.bean.CouponActivityBean;
import cn.damai.category.discountticket.bean.HeaderCouponBean;
import cn.damai.homepage.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import java.util.List;
import tb.wh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class HeaderCouponViewHolder extends DiscountTicketAdapter.BaseViewHolder<HeaderCouponBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private final TextView a;
    private final TextView b;
    private HeaderCouponBean c;
    private List<b> d;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "599279435")) {
                ipChange.ipc$dispatch("599279435", new Object[]{this, view});
                return;
            }
            HeaderCouponViewHolder headerCouponViewHolder = HeaderCouponViewHolder.this;
            headerCouponViewHolder.f(headerCouponViewHolder.c);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;
        private View a;
        private TextView b;
        private TextView c;
        private View d;
        private TextView e;
        private CouponActivityBean f;

        public b(View view) {
            this.a = view;
            this.c = (TextView) view.findViewById(R$id.item_header_coupon_price);
            this.b = (TextView) view.findViewById(R$id.item_header_coupon_desc);
            this.d = view.findViewById(R$id.item_header_coupon_got);
            this.e = (TextView) view.findViewById(R$id.item_header_coupon_get);
        }

        public void a(CouponActivityBean couponActivityBean, int i) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1960211597")) {
                ipChange.ipc$dispatch("1960211597", new Object[]{this, couponActivityBean, Integer.valueOf(i)});
                return;
            }
            this.f = couponActivityBean;
            if (couponActivityBean == null) {
                this.a.setVisibility(4);
                this.a.setOnClickListener(null);
                return;
            }
            this.a.setVisibility(0);
            this.a.setOnClickListener(this);
            this.b.setText(couponActivityBean.getOverAmountText());
            this.c.setText(couponActivityBean.getDecreaseMoneyNum());
            if (couponActivityBean.isCanApply()) {
                this.e.setTextColor(Color.parseColor("#ff2869"));
                this.e.setVisibility(0);
                this.d.setVisibility(8);
            } else if (couponActivityBean.isGotCoupon()) {
                this.d.setVisibility(0);
                this.e.setVisibility(8);
            } else {
                this.d.setVisibility(8);
                this.e.setTextColor(Color.parseColor("#cccccc"));
                this.e.setVisibility(0);
            }
            HeaderCouponViewHolder.this.d(this.a, i, couponActivityBean.id);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1597403634")) {
                ipChange.ipc$dispatch("1597403634", new Object[]{this, view});
            } else if (this.f == null || HeaderCouponViewHolder.this.c == null) {
            } else {
                HeaderCouponViewHolder headerCouponViewHolder = HeaderCouponViewHolder.this;
                headerCouponViewHolder.e(headerCouponViewHolder.c, this.f);
            }
        }
    }

    public HeaderCouponViewHolder(View view) {
        super(view);
        this.d = new ArrayList();
        this.a = (TextView) view.findViewById(R$id.item_header_title);
        this.b = (TextView) view.findViewById(R$id.item_header_desc);
        View findViewById = view.findViewById(R$id.item_header_coupon_1);
        View findViewById2 = view.findViewById(R$id.item_header_coupon_2);
        this.d.add(new b(findViewById));
        this.d.add(new b(findViewById2));
    }

    private SpannableStringBuilder g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1651126082")) {
            return (SpannableStringBuilder) ipChange.ipc$dispatch("1651126082", new Object[]{this, str});
        }
        try {
            String str2 = str + " 使用规则>";
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#30AEFF")), str2.length() - 5, str2.length(), 33);
            return spannableStringBuilder;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.BaseViewHolder
    /* renamed from: c */
    public void a(HeaderCouponBean headerCouponBean) {
        IpChange ipChange = $ipChange;
        int i = 0;
        if (AndroidInstantRuntime.support(ipChange, "-607885991")) {
            ipChange.ipc$dispatch("-607885991", new Object[]{this, headerCouponBean});
            return;
        }
        this.c = headerCouponBean;
        this.a.setText(headerCouponBean.title);
        String str = headerCouponBean.desc;
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(headerCouponBean.h5Url)) {
                this.b.setText(str);
            } else {
                SpannableStringBuilder g = g(str);
                if (g != null) {
                    this.b.setText(g);
                } else {
                    this.b.setText(str);
                }
                this.b.setOnClickListener(new a());
            }
        } else {
            this.b.setText((CharSequence) null);
        }
        List<CouponActivityBean> list = this.c.couponActivities;
        int e = wh2.e(list);
        while (i < this.d.size()) {
            int i2 = i + 1;
            this.d.get(i).a(i2 <= e ? list.get(i) : null, i);
            i = i2;
        }
    }

    public abstract void d(View view, int i, String str);

    public abstract void e(@NonNull HeaderCouponBean headerCouponBean, @NonNull CouponActivityBean couponActivityBean);

    public abstract void f(HeaderCouponBean headerCouponBean);
}
