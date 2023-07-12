package cn.damai.common.user;

import android.text.TextUtils;
import cn.damai.common.user.a;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class b {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final b a = new b();
    public static final String alg_m = "alg";
    public static final String city_m = "city";
    public static final String contentlabel_m = "contentlabel";
    public static final String item_id_m = "item_id";
    public static final String keyword_m = "keyword";
    public static final String orderid_m = "orderid";
    public static final String tel_m = "tel";
    public static final String titlelabel_m = "titlelabel";
    public static final String usercode_m = "usercode";

    private void a(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "871454830")) {
            ipChange.ipc$dispatch("871454830", new Object[]{this, map});
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

    public static b getInstance() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "355279257") ? (b) ipChange.ipc$dispatch("355279257", new Object[0]) : a;
    }

    public a.b b(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "439428500") ? (a.b) ipChange.ipc$dispatch("439428500", new Object[]{this, str}) : new a.b().i(str);
    }

    public a.b c(String str, String str2, String str3, Boolean bool) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-439180615") ? (a.b) ipChange.ipc$dispatch("-439180615", new Object[]{this, str, str2, str3, bool}) : e(str, str2, str3, new HashMap(), bool);
    }

    public a.b d(String str, String str2, String str3, String str4, Map<String, String> map, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-993389292")) {
            return (a.b) ipChange.ipc$dispatch("-993389292", new Object[]{this, str, str2, str3, str4, map, bool});
        }
        a(map);
        return new a.b().i(str).f(str2).l(str3).c(str4).g(bool.booleanValue()).j(map);
    }

    public a.b e(String str, String str2, String str3, Map<String, String> map, Boolean bool) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1140722550")) {
            return (a.b) ipChange.ipc$dispatch("-1140722550", new Object[]{this, str, str2, str3, map, bool});
        }
        a(map);
        return new a.b().i(str).f(str2).l(str3).g(bool.booleanValue()).j(map);
    }
}
