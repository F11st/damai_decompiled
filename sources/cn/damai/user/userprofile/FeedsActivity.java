package cn.damai.user.userprofile;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import cn.damai.common.user.a;
import cn.damai.commonbusiness.base.SimpleBaseActivity;
import cn.damai.homepage.R$id;
import cn.damai.homepage.R$layout;
import cn.damai.user.userprofile.bean.FeedsRequest;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class FeedsActivity extends SimpleBaseActivity {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* loaded from: classes17.dex */
    public class a implements View.OnClickListener {
        private static transient /* synthetic */ IpChange $ipChange;

        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1689567259")) {
                ipChange.ipc$dispatch("-1689567259", new Object[]{this, view});
            } else {
                FeedsActivity.this.finish();
            }
        }
    }

    @Override // cn.damai.common.app.base.BaseActivity
    public int getLayoutId() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-4959493")) {
            return ((Integer) ipChange.ipc$dispatch("-4959493", new Object[]{this})).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.damai.commonbusiness.base.DamaiBaseActivity, cn.damai.common.app.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "980322696")) {
            ipChange.ipc$dispatch("980322696", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setDamaiUTKeyBuilder(new a.b().i("brand__evaluate"));
        setContentView(R$layout.activity_feeds);
        findViewById(R$id.brand_back).setOnClickListener(new a());
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        if (getIntent() == null) {
            return;
        }
        String stringExtra = getIntent().getStringExtra("type");
        String stringExtra2 = getIntent().getStringExtra("userId");
        String stringExtra3 = getIntent().getStringExtra("bid");
        long j = 0;
        try {
            i = Integer.parseInt(stringExtra);
            try {
                j = Long.parseLong(stringExtra3);
            } catch (NumberFormatException e) {
                e = e;
                e.printStackTrace();
                FeedsFragment newInstance = FeedsFragment.newInstance(i, stringExtra2, j, FeedsRequest.FEED_TYPE_QUANZI);
                beginTransaction.replace(R$id.activity_feeds, newInstance);
                newInstance.setSinglePage(true, 0);
                beginTransaction.commitAllowingStateLoss();
            }
        } catch (NumberFormatException e2) {
            e = e2;
            i = 0;
        }
        FeedsFragment newInstance2 = FeedsFragment.newInstance(i, stringExtra2, j, FeedsRequest.FEED_TYPE_QUANZI);
        beginTransaction.replace(R$id.activity_feeds, newInstance2);
        newInstance2.setSinglePage(true, 0);
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // cn.damai.common.app.base.BaseActivity
    protected String setTitle() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "126871087") ? (String) ipChange.ipc$dispatch("126871087", new Object[]{this}) : "大家说";
    }
}
