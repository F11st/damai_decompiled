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
/* renamed from: kotlinx.coroutines.debug.internal.b */
/* loaded from: classes9.dex */
public final class C8655b {
    public static final C8655b INSTANCE;
    private static final ConcurrentWeakMap<C8656a<?>, Boolean> a;
    private static final Function1<Boolean, wt2> b;
    private static final ConcurrentWeakMap<CoroutineStackFrame, j40> c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: kotlinx.coroutines.debug.internal.b$a */
    /* loaded from: classes9.dex */
    public static final class C8656a<T> implements Continuation<T>, CoroutineStackFrame {
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
            C8655b.INSTANCE.f(this);
            this.a.resumeWith(obj);
        }

        @NotNull
        public String toString() {
            return this.a.toString();
        }
    }

    static {
        C8655b c8655b = new C8655b();
        INSTANCE = c8655b;
        new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        a = new ConcurrentWeakMap<>(false, 1, null);
        new Object(0L) { // from class: tb.m40
            volatile long sequenceNumber;

            {
                this.sequenceNumber = r1;
            }
        };
        new ReentrantReadWriteLock();
        b = c8655b.d();
        c = new ConcurrentWeakMap<>(true);
        AtomicLongFieldUpdater.newUpdater(m40.class, "sequenceNumber");
    }

    private C8655b() {
    }

    private final Function1<Boolean, wt2> d() {
        Object m1271constructorimpl;
        Object newInstance;
        try {
            Result.C8174a c8174a = Result.Companion;
            newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
        } catch (Throwable th) {
            Result.C8174a c8174a2 = Result.Companion;
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
    public final boolean e(C8656a<?> c8656a) {
        j40 j40Var = c8656a.b;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(C8656a<?> c8656a) {
        a.remove(c8656a);
        j40 j40Var = c8656a.b;
        throw null;
    }
}
