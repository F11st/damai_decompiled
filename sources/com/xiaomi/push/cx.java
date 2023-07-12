package com.xiaomi.push;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class cx extends cr {
    cr a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ cv f189a;
    final /* synthetic */ cr b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cx(cv cvVar, String str, cr crVar) {
        super(str);
        this.f189a = cvVar;
        this.b = crVar;
        this.a = crVar;
        ((cr) this).f175b = ((cr) this).f175b;
        if (crVar != null) {
            this.f = crVar.f;
        }
    }

    @Override // com.xiaomi.push.cr
    public synchronized ArrayList<String> a(boolean z) {
        ArrayList<String> arrayList;
        arrayList = new ArrayList<>();
        cr crVar = this.a;
        if (crVar != null) {
            arrayList.addAll(crVar.a(true));
        }
        Map<String, cr> map = cv.b;
        synchronized (map) {
            cr crVar2 = map.get(((cr) this).f175b);
            if (crVar2 != null) {
                Iterator<String> it = crVar2.a(true).iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (arrayList.indexOf(next) == -1) {
                        arrayList.add(next);
                    }
                }
                arrayList.remove(((cr) this).f175b);
                arrayList.add(((cr) this).f175b);
            }
        }
        return arrayList;
    }

    @Override // com.xiaomi.push.cr
    public synchronized void a(String str, cq cqVar) {
        cr crVar = this.a;
        if (crVar != null) {
            crVar.a(str, cqVar);
        }
    }

    @Override // com.xiaomi.push.cr
    public boolean b() {
        return false;
    }
}
