package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class sq extends vq {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String c = "cn.movieshow.app/Alarm";

    @Override // tb.vq
    public String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "619856791") ? (String) ipChange.ipc$dispatch("619856791", new Object[]{this}) : c;
    }

    @Override // tb.vq, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1507527837")) {
            ipChange.ipc$dispatch("-1507527837", new Object[]{this, methodCall, result});
            return;
        }
        String str = methodCall.method;
        str.hashCode();
        if (!str.equals("alarmCommitFail")) {
            result.notImplemented();
            return;
        }
        Map map = (Map) methodCall.arguments;
        b23.b(map.containsKey("page") ? (String) map.get("page") : "FLUTTER_PAGE", map.containsKey("pointName") ? (String) map.get("pointName") : "FLUTTER_ERROR", map.containsKey("msg") ? (String) map.get("msg") : "", map.containsKey("code") ? (String) map.get("code") : "-70000", map.containsKey("args") ? (String) map.get("args") : "");
        result.success(null);
    }
}
