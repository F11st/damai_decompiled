package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alipay.sdk.m.n.a;
import com.youku.upsplayer.util.YKUpsConvert;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import tb.b90;
import tb.jn1;
import tb.qb1;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public final class SerializeWriter extends Writer {
    public static final char[] DIGITS;
    static final byte[] specicalFlags_doubleQuotes;
    static final byte[] specicalFlags_singleQuotes;
    protected char[] buf;
    protected int count;
    protected int features;
    protected final Writer writer;
    private static final ThreadLocal<char[]> bufLocal = new ThreadLocal<>();
    static final int[] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE};
    static final char[] digits = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    static final char[] DigitTens = {YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '8', '8', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_NINE};
    static final char[] DigitOnes = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE};
    static final char[] ascii_chars = {YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_ZERO, '1', YKUpsConvert.CHAR_ZERO, '2', YKUpsConvert.CHAR_ZERO, '3', YKUpsConvert.CHAR_ZERO, '4', YKUpsConvert.CHAR_ZERO, '5', YKUpsConvert.CHAR_ZERO, '6', YKUpsConvert.CHAR_ZERO, '7', YKUpsConvert.CHAR_ZERO, '8', YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_A, YKUpsConvert.CHAR_ZERO, 'B', YKUpsConvert.CHAR_ZERO, 'C', YKUpsConvert.CHAR_ZERO, qb1.LEVEL_D, YKUpsConvert.CHAR_ZERO, qb1.LEVEL_E, YKUpsConvert.CHAR_ZERO, YKUpsConvert.CHAR_F, '1', YKUpsConvert.CHAR_ZERO, '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', YKUpsConvert.CHAR_NINE, '1', YKUpsConvert.CHAR_A, '1', 'B', '1', 'C', '1', qb1.LEVEL_D, '1', qb1.LEVEL_E, '1', YKUpsConvert.CHAR_F, '2', YKUpsConvert.CHAR_ZERO, '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', YKUpsConvert.CHAR_NINE, '2', YKUpsConvert.CHAR_A, '2', 'B', '2', 'C', '2', qb1.LEVEL_D, '2', qb1.LEVEL_E, '2', YKUpsConvert.CHAR_F};
    static final char[] replaceChars = new char[93];

    static {
        byte[] bArr = new byte[161];
        specicalFlags_doubleQuotes = bArr;
        byte[] bArr2 = new byte[161];
        specicalFlags_singleQuotes = bArr2;
        bArr[0] = 4;
        bArr[1] = 4;
        bArr[2] = 4;
        bArr[3] = 4;
        bArr[4] = 4;
        bArr[5] = 4;
        bArr[6] = 4;
        bArr[7] = 4;
        bArr[8] = 1;
        bArr[9] = 1;
        bArr[10] = 1;
        bArr[11] = 4;
        bArr[12] = 1;
        bArr[13] = 1;
        bArr[34] = 1;
        bArr[92] = 1;
        bArr2[0] = 4;
        bArr2[1] = 4;
        bArr2[2] = 4;
        bArr2[3] = 4;
        bArr2[4] = 4;
        bArr2[5] = 4;
        bArr2[6] = 4;
        bArr2[7] = 4;
        bArr2[8] = 1;
        bArr2[9] = 1;
        bArr2[10] = 1;
        bArr2[11] = 4;
        bArr2[12] = 1;
        bArr2[13] = 1;
        bArr2[92] = 1;
        bArr2[39] = 1;
        for (int i = 14; i <= 31; i++) {
            specicalFlags_doubleQuotes[i] = 4;
            specicalFlags_singleQuotes[i] = 4;
        }
        for (int i2 = 127; i2 < 160; i2++) {
            specicalFlags_doubleQuotes[i2] = 4;
            specicalFlags_singleQuotes[i2] = 4;
        }
        char[] cArr = replaceChars;
        cArr[0] = YKUpsConvert.CHAR_ZERO;
        cArr[1] = '1';
        cArr[2] = '2';
        cArr[3] = '3';
        cArr[4] = '4';
        cArr[5] = '5';
        cArr[6] = '6';
        cArr[7] = '7';
        cArr[8] = 'b';
        cArr[9] = 't';
        cArr[10] = 'n';
        cArr[11] = 'v';
        cArr[12] = 'f';
        cArr[13] = 'r';
        cArr[34] = jn1.QUOTE;
        cArr[39] = '\'';
        cArr[47] = r10.DIR;
        cArr[92] = b90.TokenESC;
        DIGITS = new char[]{YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', qb1.LEVEL_D, qb1.LEVEL_E, YKUpsConvert.CHAR_F};
    }

    public SerializeWriter() {
        this((Writer) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void getChars(long j, int i, char[] cArr) {
        char c;
        if (j < 0) {
            c = '-';
            j = -j;
        } else {
            c = 0;
        }
        while (j > 2147483647L) {
            long j2 = j / 100;
            int i2 = (int) (j - (((j2 << 6) + (j2 << 5)) + (j2 << 2)));
            int i3 = i - 1;
            cArr[i3] = DigitOnes[i2];
            i = i3 - 1;
            cArr[i] = DigitTens[i2];
            j = j2;
        }
        int i4 = (int) j;
        while (i4 >= 65536) {
            int i5 = i4 / 100;
            int i6 = i4 - (((i5 << 6) + (i5 << 5)) + (i5 << 2));
            int i7 = i - 1;
            cArr[i7] = DigitOnes[i6];
            i = i7 - 1;
            cArr[i] = DigitTens[i6];
            i4 = i5;
        }
        while (true) {
            int i8 = (52429 * i4) >>> 19;
            i--;
            cArr[i] = digits[i4 - ((i8 << 3) + (i8 << 1))];
            if (i8 == 0) {
                break;
            }
            i4 = i8;
        }
        if (c != 0) {
            cArr[i - 1] = c;
        }
    }

    private void writeKeyWithDoubleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        if (i > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(34);
                    write(34);
                    write(58);
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    char charAt = str.charAt(i2);
                    byte[] bArr = specicalFlags_doubleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    }
                    i2++;
                }
                if (z) {
                    write(34);
                }
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt2 = str.charAt(i3);
                    byte[] bArr2 = specicalFlags_doubleQuotes;
                    if (charAt2 < bArr2.length && bArr2[charAt2] != 0) {
                        write(92);
                        write(replaceChars[charAt2]);
                    } else {
                        write(charAt2);
                    }
                }
                if (z) {
                    write(34);
                }
                write(58);
                return;
            }
            expandCapacity(i);
        }
        if (length == 0) {
            int i4 = this.count;
            if (i4 + 3 > this.buf.length) {
                expandCapacity(i4 + 3);
            }
            char[] cArr = this.buf;
            int i5 = this.count;
            int i6 = i5 + 1;
            this.count = i6;
            cArr[i5] = jn1.QUOTE;
            int i7 = i6 + 1;
            this.count = i7;
            cArr[i6] = jn1.QUOTE;
            this.count = i7 + 1;
            cArr[i7] = jn1.CONDITION_IF_MIDDLE;
            return;
        }
        int i8 = this.count;
        int i9 = i8 + length;
        str.getChars(0, length, this.buf, i8);
        this.count = i;
        int i10 = i8;
        boolean z2 = false;
        while (i10 < i9) {
            char[] cArr2 = this.buf;
            char c = cArr2[i10];
            byte[] bArr3 = specicalFlags_doubleQuotes;
            if (c < bArr3.length && bArr3[c] != 0) {
                if (!z2) {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i11 = i10 + 1;
                    System.arraycopy(cArr3, i11, cArr3, i10 + 3, (i9 - i10) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, 0, cArr4, 1, i10);
                    char[] cArr5 = this.buf;
                    cArr5[i8] = jn1.QUOTE;
                    cArr5[i11] = b90.TokenESC;
                    int i12 = i11 + 1;
                    cArr5[i12] = replaceChars[c];
                    i9 += 2;
                    cArr5[this.count - 2] = jn1.QUOTE;
                    i10 = i12;
                    z2 = true;
                } else {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr6 = this.buf;
                    int i13 = i10 + 1;
                    System.arraycopy(cArr6, i13, cArr6, i10 + 2, i9 - i10);
                    char[] cArr7 = this.buf;
                    cArr7[i10] = b90.TokenESC;
                    cArr7[i13] = replaceChars[c];
                    i9++;
                    i10 = i13;
                }
            }
            i10++;
        }
        this.buf[this.count - 1] = jn1.CONDITION_IF_MIDDLE;
    }

    private void writeKeyWithSingleQuoteIfHasSpecial(String str) {
        int length = str.length();
        boolean z = true;
        int i = this.count + length + 1;
        if (i > this.buf.length) {
            if (this.writer != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    char charAt = str.charAt(i2);
                    byte[] bArr = specicalFlags_singleQuotes;
                    if (charAt < bArr.length && bArr[charAt] != 0) {
                        break;
                    }
                    i2++;
                }
                if (z) {
                    write(39);
                }
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt2 = str.charAt(i3);
                    byte[] bArr2 = specicalFlags_singleQuotes;
                    if (charAt2 < bArr2.length && bArr2[charAt2] != 0) {
                        write(92);
                        write(replaceChars[charAt2]);
                    } else {
                        write(charAt2);
                    }
                }
                if (z) {
                    write(39);
                }
                write(58);
                return;
            }
            expandCapacity(i);
        }
        if (length == 0) {
            int i4 = this.count;
            if (i4 + 3 > this.buf.length) {
                expandCapacity(i4 + 3);
            }
            char[] cArr = this.buf;
            int i5 = this.count;
            int i6 = i5 + 1;
            this.count = i6;
            cArr[i5] = '\'';
            int i7 = i6 + 1;
            this.count = i7;
            cArr[i6] = '\'';
            this.count = i7 + 1;
            cArr[i7] = jn1.CONDITION_IF_MIDDLE;
            return;
        }
        int i8 = this.count;
        int i9 = i8 + length;
        str.getChars(0, length, this.buf, i8);
        this.count = i;
        int i10 = i8;
        boolean z2 = false;
        while (i10 < i9) {
            char[] cArr2 = this.buf;
            char c = cArr2[i10];
            byte[] bArr3 = specicalFlags_singleQuotes;
            if (c < bArr3.length && bArr3[c] != 0) {
                if (!z2) {
                    i += 3;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr3 = this.buf;
                    int i11 = i10 + 1;
                    System.arraycopy(cArr3, i11, cArr3, i10 + 3, (i9 - i10) - 1);
                    char[] cArr4 = this.buf;
                    System.arraycopy(cArr4, 0, cArr4, 1, i10);
                    char[] cArr5 = this.buf;
                    cArr5[i8] = '\'';
                    cArr5[i11] = b90.TokenESC;
                    int i12 = i11 + 1;
                    cArr5[i12] = replaceChars[c];
                    i9 += 2;
                    cArr5[this.count - 2] = '\'';
                    i10 = i12;
                    z2 = true;
                } else {
                    i++;
                    if (i > cArr2.length) {
                        expandCapacity(i);
                    }
                    this.count = i;
                    char[] cArr6 = this.buf;
                    int i13 = i10 + 1;
                    System.arraycopy(cArr6, i13, cArr6, i10 + 2, i9 - i10);
                    char[] cArr7 = this.buf;
                    cArr7[i10] = b90.TokenESC;
                    cArr7[i13] = replaceChars[c];
                    i9++;
                    i10 = i13;
                }
            }
            i10++;
        }
        this.buf[i - 1] = jn1.CONDITION_IF_MIDDLE;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.writer != null && this.count > 0) {
            flush();
        }
        char[] cArr = this.buf;
        if (cArr.length <= 8192) {
            bufLocal.set(cArr);
        }
        this.buf = null;
    }

    public void config(SerializerFeature serializerFeature, boolean z) {
        if (z) {
            this.features = serializerFeature.mask | this.features;
            return;
        }
        this.features = (~serializerFeature.mask) & this.features;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void expandCapacity(int i) {
        char[] cArr = this.buf;
        int length = ((cArr.length * 3) / 2) + 1;
        if (length >= i) {
            i = length;
        }
        char[] cArr2 = new char[i];
        System.arraycopy(cArr, 0, cArr2, 0, this.count);
        this.buf = cArr2;
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.writer;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.buf, 0, this.count);
            this.writer.flush();
            this.count = 0;
        } catch (IOException e) {
            throw new JSONException(e.getMessage(), e);
        }
    }

    public boolean isEnabled(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.features) != 0;
    }

    public byte[] toBytes(String str) {
        if (this.writer == null) {
            if (str == null) {
                str = "UTF-8";
            }
            try {
                return new String(this.buf, 0, this.count).getBytes(str);
            } catch (UnsupportedEncodingException e) {
                throw new JSONException("toBytes error", e);
            }
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public String toString() {
        return new String(this.buf, 0, this.count);
    }

    @Override // java.io.Writer
    public void write(int i) {
        int i2 = 1;
        int i3 = this.count + 1;
        if (i3 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i3);
            } else {
                flush();
                this.buf[this.count] = (char) i;
                this.count = i2;
            }
        }
        i2 = i3;
        this.buf[this.count] = (char) i;
        this.count = i2;
    }

    public void writeByteArray(byte[] bArr) {
        int length = bArr.length;
        boolean z = (this.features & SerializerFeature.UseSingleQuotes.mask) != 0;
        char c = z ? '\'' : jn1.QUOTE;
        if (length == 0) {
            write(z ? "''" : "\"\"");
            return;
        }
        char[] cArr = JSONLexer.CA;
        int i = (length / 3) * 3;
        int i2 = length - 1;
        int i3 = this.count;
        int i4 = (((i2 / 3) + 1) << 2) + i3 + 2;
        if (i4 > this.buf.length) {
            if (this.writer != null) {
                write(c);
                int i5 = 0;
                while (i5 < i) {
                    int i6 = i5 + 1;
                    int i7 = i6 + 1;
                    int i8 = ((bArr[i5] & 255) << 16) | ((bArr[i6] & 255) << 8) | (bArr[i7] & 255);
                    write(cArr[(i8 >>> 18) & 63]);
                    write(cArr[(i8 >>> 12) & 63]);
                    write(cArr[(i8 >>> 6) & 63]);
                    write(cArr[i8 & 63]);
                    i5 = i7 + 1;
                }
                int i9 = length - i;
                if (i9 > 0) {
                    int i10 = ((bArr[i] & 255) << 10) | (i9 == 2 ? (bArr[i2] & 255) << 2 : 0);
                    write(cArr[i10 >> 12]);
                    write(cArr[(i10 >>> 6) & 63]);
                    write(i9 == 2 ? cArr[i10 & 63] : a.h);
                    write(61);
                }
                write(c);
                return;
            }
            expandCapacity(i4);
        }
        this.count = i4;
        int i11 = i3 + 1;
        this.buf[i3] = c;
        int i12 = 0;
        while (i12 < i) {
            int i13 = i12 + 1;
            int i14 = i13 + 1;
            int i15 = ((bArr[i12] & 255) << 16) | ((bArr[i13] & 255) << 8);
            int i16 = i14 + 1;
            int i17 = i15 | (bArr[i14] & 255);
            char[] cArr2 = this.buf;
            int i18 = i11 + 1;
            cArr2[i11] = cArr[(i17 >>> 18) & 63];
            int i19 = i18 + 1;
            cArr2[i18] = cArr[(i17 >>> 12) & 63];
            int i20 = i19 + 1;
            cArr2[i19] = cArr[(i17 >>> 6) & 63];
            i11 = i20 + 1;
            cArr2[i20] = cArr[i17 & 63];
            i12 = i16;
        }
        int i21 = length - i;
        if (i21 > 0) {
            int i22 = ((bArr[i] & 255) << 10) | (i21 == 2 ? (bArr[i2] & 255) << 2 : 0);
            char[] cArr3 = this.buf;
            cArr3[i4 - 5] = cArr[i22 >> 12];
            cArr3[i4 - 4] = cArr[(i22 >>> 6) & 63];
            cArr3[i4 - 3] = i21 == 2 ? cArr[i22 & 63] : a.h;
            cArr3[i4 - 2] = a.h;
        }
        this.buf[i4 - 1] = c;
    }

    public void writeFieldName(String str, boolean z) {
        int i = this.features;
        if ((SerializerFeature.UseSingleQuotes.mask & i) != 0) {
            if ((SerializerFeature.QuoteFieldNames.mask & i) != 0) {
                writeStringWithSingleQuote(str);
                write(58);
                return;
            }
            writeKeyWithSingleQuoteIfHasSpecial(str);
        } else if ((i & SerializerFeature.QuoteFieldNames.mask) != 0) {
            writeStringWithDoubleQuote(str, jn1.CONDITION_IF_MIDDLE, z);
        } else {
            writeKeyWithDoubleQuoteIfHasSpecial(str);
        }
    }

    public void writeInt(int i) {
        if (i == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int i2 = 0;
        while ((i < 0 ? -i : i) > sizeTable[i2]) {
            i2++;
        }
        int i3 = i2 + 1;
        if (i < 0) {
            i3++;
        }
        int i4 = this.count + i3;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                char[] cArr = new char[i3];
                getChars(i, i3, cArr);
                write(cArr, 0, i3);
                return;
            }
        }
        getChars(i, i4, this.buf);
        this.count = i4;
    }

    public void writeLong(long j) {
        if (j == Long.MIN_VALUE) {
            write("-9223372036854775808");
            return;
        }
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        long j2 = i < 0 ? -j : j;
        int i2 = 1;
        long j3 = 10;
        while (true) {
            if (i2 >= 19) {
                i2 = 0;
                break;
            } else if (j2 < j3) {
                break;
            } else {
                j3 *= 10;
                i2++;
            }
        }
        int i3 = i2 != 0 ? i2 : 19;
        if (i < 0) {
            i3++;
        }
        int i4 = this.count + i3;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                char[] cArr = new char[i3];
                getChars(j, i3, cArr);
                write(cArr, 0, i3);
                return;
            }
        }
        getChars(j, i4, this.buf);
        this.count = i4;
    }

    public void writeNull() {
        write("null");
    }

    public void writeString(String str) {
        if ((this.features & SerializerFeature.UseSingleQuotes.mask) != 0) {
            writeStringWithSingleQuote(str);
        } else {
            writeStringWithDoubleQuote(str, (char) 0, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0092, code lost:
        if (r14 == (-1)) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
        r15 = r3;
        r14 = r12;
        r16 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c0, code lost:
        if ((com.alibaba.fastjson.serializer.SerializerFeature.WriteSlashAsSpecial.mask & r17.features) != 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c8, code lost:
        if (r3 != '\\') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00d1, code lost:
        if (r3 != '\"') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00e4, code lost:
        if (r14 == (-1)) goto L47;
     */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00e7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void writeStringWithDoubleQuote(java.lang.String r18, char r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.SerializeWriter.writeStringWithDoubleQuote(java.lang.String, char, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeStringWithSingleQuote(String str) {
        int i = 0;
        if (str == null) {
            int i2 = this.count + 4;
            if (i2 > this.buf.length) {
                expandCapacity(i2);
            }
            "null".getChars(0, 4, this.buf, this.count);
            this.count = i2;
            return;
        }
        int length = str.length();
        int i3 = this.count + length + 2;
        if (i3 > this.buf.length) {
            if (this.writer != null) {
                write(39);
                while (i < str.length()) {
                    char charAt = str.charAt(i);
                    if (charAt > '\r' && charAt != '\\' && charAt != '\'' && (charAt != '/' || (this.features & SerializerFeature.WriteSlashAsSpecial.mask) == 0)) {
                        write(charAt);
                    } else {
                        write(92);
                        write(replaceChars[charAt]);
                    }
                    i++;
                }
                write(39);
                return;
            }
            expandCapacity(i3);
        }
        int i4 = this.count;
        int i5 = i4 + 1;
        int i6 = i5 + length;
        char[] cArr = this.buf;
        cArr[i4] = '\'';
        str.getChars(0, length, cArr, i5);
        this.count = i3;
        int i7 = -1;
        char c = 0;
        for (int i8 = i5; i8 < i6; i8++) {
            char c2 = this.buf[i8];
            if (c2 <= '\r' || c2 == '\\' || c2 == '\'' || (c2 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                i++;
                i7 = i8;
                c = c2;
            }
        }
        int i9 = i3 + i;
        if (i9 > this.buf.length) {
            expandCapacity(i9);
        }
        this.count = i9;
        if (i == 1) {
            char[] cArr2 = this.buf;
            int i10 = i7 + 1;
            System.arraycopy(cArr2, i10, cArr2, i7 + 2, (i6 - i7) - 1);
            char[] cArr3 = this.buf;
            cArr3[i7] = b90.TokenESC;
            cArr3[i10] = replaceChars[c];
        } else if (i > 1) {
            char[] cArr4 = this.buf;
            int i11 = i7 + 1;
            System.arraycopy(cArr4, i11, cArr4, i7 + 2, (i6 - i7) - 1);
            char[] cArr5 = this.buf;
            cArr5[i7] = b90.TokenESC;
            cArr5[i11] = replaceChars[c];
            int i12 = i6 + 1;
            for (int i13 = i11 - 2; i13 >= i5; i13--) {
                char[] cArr6 = this.buf;
                char c3 = cArr6[i13];
                if (c3 <= '\r' || c3 == '\\' || c3 == '\'' || (c3 == '/' && (this.features & SerializerFeature.WriteSlashAsSpecial.mask) != 0)) {
                    int i14 = i13 + 1;
                    System.arraycopy(cArr6, i14, cArr6, i13 + 2, (i12 - i13) - 1);
                    char[] cArr7 = this.buf;
                    cArr7[i13] = b90.TokenESC;
                    cArr7[i14] = replaceChars[c3];
                    i12++;
                }
            }
        }
        this.buf[this.count - 1] = '\'';
    }

    public void writeTo(Writer writer) throws IOException {
        if (this.writer == null) {
            writer.write(this.buf, 0, this.count);
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public SerializeWriter(Writer writer) {
        this.writer = writer;
        this.features = JSON.DEFAULT_GENERATE_FEATURE;
        ThreadLocal<char[]> threadLocal = bufLocal;
        this.buf = threadLocal.get();
        if (threadLocal != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
    }

    public void writeTo(OutputStream outputStream, String str) throws IOException {
        writeTo(outputStream, Charset.forName(str));
    }

    public void writeTo(OutputStream outputStream, Charset charset) throws IOException {
        if (this.writer == null) {
            outputStream.write(new String(this.buf, 0, this.count).getBytes(charset.name()));
            return;
        }
        throw new UnsupportedOperationException("writer not null");
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        int i3;
        if (i < 0 || i > cArr.length || i2 < 0 || (i3 = i + i2) > cArr.length || i3 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i2 == 0) {
            return;
        }
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                do {
                    char[] cArr2 = this.buf;
                    int length = cArr2.length;
                    int i5 = this.count;
                    int i6 = length - i5;
                    System.arraycopy(cArr, i, cArr2, i5, i6);
                    this.count = this.buf.length;
                    flush();
                    i2 -= i6;
                    i += i6;
                } while (i2 > this.buf.length);
                i4 = i2;
            }
        }
        System.arraycopy(cArr, i, this.buf, this.count, i2);
        this.count = i4;
    }

    public SerializeWriter(SerializerFeature... serializerFeatureArr) {
        this(null, 0, serializerFeatureArr);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(CharSequence charSequence, int i, int i2) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i, i2).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public SerializeWriter(Writer writer, int i, SerializerFeature[] serializerFeatureArr) {
        this.writer = writer;
        ThreadLocal<char[]> threadLocal = bufLocal;
        char[] cArr = threadLocal.get();
        this.buf = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        }
        if (this.buf == null) {
            this.buf = new char[1024];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i |= serializerFeature.mask;
        }
        this.features = i;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public SerializeWriter append(char c) {
        write(c);
        return this;
    }

    public SerializeWriter(int i) {
        this(null, i);
    }

    public SerializeWriter(Writer writer, int i) {
        this.writer = writer;
        if (i > 0) {
            this.buf = new char[i];
            return;
        }
        throw new IllegalArgumentException("Negative initial size: " + i);
    }

    @Override // java.io.Writer
    public void write(String str, int i, int i2) {
        int i3;
        int i4 = this.count + i2;
        if (i4 > this.buf.length) {
            if (this.writer == null) {
                expandCapacity(i4);
            } else {
                while (true) {
                    char[] cArr = this.buf;
                    int length = cArr.length;
                    int i5 = this.count;
                    int i6 = length - i5;
                    i3 = i + i6;
                    str.getChars(i, i3, cArr, i5);
                    this.count = this.buf.length;
                    flush();
                    i2 -= i6;
                    if (i2 <= this.buf.length) {
                        break;
                    }
                    i = i3;
                }
                i4 = i2;
                i = i3;
            }
        }
        str.getChars(i, i2 + i, this.buf, this.count);
        this.count = i4;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            writeNull();
        } else {
            write(str, 0, str.length());
        }
    }

    public void write(boolean z) {
        write(z ? "true" : "false");
    }
}
