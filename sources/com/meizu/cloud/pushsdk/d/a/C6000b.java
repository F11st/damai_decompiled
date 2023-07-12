package com.meizu.cloud.pushsdk.d.a;

import com.meizu.cloud.pushsdk.d.f.C6030c;
import com.meizu.cloud.pushsdk.d.f.C6031d;
import com.meizu.cloud.pushsdk.d.f.C6032e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.a.b */
/* loaded from: classes10.dex */
public class C6000b implements InterfaceC5999a {
    private final String a = C6000b.class.getSimpleName();
    private final HashMap<String, Object> b = new HashMap<>();

    public C6000b(String str, Object obj) {
        a(str);
        a(obj);
    }

    public C6000b a(Object obj) {
        if (obj == null) {
            return this;
        }
        this.b.put("dt", obj);
        return this;
    }

    public C6000b a(String str) {
        C6031d.a(str, "schema cannot be null");
        C6031d.a(!str.isEmpty(), "schema cannot be empty.");
        this.b.put("sa", str);
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.d.a.InterfaceC5999a
    public Map<String, Object> a() {
        return this.b;
    }

    @Override // com.meizu.cloud.pushsdk.d.a.InterfaceC5999a
    @Deprecated
    public void a(String str, String str2) {
        C6030c.c(this.a, "Payload: add(String, String) method called - Doing nothing.", new Object[0]);
    }

    @Override // com.meizu.cloud.pushsdk.d.a.InterfaceC5999a
    public long b() {
        return C6032e.a(toString());
    }

    public String toString() {
        return C6032e.a((Map) this.b).toString();
    }
}
