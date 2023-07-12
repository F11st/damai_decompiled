package tb;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class jd1 {
    public static int a(ne neVar) {
        return b(neVar, true) + b(neVar, false);
    }

    private static int b(ne neVar, boolean z) {
        int d = z ? neVar.d() : neVar.e();
        int e = z ? neVar.e() : neVar.d();
        byte[][] c = neVar.c();
        byte b = -1;
        int i = 0;
        for (int i2 = 0; i2 < d; i2++) {
            int i3 = 0;
            for (int i4 = 0; i4 < e; i4++) {
                byte b2 = z ? c[i2][i4] : c[i4][i2];
                if (b2 == b) {
                    i3++;
                    if (i3 == 5) {
                        i += 3;
                    } else if (i3 > 5) {
                        i++;
                    }
                } else {
                    b = b2;
                    i3 = 1;
                }
            }
        }
        return i;
    }

    public static int c(ne neVar) {
        byte[][] c = neVar.c();
        int e = neVar.e();
        int d = neVar.d();
        int i = 0;
        for (int i2 = 0; i2 < d - 1; i2++) {
            int i3 = 0;
            while (i3 < e - 1) {
                byte b = c[i2][i3];
                int i4 = i3 + 1;
                if (b == c[i2][i4]) {
                    int i5 = i2 + 1;
                    if (b == c[i5][i3] && b == c[i5][i4]) {
                        i += 3;
                    }
                }
                i3 = i4;
            }
        }
        return i;
    }

    public static int d(ne neVar) {
        int i;
        int i2;
        int i3;
        int i4;
        byte[][] c = neVar.c();
        int e = neVar.e();
        int d = neVar.d();
        int i5 = 0;
        for (int i6 = 0; i6 < d; i6++) {
            for (int i7 = 0; i7 < e; i7++) {
                int i8 = i7 + 6;
                if (i8 < e && c[i6][i7] == 1 && c[i6][i7 + 1] == 0 && c[i6][i7 + 2] == 1 && c[i6][i7 + 3] == 1 && c[i6][i7 + 4] == 1 && c[i6][i7 + 5] == 0 && c[i6][i8] == 1 && (((i3 = i7 + 10) < e && c[i6][i7 + 7] == 0 && c[i6][i7 + 8] == 0 && c[i6][i7 + 9] == 0 && c[i6][i3] == 0) || (i7 - 4 >= 0 && c[i6][i7 - 1] == 0 && c[i6][i7 - 2] == 0 && c[i6][i7 - 3] == 0 && c[i6][i4] == 0))) {
                    i5 += 40;
                }
                int i9 = i6 + 6;
                if (i9 < d && c[i6][i7] == 1 && c[i6 + 1][i7] == 0 && c[i6 + 2][i7] == 1 && c[i6 + 3][i7] == 1 && c[i6 + 4][i7] == 1 && c[i6 + 5][i7] == 0 && c[i9][i7] == 1 && (((i = i6 + 10) < d && c[i6 + 7][i7] == 0 && c[i6 + 8][i7] == 0 && c[i6 + 9][i7] == 0 && c[i][i7] == 0) || (i6 - 4 >= 0 && c[i6 - 1][i7] == 0 && c[i6 - 2][i7] == 0 && c[i6 - 3][i7] == 0 && c[i2][i7] == 0))) {
                    i5 += 40;
                }
            }
        }
        return i5;
    }

    public static int e(ne neVar) {
        byte[][] c = neVar.c();
        int e = neVar.e();
        int d = neVar.d();
        int i = 0;
        for (int i2 = 0; i2 < d; i2++) {
            for (int i3 = 0; i3 < e; i3++) {
                if (c[i2][i3] == 1) {
                    i++;
                }
            }
        }
        return (Math.abs((int) (((i / (neVar.d() * neVar.e())) * 100.0d) - 50.0d)) / 5) * 10;
    }

    public static boolean f(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        if (dy1.j(i)) {
            switch (i) {
                case 0:
                    i3 += i2;
                case 1:
                    i4 = i3 & 1;
                    break;
                case 2:
                    i4 = i2 % 3;
                    break;
                case 3:
                    i4 = (i3 + i2) % 3;
                    break;
                case 4:
                    i5 = i3 >>> 1;
                    i6 = i2 / 3;
                    i7 = i5 + i6;
                    i4 = i7 & 1;
                    break;
                case 5:
                    int i8 = i3 * i2;
                    i4 = (i8 & 1) + (i8 % 3);
                    break;
                case 6:
                    int i9 = i3 * i2;
                    i7 = (i9 & 1) + (i9 % 3);
                    i4 = i7 & 1;
                    break;
                case 7:
                    i5 = (i3 * i2) % 3;
                    i6 = (i3 + i2) & 1;
                    i7 = i5 + i6;
                    i4 = i7 & 1;
                    break;
                default:
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Invalid mask pattern: ");
                    stringBuffer.append(i);
                    throw new IllegalArgumentException(stringBuffer.toString());
            }
            return i4 == 0;
        }
        throw new IllegalArgumentException("Invalid mask pattern");
    }
}
