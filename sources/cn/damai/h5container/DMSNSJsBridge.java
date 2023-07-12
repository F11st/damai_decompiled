package cn.damai.h5container;

import android.taobao.windvane.jsbridge.WVCallBackContext;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.android.sns4android.jsbridge.SNSJsbridge;
import org.jetbrains.annotations.Nullable;
import tb.qm;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class DMSNSJsBridge extends SNSJsbridge {
    private static transient /* synthetic */ IpChange $ipChange;

    @Override // com.taobao.android.sns4android.jsbridge.SNSJsbridge, android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(@Nullable String str, @Nullable String str2, @Nullable WVCallBackContext wVCallBackContext) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "292336042")) {
            return ((Boolean) ipChange.ipc$dispatch("292336042", new Object[]{this, str, str2, wVCallBackContext})).booleanValue();
        }
        if (qm.Companion.c(this.mWebView.getUrl())) {
            return super.execute(str, str2, wVCallBackContext);
        }
        return true;
    }
}
