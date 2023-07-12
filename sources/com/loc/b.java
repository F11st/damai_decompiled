package com.loc;

import androidx.core.view.MotionEventCompat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import tb.km1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class b {
    private static final byte[] a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, km1.OP_MAX_COUNT, 47};
    private static final byte[] b = {-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, km1.OP_CREATE_JSON, km1.OP_CREATE_ARRAY, km1.OP_INSERT_VALUE, km1.OP_INSERT_KVPAIR, km1.OP_UNARY_MIN, km1.OP_GOTO, km1.OP_TYPEOF, km1.OP_CALL_DX_EVENT, km1.OP_CALL_DX_PARSER, km1.OP_GET_OPT_JUMP, km1.OP_MAX_COUNT, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    static final /* synthetic */ boolean c = true;

    public static String a(byte[] bArr) {
        String str;
        try {
            str = b(bArr, bArr.length);
        } catch (IOException e) {
            if (!c) {
                throw new AssertionError(e.getMessage());
            }
            str = null;
        }
        if (c || str != null) {
            return str;
        }
        throw new AssertionError();
    }

    private static String b(byte[] bArr, int i) throws IOException {
        Objects.requireNonNull(bArr, "Cannot serialize a null array.");
        if (i >= 0) {
            if (i + 0 <= bArr.length) {
                int i2 = ((i / 3) * 4) + (i % 3 <= 0 ? 0 : 4);
                byte[] bArr2 = new byte[i2];
                int i3 = i - 2;
                int i4 = 0;
                int i5 = 0;
                while (i4 < i3) {
                    d(bArr, i4 + 0, 3, bArr2, i5);
                    i4 += 3;
                    i5 += 4;
                }
                if (i4 < i) {
                    d(bArr, i4 + 0, i - i4, bArr2, i5);
                    i5 += 4;
                }
                if (i5 <= i2 - 1) {
                    byte[] bArr3 = new byte[i5];
                    System.arraycopy(bArr2, 0, bArr3, 0, i5);
                    bArr2 = bArr3;
                }
                try {
                    return new String(bArr2, "US-ASCII");
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr2);
                }
            }
            throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", 0, Integer.valueOf(i), Integer.valueOf(bArr.length)));
        }
        throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(i)));
    }

    public static byte[] c(String str) throws IOException {
        return e(str);
    }

    private static byte[] d(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3 = a;
        int i4 = (i2 > 0 ? (bArr[i] << 24) >>> 8 : 0) | (i2 > 1 ? (bArr[i + 1] << 24) >>> 16 : 0) | (i2 > 2 ? (bArr[i + 2] << 24) >>> 24 : 0);
        if (i2 == 1) {
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = 61;
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 == 2) {
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
            bArr2[i3 + 3] = 61;
            return bArr2;
        } else if (i2 != 3) {
            return bArr2;
        } else {
            bArr2[i3] = bArr3[i4 >>> 18];
            bArr2[i3 + 1] = bArr3[(i4 >>> 12) & 63];
            bArr2[i3 + 2] = bArr3[(i4 >>> 6) & 63];
            bArr2[i3 + 3] = bArr3[i4 & 63];
            return bArr2;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x0052 -> B:57:0x0052). Please submit an issue!!! */
    private static byte[] e(String str) throws IOException {
        byte[] bytes;
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        Objects.requireNonNull(str, "Input string was null.");
        try {
            bytes = str.getBytes("US-ASCII");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        byte[] f = f(bytes, bytes.length);
        if (f.length >= 4 && 35615 == ((f[0] & 255) | ((f[1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK))) {
            byte[] bArr = new byte[2048];
            ByteArrayOutputStream byteArrayOutputStream = null;
            try {
                try {
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    try {
                        byteArrayInputStream = new ByteArrayInputStream(f);
                        try {
                            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                            while (true) {
                                try {
                                    int read = gZIPInputStream.read(bArr);
                                    if (read < 0) {
                                        break;
                                    }
                                    byteArrayOutputStream2.write(bArr, 0, read);
                                } catch (IOException e) {
                                    e = e;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    try {
                                        e.printStackTrace();
                                        byteArrayOutputStream.close();
                                        gZIPInputStream.close();
                                        byteArrayInputStream.close();
                                        return f;
                                    } catch (Throwable th) {
                                        th = th;
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Exception unused2) {
                                        }
                                        try {
                                            gZIPInputStream.close();
                                        } catch (Exception unused3) {
                                        }
                                        try {
                                            byteArrayInputStream.close();
                                        } catch (Exception unused4) {
                                        }
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    byteArrayOutputStream = byteArrayOutputStream2;
                                    byteArrayOutputStream.close();
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    throw th;
                                }
                            }
                            f = byteArrayOutputStream2.toByteArray();
                            byteArrayOutputStream2.close();
                        } catch (IOException e2) {
                            e = e2;
                            gZIPInputStream = null;
                        } catch (Throwable th3) {
                            th = th3;
                            gZIPInputStream = null;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    } catch (Throwable th4) {
                        th = th4;
                        byteArrayInputStream = null;
                        gZIPInputStream = null;
                    }
                } catch (IOException e4) {
                    e = e4;
                    byteArrayInputStream = null;
                    gZIPInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayInputStream = null;
                    gZIPInputStream = null;
                }
            } catch (Exception unused5) {
            }
            try {
                gZIPInputStream.close();
            } catch (Exception unused6) {
            }
            try {
                byteArrayInputStream.close();
            } catch (Exception unused7) {
            }
        }
        return f;
    }

    private static byte[] f(byte[] bArr, int i) throws IOException {
        int i2;
        Objects.requireNonNull(bArr, "Cannot decode null source array.");
        int i3 = i + 0;
        int i4 = 1;
        if (i3 <= bArr.length) {
            if (i == 0) {
                return new byte[0];
            }
            if (i >= 4) {
                byte[] bArr2 = b;
                int i5 = (i * 3) / 4;
                byte[] bArr3 = new byte[i5];
                byte[] bArr4 = new byte[4];
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (i6 < i3) {
                    byte b2 = bArr2[bArr[i6] & 255];
                    if (b2 < -5) {
                        throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", Integer.valueOf(bArr[i6] & 255), Integer.valueOf(i6)));
                    }
                    if (b2 >= -1) {
                        int i9 = i7 + 1;
                        bArr4[i7] = bArr[i6];
                        if (i9 <= 3) {
                            i7 = i9;
                        } else if (i8 < 0 || (i2 = i8 + 2) >= i5) {
                            throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", Integer.valueOf(i5), Integer.valueOf(i8)));
                        } else {
                            byte[] bArr5 = b;
                            if (bArr4[2] == 61) {
                                bArr3[i8] = (byte) ((((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[i4]] & 255) << 12)) >>> 16);
                            } else if (bArr4[3] == 61) {
                                int i10 = ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[i4]] & 255) << 12) | ((bArr5[bArr4[2]] & 255) << 6);
                                bArr3[i8] = (byte) (i10 >>> 16);
                                bArr3[i8 + 1] = (byte) (i10 >>> 8);
                                i4 = 2;
                            } else {
                                int i11 = ((bArr5[bArr4[i4]] & 255) << 12) | ((bArr5[bArr4[0]] & 255) << 18) | ((bArr5[bArr4[2]] & 255) << 6) | (bArr5[bArr4[3]] & 255);
                                bArr3[i8] = (byte) (i11 >> 16);
                                bArr3[i8 + 1] = (byte) (i11 >> 8);
                                bArr3[i2] = (byte) i11;
                                i4 = 3;
                            }
                            i8 += i4;
                            if (bArr[i6] == 61) {
                                break;
                            }
                            i7 = 0;
                        }
                    }
                    i6++;
                    i4 = 1;
                }
                byte[] bArr6 = new byte[i8];
                System.arraycopy(bArr3, 0, bArr6, 0, i8);
                return bArr6;
            }
            throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(i)));
        }
        throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", Integer.valueOf(bArr.length), 0, Integer.valueOf(i)));
    }
}
