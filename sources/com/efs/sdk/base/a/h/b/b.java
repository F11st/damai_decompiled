package com.efs.sdk.base.a.h.b;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.f01;
import tb.l01;
import tb.z0;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class b {
    public a a;
    private List<com.efs.sdk.base.a.h.a.b<l01>> b;

    public b(@NonNull String str) {
        a aVar = new a();
        this.a = aVar;
        aVar.a = str;
    }

    public final c a() {
        c cVar = new c(this.a);
        List<com.efs.sdk.base.a.h.a.b<l01>> list = this.b;
        if (list != null && list.size() > 0) {
            cVar.a(this.b);
        }
        List<com.efs.sdk.base.a.h.a.b<l01>> a = f01.c().a();
        if (a != null && a.size() > 0) {
            cVar.a(a);
        }
        return cVar;
    }

    public final b b(String str, String str2) {
        a aVar = this.a;
        if (aVar.f == null) {
            aVar.f = new HashMap(5);
        }
        this.a.f.put(str, str2);
        return this;
    }

    public final b c(@NonNull Map<String, String> map) {
        this.a.b = map;
        return this;
    }

    public final b d(@NonNull z0 z0Var) {
        if (this.b == null) {
            this.b = new ArrayList(5);
        }
        this.b.add(z0Var);
        return this;
    }
}
