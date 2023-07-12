package tb;

import android.content.Context;
import cn.damai.common.util.ToastUtil;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class se1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(Context context, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1024091549")) {
            ipChange.ipc$dispatch("1024091549", new Object[]{context, str, str2});
        } else if ("FAIL_SYS_SESSION_EXPIRED".equals(str) || context == null) {
        } else {
            ToastUtil.a().j(context, str2);
        }
    }
}
