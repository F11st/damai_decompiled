package kotlin.random;

import java.io.Serializable;
import org.jetbrains.annotations.NotNull;
import tb.k50;
import tb.oy1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class XorWowRandom extends Random implements Serializable {
    @NotNull
    private static final C8239a Companion = new C8239a(null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private int addend;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* compiled from: Taobao */
    /* renamed from: kotlin.random.XorWowRandom$a */
    /* loaded from: classes3.dex */
    private static final class C8239a {
        private C8239a() {
        }

        public /* synthetic */ C8239a(k50 k50Var) {
            this();
        }
    }

    public XorWowRandom(int i, int i2, int i3, int i4, int i5, int i6) {
        this.x = i;
        this.y = i2;
        this.z = i3;
        this.w = i4;
        this.v = i5;
        this.addend = i6;
        int i7 = i | i2 | i3 | i4 | i5;
        if (!(i7 != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i8 = 0; i8 < 64; i8++) {
            nextInt();
        }
    }

    @Override // kotlin.random.Random
    public int nextBits(int i) {
        return oy1.f(nextInt(), i);
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        int i = this.x;
        int i2 = i ^ (i >>> 2);
        this.x = this.y;
        this.y = this.z;
        this.z = this.w;
        int i3 = this.v;
        this.w = i3;
        int i4 = ((i2 ^ (i2 << 1)) ^ i3) ^ (i3 << 4);
        this.v = i4;
        int i5 = this.addend + 362437;
        this.addend = i5;
        return i4 + i5;
    }

    public XorWowRandom(int i, int i2) {
        this(i, i2, 0, 0, ~i, (i << 10) ^ (i2 >>> 4));
    }
}
