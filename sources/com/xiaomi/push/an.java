package com.xiaomi.push;

import com.xiaomi.push.al;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class an extends al.b {
    final /* synthetic */ al a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public an(al alVar, al.a aVar) {
        super(aVar);
        this.a = alVar;
    }

    @Override // com.xiaomi.push.al.b
    void b() {
        Object obj;
        Map map;
        obj = this.a.f88a;
        synchronized (obj) {
            map = this.a.f89a;
            map.remove(super.a.mo706a());
        }
    }
}
