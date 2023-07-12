package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.google.protobuf.g */
/* loaded from: classes10.dex */
public class C5401g {
    static final C5401g b;
    private final Map<Object, GeneratedMessageLite.C5381e<?, ?>> a;

    static {
        b();
        b = new C5401g(true);
    }

    C5401g() {
        new HashMap();
    }

    public static C5401g a() {
        return C5400f.a();
    }

    static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    C5401g(boolean z) {
        this.a = Collections.emptyMap();
    }
}
