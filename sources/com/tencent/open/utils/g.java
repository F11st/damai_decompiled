package com.tencent.open.utils;

import android.content.Context;
import java.io.File;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class g {
    private static Context a;

    public static final Context a() {
        Context context = a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final String b() {
        return a() == null ? "" : a().getPackageName();
    }

    public static final File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }

    public static final File d() {
        Context a2 = a();
        if (a2 != null) {
            return a2.getCacheDir();
        }
        return null;
    }

    public static final File e() {
        return a((String) null);
    }

    public static final void a(Context context) {
        a = context;
    }

    public static final File a(String str) {
        return m.h(a(), str);
    }
}
