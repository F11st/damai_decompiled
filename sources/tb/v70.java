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
    private Map<String, a> a = new ConcurrentHashMap();
    private volatile long d = ConfigStorage.DEFAULT_MAX_AGE;
    private SharedPreferences b = PreferenceManager.getDefaultSharedPreferences(hu0.c());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class a {
        long a;
        boolean b;

        a() {
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
                a aVar = new a();
                String string2 = jSONObject.getString("networkUniqueId");
                aVar.a = jSONObject.getLong("time");
                aVar.b = jSONObject.getBoolean("enable");
                if (c(aVar.a)) {
                    synchronized (this.a) {
                        this.a.put(string2, aVar);
                    }
                }
            }
            ALog.e("awcn.DetectHistoryRecord", "DetectHistoryRecord load success.", null, "fileName", str, "content", jSONArray.toString());
        } catch (JSONException unused) {
        }
    }

    public int a(String str) {
        synchronized (this.a) {
            a aVar = this.a.get(str);
            if (aVar != null) {
                return aVar.b ? 1 : 0;
            }
            return -1;
        }
    }

    public boolean b(String str) {
        synchronized (this.a) {
            a aVar = this.a.get(str);
            boolean z = true;
            if (aVar == null) {
                return true;
            }
            if (c(aVar.a)) {
                z = false;
            }
            return z;
        }
    }

    public boolean c(long j) {
        return System.currentTimeMillis() - j < this.d;
    }

    public void e(String str, boolean z) {
        a aVar = new a();
        aVar.b = z;
        aVar.a = System.currentTimeMillis();
        JSONArray jSONArray = new JSONArray();
        synchronized (this.a) {
            this.a.put(str, aVar);
            for (Map.Entry<String, a> entry : this.a.entrySet()) {
                String key = entry.getKey();
                a value = entry.getValue();
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
