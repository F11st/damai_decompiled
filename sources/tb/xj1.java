package tb;

import android.content.Context;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.NetworkInfoProviderProxy;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class xj1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static boolean a(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1748543749") ? ((Boolean) ipChange.ipc$dispatch("1748543749", new Object[]{context})).booleanValue() : NetworkInfoProviderProxy.isMobile();
    }

    public static boolean b(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-385504624") ? ((Boolean) ipChange.ipc$dispatch("-385504624", new Object[]{context})).booleanValue() : NetworkInfoProviderProxy.isNetworkAvailable();
    }

    public static boolean c(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "464643946") ? ((Boolean) ipChange.ipc$dispatch("464643946", new Object[]{context})).booleanValue() : NetworkInfoProviderProxy.isWifi();
    }
}
