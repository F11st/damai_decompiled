package tb;

import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class gb extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String HOME_MESSAGE_PAGE = "message";
    public static final String PROJECT_PAGE = "project";
    public static final String PROJECT_SCREENINGS_PAGE = "screenings";

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static class a {
        private static final gb a = new gb();
    }

    public static gb g() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2083669545") ? (gb) ipChange.ipc$dispatch("2083669545", new Object[0]) : a.a;
    }

    public a.b f(long j, String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-476825958") ? (a.b) ipChange.ipc$dispatch("-476825958", new Object[]{this, Long.valueOf(j), str}) : new a.b().d(String.valueOf(j)).i(str);
    }

    public a.b h(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1796812610")) {
            return (a.b) ipChange.ipc$dispatch("-1796812610", new Object[]{this, Long.valueOf(j)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("item_id", String.valueOf(j));
        return e(PROJECT_PAGE, "bottom", "select", hashMap, Boolean.TRUE);
    }

    public Map<String, String> i(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-436490626")) {
            return (Map) ipChange.ipc$dispatch("-436490626", new Object[]{this, str, str2});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("titlelabel", str);
        hashMap.put("contentlabel", str2);
        return hashMap;
    }
}
