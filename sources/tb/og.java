package tb;

import android.text.TextUtils;
import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class og extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String B_NAME = "xiannv";
    private static og b;

    public static og g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2138144421")) {
            return (og) ipChange.ipc$dispatch("-2138144421", new Object[0]);
        }
        if (b == null) {
            b = new og();
        }
        return b;
    }

    public a.b f(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1843616851")) {
            return (a.b) ipChange.ipc$dispatch("-1843616851", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", str);
        hashMap.put("titlelabel", str2);
        return new a.b().i(B_NAME).j(hashMap);
    }

    public a.b h(int i, String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "178255399")) {
            return (a.b) ipChange.ipc$dispatch("178255399", new Object[]{this, Integer.valueOf(i), str, str2, str3});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", str);
        hashMap.put("titlelabel", str2);
        if (!TextUtils.isEmpty(str3)) {
            hashMap.put("item_id", str3);
        }
        return e(B_NAME, "center", "item_" + i, hashMap, Boolean.TRUE);
    }
}
