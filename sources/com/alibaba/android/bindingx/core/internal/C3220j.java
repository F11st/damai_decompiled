package com.alibaba.android.bindingx.core.internal;

import java.util.Collections;
import java.util.Map;
import tb.xg0;

/* compiled from: Taobao */
/* renamed from: com.alibaba.android.bindingx.core.internal.j */
/* loaded from: classes5.dex */
final class C3220j {
    String a;
    String b;
    xg0 c;
    String d;
    String e;
    Map<String, Object> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3220j(String str, String str2, xg0 xg0Var, String str3, String str4, Map<String, Object> map) {
        this.a = str;
        this.b = str2;
        this.c = xg0Var;
        this.d = str3;
        this.e = str4;
        if (map == null) {
            this.f = Collections.emptyMap();
        } else {
            this.f = map;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3220j.class != obj.getClass()) {
            return false;
        }
        C3220j c3220j = (C3220j) obj;
        String str = this.a;
        if (str == null ? c3220j.a == null : str.equals(c3220j.a)) {
            xg0 xg0Var = this.c;
            if (xg0Var == null ? c3220j.c == null : xg0Var.equals(c3220j.c)) {
                String str2 = this.d;
                if (str2 == null ? c3220j.d == null : str2.equals(c3220j.d)) {
                    String str3 = this.e;
                    if (str3 == null ? c3220j.e == null : str3.equals(c3220j.e)) {
                        Map<String, Object> map = this.f;
                        Map<String, Object> map2 = c3220j.f;
                        return map != null ? map.equals(map2) : map2 == null;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        xg0 xg0Var = this.c;
        int hashCode2 = (hashCode + (xg0Var != null ? xg0Var.hashCode() : 0)) * 31;
        String str2 = this.d;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.e;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Map<String, Object> map = this.f;
        return hashCode4 + (map != null ? map.hashCode() : 0);
    }
}
