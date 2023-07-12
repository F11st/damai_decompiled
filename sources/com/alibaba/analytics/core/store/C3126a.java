package com.alibaba.analytics.core.store;

import android.content.Context;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.utils.Logger;
import java.util.List;
import tb.pq;
import tb.qa1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* renamed from: com.alibaba.analytics.core.store.a */
/* loaded from: classes5.dex */
public class C3126a implements ILogStore {
    /* JADX INFO: Access modifiers changed from: package-private */
    public C3126a(Context context) {
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized void clear() {
        Variables.n().k().b(qa1.class);
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized int clearOldLogByCount(int i) {
        String p;
        pq k;
        Logger.d();
        p = Variables.n().k().p(qa1.class);
        k = Variables.n().k();
        return k.f(qa1.class, " _id in ( select _id from " + p + "  ORDER BY priority ASC , _id ASC LIMIT " + i + " )", null);
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized int clearOldLogByField(String str, String str2) {
        pq k;
        Logger.d();
        k = Variables.n().k();
        return k.f(qa1.class, str + "< ?", new String[]{str2});
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized int count() {
        return Variables.n().k().d(qa1.class);
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized int delete(List<qa1> list) {
        return Variables.n().k().g(list);
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized List<qa1> get(int i) {
        return Variables.n().k().i(qa1.class, null, "priority DESC , time DESC ", i);
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized double getDbFileSize() {
        return Variables.n().k().m();
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized boolean insert(List<qa1> list) {
        Variables.n().k().q(list);
        return true;
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized void update(List<qa1> list) {
        Variables.n().k().s(list);
    }

    @Override // com.alibaba.analytics.core.store.ILogStore
    public synchronized void updateLogPriority(List<qa1> list) {
        Variables.n().k().t(list);
    }
}
