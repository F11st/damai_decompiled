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

        /* synthetic */ PureJavaLongAddable(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a implements Supplier<LongAddable> {
        a() {
        }

        @Override // com.google.common.base.Supplier
        /* renamed from: a */
        public LongAddable get() {
            return new LongAdder();
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class b implements Supplier<LongAddable> {
        b() {
        }

        @Override // com.google.common.base.Supplier
        /* renamed from: a */
        public LongAddable get() {
            return new PureJavaLongAddable(null);
        }
    }

    static {
        Supplier<LongAddable> bVar;
        try {
            new LongAdder();
            bVar = new a();
        } catch (Throwable unused) {
            bVar = new b();
        }
        a = bVar;
    }

    public static LongAddable a() {
        return a.get();
    }
}
