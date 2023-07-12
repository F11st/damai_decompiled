package tb;

import java.util.Objects;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.ThreadContextElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class oo extends n1 implements ThreadContextElement<String> {
    public static final a Key = new a(null);
    private final long a;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static final class a implements CoroutineContext.Key<oo> {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public oo(long j) {
        super(Key);
        this.a = j;
    }

    public final long a() {
        return this.a;
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    /* renamed from: b */
    public void restoreThreadContext(@NotNull CoroutineContext coroutineContext, @NotNull String str) {
        Thread.currentThread().setName(str);
    }

    @Override // kotlinx.coroutines.ThreadContextElement
    @NotNull
    /* renamed from: c */
    public String updateThreadContext(@NotNull CoroutineContext coroutineContext) {
        int f0;
        po poVar = (po) coroutineContext.get(po.Key);
        String str = (poVar == null || (str = poVar.getName()) == null) ? "coroutine" : "coroutine";
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        f0 = StringsKt__StringsKt.f0(name, " @", 0, false, 6, null);
        if (f0 < 0) {
            f0 = name.length();
        }
        StringBuilder sb = new StringBuilder(str.length() + f0 + 10);
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String substring = name.substring(0, f0);
        b41.h(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(" @");
        sb.append(str);
        sb.append('#');
        sb.append(this.a);
        wt2 wt2Var = wt2.INSTANCE;
        String sb2 = sb.toString();
        b41.h(sb2, "StringBuilder(capacity).…builderAction).toString()");
        currentThread.setName(sb2);
        return name;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof oo) && this.a == ((oo) obj).a;
        }
        return true;
    }

    @Override // tb.n1, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return (R) ThreadContextElement.a.a(this, r, function2);
    }

    @Override // tb.n1, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> key) {
        return (E) ThreadContextElement.a.b(this, key);
    }

    public int hashCode() {
        long j = this.a;
        return (int) (j ^ (j >>> 32));
    }

    @Override // tb.n1, kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> key) {
        return ThreadContextElement.a.c(this, key);
    }

    @Override // tb.n1, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return ThreadContextElement.a.d(this, coroutineContext);
    }

    @NotNull
    public String toString() {
        return "CoroutineId(" + this.a + ')';
    }
}
