package com.efs.sdk.base.a.b;

import androidx.annotation.Nullable;
import java.util.concurrent.ConcurrentHashMap;
import tb.t53;
import tb.w63;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class b {
    private ConcurrentHashMap<Byte, e> a = new ConcurrentHashMap<>();

    @Nullable
    public final e a(byte b) {
        ConcurrentHashMap<Byte, e> concurrentHashMap;
        Byte valueOf;
        e dVar;
        if (!this.a.containsKey(Byte.valueOf(b))) {
            if (b == 1) {
                concurrentHashMap = this.a;
                valueOf = Byte.valueOf(b);
                dVar = new d();
            } else if (b != 2) {
                w63.b("efs.cache", "Cache module not support protocol ".concat(String.valueOf((int) b)), null);
            } else {
                concurrentHashMap = this.a;
                valueOf = Byte.valueOf(b);
                dVar = new t53();
            }
            concurrentHashMap.putIfAbsent(valueOf, dVar);
        }
        return this.a.get(Byte.valueOf(b));
    }
}
