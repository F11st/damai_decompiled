package tb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class m61 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static <T> T a(String str, Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2068616300")) {
            return (T) ipChange.ipc$dispatch("2068616300", new Object[]{str, cls});
        }
        try {
            return (T) JSON.parseObject(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T b(String str, Class<T> cls, String str2, String str3, String str4, String str5) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1428762812")) {
            return (T) ipChange.ipc$dispatch("-1428762812", new Object[]{str, cls, str2, str3, str4, str5});
        }
        try {
            return (T) JSON.parseObject(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            String name = cls.getName();
            b23.c(str2, "mtop", str3, "JSON.parseObject错误", b23.i(name, str2, str4, str5 + " trace=" + zm2.a(e), str));
            return null;
        }
    }

    public static JSONObject c(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2088825485")) {
            return (JSONObject) ipChange.ipc$dispatch("-2088825485", new Object[]{str});
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return JSON.parseObject(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T d(JSON json, Class<T> cls) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2070389")) {
            return (T) ipChange.ipc$dispatch("2070389", new Object[]{json, cls});
        }
        try {
            return (T) a(json.toJSONString(), cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String e(Object obj) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1596796339")) {
            return (String) ipChange.ipc$dispatch("-1596796339", new Object[]{obj});
        }
        if (obj != null) {
            try {
                return JSON.toJSONString(obj);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
