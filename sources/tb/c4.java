package tb;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.asp.APreferencesManager;
import com.taobao.accs.client.ClientManager;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.android.agoo.common.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class c4 {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";
    private ConcurrentMap<String, Integer> a = new ConcurrentHashMap();
    private String b;
    private long c;
    private Context d;

    public c4(Context context) {
        if (context != null) {
            this.d = context.getApplicationContext();
            return;
        }
        throw new RuntimeException("Context is null!!");
    }

    private void f() {
        try {
            String string = APreferencesManager.getSharedPreferences(this.d, "AGOO_BIND", 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.w("AgooBindCache", "restoreAgooClients packs null return", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.c = jSONArray.getLong(0);
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.c;
            if (currentTimeMillis < 86400000 + j) {
                for (int i = 1; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    this.a.put(jSONObject.getString("p"), Integer.valueOf(jSONObject.getInt("s")));
                }
                ALog.i("AgooBindCache", "restoreAgooClients", "mAgooBindStatus", this.a);
                return;
            }
            ALog.i("AgooBindCache", "restoreAgooClients expired", "agooLastFlushTime", Long.valueOf(j));
            this.c = 0L;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean a(String str) {
        String str2 = this.b;
        return str2 != null && str2.equals(str);
    }

    public boolean b(String str) {
        if (this.a.isEmpty()) {
            f();
        }
        Integer num = this.a.get(str);
        ALog.i("AgooBindCache", "isAgooRegistered", "packageName", str, "appStatus", num, "agooBindStatus", this.a);
        return (UtilityImpl.utdidChanged(Config.PREFERENCES, this.d) || num == null || num.intValue() != 2) ? false : true;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b = str;
    }

    public void d() {
        this.b = null;
    }

    public void e(String str) {
        Integer num = this.a.get(str);
        if (num == null || num.intValue() != 2) {
            this.a.put(str, 2);
            ClientManager.saveClients(this.d, "AGOO_BIND", this.c, this.a);
        }
    }
}
