package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
@GwtCompatible(emulated = true)
/* loaded from: classes10.dex */
final class LongAddables {
    private static final Supplier<LongAddable> a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        @Override // com.google.common.cache.LongAddable
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // com.google.common.cache.LongAddable
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.LongAddable
        public long sum() {
            return get();
        }

        /* synthetic */ PureJavaLongAddable(C4887a c4887a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.cache.LongAddables$a */
    /* loaded from: classes10.dex */
    public static class C4887a implements Supplier<LongAddable> {
        C4887a() {
        }

        @Override // com.google.common.base.Supplier
        /* renamed from: a */
        public LongAddable get() {
            return new LongAdder();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.cache.LongAddables$b */
    /* loaded from: classes10.dex */
    static class C4888b implements Supplier<LongAddable> {
        C4888b() {
        }

        @Override // com.google.common.base.Supplier
        /* renamed from: a */
        public LongAddable get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        Supplier<LongAddable> c4888b;
        try {
            new LongAdder();
            c4888b = new C4887a();
        } catch (Throwable unused) {
            c4888b = new C4888b();
        }
        a = c4888b;
    }

    public static LongAddable a() {
        return a.get();
    }
}
