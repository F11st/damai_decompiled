package com.taobao.monitor.adapter;

import android.app.Application;
import com.taobao.android.ab.api.ABGlobal;
import java.util.HashMap;
import tb.rj2;
import tb.sp1;
import tb.zp1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TBAPMInitiator extends AbsAPMInitiator {
    @Override // com.taobao.monitor.adapter.AbsAPMInitiator
    public /* bridge */ /* synthetic */ void init(Application application, HashMap hashMap) {
        super.init(application, hashMap);
    }

    @Override // com.taobao.monitor.adapter.AbsAPMInitiator
    protected void initExpendLauncher(Application application) {
    }

    @Override // com.taobao.monitor.adapter.AbsAPMInitiator
    protected void initPage(Application application) {
        zp1.a("com.taobao.tao.welcome.Welcome");
        zp1.a("com.taobao.bootimage.activity.BootImageActivity");
        zp1.a("com.taobao.linkmanager.afc.TbFlowInActivity");
        zp1.a("com.taobao.tao.detail.activity.DetailActivity");
        zp1.d("com.taobao.tao.homepage.MainActivity3");
        zp1.d("com.taobao.tao.TBMainActivity");
        zp1.d("com.taobao.search.sf.MainSearchResultActivity");
        zp1.d("com.taobao.browser.BrowserActivity");
        zp1.d("com.taobao.android.detail.wrapper.activity.DetailActivity");
        zp1.d("com.taobao.order.detail.ui.OrderDetailActivity");
        zp1.d("com.taobao.message.accounts.activity.AccountActivity");
        zp1.d("com.taobao.android.shop.activity.ShopHomePageActivity");
        zp1.d("com.taobao.weex.WXActivity");
        zp1.d("com.taobao.android.trade.cart.CartActivity");
        zp1.c("com.taobao.android.purchase.TBPurchaseActivity");
        zp1.c("com.taobao.order.detail.ui.OrderDetailActivity");
        zp1.b("com.taobao.android.searchbaseframe.business.srp.viewpager.fragment.SearchNativeFragment", true);
        zp1.b("com.taobao.search.sf.MainSearchResultActivity", true);
        zp1.b("com.taobao.order.list.OrderListActivity", true);
        zp1.b("com.taobao.message.category.MsgCenterCategoryFragment", true);
        zp1.b("com.taobao.android.trade.cart.TabCartFragment", true);
        zp1.b("com.taobao.android.trade.cart.CartActivity", true);
        zp1.b("com.taobao.mytaobao.homepage.MyTaobaoFragment", true);
        zp1.b("TNodeDefaultPageName", true);
        zp1.b("com.taobao.weex.WXActivity", true);
        zp1.b("com.alibaba.aliweex.bundle.WeexPageFragment", true);
        zp1.b("com.taobao.android.detail2.core.framework.NewDetailActivity", true);
        sp1.d("com.taobao.android.purchase.TBPurchaseActivity", 0.28f);
        sp1.d("com.taobao.order.detail.ui.OrderDetailActivity", 0.35f);
        if (ABGlobal.isFeatureOpened(application, "ApmLaunchVisibleCalculateChange") && rj2.j) {
            zp1.b("com.taobao.tao.TBMainActivity", true);
            zp1.b("com.taobao.tao.homepage.HomepageFragment", true);
            sp1.d("com.taobao.tao.TBMainActivity", 0.7f);
            sp1.d("com.taobao.tao.homepage.HomepageFragment", 0.7f);
        }
    }
}
