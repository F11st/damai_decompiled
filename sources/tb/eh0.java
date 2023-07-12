package tb;

import android.widget.TextView;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.middlewareservice.provider.info.AppInfoProviderProxy;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class eh0 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final void a(@NotNull TextView textView, @Nullable String str, int i) {
        IpChange ipChange = $ipChange;
        boolean z = true;
        if (AndroidInstantRuntime.support(ipChange, "-303344088")) {
            ipChange.ipc$dispatch("-303344088", new Object[]{textView, str, Integer.valueOf(i)});
            return;
        }
        b41.i(textView, "<this>");
        if (str != null && str.length() != 0) {
            z = false;
        }
        if (z) {
            textView.setVisibility(i);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
    }

    public static /* synthetic */ void b(TextView textView, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8;
        }
        a(textView, str, i);
    }

    public static final void c(@NotNull Throwable th) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-930632549")) {
            ipChange.ipc$dispatch("-930632549", new Object[]{th});
            return;
        }
        b41.i(th, "<this>");
        if (AppInfoProviderProxy.isDebuggable()) {
            th.printStackTrace();
        }
    }
}
