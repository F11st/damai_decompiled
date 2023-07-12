package com.alibaba.analytics.core.db;

import android.content.Context;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import java.io.File;
import java.util.List;
import tb.pq;
import tb.qa1;
import tb.ve0;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
final class OldDBTransferMgr$1 implements Runnable {
    final /* synthetic */ Context val$context;
    final /* synthetic */ File val$dbfile;

    OldDBTransferMgr$1(Context context, File file) {
        this.val$context = context;
        this.val$dbfile = file;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        Context context = this.val$context;
        str = C3117a.a;
        pq pqVar = new pq(context, str);
        while (true) {
            List<? extends ve0> i = pqVar.i(qa1.class, null, "time", 100);
            if (i.size() == 0) {
                Logger.f("OldDBTransferMgr", "delete old db file:", this.val$dbfile.getAbsoluteFile());
                this.val$dbfile.delete();
                return;
            }
            pqVar.g(i);
            Variables.n().k().q(i);
        }
    }
}
