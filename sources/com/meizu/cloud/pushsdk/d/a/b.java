package com.meizu.cloud.pushsdk.d.a;

import com.meizu.cloud.pushsdk.d.f.d;
import com.meizu.cloud.pushsdk.d.f.e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b implements a {
    private final String a = b.class.getSimpleName();
    private final HashMap<String, Object> b = new HashMap<>();

    public b(String str, Object obj) {
        a(str);
        a(obj);
    }

    public b a(Object obj) {
        if (obj == null) {
            return this;
        }
        this.b.put("dt", obj);
        return this;
    }

    public b a(String str) {
        d.a(str, "schema cannot be null");
        d.a(!str.isEmpty(), "schema cannot be empty.");
        this.b.put("sa", str);
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.d.a.a
    public Map<String, Object> a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.d.a.a
    @Deprecated
    public void a(String str, String str2) {
        com.meizu.cloud.pushsdk.d.f.c.c(this.a, "Payload: add(String, String) method called - Doing nothing.", new Object[0]);
    }

    @Override // com.meizu.cloud.pushsdk.d.a.a
    public long b() {
        return e.a(toString());
    }

    public String toString() {
        return e.a((Map) this.b).toString();
    }
}
