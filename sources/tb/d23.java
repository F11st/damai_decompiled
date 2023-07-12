package tb;

import android.text.TextUtils;
import cn.damai.tetris.core.TrackInfo;
import com.alibaba.fastjson.JSONObject;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class d23 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static void a(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-215733716")) {
            ipChange.ipc$dispatch("-215733716", new Object[]{hashMap});
        } else if (hashMap != null) {
            String d = z20.d();
            if (TextUtils.isEmpty(d)) {
                return;
            }
            hashMap.put("city", d);
        }
    }

    public static void b(HashMap<String, String> hashMap, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "256765404")) {
            ipChange.ipc$dispatch("256765404", new Object[]{hashMap, str});
        } else if (hashMap == null || TextUtils.isEmpty(str)) {
        } else {
            hashMap.put("titlelabel", str);
        }
    }

    public static void c(HashMap<String, String> hashMap) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "959439470")) {
            ipChange.ipc$dispatch("959439470", new Object[]{hashMap});
        } else if (hashMap != null) {
            String E = z20.E();
            if (TextUtils.isEmpty(E)) {
                return;
            }
            hashMap.put("usercode", E);
        }
    }

    public static HashMap<String, String> d() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-444911968") ? (HashMap) ipChange.ipc$dispatch("-444911968", new Object[0]) : new HashMap<>();
    }

    public static TrackInfo e(String str, JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1156975412")) {
            return (TrackInfo) ipChange.ipc$dispatch("1156975412", new Object[]{str, jSONObject});
        }
        if (jSONObject == null || jSONObject.getJSONObject(str) == null || jSONObject.getJSONObject(str).getJSONObject("trackInfo") == null) {
            return null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject(str).getJSONObject("trackInfo");
        TrackInfo trackInfo = new TrackInfo();
        trackInfo.putAll(jSONObject2);
        trackInfo.trackA = jSONObject2.getString("spma");
        trackInfo.trackB = jSONObject2.getString("spmb");
        trackInfo.trackC = jSONObject2.getString("spmc");
        trackInfo.trackD = jSONObject2.getString("spmd");
        if (!TextUtils.isEmpty(jSONObject2.getString("titlelabel"))) {
            trackInfo.put("titlelabel", (Object) jSONObject2.getString("titlelabel"));
        }
        if (!TextUtils.isEmpty(jSONObject2.getString("contentlabel"))) {
            trackInfo.put("contentlabel", (Object) jSONObject2.getString("contentlabel"));
        }
        trackInfo.put("city", (Object) z20.d());
        trackInfo.putAll(jSONObject2.getJSONObject("args"));
        return trackInfo;
    }

    public static HashMap<String, String> f() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1744018695")) {
            return (HashMap) ipChange.ipc$dispatch("-1744018695", new Object[0]);
        }
        HashMap<String, String> d = d();
        c(d);
        a(d);
        return d;
    }

    public static HashMap<String, String> g() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-501420729")) {
            return (HashMap) ipChange.ipc$dispatch("-501420729", new Object[0]);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("usercode", z20.E());
        return hashMap;
    }

    public static void h(HashMap<String, String> hashMap, String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-340291096")) {
            ipChange.ipc$dispatch("-340291096", new Object[]{hashMap, str, str2});
        } else if (hashMap == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
        } else {
            hashMap.put(str, str2);
        }
    }
}
