package tb;

import android.view.View;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class vf2 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange;
    private static vf2 c;
    public String b = "business_homepage";

    public static vf2 f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1894714061")) {
            return (vf2) ipChange.ipc$dispatch("-1894714061", new Object[0]);
        }
        if (c == null) {
            c = new vf2();
        }
        return c;
    }

    public void g(View view, int i, String str, int i2, boolean z, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-12012036")) {
            ipChange.ipc$dispatch("-12012036", new Object[]{this, view, Integer.valueOf(i), str, Integer.valueOf(i2), Boolean.valueOf(z), str2});
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("biz_id", str);
        hashMap.put("biz_type", i2 + "");
        if (z) {
            hashMap.put(u12.VIEW_TYPE, "1");
        } else {
            hashMap.put(u12.VIEW_TYPE, "0");
        }
        hashMap.put("contentlabel", str2);
        C0529c e = C0529c.e();
        e.G(view, "item_" + i, "banners", this.b, hashMap);
    }
}
