package tb;

import java.io.File;
import tb.n73;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class t53 implements com.efs.sdk.base.a.b.e {
    @Override // com.efs.sdk.base.a.b.e
    public final void a(File file) {
        z43.d(file, q33.g(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a));
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(String str) {
    }

    @Override // com.efs.sdk.base.a.b.e
    public final void a(j43 j43Var) {
        n73 n73Var;
        n73 n73Var2;
        if (j43Var.c == null) {
            return;
        }
        z43.f(new File(q33.g(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a), z43.b(j43Var)), j43Var.c);
        n73Var = n73.a.a;
        n73Var.c.b();
        n73Var2 = n73.a.a;
        n73Var2.c.c();
    }

    @Override // com.efs.sdk.base.a.b.e
    public final boolean a(File file, j43 j43Var) {
        if (file.exists()) {
            j43Var.d = file;
            j43Var.i();
            j43Var.f(1);
            return true;
        }
        return false;
    }
}
