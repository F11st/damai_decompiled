package tb;

import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class nc {
    public final int a;
    public final int b;
    public final int c;
    public final int[] d;

    public nc(int i, int i2) {
        if (i >= 1 && i2 >= 1) {
            this.a = i;
            this.b = i2;
            int i3 = (i + 31) >> 5;
            this.c = i3;
            this.d = new int[i3 * i2];
            return;
        }
        throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }

    public boolean a(int i, int i2) {
        return ((this.d[(i2 * this.c) + (i >> 5)] >>> (i & 31)) & 1) != 0;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public void d(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 >= 1 && i3 >= 1) {
            int i5 = i3 + i;
            int i6 = i4 + i2;
            if (i6 > this.b || i5 > this.a) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i2 < i6) {
                int i7 = this.c * i2;
                for (int i8 = i; i8 < i5; i8++) {
                    int[] iArr = this.d;
                    int i9 = (i8 >> 5) + i7;
                    iArr[i9] = iArr[i9] | (1 << (i8 & 31));
                }
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Height and width must be at least 1");
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof nc)) {
            return false;
        }
        nc ncVar = (nc) obj;
        if (this.a != ncVar.a || this.b != ncVar.b || this.c != ncVar.c || this.d.length != ncVar.d.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int[] iArr = this.d;
            if (i >= iArr.length) {
                return true;
            }
            if (iArr[i] != ncVar.d[i]) {
                return false;
            }
            i++;
        }
    }

    public int hashCode() {
        int i = this.a;
        int i2 = (((((i * 31) + i) * 31) + this.b) * 31) + this.c;
        int i3 = 0;
        while (true) {
            int[] iArr = this.d;
            if (i3 >= iArr.length) {
                return i2;
            }
            i2 = (i2 * 31) + iArr[i3];
            i3++;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.b * (this.a + 1));
        for (int i = 0; i < this.b; i++) {
            for (int i2 = 0; i2 < this.a; i2++) {
                stringBuffer.append(a(i2, i) ? "X " : AltriaXLaunchTime.SPACE);
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }
}
