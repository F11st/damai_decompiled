package com.youku.live.dago.widgetlib;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.bridge.JSCallback;
import com.youku.live.dago.widgetlib.ailpbaselib.utils.AppContextUtils;
import com.youku.live.dago.widgetlib.component.DagoUserCardDialog;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class DemoActivity extends AppCompatActivity {
    private static transient /* synthetic */ IpChange $ipChange;
    private DagoUserCardDialog mDialog;

    /* JADX INFO: Access modifiers changed from: private */
    public void showUserCardDialog(Context context, String str, JSCallback jSCallback) {
        long j;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1455069978")) {
            ipChange.ipc$dispatch("-1455069978", new Object[]{this, context, str, jSCallback});
            return;
        }
        if (this.mDialog == null) {
            this.mDialog = new DagoUserCardDialog(context, false);
        }
        try {
            j = Long.parseLong(str);
        } catch (Exception unused) {
            j = 0;
        }
        if (j > 0) {
            this.mDialog.setTargetUserId(str);
            this.mDialog.setJSCallback(jSCallback);
            this.mDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-469823905")) {
            ipChange.ipc$dispatch("-469823905", new Object[]{this, bundle});
            return;
        }
        super.onCreate(bundle);
        setContentView(R.layout.demo_activity_layout);
        findViewById(R.id.tv_show_dialog).setOnClickListener(new View.OnClickListener() { // from class: com.youku.live.dago.widgetlib.DemoActivity.1
            private static transient /* synthetic */ IpChange $ipChange;

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IpChange ipChange2 = $ipChange;
                if (AndroidInstantRuntime.support(ipChange2, "600528366")) {
                    ipChange2.ipc$dispatch("600528366", new Object[]{this, view});
                    return;
                }
                AppContextUtils.init(DemoActivity.this.getApplication());
                DemoActivity demoActivity = DemoActivity.this;
                demoActivity.showUserCardDialog(demoActivity, "331330505", null);
            }
        });
    }
}
