package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import kotlin.jvm.functions.Function0;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class qn2 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String str, Function0<wt2> function0, Function0<wt2> function02, Function0<wt2> function03) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1600277265")) {
            ipChange.ipc$dispatch("-1600277265", new Object[]{str, function0, function02, function03});
        } else if (b41.d(str, "200")) {
            function0.invoke();
        } else if (b41.d(str, "300")) {
            function02.invoke();
        } else {
            function03.invoke();
        }
    }
}
