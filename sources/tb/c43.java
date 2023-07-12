package tb;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import tb.n73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class c43 extends z0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        private static final c43 a = new c43((byte) 0);
    }

    private c43() {
    }

    /* synthetic */ c43(byte b) {
        this();
    }

    public static c43 d() {
        return a.a;
    }

    private static void e(@NonNull l01 l01Var) {
        n73 n73Var;
        n73Var = n73.a.a;
        n73Var.d(String.valueOf(l01Var.b()), l01Var.a(), l01Var.c());
    }

    @Override // com.efs.sdk.base.a.h.a.b
    public final /* bridge */ /* synthetic */ void a(@NonNull com.efs.sdk.base.a.h.a.c<l01> cVar, @Nullable l01 l01Var) {
        l01 l01Var2 = l01Var;
        if (l01Var2 != null) {
            u23.c();
            u23.d(l01Var2);
        }
    }

    @Override // tb.z0
    public final void a(@Nullable l01 l01Var) {
        if (l01Var == null) {
            return;
        }
        e(l01Var);
    }

    @Override // tb.z0
    public final void b(@NonNull l01 l01Var) {
        n73 n73Var;
        e(l01Var);
        if (((Map) l01Var.d).containsKey("cver")) {
            String str = (String) ((Map) l01Var.d).get("cver");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            int parseInt = Integer.parseInt(str);
            n73Var = n73.a.a;
            if (n73Var.b == null || !com.efs.sdk.base.a.d.a.a().d) {
                return;
            }
            o43 o43Var = new o43("efs_core", "config_coverage", n73Var.a.c);
            o43Var.a("cver", Integer.valueOf(parseInt));
            n73Var.b.b(o43Var);
        }
    }
}
