package cn.damai.launcher.splash;

import android.view.View;
import cn.damai.common.user.b;
import cn.damai.common.user.c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class GuidePageUTHelper extends b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String GUIDE_PAGE = "guide";
    private static GuidePageUTHelper b;

    public static GuidePageUTHelper getInstance() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1863998757")) {
            return (GuidePageUTHelper) ipChange.ipc$dispatch("-1863998757", new Object[0]);
        }
        if (b == null) {
            b = new GuidePageUTHelper();
        }
        return b;
    }

    public void f(String str, String str2, HashMap hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1291201690")) {
            ipChange.ipc$dispatch("-1291201690", new Object[]{this, str, str2, hashMap});
            return;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        HashMap hashMap2 = hashMap;
        hashMap2.put("city", z20.c());
        c.e().x(e(GUIDE_PAGE, str, str2, hashMap2, Boolean.FALSE));
    }

    public void g(View view, String str, String str2, HashMap hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "822398308")) {
            ipChange.ipc$dispatch("822398308", new Object[]{this, view, str, str2, hashMap});
            return;
        }
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        HashMap hashMap2 = hashMap;
        hashMap2.put("city", z20.c());
        c.e().G(view, str2, str, GUIDE_PAGE, hashMap2);
    }
}
