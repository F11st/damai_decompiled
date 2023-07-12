package tb;

import android.content.Context;
import com.alient.resource.util.DisplayUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class gi0 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final gi0 INSTANCE = new gi0();

    private gi0() {
    }

    public final int a(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1292195374")) {
            return ((Integer) ipChange.ipc$dispatch("1292195374", new Object[]{this, context})).intValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        return (e32.e(context) - DisplayUtil.dip2px(context, 25.0f)) / ye2.INSTANCE.d(context, 2);
    }
}
