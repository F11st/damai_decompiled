package com.google.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class f {
    static final Class<?> a = c();

    public static g a() {
        if (a != null) {
            try {
                return b("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return g.b;
    }

    private static final g b(String str) throws Exception {
        return (g) a.getMethod(str, new Class[0]).invoke(null, new Object[0]);
    }

    static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
