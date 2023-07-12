package tb;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public final class ps {
    private static transient /* synthetic */ IpChange $ipChange;

    public static final void a(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-341566108")) {
            ipChange.ipc$dispatch("-341566108", new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)});
            return;
        }
        b41.i(str, "bizSceneStr");
        b41.i(str2, "point");
        b41.i(str3, "arg");
        b41.i(str4, "errorCode");
        b41.i(str5, "errorMsg");
        try {
            ct ctVar = new ct();
            HashMap hashMap = new HashMap();
            hashMap.put("arg", str3);
            ctVar.setExtral(hashMap);
            ctVar.setBizCode(str4);
            ctVar.setBizMsg(str5);
            ctVar.setBizScene(str);
            ctVar.setMPointName(str2);
            ctVar.setResultExpected(z);
            ctVar.release();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println((Object) String.valueOf(wt2.INSTANCE));
        }
    }
}
