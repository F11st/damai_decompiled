package tb;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class lp0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final lp0 INSTANCE = new lp0();

    private lp0() {
    }

    private final boolean a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "663549510")) {
            return ((Boolean) ipChange.ipc$dispatch("663549510", new Object[]{this, context})).booleanValue();
        }
        int i = Build.VERSION.SDK_INT;
        return i == 29 || i == 28;
    }

    public final void b(@NotNull Context context, @Nullable Bundle bundle) {
        Set<String> keySet;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1887871657")) {
            ipChange.ipc$dispatch("1887871657", new Object[]{this, context, bundle});
            return;
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (bundle == null || !a(context)) {
            return;
        }
        bundle.setClassLoader(context.getClass().getClassLoader());
        Bundle bundle2 = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        if (bundle2 == null || (keySet = bundle2.keySet()) == null) {
            return;
        }
        b41.h(keySet, "keySet()");
        for (String str : keySet) {
            Object obj = bundle2.get(str);
            Bundle bundle3 = obj instanceof Bundle ? (Bundle) obj : null;
            if (bundle3 != null) {
                bundle3.setClassLoader(context.getClass().getClassLoader());
            }
        }
    }
}
