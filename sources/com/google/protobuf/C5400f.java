package com.google.protobuf;

/* compiled from: Taobao */
/* renamed from: com.google.protobuf.f */
/* loaded from: classes10.dex */
final class C5400f {
    static final Class<?> a = c();

    public static C5401g a() {
        if (a != null) {
            try {
                return b("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return C5401g.b;
    }

    private static final C5401g b(String str) throws Exception {
        return (C5401g) a.getMethod(str, new Class[0]).invoke(null, new Object[0]);
    }

    static Class<?> c() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
