package tb;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.alibaba.pictures.share.ShareManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmName(name = "ApplicationUtil")
/* loaded from: classes8.dex */
public final class e7 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final synchronized boolean a(@NotNull String str) {
        PackageManager packageManager;
        synchronized (e7.class) {
            IpChange ipChange = $ipChange;
            if (AndroidInstantRuntime.support(ipChange, "1774498080")) {
                return ((Boolean) ipChange.ipc$dispatch("1774498080", new Object[]{str})).booleanValue();
            }
            b41.i(str, "packageName");
            PackageInfo packageInfo = null;
            try {
                Application a = ShareManager.INSTANCE.a();
                if (a != null && (packageManager = a.getPackageManager()) != null) {
                    packageInfo = packageManager.getPackageInfo(str, 0);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return packageInfo != null;
        }
    }
}
