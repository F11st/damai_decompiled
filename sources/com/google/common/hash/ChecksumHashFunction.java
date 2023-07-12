package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.zip.Checksum;
import tb.du1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@Immutable
/* loaded from: classes10.dex */
public final class ChecksumHashFunction extends com.google.common.hash.b implements Serializable {
    private static final long serialVersionUID = 0;
    private final int bits;
    private final ImmutableSupplier<? extends Checksum> checksumSupplier;
    private final String toString;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private final class b extends com.google.common.hash.a {
        private final Checksum b;

        @Override // com.google.common.hash.a
        protected void b(byte b) {
            this.b.update(b);
        }

        @Override // com.google.common.hash.a
        protected void e(byte[] bArr, int i, int i2) {
            this.b.update(bArr, i, i2);
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            long value = this.b.getValue();
            if (ChecksumHashFunction.this.bits == 32) {
                return HashCode.fromInt((int) value);
            }
            return HashCode.fromLong(value);
        }

        private b(Checksum checksum) {
            this.b = (Checksum) du1.p(checksum);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChecksumHashFunction(ImmutableSupplier<? extends Checksum> immutableSupplier, int i, String str) {
        this.checksumSupplier = (ImmutableSupplier) du1.p(immutableSupplier);
        du1.f(i == 32 || i == 64, "bits (%s) must be either 32 or 64", i);
        this.bits = i;
        this.toString = (String) du1.p(str);
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return this.bits;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new b(this.checksumSupplier.get());
    }

    public String toString() {
        return this.toString;
    }
}
