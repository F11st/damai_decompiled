package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.jn1;
import tb.nm1;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public final class Suppliers {

    /* compiled from: Taobao */
    @VisibleForTesting
    /* loaded from: classes10.dex */
    static class ExpiringMemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;
        final long durationNanos;
        volatile transient long expirationNanos;
        @NullableDecl
        volatile transient T value;

        ExpiringMemoizingSupplier(Supplier<T> supplier, long j, TimeUnit timeUnit) {
            this.delegate = (Supplier) du1.p(supplier);
            this.durationNanos = timeUnit.toNanos(j);
            du1.j(j > 0, "duration (%s %s) must be > 0", j, timeUnit);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            long j = this.expirationNanos;
            long f = f.f();
            if (j == 0 || f - j >= 0) {
                synchronized (this) {
                    if (j == this.expirationNanos) {
                        T t = this.delegate.get();
                        this.value = t;
                        long j2 = f + this.durationNanos;
                        if (j2 == 0) {
                            j2 = 1;
                        }
                        this.expirationNanos = j2;
                        return t;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            return "Suppliers.memoizeWithExpiration(" + this.delegate + AVFSCacheConstants.COMMA_SEP + this.durationNanos + ", NANOS)";
        }
    }

    /* compiled from: Taobao */
    @VisibleForTesting
    /* loaded from: classes10.dex */
    static class MemoizingSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;
        volatile transient boolean initialized;
        @NullableDecl
        transient T value;

        MemoizingSupplier(Supplier<T> supplier) {
            this.delegate = (Supplier) du1.p(supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    if (!this.initialized) {
                        T t = this.delegate.get();
                        this.value = t;
                        this.initialized = true;
                        return t;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("Suppliers.memoize(");
            if (this.initialized) {
                obj = "<supplier that returned " + this.value + jn1.G;
            } else {
                obj = this.delegate;
            }
            sb.append(obj);
            sb.append(jn1.BRACKET_END_STR);
            return sb.toString();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static class SupplierComposition<F, T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Function<? super F, T> function;
        final Supplier<F> supplier;

        SupplierComposition(Function<? super F, T> function, Supplier<F> supplier) {
            this.function = (Function) du1.p(function);
            this.supplier = (Supplier) du1.p(supplier);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof SupplierComposition) {
                SupplierComposition supplierComposition = (SupplierComposition) obj;
                return this.function.equals(supplierComposition.function) && this.supplier.equals(supplierComposition.supplier);
            }
            return false;
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            return this.function.apply((F) this.supplier.get());
        }

        public int hashCode() {
            return nm1.b(this.function, this.supplier);
        }

        public String toString() {
            return "Suppliers.compose(" + this.function + AVFSCacheConstants.COMMA_SEP + this.supplier + jn1.BRACKET_END_STR;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private interface SupplierFunction<T> extends Function<Supplier<T>, T> {
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private enum SupplierFunctionImpl implements SupplierFunction<Object> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Suppliers.supplierFunction()";
        }

        @Override // com.google.common.base.Function
        public Object apply(Supplier<Object> supplier) {
            return supplier.get();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static class SupplierOfInstance<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        @NullableDecl
        final T instance;

        SupplierOfInstance(@NullableDecl T t) {
            this.instance = t;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof SupplierOfInstance) {
                return nm1.a(this.instance, ((SupplierOfInstance) obj).instance);
            }
            return false;
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return nm1.b(this.instance);
        }

        public String toString() {
            return "Suppliers.ofInstance(" + this.instance + jn1.BRACKET_END_STR;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private static class ThreadSafeSupplier<T> implements Supplier<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Supplier<T> delegate;

        ThreadSafeSupplier(Supplier<T> supplier) {
            this.delegate = (Supplier) du1.p(supplier);
        }

        @Override // com.google.common.base.Supplier
        public T get() {
            T t;
            synchronized (this.delegate) {
                t = this.delegate.get();
            }
            return t;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.delegate + jn1.BRACKET_END_STR;
        }
    }

    public static <T> Supplier<T> a(@NullableDecl T t) {
        return new SupplierOfInstance(t);
    }
}
