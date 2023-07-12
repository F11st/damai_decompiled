package tb;

import android.text.TextUtils;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.ut.mini.behavior.edgecomputing.datacollector.core.UTDataCollectorNodeColumn;
import com.youku.middlewareservice.provider.analytics.TrackerConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class rv2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String SPMCNT = "spm-cnt";
    public static final String SPMURL = "spm-url";
    public static final String UTPARAM = "utparam";
    public static final String UTPARAM_CNT = "utparam-cnt";
    public static final String UTPARAM_URL = "utparam-url";
    private static HashMap<String, String> a = new HashMap<>();
    private static HashMap<String, String> b = new HashMap<>();
    private static String c = "";

    private static void a(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "870999660")) {
            ipChange.ipc$dispatch("870999660", new Object[]{str, str2});
        } else if (TextUtils.isEmpty(str2)) {
        } else {
            a.put(str, str2);
        }
    }

    public static Map<String, String> b(Map<String, String> map) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "935341657")) {
            return (Map) ipChange.ipc$dispatch("935341657", new Object[]{map});
        }
        String str = map.get("spm-cnt");
        if (TextUtils.isEmpty(str)) {
            return map;
        }
        if (str.indexOf("/") != -1) {
            str.substring(0, str.indexOf("/"));
        }
        HashMap hashMap = new HashMap(map.size());
        hashMap.putAll(map);
        String str2 = (String) hashMap.get("utparam-cnt");
        if (TextUtils.isEmpty(null)) {
            if (TextUtils.isEmpty(str2)) {
                str2 = "{\"abtest\":\"0\"}";
            }
            hashMap.put("utparam-cnt", str2);
            return hashMap;
        }
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "{}";
            }
            JSONObject jSONObject = new JSONObject(str2);
            String optString = jSONObject.optString("yk_abtest");
            if (TextUtils.isEmpty(optString)) {
                jSONObject.put("yk_abtest", (Object) null);
            } else {
                StringBuilder sb = new StringBuilder();
                if (optString.contains("|")) {
                    StringTokenizer stringTokenizer = new StringTokenizer(optString, "|");
                    if (!stringTokenizer.hasMoreTokens()) {
                        sb.append((String) null);
                        jSONObject.put("yk_abtest", sb.toString());
                    } else {
                        stringTokenizer.nextToken();
                        throw null;
                    }
                } else {
                    throw null;
                }
            }
            hashMap.put("utparam-cnt", jSONObject.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashMap;
    }

    public static void c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1360889896")) {
            ipChange.ipc$dispatch("-1360889896", new Object[0]);
        } else {
            a.clear();
        }
    }

    public static HashMap<String, String> d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "2040825874") ? (HashMap) ipChange.ipc$dispatch("2040825874", new Object[0]) : a;
    }

    public static void e(Map<String, String> map) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1033483842")) {
            ipChange.ipc$dispatch("1033483842", new Object[]{map});
            return;
        }
        b.put("spm-url", d().get("spm-url"));
        b.put(TrackerConstants.VVLINK, d().get(TrackerConstants.VVLINK));
        b.put(TrackerConstants.TRACK_INFO, d().get(TrackerConstants.TRACK_INFO));
        b.put("scg_id", d().get("scg_id"));
        b.put("scm", d().get("scm"));
        b.put("utparam-url", d().get("utparam-url"));
        String str11 = "";
        if (map != null) {
            str3 = map.get(UTDataCollectorNodeColumn.OBJECT_TYPE);
            str4 = map.get(UTDataCollectorNodeColumn.OBJECT_ID);
            str5 = map.get("object_num");
            str6 = map.get(RetryMonitorDbHelper.COLUMN_GROUP_ID);
            str7 = map.get("group_num");
            str8 = map.get(TrackerConstants.TRACK_INFO);
            str9 = map.get("scg_id");
            String str12 = map.get("scm");
            str = map.get("utparam");
            str2 = map.get("spm");
            str10 = "";
            str11 = str12;
        } else {
            str = "";
            str2 = str;
            str3 = str2;
            str4 = str3;
            str5 = str4;
            str6 = str5;
            str7 = str6;
            str8 = str7;
            str9 = str8;
            str10 = str9;
        }
        c();
        a("spm-url", str2);
        a(TrackerConstants.TRACK_INFO, str8);
        a("scm", str11);
        a("utparam-url", str);
        a("r_object_type", str3);
        a("r_object_id", str4);
        a("r_object_num", str5);
        a("r_group_id", str6);
        a("r_group_num", str7);
        a("scg_id", str9);
        if (!TextUtils.isEmpty(c)) {
            a.put(TrackerConstants.VVLINK, c);
            g(str10);
        } else if (TextUtils.isEmpty(b.get(TrackerConstants.VVLINK))) {
        } else {
            a.put(TrackerConstants.VVLINK, b.get(TrackerConstants.VVLINK));
        }
    }

    public static void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-751958550")) {
            ipChange.ipc$dispatch("-751958550", new Object[]{str});
        }
    }

    public static void g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2108192971")) {
            ipChange.ipc$dispatch("2108192971", new Object[]{str});
        } else {
            c = str;
        }
    }
}
