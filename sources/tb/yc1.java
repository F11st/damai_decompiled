package tb;

import android.text.TextUtils;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Iterator;
import java.util.Map;
import tb.kc;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class yc1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String alg_m = "alg";
    public static final String city_m = "city";
    public static final String contentlabel_m = "contentlabel";
    public static final String item_id_m = "item_id";
    public static final String keyword_m = "keyword";
    public static final String orderid_m = "orderid";
    public static final String tel_m = "tel";
    public static final String titlelabel_m = "titlelabel";
    public static final String usercode_m = "usercode";

    static {
        new yc1();
    }

    private void a(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1659176160")) {
            ipChange.ipc$dispatch("1659176160", new Object[]{this, map});
        } else if (map == null || map.size() <= 0) {
        } else {
            Iterator<String> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (TextUtils.isEmpty(it.next())) {
                    it.remove();
                }
            }
        }
    }

    public kc.b b(String str, String str2, String str3, Map<String, String> map, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "787554902")) {
            return (kc.b) ipChange.ipc$dispatch("787554902", new Object[]{this, str, str2, str3, map, bool});
        }
        a(map);
        return new kc.b().c(str).a(str2).e(str3).b(bool.booleanValue()).d(map);
    }
}
