package tb;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.taobao.windvane.util.ConfigStorage;
import android.text.TextUtils;
import anet.channel.util.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class v70 {
    private String c;
    private Map<String, C9810a> a = new ConcurrentHashMap();
    private volatile long d = ConfigStorage.DEFAULT_MAX_AGE;
    private SharedPreferences b = PreferenceManager.getDefaultSharedPreferences(hu0.c());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.v70$a */
    /* loaded from: classes.dex */
    public static class C9810a {
        long a;
        boolean b;

        C9810a() {
        }
    }

    public v70(String str) {
        this.c = "default_detect";
        this.c = str;
        d(this.c);
    }

    private void d(String str) {
        String string = this.b.getString(str, null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                C9810a c9810a = new C9810a();
                String string2 = jSONObject.getString("networkUniqueId");
                c9810a.a = jSONObject.getLong("time");
                c9810a.b = jSONObject.getBoolean("enable");
                if (c(c9810a.a)) {
                    synchronized (this.a) {
                        this.a.put(string2, c9810a);
                    }
                }
            }
            ALog.e("awcn.DetectHistoryRecord", "DetectHistoryRecord load success.", null, "fileName", str, "content", jSONArray.toString());
        } catch (JSONException unused) {
        }
    }

    public int a(String str) {
        synchronized (this.a) {
            C9810a c9810a = this.a.get(str);
            if (c9810a != null) {
                return c9810a.b ? 1 : 0;
            }
            return -1;
        }
    }

    public boolean b(String str) {
        synchronized (this.a) {
            C9810a c9810a = this.a.get(str);
            boolean z = true;
            if (c9810a == null) {
                return true;
            }
            if (c(c9810a.a)) {
                z = false;
            }
            return z;
        }
    }

    public boolean c(long j) {
        return System.currentTimeMillis() - j < this.d;
    }

    public void e(String str, boolean z) {
        C9810a c9810a = new C9810a();
        c9810a.b = z;
        c9810a.a = System.currentTimeMillis();
        JSONArray jSONArray = new JSONArray();
        synchronized (this.a) {
            this.a.put(str, c9810a);
            for (Map.Entry<String, C9810a> entry : this.a.entrySet()) {
                String key = entry.getKey();
                C9810a value = entry.getValue();
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("networkUniqueId", key);
                    jSONObject.put("time", value.a);
                    jSONObject.put("enable", value.b);
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        this.b.edit().putString(this.c, jSONArray.toString()).apply();
    }
}
