package tb;

import androidx.annotation.NonNull;
import com.efs.sdk.base.a.c.a.C4783c;
import com.efs.sdk.base.a.e.InterfaceC4792c;
import com.efs.sdk.base.a.h.b.C4801a;
import com.efs.sdk.base.a.h.b.C4802b;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class m33 implements InterfaceC4792c {
    @Override // com.efs.sdk.base.a.e.InterfaceC4792c
    @NonNull
    public final l01 a(j43 j43Var, boolean z) {
        l01 b;
        e53 a = e53.a();
        n33 n33Var = j43Var.a;
        a.d = n33Var.d;
        a.e = n33Var.e;
        a.g = n33Var.b;
        a.h = n33Var.a;
        a.k = j43Var.a();
        String b2 = C4783c.a().b(false);
        int i = j43Var.a.c;
        if (i == 0) {
            u23 c = u23.c();
            byte[] bArr = j43Var.c;
            boolean z2 = j43Var.b.b;
            String b3 = a.b();
            String a2 = u23.a(b2, a);
            if (c.a) {
                w63.a("efs.px.api", "upload buffer file, url is ".concat(String.valueOf(a2)));
            }
            HashMap hashMap = new HashMap(1);
            hashMap.put("wpk-header", b3);
            C4802b c2 = new C4802b(a2).c(hashMap);
            C4801a c4801a = c2.a;
            c4801a.c = bArr;
            c4801a.g = true;
            C4802b b4 = c2.b("type", a.h);
            StringBuilder sb = new StringBuilder();
            sb.append(a.k);
            b = b4.b("size", sb.toString()).b("flow_limit", Boolean.toString(z2)).d(s53.d()).a().b();
        } else {
            b = 1 == i ? u23.c().b(b2, a, j43Var.d, j43Var.b.b) : new l01();
        }
        if (b.a && z) {
            z43.i(j43Var.d);
        }
        return b;
    }
}
