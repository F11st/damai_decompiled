package cn.damai.h5container;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.login4android.jsbridge.JSBridgeService;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.qm;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class LoginJSBridgeService extends JSBridgeService {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.taobao.login4android.jsbridge.JSBridgeService, android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1784809603")) {
            return ((Boolean) ipChange.ipc$dispatch("-1784809603", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        if (b41.d("getUserInfo", str)) {
            if (qm.Companion.c(this.mWebView.getUrl())) {
                return super.execute(str, str2, wVCallBackContext);
            }
            return true;
        }
        return super.execute(str, str2, wVCallBackContext);
    }
}
