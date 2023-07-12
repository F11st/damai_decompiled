package tb;

import com.taobao.pexode.Pexode;
import java.io.ByteArrayOutputStream;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class he0 {
    public static final int FIXED_JPG_LENGTH;
    private static final byte[] a;
    private static final byte[] b;

    static {
        byte[] bArr = {-1, -40, -1, -37, 0, 67, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -64, 0, 17, 8};
        a = bArr;
        byte[] bArr2 = {3, 1, km1.OP_CREATE_ARRAY, 0, 2, 17, 0, 3, 17, 0, -1, -60, 0, 31, 0, 0, 1, 5, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 16, 0, 2, 1, 3, 3, 2, 4, 3, 5, 5, 4, 4, 0, 0, 1, 125, 1, 2, 3, 0, 4, 17, 5, 18, km1.OP_CREATE_JSON, 49, 65, 6, 19, 81, 97, 7, km1.OP_CREATE_ARRAY, 113, 20, 50, -127, -111, -95, 8, km1.OP_INSERT_VALUE, 66, -79, -63, 21, 82, -47, -16, km1.OP_INSERT_KVPAIR, 51, 98, 114, -126, 9, 10, 22, 23, 24, 25, 26, km1.OP_UNARY_MIN, km1.OP_GOTO, km1.OP_TYPEOF, km1.OP_CALL_DX_EVENT, km1.OP_CALL_DX_PARSER, km1.OP_GET_OPT_JUMP, 52, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -31, -30, -29, -28, -27, -26, -25, -24, -23, -22, -15, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -60, 0, 31, 1, 0, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, -1, -60, 0, -75, 17, 0, 2, 1, 2, 4, 4, 3, 4, 7, 5, 4, 4, 0, 1, 2, 119, 0, 1, 2, 3, 17, 4, 5, km1.OP_CREATE_JSON, 49, 6, 18, 65, 81, 7, 97, 113, 19, km1.OP_CREATE_ARRAY, 50, -127, 8, 20, 66, -111, -95, -79, -63, 9, km1.OP_INSERT_VALUE, 51, 82, -16, 21, 98, 114, -47, 10, 22, km1.OP_INSERT_KVPAIR, 52, -31, km1.OP_UNARY_MIN, -15, 23, 24, 25, 26, km1.OP_GOTO, km1.OP_TYPEOF, km1.OP_CALL_DX_EVENT, km1.OP_CALL_DX_PARSER, km1.OP_GET_OPT_JUMP, 53, 54, 55, 56, 57, 58, 67, 68, 69, 70, 71, 72, 73, 74, 83, 84, 85, 86, 87, 88, 89, 90, 99, 100, 101, 102, 103, 104, 105, 106, 115, 116, 117, 118, 119, 120, 121, 122, -126, -125, -124, -123, -122, -121, -120, -119, -118, -110, -109, -108, -107, -106, -105, -104, -103, -102, -94, -93, -92, -91, -90, -89, -88, -87, -86, -78, -77, -76, -75, -74, -73, -72, -71, -70, -62, -61, -60, -59, -58, -57, -56, -55, -54, -46, -45, -44, -43, -42, -41, -40, -39, -38, -30, -29, -28, -27, -26, -25, -24, -23, -22, -14, -13, -12, -11, -10, -9, -8, -7, -6, -1, -38, 0, 12, 3, 1, 0, 2, 17, 3, 17, 0, 63, 0, -114, -118, km1.OP_CALL_DX_EVENT, -96, 15, -1, -39};
        b = bArr2;
        FIXED_JPG_LENGTH = bArr.length + bArr2.length + 4;
    }

    public static byte[] a(int i, int i2, byte[] bArr) {
        if (bArr != null) {
            try {
                if (bArr.length >= FIXED_JPG_LENGTH) {
                    byte[] bArr2 = a;
                    System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
                    bArr[bArr2.length] = (byte) (i2 >> 8);
                    bArr[bArr2.length + 1] = (byte) (i2 & 255);
                    bArr[bArr2.length + 2] = (byte) (i >> 8);
                    bArr[bArr2.length + 3] = (byte) (i & 255);
                    byte[] bArr3 = b;
                    System.arraycopy(bArr3, 0, bArr, bArr2.length + 4, bArr3.length);
                    return bArr;
                }
            } catch (Exception e) {
                hh0.c(Pexode.TAG, "generate fixed size jpg bytes failed, error=%s", e);
                return null;
            }
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(FIXED_JPG_LENGTH);
        byteArrayOutputStream.write(a);
        byteArrayOutputStream.write((byte) (i2 >> 8));
        byteArrayOutputStream.write((byte) (i2 & 255));
        byteArrayOutputStream.write((byte) (i >> 8));
        byteArrayOutputStream.write((byte) (i & 255));
        byteArrayOutputStream.write(b);
        return byteArrayOutputStream.toByteArray();
    }
}
