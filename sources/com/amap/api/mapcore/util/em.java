package com.amap.api.mapcore.util;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class em {
    public short[] a;
    public int b;
    public boolean c;

    public em() {
        this(true, 16);
    }

    public void a(short s) {
        short[] sArr = this.a;
        int i = this.b;
        if (i == sArr.length) {
            sArr = d(Math.max(8, (int) (i * 1.75f)));
        }
        int i2 = this.b;
        this.b = i2 + 1;
        sArr[i2] = s;
    }

    public short b(int i) {
        int i2 = this.b;
        if (i < i2) {
            short[] sArr = this.a;
            short s = sArr[i];
            int i3 = i2 - 1;
            this.b = i3;
            if (this.c) {
                System.arraycopy(sArr, i + 1, sArr, i, i3 - i);
            } else {
                sArr[i] = sArr[i3];
            }
            return s;
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
    }

    public short[] c(int i) {
        int i2 = this.b + i;
        if (i2 > this.a.length) {
            d(Math.max(8, i2));
        }
        return this.a;
    }

    protected short[] d(int i) {
        short[] sArr = new short[i];
        System.arraycopy(this.a, 0, sArr, 0, Math.min(this.b, i));
        this.a = sArr;
        return sArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof em) {
            em emVar = (em) obj;
            int i = this.b;
            if (i != emVar.b) {
                return false;
            }
            for (int i2 = 0; i2 < i; i2++) {
                if (this.a[i2] != emVar.a[i2]) {
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
        short[] sArr = this.a;
        StringBuilder sb = new StringBuilder(32);
        sb.append(jn1.ARRAY_START);
        sb.append((int) sArr[0]);
        for (int i = 1; i < this.b; i++) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append((int) sArr[i]);
        }
        sb.append(jn1.ARRAY_END);
        return sb.toString();
    }

    public em(boolean z, int i) {
        this.c = z;
        this.a = new short[i];
    }

    public short a(int i) {
        if (i < this.b) {
            return this.a[i];
        }
        throw new IndexOutOfBoundsException("index can't be >= size: " + i + " >= " + this.b);
    }

    public void a() {
        this.b = 0;
    }
}
