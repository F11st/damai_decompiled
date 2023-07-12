package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.du1;
import tb.jn1;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes10.dex */
final class SipHashFunction extends AbstractC5229b implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;
    private final int c;
    private final int d;
    private final long k0;
    private final long k1;

    /* compiled from: Taobao */
    /* renamed from: com.google.common.hash.SipHashFunction$a */
    /* loaded from: classes10.dex */
    private static final class C5225a extends AbstractC5231d {
        private final int d;
        private final int e;
        private long f;
        private long g;
        private long h;
        private long i;
        private long j;
        private long k;

        C5225a(int i, int i2, long j, long j2) {
            super(8);
            this.f = 8317987319222330741L;
            this.g = 7237128888997146477L;
            this.h = 7816392313619706465L;
            this.i = 8387220255154660723L;
            this.j = 0L;
            this.k = 0L;
            this.d = i;
            this.e = i2;
            this.f = 8317987319222330741L ^ j;
            this.g = 7237128888997146477L ^ j2;
            this.h = 7816392313619706465L ^ j;
            this.i = 8387220255154660723L ^ j2;
        }

        private void g(long j) {
            this.i ^= j;
            h(this.d);
            this.f = j ^ this.f;
        }

        private void h(int i) {
            for (int i2 = 0; i2 < i; i2++) {
                long j = this.f;
                long j2 = this.g;
                this.f = j + j2;
                this.h += this.i;
                this.g = Long.rotateLeft(j2, 13);
                long rotateLeft = Long.rotateLeft(this.i, 16);
                this.i = rotateLeft;
                long j3 = this.g;
                long j4 = this.f;
                this.g = j3 ^ j4;
                this.i = rotateLeft ^ this.h;
                long rotateLeft2 = Long.rotateLeft(j4, 32);
                this.f = rotateLeft2;
                long j5 = this.h;
                long j6 = this.g;
                this.h = j5 + j6;
                this.f = rotateLeft2 + this.i;
                this.g = Long.rotateLeft(j6, 17);
                long rotateLeft3 = Long.rotateLeft(this.i, 21);
                this.i = rotateLeft3;
                long j7 = this.g;
                long j8 = this.h;
                this.g = j7 ^ j8;
                this.i = rotateLeft3 ^ this.f;
                this.h = Long.rotateLeft(j8, 32);
            }
        }

        @Override // com.google.common.hash.AbstractC5231d
        public HashCode a() {
            long j = this.k ^ (this.j << 56);
            this.k = j;
            g(j);
            this.h ^= 255;
            h(this.e);
            return HashCode.fromLong(((this.f ^ this.g) ^ this.h) ^ this.i);
        }

        @Override // com.google.common.hash.AbstractC5231d
        protected void d(ByteBuffer byteBuffer) {
            this.j += 8;
            g(byteBuffer.getLong());
        }

        @Override // com.google.common.hash.AbstractC5231d
        protected void e(ByteBuffer byteBuffer) {
            this.j += byteBuffer.remaining();
            int i = 0;
            while (byteBuffer.hasRemaining()) {
                this.k ^= (byteBuffer.get() & 255) << i;
                i += 8;
            }
        }
    }

    SipHashFunction(int i, int i2, long j, long j2) {
        du1.f(i > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", i);
        du1.f(i2 > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", i2);
        this.c = i;
        this.d = i2;
        this.k0 = j;
        this.k1 = j2;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj instanceof SipHashFunction) {
            SipHashFunction sipHashFunction = (SipHashFunction) obj;
            return this.c == sipHashFunction.c && this.d == sipHashFunction.d && this.k0 == sipHashFunction.k0 && this.k1 == sipHashFunction.k1;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((((SipHashFunction.class.hashCode() ^ this.c) ^ this.d) ^ this.k0) ^ this.k1);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new C5225a(this.c, this.d, this.k0, this.k1);
    }

    public String toString() {
        return "Hashing.sipHash" + this.c + "" + this.d + jn1.BRACKET_START_STR + this.k0 + AVFSCacheConstants.COMMA_SEP + this.k1 + jn1.BRACKET_END_STR;
    }
}
