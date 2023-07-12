package tb;

import android.text.TextUtils;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ya1 implements SystemConfigMgr.IKVChangeListener {
    private static ya1 b;
    private Map<String, String> a = Collections.synchronizedMap(new HashMap());

    ya1() {
        SystemConfigMgr.i().l("loglevel", this);
        onChange("loglevel", SystemConfigMgr.i().h("loglevel"));
    }

    public static synchronized ya1 b() {
        ya1 ya1Var;
        synchronized (ya1.class) {
            if (b == null) {
                b = new ya1();
            }
            ya1Var = b;
        }
        return ya1Var;
    }

    public String a(String str) {
        return this.a.get(str);
    }

    public String c(String str) {
        String a = a(str);
        return !TextUtils.isEmpty(a) ? a : "3";
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        this.a.clear();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String optString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
                    this.a.put(next, optString);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
