package com.google.common.hash;

import com.google.common.hash.BloomFilter;
import com.google.common.math.LongMath;
import com.google.common.primitives.Ints;
import com.google.common.primitives.Longs;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes10.dex */
public enum BloomFilterStrategies implements BloomFilter.Strategy {
    MURMUR128_MITZ_32 { // from class: com.google.common.hash.BloomFilterStrategies.1
        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, C5214a c5214a) {
            long b = c5214a.b();
            long asLong = Hashing.a().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                if (!c5214a.d(i5 % b)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, C5214a c5214a) {
            long b = c5214a.b();
            long asLong = Hashing.a().hashObject(t, funnel).asLong();
            int i2 = (int) asLong;
            int i3 = (int) (asLong >>> 32);
            boolean z = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                z |= c5214a.f(i5 % b);
            }
            return z;
        }
    },
    MURMUR128_MITZ_64 { // from class: com.google.common.hash.BloomFilterStrategies.2
        private long lowerEight(byte[] bArr) {
            return Longs.d(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return Longs.d(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, C5214a c5214a) {
            long b = c5214a.b();
            byte[] bytesInternal = Hashing.a().hashObject(t, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            for (int i2 = 0; i2 < i; i2++) {
                if (!c5214a.d((AbsPerformance.LONG_NIL & lowerEight) % b)) {
                    return false;
                }
                lowerEight += upperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.BloomFilter.Strategy
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, C5214a c5214a) {
            long b = c5214a.b();
            byte[] bytesInternal = Hashing.a().hashObject(t, funnel).getBytesInternal();
            long lowerEight = lowerEight(bytesInternal);
            long upperEight = upperEight(bytesInternal);
            boolean z = false;
            for (int i2 = 0; i2 < i; i2++) {
                z |= c5214a.f((AbsPerformance.LONG_NIL & lowerEight) % b);
                lowerEight += upperEight;
            }
            return z;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.google.common.hash.BloomFilterStrategies$a */
    /* loaded from: classes10.dex */
    public static final class C5214a {
        final AtomicLongArray a;
        private final LongAddable b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C5214a(long j) {
            du1.e(j > 0, "data length is zero!");
            this.a = new AtomicLongArray(Ints.c(LongMath.a(j, 64L, RoundingMode.CEILING)));
            this.b = LongAddables.a();
        }

        public static long[] g(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = atomicLongArray.get(i);
            }
            return jArr;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long a() {
            return this.b.sum();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public long b() {
            return this.a.length() * 64;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C5214a c() {
            return new C5214a(g(this.a));
        }

        boolean d(long j) {
            return ((1 << ((int) j)) & this.a.get((int) (j >>> 6))) != 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void e(C5214a c5214a) {
            long j;
            long j2;
            boolean z;
            du1.g(this.a.length() == c5214a.a.length(), "BitArrays must be of equal length (%s != %s)", this.a.length(), c5214a.a.length());
            for (int i = 0; i < this.a.length(); i++) {
                long j3 = c5214a.a.get(i);
                while (true) {
                    j = this.a.get(i);
                    j2 = j | j3;
                    if (j == j2) {
                        z = false;
                        break;
                    } else if (this.a.compareAndSet(i, j, j2)) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    this.b.add(Long.bitCount(j2) - Long.bitCount(j));
                }
            }
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof C5214a) {
                return Arrays.equals(g(this.a), g(((C5214a) obj).a));
            }
            return false;
        }

        boolean f(long j) {
            long j2;
            long j3;
            if (d(j)) {
                return false;
            }
            int i = (int) (j >>> 6);
            long j4 = 1 << ((int) j);
            do {
                j2 = this.a.get(i);
                j3 = j2 | j4;
                if (j2 == j3) {
                    return false;
                }
            } while (!this.a.compareAndSet(i, j2, j3));
            this.b.increment();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(g(this.a));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C5214a(long[] jArr) {
            du1.e(jArr.length > 0, "data length is zero!");
            this.a = new AtomicLongArray(jArr);
            this.b = LongAddables.a();
            long j = 0;
            for (long j2 : jArr) {
                j += Long.bitCount(j2);
            }
            this.b.add(j);
        }
    }
}
