package com.google.common.hash;

import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import tb.cu2;
import tb.du1;
import tb.ii;
import tb.jn1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@Immutable
/* loaded from: classes10.dex */
public final class Murmur3_32HashFunction extends AbstractC5229b implements Serializable {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final int CHUNK_SIZE = 4;
    private static final long serialVersionUID = 0;
    private final int seed;
    static final HashFunction MURMUR3_32 = new Murmur3_32HashFunction(0);
    static final HashFunction GOOD_FAST_HASH_32 = new Murmur3_32HashFunction(Hashing.a);

    /* compiled from: Taobao */
    @CanIgnoreReturnValue
    /* renamed from: com.google.common.hash.Murmur3_32HashFunction$a */
    /* loaded from: classes10.dex */
    private static final class C5224a extends AbstractC5230c {
        private int a;
        private long b;
        private int c;
        private int d = 0;
        private boolean e = false;

        C5224a(int i) {
            this.a = i;
        }

        private void a(int i, long j) {
            long j2 = this.b;
            int i2 = this.c;
            long j3 = ((j & 4294967295L) << i2) | j2;
            this.b = j3;
            int i3 = i2 + (i * 8);
            this.c = i3;
            this.d += i;
            if (i3 >= 32) {
                this.a = Murmur3_32HashFunction.mixH1(this.a, Murmur3_32HashFunction.mixK1((int) j3));
                this.b >>>= 32;
                this.c -= 32;
            }
        }

        @Override // com.google.common.hash.Hasher
        public HashCode hash() {
            du1.w(!this.e);
            this.e = true;
            int mixK1 = this.a ^ Murmur3_32HashFunction.mixK1((int) this.b);
            this.a = mixK1;
            return Murmur3_32HashFunction.fmix(mixK1, this.d);
        }

