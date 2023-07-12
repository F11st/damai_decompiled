package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class xi2 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final void a(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-576245185")) {
            ipChange.ipc$dispatch("-576245185", new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)});
            return;
        }
        b41.i(str, "bizSceneStr");
        b41.i(str2, "point");
        b41.i(str3, "arg");
        b41.i(str4, "errorCode");
        b41.i(str5, "errorMsg");
        try {
            g23 g23Var = new g23();
            HashMap hashMap = new HashMap();
            hashMap.put("arg", str3);
            g23Var.setExtral(hashMap);
            g23Var.setBizCode(str4);
            g23Var.setBizMsg(str5);
            g23Var.setBizScene(str);
            g23Var.setMPointName(str2);
            g23Var.setResultExpected(z);
            g23Var.release();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println((Object) String.valueOf(wt2.INSTANCE));
        }
    }
}
