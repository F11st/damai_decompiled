package tb;

import android.view.View;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class xy0 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HOME_PAGE = "home";
    private static xy0 b;

    public static xy0 g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "112491451")) {
            return (xy0) ipChange.ipc$dispatch("112491451", new Object[0]);
        }
        if (b == null) {
            b = new xy0();
        }
        return b;
    }

    public C0525a.C0527b f(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1032554986")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1032554986", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d() + "市");
        hashMap.put("titlelabel", str);
        return e(py0.CHANNEL_PAGE, "top", "tab_" + i, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b h(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1551053339")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1551053339", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", str);
        return e("home", "top", "tab_" + i, hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b i(String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-439815727")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-439815727", new Object[]{this, str, Integer.valueOf(i), str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d());
        hashMap.put("titlelabel", str2);
        return e(str, "top", "tab_" + i, hashMap, Boolean.TRUE);
    }

    public void j(View view, String str, int i, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1528136987")) {
            ipChange.ipc$dispatch("-1528136987", new Object[]{this, view, str, Integer.valueOf(i), str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("city", z20.d() + "市");
        hashMap.put("titlelabel", str2);
        C0529c e = C0529c.e();
        e.G(view, "tab_" + i, "top", str, hashMap);
    }
}
