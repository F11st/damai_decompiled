package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.C8831s;

/* compiled from: Taobao */
/* renamed from: okhttp3.internal.connection.g */
/* loaded from: classes2.dex */
final class C8773g {
    private final Set<C8831s> a = new LinkedHashSet();

    public synchronized void a(C8831s c8831s) {
        this.a.remove(c8831s);
    }

    public synchronized void b(C8831s c8831s) {
        this.a.add(c8831s);
    }

    public synchronized boolean c(C8831s c8831s) {
        return this.a.contains(c8831s);
    }
}
