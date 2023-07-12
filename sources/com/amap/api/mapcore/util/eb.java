package com.amap.api.mapcore.util;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class eb {
    public int[] a;
    public int b;
    public boolean c;

    public eb() {
        this(true, 16);
    }

    public void a(int i) {
        int[] iArr = this.a;
        int i2 = this.b;
        if (i2 == iArr.length) {
            iArr = d(Math.max(8, (int) (i2 * 1.75f)));
        }
        int i3 = this.b;
        this.b = i3 + 1;
        iArr[i3] = i;
    }

    public int b(int i) {
        int i2 = this.b;
        if (i < i2) {
            int[] iArr = this.a;
            int i3 = iArr[i];
            int i4 = i2 - 1;
            this.b = i4;
            if (this.c) {
                System.arraycopy(iArr, i + 1, iArr, i, i4 - i);
            } else {
                iArr[i] = iArr[i4];
            }
            return i3;
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
    }

    public int[] c(int i) {
        int i2 = this.b + i;
        if (i2 > this.a.length) {
            d(Math.max(8, i2));
        }
        return this.a;
    }

    protected int[] d(int i) {
        int[] iArr = new int[i];
        System.arraycopy(this.a, 0, iArr, 0, Math.min(this.b, i));
        this.a = iArr;
        return iArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof eb) {
            eb ebVar = (eb) obj;
            int i = this.b;
            if (i != ebVar.b) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                if (this.a[i2] != ebVar.a[i2]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return 42;
    }

    public String toString() {
        if (this.b == 0) {
            return "[]";
        }
        int[] iArr = this.a;
        StringBuilder sb = new StringBuilder(32);
        sb.append(jn1.ARRAY_START);
        sb.append(iArr[0]);
        for (int i = 1; i < this.b; i++) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append(iArr[i]);
        }
        sb.append(jn1.ARRAY_END);
        return sb.toString();
    }

    public eb(boolean z, int i) {
        this.c = z;
        this.a = new int[i];
    }

    public void a() {
        this.b = 0;
    }
}
