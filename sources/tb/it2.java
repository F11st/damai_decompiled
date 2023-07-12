package tb;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.rl2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class it2 {
    private static Map<String, it2> f = new HashMap();
    private final rl2 a;
    private volatile List<String> b;
    private final LruCache<String, JSONObject> c = new LruCache<>(16);
    private final LruCache<String, ve> d = new LruCache<>(4);
    private final Object e = new Object();

    private it2(Context context, String str) {
        String str2 = str + "_ultron_template_cache";
        this.a = new rl2.C9655b().h(context.getApplicationContext()).i(str2 + ".db").l(str2).k(1).j(16777216L).g();
    }

    public static it2 d(Context context, @NonNull String str) {
        it2 it2Var = f.get(str);
        if (it2Var == null) {
            synchronized (it2.class) {
                it2Var = f.get(str);
                if (it2Var == null) {
                    Map<String, it2> map = f;
                    it2 it2Var2 = new it2(context, str);
                    map.put(str, it2Var2);
                    it2Var = it2Var2;
                }
            }
        }
        return it2Var;
    }

    public void a(String str) {
        synchronized (this.e) {
            this.d.remove(str);
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.e) {
            if (this.b != null) {
                this.b.remove(str);
            }
            this.c.remove(str);
        }
        this.a.c(str);
    }

    public ve c(String str) {
        return this.d.get(str);
    }

    public JSONObject e(String str) {
        JSONObject jSONObject;
        byte[] d;
        synchronized (this.e) {
            jSONObject = this.c.get(str);
        }
        if (jSONObject == null && (d = this.a.d(str)) != null && (jSONObject = JSON.parseObject(new String(d, Charset.forName("UTF-8")))) != null) {
            synchronized (this.e) {
                this.c.put(str, jSONObject);
            }
        }
        return jSONObject;
    }

    public List<String> f() {
        if (this.b == null) {
            List<String> f2 = this.a.f();
            synchronized (this.e) {
                if (this.b == null) {
                    this.b = f2;
                }
            }
        }
        return this.b == null ? Collections.emptyList() : this.b;
    }

    public void g(String str, ve veVar) {
        if (TextUtils.isEmpty(str) || veVar == null) {
            return;
        }
        synchronized (this.e) {
            this.d.put(str, veVar);
        }
    }

    public void h(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return;
        }
        try {
            synchronized (this.e) {
                if (this.b != null && !this.b.contains(str)) {
                    this.b.add(str);
                }
                if (this.c.get(str) == null) {
                    this.c.put(str, jSONObject);
                }
            }
            this.a.i(str, jSONObject.toJSONString().getBytes(Charset.forName("UTF-8")));
        } catch (Throwable th) {
            vt2.b("UltronTemplateManager", "saveTemplate", Log.getStackTraceString(th));
        }
    }
}
