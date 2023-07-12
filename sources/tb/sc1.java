package tb;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.alipay.camera2.util.Camera2CharacteristicsCache;
import com.alipay.mobile.bqcscanservice.MPaasScanService;
import com.alipay.mobile.bqcscanservice.impl.MPaasScanServiceImpl;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class sc1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static String a = "MPaasScanServiceFactory";

    public static MPaasScanService a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "891191439")) {
            return (MPaasScanService) ipChange.ipc$dispatch("891191439", new Object[]{context});
        }
        if (Build.VERSION.SDK_INT < 26) {
            return new MPaasScanServiceImpl();
        }
        new Camera2CharacteristicsCache(context, true);
        Log.d(a, "MPaasScanServiceImpl is created");
        return new MPaasScanServiceImpl();
    }
}
