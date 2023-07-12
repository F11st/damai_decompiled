package com.google.common.hash;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
final class LongAddables {
    private static final Supplier<LongAddable> a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        @Override // com.google.common.hash.LongAddable
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // com.google.common.hash.LongAddable
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.hash.LongAddable
        public long sum() {
            return get();
        }

        /* synthetic */ PureJavaLongAddable(C5219a c5219a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.hash.LongAddables$a */
    /* loaded from: classes10.dex */
    public static class C5219a implements Supplier<LongAddable> {
        C5219a() {
        }

        @Override // com.google.common.base.Supplier
        /* renamed from: a */
        public LongAddable get() {
            return new LongAdder();
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.google.common.hash.LongAddables$b */
    /* loaded from: classes10.dex */
    static class C5220b implements Supplier<LongAddable> {
        C5220b() {
        }

        @Override // com.google.common.base.Supplier
        /* renamed from: a */
        public LongAddable get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        Supplier<LongAddable> c5220b;
        try {
            new LongAdder();
            c5220b = new C5219a();
        } catch (Throwable unused) {
            c5220b = new C5220b();
        }
        a = c5220b;
    }

    public static LongAddable a() {
        return a.get();
    }
}
