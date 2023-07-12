package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.utils.Logger;
import com.ta.audid.Constants;
import com.ut.device.UTDevice;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class bt2 extends zs2 {
    private static bt2 e;
    private Map<String, a> a = new HashMap();
    private int b = 10;
    private int c = 0;
    private int d = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes5.dex */
    public static class a {
        private Map<String, String> a = new HashMap();
        private Map<String, String> b = new HashMap();
        private int c = 0;

        private a() {
        }

        private String b(Map<String, String> map, String str) {
            if (str != null) {
                for (String str2 : map.keySet()) {
                    if (str2.startsWith("%") && str2.endsWith("%")) {
                        if (str.contains(str2.substring(1, str2.length() - 1))) {
                            return map.get(str2);
                        }
                    } else if (str.equals(str2)) {
                        return map.get(str2);
                    }
                }
                return null;
            }
            return null;
        }

        public static a c(String str) {
            try {
                a aVar = new a();
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("tp")) {
                    aVar.c = bt2.e(jSONObject.optString("tp"));
                }
                if (jSONObject.has("pg")) {
                    HashMap hashMap = new HashMap();
                    JSONObject optJSONObject = jSONObject.optJSONObject("pg");
                    if (optJSONObject != null) {
                        Iterator<String> keys = optJSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            hashMap.put(next, optJSONObject.optString(next));
                        }
                    }
                    aVar.a = hashMap;
                }
                if (jSONObject.has("arg1")) {
                    HashMap hashMap2 = new HashMap();
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("arg1");
                    if (optJSONObject2 != null) {
                        Iterator<String> keys2 = optJSONObject2.keys();
                        while (keys2.hasNext()) {
                            String next2 = keys2.next();
                            hashMap2.put(next2, optJSONObject2.optString(next2));
                        }
                    }
                    aVar.b = hashMap2;
                }
                return aVar;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public int a(String str, String str2) {
            String b;
            String b2;
            if (!yh2.f(str) && (b2 = b(this.a, str)) != null) {
                return bt2.e(b2);
            }
            if (!yh2.f(str2) && (b = b(this.b, str2)) != null) {
                return bt2.e(b);
            }
            return this.c;
        }
    }

    private bt2() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e2) {
            Logger.f("", e2);
            return 0;
        }
    }

    public static bt2 g() {
        if (e == null) {
            e = new bt2();
        }
        return e;
    }

    private int h(String str, String str2, String str3) {
        a aVar;
        if (TextUtils.isEmpty(str) || !this.a.containsKey(str) || (aVar = this.a.get(str)) == null) {
            return 0;
        }
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return aVar.a(str2, str3);
        }
        return 0;
    }

    @Override // tb.zs2
    public String[] a() {
        return new String[]{"ut_realtime"};
    }

    @Override // tb.zs2
    public void b(String str) {
        super.b(str);
    }

    @Override // tb.zs2
    public synchronized void c(String str, Map<String, String> map) {
        Logger.f("", "aGroupname", str, "aConfContent", map);
        l();
        for (String str2 : map.keySet()) {
            String str3 = map.get(str2);
            if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                if (str2.equals("time")) {
                    int e2 = e(str3);
                    if (e2 >= 3 && e2 <= 20) {
                        this.b = e2;
                    }
                } else if (str2.equals("sample")) {
                    int e3 = e(str3);
                    if (e3 >= 0 && e3 <= 10000) {
                        this.c = e3;
                    }
                } else {
                    a c = a.c(str3);
                    if (c != null) {
                        this.a.put(str2, c);
                    }
                }
            }
        }
    }

    public int f() {
        return this.b;
    }

    public synchronized int i(Map<String, String> map) {
        String str;
        String str2;
        LogField logField;
        LogField logField2 = LogField.EVENTID;
        str = map.containsKey(logField2.toString()) ? map.get(logField2.toString()) : "";
        LogField logField3 = LogField.PAGE;
        str2 = map.containsKey(logField3.toString()) ? map.get(logField3.toString()) : null;
        logField = LogField.ARG1;
        return h(str, str2, map.containsKey(logField.toString()) ? map.get(logField.toString()) : null);
    }

    public boolean j() {
        return Variables.n().N() || Variables.n().J() || Variables.n().F();
    }

    public boolean k() {
        if (j()) {
            return false;
        }
        if (Variables.n().m()) {
            return true;
        }
        if (this.d == -1) {
            String utdid = UTDevice.getUtdid(Variables.n().j());
            if (utdid == null || utdid.equals(Constants.UTDID_INVALID)) {
                return false;
            }
            this.d = Math.abs(yh2.d(utdid));
        }
        Logger.r("", "hashcode", Integer.valueOf(this.d), "sample", Integer.valueOf(this.c));
        return this.d % 10000 < this.c;
    }

    public void l() {
        this.a.clear();
        this.b = 10;
        this.c = 0;
    }
}