        @Override // com.google.common.hash.PrimitiveSink
        public Hasher putByte(byte b) {
            a(1, b & 255);
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public Hasher putChar(char c) {
            a(2, c);
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public Hasher putInt(int i) {
            a(4, i);
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public Hasher putLong(long j) {
            a(4, (int) j);
            a(4, j >>> 32);
            return this;
        }

        @Override // com.google.common.hash.AbstractC5230c, com.google.common.hash.PrimitiveSink
        public Hasher putString(CharSequence charSequence, Charset charset) {
            if (ii.UTF_8.equals(charset)) {
                int length = charSequence.length();
                int i = 0;
                while (true) {
                    int i2 = i + 4;
                    if (i2 > length) {
                        break;
                    }
                    char charAt = charSequence.charAt(i);
                    char charAt2 = charSequence.charAt(i + 1);
                    char charAt3 = charSequence.charAt(i + 2);
                    char charAt4 = charSequence.charAt(i + 3);
                    if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                        break;
                    }
                    a(4, (charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24));
                    i = i2;
                }
                while (i < length) {
                    char charAt5 = charSequence.charAt(i);
                    if (charAt5 < 128) {
                        a(1, charAt5);
                    } else if (charAt5 < 2048) {
                        a(2, Murmur3_32HashFunction.charToTwoUtf8Bytes(charAt5));
                    } else if (charAt5 < 55296 || charAt5 > 57343) {
                        a(3, Murmur3_32HashFunction.charToThreeUtf8Bytes(charAt5));
                    } else {
                        int codePointAt = Character.codePointAt(charSequence, i);
                        if (codePointAt != charAt5) {
                            i++;
                            a(4, Murmur3_32HashFunction.codePointToFourUtf8Bytes(codePointAt));
                        } else {
                            putBytes(charSequence.subSequence(i, length).toString().getBytes(charset));
                            return this;
                        }
                    }
                    i++;
                }
                return this;
            }
            return super.putString(charSequence, charset);
        }

        @Override // com.google.common.hash.PrimitiveSink
        public Hasher putBytes(byte[] bArr, int i, int i2) {
            du1.v(i, i + i2, bArr.length);
            int i3 = 0;
            while (true) {
                int i4 = i3 + 4;
                if (i4 > i2) {
                    break;
                }
                a(4, Murmur3_32HashFunction.getIntLittleEndian(bArr, i3 + i));
                i3 = i4;
            }
            while (i3 < i2) {
                putByte(bArr[i + i3]);
                i3++;
            }
            return this;
        }

        @Override // com.google.common.hash.PrimitiveSink
        public Hasher putBytes(ByteBuffer byteBuffer) {
            ByteOrder order = byteBuffer.order();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            while (byteBuffer.remaining() >= 4) {
                putInt(byteBuffer.getInt());
            }
            while (byteBuffer.hasRemaining()) {
                putByte(byteBuffer.get());
            }
            byteBuffer.order(order);
            return this;
        }
    }

    Murmur3_32HashFunction(int i) {
        this.seed = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToThreeUtf8Bytes(char c) {
        return (((c & jn1.CONDITION_IF) | 128) << 16) | (((c >>> '\f') | GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH) & 255) | ((((c >>> 6) & 63) | 128) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long charToTwoUtf8Bytes(char c) {
        return (((c & jn1.CONDITION_IF) | 128) << 8) | (((c >>> 6) | 960) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long codePointToFourUtf8Bytes(int i) {
        return (((i >>> 18) | 240) & 255) | ((((i >>> 12) & 63) | 128) << 8) | ((((i >>> 6) & 63) | 128) << 16) | (((i & 63) | 128) << 24);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashCode fmix(int i, int i2) {
        int i3 = i ^ i2;
        int i4 = (i3 ^ (i3 >>> 16)) * (-2048144789);
        int i5 = (i4 ^ (i4 >>> 13)) * (-1028477387);
        return HashCode.fromInt(i5 ^ (i5 >>> 16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getIntLittleEndian(byte[] bArr, int i) {
        return Ints.e(bArr[i + 3], bArr[i + 2], bArr[i + 1], bArr[i]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixH1(int i, int i2) {
        return (Integer.rotateLeft(i ^ i2, 13) * 5) - 430675100;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mixK1(int i) {
        return Integer.rotateLeft(i * C1, 15) * C2;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 32;
    }

    public boolean equals(@NullableDecl Object obj) {
        return (obj instanceof Murmur3_32HashFunction) && this.seed == ((Murmur3_32HashFunction) obj).seed;
    }

    @Override // com.google.common.hash.AbstractC5229b, com.google.common.hash.HashFunction
    public HashCode hashBytes(byte[] bArr, int i, int i2) {
        du1.v(i, i + i2, bArr.length);
        int i3 = this.seed;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5 + 4;
            if (i6 > i2) {
                break;
            }
            i3 = mixH1(i3, mixK1(getIntLittleEndian(bArr, i5 + i)));
            i5 = i6;
        }
        int i7 = i5;
        int i8 = 0;
        while (i7 < i2) {
            i4 ^= cu2.c(bArr[i + i7]) << i8;
            i7++;
            i8 += 8;
        }
        return fmix(mixK1(i4) ^ i3, i2);
    }

    public int hashCode() {
        return Murmur3_32HashFunction.class.hashCode() ^ this.seed;
    }

    @Override // com.google.common.hash.AbstractC5229b, com.google.common.hash.HashFunction
    public HashCode hashInt(int i) {
        return fmix(mixH1(this.seed, mixK1(i)), 4);
    }

    @Override // com.google.common.hash.AbstractC5229b, com.google.common.hash.HashFunction
    public HashCode hashLong(long j) {
        int i = (int) (j >>> 32);
        return fmix(mixH1(mixH1(this.seed, mixK1((int) j)), mixK1(i)), 8);
    }

    @Override // com.google.common.hash.AbstractC5229b, com.google.common.hash.HashFunction
    public HashCode hashString(CharSequence charSequence, Charset charset) {
        if (ii.UTF_8.equals(charset)) {
            int length = charSequence.length();
            int i = this.seed;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = i3 + 4;
                if (i5 > length) {
                    break;
                }
                char charAt = charSequence.charAt(i3);
                char charAt2 = charSequence.charAt(i3 + 1);
                char charAt3 = charSequence.charAt(i3 + 2);
                char charAt4 = charSequence.charAt(i3 + 3);
                if (charAt >= 128 || charAt2 >= 128 || charAt3 >= 128 || charAt4 >= 128) {
                    break;
                }
                i = mixH1(i, mixK1((charAt2 << '\b') | charAt | (charAt3 << 16) | (charAt4 << 24)));
                i4 += 4;
                i3 = i5;
            }
            long j = 0;
            while (i3 < length) {
                char charAt5 = charSequence.charAt(i3);
                if (charAt5 < 128) {
                    j |= charAt5 << i2;
                    i2 += 8;
                    i4++;
                } else if (charAt5 < 2048) {
                    j |= charToTwoUtf8Bytes(charAt5) << i2;
                    i2 += 16;
                    i4 += 2;
                } else if (charAt5 >= 55296 && charAt5 <= 57343) {
                    int codePointAt = Character.codePointAt(charSequence, i3);
                    if (codePointAt == charAt5) {
                        return hashBytes(charSequence.toString().getBytes(charset));
                    }
                    i3++;
                    j |= codePointToFourUtf8Bytes(codePointAt) << i2;
                    i4 += 4;
                } else {
                    j |= charToThreeUtf8Bytes(charAt5) << i2;
                    i2 += 24;
                    i4 += 3;
                }
                if (i2 >= 32) {
                    i = mixH1(i, mixK1((int) j));
                    j >>>= 32;
                    i2 -= 32;
                }
                i3++;
            }
            return fmix(mixK1((int) j) ^ i, i4);
        }
        return hashBytes(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.common.hash.AbstractC5229b, com.google.common.hash.HashFunction
    public HashCode hashUnencodedChars(CharSequence charSequence) {
        int i = this.seed;
        for (int i2 = 1; i2 < charSequence.length(); i2 += 2) {
            i = mixH1(i, mixK1(charSequence.charAt(i2 - 1) | (charSequence.charAt(i2) << 16)));
        }
        if ((charSequence.length() & 1) == 1) {
            i ^= mixK1(charSequence.charAt(charSequence.length() - 1));
        }
        return fmix(i, charSequence.length() * 2);
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new C5224a(this.seed);
    }

    public String toString() {
        return "Hashing.murmur3_32(" + this.seed + jn1.BRACKET_END_STR;
    }
}
