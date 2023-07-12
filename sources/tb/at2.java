package tb;

import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class at2 extends vq {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String c = "cn.movieshow.app/UT";

    private a.b c(String str, String str2, String str3, String str4, Map map, boolean z) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-102940703") ? (a.b) ipChange.ipc$dispatch("-102940703", new Object[]{this, str, str2, str3, str4, map, Boolean.valueOf(z)}) : new a.b().i(str).f(str2).l(str3).c(str4).g(z).j(map);
    }

    @Override // tb.vq
    public String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "413927666") ? (String) ipChange.ipc$dispatch("413927666", new Object[]{this}) : c;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0140, code lost:
        if (r0.equals("pageDisAppear") == false) goto L42;
     */
    @Override // tb.vq, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onMethodCall(io.flutter.plugin.common.MethodCall r23, io.flutter.plugin.common.MethodChannel.Result r24) {
        /*
            Method dump skipped, instructions count: 590
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.at2.onMethodCall(io.flutter.plugin.common.MethodCall, io.flutter.plugin.common.MethodChannel$Result):void");
    }
}
