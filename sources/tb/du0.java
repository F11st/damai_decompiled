package tb;

import android.text.TextUtils;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class du0 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String b = "xiannv";
    private static du0 c;

    public static du0 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1422220251")) {
            return (du0) ipChange.ipc$dispatch("1422220251", new Object[0]);
        }
        if (c == null) {
            c = new du0();
        }
        return c;
    }

    public C0525a.C0527b g(int i, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1591965539")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1591965539", new Object[]{this, Integer.valueOf(i), str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        if (!TextUtils.isEmpty(str2)) {
            hashMap.put("item_id", str2);
        }
        String str3 = b;
        return e(str3, "xiannv_mustsee", "item_" + i, hashMap, Boolean.TRUE);
    }
}
