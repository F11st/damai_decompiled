package com.alibaba.pictures.bricks.coupon.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.pictures.R$id;
import com.alibaba.pictures.R$layout;
import com.alibaba.pictures.bricks.bean.FaqBean;
import com.alibaba.pictures.bricks.coupon.order.bean.OrderDetail;
import com.alibaba.pictures.bricks.coupon.view.CouponQuestionViewHolder;
import com.alibaba.pictures.bricks.util.TComparator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.google.android.flexbox.FlexboxLayout;
import java.util.ArrayList;
import kotlin.collections.C8214m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.ap2;
import tb.b41;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class CouponQuestionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, TComparator<String> {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    private final OnFagActionListener a;
    @NotNull
    private final FlexboxLayout b;
    @NotNull
    private final View c;
    @NotNull
    private final ArrayList<String> d;
    @Nullable
    private FaqBean e;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.pictures.bricks.coupon.view.CouponQuestionViewHolder$a */
    /* loaded from: classes7.dex */
    public static final class C3521a {
        private static transient /* synthetic */ IpChange $ipChange;
        @NotNull
        private final String a;
        private final int b;

        public C3521a(@NotNull String str, int i) {
            b41.i(str, "question");
            this.a = str;
            this.b = i;
        }

        public final int a() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "-1167722847") ? ((Integer) ipChange.ipc$dispatch("-1167722847", new Object[]{this})).intValue() : this.b;
        }

        @NotNull
        public final String b() {
            IpChange ipChange = $ipChange;
            return AndroidInstantRuntime.support(ipChange, "681464303") ? (String) ipChange.ipc$dispatch("681464303", new Object[]{this}) : this.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CouponQuestionViewHolder(@NotNull ViewGroup viewGroup, @NotNull OnFagActionListener onFagActionListener) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.bricks_coupon_question_view, viewGroup, false));
        b41.i(viewGroup, "parent");
        b41.i(onFagActionListener, "itemActionListener");
        this.a = onFagActionListener;
        View findViewById = this.itemView.findViewById(R$id.id_bricks_cq_questions_flex);
        b41.h(findViewById, "itemView.findViewById(R.…bricks_cq_questions_flex)");
        this.b = (FlexboxLayout) findViewById;
        View findViewById2 = this.itemView.findViewById(R$id.id_bricks_cq_all_btn);
        b41.h(findViewById2, "itemView.findViewById(R.id.id_bricks_cq_all_btn)");
        this.c = findViewById2;
        this.d = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(CouponQuestionViewHolder couponQuestionViewHolder, View view) {
        OrderDetail orderBean;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-204620153")) {
            ipChange.ipc$dispatch("-204620153", new Object[]{couponQuestionViewHolder, view});
            return;
        }
        b41.i(couponQuestionViewHolder, "this$0");
        FaqBean faqBean = couponQuestionViewHolder.e;
        if (faqBean == null || (orderBean = faqBean.getOrderBean()) == null) {
            return;
        }
        couponQuestionViewHolder.a.onFagAllClick(orderBean);
    }

    public final void b(@NotNull FaqBean faqBean, int i) {
        ArrayList<String> faqList;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1534725445")) {
            ipChange.ipc$dispatch("1534725445", new Object[]{this, faqBean, Integer.valueOf(i)});
            return;
        }
        b41.i(faqBean, "faqBean");
        this.e = faqBean;
        if (ap2.INSTANCE.f(this.d, faqBean.getFaqList(), this)) {
            return;
        }
        this.d.clear();
        FaqBean faqBean2 = this.e;
        if (faqBean2 != null && (faqList = faqBean2.getFaqList()) != null) {
            for (String str : faqList) {
                this.d.add(str);
            }
        }
        this.b.removeAllViews();
        int i2 = 0;
        for (Object obj : this.d) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                C8214m.p();
            }
            String str2 = (String) obj;
            View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.bricks_coupon_one_question_view, (ViewGroup) this.b, false);
            inflate.setTag(new C3521a(str2, i2));
            inflate.setOnClickListener(this);
            TextView textView = (TextView) inflate.findViewById(R$id.id_bricks_coq_tv);
            if (textView != null) {
                textView.setText(str2);
            }
            this.b.addView(inflate);
            OnFagActionListener onFagActionListener = this.a;
            b41.h(inflate, "this");
            FaqBean faqBean3 = this.e;
            onFagActionListener.onItemExpose(inflate, str2, faqBean3 != null ? faqBean3.getOrderBean() : null, i2);
            i2 = i3;
        }
        this.c.setOnClickListener(new View.OnClickListener() { // from class: tb.hp
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CouponQuestionViewHolder.c(CouponQuestionViewHolder.this, view);
            }
        });
    }

    @Override // com.alibaba.pictures.bricks.util.TComparator
    /* renamed from: d */
    public boolean same(@Nullable String str, @Nullable String str2) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1621664393") ? ((Boolean) ipChange.ipc$dispatch("1621664393", new Object[]{this, str, str2})).booleanValue() : TextUtils.equals(str, str2);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        OrderDetail orderBean;
        Object tag;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "987586696")) {
            ipChange.ipc$dispatch("987586696", new Object[]{this, view});
            return;
        }
        FaqBean faqBean = this.e;
        if (faqBean == null || (orderBean = faqBean.getOrderBean()) == null || view == null || (tag = view.getTag()) == null || !(tag instanceof C3521a)) {
            return;
        }
        C3521a c3521a = (C3521a) tag;
        this.a.onItemClick(view, c3521a.b(), orderBean, c3521a.a());
    }
}
