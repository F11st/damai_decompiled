package kotlinx.coroutines.debug.internal;

import tb.b41;
import tb.kj2;

/* compiled from: Taobao */
/* renamed from: kotlinx.coroutines.debug.internal.a */
/* loaded from: classes9.dex */
public final class C8654a {
    private static final kj2 a = new kj2("REHASH");
    private static final C8657c b = new C8657c(null);
    private static final C8657c c = new C8657c(Boolean.TRUE);

    /* JADX INFO: Access modifiers changed from: private */
    public static final C8657c d(Object obj) {
        if (obj == null) {
            return b;
        }
        return b41.d(obj, Boolean.TRUE) ? c : new C8657c(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void e() {
        throw new UnsupportedOperationException("not implemented");
    }
}
