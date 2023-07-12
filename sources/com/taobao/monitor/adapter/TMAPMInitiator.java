package com.taobao.monitor.adapter;

import android.app.Application;
import java.util.HashMap;
import tb.zp1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class TMAPMInitiator extends AbsAPMInitiator {
    @Override // com.taobao.monitor.adapter.AbsAPMInitiator
    public /* bridge */ /* synthetic */ void init(Application application, HashMap hashMap) {
        super.init(application, hashMap);
    }

    @Override // com.taobao.monitor.adapter.AbsAPMInitiator
    protected void initPage(Application application) {
        zp1.a("com.tmall.wireless.splash.TMSplashActivity");
        zp1.a("com.taobao.bootimage.activity.BootImageActivity");
        zp1.a("com.taobao.linkmanager.AlibcEntranceActivity");
        zp1.a("com.taobao.linkmanager.AlibcOpenActivity");
        zp1.a("com.taobao.linkmanager.AlibcTransparentActivity");
        zp1.a("com.taobao.linkmanager.AlibcWindvaneCompatActivity");
        zp1.a("com.taobao.linkmanager.AlibcAuthActivity");
        zp1.d("com.tmall.wireless.homepage.activity.TMHomePageActivity");
        zp1.d("com.tmall.wireless.detail.ui.TMItemDetailsActivity");
        zp1.d("com.tmall.wireless.maintab.module.TMMainTabActivity");
        zp1.d("com.tmall.wireless.mytmall.ui.TMMtmallActivityA");
        zp1.d("com.tmall.wireless.messagebox.activity.TMMsgboxCategoryActivity");
        zp1.d("com.tmall.wireless.shop.TMShopActivity");
        zp1.d("com.tmall.wireless.minidetail.activity.TMMiniDetailActivity");
        zp1.d("com.taobao.message.accounts.activity.AccountActivity");
        zp1.d("com.taobao.android.shop.activity.ShopHomePageActivity");
        zp1.d("com.taobao.weex.WXActivity");
        zp1.d("com.taobao.android.trade.cart.CartActivity");
        zp1.d("com.tmall.wireless.login.TMLoginActivity");
    }
}
