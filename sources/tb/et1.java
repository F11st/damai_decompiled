package tb;

import android.content.SharedPreferences;
import com.alibaba.poplayer.PopLayer;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class et1 {
    public static final String SP_POPLAYER = "sp_poplayer_xxx_yyy_zzz";

    public static void a() {
        SharedPreferences c = c();
        if (c == null) {
            return;
        }
        c.edit().clear().apply();
    }

    public static int b(String str, int i) {
        SharedPreferences c = c();
        return c == null ? i : c.getInt(str, i);
    }

    private static SharedPreferences c() {
        if (PopLayer.getReference() == null || PopLayer.getReference().getApp() == null) {
            return null;
        }
        return PopLayer.getReference().getApp().getSharedPreferences(SP_POPLAYER, 0);
    }

    public static int d(String str) {
        SharedPreferences c = c();
        if (c == null) {
            return -1;
        }
        int i = c.getInt(str, 0) + 1;
        c.edit().putInt(str, i).apply();
        return i;
    }
}
