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
    public static final a Companion = a.a;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
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
