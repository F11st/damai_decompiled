package tb;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class vu2 {
    private Map<String, SharedPreferences> a;

    /* compiled from: Taobao */
    /* renamed from: tb.vu2$b */
    /* loaded from: classes9.dex */
    private static class C9830b {
        private static final vu2 a = new vu2();
    }

    public static vu2 b() {
        return C9830b.a;
    }

    public SharedPreferences a(Context context, String str) {
        SharedPreferences sharedPreferences = this.a.get(str);
        if (sharedPreferences == null) {
            synchronized (vu2.class) {
                sharedPreferences = this.a.get(str);
                if (sharedPreferences == null) {
                    SharedPreferences sharedPreferences2 = context.getSharedPreferences(str + ih0.p, 0);
                    this.a.put(str, sharedPreferences2);
                    sharedPreferences = sharedPreferences2;
                }
            }
        }
        return sharedPreferences;
    }

    private vu2() {
        this.a = new HashMap();
    }
}
