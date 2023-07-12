package cn.damai.category.discountticket.adapter;

import android.view.View;
import cn.damai.category.discountticket.adapter.DiscountTicketAdapter;
import cn.damai.category.discountticket.bean.biz.BannerWrap;
import cn.damai.homepage.R$id;
import cn.damai.uikit.banner.sub.XBanner;
import cn.damai.uikit.banner.sub.XIndicator;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public abstract class BannerViewHolder extends DiscountTicketAdapter.BaseViewHolder<BannerWrap> implements XBanner.OnBannerClickListener {
    private static transient /* synthetic */ IpChange $ipChange;
    private XBanner a;

    public BannerViewHolder(View view) {
        super(view);
        this.a = (XBanner) view.findViewById(R$id.banner_view_pager);
        this.a.setListener((XIndicator) view.findViewById(R$id.banner_indicator));
        this.a.setBannerClickListener(this);
    }

    @Override // cn.damai.category.discountticket.adapter.DiscountTicketAdapter.BaseViewHolder
    /* renamed from: b */
    public void a(BannerWrap bannerWrap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1879472733")) {
            ipChange.ipc$dispatch("-1879472733", new Object[]{this, bannerWrap});
        } else {
            this.a.update(bannerWrap.list);
        }
    }
}
