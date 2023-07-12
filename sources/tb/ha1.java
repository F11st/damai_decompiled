package tb;

import android.content.Context;
import android.location.LocationManager;
import android.os.Process;
import androidx.core.content.PermissionChecker;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ha1 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static final String[] a = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

    private static boolean a(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1327262974")) {
            return ((Boolean) ipChange.ipc$dispatch("1327262974", new Object[]{context, str})).booleanValue();
        }
        try {
            return PermissionChecker.checkPermission(context, str, Process.myPid(), Process.myUid(), context.getPackageName()) == 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1811821787")) {
            return ((Boolean) ipChange.ipc$dispatch("1811821787", new Object[]{context})).booleanValue();
        }
        if (c(context)) {
            String[] strArr = a;
            return a(context, strArr[0]) || a(context, strArr[1]);
        }
        return false;
    }

    private static boolean c(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "978455672")) {
            return ((Boolean) ipChange.ipc$dispatch("978455672", new Object[]{context})).booleanValue();
        }
        try {
            return ((LocationManager) context.getSystemService("location")).isProviderEnabled(GeocodeSearch.GPS);
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }
}
