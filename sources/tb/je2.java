package tb;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class je2 {
    private final Map<String, ie2> a;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private static class b {
        private static final je2 a = new je2();
    }

    public static je2 c() {
        return b.a;
    }

    public void a() {
        synchronized (this.a) {
            this.a.clear();
        }
    }

    public ie2 b(String str) {
        ie2 ie2Var;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.a) {
            ie2Var = this.a.get(str);
        }
        return ie2Var;
    }

    public void d(ie2 ie2Var) {
        if (ie2Var != null) {
            synchronized (this.a) {
                for (String str : ie2Var.c().keySet()) {
                    ie2 ie2Var2 = this.a.get(str);
                    if (ie2Var2 != null) {
                        if (ie2Var.e() >= ie2Var2.e()) {
                            this.a.put(str, ie2Var);
                        }
                    } else {
                        this.a.put(str, ie2Var);
                    }
                }
            }
        }
    }

    private je2() {
        this.a = new HashMap();
    }
}
