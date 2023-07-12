package tb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import mtopsdk.mtop.domain.MtopResponse;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class fc0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final fc0 INSTANCE = new fc0();

    private fc0() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@Nullable MtopResponse mtopResponse) {
        Map<String, List<String>> headerFields;
        List<String> list;
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "1484957264") ? (String) ipChange.ipc$dispatch("1484957264", new Object[]{mtopResponse}) : (mtopResponse == null || (headerFields = mtopResponse.getHeaderFields()) == null || (list = headerFields.get("x-eagleeye-id")) == null) ? "trace null" : list.toString();
    }

    @JvmStatic
    public static final boolean b(@Nullable Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "539437747")) {
            return ((Boolean) ipChange.ipc$dispatch("539437747", new Object[]{context})).booleanValue();
        }
        Object systemService = context != null ? context.getSystemService("connectivity") : null;
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? systemService : null;
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities != null) {
                    return networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(3);
                }
            } else {
                try {
                    rq.a("update_statut", "Network is available : true");
                    NetworkInfo activeNetworkInfo = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(connectivityManager);
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnected();
                    }
                    return false;
                } catch (Exception e) {
                    rq.a("update_statut", "" + e.getMessage());
                    wt2 wt2Var = wt2.INSTANCE;
                }
            }
        }
        rq.a("update_statut", "Network is available : FALSE ");
        return false;
    }
}
