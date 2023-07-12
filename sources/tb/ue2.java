package tb;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ue2 {
    public static final String FILE_NAME = "taomai.h5cache";
    public static final String KEY_FILM_DETAIL_HIGHLIGHT_FIRST_PRE = "highlight_first_0";
    public static final String KEY_FILM_DETAIL_MOVIEDATE_FIRST_PRE = "moviedate_first_0";
    @Nullable
    private static ue2 c;
    private Context a;
    private int b;

    private ue2() {
    }

    @NonNull
    public static synchronized ue2 a() {
        ue2 c2;
        synchronized (ue2.class) {
            c2 = c(yk2.a, 0);
        }
        return c2;
    }

    @NonNull
    public static synchronized ue2 b(@NonNull Context context) {
        ue2 c2;
        synchronized (ue2.class) {
            c2 = c(context, 0);
        }
        return c2;
    }

    @NonNull
    public static synchronized ue2 c(@NonNull Context context, int i) {
        ue2 ue2Var;
        synchronized (ue2.class) {
            if (c == null) {
                c = new ue2();
            }
            c.a = context.getApplicationContext();
            ue2Var = c;
            ue2Var.b = i;
        }
        return ue2Var;
    }

    @NonNull
    public String d(@NonNull String str) {
        SharedPreferences sharedPreferences = this.a.getSharedPreferences(FILE_NAME, this.b);
        return sharedPreferences == null ? "" : sharedPreferences.getString(str, "");
    }

    public void e(@NonNull String str, @NonNull String str2) {
        this.a.getSharedPreferences(FILE_NAME, this.b).edit().putString(str, str2).apply();
    }

    public void f(@NonNull String str) {
        this.a.getSharedPreferences(FILE_NAME, this.b).edit().remove(str).apply();
    }
}
