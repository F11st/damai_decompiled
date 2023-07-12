package tb;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class np0 {
    private static transient /* synthetic */ IpChange $ipChange;
    public static final np0 fragmentXFixer = new np0();

    private Boolean a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1837748950")) {
            return (Boolean) ipChange.ipc$dispatch("1837748950", new Object[]{this});
        }
        int i = Build.VERSION.SDK_INT;
        if (i != 29 && i != 28) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public void b(Context context, Bundle bundle) {
        Bundle bundle2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1599450692")) {
            ipChange.ipc$dispatch("-1599450692", new Object[]{this, context, bundle});
        } else if (bundle != null) {
            try {
                if (a().booleanValue()) {
                    bundle.setClassLoader(context.getClass().getClassLoader());
                    if (bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") == null || (bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key")) == null || bundle2.keySet() == null) {
                        return;
                    }
                    for (String str : bundle2.keySet()) {
                        if (bundle2.get(str) != null && (bundle2.get(str) instanceof Bundle)) {
                            ((Bundle) bundle2.get(str)).setClassLoader(context.getClass().getClassLoader());
                        }
                    }
                }
            } catch (Exception e) {
                Log.e("FragmentXFixer", " FATAL: FragmentXFixer exception");
                e.printStackTrace();
            }
        }
    }
}
