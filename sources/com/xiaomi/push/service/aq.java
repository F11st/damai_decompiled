package com.xiaomi.push.service;

import com.xiaomi.push.fj;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class aq implements Runnable {
    final /* synthetic */ List a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ boolean f898a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(List list, boolean z) {
        this.a = list;
        this.f898a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean b;
        boolean b2;
        b = ap.b("www.baidu.com:80");
        Iterator it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            if (!b) {
                b2 = ap.b(str);
                if (!b2) {
                    b = false;
                    if (!b && !this.f898a) {
                        break;
                    }
                }
            }
            b = true;
            if (!b) {
            }
        }
        fj.a(b ? 1 : 2);
    }
}
