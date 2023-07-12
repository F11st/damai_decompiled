package cn.damai.category.discountticket.adapter;

import android.view.View;
import android.widget.TextView;
import cn.damai.category.discountticket.adapter.DiscountTicketAdapter;
import cn.damai.category.discountticket.bean.biz.DiscountTipBean;
import cn.damai.homepage.R$id;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class MoreDiscountTipViewHolder extends DiscountTicketAdapter.BaseViewHolder<DiscountTipBean> {
    private static transient /* synthetic */ IpChange $ipChange;
    private TextView a;
    private TextView b;

    public MoreDiscountTipViewHolder(View view) {
        super(view);
        this.a = (TextView) view.findViewById(R$id.more_tip_desc);
        this.b = (TextView) view.findViewById(R$id.tip_title);
    }

    @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.BaseViewHolder
    /* renamed from: b */
    public void a(DiscountTipBean discountTipBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1887525932")) {
            ipChange.ipc$dispatch("-1887525932", new Object[]{this, discountTipBean});
            return;
        }
        this.a.setText(discountTipBean.desc);
        this.b.setText(discountTipBean.title);
    }
}
