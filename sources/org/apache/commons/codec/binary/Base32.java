package org.apache.commons.codec.binary;

import org.apache.commons.codec.binary.BaseNCodec;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Base32 extends BaseNCodec {
    private static final int BITS_PER_ENCODED_BYTE = 5;
    private static final int BYTES_PER_ENCODED_BLOCK = 8;
    private static final int BYTES_PER_UNENCODED_BLOCK = 5;
    private static final byte[] CHUNK_SEPARATOR = {13, 10};
    private static final byte[] DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25};
    private static final byte[] ENCODE_TABLE = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, 52, 53, 54, 55};
    private static final byte[] HEX_DECODE_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, -1, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
    private static final byte[] HEX_ENCODE_TABLE = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86};
    private static final int MASK_5BITS = 31;
    private final int decodeSize;
    private final byte[] decodeTable;
    private final int encodeSize;
    private final byte[] encodeTable;
    private final byte[] lineSeparator;

    public Base32() {
        this(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void decode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        byte b;
        if (context.eof) {
            return;
        }
        ?? r3 = 1;
        if (i2 < 0) {
            context.eof = true;
        }
        int i3 = i;
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                break;
            }
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            if (b2 == this.pad) {
                context.eof = r3;
                break;
            }
            byte[] ensureBufferSize = ensureBufferSize(this.decodeSize, context);
            if (b2 >= 0) {
                byte[] bArr2 = this.decodeTable;
                if (b2 < bArr2.length && (b = bArr2[b2]) >= 0) {
                    int i6 = (context.modulus + r3) % 8;
                    context.modulus = i6;
                    long j = (context.lbitWorkArea << 5) + b;
                    context.lbitWorkArea = j;
                    if (i6 == 0) {
                        int i7 = context.pos;
                        int i8 = i7 + 1;
                        context.pos = i8;
                        ensureBufferSize[i7] = (byte) ((j >> 32) & 255);
                        int i9 = i8 + 1;
                        context.pos = i9;
                        ensureBufferSize[i8] = (byte) ((j >> 24) & 255);
                        int i10 = i9 + 1;
                        context.pos = i10;
                        ensureBufferSize[i9] = (byte) ((j >> 16) & 255);
                        int i11 = i10 + 1;
                        context.pos = i11;
                        ensureBufferSize[i10] = (byte) ((j >> 8) & 255);
                        context.pos = i11 + 1;
                        ensureBufferSize[i11] = (byte) (j & 255);
                    }
                }
            }
            i4++;
            i3 = i5;
            r3 = 1;
        }
        if (!context.eof || context.modulus < 2) {
            return;
        }
        byte[] ensureBufferSize2 = ensureBufferSize(this.decodeSize, context);
        switch (context.modulus) {
            case 2:
                int i12 = context.pos;
                context.pos = i12 + 1;
                ensureBufferSize2[i12] = (byte) ((context.lbitWorkArea >> 2) & 255);
                return;
            case 3:
                int i13 = context.pos;
                context.pos = i13 + 1;
                ensureBufferSize2[i13] = (byte) ((context.lbitWorkArea >> 7) & 255);
                return;
            case 4:
                long j2 = context.lbitWorkArea >> 4;
                context.lbitWorkArea = j2;
                int i14 = context.pos;
                int i15 = i14 + 1;
                context.pos = i15;
                ensureBufferSize2[i14] = (byte) ((j2 >> 8) & 255);
                context.pos = i15 + 1;
                ensureBufferSize2[i15] = (byte) (j2 & 255);
                return;
            case 5:
                long j3 = context.lbitWorkArea >> 1;
                context.lbitWorkArea = j3;
                int i16 = context.pos;
                int i17 = i16 + 1;
                context.pos = i17;
                ensureBufferSize2[i16] = (byte) ((j3 >> 16) & 255);
                int i18 = i17 + 1;
                context.pos = i18;
                ensureBufferSize2[i17] = (byte) ((j3 >> 8) & 255);
                context.pos = i18 + 1;
                ensureBufferSize2[i18] = (byte) (j3 & 255);
                return;
            case 6:
                long j4 = context.lbitWorkArea >> 6;
                context.lbitWorkArea = j4;
                int i19 = context.pos;
                int i20 = i19 + 1;
                context.pos = i20;
                ensureBufferSize2[i19] = (byte) ((j4 >> 16) & 255);
                int i21 = i20 + 1;
                context.pos = i21;
                ensureBufferSize2[i20] = (byte) ((j4 >> 8) & 255);
                context.pos = i21 + 1;
                ensureBufferSize2[i21] = (byte) (j4 & 255);
                return;
            case 7:
                long j5 = context.lbitWorkArea >> 3;
                context.lbitWorkArea = j5;
                int i22 = context.pos;
                int i23 = i22 + 1;
                context.pos = i23;
                ensureBufferSize2[i22] = (byte) ((j5 >> 24) & 255);
                int i24 = i23 + 1;
                context.pos = i24;
                ensureBufferSize2[i23] = (byte) ((j5 >> 16) & 255);
                int i25 = i24 + 1;
                context.pos = i25;
                ensureBufferSize2[i24] = (byte) ((j5 >> 8) & 255);
                context.pos = i25 + 1;
                ensureBufferSize2[i25] = (byte) (j5 & 255);
                return;
            default:
                throw new IllegalStateException("Impossible modulus " + context.modulus);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.apache.commons.codec.binary.BaseNCodec
    public void encode(byte[] bArr, int i, int i2, BaseNCodec.Context context) {
        int i3;
        if (context.eof) {
            return;
        }
        int i4 = 1;
        if (i2 >= 0) {
            int i5 = i;
            int i6 = 0;
            while (i6 < i2) {
                byte[] ensureBufferSize = ensureBufferSize(this.encodeSize, context);
                int i7 = (context.modulus + i4) % 5;
                context.modulus = i7;
                int i8 = i5 + 1;
                int i9 = bArr[i5];
                if (i9 < 0) {
                    i9 += 256;
                }
                long j = (context.lbitWorkArea << 8) + i9;
                context.lbitWorkArea = j;
                if (i7 == 0) {
                    int i10 = context.pos;
                    int i11 = i10 + 1;
                    context.pos = i11;
                    byte[] bArr2 = this.encodeTable;
                    ensureBufferSize[i10] = bArr2[((int) (j >> 35)) & 31];
                    int i12 = i11 + 1;
                    context.pos = i12;
                    ensureBufferSize[i11] = bArr2[((int) (j >> 30)) & 31];
                    int i13 = i12 + 1;
                    context.pos = i13;
                    i3 = i8;
                    ensureBufferSize[i12] = bArr2[((int) (j >> 25)) & 31];
                    int i14 = i13 + 1;
                    context.pos = i14;
                    ensureBufferSize[i13] = bArr2[((int) (j >> 20)) & 31];
                    int i15 = i14 + 1;
                    context.pos = i15;
                    ensureBufferSize[i14] = bArr2[((int) (j >> 15)) & 31];
                    int i16 = i15 + 1;
                    context.pos = i16;
                    ensureBufferSize[i15] = bArr2[((int) (j >> 10)) & 31];
                    int i17 = i16 + 1;
                    context.pos = i17;
                    ensureBufferSize[i16] = bArr2[((int) (j >> 5)) & 31];
                    int i18 = i17 + 1;
                    context.pos = i18;
                    ensureBufferSize[i17] = bArr2[((int) j) & 31];
                    int i19 = context.currentLinePos + 8;
                    context.currentLinePos = i19;
                    int i20 = this.lineLength;
                    if (i20 > 0 && i20 <= i19) {
                        byte[] bArr3 = this.lineSeparator;
                        System.arraycopy(bArr3, 0, ensureBufferSize, i18, bArr3.length);
                        context.pos += this.lineSeparator.length;
                        context.currentLinePos = 0;
                        i6++;
                        i5 = i3;
                        i4 = 1;
                    }
                } else {
                    i3 = i8;
                }
                i6++;
                i5 = i3;
                i4 = 1;
            }
            return;
        }
        context.eof = true;
        if (context.modulus == 0 && this.lineLength == 0) {
            return;
        }
        byte[] ensureBufferSize2 = ensureBufferSize(this.encodeSize, context);
        int i21 = context.pos;
        int i22 = context.modulus;
        if (i22 != 0) {
            if (i22 == 1) {
                int i23 = i21 + 1;
                context.pos = i23;
                byte[] bArr4 = this.encodeTable;
                long j2 = context.lbitWorkArea;
                ensureBufferSize2[i21] = bArr4[((int) (j2 >> 3)) & 31];
                int i24 = i23 + 1;
                context.pos = i24;
                ensureBufferSize2[i23] = bArr4[((int) (j2 << 2)) & 31];
                int i25 = i24 + 1;
                context.pos = i25;
                byte b = this.pad;
                ensureBufferSize2[i24] = b;
                int i26 = i25 + 1;
                context.pos = i26;
                ensureBufferSize2[i25] = b;
                int i27 = i26 + 1;
                context.pos = i27;
                ensureBufferSize2[i26] = b;
                int i28 = i27 + 1;
                context.pos = i28;
                ensureBufferSize2[i27] = b;
                int i29 = i28 + 1;
                context.pos = i29;
                ensureBufferSize2[i28] = b;
                context.pos = i29 + 1;
                ensureBufferSize2[i29] = b;
            } else if (i22 == 2) {
                int i30 = i21 + 1;
                context.pos = i30;
                byte[] bArr5 = this.encodeTable;
                long j3 = context.lbitWorkArea;
                ensureBufferSize2[i21] = bArr5[((int) (j3 >> 11)) & 31];
                int i31 = i30 + 1;
                context.pos = i31;
                ensureBufferSize2[i30] = bArr5[((int) (j3 >> 6)) & 31];
                int i32 = i31 + 1;
                context.pos = i32;
                ensureBufferSize2[i31] = bArr5[((int) (j3 >> 1)) & 31];
                int i33 = i32 + 1;
                context.pos = i33;
                ensureBufferSize2[i32] = bArr5[((int) (j3 << 4)) & 31];
                int i34 = i33 + 1;
                context.pos = i34;
                byte b2 = this.pad;
                ensureBufferSize2[i33] = b2;
                int i35 = i34 + 1;
                context.pos = i35;
                ensureBufferSize2[i34] = b2;
                int i36 = i35 + 1;
                context.pos = i36;
                ensureBufferSize2[i35] = b2;
                context.pos = i36 + 1;
                ensureBufferSize2[i36] = b2;
            } else if (i22 == 3) {
                int i37 = i21 + 1;
                context.pos = i37;
                byte[] bArr6 = this.encodeTable;
                long j4 = context.lbitWorkArea;
                ensureBufferSize2[i21] = bArr6[((int) (j4 >> 19)) & 31];
                int i38 = i37 + 1;
                context.pos = i38;
                ensureBufferSize2[i37] = bArr6[((int) (j4 >> 14)) & 31];
                int i39 = i38 + 1;
                context.pos = i39;
                ensureBufferSize2[i38] = bArr6[((int) (j4 >> 9)) & 31];
                int i40 = i39 + 1;
                context.pos = i40;
                ensureBufferSize2[i39] = bArr6[((int) (j4 >> 4)) & 31];
                int i41 = i40 + 1;
                context.pos = i41;
                ensureBufferSize2[i40] = bArr6[((int) (j4 << 1)) & 31];
                int i42 = i41 + 1;
                context.pos = i42;
                byte b3 = this.pad;
                ensureBufferSize2[i41] = b3;
                int i43 = i42 + 1;
                context.pos = i43;
                ensureBufferSize2[i42] = b3;
                context.pos = i43 + 1;
                ensureBufferSize2[i43] = b3;
            } else if (i22 == 4) {
                int i44 = i21 + 1;
                context.pos = i44;
                byte[] bArr7 = this.encodeTable;
                long j5 = context.lbitWorkArea;
                ensureBufferSize2[i21] = bArr7[((int) (j5 >> 27)) & 31];
                int i45 = i44 + 1;
                context.pos = i45;
                ensureBufferSize2[i44] = bArr7[((int) (j5 >> 22)) & 31];
                int i46 = i45 + 1;
                context.pos = i46;
                ensureBufferSize2[i45] = bArr7[((int) (j5 >> 17)) & 31];
                int i47 = i46 + 1;
                context.pos = i47;
                ensureBufferSize2[i46] = bArr7[((int) (j5 >> 12)) & 31];
                int i48 = i47 + 1;
                context.pos = i48;
                ensureBufferSize2[i47] = bArr7[((int) (j5 >> 7)) & 31];
                int i49 = i48 + 1;
                context.pos = i49;
                ensureBufferSize2[i48] = bArr7[((int) (j5 >> 2)) & 31];
                int i50 = i49 + 1;
                context.pos = i50;
                ensureBufferSize2[i49] = bArr7[((int) (j5 << 3)) & 31];
                context.pos = i50 + 1;
                ensureBufferSize2[i50] = this.pad;
            } else {
                throw new IllegalStateException("Impossible modulus " + context.modulus);
            }
        }
        int i51 = context.currentLinePos;
        int i52 = context.pos;
        int i53 = i51 + (i52 - i21);
        context.currentLinePos = i53;
        if (this.lineLength <= 0 || i53 <= 0) {
            return;
        }
        byte[] bArr8 = this.lineSeparator;
        System.arraycopy(bArr8, 0, ensureBufferSize2, i52, bArr8.length);
        context.pos += this.lineSeparator.length;
    }

    @Override // org.apache.commons.codec.binary.BaseNCodec
    public boolean isInAlphabet(byte b) {
        if (b >= 0) {
            byte[] bArr = this.decodeTable;
            if (b < bArr.length && bArr[b] != -1) {
                return true;
            }
        }
        return false;
    }

    public Base32(byte b) {
        this(false, b);
    }

    public Base32(boolean z) {
        this(0, null, z, (byte) 61);
    }

    public Base32(boolean z, byte b) {
        this(0, null, z, b);
    }

    public Base32(int i) {
        this(i, CHUNK_SEPARATOR);
    }

    public Base32(int i, byte[] bArr) {
        this(i, bArr, false, (byte) 61);
    }

    public Base32(int i, byte[] bArr, boolean z) {
        this(i, bArr, z, (byte) 61);
    }

    public Base32(int i, byte[] bArr, boolean z, byte b) {
        super(5, 8, i, bArr == null ? 0 : bArr.length, b);
        if (z) {
            this.encodeTable = HEX_ENCODE_TABLE;
            this.decodeTable = HEX_DECODE_TABLE;
        } else {
            this.encodeTable = ENCODE_TABLE;
            this.decodeTable = DECODE_TABLE;
        }
        if (i <= 0) {
            this.encodeSize = 8;
            this.lineSeparator = null;
        } else if (bArr != null) {
            if (!containsAlphabetOrPad(bArr)) {
                this.encodeSize = bArr.length + 8;
                byte[] bArr2 = new byte[bArr.length];
                this.lineSeparator = bArr2;
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            } else {
                String newStringUtf8 = StringUtils.newStringUtf8(bArr);
                throw new IllegalArgumentException("lineSeparator must not contain Base32 characters: [" + newStringUtf8 + jn1.ARRAY_END_STR);
            }
        } else {
            throw new IllegalArgumentException("lineLength " + i + " > 0, but lineSeparator is null");
        }
        this.decodeSize = this.encodeSize - 1;
        if (isInAlphabet(b) || BaseNCodec.isWhiteSpace(b)) {
            throw new IllegalArgumentException("pad must not be in alphabet or whitespace");
        }
    }
}
