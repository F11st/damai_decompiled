package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class g {
    static final g b;
    private final Map<Object, GeneratedMessageLite.e<?, ?>> a;

    static {
        b();
        b = new g(true);
    }

    g() {
        new HashMap();
    }

    public static g a() {
        return f.a();
    }

    static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    g(boolean z) {
        this.a = Collections.emptyMap();
    }
}
