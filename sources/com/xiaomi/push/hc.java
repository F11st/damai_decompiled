package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ao;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class hc extends ao.b {
    final /* synthetic */ Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hc(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.ao.b
    public void b() {
        Object obj;
        ArrayList arrayList;
        List list;
        List list2;
        obj = hb.f447a;
        synchronized (obj) {
            list = hb.f449a;
            arrayList = new ArrayList(list);
            list2 = hb.f449a;
            list2.clear();
        }
        hb.b(this.a, arrayList);
    }
}
