package cn.damai.commonbusiness.scriptmurder.venuedetail;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.R$drawable;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity;
import cn.damai.commonbusiness.share.ShareManager;
import com.alibaba.pictures.bricks.bean.ShareInfoBean;
import com.alibaba.pictures.bricks.bean.VenueInfoBean;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.wt2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class VenueDetailActivity extends CommonNavbarActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    @Nullable
    private VenueInfoBean venueInfoBean;

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void addFragment() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1851424792")) {
            ipChange.ipc$dispatch("1851424792", new Object[]{this});
            return;
        }
        Intent intent = getIntent();
        String stringExtra = intent != null ? intent.getStringExtra(VenueDetailFragment.VENUE_ID) : null;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int i = R$id.container;
        VenueDetailFragment venueDetailFragment = new VenueDetailFragment();
        Bundle bundle = new Bundle();
        if (stringExtra != null) {
            bundle.putString(VenueDetailFragment.VENUE_ID, stringExtra);
        }
        venueDetailFragment.setArguments(bundle);
        wt2 wt2Var = wt2.INSTANCE;
        beginTransaction.add(i, venueDetailFragment);
        beginTransaction.commit();
        View findViewById = findViewById(R$id.nav_bar);
        if (findViewById == null) {
            return;
        }
        Resources resources = getResources();
        findViewById.setBackground(resources != null ? resources.getDrawable(R$drawable.venue_top_nav_default_bg) : null);
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void addUtPage() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1302916250")) {
            ipChange.ipc$dispatch("1302916250", new Object[]{this});
        } else {
            setDamaiUTKeyBuilder(new a.b().i("venue_new").a(z20.d()));
        }
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void initBaseInfo(@NotNull Object obj) {
        Object obj2;
        String bid;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-813095346")) {
            ipChange.ipc$dispatch("-813095346", new Object[]{this, obj});
            return;
        }
        b41.i(obj, "bean");
        HashMap hashMap = obj instanceof HashMap ? (HashMap) obj : null;
        if (hashMap == null || (obj2 = hashMap.get("value")) == null) {
            return;
        }
        VenueInfoBean venueInfoBean = obj2 instanceof VenueInfoBean ? (VenueInfoBean) obj2 : null;
        this.venueInfoBean = venueInfoBean;
        if (venueInfoBean == null || (bid = venueInfoBean.getBid()) == null) {
            return;
        }
        initAttentionView(bid, venueInfoBean.getFavoriteFlag(), "3");
    }

    @Override // cn.damai.commonbusiness.scriptmurder.CommonNavbarActivity
    public void onShareClick() {
        ShareInfoBean share;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-743676807")) {
            ipChange.ipc$dispatch("-743676807", new Object[]{this});
            return;
        }
        VenueInfoBean venueInfoBean = this.venueInfoBean;
        if (venueInfoBean != null) {
            b41.f(venueInfoBean);
            if (venueInfoBean.getShare() == null) {
                return;
            }
            Bundle bundle = new Bundle();
            VenueInfoBean venueInfoBean2 = this.venueInfoBean;
            if (venueInfoBean2 != null && (share = venueInfoBean2.getShare()) != null) {
                bundle.putString("title", share.getShareTitle());
                bundle.putString("message", share.getShareSubTitle());
                bundle.putString("imageurl", share.getShareImage());
                bundle.putString("producturl", share.getShareUrl());
            }
            ShareManager.E().T(this, bundle, getWindow().getDecorView());
            ShareManager.E().l0();
        }
    }
}
