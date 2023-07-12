package kotlinx.coroutines.debug.internal;

import tb.b41;
import tb.kj2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class a {
    private static final kj2 a = new kj2("REHASH");
    private static final c b = new c(null);
    private static final c c = new c(Boolean.TRUE);

    /* JADX INFO: Access modifiers changed from: private */
    public static final c d(Object obj) {
        if (obj == null) {
            return b;
        }
        return b41.d(obj, Boolean.TRUE) ? c : new c(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
