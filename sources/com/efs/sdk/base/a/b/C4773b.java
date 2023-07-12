package com.efs.sdk.base.a.b;

import androidx.annotation.Nullable;
import java.util.concurrent.ConcurrentHashMap;
import tb.t53;
import tb.w63;

/* compiled from: Taobao */
/* renamed from: com.efs.sdk.base.a.b.b */
/* loaded from: classes10.dex */
public final class C4773b {
    private ConcurrentHashMap<Byte, InterfaceC4778e> a = new ConcurrentHashMap<>();

    @Nullable
    public final InterfaceC4778e a(byte b) {
        ConcurrentHashMap<Byte, InterfaceC4778e> concurrentHashMap;
        Byte valueOf;
        InterfaceC4778e handlerC4776d;
        if (!this.a.containsKey(Byte.valueOf(b))) {
            if (b == 1) {
                concurrentHashMap = this.a;
                valueOf = Byte.valueOf(b);
                handlerC4776d = new HandlerC4776d();
            } else if (b != 2) {
                w63.b("efs.cache", "Cache module not support protocol ".concat(String.valueOf((int) b)), null);
            } else {
                concurrentHashMap = this.a;
                valueOf = Byte.valueOf(b);
                handlerC4776d = new t53();
            }
            concurrentHashMap.putIfAbsent(valueOf, handlerC4776d);
        }
        return this.a.get(Byte.valueOf(b));
    }
}
