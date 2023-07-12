package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.taobao.weex.ui.component.WXWeb;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class v9 extends vq {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String c = "cn.movieshow.app/nativeback";

    @Override // tb.vq
    public String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1759449426") ? (String) ipChange.ipc$dispatch("1759449426", new Object[]{this}) : c;
    }

    @Override // tb.vq, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-529386232")) {
            ipChange.ipc$dispatch("-529386232", new Object[]{this, methodCall, result});
            return;
        }
        String str = methodCall.method;
        str.hashCode();
        if (!str.equals(WXWeb.GO_BACK)) {
            result.notImplemented();
            return;
        }
        b().onBackPressed();
        result.success(null);
    }
}
