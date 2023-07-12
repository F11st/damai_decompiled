package tb;

import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class u70 extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DETAILED_PAGE = "shoppinglist";
    private static u70 b;

    public static u70 g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-885143381")) {
            return (u70) ipChange.ipc$dispatch("-885143381", new Object[0]);
        }
        if (b == null) {
            b = new u70();
        }
        return b;
    }

    public C0525a.C0527b f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-186644659")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("-186644659", new Object[]{this, str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.c());
        hashMap.put("usercode", z20.E());
        hashMap.put("shoppinglist_id", str);
        hashMap.put(C9548pb.CNT_CONTENT_ID, str);
        hashMap.put(C9548pb.CNT_CONTENT_TYPE, DETAILED_PAGE);
        return new C0525a.C0527b().j(hashMap).i(DETAILED_PAGE);
    }

    public C0525a.C0527b h(String str, String str2, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1057990700")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1057990700", new Object[]{this, str, str2, Boolean.valueOf(z)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("titlelabel", str);
        hashMap.put("shoppinglist_id", str2);
        hashMap.put(C9548pb.CNT_CONTENT_TYPE, DETAILED_PAGE);
        hashMap.put(C9548pb.CNT_CONTENT_ID, str2);
        hashMap.put("status", z ? "0" : "1");
        return e(DETAILED_PAGE, "top", "favorite", hashMap, Boolean.FALSE);
    }

    public C0525a.C0527b i(String str, String str2, String str3, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "202682260")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("202682260", new Object[]{this, str, str2, str3, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("city", z20.c());
        hashMap.put("titlelabel", str);
        hashMap.put("item_id", str2);
        hashMap.put("shoppinglist_id", str3);
        hashMap.put(C9548pb.CNT_CONTENT_TYPE, DETAILED_PAGE);
        hashMap.put(C9548pb.CNT_CONTENT_ID, str3);
        return e(DETAILED_PAGE, "list", "item_" + i, hashMap, Boolean.TRUE);
    }

    public C0525a.C0527b j(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1137937561")) {
            return (C0525a.C0527b) ipChange.ipc$dispatch("1137937561", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("titlelabel", str);
        hashMap.put("shoppinglist_id", str2);
        hashMap.put(C9548pb.CNT_CONTENT_TYPE, DETAILED_PAGE);
        hashMap.put(C9548pb.CNT_CONTENT_ID, str2);
        return e(DETAILED_PAGE, "top", "award_share", hashMap, Boolean.TRUE);
    }
}
