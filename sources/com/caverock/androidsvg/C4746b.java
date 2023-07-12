package com.caverock.androidsvg;

/* compiled from: Taobao */
/* renamed from: com.caverock.androidsvg.b */
/* loaded from: classes10.dex */
class C4746b {
    private int a;
    private long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4746b(long j, int i) {
        this.b = j;
        this.a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C4746b b(String str, int i, int i2) {
        long j;
        int i3;
        if (i >= i2) {
            return null;
        }
        long j2 = 0;
        int i4 = i;
        while (i4 < i2) {
            char charAt = str.charAt(i4);
            if (charAt < '0' || charAt > '9') {
                if (charAt >= 'A' && charAt <= 'F') {
                    j = j2 * 16;
                    i3 = charAt - 'A';
                } else if (charAt < 'a' || charAt > 'f') {
                    break;
                } else {
                    j = j2 * 16;
                    i3 = charAt - 'a';
                }
                j2 = j + i3 + 10;
            } else {
                j2 = (j2 * 16) + (charAt - '0');
            }
            if (j2 > 4294967295L) {
                return null;
            }
            i4++;
        }
        if (i4 == i) {
            return null;
        }
        return new C4746b(j2, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C4746b c(String str, int i, int i2, boolean z) {
        if (i >= i2) {
            return null;
        }
        if (z) {
            char charAt = str.charAt(i);
            if (charAt != '+') {
                r1 = charAt == '-';
            }
            i++;
        }
        long j = 0;
        int i3 = i;
        while (i3 < i2) {
            char charAt2 = str.charAt(i3);
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            if (r1) {
                j = (j * 10) - (charAt2 - '0');
                if (j < -2147483648L) {
                    return null;
                }
            } else {
                j = (j * 10) + (charAt2 - '0');
                if (j > 2147483647L) {
                    return null;
                }
            }
            i3++;
        }
        if (i3 == i) {
            return null;
        }
        return new C4746b(j, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.a;
    }

    public int d() {
        return (int) this.b;
    }
}
