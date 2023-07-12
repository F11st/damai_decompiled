package tb;

import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import tb.n73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class s53 extends z0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a {
        private static final s53 a = new s53((byte) 0);
    }

    private s53() {
    }

    /* synthetic */ s53(byte b) {
        this();
    }

    public static s53 d() {
        return a.a;
    }

    private static void e(@Nullable l01 l01Var) {
        String str;
        if (com.efs.sdk.base.a.d.a.a().d()) {
            if (l01Var == null) {
                str = "upload result : false";
            } else {
                str = "upload result : " + l01Var.a + ", resp is " + l01Var.toString();
            }
            w63.a("efs.px.api", str);
        }
    }

    private static void f(l01 l01Var) {
        n73 n73Var;
        n73Var = n73.a.a;
        n73Var.d(String.valueOf(l01Var.b()), l01Var.a(), l01Var.c());
    }

    private static void g(l01 l01Var) {
        int parseInt;
        if (((Map) l01Var.d).containsKey("cver")) {
            String str = (String) ((Map) l01Var.d).get("cver");
            if (!TextUtils.isEmpty(str) && (parseInt = Integer.parseInt(str)) > com.efs.sdk.base.a.c.a.c.a().e.a) {
                com.efs.sdk.base.a.c.a.c.a().d(parseInt);
            }
        }
    }

    @Override // com.efs.sdk.base.a.h.a.b
    public final /* synthetic */ void a(@NonNull com.efs.sdk.base.a.h.a.c<l01> cVar, @Nullable l01 l01Var) {
        l01 l01Var2 = l01Var;
        if (l01Var2 != null) {
            com.efs.sdk.base.a.h.b.a aVar = (com.efs.sdk.base.a.h.b.a) cVar;
            ((Map) l01Var2.d).putAll(aVar.f);
            aVar.f.clear();
            u23.c();
            u23.d(l01Var2);
        }
    }

    @Override // tb.z0
    public final void a(@Nullable l01 l01Var) {
        e(l01Var);
        if (l01Var == null) {
            return;
        }
        f(l01Var);
        g(l01Var);
    }

    @Override // tb.z0
    public final void b(@NonNull l01 l01Var) {
        int i;
        n73 n73Var;
        if (!((Map) l01Var.d).containsKey("flow_limit") || !Boolean.FALSE.toString().equals(((Map) l01Var.d).get("flow_limit"))) {
            String str = ((Map) l01Var.d).containsKey("type") ? (String) ((Map) l01Var.d).get("type") : "";
            if (((Map) l01Var.d).containsKey("size")) {
                String str2 = (String) ((Map) l01Var.d).get("size");
                if (!TextUtils.isEmpty(str2)) {
                    i = Integer.parseInt(str2);
                    com.efs.sdk.base.a.e.b b = com.efs.sdk.base.a.e.b.b();
                    Message obtain = Message.obtain();
                    obtain.what = 0;
                    obtain.obj = str;
                    obtain.arg1 = i;
                    b.sendMessage(obtain);
                }
            }
            i = 0;
            com.efs.sdk.base.a.e.b b2 = com.efs.sdk.base.a.e.b.b();
            Message obtain2 = Message.obtain();
            obtain2.what = 0;
            obtain2.obj = str;
            obtain2.arg1 = i;
            b2.sendMessage(obtain2);
        }
        f(l01Var);
        n73Var = n73.a.a;
        n73Var.c.d.incrementAndGet();
        g(l01Var);
        e(l01Var);
    }
}
