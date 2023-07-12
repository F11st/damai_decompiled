package tb;

import java.lang.reflect.Array;
import me.ele.altriax.launcher.common.AltriaXLaunchTime;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ne {
    private final byte[][] a;
    private final int b;
    private final int c;

    public ne(int i, int i2) {
        this.a = (byte[][]) Array.newInstance(byte.class, i2, i);
        this.b = i;
        this.c = i2;
    }

    public void a(byte b) {
        for (int i = 0; i < this.c; i++) {
            for (int i2 = 0; i2 < this.b; i2++) {
                this.a[i][i2] = b;
            }
        }
    }

    public byte b(int i, int i2) {
        return this.a[i2][i];
    }

    public byte[][] c() {
        return this.a;
    }

    public int d() {
        return this.c;
    }

    public int e() {
        return this.b;
    }

    public void f(int i, int i2, int i3) {
        this.a[i2][i] = (byte) i3;
    }

    public void g(int i, int i2, boolean z) {
        this.a[i2][i] = z ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer((this.b * 2 * this.c) + 2);
        for (int i = 0; i < this.c; i++) {
            for (int i2 = 0; i2 < this.b; i2++) {
                byte b = this.a[i][i2];
                if (b == 0) {
                    stringBuffer.append(" 0");
                } else if (b != 1) {
                    stringBuffer.append(AltriaXLaunchTime.SPACE);
                } else {
                    stringBuffer.append(" 1");
                }
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }
}
