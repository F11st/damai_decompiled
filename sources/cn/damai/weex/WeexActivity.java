package cn.damai.weex;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.taobao.windvane.WindVaneSDK;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import cn.damai.common.AppConfig;
import cn.damai.commonbusiness.R$color;
import cn.damai.commonbusiness.R$id;
import cn.damai.commonbusiness.R$layout;
import cn.damai.h5container.DMBridge;
import cn.damai.h5container.WindvaneAgent;
import com.alibaba.aliweex.bundle.WeexPageFragment;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.WXSDKInstance;
import tb.kg2;
import tb.mu0;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class WeexActivity extends AppCompatActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String URL = "url";
    public static long endTime;
    public static long startTime;
    private String mUrl = "";
    private WeexPageFragment mWeexPageFragment;

    /* compiled from: Taobao */
    /* renamed from: cn.damai.weex.WeexActivity$a */
    /* loaded from: classes9.dex */
    public class C2790a extends WeexPageFragment.C3076b {
        private static transient /* synthetic */ IpChange $ipChange;

        C2790a() {
        }

        @Override // com.alibaba.aliweex.bundle.WeexPageFragment.C3076b
        public void c(WXSDKInstance wXSDKInstance, boolean z, String str, String str2) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-666314577")) {
                ipChange.ipc$dispatch("-666314577", new Object[]{this, wXSDKInstance, Boolean.valueOf(z), str, str2});
                return;
            }
            super.c(wXSDKInstance, z, str, str2);
            WeexActivity.this.showErrorView();
        }

        @Override // com.alibaba.aliweex.bundle.WeexPageFragment.C3076b, com.taobao.weex.IWXRenderListener
        public void onViewCreated(WXSDKInstance wXSDKInstance, View view) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "-1581893659")) {
                ipChange.ipc$dispatch("-1581893659", new Object[]{this, wXSDKInstance, view});
                return;
            }
            WeexActivity.endTime = System.currentTimeMillis();
            Log.e("weextime", (WeexActivity.endTime - WeexActivity.startTime) + "");
            super.onViewCreated(wXSDKInstance, view);
        }
    }

    private String getRenderUrl(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-156189599")) {
            return (String) ipChange.ipc$dispatch("-156189599", new Object[]{this, str});
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("_wx_tpl");
        return !TextUtils.isEmpty(queryParameter) ? queryParameter : Boolean.parseBoolean(parse.getQueryParameter("wh_weex")) ? str : "";
    }

    private void initTitle() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1461119466")) {
            ipChange.ipc$dispatch("1461119466", new Object[]{this});
            return;
        }
        getSupportActionBar().hide();
        View findViewById = findViewById(R$id.status_bar_space);
        if (Build.VERSION.SDK_INT >= 23) {
            findViewById.getLayoutParams().height = kg2.a(this);
            findViewById.setVisibility(0);
            kg2.f(this, true, R$color.black);
            kg2.d(true, this);
            return;
        }
        kg2.f(this, false, R$color.black);
        findViewById.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorView() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1519389506")) {
            ipChange.ipc$dispatch("1519389506", new Object[]{this});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "374634007")) {
            ipChange.ipc$dispatch("374634007", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R$layout.activity_weex);
        if (getIntent() != null && getIntent().getStringExtra("url") != null) {
            this.mUrl = getIntent().getStringExtra("url");
        }
        initTitle();
        if (!WindVaneSDK.isInitialized()) {
            Log.d("delayInit", "windvane lazy init start");
            String n = AppConfig.n(mu0.a());
            if (!TextUtils.isEmpty(n) && n.equals("cn.damai")) {
                WindvaneAgent.initWindVane(mu0.a());
            }
        }
        DMBridge.registerPlugin(this);
        if (!TextUtils.isEmpty(this.mUrl)) {
            String renderUrl = getRenderUrl(this.mUrl);
            try {
                this.mWeexPageFragment = (WeexPageFragment) WeexPageFragment.newInstanceWithUrl(this, WeexPageFragment.class, renderUrl, renderUrl, R$id.contanier);
            } catch (Exception unused) {
            }
            startTime = System.currentTimeMillis();
            this.mWeexPageFragment.setRenderListener(new C2790a());
            return;
        }
        showErrorView();
    }

    public void setTitleContent(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1363246329")) {
            ipChange.ipc$dispatch("1363246329", new Object[]{this, str});
        } else if (str == null) {
        } else {
            ((TextView) findViewById(R$id.webview_titile)).setText(str);
        }
    }
}
