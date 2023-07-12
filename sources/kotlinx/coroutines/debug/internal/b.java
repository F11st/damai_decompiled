package kotlinx.coroutines.debug.internal;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.i32;
import tb.j40;
import tb.m40;
import tb.tq2;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public final class b {
    public static final b INSTANCE;
    private static final ConcurrentWeakMap<a<?>, Boolean> a;
    private static final Function1<Boolean, wt2> b;
    private static final ConcurrentWeakMap<CoroutineStackFrame, j40> c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes9.dex */
    public static final class a<T> implements Continuation<T>, CoroutineStackFrame {
        @JvmField
        @NotNull
        public final Continuation<T> a;
        @JvmField
        @NotNull
        public final j40 b;
        private final CoroutineStackFrame c;

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        @Nullable
        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame coroutineStackFrame = this.c;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getCallerFrame();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        @NotNull
        public CoroutineContext getContext() {
            return this.a.getContext();
        }

        @Override // kotlin.coroutines.jvm.internal.CoroutineStackFrame
        @Nullable
        public StackTraceElement getStackTraceElement() {
            CoroutineStackFrame coroutineStackFrame = this.c;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getStackTraceElement();
            }
            return null;
        }

        @Override // kotlin.coroutines.Continuation
        public void resumeWith(@NotNull Object obj) {
            b.INSTANCE.f(this);
            this.a.resumeWith(obj);
        }

        @NotNull
        public String toString() {
            return this.a.toString();
        }
    }

    static {
        b bVar = new b();
        INSTANCE = bVar;
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        a = new ConcurrentWeakMap<>(false, 1, null);
        new Object(0L) { // from class: tb.m40
            volatile long sequenceNumber;

            {
                this.sequenceNumber = r1;
            }
        };
        new ReentrantReadWriteLock();
        b = bVar.d();
        c = new ConcurrentWeakMap<>(true);
        AtomicLongFieldUpdater.newUpdater(m40.class, "sequenceNumber");
    }

    private b() {
    }

    private final Function1<Boolean, wt2> d() {
        Object m1271constructorimpl;
        Object newInstance;
        try {
            Result.a aVar = Result.Companion;
            newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m1271constructorimpl = Result.m1271constructorimpl(i32.a(th));
        }
        if (newInstance != null) {
            m1271constructorimpl = Result.m1271constructorimpl((Function1) tq2.e(newInstance, 1));
            if (Result.m1277isFailureimpl(m1271constructorimpl)) {
                m1271constructorimpl = null;
            }
            return (Function1) m1271constructorimpl;
        }
        throw new NullPointerException("null cannot be cast to non-null type (kotlin.Boolean) -> kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(a<?> aVar) {
        j40 j40Var = aVar.b;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(a<?> aVar) {
        a.remove(aVar);
        j40 j40Var = aVar.b;
        throw null;
    }
}
