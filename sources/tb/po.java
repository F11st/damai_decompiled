package tb;

import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class po extends n1 {
    public static final C9559a Key = new C9559a(null);
    @NotNull
    private final String a;

    /* compiled from: Taobao */
    /* renamed from: tb.po$a */
    /* loaded from: classes8.dex */
    public static final class C9559a implements CoroutineContext.Key<po> {
        private C9559a() {
        }

        public /* synthetic */ C9559a(k50 k50Var) {
            this();
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof po) && b41.d(this.a, ((po) obj).a);
        }
        return true;
    }

    @NotNull
    public final String getName() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return "CoroutineName(" + this.a + ')';
    }
}
