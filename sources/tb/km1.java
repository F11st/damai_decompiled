package tb;

import android.taobao.windvane.connect.HttpRequest;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class km1 {
    public static final byte INVALID = 0;
    public static final byte OP_BIN_ADD = 9;
    public static final byte OP_BIN_DIV = 12;
    public static final byte OP_BIN_MOD = 13;
    public static final byte OP_BIN_MUL = 11;
    public static final byte OP_BIN_SUB = 10;
    public static final byte OP_BOOL_AND = 21;
    public static final byte OP_BOOL_EQUAL = 19;
    public static final byte OP_BOOL_LARGER = 17;
    public static final byte OP_BOOL_LARGER_OR_EQUAL = 20;
    public static final byte OP_BOOL_NOT = 23;
    public static final byte OP_BOOL_NOT_EQUAL = 18;
    public static final byte OP_BOOL_OR = 22;
    public static final byte OP_CALL_DX_EVENT = 40;
    public static final byte OP_CALL_DX_PARSER = 41;
    public static final byte OP_CALL_JS_METHOD = 6;
    public static final byte OP_CALL_METHOD = 5;
    public static final byte OP_COPY_VAR = 4;
    public static final byte OP_CREATE_ARRAY = 34;
    public static final byte OP_CREATE_JSON = 33;
    public static final byte OP_GET_BY_DOT = 8;
    public static final byte OP_GET_BY_INDEX = 7;
    public static final byte OP_GET_CONST = 2;
    public static final byte OP_GET_OPT_JUMP = 42;
    public static final byte OP_GET_VAR = 1;
    public static final byte OP_GOTO = 38;
    public static final byte OP_GOTO_IF_FALSE = 14;
    public static final byte OP_GOTO_IF_TRUE = 15;
    public static final byte OP_IN = 16;
    public static final byte OP_INSERT_KVPAIR = 36;
    public static final byte OP_INSERT_VALUE = 35;
    public static final byte OP_MAX_COUNT = 43;
    public static final byte OP_POP_VAR = 3;
    public static final byte OP_PUSH_DOUBLE_64 = 30;
    public static final byte OP_PUSH_FALSE = 25;
    public static final byte OP_PUSH_INT_16 = 27;
    public static final byte OP_PUSH_INT_32 = 28;
    public static final byte OP_PUSH_INT_64 = 29;
    public static final byte OP_PUSH_INT_8 = 26;
    public static final byte OP_PUSH_NULL = 31;
    public static final byte OP_PUSH_TRUE = 24;
    public static final byte OP_PUSH_UNDEFINED = 32;
    public static final byte OP_TYPEOF = 39;
    public static final byte OP_UNARY_MIN = 37;
    private static final String[] a;
    private static final int[] b;
    private static final int[] c;
    private static final int[] d;
    private static final int[][] e;

    static {
        String[] strArr = {HttpRequest.DEFAULT_HTTPS_ERROR_INVALID, "OP_GET_VAR", "OP_GET_CONST", "OP_POP_VAR", "OP_COPY_VAR", "OP_CALL_METHOD", "OP_CALL_JS_METHOD", "OP_GET_BY_INDEX", "OP_GET_BY_DOT", "OP_BIN_ADD", "OP_BIN_SUB", "OP_BIN_MUL", "OP_BIN_DIV", "OP_BIN_MOD", "OP_GOTO_IF_FALSE", "OP_GOTO_IF_TRUE", "OP_IN", "OP_BOOL_LARGER", "OP_BOOL_NOT_EQUAL", "OP_BOOL_EQUAL", "OP_BOOL_LARGER_OR_EQUAL", "OP_BOOL_AND", "OP_BOOL_OR", "OP_BOOL_NOT", "OP_PUSH_TRUE", "OP_PUSH_FALSE", "OP_PUSH_INT_8", "OP_PUSH_INT_16", "OP_PUSH_INT_32", "OP_PUSH_INT_64", "OP_PUSH_DOUBLE_64", "OP_PUSH_NULL", "OP_PUSH_UNDEFINED", "OP_CREATE_JSON", "OP_CREATE_ARRAY", "OP_INSERT_VALUE", "OP_INSERT_KVPAIR", "OP_UNARY_MIN", "OP_GOTO", "OP_TYPEOF", "OP_CALL_DX_EVENT", "OP_CALL_DX_PARSER", "OP_GET_OPT_JUMP"};
        a = strArr;
        int[] iArr = {0, 2, 2, 0, 0, 1, 5, 0, 2, 0, 0, 0, 0, 0, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 4, 8, 8, 0, 0, 0, 0, 0, 0, 0, 3, 0, 1, 1, 3};
        b = iArr;
        int[] iArr2 = {0, 1, 1, -1, 1, 0, 0, -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -2, -2, 0, 0, 0, 0, 0, 0};
        c = iArr2;
        int[] iArr3 = {0, 1, 1, 0, 0, 1, 3, 0, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1};
        d = iArr3;
        int[][] iArr4 = {new int[0], new int[]{2}, new int[]{2}, new int[0], new int[0], new int[]{1}, new int[]{1, 2, 2}, new int[0], new int[]{2}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{3}, new int[]{3}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{1}, new int[]{2}, new int[]{4}, new int[]{8}, new int[]{8}, new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[0], new int[]{3}, new int[0], new int[]{1}, new int[]{1}, new int[]{3}};
        e = iArr4;
        if (iArr4.length == 43) {
            if (iArr3.length == 43) {
                if (iArr2.length == 43) {
                    if (iArr.length == 43) {
                        if (strArr.length != 43) {
                            throw new IllegalStateException();
                        }
                        for (int i = 0; i < 43; i++) {
                            int i2 = b[i];
                            int i3 = d[i];
                            int[] iArr5 = e[i];
                            if (iArr5.length != i3) {
                                throw new IllegalStateException();
                            }
                            int i4 = 0;
                            for (int i5 = 0; i5 < i3; i5++) {
                                i4 += iArr5[i5];
                            }
                            if (i4 != i2) {
                                throw new IllegalStateException("" + i);
                            }
                        }
                        return;
                    }
                    throw new IllegalStateException();
                }
                throw new IllegalStateException();
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    public static int a(byte[] bArr, int i) {
        if (i < bArr.length) {
            int i2 = bArr[i] & 255;
            if (i2 < 43) {
                return i2;
            }
            throw new IllegalArgumentException(String.format("Code %02x not a op", Byte.valueOf(bArr[i])));
        }
        throw new IllegalArgumentException("getOpSize pos Overflow");
    }

    public static String b(int i) {
        return a[i];
    }

    public static int c(int i) {
        return b[i];
    }
}
