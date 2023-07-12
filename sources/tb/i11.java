package tb;

import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class i11 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* compiled from: Taobao */
    /* renamed from: tb.i11$a */
    /* loaded from: classes4.dex */
    private static class C9249a {
        private static final i11 a = new i11();
    }

    public static final i11 g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-184364165") ? (i11) ipChange.ipc$dispatch("-184364165", new Object[0]) : C9249a.a;
    }

    public C0525a.C0527b f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1484333615")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-1484333615", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", str);
        return new C0525a.C0527b().j(hashMap).i("poster");
    }
}
