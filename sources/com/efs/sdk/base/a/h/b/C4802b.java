package com.efs.sdk.base.a.h.b;

import androidx.annotation.NonNull;
import com.efs.sdk.base.a.h.a.InterfaceC4798b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import tb.f01;
import tb.l01;
import tb.z0;

/* compiled from: Taobao */
/* renamed from: com.efs.sdk.base.a.h.b.b */
/* loaded from: classes10.dex */
public final class C4802b {
    public C4801a a;
    private List<InterfaceC4798b<l01>> b;

    public C4802b(@NonNull String str) {
        C4801a c4801a = new C4801a();
        this.a = c4801a;
        c4801a.a = str;
    }

    public final C4803c a() {
        C4803c c4803c = new C4803c(this.a);
        List<InterfaceC4798b<l01>> list = this.b;
        if (list != null && list.size() > 0) {
            c4803c.a(this.b);
        }
        List<InterfaceC4798b<l01>> a = f01.c().a();
        if (a != null && a.size() > 0) {
            c4803c.a(a);
        }
        return c4803c;
    }

    public final C4802b b(String str, String str2) {
        C4801a c4801a = this.a;
        if (c4801a.f == null) {
            c4801a.f = new HashMap(5);
        }
        this.a.f.put(str, str2);
        return this;
    }

    public final C4802b c(@NonNull Map<String, String> map) {
        this.a.b = map;
        return this;
    }

    public final C4802b d(@NonNull z0 z0Var) {
        if (this.b == null) {
            this.b = new ArrayList(5);
        }
        this.b.add(z0Var);
        return this;
    }
}
