package tb;

import java.util.Vector;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class rz1 {
    private final wp0 a;
    private final Vector b;

    public rz1(wp0 wp0Var) {
        if (wp0.QR_CODE_FIELD.equals(wp0Var)) {
            this.a = wp0Var;
            Vector vector = new Vector();
            this.b = vector;
            vector.addElement(new xp0(wp0Var, new int[]{1}));
            return;
        }
        throw new IllegalArgumentException("Only QR Code is supported at this time");
    }

    private xp0 a(int i) {
        if (i >= this.b.size()) {
            Vector vector = this.b;
            xp0 xp0Var = (xp0) vector.elementAt(vector.size() - 1);
            for (int size = this.b.size(); size <= i; size++) {
                wp0 wp0Var = this.a;
                xp0Var = xp0Var.g(new xp0(wp0Var, new int[]{1, wp0Var.c(size - 1)}));
                this.b.addElement(xp0Var);
            }
        }
        return (xp0) this.b.elementAt(i);
    }

    public void b(int[] iArr, int i) {
        if (i != 0) {
            int length = iArr.length - i;
            if (length > 0) {
                xp0 a = a(i);
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                int[] d = new xp0(this.a, iArr2).h(i, 1).b(a)[1].d();
                int length2 = i - d.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    iArr[length + i2] = 0;
                }
                System.arraycopy(d, 0, iArr, length + length2, d.length);
                return;
            }
            throw new IllegalArgumentException("No data bytes provided");
        }
        throw new IllegalArgumentException("No error correction bytes");
    }
}
