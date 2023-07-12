package com.efs.sdk.base.a.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.efs.sdk.base.Constants;
import com.taobao.weex.annotation.JSMethod;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import tb.j43;
import tb.j83;
import tb.n73;
import tb.q33;
import tb.u23;
import tb.w63;
import tb.z43;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class a {
    public boolean a;
    public boolean b;
    public com.efs.sdk.base.a.b.b c;
    public C0221a d;

    /* compiled from: Taobao */
    /* renamed from: com.efs.sdk.base.a.b.a$a */
    /* loaded from: classes10.dex */
    public static class C0221a implements Comparator<File> {
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            int i = ((file.lastModified() - file2.lastModified()) > 0L ? 1 : ((file.lastModified() - file2.lastModified()) == 0L ? 0 : -1));
            if (i > 0) {
                return 1;
            }
            return i == 0 ? 0 : -1;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b {
        private static final a a = new a((byte) 0);

        public static /* synthetic */ a a() {
            return a;
        }
    }

    private a() {
        this.a = false;
        this.b = true;
        this.c = new com.efs.sdk.base.a.b.b();
        this.d = new C0221a();
    }

    /* synthetic */ a(byte b2) {
        this();
    }

    public static boolean c(String str) {
        try {
            long parseLong = Long.parseLong(str.substring(str.lastIndexOf(JSMethod.NOT_SET) + 1));
            u23.c();
            return Math.abs(u23.e() - parseLong) >= 604800000;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void d(@NonNull File file) {
        n73 n73Var;
        if (!file.getName().startsWith("wa_")) {
            n73Var = n73.a.a;
            n73Var.c.e();
        }
        z43.i(file);
    }

    public static void e(File file) {
        n73 n73Var;
        StringBuilder sb = new StringBuilder("file is expire: ");
        sb.append(file.getName());
        sb.append(", now is ");
        u23.c();
        sb.append(u23.e());
        w63.a("efs.cache", sb.toString());
        if (!file.getName().startsWith("wa_")) {
            n73Var = n73.a.a;
            n73Var.c.d();
        }
        z43.i(file);
    }

    @Nullable
    public final j43 a(File file) {
        try {
            if (file.exists()) {
                if (c(file.getName())) {
                    e(file);
                    return null;
                }
                j43 h = z43.h(file.getName());
                if (h == null) {
                    d(file);
                    return null;
                }
                e a = this.c.a(h.a.b);
                if (a == null) {
                    d(file);
                    return null;
                } else if (a.a(file, h)) {
                    return h;
                } else {
                    d(file);
                    return null;
                }
            }
            return null;
        } catch (Throwable th) {
            w63.b(Constants.TAG, "efs.cache", th);
            d(file);
            return null;
        }
    }

    public final void b() {
        String[] list;
        e a;
        File e = q33.e(com.efs.sdk.base.a.d.a.a().c, com.efs.sdk.base.a.d.a.a().a);
        if (!e.exists() || !e.isDirectory() || (list = e.list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!j83.b(com.efs.sdk.base.a.d.a.a().c, str)) {
                File file = new File(e, str);
                List<File> k = z43.k(file);
                if (!k.isEmpty()) {
                    for (File file2 : k) {
                        if (c(file2.getName())) {
                            e(file2);
                        } else {
                            j43 h = z43.h(file2.getName());
                            if (h == null || (a = this.c.a(h.a.b)) == null) {
                                d(file2);
                            } else {
                                a.a(file2);
                            }
                        }
                    }
                }
                z43.i(file);
            }
        }
    }
}
