package tb;

import android.content.Intent;
import cn.damai.fluttercommon.DMNFCActivity;
import cn.damai.ticket.nfc.NfcUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class eb2 extends vq {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String c = "cn.movieshow.app/Setting";

    private void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1492462918")) {
            ipChange.ipc$dispatch("-1492462918", new Object[]{this});
        } else {
            b().startActivity(new Intent("android.settings.SETTINGS"));
        }
    }

    @Override // tb.vq
    public String a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "924515992") ? (String) ipChange.ipc$dispatch("924515992", new Object[]{this}) : c;
    }

    @Override // tb.vq, io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1000022146")) {
            ipChange.ipc$dispatch("1000022146", new Object[]{this, methodCall, result});
            return;
        }
        String str = methodCall.method;
        str.hashCode();
        if (!str.equals("openNFCSettingPage")) {
            result.notImplemented();
            return;
        }
        if (b() != null) {
            try {
                if (b() instanceof DMNFCActivity) {
                    NfcUtil nfcUtil = ((DMNFCActivity) b()).getNfcUtil();
                    if (nfcUtil != null && nfcUtil.f()) {
                        b().startActivity(new Intent("android.settings.NFC_SETTINGS"));
                    } else {
                        c();
                    }
                } else {
                    c();
                }
            } catch (Exception unused) {
                c();
            }
        }
        result.success(null);
    }
}
