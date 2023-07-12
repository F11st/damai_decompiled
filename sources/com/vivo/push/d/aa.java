package com.vivo.push.d;

import com.vivo.push.AbstractC7496o;
import com.vivo.push.C7481e;
import com.vivo.push.C7492m;
import com.vivo.push.b.C7432t;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class aa extends AbstractC7480z {
    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(AbstractC7496o abstractC7496o) {
        super(abstractC7496o);
    }

    @Override // com.vivo.push.AbstractRunnableC7491l
    protected final void a(AbstractC7496o abstractC7496o) {
        C7432t c7432t = (C7432t) abstractC7496o;
        ArrayList<String> d = c7432t.d();
        List<String> e = c7432t.e();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int h = c7432t.h();
        String g = c7432t.g();
        if (d != null) {
            for (String str : d) {
                if (str.startsWith("ali/")) {
                    arrayList2.add(str.replace("ali/", ""));
                } else if (str.startsWith("tag/")) {
                    arrayList.add(str.replace("tag/", ""));
                }
            }
        }
        if (e != null) {
            for (String str2 : e) {
                if (str2.startsWith("ali/")) {
                    arrayList4.add(str2.replace("ali/", ""));
                } else if (str2.startsWith("tag/")) {
                    arrayList3.add(str2.replace("tag/", ""));
                }
            }
        }
        if (arrayList.size() > 0 || arrayList3.size() > 0) {
            if (arrayList.size() > 0) {
                C7481e.a().a(arrayList);
            }
            C7481e.a().a(c7432t.g(), arrayList3.size() > 0 ? 10000 : h);
            C7492m.b(new RunnableC7452ab(this, h, arrayList, arrayList3, g));
        }
        if (arrayList2.size() > 0 || arrayList4.size() > 0) {
            if (arrayList2.size() > 0) {
                C7481e.a().b((String) arrayList2.get(0));
            }
            C7481e.a().a(c7432t.g(), h);
            C7492m.b(new ac(this, h, arrayList2, arrayList4, g));
        }
    }
}
