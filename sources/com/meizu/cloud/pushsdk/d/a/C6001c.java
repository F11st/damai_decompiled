package com.meizu.cloud.pushsdk.d.a;

import com.meizu.cloud.pushsdk.d.f.C6030c;
import com.meizu.cloud.pushsdk.d.f.C6032e;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.meizu.cloud.pushsdk.d.a.c */
/* loaded from: classes10.dex */
public class C6001c implements InterfaceC5999a {
    private final String a = C6001c.class.getSimpleName();
    private final HashMap<String, Object> b = new HashMap<>();

    @Override // com.meizu.cloud.pushsdk.d.a.InterfaceC5999a
    public Map a() {
        return this.b;
    }

    public void a(String str, Object obj) {
        if (obj != null) {
            this.b.put(str, obj);
            return;
        }
        String str2 = this.a;
        C6030c.c(str2, "The keys value is empty, returning without adding key: " + str, new Object[0]);
    }

    @Override // com.meizu.cloud.pushsdk.d.a.InterfaceC5999a
    public void a(String str, String str2) {
        if (str2 != null && !str2.isEmpty()) {
            this.b.put(str, str2);
            return;
        }
        String str3 = this.a;
        C6030c.c(str3, "The keys value is empty, returning without adding key: " + str, new Object[0]);
    }

    public void a(Map<String, Object> map) {
        if (map == null) {
            C6030c.c(this.a, "Map passed in is null, returning without adding map.", new Object[0]);
        } else {
            this.b.putAll(map);
        }
    }

    @Override // com.meizu.cloud.pushsdk.d.a.InterfaceC5999a
    public long b() {
        return C6032e.a(toString());
    }

    public String toString() {
        return C6032e.a((Map) this.b).toString();
    }
}
