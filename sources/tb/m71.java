package tb;

import android.content.SharedPreferences;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class m71 {
    private static SharedPreferences a;
    private static SharedPreferences.Editor b;

    public static SharedPreferences.Editor a() {
        b();
        return b;
    }

    private static void b() {
        if (b == null) {
            c();
            b = a.edit();
        }
    }

    private static void c() {
        if (a == null) {
            a = gu0.a.getSharedPreferences("deviceevaluator", 0);
        }
    }
}
