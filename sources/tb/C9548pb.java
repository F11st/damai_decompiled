package tb;

import android.text.TextUtils;
import cn.damai.common.user.C0525a;
import cn.damai.common.user.C0528b;
import cn.damai.common.user.C0529c;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: tb.pb */
/* loaded from: classes.dex */
public class C9548pb extends C0528b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String CNT_CONTENT_ID = "cnt_content_id";
    public static final String CNT_CONTENT_TYPE = "cnt_content_type";
    public static final int N_2001 = 2001;
    public static final int N_2101 = 2101;
    public static final String PRE_CONTENT_ID = "pre_content_id";
    public static final String PRE_CONTENT_TYPE = "pre_content_type";
    public static final String PUBLISHER_ID = "publisher_id";
    public static final String TYPE_NOTE = "note";
    public static final String TYPE_THEME = "theme";

    public static void f(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1836859709")) {
            ipChange.ipc$dispatch("1836859709", new Object[]{map});
        } else {
            h("city", z20.d(), map);
        }
    }

    public static void g(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1323144577")) {
            ipChange.ipc$dispatch("-1323144577", new Object[]{map});
        } else {
            h("usercode", z20.E(), map);
        }
    }

    public static void h(String str, String str2, Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-724255946")) {
            ipChange.ipc$dispatch("-724255946", new Object[]{str, str2, map});
        } else if (map == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
        } else {
            map.put(str, str2);
        }
    }

    public static boolean i(int i) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1558121010") ? ((Boolean) ipChange.ipc$dispatch("-1558121010", new Object[]{Integer.valueOf(i)})).booleanValue() : i == 2001;
    }

    public static void j(C0525a.C0527b c0527b) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-363124580")) {
            ipChange.ipc$dispatch("-363124580", new Object[]{c0527b});
        } else {
            C0529c.e().x(c0527b);
        }
    }
}
