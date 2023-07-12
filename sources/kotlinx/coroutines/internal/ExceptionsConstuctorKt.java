package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CopyableThrowable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.b41;
import tb.i32;
import tb.s61;
import tb.ul;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class ExceptionsConstuctorKt {
    private static final int a = d(Throwable.class, -1);
    private static final ReentrantReadWriteLock b = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> c = new WeakHashMap<>();

    /* compiled from: Taobao */
    /* renamed from: kotlinx.coroutines.internal.ExceptionsConstuctorKt$a */
    /* loaded from: classes11.dex */
    public static final class C8693a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            a = ul.a(Integer.valueOf(((Constructor) t2).getParameterTypes().length), Integer.valueOf(((Constructor) t).getParameterTypes().length));
            return a;
        }
    }

    private static final Function1<Throwable, Throwable> a(final Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2 && b41.d(parameterTypes[0], String.class) && b41.d(parameterTypes[1], Throwable.class)) {
                    return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        @Nullable
                        public final Throwable invoke(@NotNull Throwable th) {
                            Object m1271constructorimpl;
                            Object newInstance;
                            try {
                                Result.C8174a c8174a = Result.Companion;
                                newInstance = constructor.newInstance(th.getMessage(), th);
                            } catch (Throwable th2) {
                                Result.C8174a c8174a2 = Result.Companion;
                                m1271constructorimpl = Result.m1271constructorimpl(i32.a(th2));
                            }
                            if (newInstance != null) {
                                m1271constructorimpl = Result.m1271constructorimpl((Throwable) newInstance);
                                if (Result.m1277isFailureimpl(m1271constructorimpl)) {
                                    m1271constructorimpl = null;
                                }
                                return (Throwable) m1271constructorimpl;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                    };
                }
                return null;
            }
            Class<?> cls = parameterTypes[0];
            if (b41.d(cls, Throwable.class)) {
                return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final Throwable invoke(@NotNull Throwable th) {
                        Object m1271constructorimpl;
                        Object newInstance;
                        try {
                            Result.C8174a c8174a = Result.Companion;
                            newInstance = constructor.newInstance(th);
                        } catch (Throwable th2) {
                            Result.C8174a c8174a2 = Result.Companion;
                            m1271constructorimpl = Result.m1271constructorimpl(i32.a(th2));
                        }
                        if (newInstance != null) {
                            m1271constructorimpl = Result.m1271constructorimpl((Throwable) newInstance);
                            if (Result.m1277isFailureimpl(m1271constructorimpl)) {
                                m1271constructorimpl = null;
                            }
                            return (Throwable) m1271constructorimpl;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
            if (b41.d(cls, String.class)) {
                return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final Throwable invoke(@NotNull Throwable th) {
                        Object m1271constructorimpl;
                        Object newInstance;
                        try {
                            Result.C8174a c8174a = Result.Companion;
                            newInstance = constructor.newInstance(th.getMessage());
                        } catch (Throwable th2) {
                            Result.C8174a c8174a2 = Result.Companion;
                            m1271constructorimpl = Result.m1271constructorimpl(i32.a(th2));
                        }
                        if (newInstance != null) {
                            Throwable th3 = (Throwable) newInstance;
                            th3.initCause(th);
                            m1271constructorimpl = Result.m1271constructorimpl(th3);
                            if (Result.m1277isFailureimpl(m1271constructorimpl)) {
                                m1271constructorimpl = null;
                            }
                            return (Throwable) m1271constructorimpl;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                };
            }
            return null;
        }
        return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @Nullable
            public final Throwable invoke(@NotNull Throwable th) {
                Object m1271constructorimpl;
                Object newInstance;
                try {
                    Result.C8174a c8174a = Result.Companion;
                    newInstance = constructor.newInstance(new Object[0]);
                } catch (Throwable th2) {
                    Result.C8174a c8174a2 = Result.Companion;
                    m1271constructorimpl = Result.m1271constructorimpl(i32.a(th2));
                }
                if (newInstance != null) {
                    Throwable th3 = (Throwable) newInstance;
                    th3.initCause(th);
                    m1271constructorimpl = Result.m1271constructorimpl(th3);
                    if (Result.m1277isFailureimpl(m1271constructorimpl)) {
                        m1271constructorimpl = null;
                    }
                    return (Throwable) m1271constructorimpl;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
            }
        };
    }

    private static final int b(Class<?> cls, int i) {
        do {
            int i2 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    static /* synthetic */ int c(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return b(cls, i);
    }

    private static final int d(Class<?> cls, int i) {
        Integer m1271constructorimpl;
        s61.e(cls);
        try {
            Result.C8174a c8174a = Result.Companion;
            m1271constructorimpl = Result.m1271constructorimpl(Integer.valueOf(c(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.C8174a c8174a2 = Result.Companion;
            m1271constructorimpl = Result.m1271constructorimpl(i32.a(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m1277isFailureimpl(m1271constructorimpl)) {
            m1271constructorimpl = valueOf;
        }
        return ((Number) m1271constructorimpl).intValue();
    }

    @Nullable
    public static final <E extends Throwable> E e(@NotNull E e) {
        Object m1271constructorimpl;
        List P;
        ReentrantReadWriteLock.ReadLock readLock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        if (e instanceof CopyableThrowable) {
            try {
                Result.C8174a c8174a = Result.Companion;
                m1271constructorimpl = Result.m1271constructorimpl(((CopyableThrowable) e).createCopy());
            } catch (Throwable th) {
                Result.C8174a c8174a2 = Result.Companion;
                m1271constructorimpl = Result.m1271constructorimpl(i32.a(th));
            }
            return (E) (Result.m1277isFailureimpl(m1271constructorimpl) ? null : m1271constructorimpl);
        }
        ReentrantReadWriteLock reentrantReadWriteLock = b;
        ReentrantReadWriteLock.ReadLock readLock2 = reentrantReadWriteLock.readLock();
        readLock2.lock();
        try {
            Function1<Throwable, Throwable> function1 = c.get(e.getClass());
            if (function1 != null) {
                return (E) function1.invoke(e);
            }
            int i = 0;
            if (a != d(e.getClass(), 0)) {
                readLock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    c.put(e.getClass(), new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1
                        @Override // kotlin.jvm.functions.Function1
                        @Nullable
                        public final Void invoke(@NotNull Throwable th2) {
                            return null;
                        }
                    });
                    wt2 wt2Var = wt2.INSTANCE;
                    return null;
                } finally {
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                }
            }
            P = ArraysKt___ArraysKt.P(e.getClass().getConstructors(), new C8693a());
            Iterator it = P.iterator();
            Function1<Throwable, Throwable> function12 = null;
            while (it.hasNext() && (function12 = a((Constructor) it.next())) == null) {
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = b;
            readLock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i3 = 0; i3 < readHoldCount; i3++) {
                readLock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                c.put(e.getClass(), function12 != null ? function12 : new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1
                    @Override // kotlin.jvm.functions.Function1
                    @Nullable
                    public final Void invoke(@NotNull Throwable th2) {
                        return null;
                    }
                });
                wt2 wt2Var2 = wt2.INSTANCE;
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
                if (function12 != null) {
                    return (E) function12.invoke(e);
                }
                return null;
            } finally {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock2.unlock();
        }
    }
}
