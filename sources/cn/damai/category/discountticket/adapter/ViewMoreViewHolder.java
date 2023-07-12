package cn.damai.category.discountticket.adapter;

import android.view.View;
import cn.damai.category.discountticket.adapter.DiscountTicketAdapter;
import cn.damai.category.discountticket.bean.biz.ViewMoreBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class ViewMoreViewHolder extends DiscountTicketAdapter.BaseViewHolder<ViewMoreBean> implements View.OnClickListener {
    private static transient /* synthetic */ IpChange $ipChange;

    public ViewMoreViewHolder(View view) {
        super(view);
    }

    @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.BaseViewHolder
    /* renamed from: b */
    public void a(ViewMoreBean viewMoreBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-104252291")) {
            ipChange.ipc$dispatch("-104252291", new Object[]{this, viewMoreBean});
            return;
        }
        this.itemView.setOnClickListener(this);
        d(this.itemView);
    }

    public abstract void c();

    public abstract void d(View view);

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-975944315")) {
            ipChange.ipc$dispatch("-975944315", new Object[]{this, view});
        } else {
            c();
        }
    }
}
