package com.meizu.cloud.pushsdk.d.a;

import com.meizu.cloud.pushsdk.d.f.e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class c implements a {
    private final String a = c.class.getSimpleName();
    private final HashMap<String, Object> b = new HashMap<>();

    @Override // com.meizu.cloud.pushsdk.d.a.a
    public Map a() {
        return this.b;
    }

    public void a(String str, Object obj) {
        if (obj != null) {
            this.b.put(str, obj);
            return;
        }
        String str2 = this.a;
        com.meizu.cloud.pushsdk.d.f.c.c(str2, "The keys value is empty, returning without adding key: " + str, new Object[0]);
    }

    @Override // com.meizu.cloud.pushsdk.d.a.a
    public void a(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            this.b.put(str, str2);
            return;
        }
        String str3 = this.a;
        com.meizu.cloud.pushsdk.d.f.c.c(str3, "The keys value is empty, returning without adding key: " + str, new Object[0]);
    }

    public void a(Map<String, Object> map) {
        if (map == null) {
            com.meizu.cloud.pushsdk.d.f.c.c(this.a, "Map passed in is null, returning without adding map.", new Object[0]);
        } else {
            this.b.putAll(map);
        }
    }

    @Override // com.meizu.cloud.pushsdk.d.a.a
    public long b() {
        return e.a(toString());
    }

    public String toString() {
        return e.a((Map) this.b).toString();
    }
}
