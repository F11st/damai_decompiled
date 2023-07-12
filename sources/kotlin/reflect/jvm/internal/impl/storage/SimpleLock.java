package kotlin.reflect.jvm.internal.impl.storage;

import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.fg;
import tb.g60;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public interface SimpleLock {
    @NotNull
    public static final C8529a Companion = C8529a.a;

    /* compiled from: Taobao */
    /* renamed from: kotlin.reflect.jvm.internal.impl.storage.SimpleLock$a */
    /* loaded from: classes3.dex */
    public static final class C8529a {
        static final /* synthetic */ C8529a a = new C8529a();

        private C8529a() {
        }

        @NotNull
        public final g60 a(@Nullable Runnable runnable, @Nullable Function1<? super InterruptedException, wt2> function1) {
            if (runnable != null && function1 != null) {
                return new fg(runnable, function1);
            }
            return new g60(null, 1, null);
        }
    }

    void lock();

    void unlock();
}
