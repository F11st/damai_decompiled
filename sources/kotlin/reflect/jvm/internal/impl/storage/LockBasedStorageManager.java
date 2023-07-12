package kotlin.reflect.jvm.internal.impl.storage;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.cg0;
import tb.jn1;
import tb.le0;
import tb.m80;
import tb.wt2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class LockBasedStorageManager implements StorageManager {
    public static final StorageManager NO_LOCKS;
    private static final String d;
    protected final SimpleLock a;
    private final ExceptionHandlingStrategy b;
    private final String c;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public interface ExceptionHandlingStrategy {
        public static final ExceptionHandlingStrategy THROW = new a();

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        static class a implements ExceptionHandlingStrategy {
            a() {
            }

            private static /* synthetic */ void a(int i) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.ExceptionHandlingStrategy
            @NotNull
            public RuntimeException handleException(@NotNull Throwable th) {
                if (th == null) {
                    a(0);
                }
                throw cg0.b(th);
            }
        }

        @NotNull
        RuntimeException handleException(@NotNull Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public enum NotValue {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    static class a extends LockBasedStorageManager {
        a(String str, ExceptionHandlingStrategy exceptionHandlingStrategy, SimpleLock simpleLock) {
            super(str, exceptionHandlingStrategy, simpleLock, null);
        }

        private static /* synthetic */ void a(int i) {
            String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 1 ? 3 : 2];
            if (i != 1) {
                objArr[0] = "source";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String format = String.format(str, objArr);
            if (i == 1) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager
        @NotNull
        protected <K, V> m<V> g(@NotNull String str, K k) {
            if (str == null) {
                a(0);
            }
            m<V> a = m.a();
            if (a == null) {
                a(1);
            }
            return a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    class b<T> extends i<T> {
        final /* synthetic */ Object d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(LockBasedStorageManager lockBasedStorageManager, LockBasedStorageManager lockBasedStorageManager2, Function0 function0, Object obj) {
            super(lockBasedStorageManager2, function0);
            this.d = obj;
        }

        private static /* synthetic */ void a(int i) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.g
        @NotNull
        protected m<T> c(boolean z) {
            m<T> d = m.d(this.d);
            if (d == null) {
                a(0);
            }
            return d;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    class c<T> extends j<T> {
        final /* synthetic */ Function1 e;
        final /* synthetic */ Function1 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(LockBasedStorageManager lockBasedStorageManager, LockBasedStorageManager lockBasedStorageManager2, Function0 function0, Function1 function1, Function1 function12) {
            super(lockBasedStorageManager2, function0);
            this.e = function1;
            this.f = function12;
        }

        private static /* synthetic */ void a(int i) {
            String str = i != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i != 2 ? 2 : 3];
            if (i != 2) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            } else {
                objArr[0] = "value";
            }
            if (i != 2) {
                objArr[1] = "recursionDetected";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            }
            if (i == 2) {
                objArr[2] = "doPostCompute";
            }
            String format = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalArgumentException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.g
        @NotNull
        protected m<T> c(boolean z) {
            Function1 function1 = this.e;
            if (function1 == null) {
                m<T> c = super.c(z);
                if (c == null) {
                    a(0);
                }
                return c;
            }
            m<T> d = m.d(function1.invoke(Boolean.valueOf(z)));
            if (d == null) {
                a(1);
            }
            return d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.h
        protected void d(@NotNull T t) {
            if (t == null) {
                a(2);
            }
            this.f.invoke(t);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class d<K, V> extends e<K, V> implements CacheWithNotNullValues<K, V> {
        /* synthetic */ d(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap concurrentMap, a aVar) {
            this(lockBasedStorageManager, concurrentMap);
        }

        private static /* synthetic */ void a(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 3 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "computation";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.e, kotlin.reflect.jvm.internal.impl.storage.CacheWithNotNullValues
        @NotNull
        public V computeIfAbsent(K k, @NotNull Function0<? extends V> function0) {
            if (function0 == null) {
                a(2);
            }
            V v = (V) super.computeIfAbsent(k, function0);
            if (v == null) {
                a(3);
            }
            return v;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private d(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<f<K, V>, Object> concurrentMap) {
            super(lockBasedStorageManager, concurrentMap, null);
            if (lockBasedStorageManager == null) {
                a(0);
            }
            if (concurrentMap == null) {
                a(1);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class e<K, V> extends k<f<K, V>, V> implements CacheWithNullableValues<K, V> {

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        class a implements Function1<f<K, V>, V> {
            a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public V invoke(f<K, V> fVar) {
                return (V) ((f) fVar).b.invoke();
            }
        }

        /* synthetic */ e(LockBasedStorageManager lockBasedStorageManager, ConcurrentMap concurrentMap, a aVar) {
            this(lockBasedStorageManager, concurrentMap);
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Nullable
        public V computeIfAbsent(K k, @NotNull Function0<? extends V> function0) {
            if (function0 == null) {
                a(2);
            }
            return invoke(new f(k, function0));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private e(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<f<K, V>, Object> concurrentMap) {
            super(lockBasedStorageManager, concurrentMap, new a());
            if (lockBasedStorageManager == null) {
                a(0);
            }
            if (concurrentMap == null) {
                a(1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class f<K, V> {
        private final K a;
        private final Function0<? extends V> b;

        public f(K k, Function0<? extends V> function0) {
            this.a = k;
            this.b = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && f.class == obj.getClass() && this.a.equals(((f) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class g<T> implements NullableLazyValue<T> {
        private final LockBasedStorageManager a;
        private final Function0<? extends T> b;
        @Nullable
        private volatile Object c;

        public g(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            if (lockBasedStorageManager == null) {
                a(0);
            }
            if (function0 == null) {
                a(1);
            }
            this.c = NotValue.NOT_COMPUTED;
            this.a = lockBasedStorageManager;
            this.b = function0;
        }

        private static /* synthetic */ void a(int i) {
            String str = (i == 2 || i == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 2 || i == 3) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i == 2 || i == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 2) {
                objArr[1] = "recursionDetected";
            } else if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i != 2 && i != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        protected void b(T t) {
        }

        @NotNull
        protected m<T> c(boolean z) {
            m<T> g = this.a.g("in a lazy value", null);
            if (g == null) {
                a(2);
            }
            return g;
        }

        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            T invoke;
            Object obj = this.c;
            if (obj instanceof NotValue) {
                this.a.a.lock();
                try {
                    Object obj2 = this.c;
                    if (obj2 instanceof NotValue) {
                        NotValue notValue = NotValue.COMPUTING;
                        if (obj2 == notValue) {
                            this.c = NotValue.RECURSION_WAS_DETECTED;
                            m<T> c = c(true);
                            if (!c.c()) {
                                invoke = c.b();
                            }
                        }
                        if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                            m<T> c2 = c(false);
                            if (!c2.c()) {
                                invoke = c2.b();
                            }
                        }
                        this.c = notValue;
                        invoke = this.b.invoke();
                        b(invoke);
                        this.c = invoke;
                    } else {
                        invoke = (T) WrappedValues.f(obj2);
                    }
                    return invoke;
                } finally {
                    this.a.a.unlock();
                }
            }
            return (T) WrappedValues.f(obj);
        }

        public boolean isComputed() {
            return (this.c == NotValue.NOT_COMPUTED || this.c == NotValue.COMPUTING) ? false : true;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static abstract class h<T> extends g<T> {
        @Nullable
        private volatile kotlin.reflect.jvm.internal.impl.storage.a<T> d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                a(0);
            }
            if (function0 == null) {
                a(1);
            }
            this.d = null;
        }

        private static /* synthetic */ void a(int i) {
            Object[] objArr = new Object[3];
            if (i != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.g
        protected final void b(T t) {
            this.d = new kotlin.reflect.jvm.internal.impl.storage.a<>(t);
            try {
                d(t);
            } finally {
                this.d = null;
            }
        }

        protected abstract void d(T t);

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.g, kotlin.jvm.functions.Function0
        public T invoke() {
            kotlin.reflect.jvm.internal.impl.storage.a<T> aVar = this.d;
            if (aVar != null && aVar.b()) {
                return aVar.a();
            }
            return (T) super.invoke();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static class i<T> extends g<T> implements NotNullLazyValue<T> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                a(0);
            }
            if (function0 == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 2 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.g, kotlin.jvm.functions.Function0
        @NotNull
        public T invoke() {
            T t = (T) super.invoke();
            if (t == null) {
                a(2);
            }
            return t;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static abstract class j<T> extends h<T> implements NotNullLazyValue<T> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull Function0<? extends T> function0) {
            super(lockBasedStorageManager, function0);
            if (lockBasedStorageManager == null) {
                a(0);
            }
            if (function0 == null) {
                a(1);
            }
        }

        private static /* synthetic */ void a(int i) {
            String str = i != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 2 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "computable";
            } else if (i != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i == 2) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.h, kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.g, kotlin.jvm.functions.Function0
        @NotNull
        public T invoke() {
            T t = (T) super.invoke();
            if (t == null) {
                a(2);
            }
            return t;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class k<K, V> implements MemoizedFunctionToNullable<K, V> {
        private final LockBasedStorageManager a;
        private final ConcurrentMap<K, Object> b;
        private final Function1<? super K, ? extends V> c;

        public k(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull Function1<? super K, ? extends V> function1) {
            if (lockBasedStorageManager == null) {
                a(0);
            }
            if (concurrentMap == null) {
                a(1);
            }
            if (function1 == null) {
                a(2);
            }
            this.a = lockBasedStorageManager;
            this.b = concurrentMap;
            this.c = function1;
        }

        private static /* synthetic */ void a(int i) {
            String str = (i == 3 || i == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i == 3 || i == 4) ? 2 : 3];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i == 3 || i == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i == 3) {
                objArr[1] = "recursionDetected";
            } else if (i != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i != 3 && i != 4) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i != 3 && i != 4) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @NotNull
        private AssertionError b(K k, Object obj) {
            AssertionError assertionError = (AssertionError) LockBasedStorageManager.h(new AssertionError("Race condition detected on input " + k + ". Old value is " + obj + " under " + this.a));
            if (assertionError == null) {
                a(4);
            }
            return assertionError;
        }

        @NotNull
        protected m<V> c(K k, boolean z) {
            m<V> g = this.a.g("", k);
            if (g == null) {
                a(3);
            }
            return g;
        }

        @Override // kotlin.jvm.functions.Function1
        @Nullable
        public V invoke(K k) {
            V v;
            Object obj = this.b.get(k);
            if (obj == null || obj == NotValue.COMPUTING) {
                this.a.a.lock();
                try {
                    Object obj2 = this.b.get(k);
                    NotValue notValue = NotValue.COMPUTING;
                    if (obj2 == notValue) {
                        obj2 = NotValue.RECURSION_WAS_DETECTED;
                        m<V> c = c(k, true);
                        if (!c.c()) {
                            v = c.b();
                            return v;
                        }
                    }
                    if (obj2 == NotValue.RECURSION_WAS_DETECTED) {
                        m<V> c2 = c(k, false);
                        if (!c2.c()) {
                            v = c2.b();
                            return v;
                        }
                    }
                    if (obj2 != null) {
                        v = (V) WrappedValues.d(obj2);
                        return v;
                    }
                    this.b.put(k, notValue);
                    V invoke = this.c.invoke(k);
                    Object put = this.b.put(k, WrappedValues.b(invoke));
                    if (put == notValue) {
                        return invoke;
                    }
                    throw b(k, put);
                } finally {
                    this.a.a.unlock();
                }
            }
            return (V) WrappedValues.d(obj);
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable
        public boolean isComputed(K k) {
            Object obj = this.b.get(k);
            return (obj == null || obj == NotValue.COMPUTING) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class l<K, V> extends k<K, V> implements MemoizedFunctionToNotNull<K, V> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(@NotNull LockBasedStorageManager lockBasedStorageManager, @NotNull ConcurrentMap<K, Object> concurrentMap, @NotNull Function1<? super K, ? extends V> function1) {
            super(lockBasedStorageManager, concurrentMap, function1);
            if (lockBasedStorageManager == null) {
                a(0);
            }
            if (concurrentMap == null) {
                a(1);
            }
            if (function1 == null) {
                a(2);
            }
        }

        private static /* synthetic */ void a(int i) {
            String str = i != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i != 3 ? 3 : 2];
            if (i == 1) {
                objArr[0] = "map";
            } else if (i == 2) {
                objArr[0] = "compute";
            } else if (i != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i == 3) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.k, kotlin.jvm.functions.Function1
        @NotNull
        public V invoke(K k) {
            V v = (V) super.invoke(k);
            if (v == null) {
                a(3);
            }
            return v;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class m<T> {
        private final T a;
        private final boolean b;

        private m(T t, boolean z) {
            this.a = t;
            this.b = z;
        }

        @NotNull
        public static <T> m<T> a() {
            return new m<>(null, true);
        }

        @NotNull
        public static <T> m<T> d(T t) {
            return new m<>(t, false);
        }

        public T b() {
            return this.a;
        }

        public boolean c() {
            return this.b;
        }

        public String toString() {
            return c() ? "FALL_THROUGH" : String.valueOf(this.a);
        }
    }

    static {
        String L0;
        L0 = StringsKt__StringsKt.L0(LockBasedStorageManager.class.getCanonicalName(), ".", "");
        d = L0;
        NO_LOCKS = new a("NO_LOCKS", ExceptionHandlingStrategy.THROW, le0.INSTANCE);
    }

    /* synthetic */ LockBasedStorageManager(String str, ExceptionHandlingStrategy exceptionHandlingStrategy, SimpleLock simpleLock, a aVar) {
        this(str, exceptionHandlingStrategy, simpleLock);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void a(int r13) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager.a(int):void");
    }

    static /* synthetic */ ExceptionHandlingStrategy b(LockBasedStorageManager lockBasedStorageManager) {
        return lockBasedStorageManager.b;
    }

    @NotNull
    private static <K> ConcurrentMap<K, Object> d() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NotNull
    public static <T extends Throwable> T h(@NotNull T t) {
        if (t == null) {
            a(36);
        }
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            } else if (!stackTrace[i3].getClassName().startsWith(d)) {
                i2 = i3;
                break;
            } else {
                i3++;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i2, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    public <T> T compute(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            a(34);
        }
        this.a.lock();
        try {
            return function0.invoke();
        } finally {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <K, V> CacheWithNotNullValues<K, V> createCacheWithNotNullValues() {
        return new d(this, d(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <K, V> CacheWithNullableValues<K, V> createCacheWithNullableValues() {
        return new e(this, d(), null);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <T> NotNullLazyValue<T> createLazyValue(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            a(23);
        }
        return new i(this, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <T> NotNullLazyValue<T> createLazyValueWithPostCompute(@NotNull Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, @NotNull Function1<? super T, wt2> function12) {
        if (function0 == null) {
            a(28);
        }
        if (function12 == null) {
            a(29);
        }
        return new c(this, this, function0, function1, function12);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> createMemoizedFunction(@NotNull Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            a(9);
        }
        MemoizedFunctionToNotNull<K, V> e2 = e(function1, d());
        if (e2 == null) {
            a(10);
        }
        return e2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> createMemoizedFunctionWithNullableValues(@NotNull Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            a(19);
        }
        MemoizedFunctionToNullable<K, V> f2 = f(function1, d());
        if (f2 == null) {
            a(20);
        }
        return f2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <T> NullableLazyValue<T> createNullableLazyValue(@NotNull Function0<? extends T> function0) {
        if (function0 == null) {
            a(30);
        }
        return new g(this, function0);
    }

    @Override // kotlin.reflect.jvm.internal.impl.storage.StorageManager
    @NotNull
    public <T> NotNullLazyValue<T> createRecursionTolerantLazyValue(@NotNull Function0<? extends T> function0, @NotNull T t) {
        if (function0 == null) {
            a(26);
        }
        if (t == null) {
            a(27);
        }
        return new b(this, this, function0, t);
    }

    @NotNull
    public <K, V> MemoizedFunctionToNotNull<K, V> e(@NotNull Function1<? super K, ? extends V> function1, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            a(14);
        }
        if (concurrentMap == null) {
            a(15);
        }
        return new l(this, concurrentMap, function1);
    }

    @NotNull
    public <K, V> MemoizedFunctionToNullable<K, V> f(@NotNull Function1<? super K, ? extends V> function1, @NotNull ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            a(21);
        }
        if (concurrentMap == null) {
            a(22);
        }
        return new k(this, concurrentMap, function1);
    }

    @NotNull
    protected <K, V> m<V> g(@NotNull String str, K k2) {
        String str2;
        if (str == null) {
            a(35);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Recursion detected ");
        sb.append(str);
        if (k2 == null) {
            str2 = "";
        } else {
            str2 = "on input: " + k2;
        }
        sb.append(str2);
        sb.append(" under ");
        sb.append(this);
        throw ((AssertionError) h(new AssertionError(sb.toString())));
    }

    public String toString() {
        return getClass().getSimpleName() + m80.DINAMIC_PREFIX_AT + Integer.toHexString(hashCode()) + " (" + this.c + jn1.BRACKET_END_STR;
    }

    private LockBasedStorageManager(@NotNull String str, @NotNull ExceptionHandlingStrategy exceptionHandlingStrategy, @NotNull SimpleLock simpleLock) {
        if (str == null) {
            a(4);
        }
        if (exceptionHandlingStrategy == null) {
            a(5);
        }
        if (simpleLock == null) {
            a(6);
        }
        this.a = simpleLock;
        this.b = exceptionHandlingStrategy;
        this.c = str;
    }

    public LockBasedStorageManager(String str) {
        this(str, (Runnable) null, (Function1<InterruptedException, wt2>) null);
    }

    public LockBasedStorageManager(String str, @Nullable Runnable runnable, @Nullable Function1<InterruptedException, wt2> function1) {
        this(str, ExceptionHandlingStrategy.THROW, SimpleLock.Companion.a(runnable, function1));
    }
}
