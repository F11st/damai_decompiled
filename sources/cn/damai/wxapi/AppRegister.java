package cn.damai.wxapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import tb.v20;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AppRegister extends BroadcastReceiver {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1545276825")) {
            ipChange.ipc$dispatch("-1545276825", new Object[]{this, context, intent});
        } else {
            WXAPIFactory.createWXAPI(context, null).registerApp(v20.a(WXEntryActivity.APP_ID_CRYPT));
        }
    }
}
