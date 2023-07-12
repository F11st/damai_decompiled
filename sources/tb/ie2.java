package tb;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ie2 {
    private final int a;
    private final String b;
    private final Map<String, ee2> c = new HashMap();

    public ie2(int i, String str) {
        this.a = i;
        this.b = str;
    }

    public void a(ee2 ee2Var) {
        if (ee2Var != null) {
            this.c.put(ee2Var.a(), ee2Var);
        }
    }

    public ee2 b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.c.get(str);
    }

    public Map<String, ee2> c() {
        return this.c;
    }

    public String d() {
        return this.b;
    }

    public int e() {
        return this.a;
    }

    public int f() {
        return this.c.size();
    }

    public String toString() {
        return this.c.keySet().toString();
    }
}
