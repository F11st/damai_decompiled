package cn.damai.commonbusiness.scriptmurder.shopdetail;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.user.C0525a;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity;
import cn.damai.commonbusiness.scriptmurder.shopdetail.ShopDetailActivity;
import cn.damai.commonbusiness.share.ShareManager;
import cn.damai.commonbusiness.view.StopAbleViewFlipper;
import com.alibaba.pictures.bricks.bean.OrderItem;
import com.alibaba.pictures.bricks.bean.ShareInfoBean;
import com.alibaba.pictures.bricks.bean.ShopInfoBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.arch.v3.core.ModelValue;
import com.youku.arch.v3.core.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.cb2;
import tb.k50;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class ShopDetailActivity extends CommonNavbarActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    @NotNull
    public static final C0801a Companion = new C0801a(null);
    @NotNull
    public static final String STORE_ID = "storeId";
    @NotNull
    public static final String TAG = "ShopDetailActivity";
    public StopAbleViewFlipper flipper;
    private boolean hasBanner;
    @NotNull
    private final AtomicBoolean mHasPaused = new AtomicBoolean(false);
    private boolean playFinished;
    public ShopDetailFragment shopDetailFragment;
    @Nullable
    private ShopInfoBean shopInfoBean;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.commonbusiness.scriptmurder.shopdetail.ShopDetailActivity$a */
    /* loaded from: classes4.dex */
    public static final class C0801a {
        private C0801a() {
        }

        public /* synthetic */ C0801a(k50 k50Var) {
            this();
        }
    }

    private final void initFlipper() {
        ArrayList<OrderItem> orders;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1343934795")) {
            ipChange.ipc$dispatch("1343934795", new Object[]{this});
            return;
        }
        ShopInfoBean shopInfoBean = this.shopInfoBean;
        if (shopInfoBean != null) {
            if (cb2.d(shopInfoBean != null ? shopInfoBean.getOrders() : null) || this.playFinished) {
                return;
            }
            getFlipper().removeAllViews();
            getFlipper().setChangeListener(new StopAbleViewFlipper.ChangeListener() { // from class: tb.bc2
                @Override // cn.damai.commonbusiness.view.StopAbleViewFlipper.ChangeListener
                public final void onViewEnd() {
                    ShopDetailActivity.m19initFlipper$lambda10(ShopDetailActivity.this);
                }
            });
            StopAbleViewFlipper flipper = getFlipper();
            flipper.setVisibility(8);
            ShopInfoBean shopInfoBean2 = this.shopInfoBean;
            if (shopInfoBean2 == null || (orders = shopInfoBean2.getOrders()) == null) {
                return;
            }
            for (OrderItem orderItem : orders) {
                View inflate = LayoutInflater.from(flipper.getContext()).inflate(R$layout.item_info_shopdetail_order_info, (ViewGroup) null);
                ((TextView) inflate.findViewById(R$id.common_navbar_info_title)).setText(orderItem.getNickName() + ' ' + orderItem.getText());
                ((TextView) inflate.findViewById(R$id.common_navbar_info_desc)).setText(orderItem.getTime());
                flipper.addView(inflate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initFlipper$lambda-10  reason: not valid java name */
    public static final void m19initFlipper$lambda10(ShopDetailActivity shopDetailActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "355881583")) {
            ipChange.ipc$dispatch("355881583", new Object[]{shopDetailActivity});
            return;
        }
        b41.i(shopDetailActivity, "this$0");
        StopAbleViewFlipper flipper = shopDetailActivity.getFlipper();
        flipper.stopFlipping();
        flipper.removeAllViews();
        flipper.setVisibility(8);
        shopDetailActivity.playFinished = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onRefresh$lambda-13  reason: not valid java name */
    public static final void m20onRefresh$lambda13(ShopDetailActivity shopDetailActivity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1917303920")) {
            ipChange.ipc$dispatch("1917303920", new Object[]{shopDetailActivity});
            return;
        }
        b41.i(shopDetailActivity, "this$0");
        shopDetailActivity.initFlipper();
    }

    private final void startFlipAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1459843979")) {
            ipChange.ipc$dispatch("1459843979", new Object[]{this});
            return;
        }
        getFlipper().setVisibility(0);
        getFlipper().startFlipping();
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void addFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "628226042")) {
            ipChange.ipc$dispatch("628226042", new Object[]{this});
            return;
        }
        String stringExtra = getIntent().getStringExtra("storeId");
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        setShopDetailFragment(new ShopDetailFragment());
        ShopDetailFragment shopDetailFragment = getShopDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("storeId", stringExtra);
        shopDetailFragment.setArguments(bundle);
        beginTransaction.add(R$id.container, getShopDetailFragment());
        beginTransaction.commit();
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void addUtPage() {
        String stringExtra;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1654715644")) {
            ipChange.ipc$dispatch("1654715644", new Object[]{this});
            return;
        }
        HashMap hashMap = new HashMap();
        Intent intent = getIntent();
        if (intent != null && (stringExtra = intent.getStringExtra("storeId")) != null) {
            hashMap.put("store_id", stringExtra);
        }
        setDamaiUTKeyBuilder(new C0525a.C0527b().i("scriptkill_store").a(z20.d()).j(hashMap));
    }

    @NotNull
    public final StopAbleViewFlipper getFlipper() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-467576046")) {
            return (StopAbleViewFlipper) ipChange.ipc$dispatch("-467576046", new Object[]{this});
        }
        StopAbleViewFlipper stopAbleViewFlipper = this.flipper;
        if (stopAbleViewFlipper != null) {
            return stopAbleViewFlipper;
        }
        b41.A("flipper");
        return null;
    }

    public final boolean getHasBanner() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1448165459") ? ((Boolean) ipChange.ipc$dispatch("1448165459", new Object[]{this})).booleanValue() : this.hasBanner;
    }

    public final boolean getPlayFinished() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "168376563") ? ((Boolean) ipChange.ipc$dispatch("168376563", new Object[]{this})).booleanValue() : this.playFinished;
    }

    @NotNull
    public final ShopDetailFragment getShopDetailFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-62014020")) {
            return (ShopDetailFragment) ipChange.ipc$dispatch("-62014020", new Object[]{this});
        }
        ShopDetailFragment shopDetailFragment = this.shopDetailFragment;
        if (shopDetailFragment != null) {
            return shopDetailFragment;
        }
        b41.A("shopDetailFragment");
        return null;
    }

    @Nullable
    public final ShopInfoBean getShopInfoBean() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1058144867") ? (ShopInfoBean) ipChange.ipc$dispatch("1058144867", new Object[]{this}) : this.shopInfoBean;
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void initBaseInfo(@NotNull Object obj) {
        Node node;
        List<Node> children;
        boolean z;
        Object obj2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1298690260")) {
            ipChange.ipc$dispatch("-1298690260", new Object[]{this, obj});
            return;
        }
        b41.i(obj, "bean");
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        if (hashMap != null && (obj2 = hashMap.get("value")) != null) {
            this.shopInfoBean = obj2 instanceof ShopInfoBean ? (ShopInfoBean) obj2 : null;
        }
        ModelValue property = getShopDetailFragment().getPageContainer().getProperty();
        b41.g(property, "null cannot be cast to non-null type com.youku.arch.v3.core.Node");
        List<Node> children2 = property.getChildren();
        if (children2 != null) {
            if (children2.isEmpty()) {
                children2 = null;
            }
            if (children2 != null && (node = children2.get(0)) != null && (children = node.getChildren()) != null) {
                List<Node> list = children.isEmpty() ? null : children;
                if (list != null) {
                    for (Node node2 : list) {
                        if (node2.getType() == 9994 && node2.getChildren() != null) {
                            List<Node> children3 = node2.getChildren();
                            b41.f(children3);
                            if (children3.size() > 0) {
                                z = true;
                                this.hasBanner = z;
                            }
                        }
                        z = false;
                        this.hasBanner = z;
                    }
                }
            }
        }
        if (this.hasBanner) {
            return;
        }
        starAnim();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity, cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-140914448")) {
            ipChange.ipc$dispatch("-140914448", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        View findViewById = findViewById(R$id.common_navbar_info_flipper);
        b41.g(findViewById, "null cannot be cast to non-null type cn.damai.commonbusiness.view.StopAbleViewFlipper");
        setFlipper((StopAbleViewFlipper) findViewById);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2141510096")) {
            ipChange.ipc$dispatch("-2141510096", new Object[]{this});
            return;
        }
        super.onDestroy();
        getFlipper().stopFlipping();
        getFlipper().removeAllViews();
        getFlipper().setChangeListener(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1471006708")) {
            ipChange.ipc$dispatch("1471006708", new Object[]{this});
            return;
        }
        super.onPause();
        if (getFlipper().isFlipping()) {
            this.mHasPaused.compareAndSet(false, true);
            stopAnim();
        }
    }

    public final void onRefresh() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "371538863")) {
            ipChange.ipc$dispatch("371538863", new Object[]{this});
            return;
        }
        this.playFinished = false;
        runOnUiThread(new Runnable() { // from class: tb.cc2
            @Override // java.lang.Runnable
            public final void run() {
                ShopDetailActivity.m20onRefresh$lambda13(ShopDetailActivity.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "4354195")) {
            ipChange.ipc$dispatch("4354195", new Object[]{this});
            return;
        }
        super.onResume();
        if (this.mHasPaused.get()) {
            this.mHasPaused.compareAndSet(true, false);
            starAnim();
        }
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void onShareClick() {
        ShareInfoBean shareDO;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-8132393")) {
            ipChange.ipc$dispatch("-8132393", new Object[]{this});
            return;
        }
        ShopInfoBean shopInfoBean = this.shopInfoBean;
        if (shopInfoBean != null) {
            b41.f(shopInfoBean);
            if (shopInfoBean.getShareDO() == null) {
                return;
            }
            Bundle bundle = new Bundle();
            ShopInfoBean shopInfoBean2 = this.shopInfoBean;
            if (shopInfoBean2 != null && (shareDO = shopInfoBean2.getShareDO()) != null) {
                bundle.putString("title", shareDO.getShareTitle());
                bundle.putString("message", shareDO.getShareSubTitle());
                bundle.putString("imageurl", shareDO.getShareImage());
                bundle.putString("producturl", shareDO.getShareUrl());
            }
            ShareManager.E().T(this, bundle, getWindow().getDecorView());
            ShareManager.E().l0();
        }
    }

    public final void setFlipper(@NotNull StopAbleViewFlipper stopAbleViewFlipper) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1330477426")) {
            ipChange.ipc$dispatch("1330477426", new Object[]{this, stopAbleViewFlipper});
            return;
        }
        b41.i(stopAbleViewFlipper, "<set-?>");
        this.flipper = stopAbleViewFlipper;
    }

    public final void setHasBanner(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112059097")) {
            ipChange.ipc$dispatch("112059097", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.hasBanner = z;
        }
    }

    public final void setPlayFinished(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-618976047")) {
            ipChange.ipc$dispatch("-618976047", new Object[]{this, Boolean.valueOf(z)});
        } else {
            this.playFinished = z;
        }
    }

    public final void setShopDetailFragment(@NotNull ShopDetailFragment shopDetailFragment) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2091110102")) {
            ipChange.ipc$dispatch("2091110102", new Object[]{this, shopDetailFragment});
            return;
        }
        b41.i(shopDetailFragment, "<set-?>");
        this.shopDetailFragment = shopDetailFragment;
    }

    public final void setShopInfoBean(@Nullable ShopInfoBean shopInfoBean) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-315436707")) {
            ipChange.ipc$dispatch("-315436707", new Object[]{this, shopInfoBean});
        } else {
            this.shopInfoBean = shopInfoBean;
        }
    }

    public final void starAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1562283876")) {
            ipChange.ipc$dispatch("-1562283876", new Object[]{this});
            return;
        }
        if (getFlipper().getChildCount() == 0) {
            initFlipper();
        }
        startFlipAnim();
    }

    public void startWithCheck() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1247258145")) {
            ipChange.ipc$dispatch("-1247258145", new Object[]{this});
        } else if (this.flipper == null || (this.hasBanner && !getFlipper().isFlipping())) {
            starAnim();
        }
    }

    public final void stopAnim() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-287495956")) {
            ipChange.ipc$dispatch("-287495956", new Object[]{this});
            return;
        }
        View currentView = getFlipper().getCurrentView();
        if (currentView != null) {
            currentView.setVisibility(8);
        }
        getFlipper().stopFlipping();
    }

    public void stopWithCheck() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "454511659")) {
            ipChange.ipc$dispatch("454511659", new Object[]{this});
        } else if (this.hasBanner) {
            stopAnim();
        }
    }
}
