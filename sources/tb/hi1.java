package tb;

import android.text.TextUtils;
import android.view.View;
import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class hi1 extends cn.damai.common.user.b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String MY_COLLECT_PAGE = "collect";
    private static hi1 b;

    public static void f(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1092356701")) {
            ipChange.ipc$dispatch("-1092356701", new Object[]{map});
        } else {
            h("city", z20.d(), map);
        }
    }

    public static void g(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "42606309")) {
            ipChange.ipc$dispatch("42606309", new Object[]{map});
        } else {
            h("usercode", z20.E(), map);
        }
    }

    public static void h(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1021029264")) {
            ipChange.ipc$dispatch("1021029264", new Object[]{str, str2, map});
        } else if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
        } else {
            map.put(str, str2);
        }
    }

    public static void i(View view, int i, String str, String str2, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1889230235")) {
            ipChange.ipc$dispatch("-1889230235", new Object[]{view, Integer.valueOf(i), str, str2, Integer.valueOf(i2)});
            return;
        }
        HashMap hashMap = new HashMap();
        f(hashMap);
        g(hashMap);
        h("titlelabel", str, hashMap);
        h("card_id", str2, hashMap);
        cn.damai.common.user.c.e().G(view, "card_" + i2, "favorite_tab_" + i, "collect", hashMap);
    }

    public static hi1 m() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2055812059")) {
            return (hi1) ipChange.ipc$dispatch("2055812059", new Object[0]);
        }
        if (b == null) {
            b = new hi1();
        }
        return b;
    }

    public a.b j() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "383452137") ? (a.b) ipChange.ipc$dispatch("383452137", new Object[]{this}) : new a.b().i("collect");
    }

    public a.b k(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2036622515")) {
            return (a.b) ipChange.ipc$dispatch("2036622515", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("titlelabel", str);
        return e("collect", "list", "cancel_btn_" + i, hashMap, Boolean.FALSE);
    }

    public a.b l(String str, int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1818467916")) {
            return (a.b) ipChange.ipc$dispatch("1818467916", new Object[]{this, str, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("titlelabel", str);
        return e("collect", "list", "item_" + i, hashMap, Boolean.TRUE);
    }

    public a.b n(String str, String str2, int i, int i2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-570806229")) {
            return (a.b) ipChange.ipc$dispatch("-570806229", new Object[]{this, str, str2, Integer.valueOf(i), Integer.valueOf(i2)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("titlelabel", str);
        hashMap.put(pb.PRE_CONTENT_ID, str2);
        if (i == 13) {
            hashMap.put(pb.PRE_CONTENT_TYPE, "ranklist");
        } else {
            hashMap.put(pb.PRE_CONTENT_TYPE, u70.DETAILED_PAGE);
        }
        return e("collect", "collection", "item_" + i2, hashMap, Boolean.TRUE);
    }

    public a.b o(int i) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-11676593")) {
            return (a.b) ipChange.ipc$dispatch("-11676593", new Object[]{this, Integer.valueOf(i)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        return e("collect", "live", "item_" + i, hashMap, Boolean.TRUE);
    }

    public a.b p(int i, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "378807320")) {
            return (a.b) ipChange.ipc$dispatch("378807320", new Object[]{this, Integer.valueOf(i), str});
        }
        HashMap hashMap = new HashMap();
        hashMap.put("usercode", z20.E());
        hashMap.put("titlelabel", str);
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return e("collect", "top", "list", hashMap, Boolean.FALSE);
                }
                return e("collect", "top", "collection", hashMap, Boolean.FALSE);
            }
            return e("collect", "top", "live", hashMap, Boolean.FALSE);
        }
        return e("collect", "top", "list", hashMap, Boolean.FALSE);
    }
}
