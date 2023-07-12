package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.s;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class g {
    private final Set<s> a = new LinkedHashSet();

    public synchronized void a(s sVar) {
        this.a.remove(sVar);
    }

    public synchronized void b(s sVar) {
        this.a.add(sVar);
    }

    public synchronized boolean c(s sVar) {
        return this.a.contains(sVar);
    }
}
