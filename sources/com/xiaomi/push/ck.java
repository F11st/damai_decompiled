package com.xiaomi.push;

import com.xiaomi.push.al;
import com.xiaomi.push.cj;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ck extends al.AbstractRunnableC7597a {
    final /* synthetic */ cj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar) {
        this.a = cjVar;
    }

    @Override // com.xiaomi.push.al.AbstractRunnableC7597a
    /* renamed from: a */
    public String mo706a() {
        return "100957";
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList<cj.AbstractRunnableC7617a> arrayList6;
        arrayList = this.a.f156a;
        synchronized (arrayList) {
            arrayList2 = this.a.f156a;
            if (arrayList2.size() > 0) {
                arrayList3 = this.a.f156a;
                if (arrayList3.size() > 1) {
                    cj cjVar = this.a;
                    arrayList6 = cjVar.f156a;
                    cjVar.a(arrayList6);
                } else {
                    cj cjVar2 = this.a;
                    arrayList4 = cjVar2.f156a;
                    cjVar2.b((cj.AbstractRunnableC7617a) arrayList4.get(0));
                }
                arrayList5 = this.a.f156a;
                arrayList5.clear();
                System.gc();
            }
        }
    }
}
