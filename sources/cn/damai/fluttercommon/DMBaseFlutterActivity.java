package cn.damai.fluttercommon;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.idlefish.flutterboost.containers.FlutterBoostActivity;
import com.taobao.weex.ui.component.WXWeb;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;
import tb.jo0;
import tb.k3;
import tb.mo0;
import tb.wu0;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class DMBaseFlutterActivity extends FlutterBoostActivity {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String CHANNEL_NATIVE_BACK = "cn.movieshow.app/flutterback";
    C0525a.C0527b builder;

    private void flutterPlugin() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1501863640")) {
            ipChange.ipc$dispatch("1501863640", new Object[]{this});
        } else {
            new MethodChannel(getFlutterEngine().getDartExecutor().getBinaryMessenger(), CHANNEL_NATIVE_BACK).invokeMethod(WXWeb.GO_BACK, null);
        }
    }

    private String getPageName() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1838693751")) {
            return (String) ipChange.ipc$dispatch("-1838693751", new Object[]{this});
        }
        String stringExtra = getIntent().hasExtra("dm_pageName") ? getIntent().getStringExtra("dm_pageName") : "";
        return !TextUtils.isEmpty(stringExtra) ? stringExtra : getUrl();
    }

    @Override // io.flutter.embedding.android.FlutterActivity, io.flutter.embedding.android.FlutterActivityAndFragmentDelegate.Host, io.flutter.embedding.android.FlutterEngineConfigurator
    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1985378257")) {
            ipChange.ipc$dispatch("1985378257", new Object[]{this, flutterEngine});
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1733634412")) {
            ipChange.ipc$dispatch("1733634412", new Object[]{this, bundle});
            return;
        }
        if (jo0.f().c()) {
            mo0.g().f(null, "onCreate_success", "flutterengine");
        } else {
            mo0.g().f(null, "onCreate_need_init", "flutterengine");
            jo0.f().d();
        }
        super.onCreate(bundle);
        k3.b().e(this);
        wu0.g(getActivity(), getActivity().findViewById(16908290));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onDestroy() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1444878932")) {
            ipChange.ipc$dispatch("-1444878932", new Object[]{this});
            return;
        }
        super.onDestroy();
        k3.b().f(this);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1272008706")) {
            return ((Boolean) ipChange.ipc$dispatch("1272008706", new Object[]{this, Integer.valueOf(i), keyEvent})).booleanValue();
        }
        if (i == 4) {
            flutterPlugin();
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onPause() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1297430128")) {
            ipChange.ipc$dispatch("1297430128", new Object[]{this});
            return;
        }
        super.onPause();
        C0529c.e().j(this, this.builder);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity, android.app.Activity
    public void onResume() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1081552489")) {
            ipChange.ipc$dispatch("-1081552489", new Object[]{this});
            return;
        }
        super.onResume();
        this.builder = C0528b.getInstance().b(getPageName());
        C0529c.e().k(this, this.builder);
        k3.b().e(this);
    }

    @Override // com.idlefish.flutterboost.containers.FlutterBoostActivity, io.flutter.embedding.android.FlutterActivity, android.app.Activity
    protected void onStart() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1340534916")) {
            ipChange.ipc$dispatch("1340534916", new Object[]{this});
            return;
        }
        if (jo0.f().c()) {
            mo0.g().f(null, "onStart_success", "flutterengine");
        } else {
            mo0.g().f(null, "onStart_need_init", "flutterengine");
            jo0.f().d();
        }
        super.onStart();
    }
}
