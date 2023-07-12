package kotlin.random;

import org.jetbrains.annotations.NotNull;
import tb.b41;
import tb.k50;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
final class KotlinRandom extends java.util.Random {
    @NotNull
    private static final a Companion = new a(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    @NotNull
    private final Random impl;
    private boolean seedInitialized;

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(k50 k50Var) {
            this();
        }
    }

    public KotlinRandom(@NotNull Random random) {
        b41.i(random, "impl");
        this.impl = random;
    }

    @NotNull
    public final Random getImpl() {
        return this.impl;
    }

    @Override // java.util.Random
    protected int next(int i) {
        return this.impl.nextBits(i);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    @Override // java.util.Random
    public void nextBytes(@NotNull byte[] bArr) {
        b41.i(bArr, "bytes");
        this.impl.nextBytes(bArr);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.impl.nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.impl.nextFloat();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.impl.nextInt();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.impl.nextLong();
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (!this.seedInitialized) {
            this.seedInitialized = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        return this.impl.nextInt(i);
    }
}
