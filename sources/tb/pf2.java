package tb;

import java.util.ArrayDeque;
import java.util.Objects;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.ExceptionsConstuctorKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class pf2 {
    private static final String a;
    private static final String b;

    static {
        Object m1271constructorimpl;
        Object m1271constructorimpl2;
        try {
            Result.a aVar = Result.Companion;
            m1271constructorimpl = Result.m1271constructorimpl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m1271constructorimpl = Result.m1271constructorimpl(i32.a(th));
        }
        if (Result.m1274exceptionOrNullimpl(m1271constructorimpl) != null) {
            m1271constructorimpl = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        a = (String) m1271constructorimpl;
        try {
            Result.a aVar3 = Result.Companion;
            m1271constructorimpl2 = Result.m1271constructorimpl(pf2.class.getCanonicalName());
        } catch (Throwable th2) {
            Result.a aVar4 = Result.Companion;
            m1271constructorimpl2 = Result.m1271constructorimpl(i32.a(th2));
        }
        if (Result.m1274exceptionOrNullimpl(m1271constructorimpl2) != null) {
            m1271constructorimpl2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        b = (String) m1271constructorimpl2;
    }

    public static final /* synthetic */ Throwable a(Throwable th, CoroutineStackFrame coroutineStackFrame) {
        return j(th, coroutineStackFrame);
    }

    @InternalCoroutinesApi
    @NotNull
    public static final StackTraceElement b(@NotNull String str) {
        return new StackTraceElement("\b\b\b(" + str, "\b", "\b", -1);
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> c(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause != null && b41.d(cause.getClass(), e.getClass())) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (h(stackTrace[i])) {
                    z = true;
                    break;
                } else {
                    i++;
                }
            }
            if (z) {
                return hq2.a(cause, stackTrace);
            }
            return hq2.a(e, new StackTraceElement[0]);
        }
        return hq2.a(e, new StackTraceElement[0]);
    }

    private static final <E extends Throwable> E d(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(b("Coroutine boundary"));
        StackTraceElement[] stackTrace = e.getStackTrace();
        int g = g(stackTrace, a);
        int i = 0;
        if (g == -1) {
            Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            e2.setStackTrace((StackTraceElement[]) array);
            return e2;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + g];
        for (int i2 = 0; i2 < g; i2++) {
            stackTraceElementArr[i2] = stackTrace[i2];
        }
        for (StackTraceElement stackTraceElement : arrayDeque) {
            stackTraceElementArr[g + i] = stackTraceElement;
            i++;
        }
        e2.setStackTrace(stackTraceElementArr);
        return e2;
    }

    private static final ArrayDeque<StackTraceElement> e(CoroutineStackFrame coroutineStackFrame) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    private static final boolean f(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && b41.d(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && b41.d(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && b41.d(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final int g(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (b41.d(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }

    public static final boolean h(@NotNull StackTraceElement stackTraceElement) {
        boolean F;
        F = kotlin.text.o.F(stackTraceElement.getClassName(), "\b\b\b", false, 2, null);
        return F;
    }

    private static final void i(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (h(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i2) {
            return;
        }
        while (true) {
            if (f(stackTraceElementArr[length2], arrayDeque.getLast())) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i2) {
                return;
            }
            length2--;
        }
    }

    public static final <E extends Throwable> E j(E e, CoroutineStackFrame coroutineStackFrame) {
        Pair c = c(e);
        Throwable th = (Throwable) c.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) c.component2();
        Throwable e2 = ExceptionsConstuctorKt.e(th);
        if (e2 == null || (!b41.d(e2.getMessage(), th.getMessage()))) {
            return e;
        }
        ArrayDeque<StackTraceElement> e3 = e(coroutineStackFrame);
        if (e3.isEmpty()) {
            return e;
        }
        if (th != e) {
            i(stackTraceElementArr, e3);
        }
        return (E) d(th, e2, e3);
    }

    @NotNull
    public static final <E extends Throwable> E k(@NotNull E e) {
        Throwable e2;
        return (k40.d() && (e2 = ExceptionsConstuctorKt.e(e)) != null) ? (E) l(e2) : e;
    }

    private static final <E extends Throwable> E l(E e) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        int g = g(stackTrace, b);
        int i = g + 1;
        int g2 = g(stackTrace, a);
        int i2 = (length - g) - (g2 == -1 ? 0 : length - g2);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 == 0) {
                stackTraceElement = b("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(i + i3) - 1];
            }
            stackTraceElementArr[i3] = stackTraceElement;
        }
        e.setStackTrace(stackTraceElementArr);
        return e;
    }

    @NotNull
    public static final <E extends Throwable> E m(@NotNull E e) {
        E e2 = (E) e.getCause();
        if (e2 != null) {
            boolean z = true;
            if (!(!b41.d(e2.getClass(), e.getClass()))) {
                StackTraceElement[] stackTrace = e.getStackTrace();
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    } else if (h(stackTrace[i])) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return e2;
                }
            }
        }
        return e;
    }
}
